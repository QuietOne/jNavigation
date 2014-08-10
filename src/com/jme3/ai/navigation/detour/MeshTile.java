package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;

/**
 * Defines a navigation mesh tile.
 *
 * Tiles generally only exist within the context of a dtNavMesh object.
 *
 * Some tile content is optional. For example, a tile may not contain any
 * off-mesh connections. In this case the associated pointer will be null.
 *
 * If a detail mesh exists it will share vertices with the base polygon mesh.
 * Only the vertices unique to the detail mesh will be stored in detailVerts.
 *
 * Warning: Tiles returned by a NavMesh object are not guarenteed to be
 * populated. For example: The tile at a location might not have been loaded
 * yet, or may have been removed. In this case, pointers will be null. So if in
 * doubt, check the polygon count in the tile's header to determine if a tile
 * has polygons defined.
 *
 * @see NavMesh
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class MeshTile {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public MeshTile() {
        this(RecastJNI.new_dtMeshTile(), true);
    }

    public MeshTile(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(MeshTile obj) {
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
                RecastJNI.delete_dtMeshTile(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value Counter describing modifications to the tile.
     */
    public void setSalt(long value) {
        RecastJNI.dtMeshTile_salt_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Counter describing modifications to the tile.
     */
    public long getSalt() {
        return RecastJNI.dtMeshTile_salt_get(swigCPtr, this);
    }

//    /**
//     *
//     * @param value Index to the next free link.
//     */
//    public void setLinksFreeList(long value) {
//        RecastJNI.dtMeshTile_linksFreeList_set(swigCPtr, this, value);
//    }

    /**
     *
     * @return Index to the next free link.
     */
    public long getLinksFreeList() {
        return RecastJNI.dtMeshTile_linksFreeList_get(swigCPtr, this);
    }

    /**
     *
     * @param value The tile header.
     */
    public void setHeader(MeshHeader value) {
        RecastJNI.dtMeshTile_header_set(swigCPtr, this, MeshHeader.getCPtr(value), value);
    }

    /**
     *
     * @return The tile header.
     */
    public MeshHeader getHeader() {
        long cPtr = RecastJNI.dtMeshTile_header_get(swigCPtr, this);
        return (cPtr == 0) ? null : new MeshHeader(cPtr, false);
    }

    /**
     *
     * @param value The tile polygons.
     */
    public void setPolys(Poly value) {
        RecastJNI.dtMeshTile_polys_set(swigCPtr, this, Poly.getCPtr(value), value);
    }

    /**
     *
     * @return The tile polygons.
     */
    public Poly[] getPolys() {
        long cPtr = RecastJNI.dtMeshTile_polys_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToPolys(cPtr, getHeader().getPolyCount());
    }

    /**
     *
     * @param vertices The tile vertices.
     */
    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(vertices);
        RecastJNI.dtMeshTile_verts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The tile vertices.
     */
    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.dtMeshTile_verts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getHeader().getVerticesCount());
    }

    /**
     *
     * @param value The tile links.
     */
    public void setLinks(Link[] value) {
        RecastJNI.dtMeshTile_links_set(swigCPtr, this, Link.getCPtr(value[0]), value[0]);
    }

    /**
     *
     * @return The tile links.
     */
    public Link[] getLinks() {
        long cPtr = RecastJNI.dtMeshTile_links_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToLinks(cPtr, getHeader().getMaxLinkCount());
    }

    /**
     *
     * @param value The tile's detail sub-meshes.
     */
    public void setDetailMeshes(PolyDetail[] value) {
        RecastJNI.dtMeshTile_detailMeshes_set(swigCPtr, this, PolyDetail.getCPtr(value[0]), value[0]);
    }

    /**
     *
     * @return The tile's detail sub-meshes.
     */
    public PolyDetail[] getDetailMeshes() {
        long cPtr = RecastJNI.dtMeshTile_detailMeshes_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToPolyDetails(cPtr, getHeader().getDetailMeshCount());
    }

    /**
     *
     * @param detailVertices The detail mesh's unique vertices. [(x, y, z) *
     */
    public void setDetailVertices(Vector3f[] detailVertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(detailVertices);
        RecastJNI.dtMeshTile_detailVerts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The detail mesh's unique vertices. [(x, y, z) *
     */
    public Vector3f[] getDetailVertices() {
        long cPtr = RecastJNI.dtMeshTile_detailVerts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getHeader().getDetailVerticesCount());
    }

    /**
     *
     * @param detailTriangles The detail mesh's triangles. [(vertA, vertB,
     * vertC)]
     */
    public void setDetailTriangles(char[] detailTriangles) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(detailTriangles);
        RecastJNI.dtMeshTile_detailTris_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return The detail mesh's triangles. [(vertA, vertB, vertC)]
     */
    public char[] getDetailTriangles() {
        long cPtr = RecastJNI.dtMeshTile_detailTris_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getHeader().getDetailTrianglesCount() * 3);
    }

    /**
     * -not tested yet
     *
     * @param value The tile bounding volume nodes.
     */
    public void setBvTree(BVNode value) {
        RecastJNI.dtMeshTile_bvTree_set(swigCPtr, this, BVNode.getCPtr(value), value);
    }

    /**
     * -not tested yet
     *
     * @return The tile bounding volume nodes.
     */
    public BVNode getBvTree() {
        long cPtr = RecastJNI.dtMeshTile_bvTree_get(swigCPtr, this);
        return (cPtr == 0) ? null : new BVNode(cPtr, false);
    }

    /**
     *
     * @param value The tile off-mesh connections.
     */
    public void setOffMeshConnections(OffMeshConnection value) {
        RecastJNI.dtMeshTile_offMeshCons_set(swigCPtr, this, OffMeshConnection.getCPtr(value), value);
    }

    /**
     *
     * @return The tile off-mesh connections.
     */
    public OffMeshConnection[] getOffMeshConnections() {
        long cPtr = RecastJNI.dtMeshTile_offMeshCons_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToOffMeshConnections(cPtr, getHeader().getOffMeshConnectionsCount());
    }

    /**
     *
     * @param data The tile data. (Not directly accessed under normal
     * situations.)
     */
    public void setData(char[] data) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        RecastJNI.dtMeshTile_data_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return The tile data. (Not directly accessed under normal situations.)
     */
    public char[] getData() {
        long cPtr = RecastJNI.dtMeshTile_data_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getDataSize());
    }

    /**
     *
     * @param value Size of the tile data.
     */
    public void setDataSize(int value) {
        RecastJNI.dtMeshTile_dataSize_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Size of the tile data.
     */
    public int getDataSize() {
        return RecastJNI.dtMeshTile_dataSize_get(swigCPtr, this);
    }

    /**
     *
     * @param value Tile flags.
     */
    public void setFlags(int value) {
        RecastJNI.dtMeshTile_flags_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Tile flags.
     */
    public int getFlags() {
        return RecastJNI.dtMeshTile_flags_get(swigCPtr, this);
    }

    /**
     *
     * @param value The next free tile, or the next tile in the spatial grid.
     */
    public void setNext(MeshTile value) {
        RecastJNI.dtMeshTile_next_set(swigCPtr, this, MeshTile.getCPtr(value), value);
    }

    /**
     *
     * @return The next free tile, or the next tile in the spatial grid.
     */
    public MeshTile getNext() {
        long cPtr = RecastJNI.dtMeshTile_next_get(swigCPtr, this);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }

    protected void setSwigCPtr(long swigCPtr) {
        if (this.swigCPtr==swigCPtr) {
            return;
        }
        delete();
        this.swigCPtr = swigCPtr;
    }
}
