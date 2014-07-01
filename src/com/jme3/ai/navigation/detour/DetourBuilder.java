package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.crowd.dtCrowd;
import com.jme3.ai.navigation.crowd.dtObstacleAvoidanceDebugData;
import com.jme3.ai.navigation.crowd.dtObstacleAvoidanceQuery;
import com.jme3.ai.navigation.crowd.dtProximityGrid;
import com.jme3.ai.navigation.tilecache.TileCache;
import com.jme3.ai.navigation.tilecache.TileCacheAlloc;
import com.jme3.ai.navigation.tilecache.TileCacheCompressor;
import com.jme3.ai.navigation.tilecache.TileCacheContourSet;
import com.jme3.ai.navigation.tilecache.TileCacheLayer;
import com.jme3.ai.navigation.tilecache.TileCacheLayerHeader;
import com.jme3.ai.navigation.tilecache.TileCachePolyMesh;
import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.FloatArray;
import com.jme3.ai.navigation.utils.IntArray;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_dtTileCacheLayer;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;
import com.jme3.ai.navigation.utils.UCharArray;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class DetourBuilder {

    /**
     * Derives the signed xz-plane area of the triangle ABC, or the relationship
     * of line AB to point C. The vertices are projected onto the xz-plane, so
     * the y-values are ignored.
     *
     * This is a low cost function than can be used for various purposes. Its
     * main purpose is for point/line relationship testing.
     *
     * In all cases: A value of zero indicates that all vertices are collinear
     * or represent the same point. (On the xz-plane.)
     *
     * When used for point/line relationship tests, AB usually represents a line
     * against which the C point is to be tested. In this case:
     *
     * A positive value indicates that point C is to the left of line AB,
     * looking from A toward B. A negative value indicates that point C is to
     * the right of lineAB, looking from A toward B.
     *
     * When used for evaluating a triangle:
     *
     * The absolute value of the return value is two times the area of the
     * triangle when it is projected onto the xz-plane.
     *
     * A positive return value indicates:
     *
     * The vertices are wrapped in the normal DetourBuilder wrap direction. The
     * triangle's 3D face normal is in the general up direction. A negative
     * return value indicates:
     *
     * The vertices are reverse wrapped. (Wrapped opposite the normal
     * DetourBuilder wrap direction.) The triangle's 3D face normal is in the
     * general down direction.
     *
     * @param a Vertex A.
     * @param b Vertex B.
     * @param c Vertex C.
     * @return The signed xz-plane area of the triangle.
     */
    public static float dtTriArea2D(Vector3f a, Vector3f b, Vector3f c) {
        SWIGTYPE_p_float aa = Converter.convertToSWIGTYPE_p_float(a);
        SWIGTYPE_p_float bb = Converter.convertToSWIGTYPE_p_float(b);
        SWIGTYPE_p_float cc = Converter.convertToSWIGTYPE_p_float(c);
        return RecastJNI.dtTriArea2D(SWIGTYPE_p_float.getCPtr(aa), SWIGTYPE_p_float.getCPtr(bb), SWIGTYPE_p_float.getCPtr(cc));
    }

    /**
     * Determines if two axis-aligned bounding boxes overlap.
     *
     * @see DetourBuilder#areBoundsOverlaping(com.jme3.math.Vector3f,
     * com.jme3.math.Vector3f, com.jme3.math.Vector3f, com.jme3.math.Vector3f)
     *
     * @param aMinBounds Minimum bounds of box A.
     * @param aMaxBounds Maximum bounds of box A
     * @param bMinBounds Minimum bounds of box B.
     * @param bMaxBounds Maximum bounds of box B.
     * @return True if the two AABB's overlap.
     */
    public static boolean areQuantBoundsOverlaping(Vector3f aMinBounds, Vector3f aMaxBounds, Vector3f bMinBounds, Vector3f bMaxBounds) {
        SWIGTYPE_p_unsigned_short amin = Converter.convertToSWIGTYPE_p_unsigned_short(aMinBounds);
        SWIGTYPE_p_unsigned_short amax = Converter.convertToSWIGTYPE_p_unsigned_short(aMaxBounds);
        SWIGTYPE_p_unsigned_short bmin = Converter.convertToSWIGTYPE_p_unsigned_short(bMinBounds);
        SWIGTYPE_p_unsigned_short bmax = Converter.convertToSWIGTYPE_p_unsigned_short(bMaxBounds);
        return RecastJNI.dtOverlapQuantBounds(SWIGTYPE_p_unsigned_short.getCPtr(amin), SWIGTYPE_p_unsigned_short.getCPtr(amax), SWIGTYPE_p_unsigned_short.getCPtr(bmin), SWIGTYPE_p_unsigned_short.getCPtr(bmax));
    }

    /**
     * Determines if two axis-aligned bounding boxes overlap.
     *
     * @see DetourBuilder#areQuantBoundsOverlaping(com.jme3.math.Vector3f,
     * com.jme3.math.Vector3f, com.jme3.math.Vector3f, com.jme3.math.Vector3f)
     *
     * @param aMinBounds Minimum bounds of box A.
     * @param aMaxBounds Maximum bounds of box A
     * @param bMinBounds Minimum bounds of box B.
     * @param bMaxBounds Maximum bounds of box B.
     * @return True if the two AABB's overlap.
     */
    public static boolean areBoundsOverlaping(Vector3f aMinBounds, Vector3f aMaxBounds, Vector3f bMinBounds, Vector3f bMaxBounds) {
        SWIGTYPE_p_float amin = Converter.convertToSWIGTYPE_p_float(aMinBounds);
        SWIGTYPE_p_float amax = Converter.convertToSWIGTYPE_p_float(aMaxBounds);
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(bMinBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(bMaxBounds);
        return RecastJNI.dtOverlapBounds(SWIGTYPE_p_float.getCPtr(amin), SWIGTYPE_p_float.getCPtr(amax), SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax));
    }

    /**
     * Derives the closest point on a triangle from the specified reference
     * point.
     *
     * @param p The reference point from which to test.
     * @param a Vertex A of triangle ABC.
     * @param b Vertex B of triangle ABC.
     * @param c Vertex C of triangle ABC.
     * @return
     */
    public static Vector3f closestPtPointTriangle(Vector3f referencePoint, Vector3f a, Vector3f b, Vector3f c) {
        SWIGTYPE_p_float p = Converter.convertToSWIGTYPE_p_float(referencePoint);
        SWIGTYPE_p_float aa = Converter.convertToSWIGTYPE_p_float(a);
        SWIGTYPE_p_float bb = Converter.convertToSWIGTYPE_p_float(b);
        SWIGTYPE_p_float cc = Converter.convertToSWIGTYPE_p_float(c);
        SWIGTYPE_p_float closest = new FloatArray(3).cast();
        RecastJNI.dtClosestPtPointTriangle(SWIGTYPE_p_float.getCPtr(closest), SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(aa), SWIGTYPE_p_float.getCPtr(bb), SWIGTYPE_p_float.getCPtr(cc));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(closest));
    }

    /**
     * Derives the y-axis height of the closest point on the triangle from the
     * specified reference point.
     *
     * @param referencePoint The reference point from which to test.
     * @param a Vertex A of triangle ABC.
     * @param b Vertex B of triangle ABC.
     * @param c Vertex C of triangle ABC.
     * @return The resulting height.
     */
    public static float closestHeightPointTriangle(Vector3f referencePoint, Vector3f a, Vector3f b, Vector3f c) {
        SWIGTYPE_p_float p = Converter.convertToSWIGTYPE_p_float(referencePoint);
        SWIGTYPE_p_float aa = Converter.convertToSWIGTYPE_p_float(a);
        SWIGTYPE_p_float bb = Converter.convertToSWIGTYPE_p_float(b);
        SWIGTYPE_p_float cc = Converter.convertToSWIGTYPE_p_float(c);
        SWIGTYPE_p_float h = new FloatArray(1).cast();
        RecastJNI.dtClosestHeightPointTriangle(SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(aa), SWIGTYPE_p_float.getCPtr(bb), SWIGTYPE_p_float.getCPtr(cc), SWIGTYPE_p_float.getCPtr(h));
        return Converter.convertToFloat(SWIGTYPE_p_float.getCPtr(h));
    }

