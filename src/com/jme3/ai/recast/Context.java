package com.jme3.ai.recast;

import com.jme3.ai.recast.util.LogCategory;
import com.jme3.ai.recast.util.TimerLabel;

/**
 * Provides an interface for optional logging and performance tracking of the
 * Recast build process. This class does not provide logging or timer
 * functionality on its own. Both must be provided by a concrete implementation
 * by overriding the protected member functions. Also, this class does not
 * provide an interface for extracting log messages. (Only adding them.) So
 * concrete implementations must provide one. If no logging or timers are
 * required, just pass an instance of this class through the Recast build
 * process.
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public abstract class Context {

    /**
     * True if logging is enabled.
     */
    protected boolean m_logEnabled;
    /**
     * True if the performance timers are enabled.
     */
    protected boolean m_timerEnabled;

    //WARNING: destructor is virtual
    /**
     * WARNING: virtual Returns the total accumulated time of the specified
     * performance timer.
     *
     * @param timerLabel The category of the timer
     * @return The accumulated time of the timer, or -1 if timers are disabled
     * or the timer has never been started.
     */
    protected native int doGetAccumulatedTime(TimerLabel timerLabel);

    /**
     * WARNING: virtual and input length of message Logs a message.
     *
     * @param logCategory The category of the message
     * @param message The formatted message
     */
    protected native void doLog(LogCategory logCategory, String message);

    /**
     * WARNING: virtual Clears all log entries.
     */
    protected native void doResetLog();

    /**
     * WARNING: virtual Clears all timers. (Resets all to unused.)
     */
    protected native void doResetTimers();

    /**
     * WARNING: virtual Starts the specified performance timer.
     *
     * @param timerLabel The category of timer.
     */
    protected native void doStartTimer(TimerLabel timerLabel);

    /**
     * WARNING: virtual Stops the specified performance timer.
     *
     * @param timerLabel The category of the timer.
     */
    protected native void doStopTimer(TimerLabel timerLabel);

    /**
     * Enables or disables logging.
     *
     * @param state TRUE if logging should be enabled.
     */
    public native void enableLog(boolean state);

    /**
     * Enables or disables the performance timers.
     *
     * @param state TRUE if timers should be enabled.
     */
    public native void enableTimer(boolean state);

    /**
     * Returns the total accumulated time of the specified performance timer.
     *
     * @param timerLabel The category of the timer.
     * @return The accumulated time of the timer, or -1 if timers are disabled
     * or the timer has never been started.
     */
    public native int getAccumulatedTime(TimerLabel timerLabel);

    /**
     * Logs a message.
     *
     * Example: Where ctx is an instance of Context and filepath is a char
 array. ctx->log(RC_LOG_ERROR, "buildTiledNavigation: Could not load
     * '%s'", filepath);
     *
     * @param logCategory The category of the message.
     * @param message The message.
     */
    public native void log(LogCategory logCategory, String message);

    /**
     * Clears all log entries.
     */
    public native void resetLog();
    
    /**
     * Clears all peformance timers. (Resets all to unused.)
     */
    public native void resetTimers();
    
    /**
     * Starts the specified performance timer.
     * @param timerLabel The category of timer.
     */
    public native void startTimer(TimerLabel timerLabel);
    
    /**
     * Stops the specified performance timer.
     * @param timerLabel The category of the timer.
     */
    public native void stopTimer(TimerLabel timerLabel);
    
    
}
