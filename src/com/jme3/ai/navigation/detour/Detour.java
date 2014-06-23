package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.crowd.dtAllocHint;
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
import com.jme3.ai.navigation.utils.SWIGTYPE_p_void;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_short;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_dtTileCacheLayer;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Detour {

    public static SWIGTYPE_p_void Alloc(int size, dtAllocHint hint) {
        long cPtr = RecastJNI.dtAlloc(size, hint.swigValue());
        return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
    }
    /*
     public static void dtFree(SWIGTYPE_p_void ptr) {
     RecastJNI.dtFree(SWIGTYPE_p_void.getCPtr(ptr));
     }

     public static float dtSqrt(float x) {
     return RecastJNI.dtSqrt(x);
     }

     public static void dtVcross(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     RecastJNI.dtVcross(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static float dtVdot(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.dtVdot(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void dtVmad(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2, float s) {
     RecastJNI.dtVmad(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2), s);
     }

     public static void dtVlerp(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2, float t) {
     RecastJNI.dtVlerp(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2), t);
     }

     public static void dtVadd(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     RecastJNI.dtVadd(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void dtVsub(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     RecastJNI.dtVsub(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void dtVscale(SWIGTYPE_p_float dest, SWIGTYPE_p_float v, float t) {
     RecastJNI.dtVscale(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v), t);
     }

     public static void dtVmin(SWIGTYPE_p_float mn, SWIGTYPE_p_float v) {
     RecastJNI.dtVmin(SWIGTYPE_p_float.getCPtr(mn), SWIGTYPE_p_float.getCPtr(v));
     }

     public static void dtVmax(SWIGTYPE_p_float mx, SWIGTYPE_p_float v) {
     RecastJNI.dtVmax(SWIGTYPE_p_float.getCPtr(mx), SWIGTYPE_p_float.getCPtr(v));
     }

     public static void dtVset(SWIGTYPE_p_float dest, float x, float y, float z) {
     RecastJNI.dtVset(SWIGTYPE_p_float.getCPtr(dest), x, y, z);
     }

     public static void dtVcopy(SWIGTYPE_p_float dest, SWIGTYPE_p_float a) {
     RecastJNI.dtVcopy(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(a));
     }

     public static float dtVlen(SWIGTYPE_p_float v) {
     return RecastJNI.dtVlen(SWIGTYPE_p_float.getCPtr(v));
     }

     public static float dtVlenSqr(SWIGTYPE_p_float v) {
     return RecastJNI.dtVlenSqr(SWIGTYPE_p_float.getCPtr(v));
     }

     public static float dtVdist(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.dtVdist(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static float dtVdistSqr(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.dtVdistSqr(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static float dtVdist2D(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.dtVdist2D(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static float dtVdist2DSqr(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.dtVdist2DSqr(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void dtVnormalize(SWIGTYPE_p_float v) {
     RecastJNI.dtVnormalize(SWIGTYPE_p_float.getCPtr(v));
     }

     public static boolean dtVequal(SWIGTYPE_p_float p0, SWIGTYPE_p_float p1) {
     return RecastJNI.dtVequal(SWIGTYPE_p_float.getCPtr(p0), SWIGTYPE_p_float.getCPtr(p1));
     }

     public static float dtVdot2D(SWIGTYPE_p_float u, SWIGTYPE_p_float v) {
     return RecastJNI.dtVdot2D(SWIGTYPE_p_float.getCPtr(u), SWIGTYPE_p_float.getCPtr(v));
     }

     public static float dtVperp2D(SWIGTYPE_p_float u, SWIGTYPE_p_float v) {
     return RecastJNI.dtVperp2D(SWIGTYPE_p_float.getCPtr(u), SWIGTYPE_p_float.getCPtr(v));
     }*/

    public static float dtTriArea2D(SWIGTYPE_p_float a, SWIGTYPE_p_float b, SWIGTYPE_p_float c) {
        return RecastJNI.dtTriArea2D(SWIGTYPE_p_float.getCPtr(a), SWIGTYPE_p_float.getCPtr(b), SWIGTYPE_p_float.getCPtr(c));
    }

    public static boolean dtOverlapQuantBounds(SWIGTYPE_p_unsigned_short amin, SWIGTYPE_p_unsigned_short amax, SWIGTYPE_p_unsigned_short bmin, SWIGTYPE_p_unsigned_short bmax) {
        return RecastJNI.dtOverlapQuantBounds(SWIGTYPE_p_unsigned_short.getCPtr(amin), SWIGTYPE_p_unsigned_short.getCPtr(amax), SWIGTYPE_p_unsigned_short.getCPtr(bmin), SWIGTYPE_p_unsigned_short.getCPtr(bmax));
    }

    public static boolean dtOverlapBounds(SWIGTYPE_p_float amin, SWIGTYPE_p_float amax, SWIGTYPE_p_float bmin, SWIGTYPE_p_float bmax) {
        return RecastJNI.dtOverlapBounds(SWIGTYPE_p_float.getCPtr(amin), SWIGTYPE_p_float.getCPtr(amax), SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax));
    }

    public static void dtClosestPtPointTriangle(SWIGTYPE_p_float closest, SWIGTYPE_p_float p, SWIGTYPE_p_float a, SWIGTYPE_p_float b, SWIGTYPE_p_float c) {
        RecastJNI.dtClosestPtPointTriangle(SWIGTYPE_p_float.getCPtr(closest), SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(a), SWIGTYPE_p_float.getCPtr(b), SWIGTYPE_p_float.getCPtr(c));
    }

    public static boolean dtClosestHeightPointTriangle(SWIGTYPE_p_float p, SWIGTYPE_p_float a, SWIGTYPE_p_float b, SWIGTYPE_p_float c, SWIGTYPE_p_float h) {
        return RecastJNI.dtClosestHeightPointTriangle(SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(a), SWIGTYPE_p_float.getCPtr(b), SWIGTYPE_p_float.getCPtr(c), SWIGTYPE_p_float.getCPtr(h));
    }

    public static boolean dtIntersectSegmentPoly2D(SWIGTYPE_p_float p0, SWIGTYPE_p_float p1, SWIGTYPE_p_float verts, int nverts, SWIGTYPE_p_float tmin, SWIGTYPE_p_float tmax, SWIGTYPE_p_int segMin, SWIGTYPE_p_int segMax) {
        return RecastJNI.dtIntersectSegmentPoly2D(SWIGTYPE_p_float.getCPtr(p0), SWIGTYPE_p_float.getCPtr(p1), SWIGTYPE_p_float.getCPtr(verts), nverts, SWIGTYPE_p_float.getCPtr(tmin), SWIGTYPE_p_float.getCPtr(tmax), SWIGTYPE_p_int.getCPtr(segMin), SWIGTYPE_p_int.getCPtr(segMax));
    }

    public static boolean dtIntersectSegSeg2D(SWIGTYPE_p_float ap, SWIGTYPE_p_float aq, SWIGTYPE_p_float bp, SWIGTYPE_p_float bq, SWIGTYPE_p_float s, SWIGTYPE_p_float t) {
        return RecastJNI.dtIntersectSegSeg2D(SWIGTYPE_p_float.getCPtr(ap), SWIGTYPE_p_float.getCPtr(aq), SWIGTYPE_p_float.getCPtr(bp), SWIGTYPE_p_float.getCPtr(bq), SWIGTYPE_p_float.getCPtr(s), SWIGTYPE_p_float.getCPtr(t));
    }

    public static boolean dtPointInPolygon(SWIGTYPE_p_float pt, SWIGTYPE_p_float verts, int nverts) {
        return RecastJNI.dtPointInPolygon(SWIGTYPE_p_float.getCPtr(pt), SWIGTYPE_p_float.getCPtr(verts), nverts);
    }

    public static boolean dtDistancePtPolyEdgesSqr(SWIGTYPE_p_float pt, SWIGTYPE_p_float verts, int nverts, SWIGTYPE_p_float ed, SWIGTYPE_p_float et) {
        return RecastJNI.dtDistancePtPolyEdgesSqr(SWIGTYPE_p_float.getCPtr(pt), SWIGTYPE_p_float.getCPtr(verts), nverts, SWIGTYPE_p_float.getCPtr(ed), SWIGTYPE_p_float.getCPtr(et));
    }

    public static float dtDistancePtSegSqr2D(SWIGTYPE_p_float pt, SWIGTYPE_p_float p, SWIGTYPE_p_float q, SWIGTYPE_p_float t) {
        return RecastJNI.dtDistancePtSegSqr2D(SWIGTYPE_p_float.getCPtr(pt), SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(q), SWIGTYPE_p_float.getCPtr(t));
    }

    public static void dtCalcPolyCenter(SWIGTYPE_p_float tc, SWIGTYPE_p_unsigned_short idx, int nidx, SWIGTYPE_p_float verts) {
        RecastJNI.dtCalcPolyCenter(SWIGTYPE_p_float.getCPtr(tc), SWIGTYPE_p_unsigned_short.getCPtr(idx), nidx, SWIGTYPE_p_float.getCPtr(verts));
    }

    public static boolean dtOverlapPolyPoly2D(SWIGTYPE_p_float polya, int npolya, SWIGTYPE_p_float polyb, int npolyb) {
        return RecastJNI.dtOverlapPolyPoly2D(SWIGTYPE_p_float.getCPtr(polya), npolya, SWIGTYPE_p_float.getCPtr(polyb), npolyb);
    }

    public static long dtNextPow2(long v) {
        return RecastJNI.dtNextPow2(v);
    }

    public static long dtIlog2(long v) {
        return RecastJNI.dtIlog2(v);
    }

    public static int dtAlign4(int x) {
        return RecastJNI.dtAlign4(x);
    }

    public static int dtOppositeTile(int side) {
        return RecastJNI.dtOppositeTile(side);
    }

    public static void dtSwapByte(SWIGTYPE_p_unsigned_char a, SWIGTYPE_p_unsigned_char b) {
        RecastJNI.dtSwapByte(SWIGTYPE_p_unsigned_char.getCPtr(a), SWIGTYPE_p_unsigned_char.getCPtr(b));
    }

    public static void dtSwapEndian(SWIGTYPE_p_unsigned_short v) {
        RecastJNI.dtSwapEndian__SWIG_0(SWIGTYPE_p_unsigned_short.getCPtr(v));
    }

    public static void dtSwapEndian(SWIGTYPE_p_short v) {
        RecastJNI.dtSwapEndian__SWIG_1(SWIGTYPE_p_short.getCPtr(v));
    }

    public static void dtSwapEndian(SWIGTYPE_p_unsigned_int v) {
        RecastJNI.dtSwapEndian__SWIG_2(SWIGTYPE_p_unsigned_int.getCPtr(v));
    }

    public static void dtSwapEndian(SWIGTYPE_p_int v) {
        RecastJNI.dtSwapEndian__SWIG_3(SWIGTYPE_p_int.getCPtr(v));
    }

    public static void dtSwapEndian(SWIGTYPE_p_float v) {
        RecastJNI.dtSwapEndian__SWIG_4(SWIGTYPE_p_float.getCPtr(v));
    }

    public static void dtRandomPointInConvexPoly(SWIGTYPE_p_float pts, int npts, SWIGTYPE_p_float areas, float s, float t, SWIGTYPE_p_float out) {
        RecastJNI.dtRandomPointInConvexPoly(SWIGTYPE_p_float.getCPtr(pts), npts, SWIGTYPE_p_float.getCPtr(areas), s, t, SWIGTYPE_p_float.getCPtr(out));
    }

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

    public static NavMesh dtAllocNavMesh() {
        long cPtr = RecastJNI.dtAllocNavMesh();
        return (cPtr == 0) ? null : new NavMesh(cPtr, false);
    }

    public static void dtFreeNavMesh(NavMesh navmesh) {
        RecastJNI.dtFreeNavMesh(NavMesh.getCPtr(navmesh), navmesh);
    }

    public static boolean dtCreateNavMeshData(NavMeshCreateParams params, SWIGTYPE_p_p_unsigned_char outData, SWIGTYPE_p_int outDataSize) {
        return RecastJNI.dtCreateNavMeshData(NavMeshCreateParams.getCPtr(params), params, SWIGTYPE_p_p_unsigned_char.getCPtr(outData), SWIGTYPE_p_int.getCPtr(outDataSize));
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
