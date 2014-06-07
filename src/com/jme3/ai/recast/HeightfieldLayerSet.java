package com.jme3.ai.recast;

import com.jme3.ai.recast.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class HeightfieldLayerSet {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public HeightfieldLayerSet() {
        swigCPtr = RecastJNI.rcAllocHeightfieldLayerSet();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public HeightfieldLayerSet(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(HeightfieldLayerSet obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            delete();
        } finally {
            super.finalize();
        }
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.rcFreeHeightfieldLayerSet(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public void setLayers(HeightfieldLayer value) {
        RecastJNI.rcHeightfieldLayerSet_layers_set(swigCPtr, this, HeightfieldLayer.getCPtr(value), value);
    }

    public HeightfieldLayer getLayers() {
        long cPtr = RecastJNI.rcHeightfieldLayerSet_layers_get(swigCPtr, this);
        return (cPtr == 0) ? null : new HeightfieldLayer(cPtr, false);
    }

    public void setNumberOfLayers(int value) {
        RecastJNI.rcHeightfieldLayerSet_nlayers_set(swigCPtr, this, value);
    }

    public int getNumberOfLayers() {
        return RecastJNI.rcHeightfieldLayerSet_nlayers_get(swigCPtr, this);
    }
}
