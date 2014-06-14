package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class BVNode {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public BVNode() {
        this(RecastJNI.new_dtBVNode(), true);
    }
    
    public BVNode(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(BVNode obj) {
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
                RecastJNI.delete_dtBVNode(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(minBounds);
        RecastJNI.dtBVNode_bmin_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.dtBVNode_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(maxBounds);
        RecastJNI.dtBVNode_bmax_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.dtBVNode_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setNodeIndex(int index) {
        RecastJNI.dtBVNode_i_set(swigCPtr, this, index);
    }

    public int getNodeIndex() {
        return RecastJNI.dtBVNode_i_get(swigCPtr, this);
    }

    
}
