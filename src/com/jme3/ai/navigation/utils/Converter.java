package com.jme3.ai.navigation.utils;

import com.jme3.ai.navigation.detour.Link;
import com.jme3.ai.navigation.detour.OffMeshConnection;
import com.jme3.ai.navigation.detour.Poly;
import com.jme3.ai.navigation.detour.PolyDetail;
import com.jme3.math.Vector3f;

/**
 * Class for converting types from C++ types to one that are used by jME, and
 * some helper function used to get data from some jME structures.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
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

    public static int[] convertToInts(short[] shorts) {
        int[] ints = new int[shorts.length];
        for (int i = 0; i < shorts.length; i++) {
            ints[i] = shorts[i];
        }
        return ints;
    }

    public static SWIGTYPE_p_float convertToSWIGTYPE_p_float(float[] v) {
        FloatArray array = new FloatArray(v.length);
        for (int i = 0; i < v.length; i++) {
            array.setItem(i, v[i]);
        }
        return array.cast();
    }

    public static float[] convertToFloats(long pointer, int count) {
        float[] fs = new float[count];
        FloatArray array = new FloatArray(pointer, false);
        for (int i = 0; i < count; i++) {
            fs[i] = array.getItem(i);
        }
        return fs;
    }

    public static float convertToFloat(long pointer) {
        FloatArray array = new FloatArray(pointer, true);
        return array.getItem(0);
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(Vector3f v) {
        UShortArray array = new UShortArray(3);
        array.setItem(0, (short) v.x);
        array.setItem(1, (short) v.y);
        array.setItem(2, (short) v.z);
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
            array.setItem(i, (short) chars[i]);
        }
        return array.cast();
    }

    public static SWIGTYPE_p_unsigned_char convertToSWIGTYPE_p_unsigned_char(char ch) {
        UCharArray array = new UCharArray(1);
        array.setItem(0, (short) ch);
        return array.cast();
    }

    public static char[] convertToChars(SWIGTYPE_p_unsigned_char value, int count) {
        UCharArray array = new UCharArray(SWIGTYPE_p_unsigned_char.getCPtr(value), false);
        char[] cs = new char[count];
        for (int i = 0; i < count; i++) {
            cs[i] = (char) array.getItem(i);
        }
        return cs;
    }

    public static char[] convertToChars(long pointer, int count) {
        UCharArray array = new UCharArray(pointer, false);
        char[] cs = new char[count];
        for (int i = 0; i < count; i++) {
            cs[i] = (char) array.getItem(i);
        }
        return cs;
    }

    public static char convertToChar(long pointer) {
        UCharArray array = new UCharArray(pointer, false);
        return (char) array.getItem(0);
    }

    public static Vector3f[] convertToVector3f(long pointer, int count) {
        FloatArray array = new FloatArray(pointer, false);
        Vector3f[] vs = new Vector3f[count];
        for (int i = 0; i < count; i++) {
            vs[i] = new Vector3f(array.getItem(i * 3), array.getItem(i * 3 + 1), array.getItem(i * 3 + 2));
        }
        return vs;
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(int value) {
        UShortArray array = new UShortArray(1);
        array.setItem(0, value);
        return array.cast();
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(Vector3f[] value) {
        UShortArray array = new UShortArray(value.length * 3);
        for (int i = 0; i < value.length; i++) {
            array.setItem(i * 3, (short) value[i].x);
            array.setItem(i * 3 + 1, (short) value[i].y);
            array.setItem(i * 3 + 2, (short) value[i].z);
        }
        return array.cast();
    }

    public static SWIGTYPE_p_unsigned_short convertToSWIGTYPE_p_unsigned_short(short[] value) {
        UShortArray array = new UShortArray(value.length * 3);
        for (int i = 0; i < value.length; i++) {
            array.setItem(i, value[i]);
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

    public static short[] convertToShorts(long pointer, int count) {
        IntArray array = new IntArray(pointer, false);
        short[] ses = new short[count];
        for (int i = 0; i < count; i++) {
            ses[i] = (short) array.getItem(i);
        }
        return ses;
    }

    public static SWIGTYPE_p_unsigned_int convertToSWIGTYPE_p_unsigned_int(int[] ints) {
        UIntArray ia = new UIntArray(ints.length);
        for (int i = 0; i < ints.length; i++) {
            ia.setItem(i, ints[i]);
        }
        return ia.cast();
    }

    public static Poly[] convertToPolys(long pointer, int count) {
        Poly[] polys = new Poly[count];
        for (int i = 0; i < polys.length; i++) {
            polys[i] = new Poly(pointer + i, false);
        }
        return polys;
    }

    public static Poly[] convertToPolys(SWIGTYPE_p_unsigned_int resultRef, SWIGTYPE_p_int resultCount) {
        return convertToPolys(SWIGTYPE_p_unsigned_int.getCPtr(resultRef), convertToInt(SWIGTYPE_p_int.getCPtr(resultCount)));
    }

    public static Poly[] convertToPolys(SWIGTYPE_p_unsigned_int resultRef, int resultCount) {
        return convertToPolys(SWIGTYPE_p_unsigned_int.getCPtr(resultRef), resultCount);
    }
    
    public static PolyDetail[] convertToPolyDetails(long pointer, int count){
        PolyDetail[] details = new PolyDetail[count];
        for (int i = 0; i < details.length; i++) {
            details[i] = new PolyDetail(pointer + i, false);
        }
        return details;
    }
    
    public static OffMeshConnection[] convertToOffMeshConnections(long pointer, int count){
        OffMeshConnection[] connections = new OffMeshConnection[count];
        for (int i = 0; i < connections.length; i++) {
            connections[i] = new OffMeshConnection(pointer + i, false);
        }
        return connections;
    }
    
    public static Link[] convertToLinks(long pointer, int count){
        Link[] links = new Link[count];
        for (int i = 0; i < links.length; i++) {
            links[i] = new Link(pointer + i, false);
        }
        return links;
    }
    
    public static SWIGTYPE_p_unsigned_int convertToSWIGTYPE_p_unsigned_int(Poly[] polys){
        return new SWIGTYPE_p_unsigned_int(Poly.getCPtr(polys[0]), true);
    }
}
