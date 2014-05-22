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
    private Vector3f maxBound;
    /**
     * The minimum bounds in world space. [(x, y, z)].
     */
    private Vector3f minBound;
    /**
     * The height of each cell. (The minimum increment along the y-axis.)
     */
    private float cellHeight;
    /**
     * The size of each cell. (On the xz-plane.)
     */
    private float cellSize;
    private Object structure;
}
