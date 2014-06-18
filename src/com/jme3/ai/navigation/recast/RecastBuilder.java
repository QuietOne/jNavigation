package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.detour.Detour;
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
 * Class for all Recast builds.
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

    /**
     * Calculates the bounding box of an array of vertices.
     *
     * @param vertices An array of vertices.
     * @return The minimum bounds of the AABB.
     */
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

    /**
     * Calculates the bounding box of an array of vertices.
     *
     * @param vertices An array of vertices.
     * @return The maximum bounds of the AABB.
     */
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
     * Calculates the grid height based on the bounding box and grid cell size.
     *
     * @param minBounds The minimum bounds of the AABB.
     * @param maxBounds The maximum bounds of the AABB.
     * @param cellSize The xz-plane cell size. [Limit: > 0] [Units: wu]
     * @return The height along the z-axis. [Limit: >= 0] [Units: vx]
     *
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
     * Calculates the grid width based on the bounding box and grid cell size.
     *
     * @param minBounds The minimum bounds of the AABB.
     * @param maxBounds The maximum bounds of the AABB.
     * @param cellSize The xz-plane cell size. [Limit: > 0] [Units: wu]
     * @return The width along the x-axis. [Limit: >= 0] [Units: vx]
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

    /**
     * Initializes a new heightfield.
     *
     * @param ctx The build context to use during the operation.
     * @param hf The allocated heightfield to initialize.
     * @param width The width of the field along the x-axis. [Limit: >= 0]
     * [Units: vx]
     * @param height The height of the field along the z-axis. [Limit: >= 0]
     * [Units: vx]
     * @param minBounds The minimum bounds of the field's AABB. [(x, y, z)]
     * [Units: wu]
     * @param maxBounds The maximum bounds of the field's AABB. [(x, y, z)]
     * [Units: wu]
     * @param cs The xz-plane cell size to use for the field. [Limit: > 0]
     * [Units: wu]
     * @param ch The y-axis cell size to use for field. [Limit: > 0] [Units: wu]
     * @return
     */
    public static boolean createHeightfield(Context ctx, Heightfield hf, int width, int height, Vector3f minBounds, Vector3f maxBounds, float cs, float ch) {
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(minBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(maxBounds);
        return RecastJNI.rcCreateHeightfield(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf, width, height, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), cs, ch);
    }

    /**
     * Initializes a new heightfield.
     *
     * @param ctx The build context to use during the operation.
     * @param hf The allocated heightfield to initialize.
     * @param config
     * @return
     */
    public static boolean createHeightfield(Context ctx, Heightfield hf, Config config) {
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(config.getMinBounds());
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(config.getMaxBounds());
        int width = config.getWidth();
        int height = config.getHeight();
        float cs = config.getCellSize();
        float ch = config.getCellHeight();
        return RecastJNI.rcCreateHeightfield(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf, width, height, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), cs, ch);
    }

    /**
     * - not tested (not sure about area.length)
     *
     * Sets the area id of all triangles with a slope below the specified value
     * to RC_WALKABLE_AREA.
     *
     * @see RecastBuilder#RC_WALKABLE_AREA()
     * @param ctx The build context to use during the operation.
     * @param walkableSlopeAngle The maximum slope that is considered walkable.
     * [Limits: 90> value >= 0] [Units: Degrees]
     * @param vertices The vertices.
     * @param triangles The triangle vertex indices. [(vert A, vertB, vertC)]
     * @return The triangle area ids. [Length: >= number of triangles]
     */
    public static char[] markWalkableTriangles(Context ctx, float walkableSlopeAngle, Vector3f[] vertices, int[] triangles) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(triangles);
        SWIGTYPE_p_unsigned_char area = new SWIGTYPE_p_unsigned_char();
        int nt = triangles.length / 3;
        RecastJNI.rcMarkWalkableTriangles(Context.getCPtr(ctx), ctx, walkableSlopeAngle, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), nt, SWIGTYPE_p_unsigned_char.getCPtr(area));
        return Converter.convertToChars(area, nt);
    }

    /**
     * Sets the area id of all triangles with a slope greater than or equal to
     * the specified value to RC_NULL_AREA. Only sets the aread id's for the
     * unwalkable triangles. Does not alter the area id's for walkable
     * triangles.
     *
     * @see RecastBuilder#RC_NULL_AREA()
     * @param ctx The build context to use during the operation.
     * @param walkableSlopeAngle The maximum slope that is considered walkable.
     * [Limits: 90> value >= 0] [Units: Degrees]
     * @param vertices The vertices.
     * @param triangles The triangle vertex indices. [(vertA, vertB, vertC)]
     * @return The triangle area ids. [Length: >= number of triangles]
     */
    public static char[] clearUnwalkableTriangles(Context ctx, float walkableSlopeAngle, Vector3f[] vertices, int[] triangles) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(triangles);
        int nt = triangles.length / 3;
        SWIGTYPE_p_unsigned_char area = new SWIGTYPE_p_unsigned_char();
        RecastJNI.rcClearUnwalkableTriangles(Context.getCPtr(ctx), ctx, walkableSlopeAngle, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), nt, SWIGTYPE_p_unsigned_char.getCPtr(area));
        return Converter.convertToChars(area, nt);
    }

    /**
     * Adds a span to the specified heightfield. The span addition can be set to
     * favor flags. If the span is merged to another span and the new smax is
     * within flagMergeThr units from the existing span, the span flags are
     * merged.
     *
     * @param ctx The build context to use during the operation.
     * @param hf An initialized heightfield.
     * @param x The width index where the span is to be added. [Limits:
     * Heightfield#width > value >= 0 ]
     * @see Heightfield#getWidth()
     * @param y The height index where the span is to be added. [Limits:
     * Heightfield#height > value >=0 ]
     * @see Heightfield#getHeight()
     * @param minSpanLimit The minimum height of the span. [Limit: smaller than
     * maxSpan] [Units: vx]
     * @param maxSpanLimit The maximum height of the span. [Limit: smaller than
     * RC_SPAN_MAX_HEIGHT] [Units: vx]
     * @see RecastBuilder#RC_SPAN_HEIGHT_BITS()
     * @param area The area id of th e span. [Limit: smaller than
     * RC_WALKABLE_AREA)
     * @see RecastBuilder#RC_WALKABLE_AREA()
     * @param flagMerge Thr The merge theshold. [Limit: >= 0] [Units: vx]
     */
    public static void addSpan(Context ctx, Heightfield hf, int x, int y, int minSpanLimit, int maxSpanLimit, short area, int flagMergeThr) {
        RecastJNI.rcAddSpan(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf, x, y, minSpanLimit, maxSpanLimit, area, flagMergeThr);
    }

    /**
     * Rasterizes a triangle into the specified heightfield. No spans will be
     * added if the triangle does not overlap the heightfield grid.
     *
     * @param ctx The build context to use during the operation.
     * @param vertex0 Triangle vertex 0
     * @param vertex1 Triangle vertex 1
     * @param vertex2 Triangle vertex 2
     * @param area The area id of the triangle. [Limit: smaller
     * RC_WALKABLE_AREA]
     * @param solid An initialized heightfield.
     * @param flagMergeThr The distance where the walkable flag is favored over
     * the non-walkable flag. [Limit: >= 0] [Units: vx]
     */
    public static void rasterizeTriangle(Context ctx, Vector3f vertex0, Vector3f vertex1, Vector3f vertex2, short area, Heightfield solid, int flagMergeThr) {
        SWIGTYPE_p_float v0 = Converter.convertToSWIGTYPE_p_float(vertex0);
        SWIGTYPE_p_float v1 = Converter.convertToSWIGTYPE_p_float(vertex1);
        SWIGTYPE_p_float v2 = Converter.convertToSWIGTYPE_p_float(vertex2);
        RecastJNI.rcRasterizeTriangle__SWIG_0(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(v0), SWIGTYPE_p_float.getCPtr(v1), SWIGTYPE_p_float.getCPtr(v2), area, Heightfield.getCPtr(solid), solid, flagMergeThr);
    }

    /**
     * Rasterizes an indexed triangle mesh into the specified heightfield. Spans
     * will only be added for triangles that overlap the heightfield grid.
     *
     * @param ctx The build context to use during the operation.
     * @param vertices The vertices.
     * @param triangles The triangle indices. [(vertA, vertB, vertC)]
     * @param areas The area id's of the triangles. [Limit: smaller than
     * RC_WALKABLE_AREA] Size must be the same as for triangles.
     * @param solid An initialized heightfield.
     * @param flagMergeThr The distance where the walkable flag is favored over
     * the non-walkable flag. [Limit: >= 0] [Units: vx]
     *
     */
    public static void rasterizeTriangles(Context ctx, Vector3f[] vertices, int[] triangles, char[] areas, Heightfield solid, int flagMergeThr) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nv = vertices.length;
        SWIGTYPE_p_int tris = Converter.convertToSWIGTYPE_p_int(triangles);
        int nt = triangles.length / 3;
        SWIGTYPE_p_unsigned_char area = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcRasterizeTriangles__SWIG_0(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(verts), nv, SWIGTYPE_p_int.getCPtr(tris), SWIGTYPE_p_unsigned_char.getCPtr(area), nt, Heightfield.getCPtr(solid), solid, flagMergeThr);
    }

    /**
     * Marks non-walkable spans as walkable if their maximum is within
     * walkableClimp of a walkable neihbor. Allows the formation of walkable
     * regions that will flow over low lying objects such as curbs, and up
     * structures such as stairways.
     *
     * Two neighboring spans are walkable if:
     * <code>
     *  walkableClimb > FastMath.abs(currentSpan.getMaxSpan() - neighborSpan.getMaxSpan)
     * </code>
     *
     * Warning: Will override the effect of filterLedgeSpans. So if both filters
     * are used, call filterLedgeSpans after calling this filter.
     *
     * @see
     * RecastBuilder#filterLedgeSpans(com.jme3.ai.navigation.recast.Context,
     * int, int, com.jme3.ai.navigation.recast.Heightfield)
     *
     * @param ctx The build context to use during the operation.
     * @param walkableClimb Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx]
     * @param solid A fully built heightfield. (All spans have been added.)
     */
    public static void filterLowHangingWalkableObstacles(Context ctx, int walkableClimb, Heightfield solid) {
        RecastJNI.rcFilterLowHangingWalkableObstacles(Context.getCPtr(ctx), ctx, walkableClimb, Heightfield.getCPtr(solid), solid);
    }

    /**
     * Marks spans that are ledges as not-walkable.
     *
     * A ledge is a span with one or more neighbors whose maximum is further
     * away than walkableClimb from the current span's maximum. This method
     * removes the impact of the overestimation of conservative voxelization so
     * the resulting mesh will not have regions hanging in the air over ledges.
     * A span is a ledge if:
     * <code>
     *  FastMath.abs(currentSpan.getMaxSpan() - neighborSpan.getMaxSpan) > walkableClimb
     * </code>
     *
     * @param ctx The build context to use during the operation.
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     * @param walkableClimb Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx]
     * @param solid A fully built heightfield. (All spans have been added.)
     */
    public static void filterLedgeSpans(Context ctx, int walkableHeight, int walkableClimb, Heightfield solid) {
        RecastJNI.rcFilterLedgeSpans(Context.getCPtr(ctx), ctx, walkableHeight, walkableClimb, Heightfield.getCPtr(solid), solid);
    }

    /**
     * Marks walkable spans as not walkable if the clearence above the span is
     * less than the specified height. For this filter, the clearance above the
     * span is the distance from the span's maximum to the next higher span's
     * minimum. (Same grid column.)
     *
     * @param ctx The build context to use during the operation.
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     * @param solid A fully built heightfield. (All spans have been added.)
     */
    public static void filterWalkableLowHeightSpans(Context ctx, int walkableHeight, Heightfield solid) {
        RecastJNI.rcFilterWalkableLowHeightSpans(Context.getCPtr(ctx), ctx, walkableHeight, Heightfield.getCPtr(solid), solid);
    }

    /**
     * Returns the number of spans contained in the specified heightfield.
     *
     * @param ctx The build context to use during the operation.
     * @param hf An initialized heightfield.
     * @return The number of spans in the heightfield.
     */
    public static int getHeightFieldSpanCount(Context ctx, Heightfield hf) {
        return RecastJNI.rcGetHeightFieldSpanCount(Context.getCPtr(ctx), ctx, Heightfield.getCPtr(hf), hf);
    }

    /**
     * Builds a compact heightfield representing open space, from a heightfield
     * representing solid space.
     *
     * @param ctx The build context to use during the operation.
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     * @param walkableClimb Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx]
     * @param hf The heightfield to be compacted
     * @param chf The resulting compact heightfield. (Must be pre-allocated.)
     * @return True if the operation completed successfully.
     */
    public static boolean buildCompactHeightfield(Context ctx, int walkableHeight, int walkableClimb, Heightfield hf, CompactHeightfield chf) {
        return RecastJNI.rcBuildCompactHeightfield(Context.getCPtr(ctx), ctx, walkableHeight, walkableClimb, Heightfield.getCPtr(hf), hf, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Erodes the walkable area within the heightfield by the specified radius.
     *
     * Basically, any spans that are closer to a boundary or obstruction than
     * the specified radius are marked as unwalkable.
     *
     * This method is usually called immediately after the heightfield has been
     * built.
     *
     * @param ctx The build context to use during the operation.
     * @param radius The radius of erosion. [Limits: 255> value > 0] [Units: vx]
     * @param chf The populated compact heightfield to erode.
     * @return True if the operation completed successfully.
     */
    public static boolean erodeWalkableArea(Context ctx, int radius, CompactHeightfield chf) {
        return RecastJNI.rcErodeWalkableArea(Context.getCPtr(ctx), ctx, radius, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Applies a median filter to walkable area types (based on area id),
     * removing noise. This filter is usually applied after applying area id's
     * using functions such as markBoxArea, markConvexPolyArea, and
     * markCylinderArea.
     *
     * @see RecastBuilder#markBoxArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f, com.jme3.math.Vector3f, short,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     * @see
     * RecastBuilder#markConvexPolyArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f[], float, float, short,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     * @see
     * RecastBuilder#markCylinderArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f, float, float, short,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     * @return True if the operation completed successfully.
     */
    public static boolean medianFilterWalkableArea(Context ctx, CompactHeightfield chf) {
        return RecastJNI.rcMedianFilterWalkableArea(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Applies an area id to all spans within the specified bounding box. The
     * value of spacial parameters are in world units.
     *
     * @param ctx The build context to use during the operation.
     * @param minBounds The minimum of the bounding box.
     * @param maxBounds The maximum of the bounding box.
     * @param areaId The area id to apply. [Limit: smaller than
     * RC_WALKABLE_AREA]
     * @param chf A populated compact heightfield.
     * @see RecastBuilder#RC_WALKABLE_AREA()
     */
    public static void markBoxArea(Context ctx, Vector3f minBounds, Vector3f maxBounds, short areaId, CompactHeightfield chf) {
        SWIGTYPE_p_float bmin = Converter.convertToSWIGTYPE_p_float(minBounds);
        SWIGTYPE_p_float bmax = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcMarkBoxArea(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), areaId, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Applies the area id to the all spans within the specified convex polygon.
     * The value of spacial parameters are in world units.
     *
     * The y-values of the polygon vertices are ignored. So the polygon is
     * effectively projected onto the xz-plane at hmin, then extruded to hmax.
     *
     * @param ctx The build context to use during the operation.
     * @param vertices The vertices of the polygon.
     * @param minHeight The height of the base of the polygon.
     * @param maxHeight The height of the top of the polygon.
     * @param areaId The area id to apply. [Limit: smaller than
     * RC_WALKABLE_AREA]
     * @param chf A populated compact heightfield.
     */
    public static void markConvexPolyArea(Context ctx, Vector3f[] vertices, float minHeight, float maxHeight, short areaId, CompactHeightfield chf) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        RecastJNI.rcMarkConvexPolyArea(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(verts), nverts, minHeight, maxHeight, areaId, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Helper function to offset voncex polygons for markConvexPolyArea.
     *
     * @param vertices The vertices of the polygon.
     * @param offset
     * @param maxOutVerts The max number of vertices that can be stored to
     * returning vertices.
     * @return The offset vertices (should hold up to 2 * number of vertices)
     */
    public static Vector3f[] offsetPoly(Vector3f[] vertices, float offset, int maxOutVerts) {
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        FloatArray array = new FloatArray(maxOutVerts);
        SWIGTYPE_p_float outVerts = array.cast();
        int num = RecastJNI.rcOffsetPoly(SWIGTYPE_p_float.getCPtr(verts), nverts, offset, SWIGTYPE_p_float.getCPtr(outVerts), maxOutVerts);
        array = new FloatArray(SWIGTYPE_p_float.getCPtr(outVerts), false);
        return Converter.convertToVector3f(FloatArray.getCPtr(array), num);
    }

    /**
     * Applies the area id to all spans within the specified cylinder. The value
     * of spacial parameters are in world units.
     *
     * @param ctx The build context to use during the operation.
     * @param position The center of the base of the cylinder.
     * @param radius The radius of the cylinder.
     * @param height The height of the cylinder.
     * @param areaId The area id to apply. [Limit: smaller than
     * RC_WALKABLE_AREA]
     * @param chf A populated compact heightfield.
     */
    public static void markCylinderArea(Context ctx, Vector3f position, float radius, float height, short areaId, CompactHeightfield chf) {
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.rcMarkCylinderArea(Context.getCPtr(ctx), ctx, SWIGTYPE_p_float.getCPtr(pos), radius, height, areaId, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Builds the distance field for the specified compact heightfield. This is
     * usually the second to the last step in creating a fully built compact
     * heightfield. This step is required before regions are built using
     * buildRegions or buildRegionsMonotone.
     *
     * After this step, the distance data is available via the
     * CompactHeightfield.maxDistance and CompactHeightfield.distances fields.
     *
     * @see RecastBuilder#buildRegions(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     * @see
     * RecastBuilder#buildRegionsMonotone(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     * @see CompactHeightfield#getMaxDistance()
     * @see CompactHeightfield#getDistances()
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     * @return True if the operation completed successfully.
     */
    public static boolean buildDistanceField(Context ctx, CompactHeightfield chf) {
        return RecastJNI.rcBuildDistanceField(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf);
    }

    /**
     * Builds region data for the heightfield using watershed partitioning.
     * Non-null regions will consist of connected, non-overlapping walkable
     * spans that form a single contour. Contours will form simple polygons.
     *
     * If multiple regions form an area that is smaller than minRegionArea, then
     * all spans will be re-assigned to the zero (null) region.
     *
     * Watershed partitioning can result in smaller than necessary regions,
     * especially in diagonal corridors. mergeRegionArea helps reduce
     * unecessarily small regions. The region data will be available via the
     * CompactHeightfield.maxRegions and CompactSpan.regionID fields.
     *
     * @see CompactHeightfield#getMaxRegions()
     * @see CompactSpan#getRegionID()
     *
     * The distance field must be created using buildDistanceField before
     * attempting to build regions.
     * @see
     * RecastBuilder#buildDistanceField(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param minRegionArea The minimum number of cells allowed to form isolated
     * island areas. [Limit: >=0] [Units: vx].
     * @param mergeRegionArea Any regions with a span count smaller than this
     * value will, if possible, be merged with larger regions. [Limit: >=0]
     * [Units: vx]
     *
     * @return True if the operation completed successfully.
     */
    public static boolean buildRegions(Context ctx, CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea) {
        return RecastJNI.rcBuildRegions(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, borderSize, minRegionArea, mergeRegionArea);
    }

    /**
     * Builds region data for the heightfield using simple monotone
     * partitioning. Non-null regions will consist of connected, non-overlapping
     * walkable spans that form a single contour. Contours will form simple
     * polygons.
     *
     * If multiple regions form an area that is smaller than minRegionArea, then
     * all spans will be re-assigned to the zero (null) region.
     *
     * Partitioning can result in smaller than necessary regions.
     * mergeRegionArea helps reduce unecessarily small regions.The region data
     * will be available via the CompactHeightfield.maxRegions and
     * CompactSpan.regionID fields.
     *
     * @see CompactHeightfield#getMaxRegions()
     * @see CompactSpan#getRegionID()
     *
     * The distance field must be created using buildDistanceField before
     * attempting to build regions.
     * @see
     * RecastBuilder#buildDistanceField(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param minRegionArea The minimum number of cells allowed to form isolated
     * island areas. [Limit: >=0] [Units: vx].
     * @param mergeRegionArea Any regions with a span count smaller than this
     * value will, if possible, be merged with larger regions. [Limit: >=0]
     * [Units: vx]
     *
     * @return True if the operation completed successfully.
     */
    public static boolean buildRegionsMonotone(Context ctx, CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea) {
        return RecastJNI.rcBuildRegionsMonotone(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, borderSize, minRegionArea, mergeRegionArea);
    }

    /**
     * Sets the neighbor connection data for the specified direction.
     *
     * @param s The span to update.
     * @param dir The direction to check. [Limits: 4 > value >= 0]
     * @param i The index of the neighbor span.
     */
    public static void setConnection(CompactSpan s, int dir, int i) {
        RecastJNI.rcSetCon(CompactSpan.getCPtr(s), s, dir, i);
    }

    /**
     * Gets neighbor connection data for the specified direction. Can be used to
     * locate neighbor spans in a compact heightfield.
     *
     * @see CompactHeightfield
     *
     * @param s The span to check.
     * @param dir The direction to check. [Limits: 4 > value >= 0]
     *
     * @return The neighbor connection data for the specified direction, or
     * RC_NOT_CONNECTED if there is no connection.
     * @see RecastBuilder#RC_NOT_CONNECTED()
     */
    public static int getConnection(CompactSpan s, int dir) {
        return RecastJNI.rcGetCon(CompactSpan.getCPtr(s), s, dir);
    }

    /**
     * Gets the standard width (x-axis) offset for the specified direction. The
     * value of dir will be automatically wrapped. So a value of 6 will be
     * interpreted as 2.
     *
     * @param dir The direction to check. [Limits: 4 > value >= 0]
     * @return The width offset to apply to the current cell position to move in
     * the direction.
     */
    public static int getDirectionOffsetX(int dir) {
        return RecastJNI.rcGetDirOffsetX(dir);
    }

    /**
     * Gets the standard height (z-axis) offset for the specified direction. The
     * value of dir will be automatically wrapped. So a value of 6 will be
     * interpreted as 2.
     *
     * @param dir The direction to check. [Limits: 4 > value >= 0]
     * @return The height offset to apply to the current cell position to move
     * in the direction.
     */
    public static int getDirectionOffsetY(int dir) {
        return RecastJNI.rcGetDirOffsetY(dir);
    }

    /**
     * Builds a layer set from the specified compact heightfield.
     *
     * @param ctx The build context to use during the operation.
     * @param chf A fully built compact heightfield.
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     * @param lset The resulting layer set. (Must be pre-allocated.)
     * @return True if the operation completed successfully.
     */
    public static boolean buildHeightfieldLayers(Context ctx, CompactHeightfield chf, int borderSize, int walkableHeight, HeightfieldLayerSet lset) {
        return RecastJNI.rcBuildHeightfieldLayers(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, borderSize, walkableHeight, HeightfieldLayerSet.getCPtr(lset), lset);
    }

    /**
     * Builds a contour set from the region outlines in the provided compact
     * heightfield.
     *
     * The raw contours will match the region outlines exactly. The maxError and
     * maxEdgeLen parameters control how closely the simplified contours will
     * match the raw contours.
     *
     * Simplified contours are generated such that the vertices for portals
     * between areas match up. (They are considered mandatory vertices.)
     *
     * Setting maxEdgeLength to zero will disabled the edge length feature.
     *
     * @param ctx The build context to use during the operation.
     * @param chf A fully built compact heightfield.
     * @param maxError The maximum distance a simplfied contour's border edges
     * should deviate the original raw contour. [Limit: >=0] [Units: wu]
     * @param maxEdgeLen The maximum allowed length for contour edges along the
     * border of the mesh. [Limit: >=0] [Units: vx]
     * @param cset The resulting contour set. (Must be pre-allocated.)
     * @param flags The build flags.
     * @see BuildContoursFlags
     * @return True if the operation completed successfully.
     */
    public static boolean buildContours(Context ctx, CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset, int flags) {
        return RecastJNI.rcBuildContours__SWIG_0(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, maxError, maxEdgeLen, ContourSet.getCPtr(cset), cset, flags);
    }

    public static boolean buildContours(Context ctx, CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset) {
        return RecastJNI.rcBuildContours__SWIG_1(Context.getCPtr(ctx), ctx, CompactHeightfield.getCPtr(chf), chf, maxError, maxEdgeLen, ContourSet.getCPtr(cset), cset);
    }

    /**
     * Builds a polygon mesh from the provided contours. If the mesh data is to
     * be used to construct a Detour navigation mesh, then the upper limit must
     * be retricted to smaller than DT_VERTS_PER_POLYGON.
     *
     * @see Detour#DT_VERTS_PER_POLYGON()
     *
     * @param ctx The build context to use during the operation.
     * @param cset A fully built contour set.
     * @param nvp The maximum number of vertices allowed for polygons generated
     * during the contour to polygon conversion process. [Limit: >= 3]
     * @param mesh The resulting polygon mesh. (Must be re-allocated.)
     * @return True if the operation completed successfully.
     */
    public static boolean buildPolyMesh(Context ctx, ContourSet cset, int nvp, PolyMesh mesh) {
        return RecastJNI.rcBuildPolyMesh(Context.getCPtr(ctx), ctx, ContourSet.getCPtr(cset), cset, nvp, PolyMesh.getCPtr(mesh), mesh);
    }

    /**
     * - needs to be upgraded to more than two mesh merging
     *
     * Merges multiple polygon meshes into a single mesh.
     *
     * @param ctx The build context to use during the operation.
     * @param polyMesh1 An array of polygon meshes to merge.
     * @param polyMesh2 The resulting polygon mesh. (Must be pre-allocated.)
     * @return True if the operation completed successfully.
     */
    public static boolean mergePolyMeshes(Context ctx, PolyMesh polyMesh1, PolyMesh polyMesh2) {
        SWIGTYPE_p_p_rcPolyMesh meshes = new SWIGTYPE_p_p_rcPolyMesh(PolyMesh.getCPtr(polyMesh1), true);
        return RecastJNI.rcMergePolyMeshes(Context.getCPtr(ctx), ctx, SWIGTYPE_p_p_rcPolyMesh.getCPtr(meshes), 1, PolyMesh.getCPtr(polyMesh1), polyMesh2);
    }

    /**
     * Builds a detail mesh from the provided polygon mesh.
     *
     * @param ctx The build context to use during the operation.
     * @param mesh A fully built polygon mesh.
     * @param chf The compact heightfield used to build the polygon mesh.
     * @param sampleDist Sets the distance to use when samping the heightfield.
     * [Limit: >=0] [Units: wu]
     * @param sampleMaxError The maximum distance the detail mesh surface should
     * deviate from heightfield data. [Limit: >=0] [Units: wu]
     * @param dmesh The resulting detail mesh. (Must be pre-allocated.)
     * @return True if the operation completed successfully.
     */
    public static boolean buildPolyMeshDetail(Context ctx, PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError, PolyMeshDetail dmesh) {
        return RecastJNI.rcBuildPolyMeshDetail(Context.getCPtr(ctx), ctx, PolyMesh.getCPtr(mesh), mesh, CompactHeightfield.getCPtr(chf), chf, sampleDist, sampleMaxError, PolyMeshDetail.getCPtr(dmesh), dmesh);
    }

    /**
     * Copies the poly mesh data from src to dst.
     *
     * @param ctx The build context to use during the operation.
     * @param src The source mesh to copy from.
     * @param dst The resulting detail mesh. (Must be pre-allocated, must be
     * empty mesh.)
     * @return True if the operation completed successfully.
     */
    public static boolean copyPolyMesh(Context ctx, PolyMesh src, PolyMesh dst) {
        return RecastJNI.rcCopyPolyMesh(Context.getCPtr(ctx), ctx, PolyMesh.getCPtr(src), src, PolyMesh.getCPtr(dst), dst);
    }

    /**
     * - needs to be upgraded to more than two mesh merging
     *
     * Merges multiple detail meshes into a single detail mesh.
     *
     * @param ctx The build context to use during the operation.
     * @param source An array of detail meshes to merge.
     * @param destination The resulting detail mesh. (Must be pre-allocated.)
     * @return True if the operation completed successfully.
     */
    public static boolean mergePolyMeshDetails(Context ctx, PolyMeshDetail source, PolyMeshDetail destination) {
        SWIGTYPE_p_p_rcPolyMeshDetail mesh = new SWIGTYPE_p_p_rcPolyMeshDetail(PolyMeshDetail.getCPtr(source), true);
        return RecastJNI.rcMergePolyMeshDetails(Context.getCPtr(ctx), ctx, SWIGTYPE_p_p_rcPolyMeshDetail.getCPtr(mesh), 1, PolyMeshDetail.getCPtr(destination), destination);
    }
}
