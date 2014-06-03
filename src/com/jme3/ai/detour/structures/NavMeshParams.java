package com.jme3.ai.detour.structures;

import com.jme3.math.Vector3f;

/**
 * Configuration parameters used to define multi-tile navigation meshes.
 *
 * The values are used to allocate space during the initialization of a
 * navigation mesh.
 *
 * @author Tihomir Radosavljevic
 */
public class NavMeshParams {

    private Object reference;
    /**
     * The world space origin of the navigation mesh's tile space.
     */
    private Vector3f origin;
    /**
     * The width of each tile. (Along the x-axis.)
     */
    private float tileWidth;
    /**
     * The height of each tile. (Along the z-axis.)
     */
    private float tileHeight;
    /**
     * The maximum number of tiles the navigation mesh can contain.
     */
    private int maxTiles;
    /**
     * The maximum number of polygons each tile can contain.
     */
    private int maxPolygons;
    
    public NavMeshParams() {
    }

    public Vector3f getOrigin() {
        getNativeOrigin();
        return origin;
    }
    
    private native void getNativeOrigin();

    public float getTileWidth() {
        getNativeTileWidth();
        return tileWidth;
    }
    
    private native void getNativeTileWidth();

    public float getTileHeight() {
        getNativeTileHeight();
        return tileHeight;
    }
    
    private native void getNativeTileHeight();

    public int getMaxTiles() {
        getNativeMaxTiles();
        return maxTiles;
    }
    
    private native void getNativeMaxTiles();

    public int getMaxPolygons() {
        getNativeMaxPolygons();
        return maxPolygons;
    }
    
    private native void getNativeMaxPolygons();
}
