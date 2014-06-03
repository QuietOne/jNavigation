package com.jme3.ai.detour.structures;

import com.jme3.ai.detour.structures.MeshTile.TileRef;
import com.jme3.ai.detour.structures.Poly.PolyRef;
import com.jme3.ai.detour.util.Status;
import com.jme3.math.Vector3f;

/**
 * A navigation mesh based on tiles of convex polygons.
 *
 * @author Tihomir Radosavljevic
 */
public class NavMesh {

    private Object reference;

    public NavMesh() {
        reference = dtAllocNavMesh();
    }

    private native Object dtAllocNavMesh();

    public Status init(NavMeshParams params) {
        return initDT(params);
    }

    private native Status initDT(NavMeshParams params);

    public Status init(char[] data, int flags) {
        return initDT(data, flags);
    }

    private native Status initDT(char[] data, int flags);

    /**
     *
     * @param data
     * @param flags
     * @param lastRef
     * @param result
     * @return
     */
    public Status addTile(char[] data, int flags, TileRef lastRef, TileRef result) {
        return addTileDT(data, flags, lastRef, result);
    }

    private native Status addTileDT(char[] data, int flags, TileRef lastRef, TileRef result);

    public Status removeTile(TileRef ref, char[] data) {
        return removeTileDT(ref, data);
    }

    private native Status removeTileDT(TileRef ref, char[] data);

    public NavMeshParams getParams() {
        return getParamsDT();
    }

    private native NavMeshParams getParamsDT();

    public void calulateTileLocation(Vector3f position, int tilePositionX, int tilePositionY) {
        calcTileLoc(position, tilePositionX, tilePositionY);
    }

    private native void calcTileLoc(Vector3f position, int tilePositionX, int tilePositionY);

    public MeshTile getTileAt(int x, int y, int layer) {
        return getTileAtDT(x, y, layer);
    }

    private native MeshTile getTileAtDT(int x, int y, int layer);

    public MeshTile[] getTilesAt(int x, int y, int maxTiles) {
        return getTilesAtDT(x, y, maxTiles);
    }

    private native MeshTile[] getTilesAtDT(int x, int y, int maxTiles);

    public TileRef getTileRefAt(int x, int y, int layer) {
        return getTileRefAtDT(x, y, layer);
    }

    private native TileRef getTileRefAtDT(int x, int y, int layer);

    public TileRef getTileRef(MeshTile meshTile) {
        return getTileRefDT(meshTile);
    }

    private native TileRef getTileRefDT(MeshTile tile);

    public MeshTile getTileByRef(TileRef tileRef) {
        return getTileByRefDT(tileRef);
    }

    private native MeshTile getTileByRefDT(TileRef tileRef);

    public int getMaxTiles() {
        return getMaxTilesDT();
    }

    private native int getMaxTilesDT();
    
    public MeshTile getTile(int i){
        return getTileDT(i);
    }
    
    private native MeshTile getTileDT(int i);

    public boolean isValidPolyRef(PolyRef polyRef){
        return isValidPolyRefDT(polyRef);
    }
    
    private native boolean isValidPolyRefDT(PolyRef ref);
    
    public PolyRef getPolyRefBase(MeshTile tile){
        return getPolyRefBaseDT(tile);
    }
    
    private native PolyRef getPolyRefBaseDT(MeshTile tile); 
    
    //TODO: off-mesh connections
/*  
 * not necessary yet
    public Status setPolyFlags(PolyRef polyRef, short flags){
        return setPolyFlagsDT(polyRef, flags);
    }
    
    private native Status setPolyFlagsDT(PolyRef polyRef, short flags);
  */  
    
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dtFreeNavMesh(this);
    }

    private native void dtFreeNavMesh(NavMesh navMesh);


}
