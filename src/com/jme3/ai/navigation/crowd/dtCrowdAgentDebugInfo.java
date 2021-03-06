package com.jme3.ai.navigation.crowd;


import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class dtCrowdAgentDebugInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public dtCrowdAgentDebugInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(dtCrowdAgentDebugInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RecastJNI.delete_dtCrowdAgentDebugInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setIdx(int value) {
    RecastJNI.dtCrowdAgentDebugInfo_idx_set(swigCPtr, this, value);
  }

  public int getIdx() {
    return RecastJNI.dtCrowdAgentDebugInfo_idx_get(swigCPtr, this);
  }

  public void setOptStart(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgentDebugInfo_optStart_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getOptStart() {
    long cPtr = RecastJNI.dtCrowdAgentDebugInfo_optStart_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setOptEnd(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgentDebugInfo_optEnd_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getOptEnd() {
    long cPtr = RecastJNI.dtCrowdAgentDebugInfo_optEnd_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setVod(dtObstacleAvoidanceDebugData value) {
    RecastJNI.dtCrowdAgentDebugInfo_vod_set(swigCPtr, this, dtObstacleAvoidanceDebugData.getCPtr(value), value);
  }

  public dtObstacleAvoidanceDebugData getVod() {
    long cPtr = RecastJNI.dtCrowdAgentDebugInfo_vod_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dtObstacleAvoidanceDebugData(cPtr, false);
  }

  public dtCrowdAgentDebugInfo() {
    this(RecastJNI.new_dtCrowdAgentDebugInfo(), true);
  }

}
