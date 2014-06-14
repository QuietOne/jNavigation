package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljavic
 * @version 1.0
 */
public class Context {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Context() {
        this(RecastJNI.new_rcContext__SWIG_1(), true);
    }

    public Context(boolean state) {
        this(RecastJNI.new_rcContext__SWIG_0(state), true);
    }

    public Context(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Context obj) {
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
                RecastJNI.delete_rcContext(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void enableLog(boolean state) {
        RecastJNI.rcContext_enableLog(swigCPtr, this, state);
    }

    public void resetLog() {
        RecastJNI.rcContext_resetLog(swigCPtr, this);
    }

    public void log(LogCategory category, String format) {
        RecastJNI.rcContext_log(swigCPtr, this, category.swigValue(), format);
    }

    public void enableTimer(boolean state) {
        RecastJNI.rcContext_enableTimer(swigCPtr, this, state);
    }

    public void resetTimers() {
        RecastJNI.rcContext_resetTimers(swigCPtr, this);
    }

    public void startTimer(TimerLabel label) {
        RecastJNI.rcContext_startTimer(swigCPtr, this, label.swigValue());
    }

    public void stopTimer(TimerLabel label) {
        RecastJNI.rcContext_stopTimer(swigCPtr, this, label.swigValue());
    }

    public int getAccumulatedTime(TimerLabel label) {
        return RecastJNI.rcContext_getAccumulatedTime(swigCPtr, this, label.swigValue());
    }
}
