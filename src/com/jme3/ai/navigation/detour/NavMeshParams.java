package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
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

    public void setOrigin(Vector3f origin) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(origin);
        RecastJNI.dtNavMeshParams_orig_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getOrigin() {
        long cPtr = RecastJNI.dtNavMeshParams_orig_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setTileWidth(float value) {
        RecastJNI.dtNavMeshParams_tileWidth_set(swigCPtr, this, value);
    }

    public float getTileWidth() {
        return RecastJNI.dtNavMeshParams_tileWidth_get(swigCPtr, this);
    }

    public void setTileHeight(float value) {
        RecastJNI.dtNavMeshParams_tileHeight_set(swigCPtr, this, value);
    }

    public float getTileHeight() {
        return RecastJNI.dtNavMeshParams_tileHeight_get(swigCPtr, this);
    }

    public void setMaxTiles(int value) {
        RecastJNI.dtNavMeshParams_maxTiles_set(swigCPtr, this, value);
    }

    public int getMaxTiles() {
        return RecastJNI.dtNavMeshParams_maxTiles_get(swigCPtr, this);
    }

    public void setMaxPolygons(int value) {
        RecastJNI.dtNavMeshParams_maxPolys_set(swigCPtr, this, value);
    }

    public int getMaxPolygons() {
        return RecastJNI.dtNavMeshParams_maxPolys_get(swigCPtr, this);
    }
}
