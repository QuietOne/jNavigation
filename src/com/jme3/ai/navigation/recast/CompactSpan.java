package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompactSpan {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CompactSpan() {
        this(RecastJNI.new_rcCompactSpan(), true);
    }

    public CompactSpan(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(CompactSpan obj) {
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
                RecastJNI.delete_rcCompactSpan(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setY(int value) {
        RecastJNI.rcCompactSpan_y_set(swigCPtr, this, value);
    }

    public int getY() {
        return RecastJNI.rcCompactSpan_y_get(swigCPtr, this);
    }

    public void setRegionID(int value) {
        RecastJNI.rcCompactSpan_reg_set(swigCPtr, this, value);
    }

    public int getRegionID() {
        return RecastJNI.rcCompactSpan_reg_get(swigCPtr, this);
    }

    public void setConnnection(long value) {
        RecastJNI.rcCompactSpan_con_set(swigCPtr, this, value);
    }

    public long getConnection() {
        return RecastJNI.rcCompactSpan_con_get(swigCPtr, this);
    }

    public void setHeight(long value) {
        RecastJNI.rcCompactSpan_h_set(swigCPtr, this, value);
    }

    public long getHeight() {
        return RecastJNI.rcCompactSpan_h_get(swigCPtr, this);
    }
}
