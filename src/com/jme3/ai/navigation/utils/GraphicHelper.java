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
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
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

    static float distancePtLine2d(Vector3f pt, Vector3f p, Vector3f q) {
        float pqx = q.x - p.x;
        float pqz = q.z - p.z;
        float dx = pt.x - p.x;
        float dz = pt.z - p.z;
        float d = pqx * pqx + pqz * pqz;
        float t = pqx * dx + pqz * dz;
        if (d != 0) {
            t /= d;
        }
        dx = p.x + t * pqx - pt.x;
        dz = p.z + t * pqz - pt.z;
        return dx * dx + dz * dz;
    }

    static int bit(int a, int b) {
        return (a & (1 << b)) >> b;
    }

    static ColorRGBA intToColor(int i, int a) {
        int r = bit(i, 1) + bit(i, 3) * 2 + 1;
        int g = bit(i, 2) + bit(i, 4) * 2 + 1;
        int b = bit(i, 0) + bit(i, 5) * 2 + 1;
        return new ColorRGBA(r * 63, g * 63, b * 63, a);
    }

    static Mesh vertex(Mesh mesh, Vector3f vertex, ColorRGBA color) {
        return new Mesh();
    }

    static Mesh mergeMeshes(Mesh mesh1, Mesh mesh2) {
        return mesh1;
    }

    static Vector3f evaluateArc(Vector3f v, Vector3f d, float h, float u) {
        Vector3f result = new Vector3f();
        result.setX(v.getX() + d.getX() * u);
        result.setY(v.getY() + d.getY() * u + h * (1 - (u * 2 - 1) * (u * 2 - 1)));
        result.setZ(v.getZ() + d.getZ() * u);
        return result;
    }

    static Mesh appendArrowHead(Mesh mesh, Vector3f p, Vector3f q, float s, ColorRGBA col) {
        float eps = 0.001f;
        if (p.distance(q) < eps) {
            return mesh;
        }
        Vector3f ax;
        Vector3f ay = new Vector3f(0, 1, 0);
        Vector3f az = q.subtract(p).normalize();
        ax = ay.cross(az);
        //ay = az.cross(ax).normalize();

        mesh = vertex(mesh, p, col);
        Vector3f v = new Vector3f();
        v.setX(p.x + az.x * s + ax.x * s / 3);
        v.setY(p.y + az.y * s + ax.y * s / 3);
        v.setZ(p.z + az.z * s + ax.z * s / 3);
        mesh = vertex(mesh, v, col);

        mesh = vertex(mesh, p, col);
        v.setX(p.x + az.x * s - ax.x * s / 3);
        v.setY(p.y + az.y * s - ax.y * s / 3);
        v.setZ(p.z + az.z * s - ax.z * s / 3);
        mesh = vertex(mesh, v, col);

        return mesh;
    }

    static Mesh appendArc(Mesh mesh, Vector3f v0, Vector3f v1, float h, float as0, float as1, ColorRGBA col) {
        int NUM_ARC_PTS = 8;
        float PAD = 0.05f;
        float ARC_PTS_SCALE = (1.0f - PAD * 2) / (float) NUM_ARC_PTS;
        Vector3f d = v1.subtract(v0);
        float len = d.length();
        Vector3f prev = evaluateArc(v0, d, len * h, PAD);
        for (int i = 0; i <= NUM_ARC_PTS; i++) {
            float u = PAD + i * ARC_PTS_SCALE;
            Vector3f pt = evaluateArc(v0, d, len * h, u);
            mesh = vertex(mesh, prev, col);
            mesh = vertex(mesh, pt, col);
            prev = pt;
        }

        //End arrows
        if (as0 > 0.001f) {
            Vector3f p = evaluateArc(v0, d, len * h, PAD);
            Vector3f q = evaluateArc(v0, d, len * h, PAD + 0.05f);
            mesh = appendArrowHead(mesh, p, q, as0, col);
        }
        if (as1 > 0.001f) {
            Vector3f p = evaluateArc(v0, d, len * h, 1 - PAD);
            Vector3f q = evaluateArc(v0, d, len * h, 1 - (PAD + 0.05f));
            mesh = appendArrowHead(mesh, p, q, as0, col);
        }

        return mesh;
    }

    public static Mesh drawPolyBoundaries(MeshTile tile, ColorRGBA color, float line, boolean inner) {
        Mesh mesh = new Mesh();
        float thr = 0.01f * 0.01f;
        Poly[] polys = tile.getPolys();
        PolyDetail[] details = tile.getDetailMeshes();
        Link[] links = tile.getLinks();
        Vector3f[] tileVertices = tile.getVertices();
        for (int i = 0; i < tile.getHeader().getPolyCount(); i++) {
            Poly p = polys[i];
            if (p.getType() == PolyTypes.DT_POLYTYPE_OFFMESH_CONNECTION.value()) {
                continue;
            }
            short[] neighbours = p.getNeighbours();
            for (int j = 0, nj = (int) p.getVerticesCount(); j < nj; j++) {
                ColorRGBA c = color;
                if (inner) {
                    if (neighbours[j] == 0) {
                        continue;
                    }
                    if ((neighbours[j] & DetourBuilder.EXT_LINK()) != 0) {
                        boolean con = false;
                        long k = p.getFirstLink();
                        while (k != DetourBuilder.NULL_LINK()) {
                            if (links[(int) k].getEdge() == j) {
                                con = true;
                                break;
                            }
                            k = links[(int) k].getNext();
                        }
                        if (con) {
                            c = new ColorRGBA(255, 255, 255, 48);
                        } else {
                            c = new ColorRGBA(0, 0, 0, 48);
                        }
                    } else {
                        c = new ColorRGBA(0, 48, 64, 32);
                    }
                } else {
                    if (neighbours[j] != 0) {
                        continue;
                    }
                }
                Vector3f v0 = tileVertices[p.getVertices()[j]].clone();
                Vector3f v1 = tileVertices[p.getVertices()[(j + 1) % nj]].clone();
                // Draw detail mesh edges which align with the actual poly edge.
                // This is really slow.
                char[] t = tile.getDetailTriangles();
                for (int k = 0; k < details[i].getTriangleCount(); k++) {
                    int beggining = ((int) details[i].getTriangleBase() + k) * 4;
                    Vector3f[] tv = new Vector3f[3];
                    for (int m = 0; m < 3; m++) {
                        if (t[beggining + m] < p.getVerticesCount()) {
                            tv[m] = tileVertices[p.getVertices()[t[beggining + m]]];
                        } else {
                            tv[m] = tile.getDetailVertices()[(int) details[i].getVertBase() + (t[beggining + m] - p.getVerticesCount())];
                        }
                    }
                    for (int m = 0; m < 3; m++) {
                        int n = 2 + m;
                        if (((t[beggining + 3] >> (n * 2)) & 0x3) == 0) { //Skip inner detail edges
                            continue;
                        }
                        if (distancePtLine2d(tv[n], v0, v1) < thr && distancePtLine2d(tv[m], v0, v1) < thr) {
                            mesh = vertex(mesh, tv[n], c);
                            mesh = vertex(mesh, tv[m], c);
                        }
                    }
                }
            }
        }
        return mesh;
    }

    static Mesh appendCircle(Mesh mesh, Vector3f v, float r, ColorRGBA col) {
        int NUM_SEG = 40;
        float[] dir = new float[40 * 2];
        boolean init = false;
        if (!init) {
            init = true;
            for (int i = 0; i < NUM_SEG; i++) {
                float a = (float) i / (float) NUM_SEG * FastMath.TWO_PI;
                dir[i * 2] = FastMath.cos(a);
                dir[i * 2 + 1] = FastMath.sin(a);
            }
        }
        Vector3f ve = new Vector3f();
        ve.setY(v.getY());
        for (int i = 0, j = NUM_SEG - 1; i < NUM_SEG; j = i++) {
            ve.setX(v.getX() + dir[j * 2] * r);
            ve.setZ(v.getZ() + dir[j * 2 + 1] * r);
            mesh = vertex(mesh, ve, col);
            ve.setX(v.getX() + dir[i * 2] * r);
            ve.setZ(v.getZ() + dir[i * 2 + 1] * r);
            mesh = vertex(mesh, ve, col);
        }
        return mesh;
    }

    public static Mesh drawMeshTile(NavMesh navMesh, NavMeshQuery query, MeshTile tile, char flags) {
        Mesh mesh = new Mesh();
        Poly base = navMesh.getPolyRefBase(tile);
        long tileNum = navMesh.decodePolyTile(base);
        Poly[] polys = tile.getPolys();
        PolyDetail[] details = tile.getDetailMeshes();
        Vector3f[] tileVertices = tile.getVertices();
        for (int i = 0; i < tile.getHeader().getPolyCount(); i++) {
            Poly p = polys[i];
            if (p.getType() == PolyTypes.DT_POLYTYPE_OFFMESH_CONNECTION.value()) {//Skip off-mesh links
                continue;
            }
            ColorRGBA color;
            if (query != null && query.isInClosedList(new Poly(Poly.getCPtr(base) | i, false))) {
                color = new ColorRGBA(255, 196, 0, 64);
            } else {
                //flags & DU_DRAWNAVMESH_COLOR_TILES?
                if (flags != '?') {
                    color = intToColor((int) tileNum, 128);
                } else {
                    if (p.getArea() == 0) {//Treat zero area type as default
                        color = new ColorRGBA(0, 192, 255, 64);
                    } else {
                        color = intToColor(p.getArea(), 64);
                    }
                }
            }
            for (int j = 0; j < details[i].getTriangleCount(); j++) {
                char[] t = tile.getDetailTriangles();
                int m = (((int) details[i].getTriangleBase()) + j);
                for (int k = 0; k < 3; k++) {
                    if (t[m + k] < p.getVerticesCount()) {
                        Vector3f v = tileVertices[p.getVertices()[t[m + k]]];
                        mesh = vertex(mesh, v, color);
                    } else {
                        Vector3f v = tile.getDetailVertices()[(int) details[i].getVertBase() + t[m + k] - p.getVerticesCount()];
                        mesh = vertex(mesh, v, color);
                    }

                }

            }
        }
        //adding inter poly boundaries
        Mesh inter = drawPolyBoundaries(tile, new ColorRGBA(0, 48, 64, 32), 1.5f, true);
        mesh = mergeMeshes(mesh, inter);

        //adding outer poly boundaries
        Mesh outer = drawPolyBoundaries(tile, new ColorRGBA(0, 48, 64, 220), 2.5f, false);
        mesh = mergeMeshes(mesh, outer);

        //flags & DU_DRAWNAVMESH_OFFMESHCONS
        if (flags != '!') {
            OffMeshConnection[] connections = tile.getOffMeshConnections();
            //drawing some line
            for (int i = 0; i < tile.getHeader().getPolyCount(); i++) {
                Poly p = polys[i];
                if (p.getType() != PolyTypes.DT_POLYTYPE_OFFMESH_CONNECTION.value()) {
                    continue;
                }
                ColorRGBA color1, color2;
                if (query != null && query.isInClosedList(new Poly(Poly.getCPtr(base) | i, false))) {
                    color1 = new ColorRGBA(255, 196, 0, 220);
                } else {
                    color1 = intToColor(p.getArea(), 220);
                }
                OffMeshConnection con = connections[i - tile.getHeader().getOffMeshBase()];
                Vector3f va = tileVertices[p.getVertices()[0]].clone();
                Vector3f vb = tileVertices[p.getVertices()[1]].clone();

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

                Vector3f[] conPostitions = con.getPosition();

                // End points and their on-mesh locations.
                mesh = vertex(mesh, va, color1);
                mesh = vertex(mesh, conPostitions[0], color1);
                color2 = startSet ? color1 : new ColorRGBA(220, 32, 16, 196);
                Vector3f v1 = conPostitions[0].clone().add(0, 0.1f, 0);
                mesh = appendCircle(mesh, v1, con.getRadius(), color2);

                mesh = vertex(mesh, vb, color1);
                mesh = vertex(mesh, conPostitions[1], color1);
                color2 = endSet ? color1 : new ColorRGBA(220, 32, 16, 196);
                Vector3f v2 = conPostitions[1].clone().add(0, 0.1f, 0);
                mesh = appendCircle(mesh, v2, con.getRadius(), color2);

                // End point vertices.
                mesh = vertex(mesh, conPostitions[0], new ColorRGBA(0, 48, 64, 196));
                v1 = v1.add(0, 0.1f, 0);
                mesh = vertex(mesh, v1, new ColorRGBA(0, 48, 64, 196));
                v2 = v2.add(0, 0.1f, 0);
                mesh = vertex(mesh, conPostitions[1], new ColorRGBA(0, 48, 64, 196));
                mesh = vertex(mesh, v2, new ColorRGBA(0, 48, 64, 196));

                //Connection arcmesh tile corrected
                mesh = appendArc(mesh, conPostitions[0], conPostitions[1], 0.25f, ((con.getFlags() & 1) != 0) ? 0.6f : 0f, 0.6f, color1);
            }
        }

        ColorRGBA vcol = new ColorRGBA(0, 0, 0, 196);
        for (int i = 0; i < tile.getHeader().getVerticesCount() / 3; i++) {
            mesh = vertex(mesh, tileVertices[i], vcol);
        }
        return mesh;
    }

    public static Mesh drawNavMesh(NavMesh navMesh, char flags) {
        Mesh mesh = new Mesh();
        for (int i = 0; i < navMesh.getMaxTiles(); i++) {
            MeshTile tile = navMesh.getTile(i);
            //check if it is supposed to be equal to null
            if (tile.getHeader() != null) {
                Mesh tempMesh = drawMeshTile(navMesh, null, tile, flags);
                mesh = mergeMeshes(mesh, tempMesh);
            }
        }
        return mesh;
    }
}
