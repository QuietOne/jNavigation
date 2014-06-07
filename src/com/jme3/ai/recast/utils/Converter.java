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

    public static SWIGTYPE_p_float convertToSWIGTYPE_p_float(Vector3f[] v) {
        FloatArray array = new FloatArray(v.length * 3);
        for (int i = 0; i < v.length; i++) {
            array.setItem(i * 3, v[i].x);
            array.setItem(i * 3 + 1, v[i].y);
            array.setItem(i * 3 + 2, v[i].z);
        }
        return array.cast();
    }

    public static SWIGTYPE_p_int convertToSWIGTYPE_p_int(int[] ints) {
        IntArray ia = new IntArray(ints.length);
        for (int i = 0; i < ints.length; i++) {
            ia.setItem(i, ints[i]);
        }
        return ia.cast();
    }

    public static SWIGTYPE_p_unsigned_char convertTOSWIGTYPE_p_unsigned_char(char[] chars) {
        UCharArray array = new UCharArray(chars.length);
        for (int i = 0; i < chars.length; i++) {
            array.setitem(i, (short) chars[i]);
        }
        return array.cast();
    }

    public static Vector3f[] convertToVector3f(FloatArray array, int count) {
        Vector3f[] vs = new Vector3f[count];
        for (int i = 0; i < count / 3; i++) {
            vs[i] = new Vector3f(array.getItem(i*3), array.getItem(i*3+1), array.getItem(i*3+2));
        }
        return vs;
    }
}
