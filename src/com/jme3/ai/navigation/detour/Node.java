package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
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

    /**
     *
     * @param position Position of the node.
     */
    public void setPosition(Vector3f position) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtNode_pos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return Position of the node.
     */
    public Vector3f getPosition() {
        long cPtr = RecastJNI.dtNode_pos_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value Cost from previous node to current node.
     */
    public void setCost(float value) {
        RecastJNI.dtNode_cost_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Cost from previous node to current node.
     */
    public float getCost() {
        return RecastJNI.dtNode_cost_get(swigCPtr, this);
    }

    /**
     *
     * @param value Cost up to the node.
     */
    public void setTotal(float value) {
        RecastJNI.dtNode_total_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Cost up to the node.
     */
    public float getTotal() {
        return RecastJNI.dtNode_total_get(swigCPtr, this);
    }

    /**
     *
     * @param value Index to parent node.
     */
    public void setParentIndex(long value) {
        RecastJNI.dtNode_pidx_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Index to parent node.
     */
    public long getParenIndex() {
        return RecastJNI.dtNode_pidx_get(swigCPtr, this);
    }

    /**
     *
     * @param value Node flags 0/open/closed.
     */
    public void setFlags(long value) {
        RecastJNI.dtNode_flags_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Node flags 0/open/closed.
     */
    public long getFlags() {
        return RecastJNI.dtNode_flags_get(swigCPtr, this);
    }

    /**
     *
     * @param value Polygon ref the node corresponds to.
     */
    public void setId(Poly poly) {
        long value = Poly.getCPtr(poly);
        RecastJNI.dtNode_id_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Polygon ref the node corresponds to.
     */
    public Poly getId() {
        long pointer = RecastJNI.dtNode_id_get(swigCPtr, this);
        return (pointer == 0) ? null : new Poly(pointer, false);
    }
}
