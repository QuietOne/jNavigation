package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.ContourSet;
import com.jme3.ai.recast.structures.PolyMesh;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshBuilder extends Builder {

    private PolyMesh polyMesh;

    @Override
    public void initializeStructure() {
        polyMesh = new PolyMesh();
    }
    
    public boolean buildPolyMesh(ContourSet contourSet, int numberOfVerticesPerPoly){
        return rcBuildPolyMesh(contourSet, numberOfVerticesPerPoly);
    }

    private native boolean rcBuildPolyMesh(ContourSet cset, int nvp);

    public boolean addPolyMeshes(PolyMesh[] polyMeshes){
        return rcMergePolyMeshes(polyMeshes);
    }
    
    private native boolean rcMergePolyMeshes(PolyMesh[] meshes);

    public PolyMesh getPolyMesh() {
        return polyMesh;
    }
}
