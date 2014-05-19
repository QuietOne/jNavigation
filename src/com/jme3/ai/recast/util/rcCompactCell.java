package com.jme3.ai.recast.util;

/**
 * Provides information on the content of a cell column in a compact
 * heightfield.
 *
 * See the rcCompactHeightfield documentation for an example of how compact
 * cells are used to iterate the heightfield.
 *
 * Useful instances of this type can only by obtained from a
 * rcCompactHeightfield object.
 *
 * See Also rcCompactHeightfield
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class rcCompactCell {

/**
 * WARNING: unsigned
 * Number of spans in the column.
 */    
public int count;

/**
 * WARNING: unsigned
 * Index to the first span in the column.
 */
public int index;

}
