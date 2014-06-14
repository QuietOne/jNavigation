package com.jme3.ai.navigation.crowd;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public final class CrowdAgentState {
  public final static CrowdAgentState DT_CROWDAGENT_STATE_INVALID = new CrowdAgentState("DT_CROWDAGENT_STATE_INVALID");
  public final static CrowdAgentState DT_CROWDAGENT_STATE_WALKING = new CrowdAgentState("DT_CROWDAGENT_STATE_WALKING");
  public final static CrowdAgentState DT_CROWDAGENT_STATE_OFFMESH = new CrowdAgentState("DT_CROWDAGENT_STATE_OFFMESH");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static CrowdAgentState swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + CrowdAgentState.class + " with value " + swigValue);
  }

  private CrowdAgentState(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private CrowdAgentState(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private CrowdAgentState(String swigName, CrowdAgentState swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static CrowdAgentState[] swigValues = { DT_CROWDAGENT_STATE_INVALID, DT_CROWDAGENT_STATE_WALKING, DT_CROWDAGENT_STATE_OFFMESH };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

