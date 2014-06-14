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
public class MeshHeader {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public MeshHeader() {
        this(RecastJNI.new_dtMeshHeader(), true);
    }

    public MeshHeader(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(MeshHeader obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_dtMeshHeader(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setMagic(int value) {
        RecastJNI.dtMeshHeader_magic_set(swigCPtr, this, value);
    }

    public int getMagic() {
        return RecastJNI.dtMeshHeader_magic_get(swigCPtr, this);
    }

    public void setVersion(int value) {
        RecastJNI.dtMeshHeader_version_set(swigCPtr, this, value);
    }

    public int getVersion() {
        return RecastJNI.dtMeshHeader_version_get(swigCPtr, this);
    }

    public void setX(int value) {
        RecastJNI.dtMeshHeader_x_set(swigCPtr, this, value);
    }

    public int getX() {
        return RecastJNI.dtMeshHeader_x_get(swigCPtr, this);
    }

    public void setY(int value) {
        RecastJNI.dtMeshHeader_y_set(swigCPtr, this, value);
    }

    public int getY() {
        return RecastJNI.dtMeshHeader_y_get(swigCPtr, this);
    }

    public void setLayer(int value) {
        RecastJNI.dtMeshHeader_layer_set(swigCPtr, this, value);
    }

    public int getLayer() {
        return RecastJNI.dtMeshHeader_layer_get(swigCPtr, this);
    }

    public void setUserId(long value) {
        RecastJNI.dtMeshHeader_userId_set(swigCPtr, this, value);
    }

    public long getUserId() {
        return RecastJNI.dtMeshHeader_userId_get(swigCPtr, this);
    }

    public void setPolygonCount(int value) {
        RecastJNI.dtMeshHeader_polyCount_set(swigCPtr, this, value);
    }

    public int getPolygonCount() {
        return RecastJNI.dtMeshHeader_polyCount_get(swigCPtr, this);
    }

    public void setVerticesCount(int value) {
        RecastJNI.dtMeshHeader_vertCount_set(swigCPtr, this, value);
    }

    public int getVerticesCount() {
        return RecastJNI.dtMeshHeader_vertCount_get(swigCPtr, this);
    }

    public void setMaxLinkCount(int value) {
        RecastJNI.dtMeshHeader_maxLinkCount_set(swigCPtr, this, value);
    }

    public int getMaxLinkCount() {
        return RecastJNI.dtMeshHeader_maxLinkCount_get(swigCPtr, this);
    }

    public void setDetailMeshCount(int value) {
        RecastJNI.dtMeshHeader_detailMeshCount_set(swigCPtr, this, value);
    }

    public int getDetailMeshCount() {
        return RecastJNI.dtMeshHeader_detailMeshCount_get(swigCPtr, this);
    }

    public void setDetailVertCount(int value) {
        RecastJNI.dtMeshHeader_detailVertCount_set(swigCPtr, this, value);
    }

    public int getDetailVerticesCount() {
        return RecastJNI.dtMeshHeader_detailVertCount_get(swigCPtr, this);
    }

    public void setDetailTrianglesCount(int value) {
        RecastJNI.dtMeshHeader_detailTriCount_set(swigCPtr, this, value);
    }

    public int getDetailTrianglesCount() {
        return RecastJNI.dtMeshHeader_detailTriCount_get(swigCPtr, this);
    }

    public void setBvNodeCount(int value) {
        RecastJNI.dtMeshHeader_bvNodeCount_set(swigCPtr, this, value);
    }

    public int getBvNodeCount() {
        return RecastJNI.dtMeshHeader_bvNodeCount_get(swigCPtr, this);
    }

    public void setOffMeshConnectionsCount(int value) {
        RecastJNI.dtMeshHeader_offMeshConCount_set(swigCPtr, this, value);
    }

    public int getOffMeshConnectionsCount() {
        return RecastJNI.dtMeshHeader_offMeshConCount_get(swigCPtr, this);
    }

    public void setOffMeshBase(int value) {
        RecastJNI.dtMeshHeader_offMeshBase_set(swigCPtr, this, value);
    }

    public int getOffMeshBase() {
        return RecastJNI.dtMeshHeader_offMeshBase_get(swigCPtr, this);
    }

    public void setWalkableHeight(float value) {
        RecastJNI.dtMeshHeader_walkableHeight_set(swigCPtr, this, value);
    }

    public float getWalkableHeight() {
        return RecastJNI.dtMeshHeader_walkableHeight_get(swigCPtr, this);
    }

    public void setWalkableRadius(float value) {
        RecastJNI.dtMeshHeader_walkableRadius_set(swigCPtr, this, value);
    }

    public float getWalkableRadius() {
        return RecastJNI.dtMeshHeader_walkableRadius_get(swigCPtr, this);
    }

    public void setWalkableClimb(float value) {
        RecastJNI.dtMeshHeader_walkableClimb_set(swigCPtr, this, value);
    }

    public float getWalkableClimb() {
        return RecastJNI.dtMeshHeader_walkableClimb_get(swigCPtr, this);
    }

    public void setMinBound(Vector3f minBound) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBound);
        RecastJNI.dtMeshHeader_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBound() {
        long cPtr = RecastJNI.dtMeshHeader_bmin_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setMaxBound(Vector3f maxBound) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBound);
        RecastJNI.dtMeshHeader_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBound() {
        long cPtr = RecastJNI.dtMeshHeader_bmax_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setBvQuantFactor(float value) {
        RecastJNI.dtMeshHeader_bvQuantFactor_set(swigCPtr, this, value);
    }

    public float getBvQuantFactor() {
        return RecastJNI.dtMeshHeader_bvQuantFactor_get(swigCPtr, this);
    }
}
