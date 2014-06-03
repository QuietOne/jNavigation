package com.jme3.ai.detour.util;

import com.jme3.ai.recast.structures.PolyMesh;
import com.jme3.ai.recast.structures.PolyMeshDetail;
import com.jme3.math.Vector3f;

/**
 * Represents the source data used to build an navigation mesh tile.
 *
 * This structure is used to marshal data between the Recast mesh generation
 * pipeline and Detour navigation components.
 *
 * See the rcPolyMesh and rcPolyMeshDetail documentation for detailed
 * information related to mesh structure.
 *
 * Units are usually in voxels (vx) or world units (wu). The units for voxels,
 * grid size, and cell size are all based on the values of cs and ch.
 *
 * The standard navigation mesh build process is to create tile data using
 * dtCreateNavMeshData, then add the tile to a navigation mesh using either the
 * dtNavMesh single tile init() function or the dtNavMesh::addTile() function.
 *
 * @author Tihomir Radosavljevic
 */
public class NavMeshCreateParams {

    /**
     * The user defined area ids assigned to each polygon.
     *
     * @see PolyMesh
     */
    private char[] areas;
    /**
     * The user defined flags for each polygon.
     *
     * @see PolyMesh
     */
    private short[] flags;
    /**
     * Number of polygons in the mesh.
     *
     * @see PolyMesh
     */
    private int numberOfPolygons;
    /**
     * The maximum number of vertices per polygon.
     *
     * @see PolyMesh
     */
    private int maximumNumberOfVerticesPerPolygon;
    /**
     * Polygon and neighbor data.
     *
     * @see PolyMesh
     */
    private short[] polygons;
    /**
     * The polygon mesh vertices. [(x, y, z) * vertCount] [Unit: vx].
     *
     * @see PolyMesh
     */
    private short[] vertices;
    /**
     * The height detail sub-mesh data. [Size: 4 * polyCount]. Optional.
     *
     * @see PolyMeshDetail
     */
    private int[] polyDetailMeshes;
    /**
     * The detail mesh vertices. [Size: 3 * detailVertsCount] [Unit: wu].
     * Optional.
     *
     * @see PolyMeshDetail
     */
    private Vector3f polyDetailVertices;
    /**
     * The detail mesh triangles. [Size: 4 * detailTriCount]. Optional.
     *
     * @see PolyMeshDetail
     */
    private char[] polyDetailTriangles;
    /**
     * Off-mesh connection vertices. [(ax, ay, az, bx, by, bz) *
     * offMeshConCount] [Unit: wu].
     */
    private Vector3f[] offMeshConnectionVertices;
    /**
     * Off-mesh connection radii. [Unit: wu].
     */
    private float[] offMeshConnectionRadii;
    /**
     * User defined flags assigned to the off-mesh connections.
     */
    private short[] offMeshConnectionFlags;
    /**
     * User defined area ids assigned to the off-mesh connections.
     */
    private char[] offMeshConnectionAreas;
    /**
     * The permitted travel direction of the off-mesh connections.
     *
     * 0 = Travel only from endpoint A to endpoint B. DT_OFFMESH_CON_BIDIR =
     * Bidirectional travel.
     */
    private char[] offMeshConnectionDirection;
    /**
     * The user defined ids of the off-mesh connection.
     */
    private int[] offMeshConnectionUserID;
    /**
     * The user defined id of the tile. Can be left at zero if the destination
     * is a single tile mesh.
     */
    private int userID;
    /**
     * The tile's x-grid location within the multi-tile destination mesh. (Along
     * the x-axis.) Can be left at zero if the destination is a single tile
     * mesh.
     */
    private int tileX;
    /**
     * The tile's y-grid location within the multi-tile desitation mesh. (Along
     * the z-axis.) Can be left at zero if the destination is a single tile
     * mesh.
     */
    private int tileY;
    /**
     * The tile's layer within the layered destination mesh. Limit: >= 0 Can be
     * left at zero if the destination is a single tile mesh.
     */
    private int tileLayer;
    /**
     * The minimum bounds of the tile. [(x, y, z)] [Unit: wu]. Can be left at
     * zero if the destination is a single tile mesh.
     */
    private Vector3f minBounds;
    /**
     * The maximum bounds of the tile. [(x, y, z)] [Unit: wu]. Can be left at
     * zero if the destination is a single tile mesh.
     */
    private Vector3f maxBounds;
    /**
     * The agent height. [Unit: wu].
     */
    private float walkableHeight;
    /**
     * The agent radius. [Unit: wu].
     */
    private float walkableRadius;
    /**
     * The agent maximum traversable ledge. (Up/Down) [Unit: wu].
     */
    private float walkableClimb;
    /**
     * The xz-plane cell size of the polygon mesh. [Limit: > 0] [Unit: wu].
     */
    private float cellSize;
    /**
     * The y-axis cell height of the polygon mesh. [Limit: > 0] [Unit: wu].
     */
    private float cellHeight;
    /**
     * True if a bounding volume tree should be built for the tile.
     *
     * Note The BVTree is not normally needed for layered navigation meshes.
     */
    private boolean buildBoundingVolumeTree;
    private Object reference;

