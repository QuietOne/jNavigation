package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Vertex flags returned by NavMeshQuery.findStraightPath
 *
 * @see
 * NavMeshQuery#findStraightPath(com.jme3.ai.navigation.utils.SWIGTYPE_p_float,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_float,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int, int,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_float,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_int, int)
 * @see
 * NavMeshQuery#findStraightPath(com.jme3.ai.navigation.utils.SWIGTYPE_p_float,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_float,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int, int,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_float,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int,
 * com.jme3.ai.navigation.utils.SWIGTYPE_p_int, int, int)
 * @author Tihomir Radosavljvic
 * @version 1.0
 */
public final class StraightPathFlags {

    /**
     * The vertex is the start position in the path.
     */
    public final static StraightPathFlags DT_STRAIGHTPATH_START = new StraightPathFlags("DT_STRAIGHTPATH_START", RecastJNI.DT_STRAIGHTPATH_START_get());
    /**
     * The vertex is the end position in the path.
     */
    public final static StraightPathFlags DT_STRAIGHTPATH_END = new StraightPathFlags("DT_STRAIGHTPATH_END", RecastJNI.DT_STRAIGHTPATH_END_get());
    /**
     * The vertex is the start of an off-mesh connection.
     */
    public final static StraightPathFlags DT_STRAIGHTPATH_OFFMESH_CONNECTION = new StraightPathFlags("DT_STRAIGHTPATH_OFFMESH_CONNECTION", RecastJNI.DT_STRAIGHTPATH_OFFMESH_CONNECTION_get());

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static StraightPathFlags swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + StraightPathFlags.class + " with value " + swigValue);
    }

    private StraightPathFlags(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private StraightPathFlags(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private StraightPathFlags(String swigName, StraightPathFlags swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static StraightPathFlags[] swigValues = {DT_STRAIGHTPATH_START, DT_STRAIGHTPATH_END, DT_STRAIGHTPATH_OFFMESH_CONNECTION};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
