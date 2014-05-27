package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.ContourSet;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class ContourSetBuilder extends Builder {

    private ContourSet contourSet;

    @Override
    public void initializeStructure() {
        contourSet = new ContourSet();
    }

    public boolean buildContours(CompactHeightfield compactHeightfield, float maxError, int maxEdgeLength, int buildFlags){
        return rcBuildContours(compactHeightfield, maxError, maxEdgeLength, buildFlags);
    }
    
    private native boolean rcBuildContours(CompactHeightfield chf, float maxError, int maxEdgeLen, int buildFlags);

    public ContourSet getContourSet() {
        return contourSet;
    }
}
