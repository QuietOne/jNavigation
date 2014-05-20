package com.jme3.ai.recast;

import com.jme3.ai.recast.util.SpanPool;
import com.jme3.ai.recast.util.Span;

/**
 * A dynamic heightfield representing obstructed space.
 *
 * The grid of a heightfield is layed out on the xz-plane based on the value of
 * cs. Spans exist within the grid columns with the span min/max values at
 * increments of ch from the base of the grid. The smallest possible span size
 * is (cs width) * (cs depth) * (ch height). (Which is a single voxel.)
 *
 * The standard process for buidling a heightfield is to allocate it using
 * rcAllocHeightfield, initialize it using rcCreateHeightfield, then add spans
 * using the various helper functions such as rcRasterizeTriangle.
 *
 * Building a heightfield is one of the first steps in creating a polygon mesh
 * from source geometry. After it is populated, it is used to build a
 * rcCompactHeightfield.
 *
 * Example of iterating the spans in a heightfield:
 *
 * // Where hf is a reference to an heightfield object. const float* orig =
 * hf.bmin; const float cs = hf.cs; const float ch = hf.ch; const int w =
 * hf.width; const int h = hf.height; for (int y = 0; y < h; ++y) { for (int x =
 * 0; x < w; ++x) { // Deriving the minimum corner of the grid location. float
 fx = orig[0] + x*cs; float fz = orig[2] + y*cs; // The base span in the
 column. (May be null.) const Span* s = hf.spans[x + y*w]; while (s) { //
 Detriving the minium and maximum world position of the span. float fymin =
 orig[1]+s->smin*ch; float fymax = orig[1] + s->smax*ch; // Do other things
 * with the span before moving up the column. s = s->next; } } }
 *
 * @author Tihomir Radosavljevic
 * @verstion 0.1
 */
public class Heightfield {

    /**
     * The maximum bounds in world space. [(x, y, z)].
     */
    public float[] bmax = new float[3];
    /**
     * The minimum bounds in world space. [(x, y, z)].
     */
    public float[] bmin = new float[3];

    /**
     * The height of each cell. (The minimum increment along the y-axis.)
     */
    public float ch;

    /**
     * The size of each cell. (On the xz-plane.)
     */
    public float cs;

    /**
     * The next free span.
     */
    public Span freelist;

    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    public int height;

    /**
     * Linked list of span pools.
     */
    public SpanPool pools;

    /**
     * Heightfield of spans (width*height).
     */
    public Span spans;

    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    public int width;

    /**
     * Calculates the bounding box of an array of vertices.
     *
     *
     * @param verts An array of vertices. [(x, y, z) * nv]
     * @param nv The number of vertices in the verts array.
     *
     * WARNING: out
     * @param bmin The minimum bounds of the AABB. [(x, y, z)] [Units: wu]
     * @param bmax The maximum bounds of the AABB. [(x, y, z)] [Units: wu]
     */
    public native void rcCalcBounds(float[] verts, int nv, float[] bmin, float[] bmax);

    /**
     * Calculates the grid size based on the bounding box and grid cell size.
     *
     * @param bmin The minimum bounds of the AABB. [(x, y, z)] [Units: wu]
     * @param bmax The maximum bounds of the AABB. [(x, y, z)] [Units: wu]
     * @param cs The xz-plane cell size. [Limit: > 0] [Units: wu]
     *
     * WARNING: out
     * @param w The width along the x-axis. [Limit: >= 0] [Units: vx]
     * @param h The height along the z-axis. [Limit: >= 0] [Units: vx]
     */
    public native void rcCalcGridSize(float[] bmin, float[] bmax, float cs, int[] w, int[] h);

    /**
     * Initializes a new heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     * @param hf The allocated heightfield to initialize.
     *
     * WARNING: in
     * @param width The width of the field along the x-axis. [Limit: >= 0]
     * [Units: vx]
     * @param height The height of the field along the z-axis. [Limit: >= 0]
     * [Units: vx]
     * @param bmin The minimum bounds of the field's AABB. [(x, y, z)] [Units:
     * wu]
     * @param bmax The maximum bounds of the field's AABB. [(x, y, z)] [Units:
     * wu]
     * @param cs The xz-plane cell size to use for the field. [Limit: > 0]
     * [Units: wu]
     * @param ch The y-axis cell size to use for field. [Limit: > 0] [Units: wu]
     * @return
     *
     * See the rcConfig documentation for more information on the configuration
 parameters.

 See Also rcAllocHeightfield, Heightfield
     */
    public native boolean rcCreateHeightfield(Context ctx, Heightfield hf, int width, int height, float[] bmin, float[] bmax, float cs, float ch);

