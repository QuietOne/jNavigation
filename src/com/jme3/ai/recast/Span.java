package com.jme3.ai.recast;

import com.jme3.ai.recast.utils.RecastJNI;

/**
 * Class for looking at Heightfield structure.
 * @author tihomir
 */
public class Span {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Span(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Span obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_rcSpan(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setMinSpanLimit(long value) {
        RecastJNI.rcSpan_smin_set(swigCPtr, this, value);
    }

    public long getMinSpanLimit() {
        return RecastJNI.rcSpan_smin_get(swigCPtr, this);
    }

    public void setMaxSpanLimit(long value) {
        RecastJNI.rcSpan_smax_set(swigCPtr, this, value);
    }

    public long getMaxSpanLimit() {
        return RecastJNI.rcSpan_smax_get(swigCPtr, this);
    }

    public void setArea(long value) {
        RecastJNI.rcSpan_area_set(swigCPtr, this, value);
    }

    public long getArea() {
        return RecastJNI.rcSpan_area_get(swigCPtr, this);
    }

    public void setNext(Span value) {
        RecastJNI.rcSpan_next_set(swigCPtr, this, Span.getCPtr(value), value);
    }

    public Span getNext() {
        long cPtr = RecastJNI.rcSpan_next_get(swigCPtr, this);
        return (cPtr == 0) ? null : new Span(cPtr, false);
    }

    private Span() {
        this(RecastJNI.new_rcSpan(), true);
    }

    @Override
    public String toString() {
        return "Span{ area=" + getArea() +"; minSpanLimit="+getMinSpanLimit()+"; maxSpanLimit="+getMaxSpanLimit()+ '}';
    }    
}
