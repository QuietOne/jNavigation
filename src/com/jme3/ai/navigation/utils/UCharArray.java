package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting unsigned char arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class UCharArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public UCharArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(UCharArray obj) {
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
                RecastJNI.delete_UCharArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public UCharArray(int nelements) {
        this(RecastJNI.new_UCharArray(nelements), true);
    }

    public short getItem(int index) {
        return RecastJNI.UCharArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, short value) {
        RecastJNI.UCharArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_unsigned_char cast() {
        long cPtr = RecastJNI.UCharArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
    }

    public static UCharArray fromPointer(SWIGTYPE_p_unsigned_char t) {
        long cPtr = RecastJNI.UCharArray_frompointer(SWIGTYPE_p_unsigned_char.getCPtr(t));
        return (cPtr == 0) ? null : new UCharArray(cPtr, false);
    }
}
