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
 * using construtor, build it using buildCompactHeightfield, then run it through
 * the various helper functions to generate neighbor and region data.
 *
 * Connected neighbor spans form non-overlapping surfaces. When neighbor
 * information is generated, spans will include data that can be used to locate
 * axis-neighbors. Axis-neighbors are connected spans that are offset from the
 * current cell column as follows:
 * <ul>
 * <li>Direction 0 = (-1, 0)</li>
 * <li>Direction 1 = (0, 1)</li>
 * <li>Direction 2 = (1, 0)</li>
 * <li>Direction 3 = (0, -1)</li>
 * </ul>
 *
 * @see RecastBuilder
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class CompactHeightfield {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Allocates a compact heightfield object using the Recast allocator.
     */
    public CompactHeightfield() {
        swigCPtr = RecastJNI.rcAllocCompactHeightfield();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    protected CompactHeightfield(long cPtr, boolean cMemoryOwn) {
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

    /**
     *
     * @param value The width of the heightfield. (Along the x-axis in cell
     * units.)
     */
    public void setWidth(int value) {
        RecastJNI.rcCompactHeightfield_width_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The width of the heightfield. (Along the x-axis in cell units.)
     */
    public int getWidth() {
        return RecastJNI.rcCompactHeightfield_width_get(swigCPtr, this);
    }

    /**
     *
     * @param height The height of the heightfield. (Along the z-axis in cell
     * units.)
     */
    public void setHeight(int height) {
        RecastJNI.rcCompactHeightfield_height_set(swigCPtr, this, height);
    }

    /**
     *
     * @return The height of the heightfield. (Along the z-axis in cell units.)
     */
    public int getHeight() {
        return RecastJNI.rcCompactHeightfield_height_get(swigCPtr, this);
    }

//    /**
//     *
//     * @param spanCount The number of spans in the heightfield.
//     */
//    protected void setSpanCount(int spanCount) {
//        RecastJNI.rcCompactHeightfield_spanCount_set(swigCPtr, this, spanCount);
//    }
    /**
     *
     * @return The number of spans in the heightfield.
     */
    protected int getSpanCount() {
        return RecastJNI.rcCompactHeightfield_spanCount_get(swigCPtr, this);
    }

    /**
     *
     * @param value The walkable height used during the build of the field.
     * @see Config#walkableHeight
     */
    public void setWalkableHeight(int value) {
        RecastJNI.rcCompactHeightfield_walkableHeight_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The walkable height used during the build of the field.
     * @see Config#walkableHeight
     */
    public int getWalkableHeight() {
        return RecastJNI.rcCompactHeightfield_walkableHeight_get(swigCPtr, this);
    }

    /**
     *
     * @param value The walkable climb used during the build of the field.
     * @see Config#walkableClimb
     */
    public void setWalkableClimb(int value) {
        RecastJNI.rcCompactHeightfield_walkableClimb_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The walkable climb used during the build of the field.
     * @see Config#walkableClimb
     */
    public int getWalkableClimb() {
        return RecastJNI.rcCompactHeightfield_walkableClimb_get(swigCPtr, this);
    }

    /**
     *
     * @param value The AABB border size used during the build of the field.
     * @see Config#borderSize
     */
    public void setBorderSize(int value) {
        RecastJNI.rcCompactHeightfield_borderSize_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The AABB border size used during the build of the field.
     * @see Config#borderSize
     */
    public int getBorderSize() {
        return RecastJNI.rcCompactHeightfield_borderSize_get(swigCPtr, this);
    }

    /**
     *
     * @param maxDistance The maximum distance value of any span within the
     * field.
     */
    public void setMaxDistance(int maxDistance) {
        RecastJNI.rcCompactHeightfield_maxDistance_set(swigCPtr, this, maxDistance);
    }

    /**
     *
     * @return The maximum distance value of any span within the field.
     */
    public int getMaxDistance() {
        return RecastJNI.rcCompactHeightfield_maxDistance_get(swigCPtr, this);
    }

    /**
     *
     * @param maxRegions The maximum region id of any span within the field.
     */
    public void setMaxRegions(int maxRegions) {
        RecastJNI.rcCompactHeightfield_maxRegions_set(swigCPtr, this, maxRegions);
    }

    /**
     *
     * @return The maximum region id of any span within the field.
     */
    public int getMaxRegions() {
        return RecastJNI.rcCompactHeightfield_maxRegions_get(swigCPtr, this);
    }

    /**
     *
     * @param minBounds The minimum bounds in world space.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcCompactHeightfield_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds in world space.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcCompactHeightfield_bmin_get(swigCPtr, this);
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
        RecastJNI.rcCompactHeightfield_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds in world space.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcCompactHeightfield_bmax_get(swigCPtr, this);
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
        RecastJNI.rcCompactHeightfield_cs_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The size of each cell. (On the xz-plane.)
     */
    public float getCellSize() {
        return RecastJNI.rcCompactHeightfield_cs_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public void setCellHeight(float value) {
        RecastJNI.rcCompactHeightfield_ch_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public float getCellHeight() {
        return RecastJNI.rcCompactHeightfield_ch_get(swigCPtr, this);
    }

//    /**
//     * -not done yet
//     *
//     * @param value Array of cells.
//     */
//    public void setCells(CompactCell value) {
//        RecastJNI.rcCompactHeightfield_cells_set(swigCPtr, this, CompactCell.getCPtr(value), value);
//    }
    /**
     *
     * @return Array of cells.
     */
    public CompactCell[] getCells() {
        long cPtr = RecastJNI.rcCompactHeightfield_cells_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        int length = getHeight() * getWidth();
        CompactCell[] compactCells = new CompactCell[length];
        for (int i = 0; i < length; i++) {
            compactCells[i] = new CompactCell(cPtr + i, false);
        }
        return compactCells;
    }

//    /**
//     * -not done yet
//     *
//     * @param value Array of spans.
//     */
//    public void setSpans(CompactSpan value) {
//        RecastJNI.rcCompactHeightfield_spans_set(swigCPtr, this, CompactSpan.getCPtr(value), value);
//    }
    /**
     *
     * @return Array of spans.
     */
    public CompactSpan[] getSpans() {
        long cPtr = RecastJNI.rcCompactHeightfield_spans_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        CompactSpan[] compactSpans = new CompactSpan[getSpanCount()];
        for (int i = 0; i < compactSpans.length; i++) {
            compactSpans[i] = new CompactSpan(cPtr + i, false);

        }
        return compactSpans;
    }

    /**
     *
     * @param distance Array containing border distance data.
     */
    public void setDistances(short[] distance) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(distance);
        RecastJNI.rcCompactHeightfield_dist_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return Array containing border distance data.
     */
    public short[] getDistances() {
        long cPtr = RecastJNI.rcCompactHeightfield_dist_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getSpanCount());
    }

    /**
     *
     * @param areas Array containing area id data.
     */
    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcCompactHeightfield_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return Array containing area id data.
     */
    public char[] getAreas() {
        long cPtr = RecastJNI.rcCompactHeightfield_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getSpanCount());
    }
}
