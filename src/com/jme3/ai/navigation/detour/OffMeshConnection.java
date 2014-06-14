package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class OffMeshConnection {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public OffMeshConnection() {
        this(RecastJNI.new_dtOffMeshConnection(), true);
    }

    public OffMeshConnection(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(OffMeshConnection obj) {
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
                RecastJNI.delete_dtOffMeshConnection(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setPosition(Vector3f position) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtOffMeshConnection_pos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getPosition() {
        long cPtr = RecastJNI.dtOffMeshConnection_pos_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setRadius(float value) {
        RecastJNI.dtOffMeshConnection_rad_set(swigCPtr, this, value);
    }

    public float getRadius() {
        return RecastJNI.dtOffMeshConnection_rad_get(swigCPtr, this);
    }

    public void setPolygon(int value) {
        RecastJNI.dtOffMeshConnection_poly_set(swigCPtr, this, value);
    }

    public int getPolygon() {
        return RecastJNI.dtOffMeshConnection_poly_get(swigCPtr, this);
    }

    public void setFlags(short value) {
        RecastJNI.dtOffMeshConnection_flags_set(swigCPtr, this, value);
    }

    public short getFlags() {
        return RecastJNI.dtOffMeshConnection_flags_get(swigCPtr, this);
    }

    public void setSide(short value) {
        RecastJNI.dtOffMeshConnection_side_set(swigCPtr, this, value);
    }

    public short getSide() {
        return RecastJNI.dtOffMeshConnection_side_get(swigCPtr, this);
    }

    public void setUserId(long value) {
        RecastJNI.dtOffMeshConnection_userId_set(swigCPtr, this, value);
    }

    public long getUserId() {
        return RecastJNI.dtOffMeshConnection_userId_get(swigCPtr, this);
    }
}
