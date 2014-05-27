package com.jme3.ai.recast.structures;

import com.jme3.math.Vector3f;

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
     * The mesh triangles. [Size: 4*ntris].
     */
    private char[] triangles;
    /**
     * The mesh vertices. [Size: 3*nverts].
     */
    private Vector3f[] vertices;

    public PolyMeshDetail() {
        reference = rcAllocPolyMeshDetail();
    }
    
    private native Object rcAllocPolyMeshDetail();

    public int[] getMeshes() {
        getNativeMesh();
        return meshes;
    }
    
    private native void getNativeMesh();

    public char[] getTriangles() {
        getNativeTriangles();
        return triangles;
    }
    
    private native void getNativeTriangles();
    
    public Vector3f[] getVertices() {
        getNativeVertices();
        return vertices;
    }
    
    private native void getNativeVertices();
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        rcFreePolyMeshDetail(this);
    }
    
    private native void rcFreePolyMeshDetail(PolyMeshDetail polyMeshDetail);

}
