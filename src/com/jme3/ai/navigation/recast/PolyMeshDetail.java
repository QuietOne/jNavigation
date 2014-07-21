package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;

/**
 * Contains triangle meshes that represent detailed height data associated with
 * the polygons in its associated polygon mesh object.
 *
 * The detail mesh is made up of triangle sub-meshes that provide extra height
 * detail for each polygon in its assoicated polygon mesh.
 *
 * The standard process for building a detail mesh is to allocate it using
 * constructor, then build it using buildPolyMeshDetail.
 *
 * See the individual field definitions for details realted to the structure the
 * mesh.
 *
 * @see RecastBuilder
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PolyMeshDetail {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Allocates a detail mesh object using the Recast allocator.
     */
    public PolyMeshDetail() {
        swigCPtr = RecastJNI.rcAllocPolyMeshDetail();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    protected PolyMeshDetail(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PolyMeshDetail obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.rcFreePolyMeshDetail(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    /**
     * [(baseVertIndex, vertCount, baseTriIndex, triCount) * numberOfMeshes]
     *
     * Maximum number of vertices per sub-mesh: 127 Maximum number of triangles
     * per sub-mesh: 255
     *
     * The sub-meshes are stored in the same order as the polygons from the
     * rcPolyMesh they represent. E.g. PolyMeshDetail sub-mesh 5 is associated
     * with PolyMesh polygon 5.
     *
     * @param meshes The sub-mesh data. [Size: 4*numberOfMeshes].
     */
    public void setMeshes(int[] meshes) {
        SWIGTYPE_p_unsigned_int value = null;//FIXME:
        RecastJNI.rcPolyMeshDetail_meshes_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    /**
     * [(baseVertIndex, vertCount, baseTriIndex, triCount) * numberOfMeshes]
     *
     * Maximum number of vertices per sub-mesh: 127 Maximum number of triangles
     * per sub-mesh: 255
     *
     * The sub-meshes are stored in the same order as the polygons from the
     * rcPolyMesh they represent. E.g. PolyMeshDetail sub-mesh 5 is associated
     * with PolyMesh polygon 5.
     *
     * @return The sub-mesh data. [Size: 4*numberOfMeshes].
     */
    public int[] getMeshes() {
        long cPtr = RecastJNI.rcPolyMeshDetail_meshes_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToInts(cPtr, getNumberOfMeshes());
    }

    /**
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
     * @param vertices The mesh vertices.
     */
    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(vertices);
        RecastJNI.rcPolyMeshDetail_verts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
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
     * @return The mesh vertices.
     */
    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.rcPolyMeshDetail_verts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr, getNumberOfVertices());
    }

    /**
     * [(vertIndexA, vertIndexB, vertIndexC, flags) * numberOfTriangles]
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
     * @param triangles The mesh triangles. [Size: 4*numberOfTriangles].
     */
    public void setTriangles(char[] triangles) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(triangles);
        RecastJNI.rcPolyMeshDetail_tris_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     * [(vertIndexA, vertIndexB, vertIndexC, flags) * numberOfTriangles]
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
     * @return The mesh triangles. [Size: 4*numberOfTriangles].
     */
    public char[] getTriangles() {
        long cPtr = RecastJNI.rcPolyMeshDetail_tris_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getNumberOfTriangles());
    }

    /**
     *
     * @param value The number of sub-meshes defined by meshes.
     */
    public void setNumberOfMeshes(int value) {
        RecastJNI.rcPolyMeshDetail_nmeshes_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of sub-meshes defined by meshes.
     */
    public int getNumberOfMeshes() {
        return RecastJNI.rcPolyMeshDetail_nmeshes_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of vertices.
     */
    public void setNumberOfVertices(int value) {
        RecastJNI.rcPolyMeshDetail_nverts_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices.
     */
    public int getNumberOfVertices() {
        return RecastJNI.rcPolyMeshDetail_nverts_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of triangles.
     */
    public void setNumberOfTriangles(int value) {
        RecastJNI.rcPolyMeshDetail_ntris_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of triangles.
     */
    public int getNumberOfTriangles() {
        return RecastJNI.rcPolyMeshDetail_ntris_get(swigCPtr, this);
    }

    /**
     * Visual representation of mesh. Created for debugging purposes.
     *
     * @return
     */
    public Mesh createVisualMesh() {
        Mesh mesh = new Mesh();

        return mesh;
    }
}
