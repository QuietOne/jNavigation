package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Defines the location of detail sub-mesh data within a MeshTile.
 *
 * @see MeshTile
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class PolyDetail {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public PolyDetail() {
        this(RecastJNI.new_dtPolyDetail(), true);
    }

    public PolyDetail(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PolyDetail obj) {
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
                RecastJNI.delete_dtPolyDetail(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value The offset of the vertices in the MeshTile.detailVertices
     * array.
     * @see MeshTile#getDetailVertices()
     */
    public void setVertBase(long value) {
        RecastJNI.dtPolyDetail_vertBase_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The offset of the vertices in the MeshTile.detailVertices array.
     * @see MeshTile#getDetailVertices()
     */
    public long getVertBase() {
        return RecastJNI.dtPolyDetail_vertBase_get(swigCPtr, this);
    }

    /**
     *
     * @param value he offset of the triangles in the MeshTile.detailTriangles
     * array.
     * @see MeshTile#getDetailTriangles()
     */
    public void setTriangleBase(long value) {
        RecastJNI.dtPolyDetail_triBase_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The offset of the triangles in the MeshTile.detailTriangles
     * array.
     * @see MeshTile#getDetailTriangles()
     */
    public long getTriangleBase() {
        return RecastJNI.dtPolyDetail_triBase_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of vertices in the sub-mesh.
     */
    public void setVerticesCount(short value) {
        RecastJNI.dtPolyDetail_vertCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices in the sub-mesh.
     */
    public short getVerticesCount() {
        return RecastJNI.dtPolyDetail_vertCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of triangles in the sub-mesh.
     */
    public void setTriangleCount(short value) {
        RecastJNI.dtPolyDetail_triCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of triangles in the sub-mesh.
     */
    public short getTriangleCount() {
        return RecastJNI.dtPolyDetail_triCount_get(swigCPtr, this);
    }
}
