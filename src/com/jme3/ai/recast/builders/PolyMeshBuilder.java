package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.ContourSet;
import com.jme3.ai.recast.structures.PolyMesh;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshBuilder implements Builder{

    private PolyMesh polyMesh;
    
    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void build() {
        //TODO: fix structure building sequence
    }

    private native boolean rcBuildPolyMesh( ContourSet cset, int nvp, PolyMesh mesh);

    private native boolean rcMergePolyMeshes( PolyMesh meshes, int nmeshes, PolyMesh mesh);

    private native boolean rcCopyPolyMesh( PolyMesh src, PolyMesh dst);

    public PolyMesh getPolyMesh() {
        return polyMesh;
    }
}
