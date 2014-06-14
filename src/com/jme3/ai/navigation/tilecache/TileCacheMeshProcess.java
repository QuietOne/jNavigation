package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.detour.NavMeshCreateParams;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class TileCacheMeshProcess {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public TileCacheMeshProcess(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(TileCacheMeshProcess obj) {
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
                RecastJNI.delete_dtTileCacheMeshProcess(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     * WARNING: virtual
     *
     * @param params
     * @param polyAreas
     * @param polyFlags
     */
    public void process(NavMeshCreateParams params, SWIGTYPE_p_unsigned_char polyAreas, SWIGTYPE_p_unsigned_short polyFlags) {
        RecastJNI.dtTileCacheMeshProcess_process(swigCPtr, this, NavMeshCreateParams.getCPtr(params), params, SWIGTYPE_p_unsigned_char.getCPtr(polyAreas), SWIGTYPE_p_unsigned_short.getCPtr(polyFlags));
    }
}
