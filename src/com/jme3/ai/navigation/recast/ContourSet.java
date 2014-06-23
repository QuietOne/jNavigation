package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * Represents a group of related contours.
 *
 * All contours within the set share the minimum bounds and cell sizes of the
 * set.
 *
 * The standard process for building a contour set is to allocate it using
 * constructor, then initialize it using buildContours.
 *
 * @see RecastBuilder
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class ContourSet {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Allocates a contour set object using the Recast allocator.
     */
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
    protected void finalize() {
        delete();
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

//    /**
//     * - not done yet
//     *
//     * @param value An array of the contours in the set.
//     */
//    public void setContours(Contour value) {
//        RecastJNI.rcContourSet_conts_set(swigCPtr, this, Contour.getCPtr(value), value);
//    }
    /**
     *
     * @return An array of the contours in the set.
     */
    public Contour[] getContours() {
        long cPtr = RecastJNI.rcContourSet_conts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        Contour[] contours = new Contour[getNumberOfContours()];
        for (int i = 0; i < contours.length; i++) {
            contours[i] = new Contour(cPtr + i, false);
        }
        return contours;
    }

//    /**
//     *
//     * @param value The number of contours in the set.
//     */
//    public void setNumberOfContours(int value) {
//        RecastJNI.rcContourSet_nconts_set(swigCPtr, this, value);
//    }
    /**
     *
     * @return The number of contours in the set.
     */
    protected int getNumberOfContours() {
        return RecastJNI.rcContourSet_nconts_get(swigCPtr, this);
    }

    /**
     *
     * @param minBounds The minimum bounds in world space.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcContourSet_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds in world space.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcContourSet_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBounds The maximum bounds in world space.
     */
    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcContourSet_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds in world space.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcContourSet_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value The size of each cell. (On the xz-plane.)
     */
    public void setCellSize(float value) {
        RecastJNI.rcContourSet_cs_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The size of each cell. (On the xz-plane.)
     */
    public float getCellSize() {
        return RecastJNI.rcContourSet_cs_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public void setCellHeight(float value) {
        RecastJNI.rcContourSet_ch_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public float getCellHeight() {
        return RecastJNI.rcContourSet_ch_get(swigCPtr, this);
    }

    /**
     *
     * @param value The width of the set. (Along the x-axis in cell units.)
     */
    public void setWidth(int value) {
        RecastJNI.rcContourSet_width_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The width of the set. (Along the x-axis in cell units.)
     */
    public int getWidth() {
        return RecastJNI.rcContourSet_width_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of the set. (Along the z-axis in cell units.)
     */
    public void setHeight(int value) {
        RecastJNI.rcContourSet_height_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of the set. (Along the z-axis in cell units.)
     */
    public int getHeight() {
        return RecastJNI.rcContourSet_height_get(swigCPtr, this);
    }

    /**
     *
     * @param value The AABB border size used to generate the source data from
     * which the contours were derived.
     */
    public void setBorderSize(int value) {
        RecastJNI.rcContourSet_borderSize_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The AABB border size used to generate the source data from which
     * the contours were derived.
     */
    public int getBorderSize() {
        return RecastJNI.rcContourSet_borderSize_get(swigCPtr, this);
    }
}
