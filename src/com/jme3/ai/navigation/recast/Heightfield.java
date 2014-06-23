package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * A dynamic heightfield representing obstructed space.
 *
 * The grid of a heightfield is layed out on the xz-plane based on the value of
 * cs. Spans exist within the grid columns with the span min/max values at
 * increments of ch from the base of the grid. The smallest possible span size
 * is (cs width) * (cs depth) * (ch height). (Which is a single voxel.)
 *
 * The standard process for buidling a heightfield is to allocate it using
 * constructor, initialize it using createHeightfield, then add spans using the
 * various helper functions such as rasterizeTriangle.
 *
 * Building a heightfield is one of the first steps in creating a polygon mesh
 * from source geometry. After it is populated, it is used to build a
 * compactHeightfield.
 *
 * @see RecastBuilder
 * @see CompactHeightfield
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Heightfield {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Allocates a heightfield object using the Recast allocator.
     */
    public Heightfield() {
        swigCPtr = RecastJNI.rcAllocHeightfield();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    protected Heightfield(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Heightfield obj) {
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
                RecastJNI.rcFreeHeightField(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value The width of the heightfield. (Along the x-axis in cell
     * units.)
     */
    public void setWidth(int value) {
        RecastJNI.rcHeightfield_width_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The width of the heightfield. (Along the x-axis in cell units.)
     */
    public int getWidth() {
        return RecastJNI.rcHeightfield_width_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of the heightfield. (Along the z-axis in cell
     * units.)
     */
    public void setHeight(int value) {
        RecastJNI.rcHeightfield_height_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of the heightfield. (Along the z-axis in cell units.)
     */
    public int getHeight() {
        return RecastJNI.rcHeightfield_height_get(swigCPtr, this);
    }

    /**
     *
     * @param minBounds The minimum bounds in world space.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcHeightfield_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds in world space.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcHeightfield_bmin_get(swigCPtr, this);
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
        RecastJNI.rcHeightfield_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds in world space.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcHeightfield_bmax_get(swigCPtr, this);
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
        RecastJNI.rcHeightfield_cs_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The size of each cell. (On the xz-plane.)
     */
    public float getCellSize() {
        return RecastJNI.rcHeightfield_cs_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public void setCellHeight(float value) {
        RecastJNI.rcHeightfield_ch_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public float getCellHeight() {
        return RecastJNI.rcHeightfield_ch_get(swigCPtr, this);
    }

    /**
     *
     * @return Heightfield of spans (width*height).
     */
    public Span[] getSpans() {
        long cPtr = RecastJNI.rcHeightfield_spans_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int length = getHeight() * getWidth();
        Span[] spans = new Span[length];
        for (int i = 0; i < length; i++) {
            spans[i] = new Span(cPtr + i, false);
        }
        return spans;
    }
}
