package com.jme3.ai.detour.structures;

import com.jme3.math.Vector3f;

/**
 * Provides high level information related to a MeshTile object.
 *
 * @see MeshTile
 * @author Tihomir Radosavljevic
 */
public class MeshHeader {

    /**
     * Reference to object.
     */
    private Object reference;
    /**
     * Tile magic number. (Used to identify the data format.)
     */
    private int magic;
    /**
     * Tile data format version number.
     */
    private int version;
    /**
     * The x-position of the tile within the NavMesh tile grid. (x, y, layer)
     */
    private int x;
    /**
     * The y-position of the tile within the NavMesh tile grid. (x, y, layer)
     */
    private int y;
    /**
     * The layer of the tile within the NavMesh tile grid.
     */
    private int layer;
    /**
     * The user defined id of the tile.
     */
    private int userID;
    /**
     * The number of polygons in the tile.
     */
    private int polyCount;
    /**
     * The number of vertices in the tile.
     */
    private int verticesCount;
    /**
     * The number of allocated links.
     */
    private int maxLinkCount;
    /**
     * The number of sub-meshes in the detail mesh.
     */
    private int detailMeshCount;
    /**
     * The number of unique vertices in the detail mesh. (In addition to the
     * polygon vertices.)
     */
    private int detailVerticesCount;
    /**
     * The number of triangles in the detail mesh.
     */
    private int detailTriangleCount;
    /**
     * The number of bounding volume nodes. (Zero if bounding volumes are
     * disabled.)
     */
    private int boundingNodeCount;
    /**
     * The number of off-mesh connections.
     */
    private int offMeshConnectionCount;
    /**
     * The index of the first polygon which is an off-mesh connection.
     */
    private int offMeshBase;
    /**
     * The height of the agents using the tile.
     */
    private float walkableHeight;
    /**
     * The radius of the agents using the tile.
     */
    private float walkableRadius;
    /**
     * The maximum climb height of the agents using the tile.
     */
    private float walkableClimb;
    /**
     * The minimum bounds of the tile's AABB.
     */
    private Vector3f minBound;
    /**
     * The maximum bounds of the tile's AABB.
     */
    private Vector3f maxBound;
    /**
     * The bounding volume quantization factor.
     *
     * This value is used for converting between world and bounding volume
     * coordinates.
     */
    private float boundingVolumeQuantizationFactor;

    public int getMagic() {
        getNativeMagic();
        return magic;
    }

    private native void getNativeMagic();

    public int getVersion() {
        getNativeVersion();
        return version;
    }

    private native void getNativeVersion();

    public int getX() {
        getNativeX();
        return x;
    }

    private native void getNativeX();

    public int getY() {
        getNativeY();
        return y;
    }

    private native void getNativeY();

    public int getLayer() {
        getNativeLayer();
        return layer;
    }

    private native void getNativeLayer();

    public int getUserID() {
        getNativeUserID();
        return userID;
    }

    private native void getNativeUserID();

    public int getPolyCount() {
        getNativePolyCount();
        return polyCount;
    }

    private native void getNativePolyCount();

    public int getVerticesCount() {
        getNativeVerticesCount();
        return verticesCount;
    }

    private native void getNativeVerticesCount();

    public int getMaxLinkCount() {
        getNativeMaxLinkCount();
        return maxLinkCount;
    }

    private native void getNativeMaxLinkCount();

    public int getDetailMeshCount() {
        getNativeDetailMeshCount();
        return detailMeshCount;
    }

    private native void getNativeDetailMeshCount();

    public int getDetailVerticesCount() {
        getNativeDetailVerticesCount();
        return detailVerticesCount;
    }

    private native void getNativeDetailVerticesCount();

    public int getDetailTriangleCount() {
        getNativeDetailTriangleCount();
        return detailTriangleCount;
    }

    private native void getNativeDetailTriangleCount();

    public int getBoundingNodeCount() {
        getNativeBoundingNodeCount();
        return boundingNodeCount;
    }

    private native void getNativeBoundingNodeCount();

    public int getOffMeshConnectionCount() {
        getNativeOffMeshConnectionCount();
        return offMeshConnectionCount;
    }

    private native void getNativeOffMeshConnectionCount();

    public int getOffMeshBase() {
        getNativeOffMeshBase();
        return offMeshBase;
    }

    private native void getNativeOffMeshBase();

    public float getWalkableHeight() {
        getNativeWalkableHeight();
        return walkableHeight;
    }

    private native void getNativeWalkableHeight();

    public float getWalkableRadius() {
        getNativeWalkableRadius();
        return walkableRadius;
    }

    private native void getNativeWalkableRadius();

    public float getWalkableClimb() {
        getNativeWalkableClimb();
        return walkableClimb;
    }

    private native void getNativeWalkableClimb();

    public Vector3f getMinBound() {
        getNativeMinBound();
        return minBound;
    }

    private native void getNativeMinBound();

    public Vector3f getMaxBound() {
        getNativeMaxBound();
        return maxBound;
    }

    private native void getNativeMaxBound();

    public float getBoundingVolumeQuantizationFactor() {
        getNativeBoundingVolume();
        return boundingVolumeQuantizationFactor;
    }

    private native void getNativeBoundingVolume();
}
