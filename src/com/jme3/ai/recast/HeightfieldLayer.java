package com.jme3.ai.recast;

import com.jme3.ai.recast.utils.Converter;
import com.jme3.ai.recast.utils.RecastJNI;
import com.jme3.ai.recast.utils.SWIGTYPE_p_float;
import com.jme3.ai.recast.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class HeightfieldLayer {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public HeightfieldLayer(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(HeightfieldLayer obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_rcHeightfieldLayer(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcHeightfieldLayer_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcHeightfieldLayer_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcHeightfieldLayer_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcHeightfieldLayer_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setCellSize(float value) {
        RecastJNI.rcHeightfieldLayer_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.rcHeightfieldLayer_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.rcHeightfieldLayer_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.rcHeightfieldLayer_ch_get(swigCPtr, this);
    }

    public void setWidth(int value) {
        RecastJNI.rcHeightfieldLayer_width_set(swigCPtr, this, value);
    }

    public int getWidth() {
        return RecastJNI.rcHeightfieldLayer_width_get(swigCPtr, this);
    }

    public void setHeight(int value) {
        RecastJNI.rcHeightfieldLayer_height_set(swigCPtr, this, value);
    }

    public int getHeight() {
        return RecastJNI.rcHeightfieldLayer_height_get(swigCPtr, this);
    }

    public void setMinX(int value) {
        RecastJNI.rcHeightfieldLayer_minx_set(swigCPtr, this, value);
    }

    public int getMinX() {
        return RecastJNI.rcHeightfieldLayer_minx_get(swigCPtr, this);
    }

    public void setMaxX(int value) {
        RecastJNI.rcHeightfieldLayer_maxx_set(swigCPtr, this, value);
    }

    public int getMaxX() {
        return RecastJNI.rcHeightfieldLayer_maxx_get(swigCPtr, this);
    }

    public void setMinY(int value) {
        RecastJNI.rcHeightfieldLayer_miny_set(swigCPtr, this, value);
    }

    public int getMinY() {
        return RecastJNI.rcHeightfieldLayer_miny_get(swigCPtr, this);
    }

    public void setMaxY(int value) {
        RecastJNI.rcHeightfieldLayer_maxy_set(swigCPtr, this, value);
    }

    public int getMaxY() {
        return RecastJNI.rcHeightfieldLayer_maxy_get(swigCPtr, this);
    }

    public void setMinHeight(int value) {
        RecastJNI.rcHeightfieldLayer_hmin_set(swigCPtr, this, value);
    }

    public int getMinHeight() {
        return RecastJNI.rcHeightfieldLayer_hmin_get(swigCPtr, this);
    }

    public void setMaxHeight(int value) {
        RecastJNI.rcHeightfieldLayer_hmax_set(swigCPtr, this, value);
    }

    public int getMaxHeight() {
        return RecastJNI.rcHeightfieldLayer_hmax_get(swigCPtr, this);
    }

    public void setHeights(char[] heights) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(heights);
        RecastJNI.rcHeightfieldLayer_heights_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getHeights(int borderSize) {
        long cPtr = RecastJNI.rcHeightfieldLayer_heights_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int count = (getWidth() - borderSize * 2) * (getHeight() - borderSize * 2);
        return Converter.convertToChars(cPtr, count);
    }

    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcHeightfieldLayer_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getAreas(int borderSize) {
        long cPtr = RecastJNI.rcHeightfieldLayer_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int count = (getWidth() - borderSize * 2) * (getHeight() - borderSize * 2);
        return Converter.convertToChars(cPtr, count);
    }

    public void setConnections(char[] connections) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connections);
        RecastJNI.rcHeightfieldLayer_cons_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getConnections(int borderSize) {
        long cPtr = RecastJNI.rcHeightfieldLayer_cons_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int count = (getWidth() - borderSize * 2) * (getHeight() - borderSize * 2);
        return Converter.convertToChars(cPtr, count);
    }

    public HeightfieldLayer() {
        this(RecastJNI.new_rcHeightfieldLayer(), true);
    }
}
