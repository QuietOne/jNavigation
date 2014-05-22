package com.jme3.ai.recast.structures.sub;

/**
 * Represents a heightfield layer within a layer set.
 *
 * See Also HeightfieldLayerSet
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class HeightfieldLayer {
    /**
     * WARNING: unsigned char*
     * Area ids. [Size: Same as heights].
     */
public String areas;

/**
 * The maximum bounds in world space. [(x, y, z)].
 */
public float[] bmax = new float[3];

/**
 * The minimum bounds in world space. [(x, y, z)].
 */
public float[] bmin=new float[3];

/**
 * The height of each cell. (The minimum increment along the y-axis.)
 */
public float ch;

/**
 * WARNING: unsigned char*
 * Packed neighbor connection information. [Size: Same as heights].
 */
public String cons;

/**
 * The size of each cell. (On the xz-plane.)
 */
public float cs;

/**
 * The height of the heightfield. (Along the z-axis in cell units.)
 */
public int height;

/**
 * WARNING: unsigned char*
 * The heightfield. [Size: (width - borderSize*2) * (h - borderSize*2)].
 */
public String heights;

/**
 * The maximum height bounds of usable data. (Along the y-axis.)
 */
public int hmax;

/**
 * The minimum height bounds of usable data. (Along the y-axis.)
 */
public int hmin;

/**
 * The maximum x-bounds of usable data.
 */
public int maxx;

/**
 * The maximum y-bounds of usable data. (Along the z-axis.)
 */
public int maxy;

/**
 * The minimum x-bounds of usable data.
 */
public int minx;

/**
 * The minimum y-bounds of usable data. (Along the z-axis.)
 */
public int miny;

/**
 * The width of the heightfield. (Along the x-axis in cell units.)
 */
public int width;

}
