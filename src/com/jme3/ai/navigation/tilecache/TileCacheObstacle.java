package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheObstacle {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheObstacle() {
        this(RecastJNI.new_dtTileCacheObstacle(), true);
    }

    public TileCacheObstacle(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheObstacle obj) {
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
                RecastJNI.delete_dtTileCacheObstacle(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setPosition(Vector3f position) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtTileCacheObstacle_pos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getPosition() {
        long cPtr = RecastJNI.dtTileCacheObstacle_pos_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setRadius(float value) {
        RecastJNI.dtTileCacheObstacle_radius_set(swigCPtr, this, value);
    }

    public float getRadius() {
        return RecastJNI.dtTileCacheObstacle_radius_get(swigCPtr, this);
    }

    public void setHeight(float value) {
        RecastJNI.dtTileCacheObstacle_height_set(swigCPtr, this, value);
    }

    public float getHeight() {
        return RecastJNI.dtTileCacheObstacle_height_get(swigCPtr, this);
    }

    public void setTouched(int[] touched) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(touched);
        RecastJNI.dtTileCacheObstacle_touched_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    public int[] getTouched() {
        long cPtr = RecastJNI.dtTileCacheObstacle_touched_get(swigCPtr, this);
        if (cPtr == 0) return null; 
        return Converter.convertToInts(cPtr, getNumberOfTouched());
    }

    public void setPending(int[] pending) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(pending);
        RecastJNI.dtTileCacheObstacle_pending_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    public int[] getPending() {
        long cPtr = RecastJNI.dtTileCacheObstacle_pending_get(swigCPtr, this);
        if (cPtr == 0) return null;
        return Converter.convertToInts(cPtr, getNumberOfPending());
    }

    public void setSalt(int value) {
        RecastJNI.dtTileCacheObstacle_salt_set(swigCPtr, this, value);
    }

    public int getSalt() {
        return RecastJNI.dtTileCacheObstacle_salt_get(swigCPtr, this);
    }

    public void setState(short value) {
        RecastJNI.dtTileCacheObstacle_state_set(swigCPtr, this, value);
    }

    public short getState() {
        return RecastJNI.dtTileCacheObstacle_state_get(swigCPtr, this);
    }

    public void setNumberOfTouched(short value) {
        RecastJNI.dtTileCacheObstacle_ntouched_set(swigCPtr, this, value);
    }

    public short getNumberOfTouched() {
        return RecastJNI.dtTileCacheObstacle_ntouched_get(swigCPtr, this);
    }

    public void setNumberOfPending(short value) {
        RecastJNI.dtTileCacheObstacle_npending_set(swigCPtr, this, value);
    }

    public short getNumberOfPending() {
        return RecastJNI.dtTileCacheObstacle_npending_get(swigCPtr, this);
    }

    public void setNext(TileCacheObstacle value) {
        RecastJNI.dtTileCacheObstacle_next_set(swigCPtr, this, TileCacheObstacle.getCPtr(value), value);
    }

    public TileCacheObstacle getNext() {
        long cPtr = RecastJNI.dtTileCacheObstacle_next_get(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheObstacle(cPtr, false);
    }
}
