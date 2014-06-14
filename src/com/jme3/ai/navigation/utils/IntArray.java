package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting int arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class IntArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IntArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(IntArray obj) {
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
                RecastJNI.delete_IntArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public IntArray(int nelements) {
        this(RecastJNI.new_IntArray(nelements), true);
    }

    public int getItem(int index) {
        return RecastJNI.IntArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, int value) {
        RecastJNI.IntArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_int cast() {
        long cPtr = RecastJNI.IntArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
    }

    public static IntArray frompointer(SWIGTYPE_p_int t) {
        long cPtr = RecastJNI.IntArray_frompointer(SWIGTYPE_p_int.getCPtr(t));
        return (cPtr == 0) ? null : new IntArray(cPtr, false);
    }
}
