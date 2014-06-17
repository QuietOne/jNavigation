package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Recast log categories.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public final class LogCategory {

    /**
     * A progress log entry.
     */
    public final static LogCategory RC_LOG_PROGRESS = new LogCategory("RC_LOG_PROGRESS", RecastJNI.RC_LOG_PROGRESS_get());
    /**
     * A warning log entry.
     */
    public final static LogCategory RC_LOG_WARNING = new LogCategory("RC_LOG_WARNING");
    /**
     * An error log entry.
     */
    public final static LogCategory RC_LOG_ERROR = new LogCategory("RC_LOG_ERROR");

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static LogCategory swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + LogCategory.class + " with value " + swigValue);
    }

    private LogCategory(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private LogCategory(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private LogCategory(String swigName, LogCategory swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static LogCategory[] swigValues = {RC_LOG_PROGRESS, RC_LOG_WARNING, RC_LOG_ERROR};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
