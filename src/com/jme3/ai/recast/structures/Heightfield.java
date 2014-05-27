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

        private Span(Heightfield heightfield) {
            this.heightfield = heightfield;
        }

        public int getArea() {
            getNativeArea();
            return area;
        }

        private native void getNativeArea();

        public void setArea(int area) {
            this.area = area;
            setArea();
        }

        private native void setArea();

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

        public void setMax(int max) {
            this.max = max;
            setMax();
        }

        private native void setMax();

        public int getMin() {
            getNativeMin();
            return min;
        }

        private native void getNativeMin();

        public void setMin(int min) {
            this.min = min;
            setMin();
        }

        private native void setMin();

        @Override
        public String toString() {
            return "Span{" + "area=" + area + ", max=" + max + ", min=" + min + '}';
        }
    }

    /**
     * Represents a set of heightfield layers.
     *
     * @author Tihomir Radosavljevic
     */
    public class HeightfieldLayerSet {

        private Object structure;
        /**
         * The layers in the set.
         */
        private HeightfieldLayer[] layers;

        public HeightfieldLayerSet() {
            structure = rcAllocHeightfieldLayerset();
        }

        private native Object rcAllocHeightfieldLayerset();

        public HeightfieldLayer[] getLayers() {
            getNativeLayers();
            return layers;
        }

        private native void getNativeLayers();

        public void setLayers(HeightfieldLayer[] layers) {
            this.layers = layers;
            setLayers();
        }

        private native void setLayers();

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            rcFreeHeightfieldLayerSet();
        }

        private native void rcFreeHeightfieldLayerSet();
    }

    /**
     * Represents a heightfield layer within a layer set.
     *
     * @author Tihomir Radosavljevic
     */
    public class HeightfieldLayer extends BoundedField {

        /**
         * Area ids. [Size: Same as heights].
         */
        private char[] areas;
        /**
         * Packed neighbor connection information. [Size: Same as heights].
         */
        private char[] connections;
        /**
         * The height of the heightfield. (Along the z-axis in cell units.)
         */
        private int heightOfHeightfield;
        /**
         * The heightfield.
         *
         * [Size: (width - borderSize*2) * (h - borderSize*2)].
         */
        private char[] heights;
        /**
         * The maximum height bounds of usable data. (Along the y-axis.)
         */
        private int maxHeight;
        /**
         * The minimum height bounds of usable data. (Along the y-axis.)
         */
        private int minHeight;
        /**
         * The maximum x-bounds of usable data.
         */
        private int maxX;
        /**
         * The maximum y-bounds of usable data. (Along the z-axis.)
         */
        private int maxY;
        /**
         * The minimum x-bounds of usable data.
         */
        private int minX;
        /**
         * The minimum y-bounds of usable data. (Along the z-axis.)
         */
        private int minY;
        /**
         * The width of the heightfield. (Along the x-axis in cell units.)
         */
        private int width;
        private HeightfieldLayerSet heightfieldLayerSet;

        private HeightfieldLayer(HeightfieldLayerSet heightfieldLayerSet) {
            this.heightfieldLayerSet = heightfieldLayerSet;
        }

        public char[] getAreas() {
            getNativeAreas();
            return areas;
        }
        
        private native void getNativeAreas();

        public char[] getConnections() {
            getNativeConnections();
            return connections;
        }
        
        private native void getNativeConnections();

        public int getHeightOfHeightfield() {
            getNativeHeight();
            return heightOfHeightfield;
        }
        
        private native void getNativeHeightOfHeightfield();
        
        public char[] getHeights() {
            getNativeHeights();
            return heights;
        }
        
        private native void getNativeHeights();


        public int getMaxHeight() {
            getNativeMaxHeight();
            return maxHeight;
        }
        
        private native void getNativeMaxHeight();

        public int getMinHeight() {
            getNativeMinHeight();
            return minHeight;
        }

        private native void getNativeMinHeight();

        public int getMaxX() {
            getNativeMaxX();
            return maxX;
        }

        private native void getNativeMaxX();

        public int getMaxY() {
            return maxY;
        }
        
        private native void getNativeMaxY();

        public int getMinX() {
            getNativeMinX();
            return minX;
        }
        
        private native void getNativeMinX();

        public int getMinY() {
            getNativeMinY();
            return minY;
        }
        
        private native void getNativeMinY();

        public int getWidth() {
            getNativeWidth();
            return width;
        }
        
        private native void getNativeWidth();
    }
}
