package com.jme3.ai.navigation.crowd;


import com.jme3.ai.navigation.detour.dtPathCorridor;
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


public class dtCrowdAgent {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public dtCrowdAgent(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(dtCrowdAgent obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        RecastJNI.delete_dtCrowdAgent(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setActive(boolean value) {
    RecastJNI.dtCrowdAgent_active_set(swigCPtr, this, value);
  }

  public boolean getActive() {
    return RecastJNI.dtCrowdAgent_active_get(swigCPtr, this);
  }

  public void setState(short value) {
    RecastJNI.dtCrowdAgent_state_set(swigCPtr, this, value);
  }

  public short getState() {
    return RecastJNI.dtCrowdAgent_state_get(swigCPtr, this);
  }

  public void setPartial(boolean value) {
    RecastJNI.dtCrowdAgent_partial_set(swigCPtr, this, value);
  }

  public boolean getPartial() {
    return RecastJNI.dtCrowdAgent_partial_get(swigCPtr, this);
  }

  public void setCorridor(dtPathCorridor value) {
    RecastJNI.dtCrowdAgent_corridor_set(swigCPtr, this, dtPathCorridor.getCPtr(value), value);
  }

  public dtPathCorridor getCorridor() {
    long cPtr = RecastJNI.dtCrowdAgent_corridor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dtPathCorridor(cPtr, false);
  }

  public void setBoundary(dtLocalBoundary value) {
    RecastJNI.dtCrowdAgent_boundary_set(swigCPtr, this, dtLocalBoundary.getCPtr(value), value);
  }

  public dtLocalBoundary getBoundary() {
    long cPtr = RecastJNI.dtCrowdAgent_boundary_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dtLocalBoundary(cPtr, false);
  }

  public void setTopologyOptTime(float value) {
    RecastJNI.dtCrowdAgent_topologyOptTime_set(swigCPtr, this, value);
  }

  public float getTopologyOptTime() {
    return RecastJNI.dtCrowdAgent_topologyOptTime_get(swigCPtr, this);
  }

  public void setNeis(dtCrowdNeighbour value) {
    RecastJNI.dtCrowdAgent_neis_set(swigCPtr, this, dtCrowdNeighbour.getCPtr(value), value);
  }

  public dtCrowdNeighbour getNeis() {
    long cPtr = RecastJNI.dtCrowdAgent_neis_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dtCrowdNeighbour(cPtr, false);
  }

  public void setNneis(int value) {
    RecastJNI.dtCrowdAgent_nneis_set(swigCPtr, this, value);
  }

  public int getNneis() {
    return RecastJNI.dtCrowdAgent_nneis_get(swigCPtr, this);
  }

  public void setDesiredSpeed(float value) {
    RecastJNI.dtCrowdAgent_desiredSpeed_set(swigCPtr, this, value);
  }

  public float getDesiredSpeed() {
    return RecastJNI.dtCrowdAgent_desiredSpeed_get(swigCPtr, this);
  }

  public void setNpos(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_npos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getNpos() {
    long cPtr = RecastJNI.dtCrowdAgent_npos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setDisp(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_disp_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getDisp() {
    long cPtr = RecastJNI.dtCrowdAgent_disp_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setDvel(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_dvel_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getDvel() {
    long cPtr = RecastJNI.dtCrowdAgent_dvel_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setNvel(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_nvel_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getNvel() {
    long cPtr = RecastJNI.dtCrowdAgent_nvel_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setVel(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_vel_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getVel() {
    long cPtr = RecastJNI.dtCrowdAgent_vel_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setParams(dtCrowdAgentParams value) {
    RecastJNI.dtCrowdAgent_params_set(swigCPtr, this, dtCrowdAgentParams.getCPtr(value), value);
  }

  public dtCrowdAgentParams getParams() {
    long cPtr = RecastJNI.dtCrowdAgent_params_get(swigCPtr, this);
    return (cPtr == 0) ? null : new dtCrowdAgentParams(cPtr, false);
  }

  public void setCornerVerts(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_cornerVerts_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getCornerVerts() {
    long cPtr = RecastJNI.dtCrowdAgent_cornerVerts_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setCornerFlags(SWIGTYPE_p_unsigned_char value) {
    RecastJNI.dtCrowdAgent_cornerFlags_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getCornerFlags() {
    long cPtr = RecastJNI.dtCrowdAgent_cornerFlags_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setCornerPolys(SWIGTYPE_p_unsigned_int value) {
    RecastJNI.dtCrowdAgent_cornerPolys_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_int getCornerPolys() {
    long cPtr = RecastJNI.dtCrowdAgent_cornerPolys_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public void setNcorners(int value) {
    RecastJNI.dtCrowdAgent_ncorners_set(swigCPtr, this, value);
  }

  public int getNcorners() {
    return RecastJNI.dtCrowdAgent_ncorners_get(swigCPtr, this);
  }

  public void setTargetState(short value) {
    RecastJNI.dtCrowdAgent_targetState_set(swigCPtr, this, value);
  }

  public short getTargetState() {
    return RecastJNI.dtCrowdAgent_targetState_get(swigCPtr, this);
  }

  public void setTargetRef(long value) {
    RecastJNI.dtCrowdAgent_targetRef_set(swigCPtr, this, value);
  }

  public long getTargetRef() {
    return RecastJNI.dtCrowdAgent_targetRef_get(swigCPtr, this);
  }

  public void setTargetPos(SWIGTYPE_p_float value) {
    RecastJNI.dtCrowdAgent_targetPos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getTargetPos() {
    long cPtr = RecastJNI.dtCrowdAgent_targetPos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public void setTargetPathqRef(long value) {
    RecastJNI.dtCrowdAgent_targetPathqRef_set(swigCPtr, this, value);
  }

  public long getTargetPathqRef() {
    return RecastJNI.dtCrowdAgent_targetPathqRef_get(swigCPtr, this);
  }

  public void setTargetReplan(boolean value) {
    RecastJNI.dtCrowdAgent_targetReplan_set(swigCPtr, this, value);
  }

  public boolean getTargetReplan() {
    return RecastJNI.dtCrowdAgent_targetReplan_get(swigCPtr, this);
  }

  public void setTargetReplanTime(float value) {
    RecastJNI.dtCrowdAgent_targetReplanTime_set(swigCPtr, this, value);
  }

  public float getTargetReplanTime() {
    return RecastJNI.dtCrowdAgent_targetReplanTime_get(swigCPtr, this);
  }

  public dtCrowdAgent() {
    this(RecastJNI.new_dtCrowdAgent(), true);
  }

}
