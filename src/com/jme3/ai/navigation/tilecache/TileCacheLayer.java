package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheLayer {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheLayer() {
        this(RecastJNI.new_dtTileCacheLayer(), true);
    }

    public TileCacheLayer(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheLayer obj) {
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
                RecastJNI.delete_dtTileCacheLayer(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setHeader(TileCacheLayerHeader value) {
        RecastJNI.dtTileCacheLayer_header_set(swigCPtr, this, TileCacheLayerHeader.getCPtr(value), value);
    }

    public TileCacheLayerHeader getHeader() {
        long cPtr = RecastJNI.dtTileCacheLayer_header_get(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheLayerHeader(cPtr, false);
    }

    public void setRegionCount(short value) {
        RecastJNI.dtTileCacheLayer_regCount_set(swigCPtr, this, value);
    }

    public short getRegionCount() {
        return RecastJNI.dtTileCacheLayer_regCount_get(swigCPtr, this);
    }

    public void setHeights(char[] heights) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(heights);
        RecastJNI.dtTileCacheLayer_heights_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getHeights() {
        long cPtr = RecastJNI.dtTileCacheLayer_heights_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        //not sure if this is correct lenght of array
        return Converter.convertToChars(cPtr, getRegionCount());
    }

    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.dtTileCacheLayer_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getAreas() {
        long cPtr = RecastJNI.dtTileCacheLayer_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        //not sure if this is correct lenght of array
        return Converter.convertToChars(cPtr, getRegionCount());
    }

    public void setConnections(char[] connections) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connections);
        RecastJNI.dtTileCacheLayer_cons_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getConnections() {
        long cPtr = RecastJNI.dtTileCacheLayer_cons_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        //not sure if this is correct lenght of array
        return Converter.convertToChars(cPtr, getRegionCount());
    }

    public void setRegions(char[] regions) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(regions);
        RecastJNI.dtTileCacheLayer_regs_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getRegions() {
        long cPtr = RecastJNI.dtTileCacheLayer_regs_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getRegionCount());
    }
}
