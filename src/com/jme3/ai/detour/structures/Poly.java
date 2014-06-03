package com.jme3.ai.detour.structures;

import com.jme3.ai.detour.util.Status;

/**
 * Defines a polyogn within a MeshTile object.
 *
 * @author Tihomir Radosavljevic
 */
public class Poly {

    /**
     * Index to first link in linked list. (Or NULL_LINK if there is no link.)
     *
     * @see Status#NULL_LINK
     */
    private int firstLink;
    /**
     * The indices of the polygon's vertices. The actual vertices are located in
     * MeshTile.
     *
     * @see MeshTile#vertices
     */
    private short[] vertices;
    /**
     * Packed data representing neighbour polygons references and flags for each
     * edge.
     *
     * Each entry represents data for the edge starting at the vertex of the
     * same index. E.g. The entry at index n represents the edge data for
     * vertex[n] to vertex[n+1].
     *
     * A value of zero indicates the edge has no polygon connection. (It makes
     * up the border of the navigation mesh.)
     */
    private short[] neighbours;
    /**
     * The user defined polygon flags.
     */
    private short flags;
    /**
     * Area id.
     */
    private char area;
    /**
     * Polygon type.
     */
    private char type;

    public char getType() {
        dtPolyGetType();
        return type;
    }

    private native void dtPolyGetType();

    public void setType(char type) {
        this.type = type;
        dtPolySetType();
    }

    private native void dtPolySetType();

    public char getArea() {
        dtPolyGetArea();
        return area;
    }

    private native void dtPolyGetArea();

    public void setArea(char area) {
        this.area = area;
        dtPolySetArea();
    }

    private native void dtPolySetArea();

    public int getFirstLink() {
        getNativeFirstLink();
        return firstLink;
    }

    private native void getNativeFirstLink();

    public short[] getVertices() {
        getNativeVertices();
        return vertices;
    }

    private native void getNativeVertices();

    public short[] getNeighbours() {
        getNativeNeighbours();
        return neighbours;
    }

    private native void getNativeNeighbours();

    public short getFlags() {
        getNativeFlags();
        return flags;
    }

    private native void getNativeFlags();

    /**
     * A handle to a polygon within a navigation mesh tile.
     *
     * Polygon references are subject to the same invalidate/preserve/restore
     * rules that apply to dtTileRef's. If the dtTileRef for the polygon's tile
     * changes, the polygon reference becomes invalid.
     *
     * Changing a polygon's flags, area id, etc. does not impact its polygon
     * reference.
     */
    public class PolyRef {

        private Object reference;

        private PolyRef() {
        }
    }
}