    /**
     * Sets the area id of all triangles with a slope below the specified value
     * to RC_WALKABLE_AREA.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param walkableSlopeAngle The maximum slope that is considered walkable.
     * [Limits: 90 > value => 0] [Units: Degrees]
     * @param verts The vertices. [(x, y, z) * nv]
     * @param nv The number of vertices.
     * @param tris The triangle vertex indices. [(vertA, vertB, vertC) * nt]
     * @param nt The number of triangles.
     *
     * WARNING: out
     * @param areas The triangle area ids. [Length: >= nt]

 Only sets the aread id's for the walkable triangles. Does not alter the
 area id's for unwalkable triangles.

 See the rcConfig documentation for more information on the configuration
 parameters.

 See Also Heightfield, rcClearUnwalkableTriangles, rcRasterizeTriangles
     */
    public native void rcMarkWalkableTriangles(Context ctx, float walkableSlopeAngle, float[] verts, int nv, int[] tris, int nt, String areas);

    /**
     * Returns the number of spans contained in the specified heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param hf An initialized heightfield.
     * @return The number of spans in the heightfield.
     */
    public native int rcGetHeightFieldSpanCount(Context ctx, Heightfield hf);

    /**
     * Sets the area id of all triangles with a slope greater than or equal to
     * the specified value to RC_NULL_AREA.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param walkableSlopeAngle The maximum slope that is considered walkable.
     * [Limits: 90 > value => 0] [Units: Degrees]
     * @param verts The vertices. [(x, y, z) * nv]
     * @param nv The number of vertices.
     * @param tris The triangle vertex indices. [(vertA, vertB, vertC) * nt]
     * @param nt The number of triangles.
     *
     * WARNING: out
     * @param areas The triangle area ids. [Length: >= nt]

 Only sets the aread id's for the unwalkable triangles. Does not alter the
 area id's for walkable triangles.

 See the rcConfig documentation for more information on the configuration
 parameters. See Also Heightfield, rcClearUnwalkableTriangles,
 rcRasterizeTriangles
     */
    public native void rcClearUnwalkableTriangles(Context ctx, float walkableSlopeAngle, float[] verts, int nv, int[] tris, int nt, String areas);

    /**
     * Adds a span to the specified heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     * @param hf An initialized heightfield.
     *
     * WARNING: in
     * @param x The width index where the span is to be added. [Limits:
 Heightfield::width > value >=0 ]
     * @param y The height index where the span is to be added. [Limits:
 Heightfield::height > value >=0 ]
     * @param smin The minimum height of the span. [Limit: l smax] [Units: vx]
     * @param smax The maximum height of the span. [Limit: le
     * RC_SPAN_MAX_HEIGHT] [Units: vx]
     * @param area The area id of the span. [Limit: le RC_WALKABLE_AREA)
     * @param flagMergeThr The merge theshold. [Limit: >= 0] [Units: vx]

 The span addition can be set to favor flags. If the span is merged to
 another span and the new smax is within flagMergeThr units from the
 existing span, the span flags are merged.

 See Also Heightfield, Span.
     */
    public native void rcAddSpan(Context ctx, Heightfield hf, int x, int y, short smin, short smax, char area, int flagMergeThr);

    /**
     * Rasterizes a triangle into the specified heightfield.
     *
     * @param v0 Triangle vertex 0 [(x, y, z)]
     * @param v1 Triangle vertex 1 [(x, y, z)]
     * @param v2 Triangle vertex 2 [(x, y, z)]
     * @param area The area id of the triangle. [Limit: le RC_WALKABLE_AREA]
     * @param flagMergeThr The distance where the walkable flag is favored over
     * the non-walkable flag. [Limit: >= 0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid An initialized heightfield.

 No spans will be added if the triangle does not overlap the heightfield
 grid.

 See Also Heightfield
     */
    public native void rcRasterizeTriangle(Context ctx, float[] v0, float[] v1, float[] v2, char area, Heightfield solid, int flagMergeThr);

