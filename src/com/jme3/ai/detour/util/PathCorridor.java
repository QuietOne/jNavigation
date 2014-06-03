package com.jme3.ai.detour.util;

import com.jme3.ai.detour.structures.Poly.PolyRef;
import com.jme3.math.Vector3f;

/**
 * Represents a dynamic polygon corridor used to plan agent movement.
 *
 * The corridor is loaded with a path, usually obtained from a
 * dtNavMeshQuery::findPath() query. The corridor is then used to plan local
 * movement, with the corridor automatically updating as needed to deal with
 * inaccurate agent locomotion.
 *
 * Example of a common use case:
 *
 * Construct the corridor object and call init() to allocate its path buffer.
 * Obtain a path from a dtNavMeshQuery object. Use reset() to set the agent's
 * current position. (At the beginning of the path.) Use setCorridor() to load
 * the path and target. Use findCorners() to plan movement. (This handles
 * dynamic path straightening.) Use movePosition() to feed agent movement back
 * into the corridor. (The corridor will automatically adjust as needed.) If the
 * target is moving, use moveTargetPosition() to update the end of the corridor.
 * (The corridor will automatically adjust as needed.) Repeat the previous 3
 * steps to continue to move the agent. The corridor position and target are
 * always constrained to the navigation mesh.
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
 */
public class PathCorridor {

    private Object reference;
    
    public PathCorridor() {
        reference = allocPathCorridor(); 
    }
    
    private native Object allocPathCorridor();

    public boolean init(int maxPath){
        return initDT(maxPath);
    }
    
    private native boolean initDT(int maxPath);
    
    public void reset(PolyRef polyRef, Vector3f position){
        resetDT(polyRef, position);
    }
    
    private native void resetDT(PolyRef polyRef, Vector3f position);
    
    //findCorners
    
    public void optimazePathVisibility(Vector3f next, float pathOptimizationRange, NavMeshQuery navMeshQuery, QueryFilter filter){
        optimazePathVisibilityDT(next, pathOptimizationRange, navMeshQuery, filter);
    }
    
    private native void optimazePathVisibilityDT(Vector3f next, float pathOptmizationRange, NavMeshQuery navMeshQuery, QueryFilter filter);
    
    public boolean optimazePathTopology(NavMeshQuery navMeshQuery, QueryFilter filter){
        return optimazePathTopologyDT(navMeshQuery, filter);
    }
    
    private native boolean optimazePathTopologyDT(NavMeshQuery meshQuery, QueryFilter filter);
    
    public boolean moveOverOffMeshConnection(PolyRef offMeshConnectionRef, PolyRef[] refs, Vector3f startPosition, Vector3f endPosition, NavMeshQuery query){
        return moveOverOffMeshConnectionDT(offMeshConnectionRef, refs, startPosition, endPosition, query);
    }
    
    private native boolean moveOverOffMeshConnectionDT(PolyRef offMeshConnectionRef, PolyRef[] refs, Vector3f startPosition, Vector3f endPosition, NavMeshQuery query);
    
    //fixPathStart
    //trimInvalidPath
    
    public boolean isValid(int maxLookAhead, NavMeshQuery meshQuery, QueryFilter filter){
        return isValidDT(maxLookAhead, meshQuery, filter);
    }
    
    private native boolean isValidDT(int maxLookAhead, NavMeshQuery meshQuery, QueryFilter filter);
    
    public boolean movePosition(Vector3f desiredPosition, NavMeshQuery query, QueryFilter filter){
        return movePositionDT(desiredPosition, query, filter);
    }
    
    private native boolean movePositionDT(Vector3f desiredPosition, NavMeshQuery query, QueryFilter filter);
    
    public boolean moveTargetPostion(Vector3f newPosition, NavMeshQuery query, QueryFilter filter){
        return moveTargetPostionDT(newPosition, query, filter);
    }
    
    private native boolean moveTargetPostionDT(Vector3f newPosition, NavMeshQuery query, QueryFilter filter);
    
    
    public void setCorridor(Vector3f target, PolyRef[] path){
        setCorridorDT(target, path);
    }
    
    private native void setCorridorDT(Vector3f target, PolyRef[] path);
    
    public Vector3f getPosition(){
        return getPositionDT();
    }
    
    private native Vector3f getPositionDT();
    
    public Vector3f getTarget(){
        return getTargetDT();
    }
    
    private native Vector3f getTargetDT();
    
    public PolyRef getFirstPoly(){
        return getFirstPolyDT();
    }
    
    private native PolyRef getFirstPolyDT();
    
    public PolyRef getLastPoly(){
        return getLastPolyDT();
    }
    
    private native PolyRef getLastPolyDT();
    
    public PolyRef[] getPath(){
        return getPathDT();
    }
    
    private native PolyRef[] getPathDT();
    
    public int getPathCount(){
        return getPathCountDT();
    }
    
    private native int getPathCountDT();
    
    
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        freePathCorridor(this);
    }
    
    private native void freePathCorridor(PathCorridor corridor);
}
