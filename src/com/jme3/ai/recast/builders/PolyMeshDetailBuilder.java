package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.PolyMesh;
import com.jme3.ai.recast.structures.PolyMeshDetail;

/**
 * PolyMeshDetailBuilder is class for correct manipulation on PolyMeshDetail
 * structure.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PolyMeshDetailBuilder extends Builder {

    private PolyMeshDetail polyMeshDetail;

    @Override
    public void initializeStructure() {
        polyMeshDetail = new PolyMeshDetail();
    }

    /**
     * 
     * @param polyMesh
     * @param compactHeightfield
     * @param distance
     * @param maxError
     * @return 
     */
    public boolean buildPolyMeshDetail(PolyMesh polyMesh, CompactHeightfield compactHeightfield, float distance, float maxError) {
        return rcBuildPolyMeshDetail(polyMesh, compactHeightfield, distance, maxError);
    }

    private native boolean rcBuildPolyMeshDetail(PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError);

    /**
     * 
     * @param polyMeshDetails
     * @return 
     */
    public boolean addPolyMeshesDetail(PolyMeshDetail[] polyMeshDetails) {
        return rcMergePolyMeshDetails(polyMeshDetails);
    }

    private native boolean rcMergePolyMeshDetails(PolyMeshDetail[] meshes);

    /**
     * 
     * @return 
     */
    public PolyMeshDetail getPolyMeshDetail() {
        return polyMeshDetail;
    }
}
