package com.jme3.ai.recast.structures;

import com.jme3.ai.recast.builders.HeightfieldBuilder;

/**
 * A dynamic heightfield representing obstructed space. The grid of a
 * heightfield is layed out on the xz-plane based on the value of cellSize.
 * Spans exist within the grid columns with the span min/max values at
 * increments of cellHeight from the base of the grid. The smallest possible
 * span size is (cellSize width) * (cellSize depth) * (cellHeight height).
 * (Which is a single voxel.) Building a heightfield is one of the first steps
 * in creating a polygon mesh from source geometry. After it is populated, it is
 * used to build a CompactHeightfield.
 *
 * @see HeightfieldBuilder
 * @see CompactHeightfield
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Heightfield extends BoundedField {

    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    private int height;
    /**
     * Heightfield of spans (width*height).
     */
    private Span[] spans;
    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    private int width;

    public Heightfield() {
        reference = rcAllocHeightField();
    }

    private native Object rcAllocHeightField();

    public int getHeight() {
        getNativeHeight();
        return height;
    }

    private native void getNativeHeight();

    public Span[] getSpans() {
        getNativeSpans();
        return spans;
    }

    private native void getNativeSpans();

    public int getWidth() {
        getNativeWidth();
        return width;
    }

    public native void getNativeWidth();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        rcFreeHeightField();
    }

    private native void rcFreeHeightField();

    /**
     * Represents a span in a heightfield.
     */
    public class Span {

        /**
         * The area id assigned to the span.
         */
        private int area;
        /**
         * The next span higher up in column.
         */
        private Span next;
        /**
         * The upper limit of the span.
         */
        private int max;
        /**
         * The lower limit of the span.
         */
        private int min;
        /**
         * Reference to the heightfield that it is attached.
         */
        private Heightfield heightfield;
        /**
         * Reference to its own structure.
         */
        private Object reference;

        private Span(Heightfield heightfield) {
            this.heightfield = heightfield;
        }

        public int getArea() {
            getNativeArea();
            return area;
        }

        private native void getNativeArea();

        public Span getNext() {
            getNativeNext();
            return next;
        }

        private native Span getNativeNext();

        public int getMax() {
            getNativeMax();
            return max;
        }

        private native void getNativeMax();

        public int getMin() {
            getNativeMin();
            return min;
        }

        private native void getNativeMin();

        @Override
        public String toString() {
            return "Span{" + "area=" + area + ", max=" + max + ", min=" + min + '}';
        }
    }
}
