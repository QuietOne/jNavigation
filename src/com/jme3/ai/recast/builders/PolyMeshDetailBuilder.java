package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.PolyMesh;
import com.jme3.ai.recast.structures.PolyMeshDetail;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshDetailBuilder implements Builder {

    private PolyMeshDetail polyMeshDetail;

    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void build() {
        //TODO: fix structure building sequenceI
    }

    private native boolean buildPolyMeshDetail(PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError, PolyMeshDetail dmesh);

    private native boolean mergePolyMeshDetails(PolyMeshDetail meshes, int nmeshes, PolyMeshDetail mesh);

    public PolyMeshDetail getPolyMeshDetail() {
        return polyMeshDetail;
    }
}
