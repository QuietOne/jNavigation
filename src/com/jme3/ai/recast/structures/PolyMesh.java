package com.jme3.ai.recast.structures;

/**
 * Represents a polygon mesh suitable for use in building a navigation mesh.
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMesh extends BoundedField {

    /**
     * The area id assigned to each polygon.
     */
    private char[] areas;
    /**
     * The AABB border size used to generate the source data from which the mesh
     * was derived.
     */
    private int borderSize;
    /**
     * The user defined flags for each polygon. [Length: maxpolys].
     */
    private short[] flags;
    /**
     * The number of polygons.
     */
    private int numberOfPolygons;
    /**
     * The maximum number of vertices per polygon.
     */
    private int maximumNumberOfVerticesPerPolygon;
    /**
     * Polygon and neighbor data.
     */
    private short[] polygons;
    /**
     * The mesh vertices.
     */
    private short[] vertices;
    /**
     * The region id assigned to each polygon.
     */
    private short[] regions;

    public PolyMesh() {
        reference = rcAllocPolyMesh();
    }

    private native Object rcAllocPolyMesh();

    public char[] getAreas() {
        getNativeAreas();
        return areas;
    }

    private native void getNativeAreas();

    public int getBorderSize() {
        getNativeBorderSize();
        return borderSize;
    }

    private native void getNativeBorderSize();

    public short[] getFlags() {
        getNativeFlags();
        return flags;
    }

    private native void getNativeFlags();

    public int getNumberOfPolygons() {
        getNativeNumberOfPolygons();
        return numberOfPolygons;
    }

    private native void getNativeNumberOfPolygons();

    public int getMaximumNumberOfVerticesPerPolygon() {
        getNativeNumberOfPolygons();
        return maximumNumberOfVerticesPerPolygon;
    }

    private native void getNativeMaximumNumberOfPolygon();

    public short[] getPolygons() {
        getNativePolygons();
        return polygons;
    }

    private native void getNativePolygons();

    public short[] getVertices() {
        getNativeVertices();
        return vertices;
    }

    private native void getNativeVertices();

    public short[] getRegions() {
        getNativeRegions();
        return regions;
    }

    private native void getNativeRegions();

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rcFreePolyMesh(this);
    }

    private native void rcFreePolyMesh(PolyMesh polyMesh);

    public boolean copyPolyMesh(PolyMesh destination) {
        return rcCopyPolyMesh(destination);
    }

    private native boolean rcCopyPolyMesh(PolyMesh dst);
}