//    public static boolean dtIntersectSegmentPoly2D(SWIGTYPE_p_float p0, SWIGTYPE_p_float p1, SWIGTYPE_p_float verts, int nverts, SWIGTYPE_p_float tmin, SWIGTYPE_p_float tmax, SWIGTYPE_p_int segMin, SWIGTYPE_p_int segMax) {
//        return RecastJNI.dtIntersectSegmentPoly2D(SWIGTYPE_p_float.getCPtr(p0), SWIGTYPE_p_float.getCPtr(p1), SWIGTYPE_p_float.getCPtr(verts), nverts, SWIGTYPE_p_float.getCPtr(tmin), SWIGTYPE_p_float.getCPtr(tmax), SWIGTYPE_p_int.getCPtr(segMin), SWIGTYPE_p_int.getCPtr(segMax));
//    }
//    public static boolean dtIntersectSegSeg2D(SWIGTYPE_p_float ap, SWIGTYPE_p_float aq, SWIGTYPE_p_float bp, SWIGTYPE_p_float bq, SWIGTYPE_p_float s, SWIGTYPE_p_float t) {
//        return RecastJNI.dtIntersectSegSeg2D(SWIGTYPE_p_float.getCPtr(ap), SWIGTYPE_p_float.getCPtr(aq), SWIGTYPE_p_float.getCPtr(bp), SWIGTYPE_p_float.getCPtr(bq), SWIGTYPE_p_float.getCPtr(s), SWIGTYPE_p_float.getCPtr(t));
//    }
    /**
     * Determines if the specified point is inside the convex polygon on the
     * xz-plane. All points are projected onto the xz-plane, so the y-values are
     * ignored.
     *
     * @param point The point to check.
     * @param polygon The polygon vertices.
     * @return True if the point is inside the polygon.
     */
    public static boolean isPointInPolygon(Vector3f point, Vector3f[] polygon) {
        SWIGTYPE_p_float pt = Converter.convertToSWIGTYPE_p_float(point);
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(polygon);
        int nverts = polygon.length;
        if (nverts < 3) {
            throw new RuntimeException("The number of vertices must be greater or equal than 3");
        }
        return RecastJNI.dtPointInPolygon(SWIGTYPE_p_float.getCPtr(pt), SWIGTYPE_p_float.getCPtr(verts), nverts);
    }

