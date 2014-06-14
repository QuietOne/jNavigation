package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.FloatArray;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.math.Vector3f;

/**
 * 
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PolyMeshDetail {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public PolyMeshDetail() {
        swigCPtr = RecastJNI.rcAllocPolyMeshDetail();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public PolyMeshDetail(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PolyMeshDetail obj) {
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
                RecastJNI.rcFreePolyMeshDetail(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public void setMeshes(int[] meshes) {
        SWIGTYPE_p_unsigned_int value = null;//FIXME:
        RecastJNI.rcPolyMeshDetail_meshes_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    public SWIGTYPE_p_unsigned_int getMeshes() {
        long cPtr = RecastJNI.rcPolyMeshDetail_meshes_get(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
    }

    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(vertices);
        RecastJNI.rcPolyMeshDetail_verts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.rcPolyMeshDetail_verts_get(swigCPtr, this);
        if (cPtr == 0) return null;
        return Converter.convertToVector3f(cPtr, getNumberOfVertices());
    }

    public void setIndices(SWIGTYPE_p_unsigned_char value) {
        RecastJNI.rcPolyMeshDetail_tris_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public SWIGTYPE_p_unsigned_char getIndices() {
        long cPtr = RecastJNI.rcPolyMeshDetail_tris_get(swigCPtr, this);
        return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
    }

    public void setNumberOfMeshes(int value) {
        RecastJNI.rcPolyMeshDetail_nmeshes_set(swigCPtr, this, value);
    }

    public int getNumberOfMeshes() {
        return RecastJNI.rcPolyMeshDetail_nmeshes_get(swigCPtr, this);
    }

    public void setNumberOfVertices(int value) {
        RecastJNI.rcPolyMeshDetail_nverts_set(swigCPtr, this, value);
    }

    public int getNumberOfVertices() {
        return RecastJNI.rcPolyMeshDetail_nverts_get(swigCPtr, this);
    }

    public void setNumberOfIndices(int value) {
        RecastJNI.rcPolyMeshDetail_ntris_set(swigCPtr, this, value);
    }

    public int getNumberOfIndices() {
        return RecastJNI.rcPolyMeshDetail_ntris_get(swigCPtr, this);
    }
}
