package com.jme3.ai.navigation.crowd;


import com.jme3.ai.navigation.utils.RecastJNI;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public final class MoveRequestState {
  public final static MoveRequestState DT_CROWDAGENT_TARGET_NONE = new MoveRequestState("DT_CROWDAGENT_TARGET_NONE", RecastJNI.DT_CROWDAGENT_TARGET_NONE_get());
  public final static MoveRequestState DT_CROWDAGENT_TARGET_FAILED = new MoveRequestState("DT_CROWDAGENT_TARGET_FAILED");
  public final static MoveRequestState DT_CROWDAGENT_TARGET_VALID = new MoveRequestState("DT_CROWDAGENT_TARGET_VALID");
  public final static MoveRequestState DT_CROWDAGENT_TARGET_REQUESTING = new MoveRequestState("DT_CROWDAGENT_TARGET_REQUESTING");
  public final static MoveRequestState DT_CROWDAGENT_TARGET_WAITING_FOR_QUEUE = new MoveRequestState("DT_CROWDAGENT_TARGET_WAITING_FOR_QUEUE");
  public final static MoveRequestState DT_CROWDAGENT_TARGET_WAITING_FOR_PATH = new MoveRequestState("DT_CROWDAGENT_TARGET_WAITING_FOR_PATH");
  public final static MoveRequestState DT_CROWDAGENT_TARGET_VELOCITY = new MoveRequestState("DT_CROWDAGENT_TARGET_VELOCITY");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static MoveRequestState swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + MoveRequestState.class + " with value " + swigValue);
  }

  private MoveRequestState(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private MoveRequestState(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private MoveRequestState(String swigName, MoveRequestState swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static MoveRequestState[] swigValues = { DT_CROWDAGENT_TARGET_NONE, DT_CROWDAGENT_TARGET_FAILED, DT_CROWDAGENT_TARGET_VALID, DT_CROWDAGENT_TARGET_REQUESTING, DT_CROWDAGENT_TARGET_WAITING_FOR_QUEUE, DT_CROWDAGENT_TARGET_WAITING_FOR_PATH, DT_CROWDAGENT_TARGET_VELOCITY };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

