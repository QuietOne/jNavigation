package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;

/**
 * Defines a polygon within a MeshTile object.
 *
 * @see MeshTile
 * @author Tihomir Radosavljevic
 * @version 0.9
 */
public class Poly {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Poly() {
        this(RecastJNI.new_dtPoly(), true);
    }

    public Poly(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Poly obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_dtPoly(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value Index to first link in linked list. (Or DT_NULL_LINK if
     * there is no link.)
     */
    public void setFirstLink(long value) {
        RecastJNI.dtPoly_firstLink_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Index to first link in linked list. (Or DT_NULL_LINK if there is
     * no link.)
     */
    public long getFirstLink() {
        return RecastJNI.dtPoly_firstLink_get(swigCPtr, this);
    }

    /**
     *
     * @param vertices The indices of the polygon's vertices.
     * @see MeshTile#getVertices()
     */
    public void setVertices(short[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.dtPoly_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The indices of the polygon's vertices.
     * @see MeshTile#getVertices()
     */
    public short[] getVertices() {
        long cPtr = RecastJNI.dtPoly_verts_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getVerticesCount());
    }

    /**
     * Note: probably doesn't work as expected
     *
     * @param neighbours Packed data representing neighbor polygons references
     * and flags for each edge.
     *
     * Each entry represents data for the edge starting at the vertex of the
     * same index. E.g. The entry at index n represents the edge data for
     * vertex[n] to vertex[n+1].
     *
     * A value of zero indicates the edge has no polygon connection. (It makes
     * up the border of the navigation mesh.)
     */
    public void setNeighbours(short[] neighbours) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(neighbours);
        RecastJNI.dtPoly_neis_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     * Note: probably doesn't work as expected
     *
     * @return Packed data representing neighbor polygons references and flags
     * for each edge.
     *
     * Each entry represents data for the edge starting at the vertex of the
     * same index. E.g. The entry at index n represents the edge data for
     * vertex[n] to vertex[n+1].
     *
     * A value of zero indicates the edge has no polygon connection. (It makes
     * up the border of the navigation mesh.)
     */
    public short[] getNeighbours() {
        long cPtr = RecastJNI.dtPoly_neis_get(swigCPtr, this);
        //check count
        return (cPtr == 0) ? null : Converter.convertToShorts(cPtr, getVerticesCount());
    }

    /**
     *
     * @param value The user defined polygon flags.
     */
    public void setFlags(int value) {
        RecastJNI.dtPoly_flags_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The user defined polygon flags.
     */
    public int getFlags() {
        return RecastJNI.dtPoly_flags_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of vertices in the polygon.
     */
    public void setVerticesCount(short value) {
        RecastJNI.dtPoly_vertCount_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices in the polygon.
     */
    public short getVerticesCount() {
        return RecastJNI.dtPoly_vertCount_get(swigCPtr, this);
    }

    /**
     * Sets the user defined area id. [Limit: less than DT_MAX_AREAS].
     *
     * @param a
     */
    public void setArea(short a) {
        RecastJNI.dtPoly_setArea(swigCPtr, this, a);
    }

    /**
     * Sets the polygon type
     *
     * @param t
     * @see PolyTypes
     */
    public void setType(short t) {
        RecastJNI.dtPoly_setType(swigCPtr, this, t);
    }

    /**
     * Gets the user defined area id.
     *
     * @return
     */
    public short getArea() {
        return RecastJNI.dtPoly_getArea(swigCPtr, this);
    }

    /**
     * Gets the polygon type.
     *
     * @return
     * @see PolyTypes
     */
    public short getType() {
        return RecastJNI.dtPoly_getType(swigCPtr, this);
    }
}