    /**
     * Rasterizes an indexed triangle mesh into the specified heightfield.
     *
     * @param verts The vertices. [(x, y, z) * nv]
     * @param nv The number of vertices.
     * @param tris The triangle indices. [(vertA, vertB, vertC) * nt]
     * @param areas The area id's of the triangles. [Limit: le RC_WALKABLE_AREA]
     * [Size: nt]
     * @param nt The number of triangles.
     * @param flagMergeThr The distance where the walkable flag is favored over
     * the non-walkable flag. [Limit: >= 0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid An initialized heightfield.

 Spans will only be added for triangles that overlap the heightfield grid.

 See Also Heightfield
     */
    public native void rcRasterizeTriangles(Context ctx, float[] verts, int nv, int[] tris, String areas, int nt, Heightfield solid, int flagMergeThr);

    /**
     * Rasterizes an indexed triangle mesh into the specified heightfield.
     *
     * @param verts The vertices. [(x, y, z) * nv]
     * @param nv The number of vertices.
     * @param tris The triangle indices. [(vertA, vertB, vertC) * nt]
     * @param areas The area id's of the triangles. [Limit: le RC_WALKABLE_AREA]
     * [Size: nt]
     * @param nt The number of triangles.
     * @param flagMergeThr The distance where the walkable flag is favored over
     * the non-walkable flag. [Limit: >= 0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid An initialized heightfield.

 Spans will only be added for triangles that overlap the heightfield grid.

 Spans will only be added for triangles that overlap the heightfield grid.

 See Also Heightfield
     */
    public native void rcRasterizeTriangles(Context ctx, float[] verts, int nv, short[] tris, String areas, int nt, Heightfield solid, int flagMergeThr);

    /**
     * Rasterizes triangles into the specified heightfield.
     *
     * @param verts The triangle vertices. [(ax, ay, az, bx, by, bz, cx, by, cx)
     * * nt]
     * @param areas The area id's of the triangles. [Limit: le RC_WALKABLE_AREA]
     * [Size: nt]
     * @param nt The number of triangles.
     * @param flagMergeThr The distance where the walkable flag is favored over
     * the non-walkable flag. [Limit: >= 0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid An initialized heightfield.

 Spans will only be added for triangles that overlap the heightfield grid.

 See Also Heightfield
     */
    public native void rcRasterizeTriangles(Context ctx, float[] verts, String areas, int nt, Heightfield solid, int flagMergeThr);

    /**
     * Marks non-walkable spans as walkable if their maximum is within
     * walkableClimp of a walkable neihbor.
     *
     * @param walkableClimb Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid A fully built heightfield. (All spans have been added.)
     *
     * Allows the formation of walkable regions that will flow over low lying
     * objects such as curbs, and up structures such as stairways.
     *
     * Two neighboring spans are walkable if: rcAbs(currentSpan.smax -
     * neighborSpan.smax) < waklableClimb

 Warning Will override the effect of rcFilterLedgeSpans. So if both
 filters are used, call rcFilterLedgeSpans after calling this filter. See
 Also Heightfield, rcConfig
     */
    public native void rcFilterLowHangingWalkableObstacles(Context ctx, int walkableClimb, Heightfield solid);

    /**
     * Marks spans that are ledges as not-walkable.
     *
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     * @param walkableClimb Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid A fully built heightfield. (All spans have been added.)
     *
     * A ledge is a span with one or more neighbors whose maximum is further
     * away than walkableClimb from the current span's maximum. This method
     * removes the impact of the overestimation of conservative voxelization so
     * the resulting mesh will not have regions hanging in the air over ledges.
     *
     * A span is a ledge if: rcAbs(currentSpan.smax - neighborSpan.smax) >
 walkableClimb

 See Also Heightfield, rcConfig
     */
    public native void rcFilterLedgeSpans(Context ctx, int walkableHeight, int walkableClimb, Heightfield solid);

    /**
     * Marks walkable spans as not walkable if the clearence above the span is
     * less than the specified height.
     *
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param solid A fully built heightfield. (All spans have been added.)

 For this filter, the clearance above the span is the distance from the
 span's maximum to the next higher span's minimum. (Same grid column.)

 See Also Heightfield, rcConfig
     */
    public native void rcFilterWalkableLowHeightSpans(Context ctx, int walkableHeight, Heightfield solid);
}
