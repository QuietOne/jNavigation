package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting double arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class DoubleArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public DoubleArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(DoubleArray obj) {
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
                RecastJNI.delete_DoubleArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public DoubleArray(int nelements) {
        this(RecastJNI.new_DoubleArray(nelements), true);
    }

    public double getItem(int index) {
        return RecastJNI.DoubleArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, double value) {
        RecastJNI.DoubleArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_double cast() {
        long cPtr = RecastJNI.DoubleArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
    }

    public static DoubleArray fromPointer(SWIGTYPE_p_double t) {
        long cPtr = RecastJNI.DoubleArray_frompointer(SWIGTYPE_p_double.getCPtr(t));
        return (cPtr == 0) ? null : new DoubleArray(cPtr, false);
    }
}
