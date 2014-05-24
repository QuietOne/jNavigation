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
        structure = rcAllocHeightField();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Span getSpans() {
        return spans;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private native Object rcAllocHeightField();

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rcFreeHeightField(this);
    }

    private native void rcFreeHeightField(Heightfield hf);

    /**
     * Represents a span in a heightfield.
     */
    public class Span {

        /**
         * WARNING: unsigned The area id assigned to the span.
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

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public Span getNext() {
            return next;
        }

        public void setNext(Span next) {
            this.next = next;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
        
        private native Span customNext();

        @Override
        public String toString() {
            //TODO:
            return null;
        }
        
    }
}
