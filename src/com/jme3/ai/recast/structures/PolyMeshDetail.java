package com.jme3.ai.recast.structures;

/**
 * Contains triangle meshes that represent detailed height data associated with
 * the polygons in its associated polygon mesh object.
 *
 * @author Tihomir Radosavljevic
 */
public class PolyMeshDetail extends BoundedField{

    /**
     * The sub-mesh data. [Size: 4*nmeshes].
     */
    private int[] meshes;
    /**
     * The number of sub-meshes defined by meshes.
     */
    private int numberOfMeshes;
    /**
     * The number of triangles in tris.
     */
    private int numberOfTriangles;
    /**
     * The number of vertices in verts.
     */
    private int numberOfVertices;
    /**
     * The mesh triangles. [Size: 4*ntris].
     */
    private String triangles;
    /**
     * The mesh vertices. [Size: 3*nverts].
     */
    private float[] vertices;

    public PolyMeshDetail() {
        structure = rcAllocPolyMeshDetail();
    }

    public int[] getMeshes() {
        return meshes;
    }

    public void setMeshes(int[] meshes) {
        this.meshes = meshes;
    }

    public int getNumberOfMeshes() {
        return numberOfMeshes;
    }

    public void setNumberOfMeshes(int numberOfMeshes) {
        this.numberOfMeshes = numberOfMeshes;
    }

    public int getNumberOfTriangles() {
        return numberOfTriangles;
    }

    public void setNumberOfTriangles(int numberOfTriangles) {
        this.numberOfTriangles = numberOfTriangles;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public String getTriangles() {
        return triangles;
    }

    public void setTriangles(String triangles) {
        this.triangles = triangles;
    }

    public float[] getVertices() {
        return vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }
    
    private native Object rcAllocPolyMeshDetail();

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rcFreePolyMeshDetail(this);
    }
    
    private native void rcFreePolyMeshDetail(PolyMeshDetail polyMeshDetail);
      
}
