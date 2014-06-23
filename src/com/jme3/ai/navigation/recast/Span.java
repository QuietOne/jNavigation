package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Represents a span in a heightfield.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Span {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Internal use only.
     */
    protected Span(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Span obj) {
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
                RecastJNI.delete_rcSpan(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value The lower limit of the span. [Limit: smaller than
     * maxSpanLimit].
     * @see Span#getMaxSpanLimit()
     */
    public void setMinSpanLimit(long value) {
        RecastJNI.rcSpan_smin_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The lower limit of the span. [Limit: smaller than maxSpanLimit].
     * @see Span#getMaxSpanLimit()
     */
    public long getMinSpanLimit() {
        return RecastJNI.rcSpan_smin_get(swigCPtr, this);
    }

    /**
     *
     * @param value The upper limit of the span. [Limit: smaller than
     * RC_SPAN_MAX_HEIGHT].
     * @see RecastBuilder#RC_SPAN_MAX_HEIGHT()
     */
    public void setMaxSpanLimit(long value) {
        RecastJNI.rcSpan_smax_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The upper limit of the span. [Limit: smaller than
     * RC_SPAN_MAX_HEIGHT].
     * @see RecastBuilder#RC_SPAN_MAX_HEIGHT()
     */
    public long getMaxSpanLimit() {
        return RecastJNI.rcSpan_smax_get(swigCPtr, this);
    }

    /**
     *
     * @param value The area id assigned to the span.
     */
    public void setArea(long value) {
        RecastJNI.rcSpan_area_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The area id assigned to the span.
     */
    public long getArea() {
        return RecastJNI.rcSpan_area_get(swigCPtr, this);
    }

    /**
     *
     * @param value The next span higher up in column.
     */
    public void setNext(Span value) {
        RecastJNI.rcSpan_next_set(swigCPtr, this, Span.getCPtr(value), value);
    }

    /**
     *
     * @return The next span higher up in column.
     */
    public Span getNext() {
        long cPtr = RecastJNI.rcSpan_next_get(swigCPtr, this);
        return (cPtr == 0) ? null : new Span(cPtr, false);
    }

    @Override
    public String toString() {
        return "Span{ area=" + getArea() + "; minSpanLimit=" + getMinSpanLimit() + "; maxSpanLimit=" + getMaxSpanLimit() + '}';
    }
}
