package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class Link {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Link() {
        this(RecastJNI.new_dtLink(), true);
    }

    public Link(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Link obj) {
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
                RecastJNI.delete_dtLink(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setReference(long value) {
        RecastJNI.dtLink_ref_set(swigCPtr, this, value);
    }

    public long getReference() {
        return RecastJNI.dtLink_ref_get(swigCPtr, this);
    }

    public void setNext(long value) {
        RecastJNI.dtLink_next_set(swigCPtr, this, value);
    }

    public long getNext() {
        return RecastJNI.dtLink_next_get(swigCPtr, this);
    }

    public void setEdge(short value) {
        RecastJNI.dtLink_edge_set(swigCPtr, this, value);
    }

    public short getEdge() {
        return RecastJNI.dtLink_edge_get(swigCPtr, this);
    }

    public void setSide(short value) {
        RecastJNI.dtLink_side_set(swigCPtr, this, value);
    }

    public short getSide() {
        return RecastJNI.dtLink_side_get(swigCPtr, this);
    }

    public void setMinBoundary(short value) {
        RecastJNI.dtLink_bmin_set(swigCPtr, this, value);
    }

    public short getMinBoundary() {
        return RecastJNI.dtLink_bmin_get(swigCPtr, this);
    }

    public void setMaxBoundary(short value) {
        RecastJNI.dtLink_bmax_set(swigCPtr, this, value);
    }

    public short getMaxBoundary() {
        return RecastJNI.dtLink_bmax_get(swigCPtr, this);
    }
}
