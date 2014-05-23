package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.ContourSet;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class ContourSetBuilder implements Builder {

    private ContourSet contourSet;

    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void build() {
        //TODO: fix structure building sequence
    }
    
    private native boolean rcBuildContours(CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset, int buildFlags);

    public ContourSet getContourSet() {
        return contourSet;
    }
}
