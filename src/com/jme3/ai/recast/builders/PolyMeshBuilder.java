package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.ContourSet;
import com.jme3.ai.recast.structures.PolyMesh;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshBuilder implements Builder {

    private PolyMesh polyMesh;

    @Override
    public void initializeStructure() {
        polyMesh = new PolyMesh();
    }

    @Override
    public void build() {
        //TODO: fix structure building sequence
    }

    private native boolean rcBuildPolyMesh(ContourSet cset, int nvp, PolyMesh mesh);

    private native boolean rcMergePolyMeshes(PolyMesh meshes, int nmeshes, PolyMesh mesh);

    

    public PolyMesh getPolyMesh() {
        return polyMesh;
    }
}
