package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.FloatArray;
import com.jme3.ai.navigation.utils.IntArray;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_rcPolyMesh;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_rcPolyMeshDetail;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class RecastBuilder {

    public static float RC_PI() {
        return RecastJNI.RC_PI_get();
    }

    public static int RC_SPAN_HEIGHT_BITS() {
        return RecastJNI.RC_SPAN_HEIGHT_BITS_get();
    }

    public static int RC_SPAN_MAX_HEIGHT() {
        return RecastJNI.RC_SPAN_MAX_HEIGHT_get();
    }

    public static int RC_SPANS_PER_POOL() {
        return RecastJNI.RC_SPANS_PER_POOL_get();
    }

    public static int RC_BORDER_REG() {
        return RecastJNI.RC_BORDER_REG_get();
    }

    public static int RC_BORDER_VERTEX() {
        return RecastJNI.RC_BORDER_VERTEX_get();
    }

    public static int RC_AREA_BORDER() {
        return RecastJNI.RC_AREA_BORDER_get();
    }

    public static int RC_CONTOUR_REG_MASK() {
        return RecastJNI.RC_CONTOUR_REG_MASK_get();
    }

    public static int RC_MESH_NULL_IDX() {
        return RecastJNI.RC_MESH_NULL_IDX_get();
    }

    public static short RC_NULL_AREA() {
        return RecastJNI.RC_NULL_AREA_get();
    }

    public static short RC_WALKABLE_AREA() {
        return RecastJNI.RC_WALKABLE_AREA_get();
    }

    public static int RC_NOT_CONNECTED() {
        return RecastJNI.RC_NOT_CONNECTED_get();
    }
    /*
     public static float rcSqrt(float x) {
     return RecastJNI.rcSqrt(x);
     }

     public static void rcVcross(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     RecastJNI.rcVcross(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static float rcVdot(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.rcVdot(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void rcVmad(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2, float s) {
     RecastJNI.rcVmad(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2), s);
     }

     public static void rcVadd(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     RecastJNI.rcVadd(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void rcVsub(SWIGTYPE_p_float dest, SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     RecastJNI.rcVsub(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void rcVmin(SWIGTYPE_p_float mn, SWIGTYPE_p_float v) {
     RecastJNI.rcVmin(SWIGTYPE_p_float.getCPtr(mn), SWIGTYPE_p_float.getCPtr(v));
     }

     public static void rcVmax(SWIGTYPE_p_float mx, SWIGTYPE_p_float v) {
     RecastJNI.rcVmax(SWIGTYPE_p_float.getCPtr(mx), SWIGTYPE_p_float.getCPtr(v));
     }

     public static void rcVcopy(SWIGTYPE_p_float dest, SWIGTYPE_p_float v) {
     RecastJNI.rcVcopy(SWIGTYPE_p_float.getCPtr(dest), SWIGTYPE_p_float.getCPtr(v));
     }

     public static float rcVdist(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.rcVdist(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static float rcVdistSqr(SWIGTYPE_p_float v1, SWIGTYPE_p_float v2) {
     return RecastJNI.rcVdistSqr(SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2));
     }

     public static void rcVnormalize(SWIGTYPE_p_float v) {
     RecastJNI.rcVnormalize(SWIGTYPE_p_float.getCPtr(v));
     }*/

    public static Vector3f calculateMinBounds(Vector3f[] vertices) {
        FloatArray tempMin = new FloatArray(3);
        FloatArray tempMax = new FloatArray(3);
        SWIGTYPE_p_float bmin = tempMin.cast();
        SWIGTYPE_p_float bmax = tempMax.cast();
        int nv = vertices.length;
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        RecastJNI.rcCalcBounds(SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(bmin));
    }

    public static Vector3f calculateMaxBounds(Vector3f[] vertices) {
        FloatArray tempMin = new FloatArray(3);
        FloatArray tempMax = new FloatArray(3);
        SWIGTYPE_p_float bmin = tempMin.cast();
        SWIGTYPE_p_float bmax = tempMax.cast();
        int nv = vertices.length;
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        RecastJNI.rcCalcBounds(SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(bmax));
    }

    /**
     * Calculating grid size and returning height.
     *
     * @param minBounds
     * @param maxBounds
     * @param cellSize
     * @return
     */
    public static int calculateGridHeight(Vector3f minBounds, Vector3f maxBounds, float cellSize) {
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(minBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(maxBounds);
        // making memory where w and h will be saved
        // w will be taken by garbage memory
        IntArray tempW = new IntArray(1);
        IntArray tempH = new IntArray(1);
        SWIGTYPE_p_int w = tempW.cast();
        SWIGTYPE_p_int h = tempH.cast();
        RecastJNI.rcCalcGridSize(SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), cellSize, SWIGTYPE_p_int.getCPtr(w), SWIGTYPE_p_int.getCPtr(h));
        return tempH.getItem(0);
    }

    /**
     * Calculating grid size and returning width.
     *
     * @param minBounds
     * @param maxBounds
     * @param cellSize
     * @return
     */
    public static int calculateGridWidth(Vector3f minBounds, Vector3f maxBounds, float cellSize) {
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(minBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(maxBounds);
        // making memory where w and h will be saved
        // h will be taken by garbage memory
        IntArray tempW = new IntArray(1);
        IntArray tempH = new IntArray(1);
        SWIGTYPE_p_int w = tempW.cast();
        SWIGTYPE_p_int h = tempH.cast();
        RecastJNI.rcCalcGridSize(SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), cellSize, SWIGTYPE_p_int.getCPtr(w), SWIGTYPE_p_int.getCPtr(h));
        return tempW.getItem(0);
    }

    public static boolean createHeightfield(Context ctx, Heightfield hf, int width, int height, Vector3f minBounds, Vector3f maxBounds, float cs, float ch) {
        if (hf == null) {
            throw new NullPointerException("Heightfield must be initialized");
        }
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(minBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(maxBounds);
        return RecastJNI.rcCreateHeightfield(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf, width, height, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), cs, ch);
    }

    public static void markWalkableTriangles(Context ctx, float walkableSlopeAngle, Vector3f[] vertices, int[] indices, int nt, char[] areas) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(indices);
        SWIGTYPE_p_unsigned_char area = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcMarkWalkableTriangles(Context.getCPtr(ctx), ctx, walkableSlopeAngle, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), nt, SWIGTYPE_p_unsigned_char.getCPtr(area));
    }

    public static void clearUnwalkableTriangles(Context ctx, float walkableSlopeAngle, Vector3f[] vertices, int[] indices, char[] areas) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(indices);
        int nt = indices.length / 3;
        SWIGTYPE_p_unsigned_char area = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcClearUnwalkableTriangles(Context.getCPtr(ctx), ctx, walkableSlopeAngle, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), nt, SWIGTYPE_p_unsigned_char.getCPtr(area));
    }

    public static void addSpan(Context ctx, Heightfield hf, int x, int y, int minSpanLimit, int maxSpanLimit, short area, int flagMergeThr) {
        RecastJNI.rcAddSpan(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf, x, y, minSpanLimit, maxSpanLimit, area, flagMergeThr);
    }

    public static void rasterizeTriangle(Context ctx, Vector3f vertex0, Vector3f vertex1, Vector3f vertex2, short area, Heightfield solid, int flagMergeThr) {
        SWIGTYPE_p_float v0 = Converter.convertToSWIGTYPE_p_float(vertex0);
        SWIGTYPE_p_float v1 = Converter.convertToSWIGTYPE_p_float(vertex1);
        SWIGTYPE_p_float v2 = Converter.convertToSWIGTYPE_p_float(vertex2);
        RecastJNI.rcRasterizeTriangle__SWIG_0(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(v0), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2), area, Heightfield.getCPtr(solid), solid, flagMergeThr);
    }

    public static void rasterizeTriangles(Context ctx, Vector3f[] vertices, int[] indices, char[] areas, Heightfield solid, int flagMergeThr) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(indices);
        int nt = indices.length / 3;
        SWIGTYPE_p_unsigned_char area = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcRasterizeTriangles__SWIG_0(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), SWIGTYPE_p_unsigned_char.getCPtr(area), nt, Heightfield.getCPtr(solid), solid, flagMergeThr);
    }

    public static void rasterizeTriangles(Context ctx, Vector3f[] vertices, int[] indices, char[] areas, Heightfield solid) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(indices);
        int nt = indices.length / 3;
        SWIGTYPE_p_unsigned_char area = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcRasterizeTriangles__SWIG_1(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), SWIGTYPE_p_unsigned_char.getCPtr(area), nt, Heightfield.getCPtr(solid), solid);
    }

    public static void filterLowHangingWalkableObstacles(Context ctx, int walkableClimb, Heightfield solid) {
        RecastJNI.rcFilterLowHangingWalkableObstacles(Context.getCPtr(ctx), ctx, walkableClimb, Heightfield.getCPtr(solid), solid);
    }

    public static void filterLedgeSpans(Context ctx, int walkableHeight, int walkableClimb, Heightfield solid) {
        RecastJNI.rcFilterLedgeSpans(Context.getCPtr(ctx), ctx, walkableHeight, walkableClimb, Heightfield.getCPtr(solid), solid);
    }

    public static void filterWalkableLowHeightSpans(Context ctx, int walkableHeight, Heightfield solid) {
        RecastJNI.rcFilterWalkableLowHeightSpans(Context.getCPtr(ctx), ctx, walkableHeight, Heightfield.getCPtr(solid), solid);
    }

    public static int getHeightFieldSpanCount(Context ctx, Heightfield hf) {
        return RecastJNI.rcGetHeightFieldSpanCount(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf);
    }

    public static boolean buildCompactHeightfield(Context ctx, int walkableHeight, int walkableClimb, Heightfield hf, CompactHeightfield chf) {
        return RecastJNI.rcBuildCompactHeightfield(Context.getCPtr(ctx), ctx, walkableHeight, walkableClimb, Heightfield.getCPtr(hf), hf, CompactHeightfield.getCPtr(chf), chf);
    }

    public static boolean erodeWalkableArea(Context ctx, int radius, CompactHeightfield chf) {
        return RecastJNI.rcErodeWalkableArea(Context.getCPtr(ctx), ctx, radius, CompactHeightfield.getCPtr(chf), chf);
    }

    public static boolean medianFilterWalkableArea(Context ctx, CompactHeightfield chf) {
        return RecastJNI.rcMedianFilterWalkableArea(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf);
    }

    public static void markBoxArea(Context ctx, Vector3f minBounds, Vector3f maxBounds, short areaId, CompactHeightfield chf) {
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(minBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcMarkBoxArea(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), areaId, CompactHeightfield.getCPtr(chf), chf);
    }

    public static void markConvexPolyArea(Context ctx, Vector3f[] vertices, float minHeight, float maxHeight, short areaId, CompactHeightfield chf) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        RecastJNI.rcMarkConvexPolyArea(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(verts), nverts, minHeight, maxHeight, areaId, CompactHeightfield.getCPtr(chf), chf);
    }

    public static Vector3f[] offsetPoly(Vector3f[] vertices, float offset, int maxOutVerts) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        FloatArray array = new FloatArray(maxOutVerts);
        SWIGTYPE_p_float outVerts = array.cast();
        int num = RecastJNI.rcOffsetPoly(SWIGTYPE_p_float.getCPtr(verts), nverts, offset, SWIGTYPE_p_float.getCPtr(outVerts), maxOutVerts);
        array = new FloatArray(SWIGTYPE_p_float.getCPtr(outVerts), false);
        return Converter.convertToVector3f(FloatArray.getCPtr(array), num);
    }

    public static void markCylinderArea(Context ctx, Vector3f position, float radius, float height, short areaId, CompactHeightfield chf) {
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.rcMarkCylinderArea(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(pos), radius, height, areaId, CompactHeightfield.getCPtr(chf), chf);
    }

    public static boolean buildDistanceField(Context ctx, CompactHeightfield chf) {
        return RecastJNI.rcBuildDistanceField(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf);
    }

    public static boolean buildRegions(Context ctx, CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea) {
        return RecastJNI.rcBuildRegions(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, borderSize, minRegionArea, mergeRegionArea);
    }

    public static boolean buildRegionsMonotone(Context ctx, CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea) {
        return RecastJNI.rcBuildRegionsMonotone(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, borderSize, minRegionArea, mergeRegionArea);
    }

    public static void setConnection(CompactSpan s, int dir, int i) {
        RecastJNI.rcSetCon(CompactSpan.getCPtr(s), s, dir, i);
    }

    public static int getConnection(CompactSpan s, int dir) {
        return RecastJNI.rcGetCon(CompactSpan.getCPtr(s), s, dir);
    }

    public static int getDirectionOffsetX(int dir) {
        return RecastJNI.rcGetDirOffsetX(dir);
    }

    public static int getDirectionOffsetY(int dir) {
        return RecastJNI.rcGetDirOffsetY(dir);
    }

    public static boolean buildHeightfieldLayers(Context ctx, CompactHeightfield chf, int borderSize, int walkableHeight, HeightfieldLayerSet lset) {
        return RecastJNI.rcBuildHeightfieldLayers(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, borderSize, walkableHeight, HeightfieldLayerSet.getCPtr(lset), lset);
    }

    public static boolean buildContours(Context ctx, CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset, int flags) {
        return RecastJNI.rcBuildContours__SWIG_0(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, maxError, maxEdgeLen, ContourSet.getCPtr(cset), cset, flags);
    }

    public static boolean buildContours(Context ctx, CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset) {
        return RecastJNI.rcBuildContours__SWIG_1(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, maxError, maxEdgeLen, ContourSet.getCPtr(cset), cset);
    }

    public static boolean buildPolyMesh(Context ctx, ContourSet cset, int nvp, PolyMesh mesh) {
        return RecastJNI.rcBuildPolyMesh(Context.getCPtr(ctx), ctx, ContourSet.getCPtr(cset), cset, nvp, PolyMesh.getCPtr(mesh), mesh);
    }

    public static boolean mergePolyMeshes(Context ctx, PolyMesh polyMesh1, PolyMesh polyMesh2) {
        SWIGTYPE_p_p_rcPolyMesh meshes = new SWIGTYPE_p_p_rcPolyMesh(PolyMesh.getCPtr(polyMesh1), true);
        return RecastJNI.rcMergePolyMeshes(Context.getCPtr(ctx), ctx, SWIGTYPE_p_p_rcPolyMesh.getCPtr(meshes), 1, PolyMesh.getCPtr(polyMesh1), polyMesh2);
    }

    public static boolean buildPolyMeshDetail(Context ctx, PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError, PolyMeshDetail dmesh) {
        return RecastJNI.rcBuildPolyMeshDetail(Context.getCPtr(ctx), ctx, PolyMesh.getCPtr(mesh), mesh, CompactHeightfield.getCPtr(chf), chf, sampleDist, sampleMaxError, PolyMeshDetail.getCPtr(dmesh), dmesh);
    }

    public static boolean copyPolyMesh(Context ctx, PolyMesh src, PolyMesh dst) {
        return RecastJNI.rcCopyPolyMesh(Context.getCPtr(ctx), ctx, PolyMesh.getCPtr(src), src, PolyMesh.getCPtr(dst), dst);
    }

    public static boolean mergePolyMeshDetails(Context ctx, PolyMeshDetail source, PolyMeshDetail destination) {
        SWIGTYPE_p_p_rcPolyMeshDetail mesh = new SWIGTYPE_p_p_rcPolyMeshDetail(PolyMeshDetail.getCPtr(source), true);
        return RecastJNI.rcMergePolyMeshDetails(Context.getCPtr(ctx), ctx, SWIGTYPE_p_p_rcPolyMeshDetail.getCPtr(mesh), 1, PolyMeshDetail.getCPtr(destination), destination);
    }

    /*public static void allocSetCustom(SWIGTYPE_p_f_int_enum_rcAllocHint__p_void allocFunc, SWIGTYPE_p_f_p_void__void freeFunc) {
     RecastJNI.rcAllocSetCustom(SWIGTYPE_p_f_int_enum_rcAllocHint__p_void.getCPtr(allocFunc), SWIGTYPE_p_f_p_void__void.getCPtr(freeFunc));
     }

     public static SWIGTYPE_p_void alloc(int size, AllocHint hint) {
     long cPtr = RecastJNI.rcAlloc(size, hint.swigValue());
     return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
     }

     public static void free(SWIGTYPE_p_void ptr) {
     RecastJNI.rcFree(SWIGTYPE_p_void.getCPtr(ptr));
     }*/
}
