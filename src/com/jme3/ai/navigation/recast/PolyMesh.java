package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PolyMesh {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public PolyMesh() {
        swigCPtr = RecastJNI.rcAllocPolyMesh();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public PolyMesh(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PolyMesh obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            delete();
        } finally {
            super.finalize();
        }
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.rcFreePolyMesh(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.rcPolyMesh_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.rcPolyMesh_verts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr, getNumberOfVertices());
    }

    public void setPolygons(short[] polygons) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygons);
        RecastJNI.rcPolyMesh_polys_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getPolygons() {
        long cPtr = RecastJNI.rcPolyMesh_polys_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getMaxNumberOfPolygons() * 2 * getNumberOfVerticesPerPolygon());
    }

    public void setRegionIDs(short[] regionIDs) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(regionIDs);
        RecastJNI.rcPolyMesh_regs_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getRegionIDs() {
        long cPtr = RecastJNI.rcPolyMesh_regs_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getMaxNumberOfPolygons());
    }

    public void setFlags(short[] flags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(flags);
        RecastJNI.rcPolyMesh_flags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getFlags() {
        long cPtr = RecastJNI.rcPolyMesh_flags_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getMaxNumberOfPolygons());
    }

    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcPolyMesh_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getAreas() {
        long cPtr = RecastJNI.rcPolyMesh_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getMaxNumberOfPolygons());
    }

    public void setNumberOfVertices(int value) {
        RecastJNI.rcPolyMesh_nverts_set(swigCPtr, this, value);
    }

    public int getNumberOfVertices() {
        return RecastJNI.rcPolyMesh_nverts_get(swigCPtr, this);
    }

    public void setNumberOfPolygons(int value) {
        RecastJNI.rcPolyMesh_npolys_set(swigCPtr, this, value);
    }

    public int getNumberOfPolygons() {
        return RecastJNI.rcPolyMesh_npolys_get(swigCPtr, this);
    }

    public void setMaxNumberOfPolygons(int value) {
        RecastJNI.rcPolyMesh_maxpolys_set(swigCPtr, this, value);
    }

    public int getMaxNumberOfPolygons() {
        return RecastJNI.rcPolyMesh_maxpolys_get(swigCPtr, this);
    }

    public void setNumberOfVerticesPerPolygon(int value) {
        RecastJNI.rcPolyMesh_nvp_set(swigCPtr, this, value);
    }

    public int getNumberOfVerticesPerPolygon() {
        return RecastJNI.rcPolyMesh_nvp_get(swigCPtr, this);
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcPolyMesh_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcPolyMesh_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcPolyMesh_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcPolyMesh_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setCellSize(float value) {
        RecastJNI.rcPolyMesh_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.rcPolyMesh_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.rcPolyMesh_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.rcPolyMesh_ch_get(swigCPtr, this);
    }

    public void setBorderSize(int value) {
        RecastJNI.rcPolyMesh_borderSize_set(swigCPtr, this, value);
    }

    public int getBorderSize() {
        return RecastJNI.rcPolyMesh_borderSize_get(swigCPtr, this);
    }
}
