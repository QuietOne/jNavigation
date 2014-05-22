package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.BoundedField;
import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.Heightfield;
import com.jme3.ai.recast.structures.sub.HeightfieldLayerSet;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class HeightfieldBuilder implements Builder {

    Heightfield heightfield;

    @Override
    public BoundedField build() {
        return heightfield;
    }

    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Calculates the bounding box of an array of vertices.
     *
     * @param verts An array of vertices. [(x, y, z) * nv]
     *
     */
    private native void calculateBounds(float[] verts);

    /**
     * Calculates the grid size based on the bounding box and grid cell size.
     */
    private native void calculateGridSize();

    /**
     * Initializes a new heightfield.
     *
     * @return
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters.
     *
     * See Also rcAllocHeightfield, Heightfield
     */
    private native boolean createHeightfield();

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
     *
     * Only sets the aread id's for the walkable triangles. Does not alter the
     * area id's for unwalkable triangles.
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters.
     *
     * See Also Heightfield, rcClearUnwalkableTriangles, rcRasterizeTriangles
     */
    private native void markWalkableTriangles(float walkableSlopeAngle, float[] verts, int nv, int[] tris, int nt, String areas);

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
    public native int getHeightFieldSpanCount();

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
     *
     * Only sets the aread id's for the unwalkable triangles. Does not alter the
     * area id's for walkable triangles.
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters. See Also Heightfield, rcClearUnwalkableTriangles,
     * rcRasterizeTriangles
     */
    public native void clearUnwalkableTriangles(float walkableSlopeAngle, float[] verts, int nv, int[] tris, int nt, String areas);

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
     * Heightfield::width > value >=0 ]
     * @param y The height index where the span is to be added. [Limits:
     * Heightfield::height > value >=0 ]
     * @param smin The minimum height of the span. [Limit: l smax] [Units: vx]
     * @param smax The maximum height of the span. [Limit: le
     * RC_SPAN_MAX_HEIGHT] [Units: vx]
     * @param area The area id of the span. [Limit: le RC_WALKABLE_AREA)
     * @param flagMergeThr The merge theshold. [Limit: >= 0] [Units: vx]
     *
     * The span addition can be set to favor flags. If the span is merged to
     * another span and the new smax is within flagMergeThr units from the
     * existing span, the span flags are merged.
     *
     * See Also Heightfield, Span.
     */
    public native void addSpan(int x, int y, short smin, short smax, char area, int flagMergeThr);

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
     *
     * No spans will be added if the triangle does not overlap the heightfield
     * grid.
     *
     * See Also Heightfield
     */
    public native void rasterizeTriangle(float[] v0, float[] v1, float[] v2, char area, Heightfield solid, int flagMergeThr);

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
     *
     * Spans will only be added for triangles that overlap the heightfield grid.
     *
     * See Also Heightfield
     */
    public native void rasterizeTriangles(float[] verts, int nv, int[] tris, String areas, int nt, Heightfield solid, int flagMergeThr);

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
     *
     * Spans will only be added for triangles that overlap the heightfield grid.
     *
     * Spans will only be added for triangles that overlap the heightfield grid.
     *
     * See Also Heightfield
     */
    public native void rasterizeTriangles(float[] verts, int nv, short[] tris, String areas, int nt, Heightfield solid, int flagMergeThr);

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
     *
     * Spans will only be added for triangles that overlap the heightfield grid.
     *
     * See Also Heightfield
     */
    public native void rasterizeTriangles(float[] verts, String areas, int nt, Heightfield solid, int flagMergeThr);

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
     *
     * Warning Will override the effect of rcFilterLedgeSpans. So if both
     * filters are used, call rcFilterLedgeSpans after calling this filter. See
     * Also Heightfield, rcConfig
     */
    public native void filterLowHangingWalkableObstacles(int walkableClimb, Heightfield solid);

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
     * walkableClimb
     *
     * See Also Heightfield, rcConfig
     */
    public native void filterLedgeSpans(int walkableHeight, int walkableClimb, Heightfield solid);

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
     *
     * For this filter, the clearance above the span is the distance from the
     * span's maximum to the next higher span's minimum. (Same grid column.)
     *
     * See Also Heightfield, rcConfig
     */
    public native void filterWalkableLowHeightSpans(int walkableHeight, Heightfield solid);

    /**
     * Builds a layer set from the specified compact heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param chf A fully built compact heightfield.
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     *
     * WARNING: out
     * @param lset The resulting layer set. (Must be pre-allocated.)
     * @return True if the operation completed successfully. See the rcConfig
     * documentation for more information on the configuration parameters.
     *
     * See Also rcAllocHeightfieldLayerSet, CompactHeightfield,
     * HeightfieldLayerSet, rcConfig
     */
    public native boolean rcBuildHeightfieldLayers(CompactHeightfield chf, int borderSize, int walkableHeight, HeightfieldLayerSet lset);
}
