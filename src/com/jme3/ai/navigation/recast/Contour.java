package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Contour {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Contour() {
        this(RecastJNI.new_rcContour(), true);
    }

    public Contour(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Contour obj) {
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
                RecastJNI.delete_rcContour(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setVertices(int[] value) {
        SWIGTYPE_p_int v = Converter.convertToSWIGTYPE_p_int(value);
        RecastJNI.rcContour_verts_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(v));
    }

    public int[] getVertices() {
        long cPtr = RecastJNI.rcContour_verts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToInts(cPtr, getNumberOfVertices());
    }

    public void setNumberOfVertices(int value) {
        RecastJNI.rcContour_nverts_set(swigCPtr, this, value);
    }

    public int getNumberOfVertices() {
        return RecastJNI.rcContour_nverts_get(swigCPtr, this);
    }

    public void setRawVertices(int[] value) {
        SWIGTYPE_p_int v = Converter.convertToSWIGTYPE_p_int(value);
        RecastJNI.rcContour_rverts_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(v));
    }

    public int[] getRawVertices() {
        long cPtr = RecastJNI.rcContour_rverts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToInts(cPtr, getNumberOfRawVertices());
    }

    public void setNumberOfRawVertices(int value) {
        RecastJNI.rcContour_nrverts_set(swigCPtr, this, value);
    }

    public int getNumberOfRawVertices() {
        return RecastJNI.rcContour_nrverts_get(swigCPtr, this);
    }

    public void setRegionID(int value) {
        RecastJNI.rcContour_reg_set(swigCPtr, this, value);
    }

    public int getRegionID() {
        return RecastJNI.rcContour_reg_get(swigCPtr, this);
    }

    public void setArea(short value) {
        RecastJNI.rcContour_area_set(swigCPtr, this, value);
    }

    public short getArea() {
        return RecastJNI.rcContour_area_get(swigCPtr, this);
    }
}
