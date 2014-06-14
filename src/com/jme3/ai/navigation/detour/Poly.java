package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class Poly {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Poly() {
        this(RecastJNI.new_dtPoly(), true);
    }

    public Poly(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Poly obj) {
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
                RecastJNI.delete_dtPoly(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setFirstLink(long value) {
        RecastJNI.dtPoly_firstLink_set(swigCPtr, this, value);
    }

    public long getFirstLink() {
        return RecastJNI.dtPoly_firstLink_get(swigCPtr, this);
    }

    public void setVertices(short[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.dtPoly_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getVertices() {
        long cPtr = RecastJNI.dtPoly_verts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getVerticesCount());
    }

    public void setNeighbours(short[] neighbours) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(neighbours);
        RecastJNI.dtPoly_neis_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getNeighbours() {
        long cPtr = RecastJNI.dtPoly_neis_get(swigCPtr, this);
        //check count
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getVerticesCount());
    }

    public void setFlags(int value) {
        RecastJNI.dtPoly_flags_set(swigCPtr, this, value);
    }

    public int getFlags() {
        return RecastJNI.dtPoly_flags_get(swigCPtr, this);
    }

    public void setVerticesCount(short value) {
        RecastJNI.dtPoly_vertCount_set(swigCPtr, this, value);
    }

    public short getVerticesCount() {
        return RecastJNI.dtPoly_vertCount_get(swigCPtr, this);
    }

    public void setArea(short a) {
        RecastJNI.dtPoly_setArea(swigCPtr, this, a);
    }

    public void setType(short t) {
        RecastJNI.dtPoly_setType(swigCPtr, this, t);
    }

    public short getArea() {
        return RecastJNI.dtPoly_getArea(swigCPtr, this);
    }

    public short getType() {
        return RecastJNI.dtPoly_getType(swigCPtr, this);
    }
}
