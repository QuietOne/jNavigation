package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.SWIGTYPE_p_void;
import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Note: all native functions are virtual.
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheAlloc {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheAlloc() {
        this(RecastJNI.new_dtTileCacheAlloc(), true);
    }

    public TileCacheAlloc(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheAlloc obj) {
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
                RecastJNI.delete_dtTileCacheAlloc(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void reset() {
        RecastJNI.dtTileCacheAlloc_reset(swigCPtr, this);
    }

    public SWIGTYPE_p_void alloc(int size) {
        long cPtr = RecastJNI.dtTileCacheAlloc_alloc(swigCPtr, this, size);
        return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
    }

    public void free(SWIGTYPE_p_void ptr) {
        RecastJNI.dtTileCacheAlloc_free(swigCPtr, this, SWIGTYPE_p_void.getCPtr(ptr));
    }
}
