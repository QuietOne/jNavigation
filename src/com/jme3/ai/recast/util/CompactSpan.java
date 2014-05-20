package com.jme3.ai.recast.util;

/**
 * Represents a span of unobstructed space within a compact heightfield.
 *
 * The span represents open, unobstructed space within a compact heightfield
 * column. See the rcCompactHeightfield documentation for an example of
 * iterating spans and searching span connections.
 *
 * Useful instances of this type can only by obtained from a
 * rcCompactHeightfield object.
 *
 * See Also rcCompactHeightfield
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class CompactSpan {

    /**
     * WARNING: unsigned Packed neighbor connection data.
     */
    public int con;

    /**
     * WARNING: unsigned The height of the span. (Measured from y.)
     */
    public int h;

    /**
     * WARNING: unsigned short The id of the region the span belongs to. (Or
     * zero if not in a region.)
     */
    public int reg;

    /**
     * WARNING: unsigned short The lower extent of the span. (Measured from the
     * heightfield's base.)
     */
    public int y;

}
