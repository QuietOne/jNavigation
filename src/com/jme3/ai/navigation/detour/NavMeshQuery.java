package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_bool;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_f___float;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class NavMeshQuery {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NavMeshQuery() {
        swigCPtr = RecastJNI.dtAllocNavMeshQuery();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public NavMeshQuery(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NavMeshQuery obj) {
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
                RecastJNI.dtFreeNavMeshQuery(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public long init(NavMesh nav, int maxNodes) {
        return RecastJNI.dtNavMeshQuery_init(swigCPtr, this, NavMesh.getCPtr(nav), nav, maxNodes);
    }

    public long findPath(long startRef, long endRef, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, QueryFilter filter, SWIGTYPE_p_unsigned_int path, SWIGTYPE_p_int pathCount, int maxPath) {
        return RecastJNI.dtNavMeshQuery_findPath(swigCPtr, this, startRef, endRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
    }

    public long findStraightPath(SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, SWIGTYPE_p_unsigned_int path, int pathSize, SWIGTYPE_p_float straightPath, SWIGTYPE_p_unsigned_char straightPathFlags, SWIGTYPE_p_unsigned_int straightPathRefs, SWIGTYPE_p_int straightPathCount, int maxStraightPath, int options) {
        return RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(path), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath, options);
    }

    public long findStraightPath(SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, SWIGTYPE_p_unsigned_int path, int pathSize, SWIGTYPE_p_float straightPath, SWIGTYPE_p_unsigned_char straightPathFlags, SWIGTYPE_p_unsigned_int straightPathRefs, SWIGTYPE_p_int straightPathCount, int maxStraightPath) {
        return RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(path), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath);
    }

    public long initSlicedFindPath(long startRef, long endRef, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, QueryFilter filter) {
        return RecastJNI.dtNavMeshQuery_initSlicedFindPath(swigCPtr, this, startRef, endRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter);
    }

    public long updateSlicedFindPath(int maxIter, SWIGTYPE_p_int doneIters) {
        return RecastJNI.dtNavMeshQuery_updateSlicedFindPath(swigCPtr, this, maxIter, SWIGTYPE_p_int.getCPtr(doneIters));
    }
    /*
     //NOT IMPLEMENTED YET JNI
     public long finalizeSlicedFindPath(SWIGTYPE_p_unsigned_int path, SWIGTYPE_p_int pathCount, int maxPath) {
     return RecastJNI.dtNavMeshQuery_finalizeSlicedFindPath(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
     }

     public long finalizeSlicedFindPathPartial(SWIGTYPE_p_unsigned_int existing, int existingSize, SWIGTYPE_p_unsigned_int path, SWIGTYPE_p_int pathCount, int maxPath) {
     return RecastJNI.dtNavMeshQuery_finalizeSlicedFindPathPartial(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(existing), existingSize, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
     }*/

    public long findPolysAroundCircle(long startRef, SWIGTYPE_p_float centerPos, float radius, QueryFilter filter, SWIGTYPE_p_unsigned_int resultRef, SWIGTYPE_p_unsigned_int resultParent, SWIGTYPE_p_float resultCost, SWIGTYPE_p_int resultCount, int maxResult) {
        return RecastJNI.dtNavMeshQuery_findPolysAroundCircle(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
    }

    public long findPolysAroundShape(long startRef, SWIGTYPE_p_float verts, int nverts, QueryFilter filter, SWIGTYPE_p_unsigned_int resultRef, SWIGTYPE_p_unsigned_int resultParent, SWIGTYPE_p_float resultCost, SWIGTYPE_p_int resultCount, int maxResult) {
        return RecastJNI.dtNavMeshQuery_findPolysAroundShape(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(verts), nverts, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
    }

    public long findNearestPoly(SWIGTYPE_p_float center, SWIGTYPE_p_float extents, QueryFilter filter, SWIGTYPE_p_unsigned_int nearestRef, SWIGTYPE_p_float nearestPt) {
        return RecastJNI.dtNavMeshQuery_findNearestPoly(swigCPtr, this, SWIGTYPE_p_float.getCPtr(center), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(nearestRef), SWIGTYPE_p_float.getCPtr(nearestPt));
    }

    public long queryPolygons(SWIGTYPE_p_float center, SWIGTYPE_p_float extents, QueryFilter filter, SWIGTYPE_p_unsigned_int polys, SWIGTYPE_p_int polyCount, int maxPolys) {
        return RecastJNI.dtNavMeshQuery_queryPolygons(swigCPtr, this, SWIGTYPE_p_float.getCPtr(center), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(polys), SWIGTYPE_p_int.getCPtr(polyCount), maxPolys);
    }

    public long findLocalNeighbourhood(long startRef, SWIGTYPE_p_float centerPos, float radius, QueryFilter filter, SWIGTYPE_p_unsigned_int resultRef, SWIGTYPE_p_unsigned_int resultParent, SWIGTYPE_p_int resultCount, int maxResult) {
        return RecastJNI.dtNavMeshQuery_findLocalNeighbourhood(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
    }

    public long moveAlongSurface(long startRef, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, QueryFilter filter, SWIGTYPE_p_float resultPos, SWIGTYPE_p_unsigned_int visited, SWIGTYPE_p_int visitedCount, int maxVisitedSize) {
        return RecastJNI.dtNavMeshQuery_moveAlongSurface(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(resultPos), SWIGTYPE_p_unsigned_int.getCPtr(visited), SWIGTYPE_p_int.getCPtr(visitedCount), maxVisitedSize);
    }

    public long raycast(long startRef, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, QueryFilter filter, SWIGTYPE_p_float t, SWIGTYPE_p_float hitNormal, SWIGTYPE_p_unsigned_int path, SWIGTYPE_p_int pathCount, int maxPath) {
        return RecastJNI.dtNavMeshQuery_raycast(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(t), SWIGTYPE_p_float.getCPtr(hitNormal), SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
    }

    public long findDistanceToWall(long startRef, SWIGTYPE_p_float centerPos, float maxRadius, QueryFilter filter, SWIGTYPE_p_float hitDist, SWIGTYPE_p_float hitPos, SWIGTYPE_p_float hitNormal) {
        return RecastJNI.dtNavMeshQuery_findDistanceToWall(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(hitDist), SWIGTYPE_p_float.getCPtr(hitPos), SWIGTYPE_p_float.getCPtr(hitNormal));
    }

    public long getPolyWallSegments(long ref, QueryFilter filter, SWIGTYPE_p_float segmentVerts, SWIGTYPE_p_unsigned_int segmentRefs, SWIGTYPE_p_int segmentCount, int maxSegments) {
        return RecastJNI.dtNavMeshQuery_getPolyWallSegments(swigCPtr, this, ref, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(segmentVerts), SWIGTYPE_p_unsigned_int.getCPtr(segmentRefs), SWIGTYPE_p_int.getCPtr(segmentCount), maxSegments);
    }

    public long findRandomPoint(QueryFilter filter, SWIGTYPE_p_f___float frand, SWIGTYPE_p_unsigned_int randomRef, SWIGTYPE_p_float randomPt) {
        return RecastJNI.dtNavMeshQuery_findRandomPoint(swigCPtr, this, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_f___float.getCPtr(frand), SWIGTYPE_p_unsigned_int.getCPtr(randomRef), SWIGTYPE_p_float.getCPtr(randomPt));
    }

    public long findRandomPointAroundCircle(long startRef, SWIGTYPE_p_float centerPos, float maxRadius, QueryFilter filter, SWIGTYPE_p_f___float frand, SWIGTYPE_p_unsigned_int randomRef, SWIGTYPE_p_float randomPt) {
        return RecastJNI.dtNavMeshQuery_findRandomPointAroundCircle(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_f___float.getCPtr(frand), SWIGTYPE_p_unsigned_int.getCPtr(randomRef), SWIGTYPE_p_float.getCPtr(randomPt));
    }

    public Status closestPointOnPoly(Poly poly, Vector3f position, SWIGTYPE_p_float closest, SWIGTYPE_p_bool posOverPoly) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        long status = RecastJNI.dtNavMeshQuery_closestPointOnPoly(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(closest), SWIGTYPE_p_bool.getCPtr(posOverPoly));
        return new Status(status);
    }

    public Status closestPointOnPolyBoundary(long ref, SWIGTYPE_p_float pos, SWIGTYPE_p_float closest) {
        long status = RecastJNI.dtNavMeshQuery_closestPointOnPolyBoundary(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(closest));
        return new Status(status);
    }

    public long getPolyHeight(long ref, SWIGTYPE_p_float pos, SWIGTYPE_p_float height) {
        return RecastJNI.dtNavMeshQuery_getPolyHeight(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(height));
    }

    public boolean isValidPolyRef(long ref, QueryFilter filter) {
        return RecastJNI.dtNavMeshQuery_isValidPolyRef(swigCPtr, this, ref, QueryFilter.getCPtr(filter), filter);
    }

    public boolean isInClosedList(long ref) {
        return RecastJNI.dtNavMeshQuery_isInClosedList(swigCPtr, this, ref);
    }

    public NodePool getNodePool() {
        long cPtr = RecastJNI.dtNavMeshQuery_getNodePool(swigCPtr, this);
        return (cPtr == 0) ? null : new NodePool(cPtr, false);
    }

    public NavMesh getAttachedNavMesh() {
        long cPtr = RecastJNI.dtNavMeshQuery_getAttachedNavMesh(swigCPtr, this);
        return (cPtr == 0) ? null : new NavMesh(cPtr, false);
    }
}
