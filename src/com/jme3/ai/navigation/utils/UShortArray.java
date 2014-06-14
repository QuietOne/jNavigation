package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting unsigned short arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class UShortArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public UShortArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(UShortArray obj) {
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
                RecastJNI.delete_UShortArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public UShortArray(int nelements) {
        this(RecastJNI.new_UShortArray(nelements), true);
    }

    public int getItem(int index) {
        return RecastJNI.UShortArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, int value) {
        RecastJNI.UShortArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_unsigned_short cast() {
        long cPtr = RecastJNI.UShortArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_short(cPtr, false);
    }

    public static UShortArray fromPointer(SWIGTYPE_p_unsigned_short t) {
        long cPtr = RecastJNI.UShortArray_frompointer(SWIGTYPE_p_unsigned_short.getCPtr(t));
        return (cPtr == 0) ? null : new UShortArray(cPtr, false);
    }
}
