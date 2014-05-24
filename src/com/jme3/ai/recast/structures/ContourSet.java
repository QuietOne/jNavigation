package com.jme3.ai.recast.structures;

/**
 * Represents a group of related contours.
 *
 * @author Tihomir Radosavljevic
 */
public class ContourSet {

    /**
     * The AABB border size used to generate the source data from which the
     * contours were derived.
     */
    private int borderSize;
    /**
     * An array of the contours in the set. [Size: nconts].
     */
    private Contour conts;
    /**
     * The height of the set. (Along the z-axis in cell units.)
     */
    private int height;
    /**
     * The number of contours in the set.
     */
    private int nconts;
    /**
     * The width of the set. (Along the x-axis in cell units.)
     */
    private int width;

    public ContourSet() {
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public Contour getConts() {
        return conts;
    }

    public void setConts(Contour conts) {
        this.conts = conts;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNconts() {
        return nconts;
    }

    public void setNconts(int nconts) {
        this.nconts = nconts;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private native Object rcAllocContourSet();

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rcFreeContourSet(this);
    }

    private native void rcFreeContourSet(ContourSet contourSet);

    /**
     * Represents a simple, non-overlapping contour in field space.
     *
     */
    public class Contour {

        /**
         * WARNING: unsigned char The area id of the contour.
         */
        private char area;
        /**
         * The number of vertices in the raw contour.
         */
        private int numberOfRawVertices;
        /**
         * The number of vertices in the simplified contour.
         */
        private int numberOfSimplifiedVertices;
        /**
         * WARNING: unsigned short The region id of the contour.
         */
        private int regionID;
        /**
         * Raw contour vertex and connection data. [Size: 4 * nrverts].
         */
        private int[] rawVertices;
        /**
         * Simplified contour vertex and connection data. [Size: 4 * nverts].
         */
        private int[] simplifiedVertices;

        public char getArea() {
            return area;
        }

        public void setArea(char area) {
            this.area = area;
        }

        public int getNumberOfRawVertices() {
            return numberOfRawVertices;
        }

        public void setNumberOfRawVertices(int numberOfRawVertices) {
            this.numberOfRawVertices = numberOfRawVertices;
        }

        public int getNumberOfSimplifiedVertices() {
            return numberOfSimplifiedVertices;
        }

        public void setNumberOfSimplifiedVertices(int numberOfSimplifiedVertices) {
            this.numberOfSimplifiedVertices = numberOfSimplifiedVertices;
        }

        public int getRegionID() {
            return regionID;
        }

        public void setRegionID(int regionID) {
            this.regionID = regionID;
        }

        public int[] getRawVertices() {
            return rawVertices;
        }

        public void setRawVertices(int[] rawVertices) {
            this.rawVertices = rawVertices;
        }

        public int[] getSimplifiedVertices() {
            return simplifiedVertices;
        }

        public void setSimplifiedVertices(int[] simplifiedVertices) {
            this.simplifiedVertices = simplifiedVertices;
        }
        
        
        //TODO: moving through contours
    }
}
