package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.BoundedField;
import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.PolyMesh;
import com.jme3.ai.recast.structures.PolyMeshDetail;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshDetailBuilder implements Builder{

    PolyMeshDetail polyMeshDetail;
    
    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoundedField build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        /**
     * Builds a detail mesh from the provided polygon mesh.
     *
     * @param mesh A fully built polygon mesh.
     * @param chf The compact heightfield used to build the polygon mesh.
     * @param sampleDist Sets the distance to use when samping the heightfield.
     * [Limit: >=0] [Units: wu]
     * @param sampleMaxError The maximum distance the detail mesh surface should
     * deviate from heightfield data. [Limit: >=0] [Units: wu]
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     *
     * WARNING: out
     * @param dmesh The resulting detail mesh. (Must be pre-allocated.)
     * @return True if the operation completed successfully. See the rcConfig
 documentation for more information on the configuration parameters.

 See Also rcAllocPolyMeshDetail, PolyMesh, CompactHeightfield,
 PolyMeshDetail, rcConfig
     */
    public native boolean buildPolyMeshDetail( PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError, PolyMeshDetail dmesh);

    /**
     * Merges multiple detail meshes into a single detail mesh.
     *
     * @param meshes An array of detail meshes to merge. [Size: nmeshes]
     * @param nmeshes The number of detail meshes in the meshes array.
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     *
     * WARNING:out
     * @param mesh The resulting detail mesh. (Must be pre-allocated.)
     * @return True if the operation completed successfully. See Also
 rcAllocPolyMeshDetail, PolyMeshDetail
     */
    public native boolean rcMergePolyMeshDetails( PolyMeshDetail meshes, int nmeshes, PolyMeshDetail mesh);
}
