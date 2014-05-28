package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.ContourSet;

/**
 * ContourSetBuilder is class for correct manipulation on ContourSet
 * structure.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class ContourSetBuilder extends Builder {

    private ContourSet contourSet;

    @Override
    public void initializeStructure() {
        contourSet = new ContourSet();
    }

    /**
     * 
     * @param compactHeightfield
     * @param maxError
     * @param maxEdgeLength
     * @param buildFlags
     * @return 
     */
    public boolean buildContours(CompactHeightfield compactHeightfield, float maxError, int maxEdgeLength, int buildFlags){
        return rcBuildContours(compactHeightfield, maxError, maxEdgeLength, buildFlags);
    }
    
    private native boolean rcBuildContours(CompactHeightfield chf, float maxError, int maxEdgeLen, int buildFlags);

    /**
     * 
     * @return 
     */
    public ContourSet getContourSet() {
        return contourSet;
    }
}
