package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.BoundedField;
import com.jme3.ai.recast.structures.ContourSet;
import com.jme3.ai.recast.structures.PolyMesh;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshBuilder implements Builder{

    PolyMesh polyMesh;
    
    @Override
    public void initializeStructure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoundedField build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        /**
     * Builds a polygon mesh from the provided contours.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param cset A fully built contour set.
     * @param nvp The maximum number of vertices allowed for polygons generated
     * during the contour to polygon conversion process. [Limit: >= 3]
     *
     * WARNING: out
     * @param mesh The resulting polygon mesh. (Must be re-allocated.)
     * @return True if the operation completed successfully.

 Note If the mesh data is to be used to construct a Detour navigation
 mesh, then the upper limit must be retricted to le DT_VERTS_PER_POLYGON.
 See Also rcAllocPolyMesh, ContourSet, PolyMesh, rcConfig
     */
    public native boolean rcBuildPolyMesh( ContourSet cset, int nvp, PolyMesh mesh);
    
        /**
     * Merges multiple polygon meshes into a single mesh.
     *
     * @param meshes An array of polygon meshes to merge. [Size: nmeshes]
     * @param nmeshes The number of polygon meshes in the meshes array.
     * @param mesh The resulting polygon mesh. (Must be pre-allocated.)
     *
     * WARNING: [in,out]
     * @param ctx The build context to use during the operation.
     * @return True if the operation completed successfully. See Also
 rcAllocPolyMesh, PolyMesh
     */
    public native boolean rcMergePolyMeshes( PolyMesh meshes, int nmeshes, PolyMesh mesh);
    
        /**
     * Copies the poly mesh data from src to dst. WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param src The source mesh to copy from.
     *
     * WARNING: out
     * @param dst The resulting detail mesh. (Must be pre-allocated, must be
     * empty mesh.)
     * @return True if the operation completed successfully.
     */
    public native boolean rcCopyPolyMesh( PolyMesh src, PolyMesh dst);
}
