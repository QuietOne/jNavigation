package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheLayerHeader {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheLayerHeader() {
        this(RecastJNI.new_dtTileCacheLayerHeader(), true);
    }

    public TileCacheLayerHeader(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheLayerHeader obj) {
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
                RecastJNI.delete_dtTileCacheLayerHeader(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setMagic(int value) {
        RecastJNI.dtTileCacheLayerHeader_magic_set(swigCPtr, this, value);
    }

    public int getMagic() {
        return RecastJNI.dtTileCacheLayerHeader_magic_get(swigCPtr, this);
    }

    public void setVersion(int value) {
        RecastJNI.dtTileCacheLayerHeader_version_set(swigCPtr, this, value);
    }

    public int getVersion() {
        return RecastJNI.dtTileCacheLayerHeader_version_get(swigCPtr, this);
    }

    public void setTX(int value) {
        RecastJNI.dtTileCacheLayerHeader_tx_set(swigCPtr, this, value);
    }

    public int getTX() {
        return RecastJNI.dtTileCacheLayerHeader_tx_get(swigCPtr, this);
    }

    public void setTY(int value) {
        RecastJNI.dtTileCacheLayerHeader_ty_set(swigCPtr, this, value);
    }

    public int getTY() {
        return RecastJNI.dtTileCacheLayerHeader_ty_get(swigCPtr, this);
    }

    public void setTLayer(int value) {
        RecastJNI.dtTileCacheLayerHeader_tlayer_set(swigCPtr, this, value);
    }

    public int getTLayer() {
        return RecastJNI.dtTileCacheLayerHeader_tlayer_get(swigCPtr, this);
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.dtTileCacheLayerHeader_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.dtTileCacheLayerHeader_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.dtTileCacheLayerHeader_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));

    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.dtTileCacheLayerHeader_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMinHeight(int value) {
        RecastJNI.dtTileCacheLayerHeader_hmin_set(swigCPtr, this, value);
    }

    public int getMinHeight() {
        return RecastJNI.dtTileCacheLayerHeader_hmin_get(swigCPtr, this);
    }

    public void setMaxHeight(int value) {
        RecastJNI.dtTileCacheLayerHeader_hmax_set(swigCPtr, this, value);
    }

    public int getMaxHeight() {
        return RecastJNI.dtTileCacheLayerHeader_hmax_get(swigCPtr, this);
    }

    public void setWidth(short value) {
        RecastJNI.dtTileCacheLayerHeader_width_set(swigCPtr, this, value);
    }

    public short getWidth() {
        return RecastJNI.dtTileCacheLayerHeader_width_get(swigCPtr, this);
    }

    public void setHeight(short value) {
        RecastJNI.dtTileCacheLayerHeader_height_set(swigCPtr, this, value);
    }

    public short getHeight() {
        return RecastJNI.dtTileCacheLayerHeader_height_get(swigCPtr, this);
    }

    public void setMinX(short value) {
        RecastJNI.dtTileCacheLayerHeader_minx_set(swigCPtr, this, value);
    }

    public short getMinX() {
        return RecastJNI.dtTileCacheLayerHeader_minx_get(swigCPtr, this);
    }

    public void setMaxX(short value) {
        RecastJNI.dtTileCacheLayerHeader_maxx_set(swigCPtr, this, value);
    }

    public short getMaxX() {
        return RecastJNI.dtTileCacheLayerHeader_maxx_get(swigCPtr, this);
    }

    public void setMinY(short value) {
        RecastJNI.dtTileCacheLayerHeader_miny_set(swigCPtr, this, value);
    }

    public short getMinY() {
        return RecastJNI.dtTileCacheLayerHeader_miny_get(swigCPtr, this);
    }

    public void setMaxY(short value) {
        RecastJNI.dtTileCacheLayerHeader_maxy_set(swigCPtr, this, value);
    }

    public short getMaxY() {
        return RecastJNI.dtTileCacheLayerHeader_maxy_get(swigCPtr, this);
    }
}