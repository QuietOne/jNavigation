package com.jme3.ai.navigation.utils;

import com.jme3.ai.navigation.detour.DetourBuilder;
import com.jme3.ai.navigation.detour.Link;
import com.jme3.ai.navigation.detour.MeshTile;
import com.jme3.ai.navigation.detour.NavMesh;
import com.jme3.ai.navigation.detour.NavMeshQuery;
import com.jme3.ai.navigation.detour.OffMeshConnection;
import com.jme3.ai.navigation.detour.Poly;
import com.jme3.ai.navigation.detour.PolyDetail;
import com.jme3.ai.navigation.detour.PolyTypes;
import com.jme3.ai.navigation.detour.StraightPathFlags;
import com.jme3.ai.navigation.recast.RecastBuilder;
import com.jme3.math.ColorRGBA;
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

    public static Mesh visulizeMeshTile(NavMesh navMesh, NavMeshQuery query, MeshTile tile, char flags) {
        Poly base = navMesh.getPolyRefBase(tile);
        long tileNum = navMesh.decodePolyTile(base);
        Poly[] polys = tile.getPolys();
        PolyDetail[] details = tile.getDetailMeshes();
        for (int i = 0; i < tile.getHeader().getPolyCount(); i++) {
            Poly p = polys[i];
            if (p.getType() == PolyTypes.DT_POLYTYPE_OFFMESH_CONNECTION.value()) {
                continue;
            }
            ColorRGBA color;
            if (query != null && query.isInClosedList(new Poly(Poly.getCPtr(base) | i, false))) {
                color = ColorRGBA.Red;
            } else {
                //flags & DU_DRAWNAVMESH_COLOR_TILES?
                if (flags != '?') {
                    color = ColorRGBA.Green;
                } else {
                    if (p.getArea() == 0) {
                        color = ColorRGBA.Blue;
                    } else {
                        color = ColorRGBA.Yellow;
                    }
                }
            }
            for (int j = 0; j < details[i].getTriangleCount(); j++) {
                char[] t = tile.getDetailTriangles();
                int m = (((int) details[i].getTriangleBase()) + j);
                for (int k = 0; k < 3; k++) {
                    if (t[m + k] < p.getVerticesCount()) {
                        Vector3f v = tile.getVertices()[p.getVertices()[t[m + k]]];
                    } else {
                        Vector3f v = tile.getDetailVertices()[(int) details[i].getVertBase() + t[m + k] - p.getVerticesCount()];
                    }

                }

            }
        }
        //adding inter poly boundaries
        //adding outer poly boundaries

        //flags & DU_DRAWNAVMESH_OFFMESHCONS
        if (flags == '!') {
            OffMeshConnection[] connections = tile.getOffMeshConnections();
            //drawing some line
            for (int i = 0; i < tile.getHeader().getPolyCount(); i++) {
                Poly p = polys[i];
                if (p.getType() != PolyTypes.DT_POLYTYPE_OFFMESH_CONNECTION.value()) {
                    continue;
                }
                ColorRGBA color1, color2;
                if (query != null && query.isInClosedList(new Poly(Poly.getCPtr(base) | i, false))) {
                    color1 = ColorRGBA.Cyan;
                } else {
                    color1 = ColorRGBA.Brown;
                }
                OffMeshConnection con = connections[i - tile.getHeader().getOffMeshBase()];
                Vector3f a = tile.getVertices()[p.getVertices()[0]];
                Vector3f b = tile.getVertices()[p.getVertices()[1]];

                boolean startSet = false;
                boolean endSet = false;

                long k = p.getFirstLink();
                Link[] links = tile.getLinks();
                while (k != DetourBuilder.NULL_LINK()) {
                    if (links[(int) k].getEdge() == 0) {
                        startSet = true;
                    }
                    if (links[(int) k].getEdge() == 1) {
                        endSet = true;
                    }
                    k = links[(int) k].getNext();
                }

                // End points and their on-mesh locations.
//                vertex(va, col);
//                vertex(con - > pos[0], con - > pos[1], con - > pos[2], col);
//                col2 = startSet ? col : duRGBA(220, 32, 16, 196);
//                duAppendCircle(dd, con - > pos[0], con - > pos[1] + 0.1f, con - > pos[2], con - > rad, col2);
//
//                dd - > vertex(vb[0], vb[1], vb[2], col);
//                dd - > vertex(con - > pos[3], con - > pos[4], con - > pos[5], col);
//                col2 = endSet ? col : duRGBA(220, 32, 16, 196);
//                duAppendCircle(dd, con - > pos[3], con - > pos[4] + 0.1f, con - > pos[5], con - > rad, col2);
//
//                // End point vertices.
//                dd - > vertex(con - > pos[0], con - > pos[1], con - > pos[2], duRGBA(0, 48, 64, 196));
//                dd - > vertex(con - > pos[0], con - > pos[1] + 0.2f, con - > pos[2], duRGBA(0, 48, 64, 196));
//
//                dd - > vertex(con - > pos[3], con - > pos[4], con - > pos[5], duRGBA(0, 48, 64, 196));
//                dd - > vertex(con - > pos[3], con - > pos[4] + 0.2f, con - > pos[5], duRGBA(0, 48, 64, 196));
//
//                // Connection arc.
//                duAppendArc(dd, con - > pos[0], con - > pos[1], con - > pos[2], con - > pos[3], con - > pos[4], con - > pos[5], 0.25f,
//                        (con - > flags & 1) ? 0.6f : 0, 0.6f, col);
            }
        }
        
        ColorRGBA vcol = ColorRGBA.White;
        Vector3f[] vertices = tile.getVertices();
        for (int i = 0; i < tile.getHeader().getVerticesCount(); i++) {
            //add triangle
            //(v[i+0], v[i+1], v[i+2], vcol);
        }

        return null;
    }

    public static Mesh visualizeNavMesh(NavMesh navMesh, char flags) {
        Mesh mesh = new Mesh();
        for (int i = 0; i < navMesh.getMaxTiles(); i++) {
            MeshTile tile = navMesh.getTile(i);
            //check if it is supposed to be equal to null
            if (tile.getHeader() != null) {
                Mesh tempMesh = visulizeMeshTile(navMesh, null, tile, flags);
                //add getting information from one mesh to another
            }
        }
        return mesh;
    }
}
