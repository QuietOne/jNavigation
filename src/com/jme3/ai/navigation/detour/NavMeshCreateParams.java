package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radoavljevic
 * @version 0.5
 */
public class NavMeshCreateParams {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NavMeshCreateParams() {
        this(RecastJNI.new_dtNavMeshCreateParams(), true);
    }

    public NavMeshCreateParams(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NavMeshCreateParams obj) {
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
                RecastJNI.delete_dtNavMeshCreateParams(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.dtNavMeshCreateParams_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_verts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getVerticesCount());
    }

    public void setVerticesCount(int value) {
        RecastJNI.dtNavMeshCreateParams_vertCount_set(swigCPtr, this, value);
    }

    public int getVerticesCount() {
        return RecastJNI.dtNavMeshCreateParams_vertCount_get(swigCPtr, this);
    }

    public void setPolygons(short[] polygons) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygons);
        RecastJNI.dtNavMeshCreateParams_polys_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getPolygons() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_polys_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getPolygonCount() * 2 * getNumberOfVerticesPerPolygon());
    }

    public void setPolygonFlags(short[] polygonFlags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygonFlags);
        RecastJNI.dtNavMeshCreateParams_polyFlags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getPolygonFlags() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_polyFlags_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getPolygonCount());
    }

    public void setPolygonAreas(char[] polygonAreas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(polygonAreas);
        RecastJNI.dtNavMeshCreateParams_polyAreas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getPolygonAreas() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_polyAreas_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getPolygonCount());
    }

    public void setPolygonCount(int value) {
        RecastJNI.dtNavMeshCreateParams_polyCount_set(swigCPtr, this, value);
    }

    public int getPolygonCount() {
        return RecastJNI.dtNavMeshCreateParams_polyCount_get(swigCPtr, this);
    }

    public void setNumberOfVerticesPerPolygon(int value) {
        RecastJNI.dtNavMeshCreateParams_nvp_set(swigCPtr, this, value);
    }

    public int getNumberOfVerticesPerPolygon() {
        return RecastJNI.dtNavMeshCreateParams_nvp_get(swigCPtr, this);
    }

    public void setDetailMeshes(int[] detailMeshes) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(detailMeshes);
        RecastJNI.dtNavMeshCreateParams_detailMeshes_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    public int[] getDetailMeshes() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_detailMeshes_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToInts(cPtr, getPolygonCount() * 4);
    }

    public void setDetailVertices(Vector3f[] detailVertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(detailVertices);
        RecastJNI.dtNavMeshCreateParams_detailVerts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f[] getDetailVertices() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_detailVerts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getDetailVerticesCount());
    }

    public void setDetailVerticesCount(int value) {
        RecastJNI.dtNavMeshCreateParams_detailVertsCount_set(swigCPtr, this, value);
    }

    public int getDetailVerticesCount() {
        return RecastJNI.dtNavMeshCreateParams_detailVertsCount_get(swigCPtr, this);
    }

    public void setDetailTriangles(char[] detailTriangles) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(detailTriangles);
        RecastJNI.dtNavMeshCreateParams_detailTris_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getDetailTriangles() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_detailTris_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getDetailTriangleCount() * 4);
    }

    public void setDetailTriangleCount(int value) {
        RecastJNI.dtNavMeshCreateParams_detailTriCount_set(swigCPtr, this, value);
    }

    public int getDetailTriangleCount() {
        return RecastJNI.dtNavMeshCreateParams_detailTriCount_get(swigCPtr, this);
    }

    public void setOffMeshConnectionVertices(Vector3f[] connectionVertices) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(connectionVertices);
        RecastJNI.dtNavMeshCreateParams_offMeshConVerts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f[] getOffMeshConnectionVertices() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConVerts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, getOffMeshConnectionCount() * 2);
    }

    public void setOffMeshConnectionRadii(float[] radii) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(radii);
        RecastJNI.dtNavMeshCreateParams_offMeshConRad_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public float[] getOffMeshConnectionRadii() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConRad_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToFloats(cPtr, getOffMeshConnectionCount());
    }

    public void setOffMeshConnectionFlags(short[] connectionFlags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(connectionFlags);
        RecastJNI.dtNavMeshCreateParams_offMeshConFlags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getOffMeshConnectionFlags() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConFlags_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getOffMeshConnectionCount());
    }

    public void setOffMeshConnectionAreas(char[] connectionAreas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connectionAreas);
        RecastJNI.dtNavMeshCreateParams_offMeshConAreas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getOffMeshConnectionAreas() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConAreas_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getOffMeshConnectionCount());
    }

    public void setOffMeshConnectionDirection(char[] connectionDirections) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connectionDirections);
        RecastJNI.dtNavMeshCreateParams_offMeshConDir_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getOffMeshConnectionDirection() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConDir_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getOffMeshConnectionCount());
    }

    public void setOffMeshConnectionUserID(int[] connectionUserIDs) {
        SWIGTYPE_p_unsigned_int value = Converter.convertToSWIGTYPE_p_unsigned_int(connectionUserIDs);
        RecastJNI.dtNavMeshCreateParams_offMeshConUserID_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
    }

    public int[] getOffMeshConnectionUserID() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_offMeshConUserID_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToInts(cPtr, getOffMeshConnectionCount());
    }

    public void setOffMeshConnectionCount(int value) {
        RecastJNI.dtNavMeshCreateParams_offMeshConCount_set(swigCPtr, this, value);
    }

    public int getOffMeshConnectionCount() {
        return RecastJNI.dtNavMeshCreateParams_offMeshConCount_get(swigCPtr, this);
    }

    public void setUserId(long value) {
        RecastJNI.dtNavMeshCreateParams_userId_set(swigCPtr, this, value);
    }

    public long getUserId() {
        return RecastJNI.dtNavMeshCreateParams_userId_get(swigCPtr, this);
    }

    public void setTileX(int value) {
        RecastJNI.dtNavMeshCreateParams_tileX_set(swigCPtr, this, value);
    }

    public int getTileX() {
        return RecastJNI.dtNavMeshCreateParams_tileX_get(swigCPtr, this);
    }

    public void setTileY(int value) {
        RecastJNI.dtNavMeshCreateParams_tileY_set(swigCPtr, this, value);
    }

    public int getTileY() {
        return RecastJNI.dtNavMeshCreateParams_tileY_get(swigCPtr, this);
    }

    public void setTileLayer(int value) {
        RecastJNI.dtNavMeshCreateParams_tileLayer_set(swigCPtr, this, value);
    }

    public int getTileLayer() {
        return RecastJNI.dtNavMeshCreateParams_tileLayer_get(swigCPtr, this);
    }

    public void setMinBound(Vector3f minBound) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBound);
        RecastJNI.dtNavMeshCreateParams_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBound() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_bmin_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setMaxBound(Vector3f maxBound) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBound);
        RecastJNI.dtNavMeshCreateParams_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBound() {
        long cPtr = RecastJNI.dtNavMeshCreateParams_bmax_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    public void setWalkableHeight(float value) {
        RecastJNI.dtNavMeshCreateParams_walkableHeight_set(swigCPtr, this, value);
    }

    public float getWalkableHeight() {
        return RecastJNI.dtNavMeshCreateParams_walkableHeight_get(swigCPtr, this);
    }

    public void setWalkableRadius(float value) {
        RecastJNI.dtNavMeshCreateParams_walkableRadius_set(swigCPtr, this, value);
    }

    public float getWalkableRadius() {
        return RecastJNI.dtNavMeshCreateParams_walkableRadius_get(swigCPtr, this);
    }

    public void setWalkableClimb(float value) {
        RecastJNI.dtNavMeshCreateParams_walkableClimb_set(swigCPtr, this, value);
    }

    public float getWalkableClimb() {
        return RecastJNI.dtNavMeshCreateParams_walkableClimb_get(swigCPtr, this);
    }

    public void setCellSize(float value) {
        RecastJNI.dtNavMeshCreateParams_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.dtNavMeshCreateParams_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.dtNavMeshCreateParams_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.dtNavMeshCreateParams_ch_get(swigCPtr, this);
    }

    public void setBuildBvTree(boolean value) {
        RecastJNI.dtNavMeshCreateParams_buildBvTree_set(swigCPtr, this, value);
    }

    public boolean getBuildBvTree() {
        return RecastJNI.dtNavMeshCreateParams_buildBvTree_get(swigCPtr, this);
    }
}
