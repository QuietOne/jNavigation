package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.99
 */
public final class NodeFlags {

    public final static NodeFlags DT_NODE_OPEN = new NodeFlags("DT_NODE_OPEN", RecastJNI.DT_NODE_OPEN_get());
    public final static NodeFlags DT_NODE_CLOSED = new NodeFlags("DT_NODE_CLOSED", RecastJNI.DT_NODE_CLOSED_get());

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static NodeFlags swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + NodeFlags.class + " with value " + swigValue);
    }

    private NodeFlags(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private NodeFlags(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private NodeFlags(String swigName, NodeFlags swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static NodeFlags[] swigValues = {DT_NODE_OPEN, DT_NODE_CLOSED};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
