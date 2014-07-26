package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * Provides high level information related to a MeshTile object.
 *
 * @see MeshTile
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class MeshHeader {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public MeshHeader() {
        this(RecastJNI.new_dtMeshHeader(), true);
    }

    protected MeshHeader(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(MeshHeader obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_dtMeshHeader(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value Tile magic number. (Used to identify the data format.)
     */
    public void setMagic(int value) {
        RecastJNI.dtMeshHeader_magic_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Tile magic number. (Used to identify the data format.)
     */
    public int getMagic() {
        return RecastJNI.dtMeshHeader_magic_get(swigCPtr, this);
    }

    /**
     *
     * @param value Tile data format version number.
     */
    public void setVersion(int value) {
        RecastJNI.dtMeshHeader_version_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Tile data format version number.
     */
    public int getVersion() {
        return RecastJNI.dtMeshHeader_version_get(swigCPtr, this);
    }

    /**
     *
     * @param value The x-position of the tile within the NavMesh tile grid. (x,
     * y, layer)
     * @see NavMesh
     */
    public void setX(int value) {
        RecastJNI.dtMeshHeader_x_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The x-position of the tile within the NavMesh tile grid. (x, y,
     * layer)
     * @see NavMesh
     */
    public int getX() {
        return RecastJNI.dtMeshHeader_x_get(swigCPtr, this);
    }

    /**
     *
     * @param value The y-position of the tile within the NavMesh tile grid. (x,
     * y, layer)
     * @see NavMesh
     */
    public void setY(int value) {
        RecastJNI.dtMeshHeader_y_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The y-position of the tile within the NavMesh tile grid. (x, y,
     * layer)
     * @see NavMesh
     */
    public int getY() {
        return RecastJNI.dtMeshHeader_y_get(swigCPtr, this);
    }

    /**
     *
     * @param value The layer of the tile within the NavMesh tile grid. (x, y,
     * layer)
     * @see NavMesh
     */
    public void setLayer(int value) {
        RecastJNI.dtMeshHeader_layer_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The layer of the tile within the NavMesh tile grid. (x, y, layer)
     * @see NavMesh
     */
    public int getLayer() {
        return RecastJNI.dtMeshHeader_layer_get(swigCPtr, this);
    }

    /**
     *
     * @param value The user defined id of the tile.
     */
    public void setUserId(long value) {
        RecastJNI.dtMeshHeader_userId_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The user defined id of the tile.
     */
    public long getUserId() {
        return RecastJNI.dtMeshHeader_userId_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of polygons in the tile.
     */
    public void setPolyCount(int value) {
        RecastJNI.dtMeshHeader_polyCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of polygons in the tile.
     */
    public int getPolyCount() {
        return RecastJNI.dtMeshHeader_polyCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of vertices in the tile.
     */
    public void setVerticesCount(int value) {
        RecastJNI.dtMeshHeader_vertCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices in the tile.
     */
    public int getVerticesCount() {
        return RecastJNI.dtMeshHeader_vertCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of allocated links.
     */
    public void setMaxLinkCount(int value) {
        RecastJNI.dtMeshHeader_maxLinkCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of allocated links.
     */
    public int getMaxLinkCount() {
        return RecastJNI.dtMeshHeader_maxLinkCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of sub-meshes in the detail mesh.
     */
    public void setDetailMeshCount(int value) {
        RecastJNI.dtMeshHeader_detailMeshCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of sub-meshes in the detail mesh.
     */
    public int getDetailMeshCount() {
        return RecastJNI.dtMeshHeader_detailMeshCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of unique vertices in the detail mesh. (In
     * addition to the polygon vertices.)
     */
    public void setDetailVertCount(int value) {
        RecastJNI.dtMeshHeader_detailVertCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of unique vertices in the detail mesh. (In addition to
     * the polygon vertices.)
     */
    public int getDetailVerticesCount() {
        return RecastJNI.dtMeshHeader_detailVertCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of triangles in the detail mesh.
     */
    public void setDetailTrianglesCount(int value) {
        RecastJNI.dtMeshHeader_detailTriCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of triangles in the detail mesh.
     */
    public int getDetailTrianglesCount() {
        return RecastJNI.dtMeshHeader_detailTriCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of bounding volume nodes. (Zero if bounding
     * volumes are disabled.)
     */
    public void setBvNodeCount(int value) {
        RecastJNI.dtMeshHeader_bvNodeCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of bounding volume nodes. (Zero if bounding volumes
     * are disabled.)
     */
    public int getBvNodeCount() {
        return RecastJNI.dtMeshHeader_bvNodeCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of off-mesh connections.
     */
    public void setOffMeshConnectionsCount(int value) {
        RecastJNI.dtMeshHeader_offMeshConCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of off-mesh connections.
     */
    public int getOffMeshConnectionsCount() {
        return RecastJNI.dtMeshHeader_offMeshConCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The index of the first polygon which is an off-mesh
     * connection.
     */
    public void setOffMeshBase(int value) {
        RecastJNI.dtMeshHeader_offMeshBase_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The index of the first polygon which is an off-mesh connection.
     */
    public int getOffMeshBase() {
        return RecastJNI.dtMeshHeader_offMeshBase_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of the agents using the tile.
     */
    public void setWalkableHeight(float value) {
        RecastJNI.dtMeshHeader_walkableHeight_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of the agents using the tile.
     */
    public float getWalkableHeight() {
        return RecastJNI.dtMeshHeader_walkableHeight_get(swigCPtr, this);
    }

    /**
     *
     * @param value The radius of the agents using the tile.
     */
    public void setWalkableRadius(float value) {
        RecastJNI.dtMeshHeader_walkableRadius_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The radius of the agents using the tile.
     */
    public float getWalkableRadius() {
        return RecastJNI.dtMeshHeader_walkableRadius_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum climb height of the agents using the tile.
     */
    public void setWalkableClimb(float value) {
        RecastJNI.dtMeshHeader_walkableClimb_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum climb height of the agents using the tile.
     */
    public float getWalkableClimb() {
        return RecastJNI.dtMeshHeader_walkableClimb_get(swigCPtr, this);
    }

    /**
     *
     * @param minBound The minimum bounds of the tile's AABB.
     */
    public void setMinBound(Vector3f minBound) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBound);
        RecastJNI.dtMeshHeader_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds of the tile's AABB.
     */
    public Vector3f getMinBound() {
        long cPtr = RecastJNI.dtMeshHeader_bmin_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBound The maximum bounds of the tile's AABB.
     */
    public void setMaxBound(Vector3f maxBound) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBound);
        RecastJNI.dtMeshHeader_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds of the tile's AABB.
     */
    public Vector3f getMaxBound() {
        long cPtr = RecastJNI.dtMeshHeader_bmax_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value The bounding volume quantization factor.
     *
     * This value is used for converting between world and bounding volume
     * coordinates.
     */
    public void setBvQuantFactor(float value) {
        RecastJNI.dtMeshHeader_bvQuantFactor_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The bounding volume quantization factor.
     *
     * This value is used for converting between world and bounding volume
     * coordinates.
     */
    public float getBvQuantFactor() {
        return RecastJNI.dtMeshHeader_bvQuantFactor_get(swigCPtr, this);
    }
}