//    public static boolean dtDistancePtPolyEdgesSqr(SWIGTYPE_p_float pt, SWIGTYPE_p_float verts, int nverts, SWIGTYPE_p_float ed, SWIGTYPE_p_float et) {
//        return RecastJNI.dtDistancePtPolyEdgesSqr(SWIGTYPE_p_float.getCPtr(pt), SWIGTYPE_p_float.getCPtr(verts), nverts, SWIGTYPE_p_float.getCPtr(ed), SWIGTYPE_p_float.getCPtr(et));
//    }
//
//    public static float dtDistancePtSegSqr2D(SWIGTYPE_p_float pt, SWIGTYPE_p_float p, SWIGTYPE_p_float q, SWIGTYPE_p_float t) {
//        return RecastJNI.dtDistancePtSegSqr2D(SWIGTYPE_p_float.getCPtr(pt), SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(q), SWIGTYPE_p_float.getCPtr(t));
//    }
    /**
     * Derives the centroid of a convex polygon. Note: not sure if implemented
     * correctly.
     *
     * @param indices The polygon indices.
     * @param vertices The polygon vertices. [(x, y, z) * vertCount]
     * @return The centroid of the polgyon.
     */
    public static Vector3f calculatePolyCenter(short[] indices, Vector3f[] vertices) {
        FloatArray array = new FloatArray(3);
        SWIGTYPE_p_float tc = array.cast();
        SWIGTYPE_p_unsigned_short idx = Converter.convertToSWIGTYPE_p_unsigned_short(indices);
        int nidx = indices.length;
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        RecastJNI.dtCalcPolyCenter(SWIGTYPE_p_float.getCPtr(tc), SWIGTYPE_p_unsigned_short.getCPtr(idx), nidx, SWIGTYPE_p_float.getCPtr(verts));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(tc));
    }

    /**
     * Determines if the two convex polygons overlap on the xz-plane. All
     * vertices are projected onto the xz-plane, so the y-values are ignored.
     *
     * @param aPoly Polygon A vertices.
     * @param bPoly Polygon B vertices.
     * @return True if the two polygons overlap.
     */
    public static boolean arePoly2DOverlaping(Vector3f[] aPoly, Vector3f[] bPoly) {
        SWIGTYPE_p_float polya = Converter.convertToSWIGTYPE_p_float(aPoly);
        int npolya = aPoly.length;
        SWIGTYPE_p_float polyb = Converter.convertToSWIGTYPE_p_float(bPoly);
        int npolyb = bPoly.length;
        return RecastJNI.dtOverlapPolyPoly2D(SWIGTYPE_p_float.getCPtr(polya), npolya, SWIGTYPE_p_float.getCPtr(polyb), npolyb);
    }