    public NavMeshCreateParams() {
        reference = allocNavMeshCreateParams();
    }

    private native Object allocNavMeshCreateParams();

    public char[] getAreas() {
        return areas;
    }

    public void setAreas(char[] areas) {
        this.areas = areas;
        setAreas();
    }
    
    private native void setAreas();

    public short[] getFlags() {
        return flags;
    }

    public void setFlags(short[] flags) {
        this.flags = flags;
        setFlags();
    }
    
    private native void setFlags();

    public int getNumberOfPolygons() {
        return numberOfPolygons;
    }

    public void setNumberOfPolygons(int numberOfPolygons) {
        this.numberOfPolygons = numberOfPolygons;
        setNumberOfPolygons();
    }
    
    private native void setNumberOfPolygons();

    public int getMaximumNumberOfVerticesPerPolygon() {
        return maximumNumberOfVerticesPerPolygon;
    }

    public void setMaximumNumberOfVerticesPerPolygon(int maximumNumberOfVerticesPerPolygon) {
        this.maximumNumberOfVerticesPerPolygon = maximumNumberOfVerticesPerPolygon;
        setMaximumNumberOfVerticesPerPolygon();
    }
    
    private native void setMaximumNumberOfVerticesPerPolygon();

    public short[] getPolygons() {
        return polygons;
    }

    public void setPolygons(short[] polygons) {
        this.polygons = polygons;
        setPolygons();
    }
    
    private native void setPolygons();

    public short[] getVertices() {
        return vertices;
    }

    public void setVertices(short[] vertices) {
        this.vertices = vertices;
        setVertices();
    }
    
    private native void setVertices();

    public int[] getPolyDetailMeshes() {
        return polyDetailMeshes;
    }

    public void setPolyDetailMeshes(int[] polyDetailMeshes) {
        this.polyDetailMeshes = polyDetailMeshes;
        setPolyDetailMeshes();
    }
    
    private native void setPolyDetailMeshes();

    public Vector3f getPolyDetailVertices() {
        return polyDetailVertices;
    }

    public void setPolyDetailVertices(Vector3f polyDetailVertices) {
        this.polyDetailVertices = polyDetailVertices;
        setPolyDetailVertices();
    }
    
    private native void setPolyDetailVertices();

    public char[] getPolyDetailTriangles() {
        return polyDetailTriangles;
    }

    public void setPolyDetailTriangles(char[] polyDetailTriangles) {
        this.polyDetailTriangles = polyDetailTriangles;
        setPolyDetailTriangles();
    }
    
    private native void setPolyDetailTriangles();

    public Vector3f[] getOffMeshConnectionVertices() {
        return offMeshConnectionVertices;
    }

    public void setOffMeshConnectionVertices(Vector3f[] offMeshConnectionVertices) {
        this.offMeshConnectionVertices = offMeshConnectionVertices;
        setOffMeshConnectionVertices();
    }
    
    private native void setOffMeshConnectionVertices();

    public float[] getOffMeshConnectionRadii() {
        return offMeshConnectionRadii;
    }

    public void setOffMeshConnectionRadii(float[] offMeshConnectionRadii) {
        this.offMeshConnectionRadii = offMeshConnectionRadii;
        setOffMeshConnectionRadii();
    }
    
