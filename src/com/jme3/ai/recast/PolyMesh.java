package com.jme3.ai.recast;

/**
 * Represents a polygon mesh suitable for use in building a navigation mesh.
 *
 * A mesh of potentially overlapping convex polygons of between three and nvp
 vertices. The mesh exists within the context of an axis-aligned bounding box
 (AABB) with vertices laid out in an evenly spaced grid, based on the values
 of cs and ch.

 The standard process for building a contour set is to allocate it using
 rcAllocPolyMesh, the initialize it using rcBuildPolyMesh

 Example of iterating the polygons:

 // Where mesh is a reference to a PolyMesh object. const int nvp =
 mesh.nvp; const float cs = mesh.cs; const float ch = mesh.ch; const float*
 orig = mesh.bmin; for (int i = 0; i < mesh.npolys; ++i) { const unsigned
 * short* p = &mesh.polys[i*nvp*2];
 *
 * // Iterate the vertices. unsigned short vi[3]; // The vertex indices. for
 * (int j = 0; j < nvp; ++j) { if (p[j] == RC_MESH_NULL_IDX) break; // End of
 * vertices. if (p[j + nvp] == RC_MESH_NULL_IDX) { // The edge beginning with
 * this vertex is a solid border. } else { // The edge beginning with this
 * vertex connects to // polygon p[j + nvp]. }
 *
 * // Convert to world space. const unsigned short* v = &mesh.verts[p[j]*3];
 * const float x = orig[0] + v[0]*cs; const float y = orig[1] + v[1]*ch; const
 * float z = orig[2] + v[2]*cs; // Do something with the vertices. } } See Also
 * rcAllocPolyMesh, rcFreePolyMesh, rcBuildPolyMesh
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class PolyMesh {

    /**
     * WARNING: unsigned char * The area id assigned to each polygon. [Length:
     * maxpolys] The standard build process assigns the value of
     * RC_WALKABLE_AREA to all walkable polygons. This value can then be changed
     * to meet user requirements.
     */
    public String areas;

    /**
     * The maximum bounds in world space. [(x, y, z)].
     */
    public float[] bmax = new float[3];

    /**
     * The minimum bounds in world space. [(x, y, z)].
     */
    public float[] bmin = new float[3];

    /**
     * The AABB border size used to generate the source data from which the mesh
     * was derived.
     */
    public int borderSize;

    /**
     * The height of each cell. (The minimum increment along the y-axis.)
     */
    public float ch;

    /**
     * The size of each cell. (On the xz-plane.)
     */
    public float cs;

    /**
     * WARNING: unsigned char * The user defined flags for each polygon.
     * [Length: maxpolys].
     */
    public String flags;

    /**
     * The number of allocated polygons.
     */
    public int maxpolys;

    /**
     * The number of polygons.
     */
    public int npolys;

    /**
     * The number of vertices.
     */
    public int nverts;

    /**
     * The maximum number of vertices per polygon.
     */
    public int nvp;

    /**
     * WARNING: unsigned char * Polygon and neighbor data. [Length: maxpolys * 2
     * * nvp].
     *
     * Each entry is 2 * nvp in length. The first half of the entry contains the
     * indices of the polygon. The first instance of RC_MESH_NULL_IDX indicates
     * the end of the indices for the entry. The second half contains indices to
     * neighbor polygons. A value of RC_MESH_NULL_IDX indicates no connection
     * for the associated edge. (I.e. The edge is a solid border.)
     *
     * For example:
     *
     * nvp = 6 For the entry: (1, 3, 4, 8, RC_MESH_NULL_IDX, RC_MESH_NULL_IDX,
     * 18, RC_MESH_NULL_IDX , 21, RC_MESH_NULL_IDX, RC_MESH_NULL_IDX,
     * RC_MESH_NULL_IDX) (1, 3, 4, 8) defines a polygon with 4 vertices. Edge
     * 1->3 is shared with polygon 18. Edge 4->8 is shared with polygon 21.
     * Edges 3->4 and 4->8 are border edges not shared with any other polygon.
 unsigned short* PolyMesh::regs The region id assigned to each polygon.
 [Length: maxpolys].

 PolyMesh::verts The mesh vertices. [Form: (x, y, z) * nverts].

 The values of bmin ,cs, and ch are used to convert vertex coordinates to
 world space as follows:

 float worldX = bmin[0] + verts[i*3+0] * cs float worldY = bmin[1] +
 verts[i*3+1] * ch float worldZ = bmin[2] + verts[i*3+2] * cs
     */
    public String polys;

}
