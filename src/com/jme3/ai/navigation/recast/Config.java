package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Config {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Config() {
        this(RecastJNI.new_rcConfig(), true);
    }

    public Config(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Config obj) {
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
                RecastJNI.delete_rcConfig(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setWidth(int value) {
        RecastJNI.rcConfig_width_set(swigCPtr, this, value);
    }

    public int getWidth() {
        return RecastJNI.rcConfig_width_get(swigCPtr, this);
    }

    public void setHeight(int value) {
        RecastJNI.rcConfig_height_set(swigCPtr, this, value);
    }

    public int getHeight() {
        return RecastJNI.rcConfig_height_get(swigCPtr, this);
    }

    public void setTileSize(int value) {
        RecastJNI.rcConfig_tileSize_set(swigCPtr, this, value);
    }

    public int getTileSize() {
        return RecastJNI.rcConfig_tileSize_get(swigCPtr, this);
    }

    public void setBorderSize(int value) {
        RecastJNI.rcConfig_borderSize_set(swigCPtr, this, value);
    }

    public int getBorderSize() {
        return RecastJNI.rcConfig_borderSize_get(swigCPtr, this);
    }

    public void setCellSize(float value) {
        RecastJNI.rcConfig_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.rcConfig_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.rcConfig_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.rcConfig_ch_get(swigCPtr, this);
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcConfig_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcConfig_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcConfig_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcConfig_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setWalkableSlopeAngle(float value) {
        RecastJNI.rcConfig_walkableSlopeAngle_set(swigCPtr, this, value);
    }

    public float getWalkableSlopeAngle() {
        return RecastJNI.rcConfig_walkableSlopeAngle_get(swigCPtr, this);
    }

    public void setWalkableHeight(int value) {
        RecastJNI.rcConfig_walkableHeight_set(swigCPtr, this, value);
    }

    public int getWalkableHeight() {
        return RecastJNI.rcConfig_walkableHeight_get(swigCPtr, this);
    }

    public void setWalkableClimb(int value) {
        RecastJNI.rcConfig_walkableClimb_set(swigCPtr, this, value);
    }

    public int getWalkableClimb() {
        return RecastJNI.rcConfig_walkableClimb_get(swigCPtr, this);
    }

    public void setWalkableRadius(int value) {
        RecastJNI.rcConfig_walkableRadius_set(swigCPtr, this, value);
    }

    public int getWalkableRadius() {
        return RecastJNI.rcConfig_walkableRadius_get(swigCPtr, this);
    }

    public void setMaxEdgeLen(int value) {
        RecastJNI.rcConfig_maxEdgeLen_set(swigCPtr, this, value);
    }

    public int getMaxEdgeLen() {
        return RecastJNI.rcConfig_maxEdgeLen_get(swigCPtr, this);
    }

    public void setMaxSimplificationError(float value) {
        RecastJNI.rcConfig_maxSimplificationError_set(swigCPtr, this, value);
    }

    public float getMaxSimplificationError() {
        return RecastJNI.rcConfig_maxSimplificationError_get(swigCPtr, this);
    }

    public void setMinRegionArea(int value) {
        RecastJNI.rcConfig_minRegionArea_set(swigCPtr, this, value);
    }

    public int getMinRegionArea() {
        return RecastJNI.rcConfig_minRegionArea_get(swigCPtr, this);
    }

    public void setMergeRegionArea(int value) {
        RecastJNI.rcConfig_mergeRegionArea_set(swigCPtr, this, value);
    }

    public int getMergeRegionArea() {
        return RecastJNI.rcConfig_mergeRegionArea_get(swigCPtr, this);
    }

    public void setMaxVertsPerPoly(int value) {
        RecastJNI.rcConfig_maxVertsPerPoly_set(swigCPtr, this, value);
    }

    public int getMaxVertsPerPoly() {
        return RecastJNI.rcConfig_maxVertsPerPoly_get(swigCPtr, this);
    }

    public void setDetailSampleDist(float value) {
        RecastJNI.rcConfig_detailSampleDist_set(swigCPtr, this, value);
    }

    public float getDetailSampleDist() {
        return RecastJNI.rcConfig_detailSampleDist_get(swigCPtr, this);
    }

    public void setDetailSampleMaxError(float value) {
        RecastJNI.rcConfig_detailSampleMaxError_set(swigCPtr, this, value);
    }

    public float getDetailSampleMaxError() {
        return RecastJNI.rcConfig_detailSampleMaxError_get(swigCPtr, this);
    }
}