//    public static long dtNextPow2(long v) {
//        return RecastJNI.dtNextPow2(v);
//    }
//    public static long dtIlog2(long v) {
//        return RecastJNI.dtIlog2(v);
//    }
//    public static int dtAlign4(int x) {
//        return RecastJNI.dtAlign4(x);
//    }
//    public static int dtOppositeTile(int side) {
//        return RecastJNI.dtOppositeTile(side);
//    }
//    public static void dtRandomPointInConvexPoly(SWIGTYPE_p_float pts, int npts, SWIGTYPE_p_float areas, float s, float t, SWIGTYPE_p_float out) {
//        RecastJNI.dtRandomPointInConvexPoly(SWIGTYPE_p_float.getCPtr(pts), npts, SWIGTYPE_p_float.getCPtr(areas), s, t, SWIGTYPE_p_float.getCPtr(out));
//    }
    public static int DT_CROWDAGENT_MAX_NEIGHBOURS() {
        return RecastJNI.DT_CROWDAGENT_MAX_NEIGHBOURS_get();
    }

    public static int DT_CROWDAGENT_MAX_CORNERS() {
        return RecastJNI.DT_CROWDAGENT_MAX_CORNERS_get();
    }

    public static int DT_CROWD_MAX_OBSTAVOIDANCE_PARAMS() {
        return RecastJNI.DT_CROWD_MAX_OBSTAVOIDANCE_PARAMS_get();
    }

    public static int DT_CROWD_MAX_QUERY_FILTER_TYPE() {
        return RecastJNI.DT_CROWD_MAX_QUERY_FILTER_TYPE_get();
    }

    public static dtCrowd dtAllocCrowd() {
        long cPtr = RecastJNI.dtAllocCrowd();
        return (cPtr == 0) ? null : new dtCrowd(cPtr, false);
    }

    public static void dtFreeCrowd(dtCrowd ptr) {
        RecastJNI.dtFreeCrowd(dtCrowd.getCPtr(ptr), ptr);
    }

    public static int DT_VERTS_PER_POLYGON() {
        return RecastJNI.DT_VERTS_PER_POLYGON_get();
    }

    public static int DT_NAVMESH_MAGIC() {
        return RecastJNI.DT_NAVMESH_MAGIC_get();
    }

    public static int DT_NAVMESH_VERSION() {
        return RecastJNI.DT_NAVMESH_VERSION_get();
    }

    public static int DT_NAVMESH_STATE_MAGIC() {
        return RecastJNI.DT_NAVMESH_STATE_MAGIC_get();
    }

    public static int DT_NAVMESH_STATE_VERSION() {
        return RecastJNI.DT_NAVMESH_STATE_VERSION_get();
    }

    public static int DT_EXT_LINK() {
        return RecastJNI.DT_EXT_LINK_get();
    }

    public static long DT_NULL_LINK() {
        return RecastJNI.DT_NULL_LINK_get();
    }

    public static long DT_OFFMESH_CON_BIDIR() {
        return RecastJNI.DT_OFFMESH_CON_BIDIR_get();
    }

    public static int DT_MAX_AREAS() {
        return RecastJNI.DT_MAX_AREAS_get();
    }

    /**
     * Note: not sure if it works correctly.
     *
     * Builds navigation mesh tile data from the provided tile creation data.
     * The output data array is allocated using the detour allocator (Alloc()).
     * The method used to free the memory will be determined by how the tile is
     * added to the navigation mesh.
     *
     * @param params Tile creation data.
     * @return The resulting tile data.
     */
    public static char[] createNavMeshData(NavMeshCreateParams params) {
        SWIGTYPE_p_p_unsigned_char outData = null;
        SWIGTYPE_p_int outDataSize = new IntArray(1).cast();
        if (RecastJNI.dtCreateNavMeshData(NavMeshCreateParams.getCPtr(params), params, SWIGTYPE_p_p_unsigned_char.getCPtr(outData), SWIGTYPE_p_int.getCPtr(outDataSize))) {
            return null;
        }
        return Converter.convertToChars(SWIGTYPE_p_p_unsigned_char.getCPtr(outData), Converter.convertToInt(SWIGTYPE_p_int.getCPtr(outDataSize)));
    }

    public static boolean dtNavMeshHeaderSwapEndian(SWIGTYPE_p_unsigned_char data, int dataSize) {
        return RecastJNI.dtNavMeshHeaderSwapEndian(SWIGTYPE_p_unsigned_char.getCPtr(data), dataSize);
    }

    public static boolean dtNavMeshDataSwapEndian(SWIGTYPE_p_unsigned_char data, int dataSize) {
        return RecastJNI.dtNavMeshDataSwapEndian(SWIGTYPE_p_unsigned_char.getCPtr(data), dataSize);
    }

    public static NavMeshQuery dtAllocNavMeshQuery() {
        long cPtr = RecastJNI.dtAllocNavMeshQuery();
        return (cPtr == 0) ? null : new NavMeshQuery(cPtr, false);
    }

    public static void dtFreeNavMeshQuery(NavMeshQuery query) {
        RecastJNI.dtFreeNavMeshQuery(NavMeshQuery.getCPtr(query), query);
    }

    public static int DT_NULL_IDX() {
        return RecastJNI.DT_NULL_IDX_get();
    }

    public static dtObstacleAvoidanceDebugData dtAllocObstacleAvoidanceDebugData() {
        long cPtr = RecastJNI.dtAllocObstacleAvoidanceDebugData();
        return (cPtr == 0) ? null : new dtObstacleAvoidanceDebugData(cPtr, false);
    }

    public static void dtFreeObstacleAvoidanceDebugData(dtObstacleAvoidanceDebugData ptr) {
        RecastJNI.dtFreeObstacleAvoidanceDebugData(dtObstacleAvoidanceDebugData.getCPtr(ptr), ptr);
    }

    public static int DT_MAX_PATTERN_DIVS() {
        return RecastJNI.DT_MAX_PATTERN_DIVS_get();
    }

    public static int DT_MAX_PATTERN_RINGS() {
        return RecastJNI.DT_MAX_PATTERN_RINGS_get();
    }

    public static dtObstacleAvoidanceQuery dtAllocObstacleAvoidanceQuery() {
        long cPtr = RecastJNI.dtAllocObstacleAvoidanceQuery();
        return (cPtr == 0) ? null : new dtObstacleAvoidanceQuery(cPtr, false);
    }

    public static void dtFreeObstacleAvoidanceQuery(dtObstacleAvoidanceQuery ptr) {
        RecastJNI.dtFreeObstacleAvoidanceQuery(dtObstacleAvoidanceQuery.getCPtr(ptr), ptr);
    }

    public static int dtMergeCorridorStartMoved(SWIGTYPE_p_unsigned_int path, int npath, int maxPath, SWIGTYPE_p_unsigned_int visited, int nvisited) {
        return RecastJNI.dtMergeCorridorStartMoved(SWIGTYPE_p_unsigned_int.getCPtr(path), npath, maxPath, SWIGTYPE_p_unsigned_int.getCPtr(visited), nvisited);
    }

    public static int dtMergeCorridorEndMoved(SWIGTYPE_p_unsigned_int path, int npath, int maxPath, SWIGTYPE_p_unsigned_int visited, int nvisited) {
        return RecastJNI.dtMergeCorridorEndMoved(SWIGTYPE_p_unsigned_int.getCPtr(path), npath, maxPath, SWIGTYPE_p_unsigned_int.getCPtr(visited), nvisited);
    }

    public static int dtMergeCorridorStartShortcut(SWIGTYPE_p_unsigned_int path, int npath, int maxPath, SWIGTYPE_p_unsigned_int visited, int nvisited) {
        return RecastJNI.dtMergeCorridorStartShortcut(SWIGTYPE_p_unsigned_int.getCPtr(path), npath, maxPath, SWIGTYPE_p_unsigned_int.getCPtr(visited), nvisited);
    }

    public static long getDT_PATHQ_INVALID() {
        return RecastJNI.DT_PATHQ_INVALID_get();
    }

    public static dtProximityGrid dtAllocProximityGrid() {
        long cPtr = RecastJNI.dtAllocProximityGrid();
        return (cPtr == 0) ? null : new dtProximityGrid(cPtr, false);
    }

    public static void dtFreeProximityGrid(dtProximityGrid ptr) {
        RecastJNI.dtFreeProximityGrid(dtProximityGrid.getCPtr(ptr), ptr);
    }

    public static long DT_FAILURE() {
        return RecastJNI.DT_FAILURE_get();
    }

    public static long DT_SUCCESS() {
        return RecastJNI.DT_SUCCESS_get();
    }

    public static long DT_IN_PROGRESS() {
        return RecastJNI.DT_IN_PROGRESS_get();
    }

    public static long DT_STATUS_DETAIL_MASK() {
        return RecastJNI.DT_STATUS_DETAIL_MASK_get();
    }

    public static long DT_WRONG_MAGIC() {
        return RecastJNI.DT_WRONG_MAGIC_get();
    }

    public static long DT_WRONG_VERSION() {
        return RecastJNI.DT_WRONG_VERSION_get();
    }

    public static long DT_OUT_OF_MEMORY() {
        return RecastJNI.DT_OUT_OF_MEMORY_get();
    }

    public static long DT_INVALID_PARAM() {
        return RecastJNI.DT_INVALID_PARAM_get();
    }

    public static long DT_BUFFER_TOO_SMALL() {
        return RecastJNI.DT_BUFFER_TOO_SMALL_get();
    }

    public static long DT_OUT_OF_NODES() {
        return RecastJNI.DT_OUT_OF_NODES_get();
    }

    public static long DT_PARTIAL_RESULT() {
        return RecastJNI.DT_PARTIAL_RESULT_get();
    }

    public static boolean dtStatusSucceed(long status) {
        return RecastJNI.dtStatusSucceed(status);
    }

    public static boolean dtStatusFailed(long status) {
        return RecastJNI.dtStatusFailed(status);
    }

    public static boolean dtStatusInProgress(long status) {
        return RecastJNI.dtStatusInProgress(status);
    }

    public static boolean dtStatusDetail(long status, long detail) {
        return RecastJNI.dtStatusDetail(status, detail);
    }

    public static int MAX_TOUCHED_TILES() {
        return RecastJNI.DT_MAX_TOUCHED_TILES_get();
    }

    public static TileCache dtAllocTileCache() {
        long cPtr = RecastJNI.dtAllocTileCache();
        return (cPtr == 0) ? null : new TileCache(cPtr, false);
    }

    public static void dtFreeTileCache(TileCache tc) {
        RecastJNI.dtFreeTileCache(TileCache.getCPtr(tc), tc);
    }

    public static int DT_TILECACHE_MAGIC() {
        return RecastJNI.DT_TILECACHE_MAGIC_get();
    }

    public static int DT_TILECACHE_VERSION() {
        return RecastJNI.DT_TILECACHE_VERSION_get();
    }

    public static short DT_TILECACHE_NULL_AREA() {
        return RecastJNI.DT_TILECACHE_NULL_AREA_get();
    }

    public static short DT_TILECACHE_WALKABLE_AREA() {
        return RecastJNI.DT_TILECACHE_WALKABLE_AREA_get();
    }

    public static int DT_TILECACHE_NULL_IDX() {
        return RecastJNI.DT_TILECACHE_NULL_IDX_get();
    }

    public static long dtBuildTileCacheLayer(TileCacheCompressor comp, TileCacheLayerHeader header, SWIGTYPE_p_unsigned_char heights, SWIGTYPE_p_unsigned_char areas, SWIGTYPE_p_unsigned_char cons, SWIGTYPE_p_p_unsigned_char outData, SWIGTYPE_p_int outDataSize) {
        return RecastJNI.dtBuildTileCacheLayer(TileCacheCompressor.getCPtr(comp), comp, TileCacheLayerHeader.getCPtr(header), header, SWIGTYPE_p_unsigned_char.getCPtr(heights), SWIGTYPE_p_unsigned_char.getCPtr(areas), SWIGTYPE_p_unsigned_char.getCPtr(cons), SWIGTYPE_p_p_unsigned_char.getCPtr(outData), SWIGTYPE_p_int.getCPtr(outDataSize));
    }

    public static void dtFreeTileCacheLayer(TileCacheAlloc alloc, TileCacheLayer layer) {
        RecastJNI.dtFreeTileCacheLayer(TileCacheAlloc.getCPtr(alloc), alloc, TileCacheLayer.getCPtr(layer), layer);
    }

    public static long dtDecompressTileCacheLayer(TileCacheAlloc alloc, TileCacheCompressor comp, SWIGTYPE_p_unsigned_char compressed, int compressedSize, SWIGTYPE_p_p_dtTileCacheLayer layerOut) {
        return RecastJNI.dtDecompressTileCacheLayer(TileCacheAlloc.getCPtr(alloc), alloc, TileCacheCompressor.getCPtr(comp), comp, SWIGTYPE_p_unsigned_char.getCPtr(compressed), compressedSize, SWIGTYPE_p_p_dtTileCacheLayer.getCPtr(layerOut));
    }

    public static TileCacheContourSet dtAllocTileCacheContourSet(TileCacheAlloc alloc) {
        long cPtr = RecastJNI.dtAllocTileCacheContourSet(TileCacheAlloc.getCPtr(alloc), alloc);
        return (cPtr == 0) ? null : new TileCacheContourSet(cPtr, false);
    }

    public static void dtFreeTileCacheContourSet(TileCacheAlloc alloc, TileCacheContourSet cset) {
        RecastJNI.dtFreeTileCacheContourSet(TileCacheAlloc.getCPtr(alloc), alloc, TileCacheContourSet.getCPtr(cset), cset);
    }

    public static TileCachePolyMesh dtAllocTileCachePolyMesh(TileCacheAlloc alloc) {
        long cPtr = RecastJNI.dtAllocTileCachePolyMesh(TileCacheAlloc.getCPtr(alloc), alloc);
        return (cPtr == 0) ? null : new TileCachePolyMesh(cPtr, false);
    }

    public static void dtFreeTileCachePolyMesh(TileCacheAlloc alloc, TileCachePolyMesh lmesh) {
        RecastJNI.dtFreeTileCachePolyMesh(TileCacheAlloc.getCPtr(alloc), alloc, TileCachePolyMesh.getCPtr(lmesh), lmesh);
    }

    public static long dtMarkCylinderArea(TileCacheLayer layer, SWIGTYPE_p_float orig, float cs, float ch, SWIGTYPE_p_float pos, float radius, float height, short areaId) {
        return RecastJNI.dtMarkCylinderArea(TileCacheLayer.getCPtr(layer), layer, SWIGTYPE_p_float.getCPtr(orig), cs, ch, SWIGTYPE_p_float.getCPtr(pos), radius, height, areaId);
    }

    public static long dtBuildTileCacheRegions(TileCacheAlloc alloc, TileCacheLayer layer, int walkableClimb) {
        return RecastJNI.dtBuildTileCacheRegions(TileCacheAlloc.getCPtr(alloc), alloc, TileCacheLayer.getCPtr(layer), layer, walkableClimb);
    }

    public static long dtBuildTileCacheContours(TileCacheAlloc alloc, TileCacheLayer layer, int walkableClimb, float maxError, TileCacheContourSet lcset) {
        return RecastJNI.dtBuildTileCacheContours(TileCacheAlloc.getCPtr(alloc), alloc, TileCacheLayer.getCPtr(layer), layer, walkableClimb, maxError, TileCacheContourSet.getCPtr(lcset), lcset);
    }

    public static long dtBuildTileCachePolyMesh(TileCacheAlloc alloc, TileCacheContourSet lcset, TileCachePolyMesh mesh) {
        return RecastJNI.dtBuildTileCachePolyMesh(TileCacheAlloc.getCPtr(alloc), alloc, TileCacheContourSet.getCPtr(lcset), lcset, TileCachePolyMesh.getCPtr(mesh), mesh);
    }

    public static boolean dtTileCacheHeaderSwapEndian(SWIGTYPE_p_unsigned_char data, int dataSize) {
        return RecastJNI.dtTileCacheHeaderSwapEndian(SWIGTYPE_p_unsigned_char.getCPtr(data), dataSize);
    }
}
