package com.jme3.ai.navigation.crowd;


import com.jme3.ai.navigation.detour.QueryFilter;
import com.jme3.ai.navigation.detour.NavMeshQuery;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class dtPathCorridor {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public dtPathCorridor(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(dtPathCorridor obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RecastJNI.delete_dtPathCorridor(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public dtPathCorridor() {
    this(RecastJNI.new_dtPathCorridor(), true);
  }

  public boolean init(int maxPath) {
    return RecastJNI.dtPathCorridor_init(swigCPtr, this, maxPath);
  }

  public void reset(long ref, SWIGTYPE_p_float pos) {
    RecastJNI.dtPathCorridor_reset(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos));
  }

  public int findCorners(SWIGTYPE_p_float cornerVerts, SWIGTYPE_p_unsigned_char cornerFlags, SWIGTYPE_p_unsigned_int cornerPolys, int maxCorners, NavMeshQuery navquery, QueryFilter filter) {
    return RecastJNI.dtPathCorridor_findCorners(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cornerVerts), SWIGTYPE_p_unsigned_char.getCPtr(cornerFlags), SWIGTYPE_p_unsigned_int.getCPtr(cornerPolys), maxCorners, NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public void optimizePathVisibility(SWIGTYPE_p_float next, float pathOptimizationRange, NavMeshQuery navquery, QueryFilter filter) {
    RecastJNI.dtPathCorridor_optimizePathVisibility(swigCPtr, this, SWIGTYPE_p_float.getCPtr(next), pathOptimizationRange, NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public boolean optimizePathTopology(NavMeshQuery navquery, QueryFilter filter) {
    return RecastJNI.dtPathCorridor_optimizePathTopology(swigCPtr, this, NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public boolean moveOverOffmeshConnection(long offMeshConRef, SWIGTYPE_p_unsigned_int refs, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, NavMeshQuery navquery) {
    return RecastJNI.dtPathCorridor_moveOverOffmeshConnection(swigCPtr, this, offMeshConRef, SWIGTYPE_p_unsigned_int.getCPtr(refs), SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), NavMeshQuery.getCPtr(navquery), navquery);
  }

  public boolean fixPathStart(long safeRef, SWIGTYPE_p_float safePos) {
    return RecastJNI.dtPathCorridor_fixPathStart(swigCPtr, this, safeRef, SWIGTYPE_p_float.getCPtr(safePos));
  }

  public boolean trimInvalidPath(long safeRef, SWIGTYPE_p_float safePos, NavMeshQuery navquery, QueryFilter filter) {
    return RecastJNI.dtPathCorridor_trimInvalidPath(swigCPtr, this, safeRef, SWIGTYPE_p_float.getCPtr(safePos), NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public boolean isValid(int maxLookAhead, NavMeshQuery navquery, QueryFilter filter) {
    return RecastJNI.dtPathCorridor_isValid(swigCPtr, this, maxLookAhead, NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public boolean movePosition(SWIGTYPE_p_float npos, NavMeshQuery navquery, QueryFilter filter) {
    return RecastJNI.dtPathCorridor_movePosition(swigCPtr, this, SWIGTYPE_p_float.getCPtr(npos), NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public boolean moveTargetPosition(SWIGTYPE_p_float npos, NavMeshQuery navquery, QueryFilter filter) {
    return RecastJNI.dtPathCorridor_moveTargetPosition(swigCPtr, this, SWIGTYPE_p_float.getCPtr(npos), NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
  }

  public void setCorridor(SWIGTYPE_p_float target, SWIGTYPE_p_unsigned_int polys, int npath) {
    RecastJNI.dtPathCorridor_setCorridor(swigCPtr, this, SWIGTYPE_p_float.getCPtr(target), SWIGTYPE_p_unsigned_int.getCPtr(polys), npath);
  }

  public SWIGTYPE_p_float getPos() {
    long cPtr = RecastJNI.dtPathCorridor_getPos(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public SWIGTYPE_p_float getTarget() {
    long cPtr = RecastJNI.dtPathCorridor_getTarget(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public long getFirstPoly() {
    return RecastJNI.dtPathCorridor_getFirstPoly(swigCPtr, this);
  }

  public long getLastPoly() {
    return RecastJNI.dtPathCorridor_getLastPoly(swigCPtr, this);
  }

  public SWIGTYPE_p_unsigned_int getPath() {
    long cPtr = RecastJNI.dtPathCorridor_getPath(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public int getPathCount() {
    return RecastJNI.dtPathCorridor_getPathCount(swigCPtr, this);
  }

}
