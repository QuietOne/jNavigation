package com.jme3.ai.navigation.crowd;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public final class ObstacleState {
  public final static ObstacleState DT_OBSTACLE_EMPTY = new ObstacleState("DT_OBSTACLE_EMPTY");
  public final static ObstacleState DT_OBSTACLE_PROCESSING = new ObstacleState("DT_OBSTACLE_PROCESSING");
  public final static ObstacleState DT_OBSTACLE_PROCESSED = new ObstacleState("DT_OBSTACLE_PROCESSED");
  public final static ObstacleState DT_OBSTACLE_REMOVING = new ObstacleState("DT_OBSTACLE_REMOVING");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ObstacleState swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ObstacleState.class + " with value " + swigValue);
  }

  private ObstacleState(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ObstacleState(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ObstacleState(String swigName, ObstacleState swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ObstacleState[] swigValues = { DT_OBSTACLE_EMPTY, DT_OBSTACLE_PROCESSING, DT_OBSTACLE_PROCESSED, DT_OBSTACLE_REMOVING };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

