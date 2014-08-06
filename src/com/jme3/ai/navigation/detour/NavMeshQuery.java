package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.FloatArray;
import com.jme3.ai.navigation.utils.IntArray;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_bool;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_int;
import com.jme3.ai.navigation.utils.UCharArray;
import com.jme3.ai.navigation.utils.UIntArray;
import com.jme3.math.Vector3f;

/**
 * Provides the ability to perform pathfinding related queries against a
 * navigation mesh.
 *
 * For methods that support undersized buffers, if the buffer is too small to
 * hold the entire result set the return status of the method will include the
 * BUFFER_TOO_SMALL flag.
 *
 * Constant member functions can be used by multiple clients without side
 * effects. (E.g. No change to the closed list. No impact on an in-progress
 * sliced path query. Etc.)
 *
 * Walls and portals: A wall is a polygon segment that is considered impassable.
 * A portal is a passable segment between polygons. A portal may be treated as a
 * wall based on the QueryFilter used for a query.
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class NavMeshQuery {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NavMeshQuery() {
        swigCPtr = RecastJNI.dtAllocNavMeshQuery();
        swigCMemOwn = (swigCPtr == 0) ? false : true;
    }

    public NavMeshQuery(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NavMeshQuery obj) {
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
                RecastJNI.dtFreeNavMeshQuery(swigCPtr, this);
            }
            swigCPtr = 0;
        }
    }

    /**
     * Initializes the query object. Must be the first function called after
     * construction, before other functions are used.
     *
     * This function can be used multiple times.
     *
     * @param nav Pointer to the NavMesh object to use for all queries.
     * @param maxNodes Maximum number of search nodes. [Limits: 0 less value
     * less or equal to 65536]
     * @return The status flags for the query.
     */
    public Status init(NavMesh nav, int maxNodes) {
        long status = RecastJNI.dtNavMeshQuery_init(swigCPtr, this, NavMesh.getCPtr(nav), nav, maxNodes);
        return new Status(status);
    }

    /**
     * Finds a path from the start polygon to the end polygon. If the end
     * polygon cannot be reached through the navigation graph, the last polygon
     * in the path will be the nearest the end polygon.
     *
     * If the path array is to small to hold the full result, it will be filled
     * as far as possible from the start polygon toward the end polygon.
     *
     * The start and end positions are used to calculate traversal costs. (The
     * y-values impact the result.)
     *
     * @param startPoly The refrence id of the start polygon.
     * @param endPoly The reference id of the end polygon
     * @param startPosition A position within the start polygon.
     * @param endPosition A position within the end polygon.
     * @param filter The polygon filter to apply to the query.
     * @param maxPath The maximum number of polygons the path array can hold.
     * [Limit: >= 1]
     * @return
     */
    public Status findPathStatus(Poly startPoly, Poly endPoly, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, int maxPath) {
        long startRef = Poly.getCPtr(startPoly);
        long endRef = Poly.getCPtr(endPoly);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int path = new UIntArray(maxPath).cast();
        SWIGTYPE_p_int pathCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_findPath(swigCPtr, this, startRef, endRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
        return new Status(status);
    }

    /**
     * Finds a path from the start polygon to the end polygon. If the end
     * polygon cannot be reached through the navigation graph, the last polygon
     * in the path will be the nearest the end polygon.
     *
     * If the path array is to small to hold the full result, it will be filled
     * as far as possible from the start polygon toward the end polygon.
     *
     * The start and end positions are used to calculate traversal costs. (The
     * y-values impact the result.)
     *
     * @param startPoly The refrence id of the start polygon.
     * @param endPoly The reference id of the end polygon
     * @param startPosition A position within the start polygon.
     * @param endPosition A position within the end polygon.
     * @param filter The polygon filter to apply to the query.
     * @param maxPath The maximum number of polygons the path array can hold.
     * [Limit: >= 1]
     * @return
     */
    public Poly[] findPath(Poly startPoly, Poly endPoly, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, int maxPath) {
        long startRef = Poly.getCPtr(startPoly);
        long endRef = Poly.getCPtr(endPoly);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int path = new UIntArray(maxPath).cast();
        SWIGTYPE_p_int pathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findPath(swigCPtr, this, startRef, endRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
        return Converter.convertToPolys(SWIGTYPE_p_unsigned_int.getCPtr(path), Converter.convertToInt(SWIGTYPE_p_int.getCPtr(pathCount)));
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return The status flags for the query.
     */
    public Status findStraightPathStatus(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath, int options) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath, options);
        return new Status(status);
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return Points describing the straight path.
     */
    public Vector3f[] findStraightPath(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath, int options) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath, options);
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(straightPath), Converter.convertToInt(SWIGTYPE_p_int.getCPtr(straightPathCount)));
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return The reference id of the polygon that is being entered at each
     * point.
     */
    public Poly[] findStraightPathRefs(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath, int options) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath, options);
        return Converter.convertToPolys(straightPathRefs, straightPathCount);
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return Flags describing each point. (See: dtStraightPathFlags)
     */
    public char[] findStraightPathFlags(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath, int options) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_0(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath, options);
        return Converter.convertToChars(straightPathFlags, Converter.convertToInt(SWIGTYPE_p_int.getCPtr(straightPathCount)));
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return The status flags for the query.
     */
    public Status findStraightPathStatus(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath);
        return new Status(status);
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return Points describing the straight path.
     */
    public Vector3f[] findStraightPath(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath);
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(straightPath), Converter.convertToInt(SWIGTYPE_p_int.getCPtr(straightPathCount)));
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return The reference id of the polygon that is being entered at each
     * point.
     */
    public Poly[] findStraightPathRefs(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath);
        return Converter.convertToPolys(straightPathRefs, straightPathCount);
    }

    /**
     * Finds the straight path from the start to the end position within the
     * polygon corridor.
     *
     * This method peforms what is often called 'string pulling'.
     *
     * The start position is clamped to the first polygon in the path, and the
     * end position is clamped to the last. So the start and end positions
     * should normally be within or very near the first and last polygons
     * respectively.
     *
     * The returned polygon references represent the reference id of the polygon
     * that is entered at the associated path position. The reference id
     * associated with the end point will always be zero. This allows, for
     * example, matching off-mesh link points to their representative polygons.
     *
     * If the provided result buffers are too small for the entire result set,
     * they will be filled as far as possible from the start toward the end
     * position.
     *
     * @param startPosition Path start position.
     * @param endPosition Path end position.
     * @param path An array of polygon references that represent the path
     * corridor.
     * @param maxStraightPath The maximum number of points the straight path
     * arrays can hold. [Limit: > 0]
     * @param options Query options. (see: dtStraightPathOptions)
     * @return Flags describing each point. (See: dtStraightPathFlags)
     */
    public char[] findStraightPathFlags(Vector3f startPosition, Vector3f endPosition, Poly[] path, int maxStraightPath) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_unsigned_int paths = Converter.convertToSWIGTYPE_p_unsigned_int(path);
        int pathSize = path.length;
        SWIGTYPE_p_float straightPath = new FloatArray(3 * maxStraightPath).cast();
        SWIGTYPE_p_unsigned_char straightPathFlags = new UCharArray(maxStraightPath).cast();
        SWIGTYPE_p_unsigned_int straightPathRefs = new UIntArray(maxStraightPath).cast();
        SWIGTYPE_p_int straightPathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findStraightPath__SWIG_1(swigCPtr, this, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), SWIGTYPE_p_unsigned_int.getCPtr(paths), pathSize, SWIGTYPE_p_float.getCPtr(straightPath), SWIGTYPE_p_unsigned_char.getCPtr(straightPathFlags), SWIGTYPE_p_unsigned_int.getCPtr(straightPathRefs), SWIGTYPE_p_int.getCPtr(straightPathCount), maxStraightPath);
        return Converter.convertToChars(straightPathFlags, Converter.convertToInt(SWIGTYPE_p_int.getCPtr(straightPathCount)));
    }

    /**
     * Intializes a sliced path query.
     *
     * Warning: Calling any non-slice methods before calling
     * finalizeSlicedFindPath() or finalizeSlicedFindPathPartial() may result in
     * corrupted data! The filter pointer is stored and used for the duration of
     * the sliced path query.
     *
     * @param start The refrence id of the start polygon.
     * @param end The reference id of the end polygon.
     * @param startPosition A position within the start polygon.
     * @param endPosition A position within the end polygon.
     * @param filter The polygon filter to apply to the query.
     * @return The status flags for the query.
     */
    public Status initSlicedFindPath(Poly start, Poly end, Vector3f startPosition, Vector3f endPosition, QueryFilter filter) {
        long startRef = Poly.getCPtr(start);
        long endRef = Poly.getCPtr(end);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        long status = RecastJNI.dtNavMeshQuery_initSlicedFindPath(swigCPtr, this, startRef, endRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter);
        return new Status(status);
    }

    /**
     * Updates an in-progress sliced path query.
     *
     * @param maxIter The maximum number of iterations to perform.
     * @return The status flags for the query.
     */
    public Status updateSlicedFindPath(int maxIter) {
        SWIGTYPE_p_int doneIters = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_updateSlicedFindPath(swigCPtr, this, maxIter, SWIGTYPE_p_int.getCPtr(doneIters));
        return new Status(status);
    }

    /**
     * Finalizes and returns the status of a sliced path query.
     *
     * @param maxPath The max number of polygons the path array can hold.
     * @return The status flags for the query.
     */
    public Status finalizeSlicedFindPathStatus(int maxPath) {
        SWIGTYPE_p_unsigned_int path = new UIntArray(maxPath).cast();
        SWIGTYPE_p_int pathCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_finalizeSlicedFindPath(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
        return new Status(status);
    }

    /**
     * Finalizes and returns the results of a sliced path query.
     *
     * @param maxPath The max number of polygons the path array can hold.
     * @return An ordered list of polygon references representing the path.
     */
    public Poly[] finalizeSlicedFindPath(int maxPath) {
        SWIGTYPE_p_unsigned_int path = new UIntArray(maxPath).cast();
        SWIGTYPE_p_int pathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_finalizeSlicedFindPath(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
        return Converter.convertToPolys(SWIGTYPE_p_unsigned_int.getCPtr(path), Converter.convertToInt(SWIGTYPE_p_int.getCPtr(pathCount)));
    }

    /**
     * Finalizes and returns the results of an incomplete sliced path query,
     * returning the path to the furthest polygon on the existing path that was
     * visited during the search.
     *
     * @param polys An array of polygon references for the existing path.
     * @param maxPath The max number of polygons the path array can hold.
     * [Limit: >= 1]
     * @return The status flags for the query.
     */
    public Status finalizeSlicedFindPathPartialStatus(Poly[] polys, int maxPath) {
        SWIGTYPE_p_unsigned_int existing = Converter.convertToSWIGTYPE_p_unsigned_int(polys);
        int existingSize = polys.length;
        SWIGTYPE_p_unsigned_int path = new UIntArray(maxPath).cast();
        SWIGTYPE_p_int pathCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_finalizeSlicedFindPathPartial(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(existing), existingSize, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
        return new Status(status);
    }

    /**
     * Finalizes and returns the results of an incomplete sliced path query,
     * returning the path to the furthest polygon on the existing path that was
     * visited during the search.
     *
     * @param polys An array of polygon references for the existing path.
     * @param maxPath The max number of polygons the path array can hold.
     * [Limit: >= 1]
     * @return An ordered list of polygon references representing the path.
     * (Start to end.)
     */
    public Poly[] finalizeSlicedFindPathPartial(Poly[] polys, int maxPath) {
        SWIGTYPE_p_unsigned_int existing = Converter.convertToSWIGTYPE_p_unsigned_int(polys);
        int existingSize = polys.length;
        SWIGTYPE_p_unsigned_int path = new UIntArray(maxPath).cast();
        SWIGTYPE_p_int pathCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_finalizeSlicedFindPathPartial(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(existing), existingSize, SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
        return Converter.convertToPolys(existing, pathCount);
    }

    /**
     * Finds the polygons along the navigation graph that touch the specified
     * circle.
     *
     * The order of the result set is from least to highest cost to reach the
     * polygon.
     *
     * A common use case for this method is to perform Dijkstra searches.
     * Candidate polygons are found by searching the graph beginning at the
     * start polygon.
     *
     * If a polygon is not found via the graph search, even if it intersects the
     * search circle, it will not be included in the result set. For example:
     *
     * polyA is the start polygon. polyB shares an edge with polyA. (Is
     * adjacent.) polyC shares an edge with polyB, but not with polyA Even if
     * the search circle overlaps polyC, it will not be included in the result
     * set unless polyB is also in the set.
     *
     * The value of the center point is used as the start position for cost
     * calculations. It is not projected onto the surface of the mesh, so its
     * y-value will effect the costs.
     *
     * Intersection tests occur in 2D. All polygons and the search circle are
     * projected onto the xz-plane. So the y-value of the center point does not
     * effect intersection tests.
     *
     * If the result arrays are to small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param startPosition The center of the search circle.
     * @param radius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The status flags for the query.
     */
    public Status findPolysAroundCircleStatus(Poly start, Vector3f startPosition, float radius, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_float resultCost = new FloatArray(1).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_findPolysAroundCircle(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return new Status(status);
    }

    /**
     * Finds the polygons along the navigation graph that touch the specified
     * circle.
     *
     * The order of the result set is from least to highest cost to reach the
     * polygon.
     *
     * A common use case for this method is to perform Dijkstra searches.
     * Candidate polygons are found by searching the graph beginning at the
     * start polygon.
     *
     * If a polygon is not found via the graph search, even if it intersects the
     * search circle, it will not be included in the result set. For example:
     *
     * polyA is the start polygon. polyB shares an edge with polyA. (Is
     * adjacent.) polyC shares an edge with polyB, but not with polyA Even if
     * the search circle overlaps polyC, it will not be included in the result
     * set unless polyB is also in the set.
     *
     * The value of the center point is used as the start position for cost
     * calculations. It is not projected onto the surface of the mesh, so its
     * y-value will effect the costs.
     *
     * Intersection tests occur in 2D. All polygons and the search circle are
     * projected onto the xz-plane. So the y-value of the center point does not
     * effect intersection tests.
     *
     * If the result arrays are to small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param startPosition The center of the search circle.
     * @param radius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The reference ids of the polygons touched by the circle.
     */
    public Poly[] findPolysAroundCircle(Poly start, Vector3f startPosition, float radius, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_float resultCost = new FloatArray(1).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findPolysAroundCircle(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return Converter.convertToPolys(resultRef, resultCount);
    }

    /**
     * Finds the polygons along the navigation graph that touch the specified
     * circle.
     *
     * The order of the result set is from least to highest cost to reach the
     * polygon.
     *
     * A common use case for this method is to perform Dijkstra searches.
     * Candidate polygons are found by searching the graph beginning at the
     * start polygon.
     *
     * If a polygon is not found via the graph search, even if it intersects the
     * search circle, it will not be included in the result set. For example:
     *
     * polyA is the start polygon. polyB shares an edge with polyA. (Is
     * adjacent.) polyC shares an edge with polyB, but not with polyA Even if
     * the search circle overlaps polyC, it will not be included in the result
     * set unless polyB is also in the set.
     *
     * The value of the center point is used as the start position for cost
     * calculations. It is not projected onto the surface of the mesh, so its
     * y-value will effect the costs.
     *
     * Intersection tests occur in 2D. All polygons and the search circle are
     * projected onto the xz-plane. So the y-value of the center point does not
     * effect intersection tests.
     *
     * If the result arrays are to small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param startPosition The center of the search circle.
     * @param radius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The reference ids of the parent polygons for each result.
     */
    public Poly[] findPolysAroundCircleParentRef(Poly start, Vector3f startPosition, float radius, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_float resultCost = new FloatArray(1).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findPolysAroundCircle(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return Converter.convertToPolys(resultParent, maxResult);
    }

    /**
     * Finds the polygons along the naviation graph that touch the specified
     * convex polygon.
     *
     * The order of the result set is from least to highest cost.
     *
     * At least one result array must be provided.
     *
     * A common use case for this method is to perform Dijkstra searches.
     * Candidate polygons are found by searching the graph beginning at the
     * start polygon.
     *
     * The same intersection test restrictions that apply to
     * findPolysAroundCircle() method apply to this method.
     *
     * The 3D centroid of the search polygon is used as the start position for
     * cost calculations.
     *
     * Intersection tests occur in 2D. All polygons are projected onto the
     * xz-plane. So the y-values of the vertices do not effect intersection
     * tests.
     *
     * If the result arrays are is too small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param vertices The vertices describing the convex polygon. (CCW)
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The status flags for the query.
     */
    public Status findPolysAroundShapeStatus(Poly start, Vector3f[] vertices, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_float resultCost = new FloatArray(1).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_findPolysAroundShape(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(verts), nverts, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return new Status(status);
    }

    /**
     * Finds the polygons along the naviation graph that touch the specified
     * convex polygon.
     *
     * The order of the result set is from least to highest cost.
     *
     * At least one result array must be provided.
     *
     * A common use case for this method is to perform Dijkstra searches.
     * Candidate polygons are found by searching the graph beginning at the
     * start polygon.
     *
     * The same intersection test restrictions that apply to
     * findPolysAroundCircle() method apply to this method.
     *
     * The 3D centroid of the search polygon is used as the start position for
     * cost calculations.
     *
     * Intersection tests occur in 2D. All polygons are projected onto the
     * xz-plane. So the y-values of the vertices do not effect intersection
     * tests.
     *
     * If the result arrays are is too small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param vertices The vertices describing the convex polygon. (CCW)
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The reference ids of the polygons touched by the search polygon.
     */
    public Poly[] findPolysAroundShape(Poly start, Vector3f[] vertices, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_float resultCost = new FloatArray(1).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findPolysAroundShape(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(verts), nverts, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return Converter.convertToPolys(resultRef, resultCount);
    }

    /**
     * Finds the polygons along the naviation graph that touch the specified
     * convex polygon.
     *
     * The order of the result set is from least to highest cost.
     *
     * At least one result array must be provided.
     *
     * A common use case for this method is to perform Dijkstra searches.
     * Candidate polygons are found by searching the graph beginning at the
     * start polygon.
     *
     * The same intersection test restrictions that apply to
     * findPolysAroundCircle() method apply to this method.
     *
     * The 3D centroid of the search polygon is used as the start position for
     * cost calculations.
     *
     * Intersection tests occur in 2D. All polygons are projected onto the
     * xz-plane. So the y-values of the vertices do not effect intersection
     * tests.
     *
     * If the result arrays are is too small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param vertices The vertices describing the convex polygon. (CCW)
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The reference ids of the parent polygons for each result.
     */
    public Poly[] findPolysAroundShapeParentRef(Poly start, Vector3f[] vertices, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float verts = Converter.convertToSWIGTYPE_p_float(vertices);
        int nverts = vertices.length;
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_float resultCost = new FloatArray(1).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findPolysAroundShape(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(verts), nverts, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_float.getCPtr(resultCost), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return Converter.convertToPolys(resultParent, resultCount);
    }

    /**
     * Finds the polygon nearest to the specified center point.
     *
     * Note: If the search box does not intersect any polygons the search will
     * return DT_SUCCESS, but nearestRef will be zero. So if in doubt, check
     * nearestRef before using nearestPt.
     *
     * Warning: This function is not suitable for large area searches. If the
     * search extents overlaps more than 128 polygons it may return an invalid
     * result.
     *
     * @param center The center of the search box.
     * @param extent The search distance along each axis.
     * @param filter The polygon filter to apply to the query.
     * @return The status flags for the query.
     *
     */
    public Status findNearestPolyStatus(Vector3f center, Vector3f extent, QueryFilter filter) {
        SWIGTYPE_p_float cen = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float extents = Converter.convertToSWIGTYPE_p_float(extent);
        SWIGTYPE_p_unsigned_int nearestRef = new UIntArray(1).cast();
        SWIGTYPE_p_float nearestPt = new FloatArray(3).cast();
        long status = RecastJNI.dtNavMeshQuery_findNearestPoly(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cen), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(nearestRef), SWIGTYPE_p_float.getCPtr(nearestPt));
        return new Status(status);
    }

    /**
     * Finds the polygon nearest to the specified center point.
     *
     * Note: If the search box does not intersect any polygons the search will
     * return DT_SUCCESS, but nearestRef will be zero. So if in doubt, check
     * nearestRef before using nearestPt.
     *
     * Warning: This function is not suitable for large area searches. If the
     * search extents overlaps more than 128 polygons it may return an invalid
     * result.
     *
     * @param center The center of the search box.
     * @param extent The search distance along each axis.
     * @param filter The polygon filter to apply to the query.
     * @return The reference id of the nearest polygon.
     *
     */
    public Poly findNearestPoly(Vector3f center, Vector3f extent, QueryFilter filter) {
        SWIGTYPE_p_float cen = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float extents = Converter.convertToSWIGTYPE_p_float(extent);
        SWIGTYPE_p_unsigned_int nearestRef = new UIntArray(1).cast();
        SWIGTYPE_p_float nearestPt = new FloatArray(3).cast();
        RecastJNI.dtNavMeshQuery_findNearestPoly(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cen), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(nearestRef), SWIGTYPE_p_float.getCPtr(nearestPt));
        return new Poly(SWIGTYPE_p_unsigned_int.getCPtr(nearestRef), false);
    }

    /**
     * Finds the polygon nearest to the specified center point.
     *
     * Note: If the search box does not intersect any polygons the search will
     * return DT_SUCCESS, but nearestRef will be zero. So if in doubt, check
     * nearestRef before using nearestPt.
     *
     * Warning: This function is not suitable for large area searches. If the
     * search extents overlaps more than 128 polygons it may return an invalid
     * result.
     *
     * @param center The center of the search box.
     * @param extent The search distance along each axis.
     * @param filter The polygon filter to apply to the query.
     * @return The nearest point on the polygon.
     *
     */
    public Vector3f findNearestPolyPoint(Vector3f center, Vector3f extent, QueryFilter filter) {
        SWIGTYPE_p_float cen = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float extents = Converter.convertToSWIGTYPE_p_float(extent);
        SWIGTYPE_p_unsigned_int nearestRef = new UIntArray(1).cast();
        SWIGTYPE_p_float nearestPt = new FloatArray(3).cast();
        RecastJNI.dtNavMeshQuery_findNearestPoly(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cen), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(nearestRef), SWIGTYPE_p_float.getCPtr(nearestPt));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(nearestPt));
    }

    /**
     * Finds polygons that overlap the search box. If no polygons are found, the
     * function will return DT_SUCCESS with a polyCount of zero.
     *
     * If polys is too small to hold the entire result set, then the array will
     * be filled to capacity. The method of choosing which polygons from the
     * full set are included in the partial result set is undefined.
     *
     * @param center The center of the search box.
     * @param extent The search distance along each axis.
     * @param filter The polygon filter to apply to the query.
     * @param maxPolys The maximum number of polygons the search result can
     * hold.
     * @return The status flags for the query.
     */
    public Status queryPolygonsStatus(Vector3f center, Vector3f extent, QueryFilter filter, int maxPolys) {
        SWIGTYPE_p_float cen = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float extents = Converter.convertToSWIGTYPE_p_float(extent);
        SWIGTYPE_p_unsigned_int polys = new UIntArray(maxPolys).cast();
        SWIGTYPE_p_int polyCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_queryPolygons(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cen), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(polys), SWIGTYPE_p_int.getCPtr(polyCount), maxPolys);
        return new Status(status);
    }

    /**
     * Finds polygons that overlap the search box. If no polygons are found, the
     * function will return DT_SUCCESS with a polyCount of zero.
     *
     * If polys is too small to hold the entire result set, then the array will
     * be filled to capacity. The method of choosing which polygons from the
     * full set are included in the partial result set is undefined.
     *
     * @param center The center of the search box.
     * @param extent The search distance along each axis.
     * @param filter The polygon filter to apply to the query.
     * @param maxPolys The maximum number of polygons the search result can
     * hold.
     * @return The reference ids of the polygons that overlap the query box.
     */
    public Poly[] queryPolygons(Vector3f center, Vector3f extent, QueryFilter filter, int maxPolys) {
        SWIGTYPE_p_float cen = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float extents = Converter.convertToSWIGTYPE_p_float(extent);
        SWIGTYPE_p_unsigned_int polys = new UIntArray(maxPolys).cast();
        SWIGTYPE_p_int polyCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_queryPolygons(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cen), SWIGTYPE_p_float.getCPtr(extents), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(polys), SWIGTYPE_p_int.getCPtr(polyCount), maxPolys);
        return Converter.convertToPolys(polys, polyCount);
    }

    /**
     * Finds the non-overlapping navigation polygons in the local neighbourhood
     * around the center position. This method is optimized for a small search
     * radius and small number of result polygons.
     *
     * Candidate polygons are found by searching the navigation graph beginning
     * at the start polygon.
     *
     * The same intersection test restrictions that apply to the
     * findPolysAroundCircle mehtod applies to this method.
     *
     * The value of the center point is used as the start point for cost
     * calculations. It is not projected onto the surface of the mesh, so its
     * y-value will effect the costs.
     *
     * Intersection tests occur in 2D. All polygons and the search circle are
     * projected onto the xz-plane. So the y-value of the center point does not
     * effect intersection tests.
     *
     * If the result arrays are is too small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param center The center of the query circle.
     * @param radius The radius of the query circle.
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The status flags for the query.
     */
    public Status findLocalNeighbourhoodStatus(Poly start, Vector3f center, float radius, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_findLocalNeighbourhood(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return new Status(status);
    }

    /**
     * Finds the non-overlapping navigation polygons in the local neighbourhood
     * around the center position. This method is optimized for a small search
     * radius and small number of result polygons.
     *
     * Candidate polygons are found by searching the navigation graph beginning
     * at the start polygon.
     *
     * The same intersection test restrictions that apply to the
     * findPolysAroundCircle mehtod applies to this method.
     *
     * The value of the center point is used as the start point for cost
     * calculations. It is not projected onto the surface of the mesh, so its
     * y-value will effect the costs.
     *
     * Intersection tests occur in 2D. All polygons and the search circle are
     * projected onto the xz-plane. So the y-value of the center point does not
     * effect intersection tests.
     *
     * If the result arrays are is too small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param center The center of the query circle.
     * @param radius The radius of the query circle.
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The reference ids of the polygons touched by the circle.
     */
    public Poly[] findLocalNeighbourhood(Poly start, Vector3f center, float radius, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findLocalNeighbourhood(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return Converter.convertToPolys(resultRef, resultCount);
    }

    /**
     * Finds the non-overlapping navigation polygons in the local neighbourhood
     * around the center position. This method is optimized for a small search
     * radius and small number of result polygons.
     *
     * Candidate polygons are found by searching the navigation graph beginning
     * at the start polygon.
     *
     * The same intersection test restrictions that apply to the
     * findPolysAroundCircle mehtod applies to this method.
     *
     * The value of the center point is used as the start point for cost
     * calculations. It is not projected onto the surface of the mesh, so its
     * y-value will effect the costs.
     *
     * Intersection tests occur in 2D. All polygons and the search circle are
     * projected onto the xz-plane. So the y-value of the center point does not
     * effect intersection tests.
     *
     * If the result arrays are is too small to hold the entire result set, they
     * will be filled to capacity.
     *
     * @param start The reference id of the polygon where the search starts.
     * @param center The center of the query circle.
     * @param radius The radius of the query circle.
     * @param filter The polygon filter to apply to the query.
     * @param maxResult The maximum number of polygons the result arrays can
     * hold.
     * @return The reference ids of the parent polygons for each result.
     */
    public Poly[] findLocalNeighbourhoodParentRef(Poly start, Vector3f center, float radius, QueryFilter filter, int maxResult) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_unsigned_int resultRef = new UIntArray(maxResult).cast();
        SWIGTYPE_p_unsigned_int resultParent = new UIntArray(maxResult).cast();
        SWIGTYPE_p_int resultCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_findLocalNeighbourhood(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), radius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_unsigned_int.getCPtr(resultRef), SWIGTYPE_p_unsigned_int.getCPtr(resultParent), SWIGTYPE_p_int.getCPtr(resultCount), maxResult);
        return Converter.convertToPolys(resultParent, resultCount);
    }

    /**
     * Moves from the start to the end position constrained to the navigation
     * mesh.
     *
     * This method is optimized for small delta movement and a small number of
     * polygons. If used for too great a distance, the result set will form an
     * incomplete path.
     *
     * resultPos will equal the endPos if the end is reached. Otherwise the
     * closest reachable position will be returned.
     *
     * resultPos is not projected onto the surface of the navigation mesh. Use
     * getPolyHeight if this is needed.
     *
     * This method treats the end position in the same manner as the raycast
     * method. (As a 2D point.) See that method's documentation for details.
     *
     * If the visited array is too small to hold the entire result set, it will
     * be filled as far as possible from the start position toward the end
     * position.
     *
     * @param start The reference id of the start polygon.
     * @param startPosition A position of the mover within the start polygon.
     * @param endPosition The desired end position of the mover.
     * @param filter The polygon filter to apply to the query.
     * @param maxVisitedSize The maximum number of polygons the visited array
     * can hold.
     * @return The status flags for the query.
     */
    public Status moveAlongSurfaceStatus(Poly start, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, int maxVisitedSize) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_float resultPos = new FloatArray(3).cast();
        SWIGTYPE_p_unsigned_int visited = new UIntArray(maxVisitedSize).cast();
        SWIGTYPE_p_int visitedCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_moveAlongSurface(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(resultPos), SWIGTYPE_p_unsigned_int.getCPtr(visited), SWIGTYPE_p_int.getCPtr(visitedCount), maxVisitedSize);
        return new Status(status);
    }

    /**
     * Moves from the start to the end position constrained to the navigation
     * mesh.
     *
     * This method is optimized for small delta movement and a small number of
     * polygons. If used for too great a distance, the result set will form an
     * incomplete path.
     *
     * resultPos will equal the endPos if the end is reached. Otherwise the
     * closest reachable position will be returned.
     *
     * resultPos is not projected onto the surface of the navigation mesh. Use
     * getPolyHeight if this is needed.
     *
     * This method treats the end position in the same manner as the raycast
     * method. (As a 2D point.) See that method's documentation for details.
     *
     * If the visited array is too small to hold the entire result set, it will
     * be filled as far as possible from the start position toward the end
     * position.
     *
     * @param start The reference id of the start polygon.
     * @param startPosition A position of the mover within the start polygon.
     * @param endPosition The desired end position of the mover.
     * @param filter The polygon filter to apply to the query.
     * @param maxVisitedSize The maximum number of polygons the visited array
     * can hold.
     * @return The result position of the mover.
     */
    public Vector3f moveAlongSurfaceResultPosition(Poly start, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, int maxVisitedSize) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_float resultPos = new FloatArray(3).cast();
        SWIGTYPE_p_unsigned_int visited = new UIntArray(maxVisitedSize).cast();
        SWIGTYPE_p_int visitedCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_moveAlongSurface(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(resultPos), SWIGTYPE_p_unsigned_int.getCPtr(visited), SWIGTYPE_p_int.getCPtr(visitedCount), maxVisitedSize);
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(resultPos));
    }

    /**
     * Moves from the start to the end position constrained to the navigation
     * mesh.
     *
     * This method is optimized for small delta movement and a small number of
     * polygons. If used for too great a distance, the result set will form an
     * incomplete path.
     *
     * resultPos will equal the endPos if the end is reached. Otherwise the
     * closest reachable position will be returned.
     *
     * resultPos is not projected onto the surface of the navigation mesh. Use
     * getPolyHeight if this is needed.
     *
     * This method treats the end position in the same manner as the raycast
     * method. (As a 2D point.) See that method's documentation for details.
     *
     * If the visited array is too small to hold the entire result set, it will
     * be filled as far as possible from the start position toward the end
     * position.
     *
     * @param start The reference id of the start polygon.
     * @param startPosition A position of the mover within the start polygon.
     * @param endPosition The desired end position of the mover.
     * @param filter The polygon filter to apply to the query.
     * @param maxVisitedSize The maximum number of polygons the visited array
     * can hold.
     * @return The reference ids of the polygons visited during the move.
     */
    public Poly[] moveAlongSurfaceVisited(Poly start, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, int maxVisitedSize) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        SWIGTYPE_p_float resultPos = new FloatArray(3).cast();
        SWIGTYPE_p_unsigned_int visited = new UIntArray(maxVisitedSize).cast();
        SWIGTYPE_p_int visitedCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_moveAlongSurface(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(resultPos), SWIGTYPE_p_unsigned_int.getCPtr(visited), SWIGTYPE_p_int.getCPtr(visitedCount), maxVisitedSize);
        return Converter.convertToPolys(visited, visitedCount);
    }
    /*
     * Not fixed, because I wanted to see if there is something similiar to it in jME already.
     public long raycast(long startRef, SWIGTYPE_p_float startPos, SWIGTYPE_p_float endPos, QueryFilter filter, SWIGTYPE_p_float t, SWIGTYPE_p_float hitNormal, SWIGTYPE_p_unsigned_int path, SWIGTYPE_p_int pathCount, int maxPath) {
     return RecastJNI.dtNavMeshQuery_raycast(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(t), SWIGTYPE_p_float.getCPtr(hitNormal), SWIGTYPE_p_unsigned_int.getCPtr(path), SWIGTYPE_p_int.getCPtr(pathCount), maxPath);
     }
     */

    /**
     * Finds the distance from the specified position to the nearest polygon
     * wall.
     *
     * @param start The reference id of the polygon containing center.
     * @param center The center of the search circle.
     * @param maxRadius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @return The status flags for the query.
     */
    public Status findDistanceToWallStatus(Poly start, Vector3f center, float maxRadius, QueryFilter filter) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float hitDist = new FloatArray(1).cast();
        SWIGTYPE_p_float hitPos = new FloatArray(3).cast();
        SWIGTYPE_p_float hitNormal = new FloatArray(3).cast();
        long status = RecastJNI.dtNavMeshQuery_findDistanceToWall(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(hitDist), SWIGTYPE_p_float.getCPtr(hitPos), SWIGTYPE_p_float.getCPtr(hitNormal));
        return new Status(status);
    }

    /**
     * Finds the distance from the specified position to the nearest polygon
     * wall.
     *
     * @param start The reference id of the polygon containing center.
     * @param center The center of the search circle.
     * @param maxRadius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @return The distance to the nearest wall from center.
     */
    public float findDistanceToWall(Poly start, Vector3f center, float maxRadius, QueryFilter filter) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float hitDist = new FloatArray(1).cast();
        SWIGTYPE_p_float hitPos = new FloatArray(3).cast();
        SWIGTYPE_p_float hitNormal = new FloatArray(3).cast();
        RecastJNI.dtNavMeshQuery_findDistanceToWall(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(hitDist), SWIGTYPE_p_float.getCPtr(hitPos), SWIGTYPE_p_float.getCPtr(hitNormal));
        return Converter.convertToFloat(SWIGTYPE_p_float.getCPtr(hitDist));
    }

    /**
     * Finds the distance from the specified position to the nearest polygon
     * wall.
     *
     * @param start The reference id of the polygon containing center.
     * @param center The center of the search circle.
     * @param maxRadius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @return The nearest position on the wall that was hit. It will equal the
     * search radius if there is no wall within the radius.
     */
    public Vector3f findDistancePositionToWall(Poly start, Vector3f center, float maxRadius, QueryFilter filter) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float hitDist = new FloatArray(1).cast();
        SWIGTYPE_p_float hitPos = new FloatArray(3).cast();
        SWIGTYPE_p_float hitNormal = new FloatArray(3).cast();
        RecastJNI.dtNavMeshQuery_findDistanceToWall(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(hitDist), SWIGTYPE_p_float.getCPtr(hitPos), SWIGTYPE_p_float.getCPtr(hitNormal));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(hitPos));
    }

    /**
     * Finds the distance from the specified position to the nearest polygon
     * wall.
     *
     * @param start The reference id of the polygon containing center.
     * @param center The center of the search circle.
     * @param maxRadius The radius of the search circle.
     * @param filter The polygon filter to apply to the query.
     * @return The normalized ray formed from the wall point to the source
     * point.
     */
    public Vector3f findDistanceNormalToWall(Poly start, Vector3f center, float maxRadius, QueryFilter filter) {
        long startRef = Poly.getCPtr(start);
        SWIGTYPE_p_float centerPos = Converter.convertToSWIGTYPE_p_float(center);
        SWIGTYPE_p_float hitDist = new FloatArray(1).cast();
        SWIGTYPE_p_float hitPos = new FloatArray(3).cast();
        SWIGTYPE_p_float hitNormal = new FloatArray(3).cast();
        RecastJNI.dtNavMeshQuery_findDistanceToWall(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(hitDist), SWIGTYPE_p_float.getCPtr(hitPos), SWIGTYPE_p_float.getCPtr(hitNormal));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(hitNormal));
    }

    /**
     * Returns the segments for the specified polygon, optionally including
     * portals.
     *
     * If the segmentRefs parameter is provided, then all polygon segments will
     * be returned. Otherwise only the wall segments are returned.
     *
     * A segment that is normally a portal will be included in the result set as
     * a wall if the filter results in the neighbor polygon becoomming
     * impassable.
     *
     * The segmentVerts and segmentRefs buffers should normally be sized for the
     * maximum segments per polygon of the source navigation mesh.
     *
     * @param poly The reference id of the polygon.
     * @param filter The polygon filter to apply to the query.
     * @param maxSegments The maximum number of segments the result arrays can
     * hold.
     * @return The status flags for the query.
     */
    public Status getPolyWallSegmentsStatus(Poly poly, QueryFilter filter, int maxSegments) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float segmentVerts = new FloatArray(maxSegments * 6).cast();
        SWIGTYPE_p_unsigned_int segmentRefs = new UIntArray(maxSegments).cast();
        SWIGTYPE_p_int segmentCount = new IntArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_getPolyWallSegments(swigCPtr, this, ref, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(segmentVerts), SWIGTYPE_p_unsigned_int.getCPtr(segmentRefs), SWIGTYPE_p_int.getCPtr(segmentCount), maxSegments);
        return new Status(status);
    }

    /**
     * Returns the segments for the specified polygon, optionally including
     * portals.
     *
     * If the segmentRefs parameter is provided, then all polygon segments will
     * be returned. Otherwise only the wall segments are returned.
     *
     * A segment that is normally a portal will be included in the result set as
     * a wall if the filter results in the neighbor polygon becoomming
     * impassable.
     *
     * The segmentVerts and segmentRefs buffers should normally be sized for the
     * maximum segments per polygon of the source navigation mesh.
     *
     * @param poly The reference id of the polygon.
     * @param filter The polygon filter to apply to the query.
     * @param maxSegments The maximum number of segments the result arrays can
     * hold.
     * @return The segments. [(ax, ay, az, bx, by, bz)]
     */
    public Vector3f[] getPolyWallSegments(Poly poly, QueryFilter filter, int maxSegments) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float segmentVerts = new FloatArray(maxSegments * 6).cast();
        SWIGTYPE_p_unsigned_int segmentRefs = new UIntArray(maxSegments).cast();
        SWIGTYPE_p_int segmentCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_getPolyWallSegments(swigCPtr, this, ref, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(segmentVerts), SWIGTYPE_p_unsigned_int.getCPtr(segmentRefs), SWIGTYPE_p_int.getCPtr(segmentCount), maxSegments);
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(segmentVerts), maxSegments * 2);
    }

    /**
     * Returns the segments for the specified polygon, optionally including
     * portals.
     *
     * If the segmentRefs parameter is provided, then all polygon segments will
     * be returned. Otherwise only the wall segments are returned.
     *
     * A segment that is normally a portal will be included in the result set as
     * a wall if the filter results in the neighbor polygon becoomming
     * impassable.
     *
     * The segmentVerts and segmentRefs buffers should normally be sized for the
     * maximum segments per polygon of the source navigation mesh.
     *
     * @param poly The reference id of the polygon.
     * @param filter The polygon filter to apply to the query.
     * @param maxSegments The maximum number of segments the result arrays can
     * hold.
     * @return The reference ids of each segment's neighbor polygon. Or zero if
     * the segment is a wall.
     */
    public Poly[] getPolyWallSegmentsPoly(Poly poly, QueryFilter filter, int maxSegments) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float segmentVerts = new FloatArray(maxSegments * 6).cast();
        SWIGTYPE_p_unsigned_int segmentRefs = new UIntArray(maxSegments).cast();
        SWIGTYPE_p_int segmentCount = new IntArray(1).cast();
        RecastJNI.dtNavMeshQuery_getPolyWallSegments(swigCPtr, this, ref, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_float.getCPtr(segmentVerts), SWIGTYPE_p_unsigned_int.getCPtr(segmentRefs), SWIGTYPE_p_int.getCPtr(segmentCount), maxSegments);
        return Converter.convertToPolys(segmentRefs, segmentCount);
    }

    /*
     * needs to fix random function importer
     public Status findRandomPoint(QueryFilter filter, SWIGTYPE_p_f___float frand, SWIGTYPE_p_unsigned_int randomRef, SWIGTYPE_p_float randomPt) {
     long status = RecastJNI.dtNavMeshQuery_findRandomPoint(swigCPtr, this, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_f___float.getCPtr(frand), SWIGTYPE_p_unsigned_int.getCPtr(randomRef), SWIGTYPE_p_float.getCPtr(randomPt));
     return new Status(status);
     }

     public long findRandomPointAroundCircle(long startRef, SWIGTYPE_p_float centerPos, float maxRadius, QueryFilter filter, SWIGTYPE_p_f___float frand, SWIGTYPE_p_unsigned_int randomRef, SWIGTYPE_p_float randomPt) {
     return RecastJNI.dtNavMeshQuery_findRandomPointAroundCircle(swigCPtr, this, startRef, SWIGTYPE_p_float.getCPtr(centerPos), maxRadius, QueryFilter.getCPtr(filter), filter, SWIGTYPE_p_f___float.getCPtr(frand), SWIGTYPE_p_unsigned_int.getCPtr(randomRef), SWIGTYPE_p_float.getCPtr(randomPt));
     }*/
    /**
     * Finds the closest point on the specified polygon. Uses the detail
     * polygons to find the surface height. (Most accurate.)
     *
     * position does not have to be within the bounds of the polygon or
     * navigation mesh.
     *
     * @param poly The reference id of the polygon.
     * @param position The position to check.
     * @return The status flags for the query.
     */
    public Status closestPointOnPolyStatus(Poly poly, Vector3f position) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_float closest = new FloatArray(3).cast();
        SWIGTYPE_p_bool posOverPoly = new SWIGTYPE_p_bool();
        long status = RecastJNI.dtNavMeshQuery_closestPointOnPoly(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(closest), SWIGTYPE_p_bool.getCPtr(posOverPoly));
        return new Status(status);
    }

    /**
     * Finds the closest point on the specified polygon. Uses the detail
     * polygons to find the surface height. (Most accurate.)
     *
     * position does not have to be within the bounds of the polygon or
     * navigation mesh.
     *
     * @param poly The reference id of the polygon.
     * @param position The position to check.
     * @return The closest point on the polygon.
     */
    public Vector3f closestPointOnPoly(Poly poly, Vector3f position) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_float closest = new FloatArray(3).cast();
        SWIGTYPE_p_bool posOverPoly = new SWIGTYPE_p_bool();
        RecastJNI.dtNavMeshQuery_closestPointOnPoly(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(closest), SWIGTYPE_p_bool.getCPtr(posOverPoly));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(closest));
    }

    /**
     * Returns a point on the boundary closest to the source point if the source
     * point is outside the polygon's xz-bounds.
     *
     * Much faster than closestPointOnPoly().
     *
     * If the provided position lies within the polygon's xz-bounds (above or
     * below), then pos and closest will be equal.
     *
     * The height of closest will be the polygon boundary. The height detail is
     * not used.
     *
     * pos does not have to be within the bounds of the polybon or the
     * navigation mesh.
     *
     * @param poly The reference id to the polygon.
     * @param position The position to check.
     * @return The status flags for the query.
     */
    public Status closestPointOnPolyBoundaryStatus(Poly poly, Vector3f position) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_float closest = new FloatArray(3).cast();
        long status = RecastJNI.dtNavMeshQuery_closestPointOnPolyBoundary(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(closest));
        return new Status(status);
    }

    /**
     * Returns a point on the boundary closest to the source point if the source
     * point is outside the polygon's xz-bounds.
     *
     * Much faster than closestPointOnPoly().
     *
     * If the provided position lies within the polygon's xz-bounds (above or
     * below), then pos and closest will be equal.
     *
     * The height of closest will be the polygon boundary. The height detail is
     * not used.
     *
     * pos does not have to be within the bounds of the polybon or the
     * navigation mesh.
     *
     * @param poly The reference id to the polygon.
     * @param position The position to check.
     * @return The closest point.
     */
    public Vector3f closestPointOnPolyBoundary(Poly poly, Vector3f position) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_float closest = new FloatArray(3).cast();
        RecastJNI.dtNavMeshQuery_closestPointOnPolyBoundary(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(closest));
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(closest));
    }

    /**
     * Gets the height of the polygon at the provided position using the height
     * detail. (Most accurate.)
     *
     * @param poly The reference id of the polygon.
     * @param position A position within the xz-bounds of the polygon.
     * @return The status flags for the query. Will return DT_FAILURE if the
     * provided position is outside the xz-bounds of the polygon.
     */
    public Status getPolyHeightStatus(Poly poly, Vector3f position) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_float height = new FloatArray(1).cast();
        long status = RecastJNI.dtNavMeshQuery_getPolyHeight(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(height));
        return new Status(status);
    }

    /**
     * Gets the height of the polygon at the provided position using the height
     * detail. (Most accurate.)
     *
     * @param poly The reference id of the polygon.
     * @param position A position within the xz-bounds of the polygon.
     * @return The height at the surface of the polygon.
     */
    public float getPolyHeight(Poly poly, Vector3f position) {
        long ref = Poly.getCPtr(poly);
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        SWIGTYPE_p_float height = new FloatArray(1).cast();
        RecastJNI.dtNavMeshQuery_getPolyHeight(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos), SWIGTYPE_p_float.getCPtr(height));
        return Converter.convertToFloat(SWIGTYPE_p_float.getCPtr(height));
    }

    /**
     * Returns true if the polygon reference is valid and passes the filter
     * restrictions.
     *
     * @param poly The polygon reference to check.
     * @param filter The filter to apply.
     * @return
     */
    public boolean isValidPolyRef(Poly poly, QueryFilter filter) {
        long ref = Poly.getCPtr(poly);
        return RecastJNI.dtNavMeshQuery_isValidPolyRef(swigCPtr, this, ref, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * Returns true if the polygon reference is in the closed list. The closed
     * list is the list of polygons that were fully evaluated during the last
     * navigation graph search. (A* or Dijkstra)
     *
     * @param poly The reference id of the polygon to check.
     * @return True if the polygon is in closed list.
     */
    public boolean isInClosedList(Poly poly) {
        long ref = Poly.getCPtr(poly);
        return RecastJNI.dtNavMeshQuery_isInClosedList(swigCPtr, this, ref);
    }

    /**
     * Gets the node pool.
     *
     * @return The node pool.
     */
    public NodePool getNodePool() {
        long cPtr = RecastJNI.dtNavMeshQuery_getNodePool(swigCPtr, this);
        return (cPtr == 0) ? null : new NodePool(cPtr, false);
    }

    /**
     * Gets the navigation mesh the query object is using.
     *
     * @return The navigation mesh the query object is using.
     */
    public NavMesh getAttachedNavMesh() {
        long cPtr = RecastJNI.dtNavMeshQuery_getAttachedNavMesh(swigCPtr, this);
        return (cPtr == 0) ? null : new NavMesh(cPtr, false);
    }
}
