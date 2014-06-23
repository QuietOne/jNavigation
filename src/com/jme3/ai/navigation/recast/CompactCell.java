package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Provides information on the content of a cell column in a compact
 * heightfield.
 *
 * Useful instances of this type can only by obtained from a CompactHeightfield
 * object.
 *
 * @see CompactHeightfield
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompactCell {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Internal use only.
     */
    protected CompactCell(long cPtr, boolean cMemoryOwn) {
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

//    public void setIndex(long value) {
//        RecastJNI.rcCompactCell_index_set(swigCPtr, this, value);
//    }
    /**
     *
     * @return Index to the first span in the column.
     */
    public long getIndex() {
        return RecastJNI.rcCompactCell_index_get(swigCPtr, this);
    }

//    public void setCount(long value) {
//        RecastJNI.rcCompactCell_count_set(swigCPtr, this, value);
//    }
    /**
     *
     * @return Number of spans in the column.
     */
    public long getCount() {
        return RecastJNI.rcCompactCell_count_get(swigCPtr, this);
    }
}
