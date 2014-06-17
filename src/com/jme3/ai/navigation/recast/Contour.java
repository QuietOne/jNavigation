package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;

/**
 * Represents a simple, non-overlapping contour in field space.
 *
 * A contour only exists within the context of a ContourSet object.
 *
 * While the height of the contour's border may vary, the contour will always
 * form a simple polygon when projected onto the xz-plane.
 *
 * @see ContourSet
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Contour {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    /**
     * For internal use only.
     */
    public Contour(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Contour obj) {
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
                RecastJNI.delete_rcContour(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     * The simplified contour is a version of the raw contour with all
     * 'unnecessary' vertices removed. Whether a vertex is considered
     * unnecessary depends on the contour build process.
     *
     * The data format is as follows: (x, y, z, r) * numberOfVertices
     *
     * A contour edge is formed by the current and next vertex. The r-value
     * represents region and connection information for the edge.
     *
     * @param value Simplified contour vertex and connection data. [Size: 4 *
     * numberOfVertices].
     */
    public void setVertices(int[] value) {
        SWIGTYPE_p_int v = Converter.convertToSWIGTYPE_p_int(value);
        RecastJNI.rcContour_verts_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(v));
    }

    /**
     * The simplified contour is a version of the raw contour with all
     * 'unnecessary' vertices removed. Whether a vertex is considered
     * unnecessary depends on the contour build process.
     *
     * The data format is as follows: (x, y, z, r) * numberOfVertices
     *
     * A contour edge is formed by the current and next vertex. The r-value
     * represents region and connection information for the edge.
     *
     * @return Simplified contour vertex and connection data. [Size: 4 *
     * numberOfVertices].
     */
    public int[] getVertices() {
        long cPtr = RecastJNI.rcContour_verts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToInts(cPtr, getNumberOfVertices() * 4);
    }

    /**
     *
     * @param numberOfVertices The number of vertices in the simplified contour.
     */
    public void setNumberOfVertices(int numberOfVertices) {
        RecastJNI.rcContour_nverts_set(swigCPtr, this, numberOfVertices);
    }

    /**
     *
     * @return The number of vertices in the simplified contour.
     */
    public int getNumberOfVertices() {
        return RecastJNI.rcContour_nverts_get(swigCPtr, this);
    }

    /**
     * The simplified contour is a version of the raw contour with all
     * 'unnecessary' vertices removed. Whether a vertex is considered
     * unnecessary depends on the contour build process.
     *
     * The data format is as follows: (x, y, z, r) * numberOfRawVertices
     *
     * A contour edge is formed by the current and next vertex. The r-value
     * represents region and connection information for the edge.
     *
     * @param value Raw contour vertex and connection data. [Size: 4 *
     * numberOfRawVertices].
     */
    public void setRawVertices(int[] value) {
        SWIGTYPE_p_int v = Converter.convertToSWIGTYPE_p_int(value);
        RecastJNI.rcContour_rverts_set(swigCPtr, this, SWIGTYPE_p_int.getCPtr(v));
    }

    /**
     * The simplified contour is a version of the raw contour with all
     * 'unnecessary' vertices removed. Whether a vertex is considered
     * unnecessary depends on the contour build process.
     *
     * The data format is as follows: (x, y, z, r) * numberOfRawVertices
     *
     * A contour edge is formed by the current and next vertex. The r-value
     * represents region and connection information for the edge.
     *
     * @return Raw contour vertex and connection data. [Size: 4 *
     * numberOfRawVertices].
     */
    public int[] getRawVertices() {
        long cPtr = RecastJNI.rcContour_rverts_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToInts(cPtr, getNumberOfRawVertices() * 4);
    }

    /**
     *
     * @param value The number of vertices in the raw contour.
     */
    public void setNumberOfRawVertices(int value) {
        RecastJNI.rcContour_nrverts_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The number of vertices in the raw contour.
     */
    public int getNumberOfRawVertices() {
        return RecastJNI.rcContour_nrverts_get(swigCPtr, this);
    }

    /**
     *
     * @param value The region id of the contour.
     */
    public void setRegionID(int value) {
        RecastJNI.rcContour_reg_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The region id of the contour.
     */
    public int getRegionID() {
        return RecastJNI.rcContour_reg_get(swigCPtr, this);
    }

    /**
     *
     * @param value The area id of the contour.
     */
    public void setArea(short value) {
        RecastJNI.rcContour_area_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The area id of the contour.
     */
    public short getArea() {
        return RecastJNI.rcContour_area_get(swigCPtr, this);
    }
}
