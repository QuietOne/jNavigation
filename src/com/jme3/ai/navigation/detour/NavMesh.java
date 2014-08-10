package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.recast.PolyMesh;
import com.jme3.ai.navigation.recast.PolyMeshDetail;
import com.jme3.ai.navigation.tilecache.TileFlags;
import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.IntArray;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_dtPoly;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_dtMeshTile;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;

/**
 * A navigation mesh based on tiles of convex polygons.
 *
 * The navigation mesh consists of one or more tiles defining three primary
 * types of structural data:
 *
 * A polygon mesh which defines most of the navigation graph. (See PolyMesh for
 * its structure.) A detail mesh used for determining surface height on the
 * polygon mesh. (See PolyMeshDetail for its structure.) Off-mesh connections,
 * which define custom point-to-point edges within the navigation graph.
 *
 * @see PolyMesh
 * @see PolyMeshDetail
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class NavMesh {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NavMesh() {
        swigCPtr = RecastJNI.dtAllocNavMesh();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    protected NavMesh(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NavMesh obj) {
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
                RecastJNI.dtFreeNavMesh(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    /**
     * Initializes the navigation mesh for tiled use.
     *
     * @param params Initialization parameters.
     * @return The status flags for the operation.
     */
    public Status init(NavMeshParams params) {
        return new Status(RecastJNI.dtNavMesh_init__SWIG_0(swigCPtr, this, NavMeshParams.getCPtr(params), params));
    }

    /**
     * Initializes the navigation mesh for single tile use.
     *
     * @see
     * DetourBuilder#createNavMeshData(com.jme3.ai.navigation.detour.NavMeshCreateParams)
     * @see TileFlags
     *
     * @param data Data of the new tile.
     * @param flags The tile flags.
     * @return
     */
    public Status init(char[] data, int flags) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        int dataSize = data.length;
        return new Status(RecastJNI.dtNavMesh_init__SWIG_1(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value), dataSize, flags));
    }

    /**
     * The navigation mesh initialization params.
     *
     * Note: The parameters are created automatically when the single tile
     * initialization is performed.
     *
     * @return
     */
    public NavMeshParams getParams() {
        long cPtr = RecastJNI.dtNavMesh_getParams(swigCPtr, this);
        return (cPtr == 0) ? null : new NavMeshParams(cPtr, false);
    }

    /**
     * Adds a tile to the navigation mesh. The add operation will fail if the
     * data is in the wrong format, the allocated tile space is full, or there
     * is a tile already at the specified reference.
     *
     * The lastRef parameter is used to restore a tile with the same tile
     * reference it had previously used. In this case the PolyRef's for the tile
     * will be restored to the same values they were before the tile was
     * removed.
     *
     * @param data Data for the new tile mesh.
     * @param flags Tile flags
     * @see TileFlags
     * @param lastRef The desired reference for the tile. (When reloading a
     * tile.) [opt] [Default: 0]
     * @param result The tile reference. (If the tile was succesfully added.)
     * [opt]
     * @return The status flags for the operation.
     */
    public Status addTile(char[] data, int flags, long lastRef, int[] result) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        int dataSize = data.length;
        SWIGTYPE_p_unsigned_int value1 = Converter.convertToSWIGTYPE_p_unsigned_int(result);
        return new Status(RecastJNI.dtNavMesh_addTile(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value), dataSize, flags, lastRef, SWIGTYPE_p_unsigned_int.getCPtr(value1)));
    }

    //data is output too
    public Status removeTile(long ref, SWIGTYPE_p_p_unsigned_char data, SWIGTYPE_p_int dataSize) {
        return new Status(RecastJNI.dtNavMesh_removeTile(swigCPtr, this, ref, SWIGTYPE_p_p_unsigned_char.getCPtr(data), SWIGTYPE_p_int.getCPtr(dataSize)));
    }

    /**
     * Calculates the tile grid location X for the specified world position.
     *
     * @param position The world position for the query.
     * @return The tile's x-location.
     */
    public int calculateTileLocationX(Vector3f position) {
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_int tx = new IntArray(1).cast();
        SWIGTYPE_p_int ty = new IntArray(1).cast();
        RecastJNI.dtNavMesh_calcTileLoc(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_int.getCPtr(tx), SWIGTYPE_p_int.getCPtr(ty));
        IntArray a = new IntArray(SWIGTYPE_p_int.getCPtr(tx), false);
        return a.getItem(0);
    }

    /**
     * Calculates the tile grid location Y for the specified world position.
     *
     * @param position The world position for the query.
     * @return The tile's y-location.
     */
    public int calculateTileLocationY(Vector3f position) {
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_int tx = new IntArray(1).cast();
        SWIGTYPE_p_int ty = new IntArray(1).cast();
        RecastJNI.dtNavMesh_calcTileLoc(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_int.getCPtr(tx), SWIGTYPE_p_int.getCPtr(ty));
        IntArray a = new IntArray(SWIGTYPE_p_int.getCPtr(ty), false);
        return a.getItem(0);
    }

    /**
     * Gets the tile at the specified grid location.
     *
     * @param x The tile's x-location. (x, y, layer)
     * @param y The tile's y-location. (x, y, layer)
     * @param layer The tile's layer. (x, y, layer)
     * @return The tile, or null if the tile does not exist.
     */
    public MeshTile getTileAt(int x, int y, int layer) {
        long cPtr = RecastJNI.dtNavMesh_getTileAt(swigCPtr, this, x, y, layer);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }
