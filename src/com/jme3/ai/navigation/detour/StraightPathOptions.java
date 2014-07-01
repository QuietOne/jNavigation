package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Options for NavMeshQuery.findStraightPath.
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
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public final class StraightPathOptions {

    /**
     * Add a vertex at every polygon edge crossing where area changes.
     */
    public final static StraightPathOptions DT_STRAIGHTPATH_AREA_CROSSINGS = new StraightPathOptions("DT_STRAIGHTPATH_AREA_CROSSINGS", RecastJNI.DT_STRAIGHTPATH_AREA_CROSSINGS_get());
    /**
     * Add a vertex at every polygon edge crossing.
     */
    public final static StraightPathOptions DT_STRAIGHTPATH_ALL_CROSSINGS = new StraightPathOptions("DT_STRAIGHTPATH_ALL_CROSSINGS", RecastJNI.DT_STRAIGHTPATH_ALL_CROSSINGS_get());

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static StraightPathOptions swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + StraightPathOptions.class + " with value " + swigValue);
    }

    private StraightPathOptions(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private StraightPathOptions(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private StraightPathOptions(String swigName, StraightPathOptions swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static StraightPathOptions[] swigValues = {DT_STRAIGHTPATH_AREA_CROSSINGS, DT_STRAIGHTPATH_ALL_CROSSINGS};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
