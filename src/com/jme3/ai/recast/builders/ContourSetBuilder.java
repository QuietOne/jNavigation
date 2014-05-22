package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.BoundedField;
import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.ContourSet;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class ContourSetBuilder implements Builder {

    ContourSet contourSet;

    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoundedField build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Builds a contour set from the region outlines in the provided compact
     * heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param chf A fully built compact heightfield.
     * @param maxError The maximum distance a simplfied contour's border edges
     * should deviate the original raw contour. [Limit: >=0] [Units: wu]
     * @param maxEdgeLen The maximum allowed length for contour edges along the
     * border of the mesh. [Limit: >=0] [Units: vx]
     * @param buildFlags The build flags. (See: rcBuildContoursFlags)
     *
     * WARNING: out
     * @param cset The resulting contour set. (Must be pre-allocated.)
     * @return True if the operation completed successfully. The raw contours
     * will match the region outlines exactly. The maxError and maxEdgeLen
     * parameters control how closely the simplified contours will match the raw
     * contours.
     *
     * Simplified contours are generated such that the vertices for portals
     * between areas match up. (They are considered mandatory vertices.)
     *
     * Setting maxEdgeLength to zero will disabled the edge length feature.
     *
     * See the rcConfig documentation for more information on the configuration
     * parameters.
     *
     * See Also rcAllocContourSet, CompactHeightfield, ContourSet, rcConfig
     */
    public native boolean rcBuildContours(CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset, int buildFlags);
}
