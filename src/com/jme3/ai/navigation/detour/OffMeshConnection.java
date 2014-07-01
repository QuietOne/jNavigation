package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * Defines an navigation mesh off-mesh connection within a MeshTile object.
 *
 * An off-mesh connection is a user defined traversable connection made up to
 * two vertices.
 *
 * @see MeshTile
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class OffMeshConnection {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public OffMeshConnection() {
        this(RecastJNI.new_dtOffMeshConnection(), true);
    }

    public OffMeshConnection(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(OffMeshConnection obj) {
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
                RecastJNI.delete_dtOffMeshConnection(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     * For a properly built navigation mesh, vertex A will always be within the
     * bounds of the mesh. Vertex B is not required to be within the bounds of
     * the mesh.
     *
     * @param position The endpoints of the connection. [(ax, ay, az, bx, by,
     * bz)].
     */
    public void setPosition(Vector3f[] position) {
        if (position.length != 2) {
            throw new RuntimeException("length of position must be 2");
        }
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtOffMeshConnection_pos_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     * For a properly built navigation mesh, vertex A will always be within the
     * bounds of the mesh. Vertex B is not required to be within the bounds of
     * the mesh.
     *
     * @return The endpoints of the connection. [(ax, ay, az, bx, by, bz)].
     */
    public Vector3f[] getPosition() {
        long cPtr = RecastJNI.dtOffMeshConnection_pos_get(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr, 2);
    }

    /**
     *
     * @param value The radius of the endpoints. [Limit: >= 0].
     */
    public void setRadius(float value) {
        RecastJNI.dtOffMeshConnection_rad_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The radius of the endpoints. [Limit: >= 0].
     */
    public float getRadius() {
        return RecastJNI.dtOffMeshConnection_rad_get(swigCPtr, this);
    }

    /**
     *
     * @param value The polygon reference of the connection within the tile.
     */
    public void setPolygon(int value) {
        RecastJNI.dtOffMeshConnection_poly_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The polygon reference of the connection within the tile.
     */
    public int getPolygon() {
        return RecastJNI.dtOffMeshConnection_poly_get(swigCPtr, this);
    }

    /**
     * These are not the connection's user defined flags. Those are assigned via
     * the connection's Poly definition. These are link flags used for internal
     * purposes.
     *
     * @see Poly
     * @param value Link flags.
     */
    public void setFlags(short value) {
        RecastJNI.dtOffMeshConnection_flags_set(swigCPtr, this, value);
    }

    /**
     * These are not the connection's user defined flags. Those are assigned via
     * the connection's Poly definition. These are link flags used for internal
     * purposes.
     *
     * @see Poly
     * @return Link flags.
     */
    public short getFlags() {
        return RecastJNI.dtOffMeshConnection_flags_get(swigCPtr, this);
    }

    /**
     *
     * @param value End point side.
     */
    public void setSide(short value) {
        RecastJNI.dtOffMeshConnection_side_set(swigCPtr, this, value);
    }

    /**
     *
     * @return End point side.
     */
    public short getSide() {
        return RecastJNI.dtOffMeshConnection_side_get(swigCPtr, this);
    }

    /**
     *
     * @param value The id of the offmesh connection. (User assigned when the
     * navigation mesh is built.)
     */
    public void setUserId(long value) {
        RecastJNI.dtOffMeshConnection_userId_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The id of the offmesh connection. (User assigned when the
     * navigation mesh is built.)
     */
    public long getUserId() {
        return RecastJNI.dtOffMeshConnection_userId_get(swigCPtr, this);
    }
}
