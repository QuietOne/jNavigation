package com.jme3.ai.detour.util;

import com.jme3.ai.detour.structures.NavMesh;
import com.jme3.ai.detour.structures.Poly.PolyRef;
import com.jme3.math.Vector3f;

/**
 * Provides the ability to perform pathfinding related queries against a
 * navigation mesh.
 *
 * For methods that support undersized buffers, if the buffer is too small to
 * hold the entire result set the return status of the method will include the
 * DT_BUFFER_TOO_SMALL flag.
 *
 * Constant member functions can be used by multiple clients without side
 * effects. (E.g. No change to the closed list. No impact on an in-progress
 * sliced path query. Etc.)
 *
 * Walls and portals: A wall is a polygon segment that is considered impassable.
 * A portal is a passable segment between polygons. A portal may be treated as a
 * wall based on the dtQueryFilter used for a query.
 *
 * @author Tihomir Radosavljevic
 */
public class NavMeshQuery {

    private Object reference;
    
    public NavMeshQuery() {
        reference = dtNavMeshQuery();
    }
    
    private native Object dtNavMeshQuery();
    
    public Status init(NavMesh navMesh, int maxNodes){
        return initDT(navMesh, maxNodes);
    }
    
    private native Status initDT(NavMesh navMesh, int maxNodes); 
    
    public Status findPath(PolyRef start, PolyRef end, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, PolyRef path, int pathCount, int maxPath){
        return findPathDT(start, end, startPosition, endPosition, filter, path, pathCount, maxPath);
    }
    
    private native Status findPathDT(PolyRef start, PolyRef end, Vector3f startPosition, Vector3f endPosition, QueryFilter filter, PolyRef path, int pathCount, int maxPath);

    public Status findStraightPath(Vector3f startPosition, Vector3f endPosition, PolyRef path, int pathSize, float straightPath, char[] straightPathFlags, PolyRef straightPathRefs, int straightPathCount, int maxStraightPath, int options){
        return findStraightPathDT(startPosition, endPosition, path, pathSize, straightPath, straightPathFlags, straightPathRefs, straightPathCount, maxStraightPath, options);
    }
    
    private native Status findStraightPathDT(Vector3f startPosition, Vector3f endPosition, PolyRef path, int pathSize, float straightPath, char[] straightPathFlags, PolyRef straightPathRefs, int straightPathCount, int maxStraightPath, int options);
    
    
    //TODO: add rest of functions by request
    

}
