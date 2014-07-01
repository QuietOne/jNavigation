package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * Configuration parameters used to define multi-tile navigation meshes.
 *
 * The values are used to allocate space during the initialization of a
 * navigation mesh.
 *
 * @see NavMesh#init(com.jme3.ai.navigation.detour.NavMeshParams)
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class NavMeshParams {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NavMeshParams() {
        this(RecastJNI.new_dtNavMeshParams(), true);
    }

    public NavMeshParams(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NavMeshParams obj) {
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
                RecastJNI.delete_dtNavMeshParams(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param origin The world space origin of the navigation mesh's tile space.
     */
    public void setOrigin(Vector3f origin) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(origin);
        RecastJNI.dtNavMeshParams_orig_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The world space origin of the navigation mesh's tile space.
     */
    public Vector3f getOrigin() {
        long cPtr = RecastJNI.dtNavMeshParams_orig_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value The width of each tile. (Along the x-axis.)
     */
    public void setTileWidth(float value) {
        RecastJNI.dtNavMeshParams_tileWidth_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The width of each tile. (Along the x-axis.)
     */
    public float getTileWidth() {
        return RecastJNI.dtNavMeshParams_tileWidth_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of each tile. (Along the z-axis.)
     */
    public void setTileHeight(float value) {
        RecastJNI.dtNavMeshParams_tileHeight_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of each tile. (Along the z-axis.)
     */
    public float getTileHeight() {
        return RecastJNI.dtNavMeshParams_tileHeight_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum number of tiles the navigation mesh can contain.
     */
    public void setMaxTiles(int value) {
        RecastJNI.dtNavMeshParams_maxTiles_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum number of tiles the navigation mesh can contain.
     */
    public int getMaxTiles() {
        return RecastJNI.dtNavMeshParams_maxTiles_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum number of polygons each tile can contain.
     */
    public void setMaxPolygons(int value) {
        RecastJNI.dtNavMeshParams_maxPolys_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum number of polygons each tile can contain.
     */
    public int getMaxPolygons() {
        return RecastJNI.dtNavMeshParams_maxPolys_get(swigCPtr, this);
    }
}
