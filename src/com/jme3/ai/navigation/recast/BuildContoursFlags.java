package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Contour build flags.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public final class BuildContoursFlags {

    /**
     * Tessellate solid (impassable) edges during contour simplification.
     */
    public final static BuildContoursFlags RC_CONTOUR_TESS_WALL_EDGES = new BuildContoursFlags("RC_CONTOUR_TESS_WALL_EDGES", RecastJNI.RC_CONTOUR_TESS_WALL_EDGES_get());
    /**
     * Tessellate edges between areas during contour simplification.
     */
    public final static BuildContoursFlags RC_CONTOUR_TESS_AREA_EDGES = new BuildContoursFlags("RC_CONTOUR_TESS_AREA_EDGES", RecastJNI.RC_CONTOUR_TESS_AREA_EDGES_get());

    public final int value() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static BuildContoursFlags swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + BuildContoursFlags.class + " with value " + swigValue);
    }

    private BuildContoursFlags(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private BuildContoursFlags(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private BuildContoursFlags(String swigName, BuildContoursFlags swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static BuildContoursFlags[] swigValues = {RC_CONTOUR_TESS_WALL_EDGES, RC_CONTOUR_TESS_AREA_EDGES};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
