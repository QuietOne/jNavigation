package com.jme3.ai.navigation.utils;

/**
 * Helper class for extracting float arrays from native.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class FloatArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FloatArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(FloatArray obj) {
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
                RecastJNI.delete_FloatArray(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public FloatArray(int nelements) {
        this(RecastJNI.new_FloatArray(nelements), true);
    }

    public float getItem(int index) {
        return RecastJNI.FloatArray_getitem(swigCPtr, this, index);
    }

    public void setItem(int index, float value) {
        RecastJNI.FloatArray_setitem(swigCPtr, this, index, value);
    }

    public SWIGTYPE_p_float cast() {
        long cPtr = RecastJNI.FloatArray_cast(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
    }

    public static FloatArray fromPointer(SWIGTYPE_p_float t) {
        long cPtr = RecastJNI.FloatArray_frompointer(SWIGTYPE_p_float.getCPtr(t));
        return (cPtr == 0) ? null : new FloatArray(cPtr, false);
    }
}
