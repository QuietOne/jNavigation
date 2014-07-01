package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class TileCacheParams {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheParams() {
        this(RecastJNI.new_dtTileCacheParams(), true);
    }

    public TileCacheParams(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheParams obj) {
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
                RecastJNI.delete_dtTileCacheParams(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setOrigin(Vector3f position) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtTileCacheParams_orig_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getOrigin() {
        long cPtr = RecastJNI.dtTileCacheParams_orig_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setCellSize(float value) {
        RecastJNI.dtTileCacheParams_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.dtTileCacheParams_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.dtTileCacheParams_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.dtTileCacheParams_ch_get(swigCPtr, this);
    }

    public void setWidth(int value) {
        RecastJNI.dtTileCacheParams_width_set(swigCPtr, this, value);
    }

    public int getWidth() {
        return RecastJNI.dtTileCacheParams_width_get(swigCPtr, this);
    }

    public void setHeight(int value) {
        RecastJNI.dtTileCacheParams_height_set(swigCPtr, this, value);
    }

    public int getHeight() {
        return RecastJNI.dtTileCacheParams_height_get(swigCPtr, this);
    }

    public void setWalkableHeight(float value) {
        RecastJNI.dtTileCacheParams_walkableHeight_set(swigCPtr, this, value);
    }

    public float getWalkableHeight() {
        return RecastJNI.dtTileCacheParams_walkableHeight_get(swigCPtr, this);
    }

    public void setWalkableRadius(float value) {
        RecastJNI.dtTileCacheParams_walkableRadius_set(swigCPtr, this, value);
    }

    public float getWalkableRadius() {
        return RecastJNI.dtTileCacheParams_walkableRadius_get(swigCPtr, this);
    }

    public void setWalkableClimb(float value) {
        RecastJNI.dtTileCacheParams_walkableClimb_set(swigCPtr, this, value);
    }

    public float getWalkableClimb() {
        return RecastJNI.dtTileCacheParams_walkableClimb_get(swigCPtr, this);
    }

    public void setMaxSimplificationError(float value) {
        RecastJNI.dtTileCacheParams_maxSimplificationError_set(swigCPtr, this, value);
    }

    public float getMaxSimplificationError() {
        return RecastJNI.dtTileCacheParams_maxSimplificationError_get(swigCPtr, this);
    }

    public void setMaxTiles(int value) {
        RecastJNI.dtTileCacheParams_maxTiles_set(swigCPtr, this, value);
    }

    public int getMaxTiles() {
        return RecastJNI.dtTileCacheParams_maxTiles_get(swigCPtr, this);
    }

    public void setMaxObstacles(int value) {
        RecastJNI.dtTileCacheParams_maxObstacles_set(swigCPtr, this, value);
    }

    public int getMaxObstacles() {
        return RecastJNI.dtTileCacheParams_maxObstacles_get(swigCPtr, this);
    }
}
