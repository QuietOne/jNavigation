package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Defines a link between polygons.
 *
 * Note This structure is rarely if ever used by the end user.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Link {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Link() {
        this(RecastJNI.new_dtLink(), true);
    }

    public Link(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Link obj) {
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
                RecastJNI.delete_dtLink(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value Neighbour reference. (The neighbor that is linked to.)
     */
    public void setReference(long value) {
        RecastJNI.dtLink_ref_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Neighbour reference. (The neighbor that is linked to.)
     */
    public long getReference() {
        return RecastJNI.dtLink_ref_get(swigCPtr, this);
    }

    /**
     *
     * @param value Index of the next link.
     */
    public void setNext(long value) {
        RecastJNI.dtLink_next_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Index of the next link.
     */
    public long getNext() {
        return RecastJNI.dtLink_next_get(swigCPtr, this);
    }

    /**
     *
     * @param value Index of the polygon edge that owns this link.
     */
    public void setEdge(short value) {
        RecastJNI.dtLink_edge_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Index of the polygon edge that owns this link.
     */
    public short getEdge() {
        return RecastJNI.dtLink_edge_get(swigCPtr, this);
    }

    /**
     *
     * @param value If a boundary link, defines on which side the link is.
     */
    public void setSide(short value) {
        RecastJNI.dtLink_side_set(swigCPtr, this, value);
    }

    /**
     *
     * @return If a boundary link, defines on which side the link is.
     */
    public short getSide() {
        return RecastJNI.dtLink_side_get(swigCPtr, this);
    }

    /**
     *
     * @param value If a boundary link, defines the minimum sub-edge area.
     */
    public void setMinBoundary(short value) {
        RecastJNI.dtLink_bmin_set(swigCPtr, this, value);
    }

    /**
     *
     * @return If a boundary link, defines the minimum sub-edge area.
     */
    public short getMinBoundary() {
        return RecastJNI.dtLink_bmin_get(swigCPtr, this);
    }

    /**
     *
     * @param value If a boundary link, defines the maximum sub-edge area.
     */
    public void setMaxBoundary(short value) {
        RecastJNI.dtLink_bmax_set(swigCPtr, this, value);
    }

    /**
     *
     * @return If a boundary link, defines the maximum sub-edge area.
     */
    public short getMaxBoundary() {
        return RecastJNI.dtLink_bmax_get(swigCPtr, this);
    }
}
