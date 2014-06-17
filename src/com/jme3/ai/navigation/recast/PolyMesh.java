package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_short;
import com.jme3.math.Vector3f;

/**
 * Represents a polygon mesh suitable for use in building a navigation mesh.
 *
 * A mesh of potentially overlapping convex polygons of between three and
 * numberOfVerticesPerPoly vertices. The mesh exists within the context of an
 * axis-aligned bounding box (AABB) with vertices laid out in an evenly spaced
 * grid, based on the values of cs and ch.
 *
 * The standard process for building a contour set is to allocate it using
 * constructor, the initialize it using buildPolyMesh
 *
 * @see RecastBuilder
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PolyMesh {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * Allocates a polygon mesh object using the Recast allocator.
     */
    public PolyMesh() {
        swigCPtr = RecastJNI.rcAllocPolyMesh();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public PolyMesh(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PolyMesh obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            delete();
        } finally {
            super.finalize();
        }
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.rcFreePolyMesh(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param vertices The mesh vertices.
     */
    public void setVertices(Vector3f[] vertices) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(vertices);
        RecastJNI.rcPolyMesh_verts_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The mesh vertices.
     */
    public Vector3f[] getVertices() {
        long cPtr = RecastJNI.rcPolyMesh_verts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr, getNumberOfVertices());
    }

    /**
     *
     * @param polygons Polygon and neighbor data. [Length: maxNumberOfPolygons *
     * 2 * numberOfVerticesPerPolygon].
     */
    public void setPolygons(short[] polygons) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(polygons);
        RecastJNI.rcPolyMesh_polys_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return Polygon and neighbor data. [Length: maxNumberOfPolygons * 2 *
     * numberOfVerticesPerPolygon].
     */
    public short[] getPolygons() {
        long cPtr = RecastJNI.rcPolyMesh_polys_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getMaxNumberOfPolygons() * 2 * getNumberOfVerticesPerPolygon());
    }

    /**
     *
     * @param regionIDs The region id assigned to each polygon.
     */
    public void setRegionIDs(short[] regionIDs) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(regionIDs);
        RecastJNI.rcPolyMesh_regs_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The region id assigned to each polygon.
     */
    public short[] getRegionIDs() {
        long cPtr = RecastJNI.rcPolyMesh_regs_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getMaxNumberOfPolygons());
    }

    /**
     *
     * @param flags The user defined flags for each polygon.
     */
    public void setFlags(short[] flags) {
        SWIGTYPE_p_unsigned_short value = Converter.convertToSWIGTYPE_p_unsigned_short(flags);
        RecastJNI.rcPolyMesh_flags_set(swigCPtr, this, SWIGTYPE_p_unsigned_short.getCPtr(value));
    }

    /**
     *
     * @return The user defined flags for each polygon.
     */
    public short[] getFlags() {
        long cPtr = RecastJNI.rcPolyMesh_flags_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToShorts(cPtr, getMaxNumberOfPolygons());
    }

    /**
     *
     * @param areas The area id assigned to each polygon.
     *
     * The standard build process assigns the value of RC_WALKABLE_AREA to all
     * walkable polygons. This value can then be changed to meet user
     * requirements.
     */
    public void setAreas(char[] areas) {
        SWIGTYPE_p_unsigned_char value = Converter.convertToSWIGTYPE_p_unsigned_char(areas);
        RecastJNI.rcPolyMesh_areas_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
    }

    /**
     *
     * @return The area id assigned to each polygon.
     *
     * The standard build process assigns the value of RC_WALKABLE_AREA to all
     * walkable polygons. This value can then be changed to meet user
     * requirements.
     */
    public char[] getAreas() {
        long cPtr = RecastJNI.rcPolyMesh_areas_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToChars(cPtr, getMaxNumberOfPolygons());
    }

    /**
     *
     * @param value The number of vertices.
     */
    public void setNumberOfVertices(int value) {
        RecastJNI.rcPolyMesh_nverts_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices.
     */
    public int getNumberOfVertices() {
        return RecastJNI.rcPolyMesh_nverts_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of polygons.
     */
    public void setNumberOfPolygons(int value) {
        RecastJNI.rcPolyMesh_npolys_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of polygons.
     */
    public int getNumberOfPolygons() {
        return RecastJNI.rcPolyMesh_npolys_get(swigCPtr, this);
    }

    /**
     *
     * @param value The number of allocated polygons.
     */
    public void setMaxNumberOfPolygons(int value) {
        RecastJNI.rcPolyMesh_maxpolys_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of allocated polygons.
     */
    public int getMaxNumberOfPolygons() {
        return RecastJNI.rcPolyMesh_maxpolys_get(swigCPtr, this);
    }

    /**
     *
     * @param value The maximum number of vertices per polygon.
     */
    public void setNumberOfVerticesPerPolygon(int value) {
        RecastJNI.rcPolyMesh_nvp_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The maximum number of vertices per polygon.
     */
    public int getNumberOfVerticesPerPolygon() {
        return RecastJNI.rcPolyMesh_nvp_get(swigCPtr, this);
    }

    /**
     *
     * @param minBounds The minimum bounds in world space.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcPolyMesh_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds in world space.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcPolyMesh_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBounds The maximum bounds in world space.
     */
    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcPolyMesh_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds in world space.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcPolyMesh_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param value The size of each cell. (On the xz-plane.)
     */
    public void setCellSize(float value) {
        RecastJNI.rcPolyMesh_cs_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The size of each cell. (On the xz-plane.)
     */
    public float getCellSize() {
        return RecastJNI.rcPolyMesh_cs_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public void setCellHeight(float value) {
        RecastJNI.rcPolyMesh_ch_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of each cell. (The minimum increment along the
     * y-axis.)
     */
    public float getCellHeight() {
        return RecastJNI.rcPolyMesh_ch_get(swigCPtr, this);
    }

    /**
     *
     * @param value The AABB border size used to generate the source data from
     * which the mesh was derived.
     */
    public void setBorderSize(int value) {
        RecastJNI.rcPolyMesh_borderSize_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The AABB border size used to generate the source data from which
     * the mesh was derived.
     */
    public int getBorderSize() {
        return RecastJNI.rcPolyMesh_borderSize_get(swigCPtr, this);
    }
}
