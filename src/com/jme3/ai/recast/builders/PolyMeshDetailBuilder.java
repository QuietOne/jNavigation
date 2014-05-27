package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.PolyMesh;
import com.jme3.ai.recast.structures.PolyMeshDetail;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshDetailBuilder extends Builder {

    private PolyMeshDetail polyMeshDetail;

    @Override
    public void initializeStructure() {
        polyMeshDetail = new PolyMeshDetail();
    }

    public boolean buildPolyMeshDetail(PolyMesh polyMesh, CompactHeightfield compactHeightfield, float distance, float maxError){
        return rcBuildPolyMeshDetail(polyMesh, compactHeightfield, distance, maxError);
    }
    
    private native boolean rcBuildPolyMeshDetail(PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError);

    public boolean addPolyMeshesDetail(PolyMeshDetail[] polyMeshDetails){
        return  rcMergePolyMeshDetails(polyMeshDetails);
    }
    
    private native boolean rcMergePolyMeshDetails(PolyMeshDetail[] meshes);

    public PolyMeshDetail getPolyMeshDetail() {
        return polyMeshDetail;
    }
}
