package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 * Bounding volume node.
 *
 * Note This structure is rarely if ever used by the end user.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
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

    /**
     *
     * @param minBounds Minimum bounds of the node's AABB.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(minBounds);
        RecastJNI.dtBVNode_bmin_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return Minimum bounds of the node's AABB.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.dtBVNode_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBounds Maximum bounds of the node's AABB.
     */
    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(maxBounds);
        RecastJNI.dtBVNode_bmax_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return Maximum bounds of the node's AABB.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.dtBVNode_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param index The node's index. (Negative for escape sequence.)
     */
    public void setNodeIndex(int index) {
        RecastJNI.dtBVNode_i_set(swigCPtr, this, index);
    }

    /**
     *
     * @return The node's index. (Negative for escape sequence.)
     */
    public int getNodeIndex() {
        return RecastJNI.dtBVNode_i_get(swigCPtr, this);
    }
}
