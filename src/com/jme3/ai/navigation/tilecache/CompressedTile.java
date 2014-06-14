package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompressedTile {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CompressedTile() {
        this(RecastJNI.new_dtCompressedTile(), true);
    }

    public CompressedTile(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(CompressedTile obj) {
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
                RecastJNI.delete_dtCompressedTile(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void setSalt(long value) {
        RecastJNI.dtCompressedTile_salt_set(swigCPtr, this, value);
    }

    public long getSalt() {
        return RecastJNI.dtCompressedTile_salt_get(swigCPtr, this);
    }

    public void setHeader(TileCacheLayerHeader value) {
        RecastJNI.dtCompressedTile_header_set(swigCPtr, this, TileCacheLayerHeader.getCPtr(value), value);
    }

    public TileCacheLayerHeader getHeader() {
        long cPtr = RecastJNI.dtCompressedTile_header_get(swigCPtr, this);
        return (cPtr == 0) ? null : new TileCacheLayerHeader(cPtr, false);
    }

    public void setCompressed(char[] compressed) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(compressed);
        RecastJNI.dtCompressedTile_compressed_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getCompressed() {
        long cPtr = RecastJNI.dtCompressedTile_compressed_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getCompressedSize());
    }

    public void setCompressedSize(int value) {
        RecastJNI.dtCompressedTile_compressedSize_set(swigCPtr, this, value);
    }

    public int getCompressedSize() {
        return RecastJNI.dtCompressedTile_compressedSize_get(swigCPtr, this);
    }

    public void setData(char[] data) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(data);
        RecastJNI.dtCompressedTile_data_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getData() {
        long cPtr = RecastJNI.dtCompressedTile_data_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getDataSize());
    }

    public void setDataSize(int value) {
        RecastJNI.dtCompressedTile_dataSize_set(swigCPtr, this, value);
    }

    public int getDataSize() {
        return RecastJNI.dtCompressedTile_dataSize_get(swigCPtr, this);
    }

    public void setFlags(long value) {
        RecastJNI.dtCompressedTile_flags_set(swigCPtr, this, value);
    }

    public long getFlags() {
        return RecastJNI.dtCompressedTile_flags_get(swigCPtr, this);
    }

    public void setNext(CompressedTile value) {
        RecastJNI.dtCompressedTile_next_set(swigCPtr, this, CompressedTile.getCPtr(value), value);
    }

    public CompressedTile getNext() {
        long cPtr = RecastJNI.dtCompressedTile_next_get(swigCPtr, this);
        return (cPtr == 0) ? null : new CompressedTile(cPtr, false);
    }
}
