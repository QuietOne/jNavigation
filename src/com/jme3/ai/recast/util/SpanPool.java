package com.jme3.ai.recast.util;

/**
 * A memory pool used for quick allocation of spans within a heightfield.
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class SpanPool {

    /**
     * Array of spans in the pool.
     */
    public Span[] items = new Span[Variables.RC_SPANS_PER_POOL];

    /**
     * The next span pool.
     */
    public SpanPool next;

}
