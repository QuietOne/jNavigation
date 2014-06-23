package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Represents a set of heightfield layers.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class HeightfieldLayerSet {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Allocates a heightfield layer set using the Recast allocator.
     */
    public HeightfieldLayerSet() {
        swigCPtr = RecastJNI.rcAllocHeightfieldLayerSet();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    protected HeightfieldLayerSet(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(HeightfieldLayerSet obj) {
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
                RecastJNI.rcFreeHeightfieldLayerSet(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

//    /**
//     * -not done yet
//     *
//     * @param value The layers in the set.
//     */
//    public void setLayers(HeightfieldLayer value) {
//        RecastJNI.rcHeightfieldLayerSet_layers_set(swigCPtr, this, HeightfieldLayer.getCPtr(value), value);
//    }
    /**
     *
     * @return The layers in the set.
     */
    public HeightfieldLayer[] getLayers() {
        long cPtr = RecastJNI.rcHeightfieldLayerSet_layers_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        HeightfieldLayer[] heightfieldLayers = new HeightfieldLayer[getNumberOfLayers()];
        for (int i = 0; i < heightfieldLayers.length; i++) {
            heightfieldLayers[i] = new HeightfieldLayer(cPtr + i, false);
        }
        return heightfieldLayers;
    }

//    /**
//     *
//     * @param value The number of layers in the set.
//     */
//    public void setNumberOfLayers(int value) {
//        RecastJNI.rcHeightfieldLayerSet_nlayers_set(swigCPtr, this, value);
//    }
    /**
     *
     * @return The number of layers in the set.
     */
    protected int getNumberOfLayers() {
        return RecastJNI.rcHeightfieldLayerSet_nlayers_get(swigCPtr, this);
    }
}