//  - not operational
//    public MeshTile[] getTilesAt(int x, int y, int maxTiles) {
//        SWIGTYPE_p_p_dtMeshTile tiles = 
//        return RecastJNI.dtNavMesh_getTilesAt(swigCPtr, this, x, y, SWIGTYPE_p_p_dtMeshTile.getCPtr(tiles), maxTiles);
//    }

    /**
     * Gets the tile reference for the tile at specified grid location.
     *
     * @param x The tile's x-location. (x, y, layer)
     * @param y The tile's y-location. (x, y, layer)
     * @param layer The tile's layer. (x, y, layer)
     * @return The tile reference of the tile, or 0 if there is none.
     */
    public long getTileRefAt(int x, int y, int layer) {
        return RecastJNI.dtNavMesh_getTileRefAt(swigCPtr, this, x, y, layer);
    }

    /**
     * Gets the tile reference for the specified tile.
     *
     * @param tile The tile.
     * @return The tile reference of the tile.
     */
    public long getTileRef(MeshTile tile) {
        return RecastJNI.dtNavMesh_getTileRef(swigCPtr, this, MeshTile.getCPtr(tile), tile);
    }

    /**
     * Gets the tile for the specified tile reference.
     *
     * @param ref The tile reference of the tile to retrieve.
     * @return The tile for the specified reference, or null if the reference is
     * invalid.
     */
    public MeshTile getTileByRef(long ref) {
        long cPtr = RecastJNI.dtNavMesh_getTileByRef(swigCPtr, this, ref);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }

    /**
     *
     * @return The maximum number of tiles supported by the navigation mesh.
     */
    public int getMaxTiles() {
        return RecastJNI.dtNavMesh_getMaxTiles(swigCPtr, this);
    }

    /**
     * Gets the tile at the specified index.
     *
     * @param i The tile index. [Limit: 0 >= index less than getMaxTiles()]
     *
     * @return The tile at the specified index.
     */
    public MeshTile getTile(int i) {
        long cPtr = RecastJNI.dtNavMesh_getTile(swigCPtr, this, i);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }

    /**
     * Gets the tile and polygon for the specified polygon reference.
     *
     * @param ref The reference for the a polygon.
     * @param meshTile The tile containing the polygon. [out]
     * @param poly The polygon. [out]
     * @return The status flags for the operation.
     */
    public Status getTileAndPolyByRef(long ref, MeshTile meshTile, Poly poly) {
        SWIGTYPE_p_p_dtMeshTile tile = new SWIGTYPE_p_p_dtMeshTile(MeshTile.getCPtr(meshTile), false);
        SWIGTYPE_p_p_dtPoly poly1 = new SWIGTYPE_p_p_dtPoly(Poly.getCPtr(poly), false);
        long ptr = RecastJNI.dtNavMesh_getTileAndPolyByRef(swigCPtr, this, ref, SWIGTYPE_p_p_dtMeshTile.getCPtr(tile), SWIGTYPE_p_p_dtPoly.getCPtr(poly1));
        meshTile.setSwigCPtr(SWIGTYPE_p_p_dtMeshTile.getCPtr(tile));
        poly.setSwigCPtr(SWIGTYPE_p_p_dtPoly.getCPtr(poly1));
        return (ptr == 0) ? null : new Status(ptr);
    }

    /**
     * Returns the tile and polygon for the specified polygon reference.
     *
     * WARNING: Only use this function if it is known that the provided polygon
     * reference is valid. This function is faster than getTileAndPolyByRef, but
     * it does not validate the reference.
     *
     * @see NavMesh#getTileAndPolyByRef(long,
     * com.jme3.ai.navigation.detour.MeshTile,
     * com.jme3.ai.navigation.detour.Poly)
     *
     * @param ref A known valid reference for a polygon.
     * @param meshTile The tile containing the polygon. [out]
     * @param poly The polygon. [out]
     */
    public void getTileAndPolyByRefUnsafe(long ref, MeshTile meshTile, Poly poly) {
        SWIGTYPE_p_p_dtMeshTile tile = new SWIGTYPE_p_p_dtMeshTile(MeshTile.getCPtr(meshTile), false);
        SWIGTYPE_p_p_dtPoly poly1 = new SWIGTYPE_p_p_dtPoly(Poly.getCPtr(poly), false);
        RecastJNI.dtNavMesh_getTileAndPolyByRefUnsafe(swigCPtr, this, ref, SWIGTYPE_p_p_dtMeshTile.getCPtr(tile), SWIGTYPE_p_p_dtPoly.getCPtr(poly1));
        meshTile.setSwigCPtr(SWIGTYPE_p_p_dtMeshTile.getCPtr(tile));
        poly.setSwigCPtr(SWIGTYPE_p_p_dtPoly.getCPtr(poly1));
    }

    /**
     * Checks the validity of a polygon reference.
     *
     * @param ref The polygon reference to check.
     * @return True if polygon reference is valid for the navigation mesh.
     */
    public boolean isValidPolyRef(long ref) {
        return RecastJNI.dtNavMesh_isValidPolyRef(swigCPtr, this, ref);
    }

    /**
     * Gets the polygon reference for the tile's base polygon.
     *
     * @param tile The tile.
     * @return The polygon reference for the base polygon in the specified tile.
     */
    public Poly getPolyRefBase(MeshTile tile) {
        long ref = RecastJNI.dtNavMesh_getPolyRefBase(swigCPtr, this, MeshTile.getCPtr(tile), tile);
        return (ref == 0) ? null : new Poly(ref, false);
    }

    /**
     * Gets the endpoints for an off-mesh connection, ordered by "direction of
     * travel".
     *
     * Off-mesh connections are stored in the navigation mesh as special
     * 2-vertex polygons with a single edge. At least one of the vertices is
     * expected to be inside a normal polygon. So an off-mesh connection is
     * "entered" from a normal polygon at one of its endpoints. This is the
     * polygon identified by the prev parameter.
     *
     * @param prev The reference of the polygon before the connection.
     * @param poly The reference of the off-mesh connection polygon.
     * @param start The start position of the off-mesh connection. [out]
     * @param end The end position of the off-mesh connection. [out]
     * @return The status flags for the operation.
     */
    public Status getOffMeshConnectionPolyEndPoints(Poly prev, Poly poly, Vector3f start, Vector3f end) {
        long prevRef = Poly.getCPtr(prev);
        long polyRef = Poly.getCPtr(poly);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(start);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(end);
        return new Status(RecastJNI.dtNavMesh_getOffMeshConnectionPolyEndPoints(swigCPtr, this, prevRef, polyRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos)));
    }

    /**
     * Gets the specified off-mesh connection.
     *
     * @param poly The polygon reference of the off-mesh connection.
     * @return The specified off-mesh connection, or null if the polygon
     * reference is not valid.
     */
    public OffMeshConnection getOffMeshConnection(Poly poly) {
        long ref = Poly.getCPtr(poly);
        long cPtr = RecastJNI.dtNavMesh_getOffMeshConnectionByRef(swigCPtr, this, ref);
        return (cPtr == 0) ? null : new OffMeshConnection(cPtr, false);
    }

    /**
     * Sets the user defined flags for the specified polygon.
     *
     * @param ref The polygon reference.
     * @param flags The new flags for the polygon.
     * @return The status flags for the operation.
     */
    public Status setPolyFlags(long ref, int flags) {
        long status = RecastJNI.dtNavMesh_setPolyFlags(swigCPtr, this, ref, flags);
        return (status == 0) ? null : new Status(status);
    }

    /**
     * Gets the user defined flags for the specified polygon.
     *
     * @param poly The polygon reference.
     * @param resultFlags The polygon flags.
     * @return The status flags for the operation.
     */
    public Status getPolyFlags(Poly poly, Short resultFlags) {
        long ref = Poly.getCPtr(poly);
        return new Status(RecastJNI.dtNavMesh_getPolyFlags(swigCPtr, this, ref, resultFlags));
    }

    /**
     * Sets the user defined area for the specified polygon.
     *
     * @param ref The polygon reference.
     * @param area The new area id for the polygon. [Limit: less than MAX_AREAS]
     * @return The status flags for the operation.
     */
    public Status setPolyArea(long ref, short area) {
        long status = RecastJNI.dtNavMesh_setPolyArea(swigCPtr, this, ref, area);
        return (status == 0) ? null : new Status(status);
    }

    /**
     * Gets the user defined area for the specified polygon.
     *
     * @param poly The polygon reference.
     * @param resultArea The area id for the polygon. [out]
     * @return The status flags for the operation.
     */
    public Status getPolyArea(Poly poly, Character resultArea) {
        long ref = Poly.getCPtr(poly);
        long status = RecastJNI.dtNavMesh_getPolyArea(swigCPtr, this, ref, resultArea);
        return (status == 0) ? null : new Status(status);
    }

    /**
     * Gets the size of the buffer required by storeTileState to store the
     * specified tile's state.
     *
     * @param tile The tile.
     * @return The size of the buffer required to store the state.
     */
    public int getTileStateSize(MeshTile tile) {
        return RecastJNI.dtNavMesh_getTileStateSize(swigCPtr, this, MeshTile.getCPtr(tile), tile);
    }

    /**
     * - doesn't work
     *
     * Stores the non-structural state of the tile in the specified buffer.
     *
     * Tile state includes non-structural data such as polygon flags, area ids,
     * etc.
     *
     * Note: The state data is only valid until the tile reference changes.
     *
     * @param tile The tile.
     * @param data The buffer to store the tile's state in.
     * @param maxDataSize The size of the data buffer. [Limit: >=
     * getTileStateSize]
     * @return The status flags for the operation.
     */
    public Status storeTileState(MeshTile tile, char[] data, int maxDataSize) {
        SWIGTYPE_p_unsigned_char data1 = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        long status = RecastJNI.dtNavMesh_storeTileState(swigCPtr, this, MeshTile.getCPtr(tile), tile, SWIGTYPE_p_unsigned_char.getCPtr(data1), maxDataSize);
        //data = Converter.convertToChars(data1, maxDataSize);
        return (status == 0) ? null : new Status(status);
    }

    /**
     * Restores the state of the tile.
     *
     * Tile state includes non-structural data such as polygon flags, area ids,
     * etc.
     *
     * @param tile Restores the state of the tile.
     * @param data The new state. (Obtained from storeTileState.)
     * @param maxDataSize The size of the state within the data buffer.
     * @return The status flags for the operation.
     */
    public Status restoreTileState(MeshTile tile, char[] data, int maxDataSize) {
        SWIGTYPE_p_unsigned_char data1 = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        long status = RecastJNI.dtNavMesh_restoreTileState(swigCPtr, this, MeshTile.getCPtr(tile), tile, SWIGTYPE_p_unsigned_char.getCPtr(data1), maxDataSize);
        return (status == 0) ? null : new Status(status);
    }

    /**
     * Derives a standard polygon reference. Note: This function is generally
     * meant for internal use only.
     *
     * @param salt The tile's salt value.
     * @param it The index of the tile.
     * @param ip The index of the polygon within the tile.
     * @return
     */
    public long encodePoly(long salt, long it, long ip) {
        return RecastJNI.dtNavMesh_encodePolyId(swigCPtr, this, salt, it, ip);
    }

    /**
     * Decodes a standard polygon reference.
     *
     * Note: This function is generally meant for internal use only.
     *
     * @param poly The polygon reference to decode.
     * @param salt The tile's salt value.
     * @param it The index of the tile.
     * @param ip The index of the polygon within the tile.
     */
    public void decodePoly(Poly poly, SWIGTYPE_p_unsigned_int salt, SWIGTYPE_p_unsigned_int it, SWIGTYPE_p_unsigned_int ip) {
        long ref = Poly.getCPtr(poly);
        RecastJNI.dtNavMesh_decodePolyId(swigCPtr, this, ref, SWIGTYPE_p_unsigned_int.getCPtr(salt), SWIGTYPE_p_unsigned_int.getCPtr(it), SWIGTYPE_p_unsigned_int.getCPtr(ip));
    }

    /**
     * Extracts a tile's salt value from the specified polygon reference.
     *
     * Note: This function is generally meant for internal use only.
     *
     * @param poly The polygon reference.
     * @return
     */
    public long decodePolySalt(Poly poly) {
        long ref = Poly.getCPtr(poly);
        return RecastJNI.dtNavMesh_decodePolyIdSalt(swigCPtr, this, ref);
    }

    /**
     * Extracts the tile's index from the specified polygon reference.
     *
     * Note: This function is generally meant for internal use only.
     *
     * @param poly The polygon reference.
     * @return
     */
    public long decodePolyTile(Poly poly) {
        long ref = Poly.getCPtr(poly);
        return RecastJNI.dtNavMesh_decodePolyIdTile(swigCPtr, this, ref);
    }

    /**
     * Extracts the polygon's index (within its tile) from the specified polygon
     * reference.
     *
     * Note: This function is generally meant for internal use only.
     *
     * @param poly The polygon reference.
     *
     * @return
     */
    public long decodePolyPoly(Poly poly) {
        long ref = Poly.getCPtr(poly);
        return RecastJNI.dtNavMesh_decodePolyIdPoly(swigCPtr, this, ref);
    }

    public boolean isAllocationSuccessful() {
        return swigCPtr != 0;
    }
}
