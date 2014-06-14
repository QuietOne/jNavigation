package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.detour.NavMesh;
import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCache {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCache() {
        this(RecastJNI.new_dtTileCache(), true);
    }

    public TileCache(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCache obj) {
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
                RecastJNI.delete_dtTileCache(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public TileCacheAlloc getAlloc() {
        long cPtr = RecastJNI.dtTileCache_getAlloc(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheAlloc(cPtr, false);
    }

    public TileCacheCompressor getCompressor() {
        long cPtr = RecastJNI.dtTileCache_getCompressor(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheCompressor(cPtr, false);
    }

    public TileCacheParams getParams() {
        long cPtr = RecastJNI.dtTileCache_getParams(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheParams(cPtr, false);
    }

    public int getTileCount() {
        return RecastJNI.dtTileCache_getTileCount(swigCPtr, this);
    }

    public CompressedTile getTile(int i) {
        long cPtr = RecastJNI.dtTileCache_getTile(swigCPtr, this, i);
        return (cPtr == 0) ? null : new CompressedTile(cPtr, false);
    }

    public int getObstacleCount() {
        return RecastJNI.dtTileCache_getObstacleCount(swigCPtr, this);
    }

    public TileCacheObstacle getObstacle(int i) {
        long cPtr = RecastJNI.dtTileCache_getObstacle(swigCPtr, this, i);
        return (cPtr == 0) ? null : new TileCacheObstacle(cPtr, false);
    }

    public TileCacheObstacle getObstacleByRef(long ref) {
        long cPtr = RecastJNI.dtTileCache_getObstacleByRef(swigCPtr, this, ref);
        return (cPtr == 0) ? null : new TileCacheObstacle(cPtr, false);
    }

    public long getObstacleRef(TileCacheObstacle obmin) {
        return RecastJNI.dtTileCache_getObstacleRef(swigCPtr, this, TileCacheObstacle.getCPtr(obmin), obmin);
    }

    public long init(TileCacheParams params, TileCacheAlloc talloc, TileCacheCompressor tcomp, TileCacheMeshProcess tmproc) {
        return RecastJNI.dtTileCache_init(swigCPtr, this, TileCacheParams.getCPtr(params), params, TileCacheAlloc.getCPtr(talloc), talloc, TileCacheCompressor.getCPtr(tcomp), tcomp, TileCacheMeshProcess.getCPtr(tmproc), tmproc);
    }

    public int[] getTilesAt(int tx, int ty, int[] tiles, int maxTiles) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(tiles);
        int count = RecastJNI.dtTileCache_getTilesAt(swigCPtr, this, tx, ty, SWIGTYPE_p_unsigned_int.getCPtr(value), maxTiles);
        return Converter.convertToInts(SWIGTYPE_p_unsigned_int.getCPtr(value), count);
    }

    public CompressedTile getTileAt(int tx, int ty, int tlayer) {
        long cPtr = RecastJNI.dtTileCache_getTileAt(swigCPtr, this, tx, ty, tlayer);
        return (cPtr == 0) ? null : new CompressedTile(cPtr, false);
    }

    public long getTileRef(CompressedTile tile) {
        return RecastJNI.dtTileCache_getTileRef(swigCPtr, this, CompressedTile.getCPtr(tile), tile);
    }

    public CompressedTile getTileByRef(long ref) {
        long cPtr = RecastJNI.dtTileCache_getTileByRef(swigCPtr, this, ref);
        return (cPtr == 0) ? null : new CompressedTile(cPtr, false);
    }

    public long addTile(char[] data, int dataSize, short flags, int[] result) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        SWIGTYPE_p_unsigned_int result1 = Converter.convertToSWIGTYPE_p_unsigned_int(result);
        return RecastJNI.dtTileCache_addTile(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value), dataSize, flags, SWIGTYPE_p_unsigned_int.getCPtr(result1));
    }

    public long removeTile(long ref, SWIGTYPE_p_p_unsigned_char data, SWIGTYPE_p_int dataSize) {
        return RecastJNI.dtTileCache_removeTile(swigCPtr, this, ref, SWIGTYPE_p_p_unsigned_char.getCPtr(data), SWIGTYPE_p_int.getCPtr(dataSize));
    }

    public long addObstacle(SWIGTYPE_p_float pos, float radius, float height, SWIGTYPE_p_unsigned_int result) {
        return RecastJNI.dtTileCache_addObstacle(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), radius, height, SWIGTYPE_p_unsigned_int.getCPtr(result));
    }

    public long removeObstacle(long ref) {
        return RecastJNI.dtTileCache_removeObstacle(swigCPtr, this, ref);
    }

    public long queryTiles(SWIGTYPE_p_float bmin, SWIGTYPE_p_float bmax, SWIGTYPE_p_unsigned_int results, SWIGTYPE_p_int resultCount, int maxResults) {
        return RecastJNI.dtTileCache_queryTiles(swigCPtr, this, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax), SWIGTYPE_p_unsigned_int.getCPtr(results), SWIGTYPE_p_int.getCPtr(resultCount), maxResults);
    }

    public long update(float arg0, NavMesh navmesh) {
        return RecastJNI.dtTileCache_update(swigCPtr, this, arg0, NavMesh.getCPtr(navmesh), navmesh);
    }

    public long buildNavMeshTilesAt(int tx, int ty, NavMesh navmesh) {
        return RecastJNI.dtTileCache_buildNavMeshTilesAt(swigCPtr, this, tx, ty, NavMesh.getCPtr(navmesh), navmesh);
    }

    public long buildNavMeshTile(long ref, NavMesh navmesh) {
        return RecastJNI.dtTileCache_buildNavMeshTile(swigCPtr, this, ref, NavMesh.getCPtr(navmesh), navmesh);
    }

    public void calcTightTileBounds(TileCacheLayerHeader header, SWIGTYPE_p_float bmin, SWIGTYPE_p_float bmax) {
        RecastJNI.dtTileCache_calcTightTileBounds(swigCPtr, this, TileCacheLayerHeader.getCPtr(header), header, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax));
    }

    public void getObstacleBounds(TileCacheObstacle ob, SWIGTYPE_p_float bmin, SWIGTYPE_p_float bmax) {
        RecastJNI.dtTileCache_getObstacleBounds(swigCPtr, this, TileCacheObstacle.getCPtr(ob), ob, SWIGTYPE_p_float.getCPtr(bmin), SWIGTYPE_p_float.getCPtr(bmax));
    }

    public long encodeTileId(long salt, long it) {
        return RecastJNI.dtTileCache_encodeTileId(swigCPtr, this, salt, it);
    }

    public long decodeTileIdSalt(long ref) {
        return RecastJNI.dtTileCache_decodeTileIdSalt(swigCPtr, this, ref);
    }

    public long decodeTileIdTile(long ref) {
        return RecastJNI.dtTileCache_decodeTileIdTile(swigCPtr, this, ref);
    }

    public long encodeObstacleId(long salt, long it) {
        return RecastJNI.dtTileCache_encodeObstacleId(swigCPtr, this, salt, it);
    }

    public long decodeObstacleIdSalt(long ref) {
        return RecastJNI.dtTileCache_decodeObstacleIdSalt(swigCPtr, this, ref);
    }

    public long decodeObstacleIdObstacle(long ref) {
        return RecastJNI.dtTileCache_decodeObstacleIdObstacle(swigCPtr, this, ref);
    }
}
