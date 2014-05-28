package com.jme3.ai.recast.structures;

import com.jme3.math.Vector3f;

/**
 * Base class for all other Recast structures.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class BoundedField {

    /**
     * The maximum bounds in world space.
     */
    protected Vector3f maxBound;
    /**
     * The minimum bounds in world space.
     */
    protected Vector3f minBound;
    /**
     * The height of each cell. (The minimum increment along the y-axis.)
     */
    protected float cellHeight;
    /**
     * The size of each cell. (On the xz-plane.)
     */
    protected float cellSize;
    /**
     * Reference to the native object.
     */
    protected Object reference;

    public Vector3f getMaxBound() {
        getNativeMaxBound();
        return maxBound;
    }

    private native void getNativeMaxBound();

    public Vector3f getMinBound() {
        getNativeMinBound();
        return minBound;
    }

    private native void getNativeMinBound();

    public float getCellHeight() {
        getNativeCellHeight();
        return cellHeight;
    }

    private native void getNativeCellHeight();

    public float getCellSize() {
        getNativeCellSize();
        return cellSize;
    }

    private native void getNativeCellSize();
}