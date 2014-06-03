package com.jme3.ai.detour.structures;

import com.jme3.ai.recast.structures.PolyMeshDetail;
import com.jme3.math.Vector3f;

/**
 * Defines a navigation mesh tile.
 *
 * Tiles generally only exist within the context of a NavMesh object.
 *
 * Some tile content is optional. For example, a tile may not contain any
 * off-mesh connections. In this case the associated pointer will be null.
 *
 * If a detail mesh exists it will share vertices with the base polygon mesh.
 * Only the vertices unique to the detail mesh will be stored in detailVerts.
 *
 * @author Tihomir Radosavljevic
 */
public class MeshTile {

    /**
     * Counter describing modifications to the tile.
     */
    private int salt;
    /**
     * Index to the next free link.
     */
    private int linkFreeList;
    /**
     * The tile header.
     */
    private MeshHeader header;
    /**
     * The tile polygons. [Size: dtMeshHeader::polyCount].
     */
    private Poly[] polygons;
    /**
     * The tile vertices. [Size: dtMeshHeader::vertCount].
     */
    private float[] vertices;
    /**
     * The tile's detail sub-meshes. [Size: dtMeshHeader::detailMeshCount].
     */
    private PolyMeshDetail[] polyDetailMeshes;
    /**
     * The detail mesh's unique vertices. [dtMeshHeader::detailVertCount].
     */
    private Vector3f[] polyDetailVertices;
    /**
     * The detail mesh's triangles. [(vertA, vertB, vertC) *
     * dtMeshHeader::detailTriCount].
     */
    private char[] polyDetailTriangles;
    /**
     * The next free tile, or the next tile in the spatial grid.
     */
    private MeshTile next;

    public int getSalt() {
        getNativeSalt();
        return salt;
    }
    
    private native void getNativeSalt();

    public int getLinkFreeList() {
        getNativeLinkFreeList();
        return linkFreeList;
    }
    
    private native void getNativeLinkFreeList();

    public MeshHeader getHeader() {
        getNativeHeader();
        return header;
    }
    
    private native void getNativeHeader();

    public Poly[] getPolygons() {
        getNativePolygons();
        return polygons;
    }
    
    private native void getNativePolygons();

    public float[] getVertices() {
        getNativeVertices();
        return vertices;
    }
    
    private native void getNativeVertices();

    public PolyMeshDetail[] getPolyDetailMeshes() {
        getNativePolyDetailMeshes();
        return polyDetailMeshes;
    }
    
    private native void getNativePolyDetailMeshes();

    public Vector3f[] getPolyDetailVertices() {
        getNativePolyDetailVertices();
        return polyDetailVertices;
    }
    
    private native void getNativePolyDetailVertices();

    public char[] getPolyDetailTriangles() {
        getNativePolyDetailTriangles();
        return polyDetailTriangles;
    }
    
    private native void getNativePolyDetailTriangles();

    public MeshTile getNext() {
        getNativeNext();
        return next;
    }
    
    private native void getNativeNext();

    
    /**
     * A handle to a tile within a navigation mesh.
     *
     * The following changes will invalidate a tile reference:
     * <ul>
     * <li>The referenced tile has been removed from the navigation mesh.</li>
     * <li>The navigation mesh has been initialized using a different set of
     * NavMeshParams.</li>
     * </ul>
     * A tile reference is preserved/restored if the tile is added to a
     * navigation mesh initialized with the original NavMeshParams and is added
     * at the original reference location. (E.g. The lastRef parameter is used
     * with dtNavMesh::addTile.)
     *
     * Basically, if the storage structure of a tile changes, its associated
     * tile reference changes.
     */
    public class TileRef {

        private Object reference;

        private TileRef() {
        }
        
    }
}
