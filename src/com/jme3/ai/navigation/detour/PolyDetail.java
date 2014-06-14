package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class PolyDetail {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public PolyDetail() {
        this(RecastJNI.new_dtPolyDetail(), true);
    }

    public PolyDetail(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PolyDetail obj) {
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
                RecastJNI.delete_dtPolyDetail(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setVertBase(long value) {
        RecastJNI.dtPolyDetail_vertBase_set(swigCPtr, this, value);
    }

    public long getVertBase() {
        return RecastJNI.dtPolyDetail_vertBase_get(swigCPtr, this);
    }

    public void setTriBase(long value) {
        RecastJNI.dtPolyDetail_triBase_set(swigCPtr, this, value);
    }

    public long getTriBase() {
        return RecastJNI.dtPolyDetail_triBase_get(swigCPtr, this);
    }

    public void setVertCount(short value) {
        RecastJNI.dtPolyDetail_vertCount_set(swigCPtr, this, value);
    }

    public short getVertCount() {
        return RecastJNI.dtPolyDetail_vertCount_get(swigCPtr, this);
    }

    public void setTriCount(short value) {
        RecastJNI.dtPolyDetail_triCount_set(swigCPtr, this, value);
    }

    public short getTriCount() {
        return RecastJNI.dtPolyDetail_triCount_get(swigCPtr, this);
    }
}
