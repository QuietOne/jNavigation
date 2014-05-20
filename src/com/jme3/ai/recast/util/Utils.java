package com.jme3.ai.recast.util;

import com.jme3.ai.recast.CompactHeightfield;
import com.jme3.ai.recast.Context;
import com.jme3.ai.recast.ContourSet;
import com.jme3.ai.recast.HeightfieldLayerSet;
import com.jme3.ai.recast.PolyMesh;
import com.jme3.ai.recast.PolyMeshDetail;

/**
 * Class for containing all those functions that don't belongs to any class.
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class Utils {

    /**
     * Builds a layer set from the specified compact heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param chf A fully built compact heightfield.
     * @param borderSize The size of the non-navigable border around the
     * heightfield. [Limit: >=0] [Units: vx]
     * @param walkableHeight Minimum floor to 'ceiling' height that will still
     * allow the floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     *
     * WARNING: out
     * @param lset The resulting layer set. (Must be pre-allocated.)
     * @return True if the operation completed successfully. See the rcConfig
 documentation for more information on the configuration parameters.

 See Also rcAllocHeightfieldLayerSet, CompactHeightfield,
 HeightfieldLayerSet, rcConfig
     */
    public native boolean rcBuildHeightfieldLayers(Context ctx, CompactHeightfield chf, int borderSize, int walkableHeight, HeightfieldLayerSet lset);

    /**
     * Builds a contour set from the region outlines in the provided compact
     * heightfield.
     *
     * WARNING: [in,out]
     *
     * @param ctx The build context to use during the operation.
     *
     * WARNING: in
     * @param chf A fully built compact heightfield.
     * @param maxError The maximum distance a simplfied contour's border edges
     * should deviate the original raw contour. [Limit: >=0] [Units: wu]
     * @param maxEdgeLen The maximum allowed length for contour edges along the
     * border of the mesh. [Limit: >=0] [Units: vx]
     * @param buildFlags The build flags. (See: rcBuildContoursFlags)
     *
     * WARNING: out
     * @param cset The resulting contour set. (Must be pre-allocated.)
     * @return True if the operation completed successfully. The raw contours
 will match the region outlines exactly. The maxError and maxEdgeLen
 parameters control how closely the simplified contours will match the raw
 contours.

 Simplified contours are generated such that the vertices for portals
 between areas match up. (They are considered mandatory vertices.)

 Setting maxEdgeLength to zero will disabled the edge length feature.

 See the rcConfig documentation for more information on the configuration
 parameters.

 See Also rcAllocContourSet, CompactHeightfield, ContourSet, rcConfig
     */
    public native boolean rcBuildContours(Context ctx, CompactHeightfield chf, float maxError, int maxEdgeLen, ContourSet cset, int buildFlags);

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
    public native boolean rcBuildPolyMesh(Context ctx, ContourSet cset, int nvp, PolyMesh mesh);

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
    public native boolean rcMergePolyMeshes(Context ctx, PolyMesh meshes, int nmeshes, PolyMesh mesh);

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
    public native boolean rcBuildPolyMeshDetail(Context ctx, PolyMesh mesh, CompactHeightfield chf, float sampleDist, float sampleMaxError, PolyMeshDetail dmesh);

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
    public native boolean rcCopyPolyMesh(Context ctx, PolyMesh src, PolyMesh dst);

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
    public native boolean rcMergePolyMeshDetails(Context ctx, PolyMeshDetail meshes, int nmeshes, PolyMeshDetail mesh);
}