    private native void setOffMeshConnectionRadii();

    public short[] getOffMeshConnectionFlags() {
        return offMeshConnectionFlags;
    }

    public void setOffMeshConnectionFlags(short[] offMeshConnectionFlags) {
        this.offMeshConnectionFlags = offMeshConnectionFlags;
        setOffMeshConnectionFlags();
    }
    
    private native void setOffMeshConnectionFlags();

    public char[] getOffMeshConnectionAreas() {
        return offMeshConnectionAreas;
    }

    public void setOffMeshConnectionAreas(char[] offMeshConnectionAreas) {
        this.offMeshConnectionAreas = offMeshConnectionAreas;
        setOffMeshConnectionAreas();
    }
    
    private native void setOffMeshConnectionAreas();

    public char[] getOffMeshConnectionDirection() {
        return offMeshConnectionDirection;
    }

    public void setOffMeshConnectionDirection(char[] offMeshConnectionDirection) {
        this.offMeshConnectionDirection = offMeshConnectionDirection;
        setOffMeshConnectionDirection();
    }
    
    private native void setOffMeshConnectionDirection();

    public int[] getOffMeshConnectionUserID() {
        return offMeshConnectionUserID;
    }

    public void setOffMeshConnectionUserID(int[] offMeshConnectionUserID) {
        this.offMeshConnectionUserID = offMeshConnectionUserID;
        setOffMeshConnectionUserID();
    }
    
    private native void setOffMeshConnectionUserID();

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
        setUserID();
    }
    
    private native void setUserID();

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
        setTileX();
    }
    
    private native void setTileX();

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
        setTileY();
    }
    
    private native void setTileY();

    public int getTileLayer() {
        return tileLayer;
    }

    public void setTileLayer(int tileLayer) {
        this.tileLayer = tileLayer;
        setTileLayer();
    }
    
    private native void setTileLayer();

    public Vector3f getMinBounds() {
        return minBounds;
    }

    public void setMinBounds(Vector3f minBounds) {
        this.minBounds = minBounds;
        setMinBounds();
    }
    
    private native void setMinBounds();

    public Vector3f getMaxBounds() {
        return maxBounds;
    }

    public void setMaxBounds(Vector3f maxBounds) {
        this.maxBounds = maxBounds;
        setMaxBounds();
    }
    
    private native void setMaxBounds();

    public float getWalkableHeight() {
        return walkableHeight;
    }

    public void setWalkableHeight(float walkableHeight) {
        this.walkableHeight = walkableHeight;
        setWalkableHeight();
    }
    
    private native void setWalkableHeight();

    public float getWalkableRadius() {
        return walkableRadius;
    }

    public void setWalkableRadius(float walkableRadius) {
        this.walkableRadius = walkableRadius;
        setWalkableRadius();
    }
    
    private native void setWalkableRadius();

    public float getWalkableClimb() {
        return walkableClimb;
    }

    public void setWalkableClimb(float walkableClimb) {
        this.walkableClimb = walkableClimb;
        setWalkableClimb();
    }
    
    private native void setWalkableClimb();

    public float getCellSize() {
        return cellSize;
    }

    public void setCellSize(float cellSize) {
        this.cellSize = cellSize;
        setCellSize();
    }
    
    private native void setCellSize();

    public float getCellHeight() {
        return cellHeight;
    }

    public void setCellHeight(float cellHeight) {
        this.cellHeight = cellHeight;
        setCellHeight();
    }
    
    private native void setCellHeight();

    public boolean isBuildBoundingVolumeTree() {
        return buildBoundingVolumeTree;
    }

    public void setBuildBoundingVolumeTree(boolean buildBoundingVolumeTree) {
        this.buildBoundingVolumeTree = buildBoundingVolumeTree;
        setBuildBoundingVolumeTree();
    }
    
    private native void setBuildBoundingVolumeTree();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        freeNavMeshCreateParams(this);
    }

    private native void freeNavMeshCreateParams(NavMeshCreateParams params);
    
    /**
     * Builds navigation mesh tile data from the provided tile creation data.
     * @return null if unsuccessful
     */
    public char[] createNavMeshData(){
        return dtCreateNavMeshData();
    }
    
    private native char[] dtCreateNavMeshData();
}
