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
public class Node {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Node() {
        this(RecastJNI.new_dtNode(), true);
    }

    public Node(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Node obj) {
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
                RecastJNI.delete_dtNode(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setPosition(Vector3f position) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtNode_pos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getPosition() {
        long cPtr = RecastJNI.dtNode_pos_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setCost(float value) {
        RecastJNI.dtNode_cost_set(swigCPtr, this, value);
    }

    public float getCost() {
        return RecastJNI.dtNode_cost_get(swigCPtr, this);
    }

    public void setTotal(float value) {
        RecastJNI.dtNode_total_set(swigCPtr, this, value);
    }

    public float getTotal() {
        return RecastJNI.dtNode_total_get(swigCPtr, this);
    }

    public void setPidX(long value) {
        RecastJNI.dtNode_pidx_set(swigCPtr, this, value);
    }

    public long getPidX() {
        return RecastJNI.dtNode_pidx_get(swigCPtr, this);
    }

    public void setFlags(long value) {
        RecastJNI.dtNode_flags_set(swigCPtr, this, value);
    }

    public long getFlags() {
        return RecastJNI.dtNode_flags_get(swigCPtr, this);
    }

    public void setId(long value) {
        RecastJNI.dtNode_id_set(swigCPtr, this, value);
    }

    public long getId() {
        return RecastJNI.dtNode_id_get(swigCPtr, this);
    }
}
