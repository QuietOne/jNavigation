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
public class QueryFilter {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public QueryFilter() {
        this(RecastJNI.new_dtQueryFilter(), true);
    }

    public QueryFilter(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(QueryFilter obj) {
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
                RecastJNI.delete_dtQueryFilter(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public boolean passFilter(long ref, MeshTile tile, Poly poly) {
        return RecastJNI.dtQueryFilter_passFilter(swigCPtr, this, ref, MeshTile.getCPtr(tile), tile, Poly.getCPtr(poly), poly);
    }

    public float getCost(Vector3f startPosition, Vector3f endPosition, long prevRef, MeshTile prevTile, Poly prevPoly, long curRef, MeshTile curTile, Poly curPoly, long nextRef, MeshTile nextTile, Poly nextPoly) {
        SWIGTYPE_p_float pa = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float pb = Converter.convertToSWIGTYPE_p_float(endPosition);
        return RecastJNI.dtQueryFilter_getCost(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pa), SWIGTYPE_p_float.getCPtr(pb), prevRef, MeshTile.getCPtr(prevTile), prevTile, Poly.getCPtr(prevPoly), prevPoly, curRef, MeshTile.getCPtr(curTile), curTile, Poly.getCPtr(curPoly), curPoly, nextRef, MeshTile.getCPtr(nextTile), nextTile, Poly.getCPtr(nextPoly), nextPoly);
    }

    public float getAreaCost(int i) {
        return RecastJNI.dtQueryFilter_getAreaCost(swigCPtr, this, i);
    }

    public void setAreaCost(int i, float cost) {
        RecastJNI.dtQueryFilter_setAreaCost(swigCPtr, this, i, cost);
    }

    public int getIncludeFlags() {
        return RecastJNI.dtQueryFilter_getIncludeFlags(swigCPtr, this);
    }

    public void setIncludeFlags(int flags) {
        RecastJNI.dtQueryFilter_setIncludeFlags(swigCPtr, this, flags);
    }

    public int getExcludeFlags() {
        return RecastJNI.dtQueryFilter_getExcludeFlags(swigCPtr, this);
    }

    public void setExcludeFlags(int flags) {
        RecastJNI.dtQueryFilter_setExcludeFlags(swigCPtr, this, flags);
    }
}
