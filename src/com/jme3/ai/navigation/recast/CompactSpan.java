package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Represents a span of unobstructed space within a compact heightfield.
 *
 * The span represents open, unobstructed space within a compact heightfield
 * column.
 *
 * Useful instances of this type can only by obtained from a CompactHeightfield
 * object.
 *
 * @see CompactHeightfield
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompactSpan {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Internal use only.
     */
    protected CompactSpan(long cPtr, boolean cMemoryOwn) {
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

    /**
     *
     * @param value The lower extent of the span. (Measured from the
     * heightfield's base.)
     */
    public void setY(int value) {
        RecastJNI.rcCompactSpan_y_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The lower extent of the span. (Measured from the heightfield's
     * base.)
     */
    public int getY() {
        return RecastJNI.rcCompactSpan_y_get(swigCPtr, this);
    }

    /**
     *
     * @param value The id of the region the span belongs to. (Or zero if not in
     * a region.)
     */
    public void setRegionID(int value) {
        RecastJNI.rcCompactSpan_reg_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The id of the region the span belongs to. (Or zero if not in a
     * region.)
     */
    public int getRegionID() {
        return RecastJNI.rcCompactSpan_reg_get(swigCPtr, this);
    }

    /**
     *
     * @param value Packed neighbor connection data.
     */
    public void setConnnection(long value) {
        RecastJNI.rcCompactSpan_con_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Packed neighbor connection data.
     */
    public long getConnection() {
        return RecastJNI.rcCompactSpan_con_get(swigCPtr, this);
    }

    /**
     * @param value The height of the span. (Measured from y.)
     */
    public void setHeight(long value) {
        RecastJNI.rcCompactSpan_h_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of the span. (Measured from y.)
     */
    public long getHeight() {
        return RecastJNI.rcCompactSpan_h_get(swigCPtr, this);
    }
}
