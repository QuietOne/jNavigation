package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.BoundedField;
import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.sub.CompactSpan;
import com.jme3.ai.recast.structures.Heightfield;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class CompactHeightfieldBuilder implements Builder{

    CompactHeightfield compactHeightfield;
    
    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoundedField build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        /**
     * Builds a compact heightfield representing open space, from a heightfield
     * representing solid space.
     *
     * WARNING [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     * @param walkableClimb Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx]
     * @param hf The heightfield to be compacted.
     *
     * WARNING: out
     * @param chf The resulting compact heightfield. (Must be pre-allocated.)
     * @return True if the operation completed successfully.
     *
     * This is just the beginning of the process of fully building a compact
     * heightfield. Various filters may be applied applied, then the distance
     * field and regions built. E.g: rcBuildDistanceField and rcBuildRegions
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters.
     *
     * See Also rcAllocCompactHeightfield, Heightfield, CompactHeightfield,
     * rcConfig
     */
    public native boolean rcBuildCompactHeightfield(int walkableHeight, int walkableClimb, Heightfield hf, CompactHeightfield chf);

    /**
     * Erodes the walkable area within the heightfield by the specified radius.
     *
     * @param radius The radius of erosion. [Limits: 255> value > 0] [Units: vx]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param chf The populated compact heightfield to erode.
     * @return True if the operation completed successfully. Basically, any
     * spans that are closer to a boundary or obstruction than the specified
     * radius are marked as unwalkable.
     *
     * This method is usually called immediately after the heightfield has been
     * built.
     *
     * See Also CompactHeightfield, rcBuildCompactHeightfield,
     * rcConfig::walkableRadius
     */
    public native boolean rcErodeWalkableArea(int radius, CompactHeightfield chf);

    /**
     * Applies a median filter to walkable area types (based on area id),
     * removing noise.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     * @return True if the operation completed successfully. This filter is
     * usually applied after applying area id's using functions such as
     * rcMarkBoxArea, rcMarkConvexPolyArea, and rcMarkCylinderArea.
     *
     * See Also CompactHeightfield
     */
    public native boolean rcMedianFilterWalkableArea(CompactHeightfield chf);

    /**
     * Applies an area id to all spans within the specified bounding box.
     *
     * (AABB)
     *
     * @param bmin The minimum of the bounding box. [(x, y, z)]
     * @param bmax The maximum of the bounding box. [(x, y, z)]
     * @param areaId The area id to apply. [Limit: le RC_WALKABLE_AREA]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     *
     * The value of spacial parameters are in world units.
     *
     * See Also CompactHeightfield, rcMedianFilterWalkableArea
     */
    public native void rcMarkBoxArea(float[] bmin, float[] bmax, char areaId, CompactHeightfield chf);

    /**
     * Applies the area id to the all spans within the specified convex polygon.
     *
     * @param verts The vertices of the polygon [Fomr: (x, y, z) * nverts]
     * @param nverts The number of vertices in the polygon.
     * @param hmin The height of the base of the polygon.
     * @param hmax The height of the top of the polygon.
     * @param areaId The area id to apply. [Limit: le RC_WALKABLE_AREA]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     *
     * The value of spacial parameters are in world units.
     *
     * The y-values of the polygon vertices are ignored. So the polygon is
     * effectively projected onto the xz-plane at hmin, then extruded to hmax.
     *
     * See Also CompactHeightfield, rcMedianFilterWalkableArea
     */
    public native void rcMarkConvexPolyArea(float[] verts, int nverts, float hmin, float hmax, char areaId, CompactHeightfield chf);

    /**
     * Helper function to offset voncex polygons for rcMarkConvexPolyArea.
     *
     * @param verts The vertices of the polygon [Form: (x, y, z) * nverts]
     * @param nverts The number of vertices in the polygon.
     * @param offset ???
     * @param maxOutVerts The max number of vertices that can be stored to
     * outVerts.
     *
     * WARNING: out
     * @param outVerts The offset vertices (should hold up to 2 * nverts) [Form:
     * (x, y, z) * return value]
     * @return Number of vertices in the offset polygon or 0 if too few vertices
     * in outVerts.
     */
    public native int rcOffsetPoly(float[] verts, int nverts, float offset, float[] outVerts, int maxOutVerts);

    /**
     * Applies the area id to all spans within the specified cylinder.
     *
     * @param pos The center of the base of the cylinder. [Form: (x, y, z)]
     * @param r The radius of the cylinder.
     * @param h The height of the cylinder.
     * @param areaId The area id to apply. [Limit: le RC_WALKABLE_AREA]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     *
     * The value of spacial parameters are in world units.
     *
     * See Also CompactHeightfield, rcMedianFilterWalkableArea
     */
    public native void rcMarkCylinderArea(float[] pos, float r, float h, char areaId, CompactHeightfield chf);

    /**
     * Builds the distance field for the specified compact heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     * @return True if the operation completed successfully. This is usually the
     * second to the last step in creating a fully built compact heightfield.
     * This step is required before regions are built using rcBuildRegions or
     * rcBuildRegionsMonotone.
     *
     * After this step, the distance data is available via the
     * CompactHeightfield::maxDistance and CompactHeightfield::dist fields.
     *
     * See Also CompactHeightfield, rcBuildRegions, rcBuildRegionsMonotone
     */
    public native boolean rcBuildDistanceField(CompactHeightfield chf);

    /**
     * Builds region data for the heightfield using watershed partitioning.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     *
     * WARNING: in
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param minRegionArea The minimum number of cells allowed to form isolated
     * island areas. [Limit: >=0] [Units: vx].
     * @param mergeRegionArea Any regions with a span count smaller than this
     * value will, if possible, be merged with larger regions. [Limit: >=0]
     * [Units: vx]
     * @return True if the operation completed successfully. Non-null regions
     * will consist of connected, non-overlapping walkable spans that form a
     * single contour. Contours will form simple polygons.
     *
     * If multiple regions form an area that is smaller than minRegionArea, then
     * all spans will be re-assigned to the zero (null) region.
     *
     * Watershed partitioning can result in smaller than necessary regions,
     * especially in diagonal corridors. mergeRegionArea helps reduce
     * unecessarily small regions.
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters.
     *
     * The region data will be available via the CompactHeightfield::maxRegions
     * and CompactSpan::reg fields.
     *
     * Warning The distance field must be created using rcBuildDistanceField
     * before attempting to build regions. See Also CompactHeightfield,
     * CompactSpan, rcBuildDistanceField, rcBuildRegionsMonotone, rcConfig
     */
    public native boolean rcBuildRegions(CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea);

    /**
     * Builds region data for the heightfield using simple monotone
     * partitioning.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     * @param chf A populated compact heightfield.
     *
     * WARNING: in
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param minRegionArea The minimum number of cells allowed to form isolated
     * island areas. [Limit: >=0] [Units: vx].
     * @param mergeRegionArea Any regions with a span count smaller than this
     * value will, if possible, be merged with larger regions. [Limit: >=0]
     * [Units: vx]
     * @return True if the operation completed successfully. Non-null regions
     * will consist of connected, non-overlapping walkable spans that form a
     * single contour. Contours will form simple polygons.
     *
     * If multiple regions form an area that is smaller than minRegionArea, then
     * all spans will be re-assigned to the zero (null) region.
     *
     * Partitioning can result in smaller than necessary regions.
     * mergeRegionArea helps reduce unecessarily small regions.
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters.
     *
     * The region data will be available via the CompactHeightfield::maxRegions
     * and CompactSpan::reg fields.
     *
     * Warning The distance field must be created using rcBuildDistanceField
     * before attempting to build regions. See Also CompactHeightfield,
     * CompactSpan, rcBuildDistanceField, rcBuildRegionsMonotone, rcConfig
     */
    public native boolean rcBuildRegionsMonotone(CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea);

    /**
     * Sets the neighbor connection data for the specified direction.
     *
     * @param s The span to update.
     * @param dir The direction to set. [Limits: 0 le value l 4]
     * @param i The index of the neighbor span.
     *
     * This function is used by the build process. It is rarely of use to end
     * users.
     *
     * See Also CompactHeightfield, CompactSpan
     */
    public native void rcSetCon(CompactSpan s, int dir, int i);

    /**
     * Gets neighbor connection data for the specified direction.
     *
     * @param s The span to check.
     * @param dir The direction to check. [Limits: 0 le value l 4]
     * @return The neighbor connection data for the specified direction, or
     * RC_NOT_CONNECTED if there is no connection. Can be used to locate
     * neighbor spans in a compact heightfield. See the CompactHeightfield
     * documentation for details on its use.
     *
     * See Also CompactHeightfield, CompactSpan
     */
    public native int rcGetCon(CompactSpan s, int dir);

    /**
     * Gets the standard width (x-axis) offset for the specified direction.
     *
     * @param dir The direction. [Limits: 0 le value l 4]
     * @return The width offset to apply to the current cell position to move in
     * the direction. The value of dir will be automatically wrapped. So a value
     * of 6 will be interpreted as 2.
     *
     * See the CompactHeightfield documentation for usage details.
     */
    public native int rcGetDirOffsetX(int dir);

    /**
     * Gets the standard height (z-axis) offset for the specified direction.
     *
     * @param dir The direction. [Limits: 0 le value l 4]
     * @return The height offset to apply to the current cell position to move
     * in the direction. The value of dir will be automatically wrapped. So a
     * value of 6 will be interpreted as 2.
     *
     * See the CompactHeightfield documentation for usage details.
     */
    public native int rcGetDirOffsetY(int dir);
}
