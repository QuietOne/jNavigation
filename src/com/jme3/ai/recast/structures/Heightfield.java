package com.jme3.ai.recast.structures;

/**
 * A dynamic heightfield representing obstructed space.
 *
 * @author Tihomir Radosavljevic
 */
public class Heightfield extends BoundedField {

    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    private int height;
    /**
     * Heightfield of spans (width*height).
     */
    private Span spans;
    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    private int width;

    public Heightfield() {
        reference = rcAllocHeightField();
        spans = new Span(this);
    }

    private native Object rcAllocHeightField();

    public int getHeight() {
        getNativeHeight();
        return height;
    }

    private native void getNativeHeight();

    public void setHeight(int height) {
        this.height = height;
        setHeight();
    }

    private native void setHeight();

    public Span getSpans() {
        getNativeSpan();
        return spans;
    }

    private native void getNativeSpan();

    public int getWidth() {
        getNativeWidth();
        return width;
    }

    public native void getNativeWidth();

    public void setWidth(int width) {
        this.width = width;
        setWidth();
    }

    private native void setWidth();

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
        private Heightfield heightfield;
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
