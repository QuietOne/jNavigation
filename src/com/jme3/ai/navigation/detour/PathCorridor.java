package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.FloatArray;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_char;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_unsigned_int;
import com.jme3.ai.navigation.utils.UCharArray;
import com.jme3.ai.navigation.utils.UIntArray;
import com.jme3.math.Vector3f;

/**
 * Represents a dynamic polygon corridor used to plan agent movement.
 *
 * ,
 *
 * The corridor is loaded with a path, usually obtained from a
 * NavMeshQuery#findPath() query. The corridor is then used to plan local
 * movement, with the corridor automatically updating as needed to deal with
 * inaccurate agent locomotion.
 *
 * Example of a common use case:
 * <ol>
 * <li> Construct the corridor object and call init() to allocate its path
 * buffer.</li>
 * <li>Obtain a path from a dtNavMeshQuery object.</li>
 * <li> Use reset() to set the agent's current position. (At the beginning of
 * the path.) </li>
 * <li>Use setCorridor() to load the path and target.</li>
 * <li>Use findCorners() to plan movement. (This handles dynamic path
 * straightening.)</li>
 * <li>Use movePosition() to feed agent movement back into the corridor. (The
 * corridor will automatically adjust as needed.)</li>
 * <li>If the target is moving, use moveTargetPosition() to update the end of
 * the corridor. (The corridor will automatically adjust as needed.)</li>
 * <li>Repeat the previous 3 steps to continue to move the agent.</li>
 * </ol>
 * The corridor position and target are always constrained to the navigation
 * mesh.
 *
 * One of the difficulties in maintaining a path is that floating point errors,
 * locomotion inaccuracies, and/or local steering can result in the agent
 * crossing the boundary of the path corridor, temporarily invalidating the
 * path. This class uses local mesh queries to detect and update the corridor as
 * needed to handle these types of issues.
 *
 * The fact that local mesh queries are used to move the position and target
 * locations results in two beahviors that need to be considered:
 *
 * Every time a move function is used there is a chance that the path will
 * become non-optimial. Basically, the further the target is moved from its
 * original location, and the further the position is moved outside the original
 * corridor, the more likely the path will become non-optimal. This issue can be
 * addressed by periodically running the optimizePathTopology() and
 * optimizePathVisibility() methods.
 *
 * All local mesh queries have distance limitations. (Review the dtNavMeshQuery
 * methods for details.) So the most accurate use case is to move the position
 * and target in small increments. If a large increment is used, then the
 * corridor may not be able to accurately find the new location. Because of this
 * limiation, if a position is moved in a large increment, then compare the
 * desired and resulting polygon references. If the two do not match, then path
 * replanning may be needed. E.g. If you move the target, check getLastPoly() to
 * see if it is the expected polygon.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class PathCorridor {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public PathCorridor() {
        this(RecastJNI.new_dtPathCorridor(), true);
    }

    public PathCorridor(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(PathCorridor obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_dtPathCorridor(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     * Allocates the corridor's path buffer.
     *
     * WARNING: Cannot be called more than once.
     *
     * @param maxPath The maximum path size the corridor can handle.
     * @return True if the initialization succeeded.
     */
    public boolean init(int maxPath) {
        return RecastJNI.dtPathCorridor_init(swigCPtr, this, maxPath);
    }

    /**
     * Resets the path corridor to the specified position.
     *
     * Essentially, the corridor is set of one polygon in size with the target
     * equal to the position.
     *
     * @param ref The polygon reference containing the position.
     * @param position The new position in the corridor.
     */
    public void reset(long ref, Vector3f position) {
        SWIGTYPE_p_float pos = Converter.convertToSWIGTYPE_p_float(position);
        RecastJNI.dtPathCorridor_reset(swigCPtr, this, ref, SWIGTYPE_p_float.getCPtr(pos));
    }

    /**
     * Finds the corners in the corridor from the position toward the target.
     *
     * @param maxCorners The maximum number of corners the buffers can hold.
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return The corner vertices. [(x, y, z) * cornerCount] [Size: less or
     * equal to maxCorners]
     */
    public Vector3f[] findCornersVerts(int maxCorners, NavMeshQuery navQuery, QueryFilter filter) {
        SWIGTYPE_p_float cornerVerts = new FloatArray(3 * maxCorners).cast();
        SWIGTYPE_p_unsigned_char cornerFlags = new UCharArray(maxCorners).cast();
        SWIGTYPE_p_unsigned_int cornerPolys = new UIntArray(maxCorners).cast();
        int count = RecastJNI.dtPathCorridor_findCorners(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cornerVerts), SWIGTYPE_p_unsigned_char.getCPtr(cornerFlags), SWIGTYPE_p_unsigned_int.getCPtr(cornerPolys), maxCorners, NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
        return Converter.convertToVector3f(SWIGTYPE_p_float.getCPtr(cornerVerts), count);
    }

    /**
     * Finds the corners in the corridor from the position toward the target.
     *
     * @param maxCorners The maximum number of corners the buffers can hold.
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return The flag for each corner. [(flag) * cornerCount] [Size: less or
     * equal to maxCorners]
     */
    public char[] findCornersFlags(int maxCorners, NavMeshQuery navQuery, QueryFilter filter) {
        SWIGTYPE_p_float cornerVerts = new FloatArray(3 * maxCorners).cast();
        SWIGTYPE_p_unsigned_char cornerFlags = new UCharArray(maxCorners).cast();
        SWIGTYPE_p_unsigned_int cornerPolys = new UIntArray(maxCorners).cast();
        int count = RecastJNI.dtPathCorridor_findCorners(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cornerVerts), SWIGTYPE_p_unsigned_char.getCPtr(cornerFlags), SWIGTYPE_p_unsigned_int.getCPtr(cornerPolys), maxCorners, NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
        return Converter.convertToChars(cornerFlags, count);
    }

    /**
     * Finds the corners in the corridor from the position toward the target.
     *
     * @param maxCorners The maximum number of corners the buffers can hold.
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return The polygon reference for each corner. [(polyRef) * cornerCount]
     * [Size: less or equal to maxCorners]
     */
    public int[] findCorners(int maxCorners, NavMeshQuery navQuery, QueryFilter filter) {
        SWIGTYPE_p_float cornerVerts = new FloatArray(3 * maxCorners).cast();
        SWIGTYPE_p_unsigned_char cornerFlags = new UCharArray(maxCorners).cast();
        SWIGTYPE_p_unsigned_int cornerPolys = new UIntArray(maxCorners).cast();
        int count = RecastJNI.dtPathCorridor_findCorners(swigCPtr, this, SWIGTYPE_p_float.getCPtr(cornerVerts), SWIGTYPE_p_unsigned_char.getCPtr(cornerFlags), SWIGTYPE_p_unsigned_int.getCPtr(cornerPolys), maxCorners, NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
        return Converter.convertToInts(SWIGTYPE_p_unsigned_int.getCPtr(cornerPolys), count);
    }

    /**
     * Attempts to optimize the path if the specified point is visible from the
     * current position.
     *
     * @param nextPoint The point to search toward.
     * @param pathOptimizationRange The maximum range to search. [Limit: > 0]
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     */
    public void optimizePathVisibility(Vector3f nextPoint, float pathOptimizationRange, NavMeshQuery navQuery, QueryFilter filter) {
        SWIGTYPE_p_float next = Converter.convertToSWIGTYPE_p_float(nextPoint);
        RecastJNI.dtPathCorridor_optimizePathVisibility(swigCPtr, this, SWIGTYPE_p_float.getCPtr(next), pathOptimizationRange, NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * Attempts to optimize the path using a local area search. (Partial
     * replanning.) Inaccurate locomotion or dynamic obstacle avoidance can
     * force the agent position significantly outside the original corridor.
     * Over time this can result in the formation of a non-optimal corridor.
     * This function will use a local area path search to try to re-optimize the
     * corridor.
     *
     * The more inaccurate the agent movement, the more beneficial this function
     * becomes. Simply adjust the frequency of the call to match the needs to
     * the agent.
     *
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return
     */
    public boolean optimizePathTopology(NavMeshQuery navQuery, QueryFilter filter) {
        return RecastJNI.dtPathCorridor_optimizePathTopology(swigCPtr, this, NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * There is no documentation so I don't know how it is supposed to be
     * used... so it is not finished yet...
     *
     * @param offMeshConRef
     * @param refs
     * @param startPosition
     * @param endPosition
     * @param navquery
     * @return
     */
    public boolean moveOverOffmeshConnection(long offMeshConRef, SWIGTYPE_p_unsigned_int refs, Vector3f startPosition, Vector3f endPosition, NavMeshQuery navquery) {
        SWIGTYPE_p_float startPos = Converter.convertToSWIGTYPE_p_float(startPosition);
        SWIGTYPE_p_float endPos = Converter.convertToSWIGTYPE_p_float(endPosition);
        return RecastJNI.dtPathCorridor_moveOverOffmeshConnection(swigCPtr, this, offMeshConRef, SWIGTYPE_p_unsigned_int.getCPtr(refs), SWIGTYPE_p_float.getCPtr(startPos), SWIGTYPE_p_float.getCPtr(endPos), NavMeshQuery.getCPtr(navquery), navquery);
    }

    public boolean fixPathStart(long safeRef, Vector3f safePosition) {
        SWIGTYPE_p_float safePos = Converter.convertToSWIGTYPE_p_float(safePosition);
        return RecastJNI.dtPathCorridor_fixPathStart(swigCPtr, this, safeRef, SWIGTYPE_p_float.getCPtr(safePos));
    }

    /**
     * There is no documentation so I don't know how it is supposed to be
     * used... so it is not finished yet...
     *
     * @param safeRef
     * @param safePos
     * @param navquery
     * @param filter
     * @return
     */
    public boolean trimInvalidPath(long safeRef, SWIGTYPE_p_float safePos, NavMeshQuery navquery, QueryFilter filter) {
        return RecastJNI.dtPathCorridor_trimInvalidPath(swigCPtr, this, safeRef, SWIGTYPE_p_float.getCPtr(safePos), NavMeshQuery.getCPtr(navquery), navquery, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * Checks the current corridor path to see if its polygon references remain
     * valid.
     *
     * The path can be invalidated if there are structural changes to the
     * underlying navigation mesh, or the state of a polygon within the path
     * changes resulting in it being filtered out. (E.g. An exclusion or
     * inclusion flag changes.)
     *
     * @param maxLookAhead The number of polygons from the beginning of the
     * corridor to search.
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return
     */
    public boolean isValid(int maxLookAhead, NavMeshQuery navQuery, QueryFilter filter) {
        return RecastJNI.dtPathCorridor_isValid(swigCPtr, this, maxLookAhead, NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * Moves the position from the current location to the desired location,
     * adjusting the corridor as needed to reflect the change.
     *
     * Behavior:
     *
     * The movement is constrained to the surface of the navigation mesh. The
     * corridor is automatically adjusted (shorted or lengthened) in order to
     * remain valid. The new position will be located in the adjusted corridor's
     * first polygon. The expected use case is that the desired position will be
     * 'near' the current corridor. What is considered 'near' depends on local
     * polygon density, query search extents, etc.
     *
     * The resulting position will differ from the desired position if the
     * desired position is not on the navigation mesh, or it can't be reached
     * using a local search.
     *
     * @param desiredPosition The desired new position.
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return Returns true if move succeeded.
     */
    public boolean movePosition(Vector3f desiredPosition, NavMeshQuery navQuery, QueryFilter filter) {
        SWIGTYPE_p_float npos = Converter.convertToSWIGTYPE_p_float(desiredPosition);
        return RecastJNI.dtPathCorridor_movePosition(swigCPtr, this, SWIGTYPE_p_float.getCPtr(npos), NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * Moves the target from the curent location to the desired location,
     * adjusting the corridor as needed to reflect the change.
     *
     * Behavior:
     *
     * The movement is constrained to the surface of the navigation mesh. The
     * corridor is automatically adjusted (shorted or lengthened) in order to
     * remain valid. The new target will be located in the adjusted corridor's
     * last polygon. The expected use case is that the desired target will be
     * 'near' the current corridor. What is considered 'near' depends on local
     * polygon density, query search extents, etc.
     *
     * The resulting target will differ from the desired target if the desired
     * target is not on the navigation mesh, or it can't be reached using a
     * local search.
     *
     * @param desiredPosition The desired new target position.
     * @param navQuery The query object used to build the corridor.
     * @param filter The filter to apply to the operation.
     * @return Returns true if move succeeded.
     */
    public boolean moveTargetPosition(Vector3f desiredPosition, NavMeshQuery navQuery, QueryFilter filter) {
        SWIGTYPE_p_float npos = Converter.convertToSWIGTYPE_p_float(desiredPosition);
        return RecastJNI.dtPathCorridor_moveTargetPosition(swigCPtr, this, SWIGTYPE_p_float.getCPtr(npos), NavMeshQuery.getCPtr(navQuery), navQuery, QueryFilter.getCPtr(filter), filter);
    }

    /**
     * Loads a new path and target into the corridor. The current corridor
     * position is expected to be within the first polygon in the path. The
     * target is expected to be in the last polygon.
     *
     * Warning: The size of the path must not exceed the size of corridor's path
     * buffer set during init().
     *
     * @param targetPosition The target location within the last polygon of the
     * path.
     * @param polyRefs The path corridor.
     * @param numberOfPolysInPath The number of polygons in the path.
     */
    public void setCorridor(Vector3f targetPosition, int[] polyRefs, int numberOfPolysInPath) {
        SWIGTYPE_p_float target = Converter.convertToSWIGTYPE_p_float(targetPosition);
        SWIGTYPE_p_unsigned_int polys = Converter.convertToSWIGTYPE_p_unsigned_int(polyRefs);
        RecastJNI.dtPathCorridor_setCorridor(swigCPtr, this, SWIGTYPE_p_float.getCPtr(target), SWIGTYPE_p_unsigned_int.getCPtr(polys), numberOfPolysInPath);
    }

    /**
     * Gets the current position within the corridor. (In the first polygon.)
     *
     * @return The current position within the corridor.
     */
    public Vector3f getPosition() {
        long cPtr = RecastJNI.dtPathCorridor_getPos(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     * Gets the current target within the corridor. (In the last polygon.)
     *
     * @return The current target within the corridor.
     */
    public Vector3f getTarget() {
        long cPtr = RecastJNI.dtPathCorridor_getTarget(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToVector3f(cPtr);
    }

    /**
     * The polygon reference id of the first polygon in the corridor, the
     * polygon containing the position.
     *
     * @return The polygon reference id of the first polygon in the corridor.
     * (Or zero if there is no path.)
     */
    public long getFirstPoly() {
        return RecastJNI.dtPathCorridor_getFirstPoly(swigCPtr, this);
    }

    /**
     * The polygon reference id of the last polygon in the corridor, the polygon
     * containing the target.
     *
     * @return The polygon reference id of the last polygon in the corridor. (Or
     * zero if there is no path.)
     */
    public long getLastPoly() {
        return RecastJNI.dtPathCorridor_getLastPoly(swigCPtr, this);
    }

    /**
     * The corridor's path.
     *
     * @return The corridor's path. [(polyRef) * getPathCount()]
     * @see PathCorridor#getPathCount()
     */
    public int[] getPath() {
        long cPtr = RecastJNI.dtPathCorridor_getPath(swigCPtr, this);
        return (cPtr == 0) ? null : Converter.convertToInts(cPtr, getPathCount());
    }

    /**
     * The number of polygons in the current corridor path.
     *
     * @return The number of polygons in the current corridor path.
     */
    public int getPathCount() {
        return RecastJNI.dtPathCorridor_getPathCount(swigCPtr, this);
    }
}
