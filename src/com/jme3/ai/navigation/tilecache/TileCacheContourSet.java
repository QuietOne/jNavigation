package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheContourSet {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheContourSet() {
        this(RecastJNI.new_dtTileCacheContourSet(), true);
    }

    public TileCacheContourSet(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheContourSet obj) {
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
                RecastJNI.delete_dtTileCacheContourSet(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setNumberOfContours(int value) {
        RecastJNI.dtTileCacheContourSet_nconts_set(swigCPtr, this, value);
    }

    public int getNumberOfContours() {
        return RecastJNI.dtTileCacheContourSet_nconts_get(swigCPtr, this);
    }

    public void setContours(TileCacheContour value) {
        RecastJNI.dtTileCacheContourSet_conts_set(swigCPtr, this, TileCacheContour.getCPtr(value), value);
    }

    public TileCacheContour getContours() {
        long cPtr = RecastJNI.dtTileCacheContourSet_conts_get(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheContour(cPtr, false);
    }
}
