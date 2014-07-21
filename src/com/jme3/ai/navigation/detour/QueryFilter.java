package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * Defines polygon filtering and traversal costs for navigation mesh query
 * operations.
 *
 * The Default Implementation
 *
 * At construction: All area costs default to 1.0. All flags are included and
 * none are excluded.
 *
 * If a polygon has both an include and an exclude flag, it will be excluded.
 *
 * The way filtering works, a navigation mesh polygon must have at least one
 * flag set to ever be considered by a query. So a polygon with no flags will
 * never be considered.
 *
 * Setting the include flags to 0 will result in all polygons being excluded.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
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

    /**
     * Returns true if the polygon can be visited. (I.e. Is traversable.)
     *
     * @param ref The reference id of the polygon test.
     * @param tile The tile containing the polygon.
     * @param poly The polygon to test.
     * @return
     */
    public boolean passFilter(long ref, MeshTile tile, Poly poly) {
        return RecastJNI.dtQueryFilter_passFilter(swigCPtr, this, ref, MeshTile.getCPtr(tile), tile, Poly.getCPtr(poly), poly);
    }

    /**
     *
     * @param startPosition The start position on the edge of the previous and
     * current polygon.
     * @param endPosition The end position on the edge of the current and next
     * polygon.
     * @param prevRef The reference id of the previous polygon. [opt]
     * @param prevTile The tile containing the previous polygon. [opt]
     * @param prevPoly The previous polygon. [opt]
     * @param curRef The reference id of the current polygon.
     * @param curTile The tile containing the current polygon.
     * @param curPoly The current polygon.
     * @param nextRef The refernece id of the next polygon. [opt]
     * @param nextTile The tile containing the next polygon. [opt]
     * @param nextPoly The next polygon. [opt]
     * @return
     */
    public float getCost(Vector3f startPosition, Vector3f endPosition, long prevRef, MeshTile prevTile, Poly prevPoly, long curRef, MeshTile curTile, Poly curPoly, long nextRef, MeshTile nextTile, Poly nextPoly) {
        SWIGTYPE_p_float pa = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float pb = Converter.convertToSWIGTYPE_p_float(endPosition);
        return RecastJNI.dtQueryFilter_getCost(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pa), SWIGTYPE_p_float.getCPtr(pb), prevRef, MeshTile.getCPtr(prevTile), prevTile, Poly.getCPtr(prevPoly), prevPoly, curRef, MeshTile.getCPtr(curTile), curTile, Poly.getCPtr(curPoly), curPoly, nextRef, MeshTile.getCPtr(nextTile), nextTile, Poly.getCPtr(nextPoly), nextPoly);
    }

    /**
     * Returns the traversal cost of the area.
     *
     * @param i The id of the area.
     * @return The traversal cost of the area.
     */
    public float getAreaCost(int i) {
        return RecastJNI.dtQueryFilter_getAreaCost(swigCPtr, this, i);
    }

    /**
     * Sets the traversal cost of the area.
     *
     * @param i The id of the area.
     * @param cost The new cost of traversing the area.
     */
    public void setAreaCost(int i, float cost) {
        RecastJNI.dtQueryFilter_setAreaCost(swigCPtr, this, i, cost);
    }

    /**
     * Any polygons that include one or more of these flags will be included in
     * the operation.
     *
     * @return Returns the include flags for the filter.
     */
    public int getIncludeFlags() {
        return RecastJNI.dtQueryFilter_getIncludeFlags(swigCPtr, this);
    }

    /**
     * Sets the include flags for the filter.
     *
     * @param flags The new flags.
     */
    public void setIncludeFlags(int flags) {
        RecastJNI.dtQueryFilter_setIncludeFlags(swigCPtr, this, flags);
    }

    /**
     * Any polygons that include one ore more of these flags will be excluded
     * from the operation.
     *
     * @return Returns the exclude flags for the filter.
     */
    public int getExcludeFlags() {
        return RecastJNI.dtQueryFilter_getExcludeFlags(swigCPtr, this);
    }

    /**
     * Sets the exclude flags for the filter.
     *
     * @param flags The new flags.
     */
    public void setExcludeFlags(int flags) {
        RecastJNI.dtQueryFilter_setExcludeFlags(swigCPtr, this, flags);
    }
}
