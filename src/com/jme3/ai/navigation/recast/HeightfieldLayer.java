package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.math.Vector3f;

/**
 * Represents a heightfield layer within a layer set.
 *
 * @see HeightfieldLayerSet
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class HeightfieldLayer {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public HeightfieldLayer() {
        this(RecastJNI.new_rcHeightfieldLayer(), true);
    }

    public HeightfieldLayer(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(HeightfieldLayer obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_rcHeightfieldLayer(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param minBounds The minimum bounds in world space.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcHeightfieldLayer_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds in world space.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcHeightfieldLayer_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBounds The maximum bounds in world space.
     */
    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcHeightfieldLayer_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds in world space.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcHeightfieldLayer_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value The size of each cell. (On the xz-plane.)
     */
    public void setCellSize(float value) {
        RecastJNI.rcHeightfieldLayer_cs_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The size of each cell. (On the xz-plane.)
     */
    public float getCellSize() {
        return RecastJNI.rcHeightfieldLayer_cs_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public void setCellHeight(float value) {
        RecastJNI.rcHeightfieldLayer_ch_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public float getCellHeight() {
        return RecastJNI.rcHeightfieldLayer_ch_get(swigCPtr, this);
    }

    /**
     *
     * @param value The width of the heightfield. (Along the x-axis in cell
     * units.)
     */
    public void setWidth(int value) {
        RecastJNI.rcHeightfieldLayer_width_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The width of the heightfield. (Along the x-axis in cell units.)
     */
    public int getWidth() {
        return RecastJNI.rcHeightfieldLayer_width_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of the heightfield. (Along the z-axis in cell
     * units.)
     */
    public void setHeight(int value) {
        RecastJNI.rcHeightfieldLayer_height_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of the heightfield. (Along the z-axis in cell units.)
     */
    public int getHeight() {
        return RecastJNI.rcHeightfieldLayer_height_get(swigCPtr, this);
    }

    /**
     *
     * @param value The minimum x-bounds of usable data.
     */
    public void setMinX(int value) {
        RecastJNI.rcHeightfieldLayer_minx_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The minimum x-bounds of usable data.
     */
    public int getMinX() {
        return RecastJNI.rcHeightfieldLayer_minx_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum x-bounds of usable data.
     */
    public void setMaxX(int value) {
        RecastJNI.rcHeightfieldLayer_maxx_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum x-bounds of usable data.
     */
    public int getMaxX() {
        return RecastJNI.rcHeightfieldLayer_maxx_get(swigCPtr, this);
    }

    /**
     *
     * @param value The minimum y-bounds of usable data. (Along the z-axis.)
     */
    public void setMinY(int value) {
        RecastJNI.rcHeightfieldLayer_miny_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The minimum y-bounds of usable data. (Along the z-axis.)
     */
    public int getMinY() {
        return RecastJNI.rcHeightfieldLayer_miny_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum y-bounds of usable data. (Along the z-axis.)
     */
    public void setMaxY(int value) {
        RecastJNI.rcHeightfieldLayer_maxy_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum y-bounds of usable data. (Along the z-axis.)
     */
    public int getMaxY() {
        return RecastJNI.rcHeightfieldLayer_maxy_get(swigCPtr, this);
    }

    /**
     *
     * @param value The minimum height bounds of usable data. (Along the
     * y-axis.)
     */
    public void setMinHeight(int value) {
        RecastJNI.rcHeightfieldLayer_hmin_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The minimum height bounds of usable data. (Along the y-axis.)
     */
    public int getMinHeight() {
        return RecastJNI.rcHeightfieldLayer_hmin_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum height bounds of usable data. (Along the
     * y-axis.)
     */
    public void setMaxHeight(int value) {
        RecastJNI.rcHeightfieldLayer_hmax_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum height bounds of usable data. (Along the y-axis.)
     */
    public int getMaxHeight() {
        return RecastJNI.rcHeightfieldLayer_hmax_get(swigCPtr, this);
    }

    /**
     *
     * @param heights The heightfield. [Size: (width - borderSize*2) * (h -
     * borderSize*2)].
     */
    public void setHeights(char[] heights) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(heights);
        RecastJNI.rcHeightfieldLayer_heights_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @param borderSize
     * @return The heightfield. [Size: (width - borderSize*2) * (h -
     * borderSize*2)].
     */
    public char[] getHeights(int borderSize) {
        long cPtr = RecastJNI.rcHeightfieldLayer_heights_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int count = (getWidth() - borderSize * 2) * (getHeight() - borderSize * 2);
        return Converter.convertToChars(cPtr, count);
    }

    /**
     *
     * @param areas Area ids.
     */
    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcHeightfieldLayer_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @param borderSize
     * @return Area ids.
     * @see Heightfield#getHeights
     */
    public char[] getAreas(int borderSize) {
        long cPtr = RecastJNI.rcHeightfieldLayer_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int count = (getWidth() - borderSize * 2) * (getHeight() - borderSize * 2);
        return Converter.convertToChars(cPtr, count);
    }

    /**
     *
     * @param connections Packed neighbor connection information.
     */
    public void setConnections(char[] connections) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(connections);
        RecastJNI.rcHeightfieldLayer_cons_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @param borderSize
     * @return Packed neighbor connection information.
     */
    public char[] getConnections(int borderSize) {
        long cPtr = RecastJNI.rcHeightfieldLayer_cons_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int count = (getWidth() - borderSize * 2) * (getHeight() - borderSize * 2);
        return Converter.convertToChars(cPtr, count);
    }
}
