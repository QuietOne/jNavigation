package com.jme3.ai.recast.structures;

import com.jme3.ai.recast.structures.sub.Span;

/**
 * A dynamic heightfield representing obstructed space.
 *
 * The grid of a heightfield is layed out on the xz-plane based on the value of
 * cs. Spans exist within the grid columns with the span min/max values at
 * increments of ch from the base of the grid. The smallest possible span size
 * is (cs width) * (cs depth) * (ch height). (Which is a single voxel.)
 *
 * The standard process for buidling a heightfield is to allocate it using
 * rcAllocHeightfield, initialize it using rcCreateHeightfield, then add spans
 * using the various helper functions such as rcRasterizeTriangle.
 *
 * Building a heightfield is one of the first steps in creating a polygon mesh
 * from source geometry. After it is populated, it is used to build a
 * rcCompactHeightfield.
 *
 * Example of iterating the spans in a heightfield:
 *
 * // Where hf is a reference to an heightfield object. const float* orig =
 * hf.bmin; const float cs = hf.cs; const float ch = hf.ch; const int w =
 * hf.width; const int h = hf.height; for (int y = 0; y < h; ++y) { for (int x =
 * 0; x < w; ++x) { // Deriving the minimum corner of the grid location. float
 * fx = orig[0] + x*cs; float fz = orig[2] + y*cs; // The base span in the
 * column. (May be null.) const Span* s = hf.spans[x + y*w]; while (s) { //
 * Detriving the minium and maximum world position of the span. float fymin =
 * orig[1]+s->smin*ch; float fymax = orig[1] + s->smax*ch; // Do other things
 * with the span before moving up the column. s = s->next; } } }
 *
 * @author Tihomir Radosavljevic
 * @verstion 0.1
 */
public class Heightfield extends BoundedField {

    /**
     * The next free span.
     */
    public Span freelist;
    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    public int height;
    /**
     * Heightfield of spans (width*height).
     */
    public Span spans;
    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    public int width;


}