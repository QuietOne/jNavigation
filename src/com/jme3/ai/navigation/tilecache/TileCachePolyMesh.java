package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCachePolyMesh {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCachePolyMesh() {
        this(RecastJNI.new_dtTileCachePolyMesh(), true);
    }

    public TileCachePolyMesh(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCachePolyMesh obj) {
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
                RecastJNI.delete_dtTileCachePolyMesh(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setNumberOfVerticesPerPolygons(int value) {
        RecastJNI.dtTileCachePolyMesh_nvp_set(swigCPtr, this, value);
    }

    public int getNumberOfVerticesPerPolygons() {
        return RecastJNI.dtTileCachePolyMesh_nvp_get(swigCPtr, this);
    }

    public void setNumberOfVertices(int value) {
        RecastJNI.dtTileCachePolyMesh_nverts_set(swigCPtr, this, value);
    }

    public int getNumberOfVertices() {
        return RecastJNI.dtTileCachePolyMesh_nverts_get(swigCPtr, this);
    }

    public void setNumberOfPolygons(int value) {
        RecastJNI.dtTileCachePolyMesh_npolys_set(swigCPtr, this, value);
    }

    public int getNumberOfPolygons() {
        return RecastJNI.dtTileCachePolyMesh_npolys_get(swigCPtr, this);
    }

    public void setVertices(short[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.dtTileCachePolyMesh_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getVertices() {
        long cPtr = RecastJNI.dtTileCachePolyMesh_verts_get(swigCPtr, this);
        if (cPtr == 0) return null;
        return Converter.convertToShorts(cPtr, getNumberOfVertices());
    }

    public void setPolygons(short[] polygons) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygons);
        RecastJNI.dtTileCachePolyMesh_polys_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getPolygons() {
        long cPtr = RecastJNI.dtTileCachePolyMesh_polys_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getNumberOfPolygons());
    }

    public void setFlags(short[] flags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(flags);
        RecastJNI.dtTileCachePolyMesh_flags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public short[] getFlags() {
        long cPtr = RecastJNI.dtTileCachePolyMesh_flags_get(swigCPtr, this);
        //check count
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getNumberOfPolygons());
    }

    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.dtTileCachePolyMesh_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getAreas() {
        long cPtr = RecastJNI.dtTileCachePolyMesh_areas_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToChars(cPtr, getNumberOfPolygons());
    }
}
