package com.jme3.ai.recast.structures;

import com.jme3.ai.recast.structures.sub.Contour;

/**
 * Represents a group of related contours.
 *
 * All contours within the set share the minimum bounds and cell sizes of the
 * set.
 *
 * The standard process for building a contour set is to allocate it using
 * rcAllocContourSet, then initialize it using rcBuildContours.
 *
 * See Also rcAllocContourSet, rcFreeContourSet, rcBuildContours
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class ContourSet {

    /**
     * The maximum bounds in world space. [(x, y, z)].
     */
    public float[] bmax = new float[3];

    /**
     * The minimum bounds in world space. [(x, y, z)].
     */
    public float[] bmin = new float[3];

    /**
     * The AABB border size used to generate the source data from which the
     * contours were derived.
     */
    public int borderSize;

    /**
     * The height of each cell. (The minimum increment along the y-axis.)
     */
    public float ch;

    /**
     * An array of the contours in the set. [Size: nconts].
     */
    public Contour conts;

    /**
     * The size of each cell. (On the xz-plane.)
     */
    public float cs;

    /**
     * The height of the set. (Along the z-axis in cell units.)
     */
    public int height;

    /**
     * The number of contours in the set.
     */
    public int nconts;

    /**
     * The width of the set. (Along the x-axis in cell units.)
     */
    public int width;

}
