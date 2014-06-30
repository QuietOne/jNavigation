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
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_dtPoly;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_dtMeshTile;
import com.jme3.math.Vector3f;

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

    public NavMesh(long cPtr, boolean cMemoryOwn) {
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

    public long init(NavMeshParams params) {
        return RecastJNI.dtNavMesh_init__SWIG_0(swigCPtr, this, NavMeshParams.getCPtr(params), params);
    }

    public long init(char[] data, int flags) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        int dataSize = data.length;
        return RecastJNI.dtNavMesh_init__SWIG_1(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value), dataSize, flags);
    }

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
    public long addTile(char[] data, int flags, long lastRef, int[] result) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        int dataSize = data.length;
        SWIGTYPE_p_unsigned_int value1 = Converter.convertToSWIGTYPE_p_unsigned_int(result);
        return RecastJNI.dtNavMesh_addTile(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value), dataSize, flags, lastRef, SWIGTYPE_p_unsigned_int.getCPtr(value1));
    }

    //data is output too
    public long removeTile(long ref, SWIGTYPE_p_p_unsigned_char data, SWIGTYPE_p_int dataSize) {
        return RecastJNI.dtNavMesh_removeTile(swigCPtr, this, ref, SWIGTYPE_p_p_unsigned_char.getCPtr(data), SWIGTYPE_p_int.getCPtr(dataSize));
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

    public MeshTile getTileAt(int x, int y, int layer) {
        long cPtr = RecastJNI.dtNavMesh_getTileAt(swigCPtr, this, x, y, layer);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }

    public int getTilesAt(int x, int y, SWIGTYPE_p_p_dtMeshTile tiles, int maxTiles) {
        return RecastJNI.dtNavMesh_getTilesAt(swigCPtr, this, x, y, SWIGTYPE_p_p_dtMeshTile.getCPtr(tiles), maxTiles);
    }

    public long getTileRefAt(int x, int y, int layer) {
        return RecastJNI.dtNavMesh_getTileRefAt(swigCPtr, this, x, y, layer);
    }

    public long getTileRef(MeshTile tile) {
        return RecastJNI.dtNavMesh_getTileRef(swigCPtr, this, MeshTile.getCPtr(tile), tile);
    }

    public MeshTile getTileByRef(long ref) {
        long cPtr = RecastJNI.dtNavMesh_getTileByRef(swigCPtr, this, ref);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }

    public int getMaxTiles() {
        return RecastJNI.dtNavMesh_getMaxTiles(swigCPtr, this);
    }

    public MeshTile getTile(int i) {
        long cPtr = RecastJNI.dtNavMesh_getTile(swigCPtr, this, i);
        return (cPtr == 0) ? null : new MeshTile(cPtr, false);
    }

    public long getTileAndPolyByRef(long ref, SWIGTYPE_p_p_dtMeshTile tile, SWIGTYPE_p_p_dtPoly poly) {
        return RecastJNI.dtNavMesh_getTileAndPolyByRef(swigCPtr, this, ref, SWIGTYPE_p_p_dtMeshTile.getCPtr(tile), SWIGTYPE_p_p_dtPoly.getCPtr(poly));
    }

    public void getTileAndPolyByRefUnsafe(long ref, SWIGTYPE_p_p_dtMeshTile tile, SWIGTYPE_p_p_dtPoly poly) {
        RecastJNI.dtNavMesh_getTileAndPolyByRefUnsafe(swigCPtr, this, ref, SWIGTYPE_p_p_dtMeshTile.getCPtr(tile), SWIGTYPE_p_p_dtPoly.getCPtr(poly));
    }

    public boolean isValidPolyRef(long ref) {
        return RecastJNI.dtNavMesh_isValidPolyRef(swigCPtr, this, ref);
    }

    public long getPolyRefBase(MeshTile tile) {
        return RecastJNI.dtNavMesh_getPolyRefBase(swigCPtr, this, MeshTile.getCPtr(tile), tile);
    }

    public long getOffMeshConnectionPolyEndPoints(long prevRef, long polyRef, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos) {
        return RecastJNI.dtNavMesh_getOffMeshConnectionPolyEndPoints(swigCPtr, this, prevRef, polyRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos));
    }

    public OffMeshConnection getOffMeshConnectionByRef(long ref) {
        long cPtr = RecastJNI.dtNavMesh_getOffMeshConnectionByRef(swigCPtr, this, ref);
        return (cPtr == 0) ? null : new OffMeshConnection(cPtr, false);
    }

    public long setPolyFlags(long ref, int flags) {
        return RecastJNI.dtNavMesh_setPolyFlags(swigCPtr, this, ref, flags);
    }

    public long getPolyFlags(long ref, SWIGTYPE_p_unsigned_short resultFlags) {
        return RecastJNI.dtNavMesh_getPolyFlags(swigCPtr, this, ref, SWIGTYPE_p_unsigned_short.getCPtr(resultFlags));
    }

    public long setPolyArea(long ref, short area) {
        return RecastJNI.dtNavMesh_setPolyArea(swigCPtr, this, ref, area);
    }

    public long getPolyArea(long ref, SWIGTYPE_p_unsigned_char resultArea) {
        return RecastJNI.dtNavMesh_getPolyArea(swigCPtr, this, ref, SWIGTYPE_p_unsigned_char.getCPtr(resultArea));
    }

    public int getTileStateSize(MeshTile tile) {
        return RecastJNI.dtNavMesh_getTileStateSize(swigCPtr, this, MeshTile.getCPtr(tile), tile);
    }

    public long storeTileState(MeshTile tile, SWIGTYPE_p_unsigned_char data, int maxDataSize) {
        return RecastJNI.dtNavMesh_storeTileState(swigCPtr, this, MeshTile.getCPtr(tile), tile, SWIGTYPE_p_unsigned_char.getCPtr(data), maxDataSize);
    }

    public long restoreTileState(MeshTile tile, SWIGTYPE_p_unsigned_char data, int maxDataSize) {
        return RecastJNI.dtNavMesh_restoreTileState(swigCPtr, this, MeshTile.getCPtr(tile), tile, SWIGTYPE_p_unsigned_char.getCPtr(data), maxDataSize);
    }

    public long encodePolyId(long salt, long it, long ip) {
        return RecastJNI.dtNavMesh_encodePolyId(swigCPtr, this, salt, it, ip);
    }

    /**
     * Decodes a standard polygon reference.
     *
     * Note This function is generally meant for internal use only.
     *
     * @param ref The polygon reference to decode.
     * @param salt The tile's salt value.
     * @param it The index of the tile.
     * @param ip The index of the polygon within the tile.
     */
    public void decodePolyId(long ref, SWIGTYPE_p_unsigned_int salt, SWIGTYPE_p_unsigned_int it, SWIGTYPE_p_unsigned_int ip) {
        RecastJNI.dtNavMesh_decodePolyId(swigCPtr, this, ref, SWIGTYPE_p_unsigned_int.getCPtr(salt), SWIGTYPE_p_unsigned_int.getCPtr(it), SWIGTYPE_p_unsigned_int.getCPtr(ip));
    }

    public long decodePolyIdSalt(long ref) {
        return RecastJNI.dtNavMesh_decodePolyIdSalt(swigCPtr, this, ref);
    }

    public long decodePolyIdTile(long ref) {
        return RecastJNI.dtNavMesh_decodePolyIdTile(swigCPtr, this, ref);
    }

    public long decodePolyIdPoly(long ref) {
        return RecastJNI.dtNavMesh_decodePolyIdPoly(swigCPtr, this, ref);
    }
}
