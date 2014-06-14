package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting unsigned integer arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class UIntArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public UIntArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(UIntArray obj) {
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
                RecastJNI.delete_UIntArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public UIntArray(int nelements) {
        this(RecastJNI.new_UIntArray(nelements), true);
    }

    public long getItem(int index) {
        return RecastJNI.UIntArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, long value) {
        RecastJNI.UIntArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_unsigned_int cast() {
        long cPtr = RecastJNI.UIntArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
    }

    public static UIntArray fromPointer(SWIGTYPE_p_unsigned_int t) {
        long cPtr = RecastJNI.UIntArray_frompointer(SWIGTYPE_p_unsigned_int.getCPtr(t));
        return (cPtr == 0) ? null : new UIntArray(cPtr, false);
    }
}
