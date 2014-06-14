package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting long arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class LongArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public LongArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(LongArray obj) {
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
                RecastJNI.delete_LongArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public LongArray(int nelements) {
        this(RecastJNI.new_LongArray(nelements), true);
    }

    public int getItem(int index) {
        return RecastJNI.LongArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, int value) {
        RecastJNI.LongArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_long cast() {
        long cPtr = RecastJNI.LongArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_long(cPtr, false);
    }

    public static LongArray fromPointer(SWIGTYPE_p_long t) {
        long cPtr = RecastJNI.LongArray_frompointer(SWIGTYPE_p_long.getCPtr(t));
        return (cPtr == 0) ? null : new LongArray(cPtr, false);
    }
}
