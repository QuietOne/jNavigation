package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.ContourSet;
import com.jme3.ai.recast.structures.PolyMesh;

/**
 * PolyMeshBuilder is class for correct manipulation on PolyMesh
 * structure.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PolyMeshBuilder extends Builder {

    private PolyMesh polyMesh;

    @Override
    public void initializeStructure() {
        polyMesh = new PolyMesh();
    }
    
    /**
     * 
     * @param contourSet
     * @param numberOfVerticesPerPoly
     * @return 
     */
    public boolean buildPolyMesh(ContourSet contourSet, int numberOfVerticesPerPoly){
        return rcBuildPolyMesh(contourSet, numberOfVerticesPerPoly);
    }

    private native boolean rcBuildPolyMesh(ContourSet cset, int nvp);

    /**
     * 
     * @param polyMeshes
     * @return 
     */
    public boolean addPolyMeshes(PolyMesh[] polyMeshes){
        return rcMergePolyMeshes(polyMeshes);
    }
    
    private native boolean rcMergePolyMeshes(PolyMesh[] meshes);

    /**
     * 
     * @return 
     */
    public PolyMesh getPolyMesh() {
        return polyMesh;
    }
}
