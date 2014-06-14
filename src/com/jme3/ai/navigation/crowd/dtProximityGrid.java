package com.jme3.ai.navigation.crowd;


import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class dtProximityGrid {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public dtProximityGrid(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(dtProximityGrid obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RecastJNI.delete_dtProximityGrid(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public dtProximityGrid() {
    this(RecastJNI.new_dtProximityGrid(), true);
  }

  public boolean init(int maxItems, float cellSize) {
    return RecastJNI.dtProximityGrid_init(swigCPtr, this, maxItems, cellSize);
  }

  public void clear() {
    RecastJNI.dtProximityGrid_clear(swigCPtr, this);
  }

  public void addItem(int id, float minx, float miny, float maxx, float maxy) {
    RecastJNI.dtProximityGrid_addItem(swigCPtr, this, id, minx, miny, maxx, maxy);
  }

  public int queryItems(float minx, float miny, float maxx, float maxy, SWIGTYPE_p_unsigned_short ids, int maxIds) {
    return RecastJNI.dtProximityGrid_queryItems(swigCPtr, this, minx, miny, maxx, maxy, SWIGTYPE_p_unsigned_short.getCPtr(ids), maxIds);
  }

  public int getItemCountAt(int x, int y) {
    return RecastJNI.dtProximityGrid_getItemCountAt(swigCPtr, this, x, y);
  }

  public SWIGTYPE_p_int getBounds() {
    long cPtr = RecastJNI.dtProximityGrid_getBounds(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public float getCellSize() {
    return RecastJNI.dtProximityGrid_getCellSize(swigCPtr, this);
  }

}
