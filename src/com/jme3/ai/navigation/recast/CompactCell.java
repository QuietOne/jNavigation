package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompactCell {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CompactCell() {
        this(RecastJNI.new_rcCompactCell(), true);
    }

    public CompactCell(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(CompactCell obj) {
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
                RecastJNI.delete_rcCompactCell(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setIndex(long value) {
        RecastJNI.rcCompactCell_index_set(swigCPtr, this, value);
    }

    public long getIndex() {
        return RecastJNI.rcCompactCell_index_get(swigCPtr, this);
    }

    public void setCount(long value) {
        RecastJNI.rcCompactCell_count_set(swigCPtr, this, value);
    }

    public long getCount() {
        return RecastJNI.rcCompactCell_count_get(swigCPtr, this);
    }
}
