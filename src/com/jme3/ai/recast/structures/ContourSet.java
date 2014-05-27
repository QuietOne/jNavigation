package com.jme3.ai.recast.structures;

/**
 * Represents a group of related contours.
 *
 * @author Tihomir Radosavljevic
 */
public class ContourSet extends BoundedField{

    /**
     * The AABB border size used to generate the source data from which the
     * contours were derived.
     */
    private int borderSize;
    /**
     * An array of the contours in the set. [Size: nconts].
     */
    private Contour[] contours;
    /**
     * The height of the set. (Along the z-axis in cell units.)
     */
    private int height;
    /**
     * The width of the set. (Along the x-axis in cell units.)
     */
    private int width;

    public ContourSet() {
        reference = rcAllocContourSet();
    }
    
    private native Object rcAllocContourSet();

    public int getBorderSize() {
        getNativeBorderSize();
        return borderSize;
    }
    
    private native void getNativeBorderSize();

    public Contour[] getContours() {
        getNativeContours();
        return contours;
    }
    
    private native void getNativeContours();

    public int getHeight() {
        getNativeHeight();
        return height;
    }
    
    private native void getNativeHeight();

    public int getWidth() {
        getNativeWidth();
        return width;
    }

    private native void getNativeWidth();

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
         * The area id of the contour.
         */
        private char area;
        /**
         * The region id of the contour.
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
            getNativeArea();
            return area;
        }
        
        private native void getNativeArea();

        public int getRegionID() {
            getNativeRegionID();
            return regionID;
        }

        private native void getNativeRegionID();

        public int[] getRawVertices() {
            getNativeRawVertices();
            return rawVertices;
        }
        
        private native void getNativeRawVertices();

        public int[] getSimplifiedVertices() {
            getNativeSimplifiedVertices();
            return simplifiedVertices;
        }
        
        private native void getNativeSimplifiedVertices();
    }
}
