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

    public static SWIGTYPE_p_unsigned_char convertToSWIGTYPE_p_unsigned_char(char[] chars) {
        UCharArray array = new UCharArray(chars.length);
        for (int i = 0; i < chars.length; i++) {
            array.setitem(i, (short) chars[i]);
        }
        return array.cast();
    }

    public static SWIGTYPE_p_unsigned_char convertTOSWIGTYPE_p_unsigned_char(char ch) {
        UCharArray array = new UCharArray(1);
        array.setitem(0, (short) ch);
        return array.cast();
    }

    public static char[] convertToChars(SWIGTYPE_p_unsigned_char value, int count) {
        UCharArray array = new UCharArray(SWIGTYPE_p_unsigned_char.getCPtr(value), false);
        char[] cs = new char[count];
        for (int i = 0; i < count; i++) {
            cs[i] = (char) array.getitem(i);
        }
        return cs;
    }

    public static char[] convertToChars(long pointer, int count) {
        UCharArray array = new UCharArray(pointer, false);
        char[] cs = new char[count];
        for (int i = 0; i < count; i++) {
            cs[i] = (char) array.getitem(i);
        }
        return cs;
    }

    public static Vector3f[] convertToVector3f(FloatArray array, int count) {
        Vector3f[] vs = new Vector3f[count];
        for (int i = 0; i < count / 3; i++) {
            vs[i] = new Vector3f(array.getItem(i * 3), array.getItem(i * 3 + 1), array.getItem(i * 3 + 2));
        }
        return vs;
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(int value) {
        UShortArray array = new UShortArray(1);
        array.setitem(0, value);
        return array.cast();
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(Vector3f[] value) {
        UShortArray array = new UShortArray(value.length * 3);
        for (int i = 0; i < value.length; i++) {
            array.setitem(i * 3, (short) value[i].x);
            array.setitem(i * 3 + 1, (short) value[i].y);
            array.setitem(i * 3 + 2, (short) value[i].z);
        }
        return array.cast();
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(short[] value) {
        UShortArray array = new UShortArray(value.length * 3);
        for (int i = 0; i < value.length; i++) {
            array.setitem(i, value[i]);
        }
        return array.cast();
    }

    public static int convertToInt(SWIGTYPE_p_unsigned_short value) {
        UShortArray array = new UShortArray(SWIGTYPE_p_unsigned_short.getCPtr(value), true);
        return array.getItem(0);
    }

    public static int convertToInt(long pointer) {
        UShortArray array = new UShortArray(pointer, true);
        return array.getItem(0);
    }

    public static int[] convertToInts(long pointer, int count) {
        IntArray array = new IntArray(pointer, false);
        int[] is = new int[count];
        for (int i = 0; i < count; i++) {
            is[i] = array.getItem(i);
        }
        return is;
    }
    
    public static short[] convertToShorts(long pointer, int count){
        IntArray array = new IntArray(pointer, false);
        short[] ses = new short[count];
        for (int i = 0; i < count; i++) {
            ses[i] = (short) array.getItem(i);
        }
        return ses;
    }

    public static SWIGTYPE_p_unsigned_int convertToSWIGTYPE_p_unsigned_int(int[] ints){
        IntArray ia = new IntArray(ints.length);
        for (int i = 0; i < ints.length; i++) {
            ia.setItem(i, ints[i]);
        }
        return null;
    }
}
