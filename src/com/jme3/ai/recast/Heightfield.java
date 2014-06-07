package com.jme3.ai.recast;

import com.jme3.ai.recast.utils.Converter;
import com.jme3.ai.recast.utils.RecastJNI;
import com.jme3.ai.recast.utils.SWIGTYPE_p_float;
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
 * rcAllocHeightfield, initialize it using rcCreateHeightfield, then add spans
 * using the various helper functions such as rcRasterizeTriangle.
 *
 * Building a heightfield is one of the first steps in creating a polygon mesh
 * from source geometry. After it is populated, it is used to build a
 * rcCompactHeightfield.
 *
 * @author Tihomir Radosavljevic
 */
public class Heightfield {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected Heightfield(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public Heightfield() {
        swigCPtr = RecastJNI.rcAllocHeightfield();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public static long getCPtr(Heightfield obj) {
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
                RecastJNI.rcFreeHeightField(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public void setWidth(int value) {
        RecastJNI.rcHeightfield_width_set(swigCPtr, this, value);
    }

    public int getWidth() {
        return RecastJNI.rcHeightfield_width_get(swigCPtr, this);
    }

    public void setHeight(int value) {
        RecastJNI.rcHeightfield_height_set(swigCPtr, this, value);
    }

    public int getHeight() {
        return RecastJNI.rcHeightfield_height_get(swigCPtr, this);
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcHeightfield_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcHeightfield_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcHeightfield_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcHeightfield_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setCellSize(float value) {
        RecastJNI.rcHeightfield_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.rcHeightfield_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.rcHeightfield_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.rcHeightfield_ch_get(swigCPtr, this);
    }

    public Span[] getSpans() {
        long cPtr = RecastJNI.rcHeightfield_spans_get(swigCPtr, this);
        //return (cPtr == 0) ? null : new SWIGTYPE_p_p_rcSpan(cPtr, false);
        Span[] spans = new Span[getHeight() * getWidth()];
        for (int i = 0; i < spans.length; i++) {
            spans[i] = new Span(cPtr, false);
            //FIXME:
            cPtr = RecastJNI.rcHeightfield_spans_get(swigCPtr, this);
        }
        return spans;
    }
    /*
     public Span getFreelist() {
     long cPtr = RecastJNI.rcHeightfield_freelist_get(swigCPtr, this);
     return (cPtr == 0) ? null : new Span(cPtr, false);
     }*/
}
