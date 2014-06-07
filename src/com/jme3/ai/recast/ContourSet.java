package com.jme3.ai.recast;

import com.jme3.ai.recast.utils.Converter;
import com.jme3.ai.recast.utils.RecastJNI;
import com.jme3.ai.recast.utils.SWIGTYPE_p_float;
import com.jme3.math.Vector3f;

/**
 * 
 * @author Tihomir Radosavljevic
 */
public class ContourSet {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public ContourSet() {
        swigCPtr = RecastJNI.rcAllocContourSet();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    protected ContourSet(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(ContourSet obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            delete();
        } finally {
            super.finalize();
        }
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.rcFreeContourSet(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public void setContours(Contour value) {
        RecastJNI.rcContourSet_conts_set(swigCPtr, this, Contour.getCPtr(value), value);
    }

    public Contour getContours() {
        long cPtr = RecastJNI.rcContourSet_conts_get(swigCPtr, this);
        return (cPtr == 0) ? null : new Contour(cPtr, false);
    }

    public void setNumberOfContours(int value) {
        RecastJNI.rcContourSet_nconts_set(swigCPtr, this, value);
    }

    public int getNumberOfContours() {
        return RecastJNI.rcContourSet_nconts_get(swigCPtr, this);
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcContourSet_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcContourSet_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcContourSet_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcContourSet_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setCellSize(float value) {
        RecastJNI.rcContourSet_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.rcContourSet_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.rcContourSet_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.rcContourSet_ch_get(swigCPtr, this);
    }

    public void setWidth(int value) {
        RecastJNI.rcContourSet_width_set(swigCPtr, this, value);
    }

    public int getWidth() {
        return RecastJNI.rcContourSet_width_get(swigCPtr, this);
    }

    public void setHeight(int value) {
        RecastJNI.rcContourSet_height_set(swigCPtr, this, value);
    }

    public int getHeight() {
        return RecastJNI.rcContourSet_height_get(swigCPtr, this);
    }

    public void setBorderSize(int value) {
        RecastJNI.rcContourSet_borderSize_set(swigCPtr, this, value);
    }

    public int getBorderSize() {
        return RecastJNI.rcContourSet_borderSize_get(swigCPtr, this);
    }
}
