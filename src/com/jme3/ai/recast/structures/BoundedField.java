package com.jme3.ai.recast.structures;

import com.jme3.math.Vector3f;

/**
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
     * Reference to the object in written in C++.
     */
    protected Object structure;

    public Vector3f getMaxBound() {
        return maxBound;
    }

    public void setMaxBound(Vector3f maxBound) {
        this.maxBound = maxBound;
    }

    public Vector3f getMinBound() {
        return minBound;
    }

    public void setMinBound(Vector3f minBound) {
        this.minBound = minBound;
    }

    public float getCellHeight() {
        return cellHeight;
    }

    public void setCellHeight(float cellHeight) {
        this.cellHeight = cellHeight;
    }

    public float getCellSize() {
        return cellSize;
    }

    public void setCellSize(float cellSize) {
        this.cellSize = cellSize;
    }

    public Object getStructure() {
        return structure;
    }

    public void setStructure(Object structure) {
        this.structure = structure;
    }
    
    
}
