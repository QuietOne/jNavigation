package com.jme3.ai.recast.structures;

import com.jme3.math.Vector3f;

/**
 * Base class for all other Recast structures.
 *
 * @author Tihomir Radosavljevic
 */
public class BoundedField {

    /**
     * The maximum bounds in world space. [(x, y, z)].
     */
    protected Vector3f maxBound;
    /**
     * The minimum bounds in world space. [(x, y, z)].
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
    protected Object structure;

    public Vector3f getMaxBound() {
        return getNativeMaxBound();
    }

    private native Vector3f getNativeMaxBound();

    public void setMaxBound(Vector3f maxBound) {
        this.maxBound = maxBound;
        setMaxBound();
    }

    private native void setMaxBound();

    public Vector3f getMinBound() {
        return getNativeMinBound();
    }

    private native Vector3f getNativeMinBound();

    public void setMinBound(Vector3f minBound) {
        this.minBound = minBound;
        setMinBound();
    }

    private native void setMinBound();

    public float getCellHeight() {
        return getNativeCellHeight();
    }

    private native float getNativeCellHeight();

    public void setCellHeight(float cellHeight) {
        this.cellHeight = cellHeight;
        setCellHeight();
    }

    private native void setCellHeight();

    public float getCellSize() {
        return getNativeCellSize();
    }

    private native float getNativeCellSize();

    public void setCellSize(float cellSize) {
        this.cellSize = cellSize;
        setCellSize();
    }

    private native void setCellSize();
}