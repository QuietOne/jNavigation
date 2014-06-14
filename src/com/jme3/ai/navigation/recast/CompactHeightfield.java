package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 * A compact, static heightfield representing unobstructed space.
 *
 * For this type of heightfield, the spans represent the open (unobstructed)
 * space above the solid surfaces of a voxel field. It is usually created from a
 * rcHeightfield object. Data is stored in a compact, efficient manner, but the
 * structure is not condusive to adding and removing spans.
 *
 * The standard process for buidling a compact heightfield is to allocate it
 * using rcAllocCompactHeightfield, build it using rcBuildCompactHeightfield,
 * then run it through the various helper functions to generate neighbor and
 * region data.
 *
 * Connected neighbor spans form non-overlapping surfaces. When neighbor
 * information is generated, spans will include data that can be used to locate
 * axis-neighbors. Axis-neighbors are connected spans that are offset from the
 * current cell column as follows:
 *
 * Direction 0 = (-1, 0) Direction 1 = (0, 1) Direction 2 = (1, 0) Direction 3 =
 * (0, -1) Example of iterating and inspecting spans, including connected
 * neighbors:
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompactHeightfield {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CompactHeightfield() {
        swigCPtr = RecastJNI.rcAllocCompactHeightfield();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public CompactHeightfield(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(CompactHeightfield obj) {
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
                RecastJNI.rcFreeCompactHeightfield(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    public void setWidth(int value) {
        RecastJNI.rcCompactHeightfield_width_set(swigCPtr, this, value);
    }

    public int getWidth() {
        return RecastJNI.rcCompactHeightfield_width_get(swigCPtr, this);
    }

    public void setHeight(int value) {
        RecastJNI.rcCompactHeightfield_height_set(swigCPtr, this, value);
    }

    public int getHeight() {
        return RecastJNI.rcCompactHeightfield_height_get(swigCPtr, this);
    }

    public void setSpanCount(int value) {
        RecastJNI.rcCompactHeightfield_spanCount_set(swigCPtr, this, value);
    }

    public int getSpanCount() {
        return RecastJNI.rcCompactHeightfield_spanCount_get(swigCPtr, this);
    }

    public void setWalkableHeight(int value) {
        RecastJNI.rcCompactHeightfield_walkableHeight_set(swigCPtr, this, value);
    }

    public int getWalkableHeight() {
        return RecastJNI.rcCompactHeightfield_walkableHeight_get(swigCPtr, this);
    }

    public void setWalkableClimb(int value) {
        RecastJNI.rcCompactHeightfield_walkableClimb_set(swigCPtr, this, value);
    }

    public int getWalkableClimb() {
        return RecastJNI.rcCompactHeightfield_walkableClimb_get(swigCPtr, this);
    }

    public void setBorderSize(int value) {
        RecastJNI.rcCompactHeightfield_borderSize_set(swigCPtr, this, value);
    }

    public int getBorderSize() {
        return RecastJNI.rcCompactHeightfield_borderSize_get(swigCPtr, this);
    }

    public void setMaxDistance(int value) {
        RecastJNI.rcCompactHeightfield_maxDistance_set(swigCPtr, this, value);
    }

    public int getMaxDistance() {
        return RecastJNI.rcCompactHeightfield_maxDistance_get(swigCPtr, this);
    }

    public void setMaxRegions(int value) {
        RecastJNI.rcCompactHeightfield_maxRegions_set(swigCPtr, this, value);
    }

    public int getMaxRegions() {
        return RecastJNI.rcCompactHeightfield_maxRegions_get(swigCPtr, this);
    }

    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcCompactHeightfield_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcCompactHeightfield_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcCompactHeightfield_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcCompactHeightfield_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    public void setCellSize(float value) {
        RecastJNI.rcCompactHeightfield_cs_set(swigCPtr, this, value);
    }

    public float getCellSize() {
        return RecastJNI.rcCompactHeightfield_cs_get(swigCPtr, this);
    }

    public void setCellHeight(float value) {
        RecastJNI.rcCompactHeightfield_ch_set(swigCPtr, this, value);
    }

    public float getCellHeight() {
        return RecastJNI.rcCompactHeightfield_ch_get(swigCPtr, this);
    }

    public void setCells(CompactCell value) {
        RecastJNI.rcCompactHeightfield_cells_set(swigCPtr, this, CompactCell.getCPtr(value), value);
    }

    public CompactCell getCells() {
        long cPtr = RecastJNI.rcCompactHeightfield_cells_get(swigCPtr, this);
        return (cPtr == 0) ? null : new CompactCell(cPtr, false);
    }

    public void setSpans(CompactSpan value) {
        RecastJNI.rcCompactHeightfield_spans_set(swigCPtr, this, CompactSpan.getCPtr(value), value);
    }

    public CompactSpan getSpans() {
        long cPtr = RecastJNI.rcCompactHeightfield_spans_get(swigCPtr, this);
        return (cPtr == 0) ? null : new CompactSpan(cPtr, false);
    }

    public void setDistance(int distance) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(distance);
        RecastJNI.rcCompactHeightfield_dist_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    public int getDistance() {
        long cPtr = RecastJNI.rcCompactHeightfield_dist_get(swigCPtr, this);
        if (cPtr == 0) {
            return 0;
        }
        return Converter.convertToInt(cPtr);
    }

    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcCompactHeightfield_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    public char[] getAreas() {
        long cPtr = RecastJNI.rcCompactHeightfield_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getSpanCount());
    }
}
