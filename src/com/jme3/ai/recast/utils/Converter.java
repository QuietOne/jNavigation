package com.jme3.ai.recast.utils;

import com.jme3.math.Vector3f;

/**
 * Class for converting types from C++ types to one that are used by jME.
 *
 * @author Tihomir Radosavljevic
 */
public class Converter {

    public static Vector3f convertToVector3f(long cPtr) {
        FloatArray a = new FloatArray(cPtr, false);
        return new Vector3f(a.getItem(0), a.getItem(1), a.getItem(2));
    }

    public static SWIGTYPE_p_float convertToSWIGTYPE_p_float(Vector3f v) {
        FloatArray array = new FloatArray(3);
        array.setItem(0, v.x);
        array.setItem(1, v.y);
        array.setItem(2, v.z);
        return array.cast();
    }
}
