package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */
public final class PolyTypes {

    public final static PolyTypes DT_POLYTYPE_GROUND = new PolyTypes("DT_POLYTYPE_GROUND", RecastJNI.DT_POLYTYPE_GROUND_get());
    public final static PolyTypes DT_POLYTYPE_OFFMESH_CONNECTION = new PolyTypes("DT_POLYTYPE_OFFMESH_CONNECTION", RecastJNI.DT_POLYTYPE_OFFMESH_CONNECTION_get());

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static PolyTypes swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + PolyTypes.class + " with value " + swigValue);
    }

    private PolyTypes(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private PolyTypes(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private PolyTypes(String swigName, PolyTypes swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static PolyTypes[] swigValues = {DT_POLYTYPE_GROUND, DT_POLYTYPE_OFFMESH_CONNECTION};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}