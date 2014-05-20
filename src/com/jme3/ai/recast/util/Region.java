package com.jme3.ai.recast.util;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class Region {

    /**
     * WARNING: unsigned
     *
     * @param i - unsigned
     */
    public Region(int i) {
    }

    public int spanCount;
    /**
     * WARNING: unsigned
     */
    public short id;
    /**
     * WARNING: unsigned
     */
    public char areaType;

    public boolean remap;

    public boolean visited;

    public IntArray connections;

    public IntArray floors;
}
