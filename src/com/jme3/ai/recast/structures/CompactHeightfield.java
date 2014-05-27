package com.jme3.ai.recast.structures;

/**
 * A compact, static heightfield representing unobstructed space.
 *
 * @author TihomirRadosavljevic
 */
public class CompactHeightfield extends BoundedField {

    /**
     * Array containing area id data.
     */
    private char[] areas;
    /**
     * The AABB border size used during the build of the field.
     */
    private int borderSize;
    /**
     * Array containing border distance data.
     */
    private short[] distance;
    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    private int height;
    /**
     * The maximum distance value of any span within the field.
     */
    private short maxDistance;
    /**
     * The maximum region id of any span within the field.
     */
    private short maxRegionID;
    /**
     * Array of spans.
     */
    private CompactSpan[] spans;
    /**
     * Array of cells. [Size: width*height].
     */
    private CompactCell[] cells;
    /**
     * The walkable climb used during the build of the field.
     */
    private int walkableClimb;
    /**
     * The walkable height used during the build of the field.
     */
    private int walkableHeight;
    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    private int width;

    public CompactHeightfield() {
        reference = rcAllocCompactHeightField();
    }

    private native Object rcAllocCompactHeightField();

    public char[] getAreas() {
        getNativeAreas();
        return areas;
    }

    private native void getNativeAreas();

    public void setAreas(char[] areas) {
        this.areas = areas;
        setAreas();
    }

    private native void setAreas();

    public int getBorderSize() {
        getNativeBorderSize();
        return borderSize;
    }

    private native void getNativeBorderSize();

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        setBorderSize();
    }

    private native void setBorderSize();

    public short[] getDistance() {
        getNativeDistance();
        return distance;
    }

    private native void getNativeDistance();

    public void setDistance(short[] dist) {
        this.distance = dist;
        setDistance();
    }

    private native void setDistance();

    public int getHeight() {
        return height;
    }

    private native void getNativeHeight();

    public void setHeight(int height) {
        this.height = height;
        setHeight();
    }

    private native void setHeight();

    public short getMaxDistance() {
        getNativeMaxDistance();
        return maxDistance;
    }

    private native void getNativeMaxDistance();

    public void setMaxDistance(short maxDistance) {
        this.maxDistance = maxDistance;
        setMaxDistance();
    }

    private native void setMaxDistance();

    public short getMaxRegionID() {
        getNativeMaxRegionID();
        return maxRegionID;
    }

    private native void getNativeMaxRegionID();

    public void setMaxRegionID(short maxRegionID) {
        this.maxRegionID = maxRegionID;
        setMaxRegionID();
    }

    private native void setMaxRegionID();

    public CompactSpan[] getSpans() {
        getNativeSpans();
        return spans;
    }

    private native void getNativeSpans();

    public int getWalkableClimb() {
        getNativeWalkableClimb();
        return walkableClimb;
    }

    private native void getNativeWalkableClimb();

    public void setWalkableClimb(int walkableClimb) {
        this.walkableClimb = walkableClimb;
        setWalkableClimb();
    }

    private native void setWalkableClimb();

    public int getWalkableHeight() {
        getNativeWalkableHeight();
        return walkableHeight;
    }

    private native void getNativeWalkableHeight();

    public void setWalkableHeight(int walkableHeight) {
        this.walkableHeight = walkableHeight;
        setWalkableHeight();
    }

    private native void setWalkableHeight();

    public int getWidth() {
        getNativeWidth();
        return width;
    }

    private native void getNativeWidth();

    public void setWidth(int width) {
        this.width = width;
        setWidth();
    }

    private native void setWidth();

    public CompactCell[] getCells() {
        getNativeCells();
        return cells;
    }

    private native void getNativeCells();

    /**
     * Provides information on the content of a cell column in a compact
     * heightfield.
     *
     * @author Tihomir Radosavljevic
     */
    public class CompactCell {

        /**
         * Number of spans in the column.
         */
        private int count;
        /**
         * Index to the first span in the column.
         */
        private int index;

        public int getCount() {
            getNativeCount();
            return count;
        }

        private native void getNativeCount();

        public int getIndex() {
            getNativeIndex();
            return index;
        }

        private native void getNativeIndex();
    }

    /**
     * Represents a span of unobstructed space within a compact heightfield.
     */
    public class CompactSpan {

        /**
         * Packed neighbor connection data.
         */
        private int connection;
        /**
         * The height of the span. (Measured from y.)
         */
        private int height;
        /**
         * The id of the region the span belongs to. (Or zero if not in a
         * region.)
         */
        private int regionID;
        /**
         * The lower extent of the span. (Measured from the heightfield's base.)
         */
        private int y;

        public int getConnection() {
            getNativeConnection();
            return connection;
        }

        private native void getNativeConnection();

        public int getHeight() {
            getNativeHeight();
            return height;
        }

        private native void getNativeHeight();

        public int getRegionID() {
            getNativeRegionID();
            return regionID;
        }

        private native void getNativeRegionID();

        public int getY() {
            getNativeY();
            return y;
        }

        private native void getNativeY();
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
