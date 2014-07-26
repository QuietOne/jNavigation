package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.recast.Config;
import com.jme3.ai.navigation.recast.PolyMesh;
import com.jme3.ai.navigation.recast.PolyMeshDetail;
import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 * Represents the source data used to build an navigation mesh tile.
 *
 * This structure is used to marshal data between the Recast mesh generation
 * pipeline and Detour navigation components.
 *
 * See the PolyMesh and PolyMeshDetail documentation for detailed information
 * related to mesh structure.
 *
 * Units are usually in voxels (vx) or world units (wu). The units for voxels,
 * grid size, and cell size are all based on the values of cs and ch.
 *
 * The standard navigation mesh build process is to create tile data using
 * createNavMeshData, then add the tile to a navigation mesh using either the
 * NavMesh single tile init() function or the NavMesh.addTile() function.
 *
 * @see PolyMesh
 * @see PolyMeshDetail
 * @see NavMesh#init(com.jme3.ai.navigation.detour.NavMeshParams)
 * @see NavMesh#addTile(char[], int, long, int[])
 * @see
 * DetourBuilder#createNavMeshData(com.jme3.ai.navigation.detour.NavMeshCreateParams)
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class NavMeshCreateParams {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NavMeshCreateParams() {
        this(RecastJNI.new_dtNavMeshCreateParams(), true);
    }

    protected NavMeshCreateParams(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NavMeshCreateParams obj) {
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
                RecastJNI.delete_dtNavMeshCreateParams(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     * Get data from poly mesh that are needed to create params for navigation
     * mesh.
     *
     * @param polyMesh
     */
    public void getData(PolyMesh polyMesh) {
        setVertices(polyMesh.getVertices());
        setVerticesCount(polyMesh.getNumberOfVertices());
        setPolygons(polyMesh.getPolygons());
        setPolygonAreas(polyMesh.getAreas());
        setPolygonFlags(polyMesh.getFlags());
        setPolygonCount(polyMesh.getNumberOfPolygons());
        setNumberOfVerticesPerPolygon(polyMesh.getNumberOfVerticesPerPolygon());
        setMaxBounds(polyMesh.getMaxBounds());
        setMinBounds(polyMesh.getMinBounds());
    }

    /**
     * Get data from poly mesh detail that are needed to create params for
     * navigation mesh.
     *
     * @param detailMesh
     */
    public void getData(PolyMeshDetail detailMesh) {
        setDetailMeshes(detailMesh.getMeshes());
        setDetailVertices(detailMesh.getVertices());
        setDetailVerticesCount(detailMesh.getNumberOfVertices());
        setDetailTriangles(detailMesh.getTriangles());
        setDetailTriangleCount(detailMesh.getNumberOfTriangles());
    }

    /**
     * Get data from config that are needed to create params for navigation
     * mesh.
     *
     * @param config
     */
    public void getData(Config config) {
        setWalkableHeight(config.getWalkableHeight() * config.getCellHeight());
        setWalkableClimb(config.getWalkableClimb() * config.getCellHeight());
        setWalkableRadius(config.getWalkableRadius() * config.getCellSize());
        setCellHeight(config.getCellHeight());
        setCellSize(config.getCellSize());
    }

    /**
     * Updates the number of vertices and verticesCount.
     *
     * @param vertices The polygon mesh vertices.
     */
    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.dtNavMeshCreateParams_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The polygon mesh vertices.
     */
    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_verts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getVerticesCount());
    }

    /**
     *
     * @param value The number vertices in the polygon mesh. [Limit: >= 3].
     */
    public void setVerticesCount(int value) {
        RecastJNI.dtNavMeshCreateParams_vertCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number vertices in the polygon mesh. [Limit: >= 3].
     */
    public int getVerticesCount() {
        return RecastJNI.dtNavMeshCreateParams_vertCount_get(swigCPtr, this);
    }

    /**
     *
     * @param polygons The polygon data.
     */
    public void setPolygons(short[] polygons) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygons);
        RecastJNI.dtNavMeshCreateParams_polys_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The polygon data.
     */
    public short[] getPolygons() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_polys_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getPolygonCount() * 2 * getNumberOfVerticesPerPolygon());
    }

    /**
     *
     * @param polygonFlags The user defined flags assigned to each polygon.
     */
    public void setPolygonFlags(short[] polygonFlags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygonFlags);
        RecastJNI.dtNavMeshCreateParams_polyFlags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The user defined flags assigned to each polygon.
     */
    public short[] getPolygonFlags() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_polyFlags_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getPolygonCount());
    }

    /**
     *
     * @param polygonAreas The user defined area ids assigned to each polygon.
     */
    public void setPolygonAreas(char[] polygonAreas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(polygonAreas);
        RecastJNI.dtNavMeshCreateParams_polyAreas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return The user defined area ids assigned to each polygon.
     */
    public char[] getPolygonAreas() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_polyAreas_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getPolygonCount());
    }

    /**
     *
     * @param value Number of polygons in the mesh. [Limit: >= 1].
     */
    public void setPolygonCount(int value) {
        RecastJNI.dtNavMeshCreateParams_polyCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Number of polygons in the mesh. [Limit: >= 1].
     */
    public int getPolygonCount() {
        return RecastJNI.dtNavMeshCreateParams_polyCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value Number maximum number of vertices per polygon. [Limit: >=
     * 3].
     */
    public void setNumberOfVerticesPerPolygon(int value) {
        RecastJNI.dtNavMeshCreateParams_nvp_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Number maximum number of vertices per polygon. [Limit: >= 3].
     */
    public int getNumberOfVerticesPerPolygon() {
        return RecastJNI.dtNavMeshCreateParams_nvp_get(swigCPtr, this);
    }

    /**
     *
     * @param detailMeshes The height detail sub-mesh data.
     */
    public void setDetailMeshes(int[] detailMeshes) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(detailMeshes);
        RecastJNI.dtNavMeshCreateParams_detailMeshes_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    /**
     *
     * @return The height detail sub-mesh data.
     */
    public int[] getDetailMeshes() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_detailMeshes_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToInts(cPtr, getPolygonCount() * 4);
    }

    /**
     *
     * @param detailVertices The detail mesh vertices.
     */
    public void setDetailVertices(Vector3f[] detailVertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(detailVertices);
        RecastJNI.dtNavMeshCreateParams_detailVerts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The detail mesh vertices.
     */
    public Vector3f[] getDetailVertices() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_detailVerts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getDetailVerticesCount());
    }

    /**
     *
     * @param value The number of vertices in the detail mesh.
     */
    public void setDetailVerticesCount(int value) {
        RecastJNI.dtNavMeshCreateParams_detailVertsCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices in the detail mesh.
     */
    public int getDetailVerticesCount() {
        return RecastJNI.dtNavMeshCreateParams_detailVertsCount_get(swigCPtr, this);
    }

    /**
     *
     * @param detailTriangles The detail mesh triangles.
     */
    public void setDetailTriangles(char[] detailTriangles) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(detailTriangles);
        RecastJNI.dtNavMeshCreateParams_detailTris_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return The detail mesh triangles.
     */
    public char[] getDetailTriangles() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_detailTris_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getDetailTriangleCount() * 4);
    }

    /**
     *
     * @param value The number of triangles in the detail mesh.
     */
    public void setDetailTriangleCount(int value) {
        RecastJNI.dtNavMeshCreateParams_detailTriCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of triangles in the detail mesh.
     */
    public int getDetailTriangleCount() {
        return RecastJNI.dtNavMeshCreateParams_detailTriCount_get(swigCPtr, this);
    }

    /**
     *
     * @param connectionVertices Off-mesh connection vertices. [(ax, ay, az, bx,
     * by, bz)]
     */
    public void setOffMeshConnectionVertices(Vector3f[] connectionVertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(connectionVertices);
        RecastJNI.dtNavMeshCreateParams_offMeshConVerts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return Off-mesh connection vertices. [(ax, ay, az, bx, by, bz)]
     */
    public Vector3f[] getOffMeshConnectionVertices() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConVerts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getOffMeshConnectionCount() * 2);
    }

    /**
     *
     * @param radii Off-mesh connection radii.
     */
    public void setOffMeshConnectionRadii(float[] radii) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(radii);
        RecastJNI.dtNavMeshCreateParams_offMeshConRad_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return Off-mesh connection radii.
     */
    public float[] getOffMeshConnectionRadii() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConRad_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToFloats(cPtr, getOffMeshConnectionCount());
    }

    /**
     *
     * @param connectionFlags User defined flags assigned to the off-mesh
     * connections.
     */
    public void setOffMeshConnectionFlags(short[] connectionFlags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(connectionFlags);
        RecastJNI.dtNavMeshCreateParams_offMeshConFlags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return User defined flags assigned to the off-mesh connections.
     */
    public short[] getOffMeshConnectionFlags() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConFlags_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getOffMeshConnectionCount());
    }

    /**
     *
     * @param connectionAreas User defined area ids assigned to the off-mesh
     * connections.
     */
    public void setOffMeshConnectionAreas(char[] connectionAreas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connectionAreas);
        RecastJNI.dtNavMeshCreateParams_offMeshConAreas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return User defined area ids assigned to the off-mesh connections.
     */
    public char[] getOffMeshConnectionAreas() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConAreas_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getOffMeshConnectionCount());
    }

    /**
     * 0 = Travel only from endpoint A to endpoint B.
     *
     * DT_OFFMESH_CON_BIDIR = Bidirectional travel.
     *
     * @param connectionDirections The permitted travel direction of the
     * off-mesh connections.
     */
    public void setOffMeshConnectionDirection(char[] connectionDirections) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connectionDirections);
        RecastJNI.dtNavMeshCreateParams_offMeshConDir_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     * 0 = Travel only from endpoint A to endpoint B.
     *
     * DT_OFFMESH_CON_BIDIR = Bidirectional travel.
     *
     * @return The permitted travel direction of the off-mesh connections.
     */
    public char[] getOffMeshConnectionDirection() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConDir_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getOffMeshConnectionCount());
    }

    /**
     *
     * @param connectionUserIDs The user defined ids of the off-mesh connection.
     */
    public void setOffMeshConnectionUserID(int[] connectionUserIDs) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(connectionUserIDs);
        RecastJNI.dtNavMeshCreateParams_offMeshConUserID_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    /**
     *
     * @return The user defined ids of the off-mesh connection.
     */
    public int[] getOffMeshConnectionUserID() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConUserID_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToInts(cPtr, getOffMeshConnectionCount());
    }

    /**
     *
     * @param value The number of off-mesh connections. [Limit: >= 0].
     */
    public void setOffMeshConnectionCount(int value) {
        RecastJNI.dtNavMeshCreateParams_offMeshConCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of off-mesh connections. [Limit: >= 0].
     */
    public int getOffMeshConnectionCount() {
        return RecastJNI.dtNavMeshCreateParams_offMeshConCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The user defined id of the tile.
     */
    public void setUserId(long value) {
        RecastJNI.dtNavMeshCreateParams_userId_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The user defined id of the tile.
     */
    public long getUserId() {
        return RecastJNI.dtNavMeshCreateParams_userId_get(swigCPtr, this);
    }

    /**
     *
     * @param value The tile's x-grid location within the multi-tile destination
     * mesh. (Along the x-axis.)
     */
    public void setTileX(int value) {
        RecastJNI.dtNavMeshCreateParams_tileX_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The tile's x-grid location within the multi-tile destination
     * mesh. (Along the x-axis.)
     */
    public int getTileX() {
        return RecastJNI.dtNavMeshCreateParams_tileX_get(swigCPtr, this);
    }

    /**
     *
     * @param value The tile's y-grid location within the multi-tile desitation
     * mesh. (Along the z-axis.)
     */
    public void setTileY(int value) {
        RecastJNI.dtNavMeshCreateParams_tileY_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The tile's y-grid location within the multi-tile desitation mesh.
     * (Along the z-axis.)
     */
    public int getTileY() {
        return RecastJNI.dtNavMeshCreateParams_tileY_get(swigCPtr, this);
    }

    /**
     *
     * @param value The tile's layer within the layered destination mesh.
     */
    public void setTileLayer(int value) {
        RecastJNI.dtNavMeshCreateParams_tileLayer_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The tile's layer within the layered destination mesh.
     */
    public int getTileLayer() {
        return RecastJNI.dtNavMeshCreateParams_tileLayer_get(swigCPtr, this);
    }

    /**
     *
     * @param minBounds The minimum bounds of the tile
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.dtNavMeshCreateParams_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds of the tile
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_bmin_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBounds The maximum bounds of the tile.
     */
    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.dtNavMeshCreateParams_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds of the tile.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_bmax_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value The agent height.
     */
    public void setWalkableHeight(float value) {
        RecastJNI.dtNavMeshCreateParams_walkableHeight_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The agent height.
     */
    public float getWalkableHeight() {
        return RecastJNI.dtNavMeshCreateParams_walkableHeight_get(swigCPtr, this);
    }

    /**
     *
     * @param value The agent radius.
     */
    public void setWalkableRadius(float value) {
        RecastJNI.dtNavMeshCreateParams_walkableRadius_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The agent radius.
     */
    public float getWalkableRadius() {
        return RecastJNI.dtNavMeshCreateParams_walkableRadius_get(swigCPtr, this);
    }

    /**
     *
     * @param value The agent maximum traversable ledge. (Up/Down)
     */
    public void setWalkableClimb(float value) {
        RecastJNI.dtNavMeshCreateParams_walkableClimb_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The agent maximum traversable ledge. (Up/Down)
     */
    public float getWalkableClimb() {
        return RecastJNI.dtNavMeshCreateParams_walkableClimb_get(swigCPtr, this);
    }

    /**
     *
     * @param value The xz-plane cell size of the polygon mesh. [Limit: > 0]
     * [Unit: wu].
     */
    public void setCellSize(float value) {
        RecastJNI.dtNavMeshCreateParams_cs_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The xz-plane cell size of the polygon mesh. [Limit: > 0] [Unit:
     * wu].
     */
    public float getCellSize() {
        return RecastJNI.dtNavMeshCreateParams_cs_get(swigCPtr, this);
    }

    /**
     *
     * @param value The y-axis cell height of the polygon mesh. [Limit: > 0]
     * [Unit: wu].
     */
    public void setCellHeight(float value) {
        RecastJNI.dtNavMeshCreateParams_ch_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The y-axis cell height of the polygon mesh. [Limit: > 0] [Unit:
     * wu].
     */
    public float getCellHeight() {
        return RecastJNI.dtNavMeshCreateParams_ch_get(swigCPtr, this);
    }

    /**
     * The BVTree is not normally needed for layered navigation meshes.
     *
     * @param value True if a bounding volume tree should be built for the tile.
     */
    public void setBuildBvTree(boolean value) {
        RecastJNI.dtNavMeshCreateParams_buildBvTree_set(swigCPtr, this, value);
    }

    /**
     * The BVTree is not normally needed for layered navigation meshes.
     *
     * @return True if a bounding volume tree should be built for the tile.
     */
    public boolean isBuildBvTree() {
        return RecastJNI.dtNavMeshCreateParams_buildBvTree_get(swigCPtr, this);
    }
}
