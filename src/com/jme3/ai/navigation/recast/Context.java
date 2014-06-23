package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Provides an interface for optional logging and performance tracking of the
 * Recast build process.
 *
 * This class does not provide logging or timer functionality on its own. Both
 * must be provided by a concrete implementation by overriding the protected
 * member functions. Also, this class does not provide an interface for
 * extracting log messages. (Only adding them.) So concrete implementations must
 * provide one.
 *
 * If no logging or timers are required, just pass an instance of this class
 * through the Recast build process.
 *
 * NOTE: For now Context is not implemented in Recast native library and does
 * not provide any functionality.
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

    /**
     * Contructor.
     *
     * @param state TRUE if the logging and performance timers should be
     * enabled. [Default: true]
     */
    public Context(boolean state) {
        this(RecastJNI.new_rcContext__SWIG_0(state), true);
    }

    protected Context(long cPtr, boolean cMemoryOwn) {
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
/**
 * Enables or disables logging.
 * @param state TRUE if logging should be enabled.

 */
    public void enableLog(boolean state) {
        RecastJNI.rcContext_enableLog(swigCPtr, this, state);
    }

    /**
     * Clears all log entries.
     */
    public void resetLog() {
        RecastJNI.rcContext_resetLog(swigCPtr, this);
    }

    /**
     * Logs a message.
     *
     * @param category The category of the message.
     * @param message The formatted message.
     */
    public void log(LogCategory category, String message) {
        RecastJNI.rcContext_log(swigCPtr, this, category.swigValue(), message);
    }
/**
 * Enables or disables the performance timers.
 * @param state TRUE if timers should be enabled.
 */
    public void enableTimer(boolean state) {
        RecastJNI.rcContext_enableTimer(swigCPtr, this, state);
    }

    /**
     * Clears all timers. (Resets all to unused.)
     */
    public void resetTimers() {
        RecastJNI.rcContext_resetTimers(swigCPtr, this);
    }

    /**
     * Starts the specified performance timer.
     *
     * @param label The category of timer.
     */
    public void startTimer(TimerLabel label) {
        RecastJNI.rcContext_startTimer(swigCPtr, this, label.swigValue());
    }

    /**
     * Stops the specified performance timer.
     *
     * @param label The category of the timer.
     */
    public void stopTimer(TimerLabel label) {
        RecastJNI.rcContext_stopTimer(swigCPtr, this, label.swigValue());
    }

    /**
     * Returns the total accumulated time of the specified performance timer.
     *
     * @param label The category of the timer.
     * @return The accumulated time of the timer, or -1 if timers are disabled
     * or the timer has never been started.
     */
    public int getAccumulatedTime(TimerLabel label) {
        return RecastJNI.rcContext_getAccumulatedTime(swigCPtr, this, label.swigValue());
    }
}
