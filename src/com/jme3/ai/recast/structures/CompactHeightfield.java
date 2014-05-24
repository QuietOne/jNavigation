package com.jme3.ai.recast.structures;

/**
 * A compact, static heightfield representing unobstructed space.
 *
 * @author TihomirRadosavljevic
 */
public class CompactHeightfield extends BoundedField {

    /**
     * WARNING: unsigned char*
     *
     * Array containing area id data. [Size: spanCount].
     */
    private String areas;
    /**
     * The AABB border size used during the build of the field. (See:
     * rcConfig::borderSize)
     */
    private int borderSize;
    /**
     * WARNING: unsigned short*
     *
     * Array containing border distance data. [Size: spanCount].
     */
    private short[] distance;
    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    private int height;
    /**
     * WARNING: unsigned short The maximum distance value of any span within the
     * field.
     */
    private int maxDistance;
    /**
     * WARNING: unsigned short The maximum region id of any span within the
     * field.
     */
    private int maxRegions;
    /**
     * The number of spans in the heightfield.
     */
    private int spanCount;
    /**
     * Array of spans. [Size: spanCount].
     */
    private CompactSpan spans;
    /**
     * The walkable climb used during the build of the field. (See:
     * rcConfig::walkableClimb)
     */
    private int walkableClimb;
    /**
     * The walkable height used during the build of the field. (See:
     * rcConfig::walkableHeight)
     */
    private int walkableHeight;
    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    private int width;

    public CompactHeightfield() {
        structure = rcAllocCompactHeightField();
    }

    private native Object rcAllocCompactHeightField();

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public short[] getDistance() {
        return distance;
    }

    public void setDistance(short[] dist) {
        this.distance = dist;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getMaxRegions() {
        return maxRegions;
    }

    public void setMaxRegions(int maxRegions) {
        this.maxRegions = maxRegions;
    }

    public int getSpanCount() {
        return spanCount;
    }

    public void setSpanCount(int spanCount) {
        this.spanCount = spanCount;
    }

    public CompactSpan getSpans() {
        return spans;
    }

    public void setSpans(CompactSpan spans) {
        this.spans = spans;
    }

    public int getWalkableClimb() {
        return walkableClimb;
    }

    public void setWalkableClimb(int walkableClimb) {
        this.walkableClimb = walkableClimb;
    }

    public int getWalkableHeight() {
        return walkableHeight;
    }

    public void setWalkableHeight(int walkableHeight) {
        this.walkableHeight = walkableHeight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

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
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
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
            return connection;
        }

        public void setConnection(int connection) {
            this.connection = connection;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getRegionID() {
            return regionID;
        }

        public void setRegionID(int regionID) {
            this.regionID = regionID;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        private native void customLoadConnection();
    }
}
