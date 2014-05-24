package com.jme3.ai.recast.structures;

/**
 * Represents a polygon mesh suitable for use in building a navigation mesh.
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMesh extends BoundedField {

    /**
     * The area id assigned to each polygon. [Length: maxpolys] The standard
     * build process assigns the value of RC_WALKABLE_AREA to all walkable
     * polygons. This value can then be changed to meet user requirements.
     */
    private String areas;
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
     * The number of allocated polygons.
     */
    private int maxPolygons;
    /**
     * The number of polygons.
     */
    private int numberOfPolygons;
    /**
     * The number of vertices.
     */
    private int numberOfVertices;
    /**
     * The maximum number of vertices per polygon.
     */
    private int maximumNumberOfVerticesPerPolygon;
    /**
     * Polygon and neighbor data.  [Length: maxpolys * 2 * nvp].
     */
    private short[] polygons;
    /**
     * The mesh vertices. [Form: (x, y, z) * nverts].
     */
    private short[] vertices;
    /**
     * The region id assigned to each polygon. [Length: maxpolys].
     */
    private short[] regions;

    public PolyMesh() {
        structure = rcAllocPolyMesh();
    }

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

    public short[] getFlags() {
        return flags;
    }

    public void setFlags(short[] flags) {
        this.flags = flags;
    }

    public int getMaxPolygons() {
        return maxPolygons;
    }

    public void setMaxPolygons(int maxPolygons) {
        this.maxPolygons = maxPolygons;
    }

    public int getNumberOfPolygons() {
        return numberOfPolygons;
    }

    public void setNumberOfPolygons(int numberOfPolygons) {
        this.numberOfPolygons = numberOfPolygons;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public int getMaximumNumberOfVerticesPerPolygon() {
        return maximumNumberOfVerticesPerPolygon;
    }

    public void setMaximumNumberOfVerticesPerPolygon(int maximumNumberOfVerticesPerPolygon) {
        this.maximumNumberOfVerticesPerPolygon = maximumNumberOfVerticesPerPolygon;
    }

    public short[] getPolygons() {
        return polygons;
    }

    public void setPolygons(short[] polygons) {
        this.polygons = polygons;
    }

    private native Object rcAllocPolyMesh();

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rcFreePolyMesh(this);
    }

    private native void rcFreePolyMesh(PolyMesh polyMesh);

    private native boolean rcCopyPolyMesh(PolyMesh src, PolyMesh dst);

    public short[] getVertices() {
        return vertices;
    }

    public void setVertices(short[] vertices) {
        this.vertices = vertices;
    }

    public short[] getRegions() {
        return regions;
    }

    public void setRegions(short[] regions) {
        this.regions = regions;
    }
    
    
    //TODO: moving through
}
