package com.jme3.ai.recast.utils;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class UShortArray {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public UShortArray(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(UShortArray obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RecastJNI.delete_UShortArray(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public UShortArray(int nelements) {
    this(RecastJNI.new_UShortArray(nelements), true);
  }

  public int getItem(int index) {
    return RecastJNI.UShortArray_getitem(swigCPtr, this, index);
  }

  public void setitem(int index, int value) {
    RecastJNI.UShortArray_setitem(swigCPtr, this, index, value);
  }

  public SWIGTYPE_p_unsigned_short cast() {
    long cPtr = RecastJNI.UShortArray_cast(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_short(cPtr, false);
  }

  public static UShortArray frompointer(SWIGTYPE_p_unsigned_short t) {
    long cPtr = RecastJNI.UShortArray_frompointer(SWIGTYPE_p_unsigned_short.getCPtr(t));
    return (cPtr == 0) ? null : new UShortArray(cPtr, false);
  }

}
