package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class TileCacheContour {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheContour() {
        this(RecastJNI.new_dtTileCacheContour(), true);
    }

    public TileCacheContour(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheContour obj) {
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
                RecastJNI.delete_dtTileCacheContour(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setNumberOfVertices(int value) {
        RecastJNI.dtTileCacheContour_nverts_set(swigCPtr, this, value);
    }

    public int getNumberOfVertices() {
        return RecastJNI.dtTileCacheContour_nverts_get(swigCPtr, this);
    }

    public void setVertices(char[] vertices) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(vertices);
        RecastJNI.dtTileCacheContour_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getVertices() {
        long cPtr = RecastJNI.dtTileCacheContour_verts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getNumberOfVertices());
    }

    public void setRegionID(short value) {
        RecastJNI.dtTileCacheContour_reg_set(swigCPtr, this, value);
    }

    public short getRegionID() {
        return RecastJNI.dtTileCacheContour_reg_get(swigCPtr, this);
    }

    public void setArea(short value) {
        RecastJNI.dtTileCacheContour_area_set(swigCPtr, this, value);
    }

    public short getArea() {
        return RecastJNI.dtTileCacheContour_area_get(swigCPtr, this);
    }
}
