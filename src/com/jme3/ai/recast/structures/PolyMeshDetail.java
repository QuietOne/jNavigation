package com.jme3.ai.recast.structures;

/**
 * Contains triangle meshes that represent detailed height data associated with
 * the polygons in its associated polygon mesh object.
 *
 * The detail mesh is made up of triangle sub-meshes that provide extra height
 * detail for each polygon in its assoicated polygon mesh.
 *
 * The standard process for building a detail mesh is to allocate it using
 * rcAllocPolyMeshDetail, then build it using rcBuildPolyMeshDetail.
 *
 * See the individual field definitions for details realted to the structure the
 * mesh.
 *
 * See Also rcAllocPolyMeshDetail, rcFreePolyMeshDetail, rcBuildPolyMeshDetail,
 * rcPolyMesh
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class PolyMeshDetail {

    /**
     * WARINING: unsigned int* The sub-mesh data. [Size: 4*nmeshes].
 [(baseVertIndex, vertCount, baseTriIndex, triCount) * nmeshes]

 Maximum number of vertices per sub-mesh: 127 Maximum number of triangles
 per sub-mesh: 255

 The sub-meshes are stored in the same order as the polygons from the
 rcPolyMesh they represent. E.g. PolyMeshDetail sub-mesh 5 is associated
 with rcPolyMesh polygon 5.

 Example of iterating the triangles in a sub-mesh.

 // Where dmesh is a reference to a PolyMeshDetail object. // Iterate
 the sub-meshes. (One for each source polygon.) for (int i = 0; i <
     * dmesh.nmeshes; ++i) { const unsigned int* meshDef = &dmesh.meshes[i*4];
     * const unsigned int baseVerts = meshDef[0]; const unsigned int baseTri =
     * meshDef[2]; const int ntris = (int)meshDef[3]; * const float* verts =
     * &dmesh.verts[baseVerts*3]; const unsigned char* tris =
     * &dmesh.tris[baseTri*4]; // Iterate the sub-mesh's triangles. for (int j =
     * 0; j < ntris; ++j) { const float x = verts[tris[j*4+0]*3]; const float y
     * = verts[tris[j*4+1]*3]; const float z = verts[tris[j*4+2]*3]; // Do
     * something with the vertex. } }
     */
    public int[] meshes = new int[4];

    /**
     * The number of sub-meshes defined by meshes.
     */
    public int nmeshes;

    /**
     * The number of triangles in tris.
     */
    public int ntris;

    /**
     * The number of vertices in verts.
     */
    public int nverts;

    /**
     * WARNING: unsigned char* The mesh triangles. [Size: 4*ntris].
     *
     * [(vertIndexA, vertIndexB, vertIndexC, flags) * ntris]
     *
     * The triangles are grouped by sub-mesh.
     *
     * Vertex Indices
     *
     * The vertex indices in the triangle array are local to the sub-mesh, not
     * global. To translate into an global index in the vertices array, the
     * values must be offset by the sub-mesh's base vertex index.
     *
     * Example: If the baseVertexIndex for the sub-mesh is 5 and the triangle
     * entry is (4, 8, 7, 0), then the actual indices for the vertices are (4 +
     * 5, 8 + 5, 7 + 5).
     *
     * Flags
     *
     * The flags entry indicates which edges are internal and which are external
     * to the sub-mesh. Internal edges connect to other triangles within the
     * same sub-mesh. External edges represent portals to other sub-meshes or
     * the null region.
     *
     * Each flag is stored in a 2-bit position. Where position 0 is the lowest
     * 2-bits and position 4 is the highest 2-bits:
     *
     * Position 0: Edge AB (>> 0) Position 1: Edge BC (>> 2) Position 2: Edge CA
     * (>> 4) Position 4: Unused
     *
     * Testing can be performed as follows:
     *
     * if (((flags >> 2) & 0x3) != 0) { // Edge BC is an external edge. }
     */
    public String tris;
    /**
     * WARNING: float* The mesh vertices. [Size: 3*nverts].
     *
     * [(x, y, z) * nverts]
     *
     * The vertices are grouped by sub-mesh and will contain duplicates since
     * each sub-mesh is independently defined.
     *
     * The first group of vertices for each sub-mesh are in the same order as
     * the vertices for the sub-mesh's associated PolyMesh polygon. These
     * vertices are followed by any additional detail vertices. So it the
     * associated polygon has 5 vertices, the sub-mesh will have a minimum of 5
     * vertices and the first 5 vertices will be equivalent to the 5 polygon
     * vertices.
     *
     */
    public float[] verts = new float[3];
}
