package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheCompressor {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheCompressor(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheCompressor obj) {
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
                RecastJNI.delete_dtTileCacheCompressor(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public int maxCompressedSize(int bufferSize) {
        return RecastJNI.dtTileCacheCompressor_maxCompressedSize(swigCPtr, this, bufferSize);
    }

    public long compress(SWIGTYPE_p_unsigned_char buffer, int bufferSize, SWIGTYPE_p_unsigned_char compressed, int maxCompressedSize, SWIGTYPE_p_int compressedSize) {
        return RecastJNI.dtTileCacheCompressor_compress(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(buffer), bufferSize, SWIGTYPE_p_unsigned_char.getCPtr(compressed), maxCompressedSize, SWIGTYPE_p_int.getCPtr(compressedSize));
    }

    public long decompress(SWIGTYPE_p_unsigned_char compressed, int compressedSize, SWIGTYPE_p_unsigned_char buffer, int maxBufferSize, SWIGTYPE_p_int bufferSize) {
        return RecastJNI.dtTileCacheCompressor_decompress(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(compressed), compressedSize, SWIGTYPE_p_unsigned_char.getCPtr(buffer), maxBufferSize, SWIGTYPE_p_int.getCPtr(bufferSize));
    }
}
