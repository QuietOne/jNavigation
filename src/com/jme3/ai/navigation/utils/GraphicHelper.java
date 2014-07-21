package com.jme3.ai.navigation.utils;

import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;

/**
 * Methods for easier debugging drawing, as for extracting data from graphical
 * objects.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class GraphicHelper {

    /**
     * Get vertcices of mesh.
     *
     * @param mesh
     * @return
     */
    public static Vector3f[] getVertices(Mesh mesh) {
        VertexBuffer buffer = mesh.getBuffer(VertexBuffer.Type.Position);
        Vector3f[] array = new Vector3f[buffer.getNumElements()];
        for (int i = 0; i < buffer.getNumElements(); i++) {
            array[i] = new Vector3f();
            array[i].setX((Float) buffer.getElementComponent(i, 0));
            array[i].setY((Float) buffer.getElementComponent(i, 1));
            array[i].setZ((Float) buffer.getElementComponent(i, 2));
        }
        return array;
    }

    /**
     * Get all triangles from mesh
     *
     * @param mesh
     * @return
     */
    public static int[] getIndices(Mesh mesh) {
        int[] indices = new int[3];
        int[] triangles = new int[mesh.getTriangleCount() * 3];
        for (int i = 0; i < triangles.length; i += 3) {
            mesh.getTriangle(i / 3, indices);
            triangles[i] = indices[0];
            triangles[i + 1] = indices[1];
            triangles[i + 2] = indices[2];
        }
        return triangles;
    }

    public static Mesh lineBox(Vector3f min, Vector3f max) {
        Mesh mesh = new Mesh();
        mesh.setMode(Mesh.Mode.Lines);
        Vector3f[] vertices = new Vector3f[]{
            min,
            new Vector3f(min.x, min.y, max.z),
            new Vector3f(min.x, max.y, min.z),
            new Vector3f(max.x, min.y, min.z),
            new Vector3f(max.x, max.y, min.z),
            new Vector3f(max.x, min.y, max.z),
            new Vector3f(min.x, max.y, max.z),
            max
        };
        int[] indices = new int[]{
            0, 1, 0, 2, 0, 3,
            1, 5, 1, 6,
            2, 4, 2, 6,
            3, 4, 3, 5,
            4, 7, 5, 7, 6, 7
        };

        mesh.setBuffer(VertexBuffer.Type.Position,
                3, BufferUtils.createFloatBuffer(vertices));
        mesh.setBuffer(VertexBuffer.Type.Index, 2, BufferUtils.createIntBuffer(indices));
        return mesh;
    }
    
}
