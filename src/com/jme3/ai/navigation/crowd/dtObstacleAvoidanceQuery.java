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
public class dtObstacleAvoidanceQuery {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public dtObstacleAvoidanceQuery() {
        swigCPtr = RecastJNI.dtAllocObstacleAvoidanceQuery();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public dtObstacleAvoidanceQuery(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(dtObstacleAvoidanceQuery obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.dtFreeObstacleAvoidanceQuery(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public boolean init(int maxCircles, int maxSegments) {
        return RecastJNI.dtObstacleAvoidanceQuery_init(swigCPtr, this, maxCircles, maxSegments);
    }

    public void reset() {
        RecastJNI.dtObstacleAvoidanceQuery_reset(swigCPtr, this);
    }

    public void addCircle(SWIGTYPE_p_float pos, float rad, SWIGTYPE_p_float vel, SWIGTYPE_p_float dvel) {
        RecastJNI.dtObstacleAvoidanceQuery_addCircle(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), rad, SWIGTYPE_p_float.getCPtr(vel), SWIGTYPE_p_float.getCPtr(dvel));
    }

    public void addSegment(SWIGTYPE_p_float p, SWIGTYPE_p_float q) {
        RecastJNI.dtObstacleAvoidanceQuery_addSegment(swigCPtr, this, SWIGTYPE_p_float.getCPtr(p), SWIGTYPE_p_float.getCPtr(q));
    }

    public int sampleVelocityGrid(SWIGTYPE_p_float pos, float rad, float vmax, SWIGTYPE_p_float vel, SWIGTYPE_p_float dvel, SWIGTYPE_p_float nvel, dtObstacleAvoidanceParams params, dtObstacleAvoidanceDebugData debug) {
        return RecastJNI.dtObstacleAvoidanceQuery_sampleVelocityGrid__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), rad, vmax, SWIGTYPE_p_float.getCPtr(vel), SWIGTYPE_p_float.getCPtr(dvel), SWIGTYPE_p_float.getCPtr(nvel), dtObstacleAvoidanceParams.getCPtr(params), params, dtObstacleAvoidanceDebugData.getCPtr(debug), debug);
    }

    public int sampleVelocityGrid(SWIGTYPE_p_float pos, float rad, float vmax, SWIGTYPE_p_float vel, SWIGTYPE_p_float dvel, SWIGTYPE_p_float nvel, dtObstacleAvoidanceParams params) {
        return RecastJNI.dtObstacleAvoidanceQuery_sampleVelocityGrid__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), rad, vmax, SWIGTYPE_p_float.getCPtr(vel), SWIGTYPE_p_float.getCPtr(dvel), SWIGTYPE_p_float.getCPtr(nvel), dtObstacleAvoidanceParams.getCPtr(params), params);
    }

    public int sampleVelocityAdaptive(SWIGTYPE_p_float pos, float rad, float vmax, SWIGTYPE_p_float vel, SWIGTYPE_p_float dvel, SWIGTYPE_p_float nvel, dtObstacleAvoidanceParams params, dtObstacleAvoidanceDebugData debug) {
        return RecastJNI.dtObstacleAvoidanceQuery_sampleVelocityAdaptive__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), rad, vmax, SWIGTYPE_p_float.getCPtr(vel), SWIGTYPE_p_float.getCPtr(dvel), SWIGTYPE_p_float.getCPtr(nvel), dtObstacleAvoidanceParams.getCPtr(params), params, dtObstacleAvoidanceDebugData.getCPtr(debug), debug);
    }

    public int sampleVelocityAdaptive(SWIGTYPE_p_float pos, float rad, float vmax, SWIGTYPE_p_float vel, SWIGTYPE_p_float dvel, SWIGTYPE_p_float nvel, dtObstacleAvoidanceParams params) {
        return RecastJNI.dtObstacleAvoidanceQuery_sampleVelocityAdaptive__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(pos), rad, vmax, SWIGTYPE_p_float.getCPtr(vel), SWIGTYPE_p_float.getCPtr(dvel), SWIGTYPE_p_float.getCPtr(nvel), dtObstacleAvoidanceParams.getCPtr(params), params);
    }

    public int getObstacleCircleCount() {
        return RecastJNI.dtObstacleAvoidanceQuery_getObstacleCircleCount(swigCPtr, this);
    }

    public dtObstacleCircle getObstacleCircle(int i) {
        long cPtr = RecastJNI.dtObstacleAvoidanceQuery_getObstacleCircle(swigCPtr, this, i);
        return (cPtr == 0) ? null : new dtObstacleCircle(cPtr, false);
    }

    public int getObstacleSegmentCount() {
        return RecastJNI.dtObstacleAvoidanceQuery_getObstacleSegmentCount(swigCPtr, this);
    }

    public dtObstacleSegment getObstacleSegment(int i) {
        long cPtr = RecastJNI.dtObstacleAvoidanceQuery_getObstacleSegment(swigCPtr, this, i);
        return (cPtr == 0) ? null : new dtObstacleSegment(cPtr, false);
    }
}
