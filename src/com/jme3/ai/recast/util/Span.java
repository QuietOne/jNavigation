package com.jme3.ai.recast.util;

/**
 * Represents a span in a heightfield.
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class Span {

    /**
     * WARNING: unsigned The area id assigned to the span.
     */
    public int area;

    /**
     * The next span higher up in column.
     */
    public Span next;

    /**
     * WARNING: unsigned The upper limit of the span. [Limit: <=
     * RC_SPAN_MAX_HEIGHT].
     */
    public int smax;

    /**
     * WARNING: unsigned The lower limit of the span. [Limit: < smax].
     */
    public int smin;

}
