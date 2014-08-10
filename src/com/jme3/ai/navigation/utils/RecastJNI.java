package com.jme3.ai.navigation.utils;

import com.jme3.ai.navigation.crowd.dtCrowd;
import com.jme3.ai.navigation.crowd.dtCrowdAgent;
import com.jme3.ai.navigation.crowd.dtCrowdAgentAnimation;
import com.jme3.ai.navigation.crowd.dtCrowdAgentDebugInfo;
import com.jme3.ai.navigation.crowd.dtCrowdAgentParams;
import com.jme3.ai.navigation.crowd.dtCrowdNeighbour;
import com.jme3.ai.navigation.crowd.dtLocalBoundary;
import com.jme3.ai.navigation.crowd.dtObstacleAvoidanceDebugData;
import com.jme3.ai.navigation.crowd.dtObstacleAvoidanceParams;
import com.jme3.ai.navigation.crowd.dtObstacleAvoidanceQuery;
import com.jme3.ai.navigation.crowd.dtObstacleCircle;
import com.jme3.ai.navigation.crowd.dtObstacleSegment;
import com.jme3.ai.navigation.crowd.dtPathQueue;
import com.jme3.ai.navigation.crowd.dtProximityGrid;
import com.jme3.ai.navigation.detour.BVNode;
import com.jme3.ai.navigation.detour.Link;
import com.jme3.ai.navigation.detour.MeshHeader;
import com.jme3.ai.navigation.detour.MeshTile;
import com.jme3.ai.navigation.detour.NavMesh;
import com.jme3.ai.navigation.detour.NavMeshCreateParams;
import com.jme3.ai.navigation.detour.NavMeshParams;
import com.jme3.ai.navigation.detour.NavMeshQuery;
import com.jme3.ai.navigation.detour.Node;
import com.jme3.ai.navigation.detour.NodePool;
import com.jme3.ai.navigation.detour.NodeQueue;
import com.jme3.ai.navigation.detour.OffMeshConnection;
import com.jme3.ai.navigation.detour.PathCorridor;
import com.jme3.ai.navigation.detour.Poly;
import com.jme3.ai.navigation.detour.PolyDetail;
import com.jme3.ai.navigation.detour.QueryFilter;
import com.jme3.ai.navigation.recast.CompactCell;
import com.jme3.ai.navigation.recast.CompactHeightfield;
import com.jme3.ai.navigation.recast.CompactSpan;
import com.jme3.ai.navigation.recast.Config;
import com.jme3.ai.navigation.recast.Context;
import com.jme3.ai.navigation.recast.Contour;
import com.jme3.ai.navigation.recast.ContourSet;
import com.jme3.ai.navigation.recast.Heightfield;
import com.jme3.ai.navigation.recast.HeightfieldLayer;
import com.jme3.ai.navigation.recast.HeightfieldLayerSet;
import com.jme3.ai.navigation.recast.PolyMesh;
import com.jme3.ai.navigation.recast.PolyMeshDetail;
import com.jme3.ai.navigation.recast.Span;
import com.jme3.ai.navigation.tilecache.CompressedTile;
import com.jme3.ai.navigation.tilecache.TileCache;
import com.jme3.ai.navigation.tilecache.TileCacheAlloc;
import com.jme3.ai.navigation.tilecache.TileCacheCompressor;
import com.jme3.ai.navigation.tilecache.TileCacheContour;
import com.jme3.ai.navigation.tilecache.TileCacheContourSet;
import com.jme3.ai.navigation.tilecache.TileCacheLayer;
import com.jme3.ai.navigation.tilecache.TileCacheLayerHeader;
import com.jme3.ai.navigation.tilecache.TileCacheMeshProcess;
import com.jme3.ai.navigation.tilecache.TileCacheObstacle;
import com.jme3.ai.navigation.tilecache.TileCacheParams;
import com.jme3.ai.navigation.tilecache.TileCachePolyMesh;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecastJNI {

    public static native long new_DoubleArray(int jarg1);

    public static native void delete_DoubleArray(long jarg1);

    public static native double DoubleArray_getitem(long jarg1, DoubleArray jarg1_, int jarg2);

    public static native void DoubleArray_setitem(long jarg1, DoubleArray jarg1_, int jarg2, double jarg3);

    public static native long DoubleArray_cast(long jarg1, DoubleArray jarg1_);

    public static native long DoubleArray_frompointer(long jarg1);

    public static native long new_FloatArray(int jarg1);

    public static native void delete_FloatArray(long jarg1);

    public static native float FloatArray_getitem(long jarg1, FloatArray jarg1_, int jarg2);

    public static native void FloatArray_setitem(long jarg1, FloatArray jarg1_, int jarg2, float jarg3);

    public static native long FloatArray_cast(long jarg1, FloatArray jarg1_);

    public static native long FloatArray_frompointer(long jarg1);

    public static native long new_IntArray(int jarg1);

    public static native void delete_IntArray(long jarg1);

    public static native int IntArray_getitem(long jarg1, IntArray jarg1_, int jarg2);

    public static native void IntArray_setitem(long jarg1, IntArray jarg1_, int jarg2, int jarg3);

    public static native long IntArray_cast(long jarg1, IntArray jarg1_);

    public static native long IntArray_frompointer(long jarg1);

    public static native long new_UCharArray(int jarg1);

    public static native void delete_UCharArray(long jarg1);

    public static native short UCharArray_getitem(long jarg1, UCharArray jarg1_, int jarg2);

    public static native void UCharArray_setitem(long jarg1, UCharArray jarg1_, int jarg2, short jarg3);

    public static native long UCharArray_cast(long jarg1, UCharArray jarg1_);

    public static native long UCharArray_frompointer(long jarg1);

    public static native long new_UShortArray(int jarg1);

    public static native void delete_UShortArray(long jarg1);

    public static native int UShortArray_getitem(long jarg1, UShortArray jarg1_, int jarg2);

    public static native void UShortArray_setitem(long jarg1, UShortArray jarg1_, int jarg2, int jarg3);

    public static native long UShortArray_cast(long jarg1, UShortArray jarg1_);

    public static native long UShortArray_frompointer(long jarg1);

    public static native long new_UIntArray(int jarg1);

    public static native void delete_UIntArray(long jarg1);

    public static native long UIntArray_getitem(long jarg1, UIntArray jarg1_, int jarg2);

    public static native void UIntArray_setitem(long jarg1, UIntArray jarg1_, int jarg2, long jarg3);

    public static native long UIntArray_cast(long jarg1, UIntArray jarg1_);

    public static native long UIntArray_frompointer(long jarg1);

    public static native long new_LongArray(int jarg1);

    public static native void delete_LongArray(long jarg1);

    public static native int LongArray_getitem(long jarg1, LongArray jarg1_, int jarg2);

    public static native void LongArray_setitem(long jarg1, LongArray jarg1_, int jarg2, int jarg3);

    public static native long LongArray_cast(long jarg1, LongArray jarg1_);

    public static native long LongArray_frompointer(long jarg1);

    public static native long new_BooleanArray(int jarg1);

    public static native void delete_BooleanArray(long jarg1);

    public static native boolean BooleanArray_getitem(long jarg1, BooleanArray jarg1_, int jarg2);

    public static native void BooleanArray_setitem(long jarg1, BooleanArray jarg1_, int jarg2, boolean jarg3);

    public static native long BooleanArray_cast(long jarg1, BooleanArray jarg1_);

    public static native long BooleanArray_frompointer(long jarg1);

    public static native void dtAllocSetCustom(long jarg1, long jarg2);

    public static native long dtAlloc(int jarg1, int jarg2);

    public static native void dtFree(long jarg1);

    public static native float dtSqrt(float jarg1);

    public static native void dtVcross(long jarg1, long jarg2, long jarg3);

    public static native float dtVdot(long jarg1, long jarg2);

    public static native void dtVmad(long jarg1, long jarg2, long jarg3, float jarg4);

    public static native void dtVlerp(long jarg1, long jarg2, long jarg3, float jarg4);

    public static native void dtVadd(long jarg1, long jarg2, long jarg3);

    public static native void dtVsub(long jarg1, long jarg2, long jarg3);

    public static native void dtVscale(long jarg1, long jarg2, float jarg3);

    public static native void dtVmin(long jarg1, long jarg2);

    public static native void dtVmax(long jarg1, long jarg2);

    public static native void dtVset(long jarg1, float jarg2, float jarg3, float jarg4);

    public static native void dtVcopy(long jarg1, long jarg2);

    public static native float dtVlen(long jarg1);

    public static native float dtVlenSqr(long jarg1);

    public static native float dtVdist(long jarg1, long jarg2);

    public static native float dtVdistSqr(long jarg1, long jarg2);

    public static native float dtVdist2D(long jarg1, long jarg2);

    public static native float dtVdist2DSqr(long jarg1, long jarg2);

    public static native void dtVnormalize(long jarg1);

    public static native boolean dtVequal(long jarg1, long jarg2);

    public static native float dtVdot2D(long jarg1, long jarg2);

    public static native float dtVperp2D(long jarg1, long jarg2);

    public static native float dtTriArea2D(long jarg1, long jarg2, long jarg3);

    public static native boolean dtOverlapQuantBounds(long jarg1, long jarg2, long jarg3, long jarg4);

    public static native boolean dtOverlapBounds(long jarg1, long jarg2, long jarg3, long jarg4);

    public static native void dtClosestPtPointTriangle(long jarg1, long jarg2, long jarg3, long jarg4, long jarg5);

    public static native boolean dtClosestHeightPointTriangle(long jarg1, long jarg2, long jarg3, long jarg4, long jarg5);

    public static native boolean dtIntersectSegmentPoly2D(long jarg1, long jarg2, long jarg3, int jarg4, long jarg5, long jarg6, long jarg7, long jarg8);

    public static native boolean dtIntersectSegSeg2D(long jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6);

    public static native boolean dtPointInPolygon(long jarg1, long jarg2, int jarg3);

    public static native boolean dtDistancePtPolyEdgesSqr(long jarg1, long jarg2, int jarg3, long jarg4, long jarg5);

    public static native float dtDistancePtSegSqr2D(long jarg1, long jarg2, long jarg3, long jarg4);

    public static native void dtCalcPolyCenter(long jarg1, long jarg2, int jarg3, long jarg4);

    public static native boolean dtOverlapPolyPoly2D(long jarg1, int jarg2, long jarg3, int jarg4);

    public static native long dtNextPow2(long jarg1);

    public static native long dtIlog2(long jarg1);

    public static native int dtAlign4(int jarg1);

    public static native int dtOppositeTile(int jarg1);

    public static native void dtSwapByte(long jarg1, long jarg2);

    public static native void dtSwapEndian__SWIG_0(long jarg1);

    public static native void dtSwapEndian__SWIG_1(long jarg1);

    public static native void dtSwapEndian__SWIG_2(long jarg1);

    public static native void dtSwapEndian__SWIG_3(long jarg1);

    public static native void dtSwapEndian__SWIG_4(long jarg1);

    public static native void dtRandomPointInConvexPoly(long jarg1, int jarg2, long jarg3, float jarg4, float jarg5, long jarg6);

    public static native int DT_CROWDAGENT_MAX_NEIGHBOURS_get();

    public static native int DT_CROWDAGENT_MAX_CORNERS_get();

    public static native int DT_CROWD_MAX_OBSTAVOIDANCE_PARAMS_get();

    public static native int DT_CROWD_MAX_QUERY_FILTER_TYPE_get();

    public static native void dtCrowdNeighbour_idx_set(long jarg1, dtCrowdNeighbour jarg1_, int jarg2);

    public static native int dtCrowdNeighbour_idx_get(long jarg1, dtCrowdNeighbour jarg1_);

    public static native void dtCrowdNeighbour_dist_set(long jarg1, dtCrowdNeighbour jarg1_, float jarg2);

    public static native float dtCrowdNeighbour_dist_get(long jarg1, dtCrowdNeighbour jarg1_);

    public static native long new_dtCrowdNeighbour();

    public static native void delete_dtCrowdNeighbour(long jarg1);

    public static native void dtCrowdAgentParams_radius_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_radius_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_height_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_height_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_maxAcceleration_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_maxAcceleration_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_maxSpeed_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_maxSpeed_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_collisionQueryRange_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_collisionQueryRange_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_pathOptimizationRange_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_pathOptimizationRange_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_separationWeight_set(long jarg1, dtCrowdAgentParams jarg1_, float jarg2);

    public static native float dtCrowdAgentParams_separationWeight_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_updateFlags_set(long jarg1, dtCrowdAgentParams jarg1_, short jarg2);

    public static native short dtCrowdAgentParams_updateFlags_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_obstacleAvoidanceType_set(long jarg1, dtCrowdAgentParams jarg1_, short jarg2);

    public static native short dtCrowdAgentParams_obstacleAvoidanceType_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_queryFilterType_set(long jarg1, dtCrowdAgentParams jarg1_, short jarg2);

    public static native short dtCrowdAgentParams_queryFilterType_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native void dtCrowdAgentParams_userData_set(long jarg1, dtCrowdAgentParams jarg1_, long jarg2);

    public static native long dtCrowdAgentParams_userData_get(long jarg1, dtCrowdAgentParams jarg1_);

    public static native long new_dtCrowdAgentParams();

    public static native void delete_dtCrowdAgentParams(long jarg1);

    public static native int DT_CROWDAGENT_TARGET_NONE_get();

    public static native void dtCrowdAgent_active_set(long jarg1, dtCrowdAgent jarg1_, boolean jarg2);

    public static native boolean dtCrowdAgent_active_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_state_set(long jarg1, dtCrowdAgent jarg1_, short jarg2);

    public static native short dtCrowdAgent_state_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_partial_set(long jarg1, dtCrowdAgent jarg1_, boolean jarg2);

    public static native boolean dtCrowdAgent_partial_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_corridor_set(long jarg1, dtCrowdAgent jarg1_, long jarg2, PathCorridor jarg2_);

    public static native long dtCrowdAgent_corridor_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_boundary_set(long jarg1, dtCrowdAgent jarg1_, long jarg2, dtLocalBoundary jarg2_);

    public static native long dtCrowdAgent_boundary_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_topologyOptTime_set(long jarg1, dtCrowdAgent jarg1_, float jarg2);

    public static native float dtCrowdAgent_topologyOptTime_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_neis_set(long jarg1, dtCrowdAgent jarg1_, long jarg2, dtCrowdNeighbour jarg2_);

    public static native long dtCrowdAgent_neis_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_nneis_set(long jarg1, dtCrowdAgent jarg1_, int jarg2);

    public static native int dtCrowdAgent_nneis_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_desiredSpeed_set(long jarg1, dtCrowdAgent jarg1_, float jarg2);

    public static native float dtCrowdAgent_desiredSpeed_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_npos_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_npos_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_disp_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_disp_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_dvel_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_dvel_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_nvel_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_nvel_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_vel_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_vel_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_params_set(long jarg1, dtCrowdAgent jarg1_, long jarg2, dtCrowdAgentParams jarg2_);

    public static native long dtCrowdAgent_params_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_cornerVerts_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_cornerVerts_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_cornerFlags_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_cornerFlags_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_cornerPolys_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_cornerPolys_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_ncorners_set(long jarg1, dtCrowdAgent jarg1_, int jarg2);

    public static native int dtCrowdAgent_ncorners_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_targetState_set(long jarg1, dtCrowdAgent jarg1_, short jarg2);

    public static native short dtCrowdAgent_targetState_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_targetRef_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_targetRef_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_targetPos_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_targetPos_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_targetPathqRef_set(long jarg1, dtCrowdAgent jarg1_, long jarg2);

    public static native long dtCrowdAgent_targetPathqRef_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_targetReplan_set(long jarg1, dtCrowdAgent jarg1_, boolean jarg2);

    public static native boolean dtCrowdAgent_targetReplan_get(long jarg1, dtCrowdAgent jarg1_);

    public static native void dtCrowdAgent_targetReplanTime_set(long jarg1, dtCrowdAgent jarg1_, float jarg2);

    public static native float dtCrowdAgent_targetReplanTime_get(long jarg1, dtCrowdAgent jarg1_);

    public static native long new_dtCrowdAgent();

    public static native void delete_dtCrowdAgent(long jarg1);

    public static native void dtCrowdAgentAnimation_active_set(long jarg1, dtCrowdAgentAnimation jarg1_, boolean jarg2);

    public static native boolean dtCrowdAgentAnimation_active_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native void dtCrowdAgentAnimation_initPos_set(long jarg1, dtCrowdAgentAnimation jarg1_, long jarg2);

    public static native long dtCrowdAgentAnimation_initPos_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native void dtCrowdAgentAnimation_startPos_set(long jarg1, dtCrowdAgentAnimation jarg1_, long jarg2);

    public static native long dtCrowdAgentAnimation_startPos_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native void dtCrowdAgentAnimation_endPos_set(long jarg1, dtCrowdAgentAnimation jarg1_, long jarg2);

    public static native long dtCrowdAgentAnimation_endPos_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native void dtCrowdAgentAnimation_polyRef_set(long jarg1, dtCrowdAgentAnimation jarg1_, long jarg2);

    public static native long dtCrowdAgentAnimation_polyRef_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native void dtCrowdAgentAnimation_t_set(long jarg1, dtCrowdAgentAnimation jarg1_, float jarg2);

    public static native float dtCrowdAgentAnimation_t_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native void dtCrowdAgentAnimation_tmax_set(long jarg1, dtCrowdAgentAnimation jarg1_, float jarg2);

    public static native float dtCrowdAgentAnimation_tmax_get(long jarg1, dtCrowdAgentAnimation jarg1_);

    public static native long new_dtCrowdAgentAnimation();

    public static native void delete_dtCrowdAgentAnimation(long jarg1);

    public static native int DT_CROWD_ANTICIPATE_TURNS_get();

    public static native int DT_CROWD_OBSTACLE_AVOIDANCE_get();

    public static native int DT_CROWD_SEPARATION_get();

    public static native int DT_CROWD_OPTIMIZE_VIS_get();

    public static native int DT_CROWD_OPTIMIZE_TOPO_get();

    public static native void dtCrowdAgentDebugInfo_idx_set(long jarg1, dtCrowdAgentDebugInfo jarg1_, int jarg2);

    public static native int dtCrowdAgentDebugInfo_idx_get(long jarg1, dtCrowdAgentDebugInfo jarg1_);

    public static native void dtCrowdAgentDebugInfo_optStart_set(long jarg1, dtCrowdAgentDebugInfo jarg1_, long jarg2);

    public static native long dtCrowdAgentDebugInfo_optStart_get(long jarg1, dtCrowdAgentDebugInfo jarg1_);

    public static native void dtCrowdAgentDebugInfo_optEnd_set(long jarg1, dtCrowdAgentDebugInfo jarg1_, long jarg2);

    public static native long dtCrowdAgentDebugInfo_optEnd_get(long jarg1, dtCrowdAgentDebugInfo jarg1_);

    public static native void dtCrowdAgentDebugInfo_vod_set(long jarg1, dtCrowdAgentDebugInfo jarg1_, long jarg2, dtObstacleAvoidanceDebugData jarg2_);

    public static native long dtCrowdAgentDebugInfo_vod_get(long jarg1, dtCrowdAgentDebugInfo jarg1_);

    public static native long new_dtCrowdAgentDebugInfo();

    public static native void delete_dtCrowdAgentDebugInfo(long jarg1);

    public static native long new_dtCrowd();

    public static native void delete_dtCrowd(long jarg1);

    public static native boolean dtCrowd_init(long jarg1, dtCrowd jarg1_, int jarg2, float jarg3, long jarg4, NavMesh jarg4_);

    public static native void dtCrowd_setObstacleAvoidanceParams(long jarg1, dtCrowd jarg1_, int jarg2, long jarg3, dtObstacleAvoidanceParams jarg3_);

    public static native long dtCrowd_getObstacleAvoidanceParams(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native long dtCrowd_getAgent(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native long dtCrowd_getEditableAgent(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native int dtCrowd_getAgentCount(long jarg1, dtCrowd jarg1_);

    public static native int dtCrowd_addAgent(long jarg1, dtCrowd jarg1_, long jarg2, long jarg3, dtCrowdAgentParams jarg3_);

    public static native void dtCrowd_updateAgentParameters(long jarg1, dtCrowd jarg1_, int jarg2, long jarg3, dtCrowdAgentParams jarg3_);

    public static native void dtCrowd_removeAgent(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native boolean dtCrowd_requestMoveTarget(long jarg1, dtCrowd jarg1_, int jarg2, long jarg3, long jarg4);

    public static native boolean dtCrowd_requestMoveVelocity(long jarg1, dtCrowd jarg1_, int jarg2, long jarg3);

    public static native boolean dtCrowd_resetMoveTarget(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native int dtCrowd_getActiveAgents(long jarg1, dtCrowd jarg1_, long jarg2, int jarg3);

    public static native void dtCrowd_update(long jarg1, dtCrowd jarg1_, float jarg2, long jarg3, dtCrowdAgentDebugInfo jarg3_);

    public static native long dtCrowd_getFilter(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native long dtCrowd_getEditableFilter(long jarg1, dtCrowd jarg1_, int jarg2);

    public static native long dtCrowd_getQueryExtents(long jarg1, dtCrowd jarg1_);

    public static native int dtCrowd_getVelocitySampleCount(long jarg1, dtCrowd jarg1_);

    public static native long dtCrowd_getGrid(long jarg1, dtCrowd jarg1_);

    public static native long dtCrowd_getPathQueue(long jarg1, dtCrowd jarg1_);

    public static native long dtCrowd_getNavMeshQuery(long jarg1, dtCrowd jarg1_);

    public static native long dtAllocCrowd();

    public static native void dtFreeCrowd(long jarg1, dtCrowd jarg1_);

    public static native long new_dtLocalBoundary();

    public static native void delete_dtLocalBoundary(long jarg1);

    public static native void dtLocalBoundary_reset(long jarg1, dtLocalBoundary jarg1_);

    public static native void dtLocalBoundary_update(long jarg1, dtLocalBoundary jarg1_, long jarg2, long jarg3, float jarg4, long jarg5, NavMeshQuery jarg5_, long jarg6, QueryFilter jarg6_);

    public static native boolean dtLocalBoundary_isValid(long jarg1, dtLocalBoundary jarg1_, long jarg2, NavMeshQuery jarg2_, long jarg3, QueryFilter jarg3_);

    public static native long dtLocalBoundary_getCenter(long jarg1, dtLocalBoundary jarg1_);

    public static native int dtLocalBoundary_getSegmentCount(long jarg1, dtLocalBoundary jarg1_);

    public static native long dtLocalBoundary_getSegment(long jarg1, dtLocalBoundary jarg1_, int jarg2);

    public static native int DT_VERTS_PER_POLYGON_get();

    public static native int DT_NAVMESH_MAGIC_get();

    public static native int DT_NAVMESH_VERSION_get();

    public static native int DT_NAVMESH_STATE_MAGIC_get();

    public static native int DT_NAVMESH_STATE_VERSION_get();

    public static native int DT_EXT_LINK_get();

    public static native long DT_NULL_LINK_get();

    public static native long DT_OFFMESH_CON_BIDIR_get();

    public static native int DT_MAX_AREAS_get();

    public static native int DT_TILE_FREE_DATA_get();

    public static native int DT_STRAIGHTPATH_START_get();

    public static native int DT_STRAIGHTPATH_END_get();

    public static native int DT_STRAIGHTPATH_OFFMESH_CONNECTION_get();

    public static native int DT_STRAIGHTPATH_AREA_CROSSINGS_get();

    public static native int DT_STRAIGHTPATH_ALL_CROSSINGS_get();

    public static native int DT_POLYTYPE_GROUND_get();

    public static native int DT_POLYTYPE_OFFMESH_CONNECTION_get();

    public static native void dtPoly_firstLink_set(long jarg1, Poly jarg1_, long jarg2);

    public static native long dtPoly_firstLink_get(long jarg1, Poly jarg1_);

    public static native void dtPoly_verts_set(long jarg1, Poly jarg1_, long jarg2);

    public static native long dtPoly_verts_get(long jarg1, Poly jarg1_);

    public static native void dtPoly_neis_set(long jarg1, Poly jarg1_, long jarg2);

    public static native long dtPoly_neis_get(long jarg1, Poly jarg1_);

    public static native void dtPoly_flags_set(long jarg1, Poly jarg1_, int jarg2);

    public static native int dtPoly_flags_get(long jarg1, Poly jarg1_);

    public static native void dtPoly_vertCount_set(long jarg1, Poly jarg1_, short jarg2);

    public static native short dtPoly_vertCount_get(long jarg1, Poly jarg1_);

    public static native void dtPoly_areaAndtype_set(long jarg1, Poly jarg1_, short jarg2);

    public static native short dtPoly_areaAndtype_get(long jarg1, Poly jarg1_);

    public static native void dtPoly_setArea(long jarg1, Poly jarg1_, short jarg2);

    public static native void dtPoly_setType(long jarg1, Poly jarg1_, short jarg2);

    public static native short dtPoly_getArea(long jarg1, Poly jarg1_);

    public static native short dtPoly_getType(long jarg1, Poly jarg1_);

    public static native long new_dtPoly();

    public static native void delete_dtPoly(long jarg1);

    public static native void dtPolyDetail_vertBase_set(long jarg1, PolyDetail jarg1_, long jarg2);

    public static native long dtPolyDetail_vertBase_get(long jarg1, PolyDetail jarg1_);

    public static native void dtPolyDetail_triBase_set(long jarg1, PolyDetail jarg1_, long jarg2);

    public static native long dtPolyDetail_triBase_get(long jarg1, PolyDetail jarg1_);

    public static native void dtPolyDetail_vertCount_set(long jarg1, PolyDetail jarg1_, short jarg2);

    public static native short dtPolyDetail_vertCount_get(long jarg1, PolyDetail jarg1_);

    public static native void dtPolyDetail_triCount_set(long jarg1, PolyDetail jarg1_, short jarg2);

    public static native short dtPolyDetail_triCount_get(long jarg1, PolyDetail jarg1_);

    public static native long new_dtPolyDetail();

    public static native void delete_dtPolyDetail(long jarg1);

    public static native void dtLink_ref_set(long jarg1, Link jarg1_, long jarg2);

    public static native long dtLink_ref_get(long jarg1, Link jarg1_);

    public static native void dtLink_next_set(long jarg1, Link jarg1_, long jarg2);

    public static native long dtLink_next_get(long jarg1, Link jarg1_);

    public static native void dtLink_edge_set(long jarg1, Link jarg1_, short jarg2);

    public static native short dtLink_edge_get(long jarg1, Link jarg1_);

    public static native void dtLink_side_set(long jarg1, Link jarg1_, short jarg2);

    public static native short dtLink_side_get(long jarg1, Link jarg1_);

    public static native void dtLink_bmin_set(long jarg1, Link jarg1_, short jarg2);

    public static native short dtLink_bmin_get(long jarg1, Link jarg1_);

    public static native void dtLink_bmax_set(long jarg1, Link jarg1_, short jarg2);

    public static native short dtLink_bmax_get(long jarg1, Link jarg1_);

    public static native long new_dtLink();

    public static native void delete_dtLink(long jarg1);

    public static native void dtBVNode_bmin_set(long jarg1, BVNode jarg1_, long jarg2);

    public static native long dtBVNode_bmin_get(long jarg1, BVNode jarg1_);

    public static native void dtBVNode_bmax_set(long jarg1, BVNode jarg1_, long jarg2);

    public static native long dtBVNode_bmax_get(long jarg1, BVNode jarg1_);

    public static native void dtBVNode_i_set(long jarg1, BVNode jarg1_, int jarg2);

    public static native int dtBVNode_i_get(long jarg1, BVNode jarg1_);

    public static native long new_dtBVNode();

    public static native void delete_dtBVNode(long jarg1);

    public static native void dtOffMeshConnection_pos_set(long jarg1, OffMeshConnection jarg1_, long jarg2);

    public static native long dtOffMeshConnection_pos_get(long jarg1, OffMeshConnection jarg1_);

    public static native void dtOffMeshConnection_rad_set(long jarg1, OffMeshConnection jarg1_, float jarg2);

    public static native float dtOffMeshConnection_rad_get(long jarg1, OffMeshConnection jarg1_);

    public static native void dtOffMeshConnection_poly_set(long jarg1, OffMeshConnection jarg1_, int jarg2);

    public static native int dtOffMeshConnection_poly_get(long jarg1, OffMeshConnection jarg1_);

    public static native void dtOffMeshConnection_flags_set(long jarg1, OffMeshConnection jarg1_, short jarg2);

    public static native short dtOffMeshConnection_flags_get(long jarg1, OffMeshConnection jarg1_);

    public static native void dtOffMeshConnection_side_set(long jarg1, OffMeshConnection jarg1_, short jarg2);

    public static native short dtOffMeshConnection_side_get(long jarg1, OffMeshConnection jarg1_);

    public static native void dtOffMeshConnection_userId_set(long jarg1, OffMeshConnection jarg1_, long jarg2);

    public static native long dtOffMeshConnection_userId_get(long jarg1, OffMeshConnection jarg1_);

    public static native long new_dtOffMeshConnection();

    public static native void delete_dtOffMeshConnection(long jarg1);

    public static native void dtMeshHeader_magic_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_magic_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_version_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_version_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_x_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_x_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_y_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_y_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_layer_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_layer_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_userId_set(long jarg1, MeshHeader jarg1_, long jarg2);

    public static native long dtMeshHeader_userId_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_polyCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_polyCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_vertCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_vertCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_maxLinkCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_maxLinkCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_detailMeshCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_detailMeshCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_detailVertCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_detailVertCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_detailTriCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_detailTriCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_bvNodeCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_bvNodeCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_offMeshConCount_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_offMeshConCount_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_offMeshBase_set(long jarg1, MeshHeader jarg1_, int jarg2);

    public static native int dtMeshHeader_offMeshBase_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_walkableHeight_set(long jarg1, MeshHeader jarg1_, float jarg2);

    public static native float dtMeshHeader_walkableHeight_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_walkableRadius_set(long jarg1, MeshHeader jarg1_, float jarg2);

    public static native float dtMeshHeader_walkableRadius_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_walkableClimb_set(long jarg1, MeshHeader jarg1_, float jarg2);

    public static native float dtMeshHeader_walkableClimb_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_bmin_set(long jarg1, MeshHeader jarg1_, long jarg2);

    public static native long dtMeshHeader_bmin_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_bmax_set(long jarg1, MeshHeader jarg1_, long jarg2);

    public static native long dtMeshHeader_bmax_get(long jarg1, MeshHeader jarg1_);

    public static native void dtMeshHeader_bvQuantFactor_set(long jarg1, MeshHeader jarg1_, float jarg2);

    public static native float dtMeshHeader_bvQuantFactor_get(long jarg1, MeshHeader jarg1_);

    public static native long new_dtMeshHeader();

    public static native void delete_dtMeshHeader(long jarg1);

    public static native void dtMeshTile_salt_set(long jarg1, MeshTile jarg1_, long jarg2);

    public static native long dtMeshTile_salt_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_linksFreeList_set(long jarg1, MeshTile jarg1_, long jarg2);

    public static native long dtMeshTile_linksFreeList_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_header_set(long jarg1, MeshTile jarg1_, long jarg2, MeshHeader jarg2_);

    public static native long dtMeshTile_header_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_polys_set(long jarg1, MeshTile jarg1_, long jarg2, Poly jarg2_);

    public static native long dtMeshTile_polys_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_verts_set(long jarg1, MeshTile jarg1_, long jarg2);

    public static native long dtMeshTile_verts_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_links_set(long jarg1, MeshTile jarg1_, long jarg2, Link jarg2_);

    public static native long dtMeshTile_links_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_detailMeshes_set(long jarg1, MeshTile jarg1_, long jarg2, PolyDetail jarg2_);

    public static native long dtMeshTile_detailMeshes_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_detailVerts_set(long jarg1, MeshTile jarg1_, long jarg2);

    public static native long dtMeshTile_detailVerts_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_detailTris_set(long jarg1, MeshTile jarg1_, long jarg2);

    public static native long dtMeshTile_detailTris_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_bvTree_set(long jarg1, MeshTile jarg1_, long jarg2, BVNode jarg2_);

    public static native long dtMeshTile_bvTree_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_offMeshCons_set(long jarg1, MeshTile jarg1_, long jarg2, OffMeshConnection jarg2_);

    public static native long dtMeshTile_offMeshCons_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_data_set(long jarg1, MeshTile jarg1_, long jarg2);

    public static native long dtMeshTile_data_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_dataSize_set(long jarg1, MeshTile jarg1_, int jarg2);

    public static native int dtMeshTile_dataSize_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_flags_set(long jarg1, MeshTile jarg1_, int jarg2);

    public static native int dtMeshTile_flags_get(long jarg1, MeshTile jarg1_);

    public static native void dtMeshTile_next_set(long jarg1, MeshTile jarg1_, long jarg2, MeshTile jarg2_);

    public static native long dtMeshTile_next_get(long jarg1, MeshTile jarg1_);

    public static native long new_dtMeshTile();

    public static native void delete_dtMeshTile(long jarg1);

    public static native void dtNavMeshParams_orig_set(long jarg1, NavMeshParams jarg1_, long jarg2);

    public static native long dtNavMeshParams_orig_get(long jarg1, NavMeshParams jarg1_);

    public static native void dtNavMeshParams_tileWidth_set(long jarg1, NavMeshParams jarg1_, float jarg2);

    public static native float dtNavMeshParams_tileWidth_get(long jarg1, NavMeshParams jarg1_);

    public static native void dtNavMeshParams_tileHeight_set(long jarg1, NavMeshParams jarg1_, float jarg2);

    public static native float dtNavMeshParams_tileHeight_get(long jarg1, NavMeshParams jarg1_);

    public static native void dtNavMeshParams_maxTiles_set(long jarg1, NavMeshParams jarg1_, int jarg2);

    public static native int dtNavMeshParams_maxTiles_get(long jarg1, NavMeshParams jarg1_);

    public static native void dtNavMeshParams_maxPolys_set(long jarg1, NavMeshParams jarg1_, int jarg2);

    public static native int dtNavMeshParams_maxPolys_get(long jarg1, NavMeshParams jarg1_);

    public static native long new_dtNavMeshParams();

    public static native void delete_dtNavMeshParams(long jarg1);

    public static native long new_dtNavMesh();

    public static native void delete_dtNavMesh(long jarg1);

    public static native long dtNavMesh_init__SWIG_0(long jarg1, NavMesh jarg1_, long jarg2, NavMeshParams jarg2_);

    public static native long dtNavMesh_init__SWIG_1(long jarg1, NavMesh jarg1_, long jarg2, int jarg3, int jarg4);

    public static native long dtNavMesh_getParams(long jarg1, NavMesh jarg1_);

    public static native long dtNavMesh_addTile(long jarg1, NavMesh jarg1_, long jarg2, int jarg3, int jarg4, long jarg5, long jarg6);

    public static native long dtNavMesh_removeTile(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4);

    public static native void dtNavMesh_calcTileLoc(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4);

    public static native long dtNavMesh_getTileAt(long jarg1, NavMesh jarg1_, int jarg2, int jarg3, int jarg4);

    public static native int dtNavMesh_getTilesAt(long jarg1, NavMesh jarg1_, int jarg2, int jarg3, long jarg4, int jarg5);

    public static native long dtNavMesh_getTileRefAt(long jarg1, NavMesh jarg1_, int jarg2, int jarg3, int jarg4);

    public static native long dtNavMesh_getTileRef(long jarg1, NavMesh jarg1_, long jarg2, MeshTile jarg2_);

    public static native long dtNavMesh_getTileByRef(long jarg1, NavMesh jarg1_, long jarg2);

    public static native int dtNavMesh_getMaxTiles(long jarg1, NavMesh jarg1_);

    public static native long dtNavMesh_getTile(long jarg1, NavMesh jarg1_, int jarg2);

    public static native long dtNavMesh_getTileAndPolyByRef(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4);

    public static native void dtNavMesh_getTileAndPolyByRefUnsafe(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4);

    public static native boolean dtNavMesh_isValidPolyRef(long jarg1, NavMesh jarg1_, long jarg2);

    public static native long dtNavMesh_getPolyRefBase(long jarg1, NavMesh jarg1_, long jarg2, MeshTile jarg2_);

    public static native long dtNavMesh_getOffMeshConnectionPolyEndPoints(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4, long jarg5);

    public static native long dtNavMesh_getOffMeshConnectionByRef(long jarg1, NavMesh jarg1_, long jarg2);

    public static native long dtNavMesh_setPolyFlags(long jarg1, NavMesh jarg1_, long jarg2, int jarg3);

    public static native long dtNavMesh_getPolyFlags(long jarg1, NavMesh jarg1_, long jarg2, long jarg3);

    public static native long dtNavMesh_setPolyArea(long jarg1, NavMesh jarg1_, long jarg2, short jarg3);

    public static native long dtNavMesh_getPolyArea(long jarg1, NavMesh jarg1_, long jarg2, long jarg3);

    public static native int dtNavMesh_getTileStateSize(long jarg1, NavMesh jarg1_, long jarg2, MeshTile jarg2_);

    public static native long dtNavMesh_storeTileState(long jarg1, NavMesh jarg1_, long jarg2, MeshTile jarg2_, long jarg3, int jarg4);

    public static native long dtNavMesh_restoreTileState(long jarg1, NavMesh jarg1_, long jarg2, MeshTile jarg2_, long jarg3, int jarg4);

    public static native long dtNavMesh_encodePolyId(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4);

    public static native void dtNavMesh_decodePolyId(long jarg1, NavMesh jarg1_, long jarg2, long jarg3, long jarg4, long jarg5);

    public static native long dtNavMesh_decodePolyIdSalt(long jarg1, NavMesh jarg1_, long jarg2);

    public static native long dtNavMesh_decodePolyIdTile(long jarg1, NavMesh jarg1_, long jarg2);

    public static native long dtNavMesh_decodePolyIdPoly(long jarg1, NavMesh jarg1_, long jarg2);

    public static native long dtAllocNavMesh();

    public static native void dtFreeNavMesh(long jarg1, NavMesh jarg1_);

    public static native void dtNavMeshCreateParams_verts_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_verts_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_vertCount_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_vertCount_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_polys_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_polys_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_polyFlags_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_polyFlags_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_polyAreas_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_polyAreas_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_polyCount_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_polyCount_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_nvp_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_nvp_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_detailMeshes_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_detailMeshes_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_detailVerts_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_detailVerts_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_detailVertsCount_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_detailVertsCount_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_detailTris_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_detailTris_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_detailTriCount_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_detailTriCount_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConVerts_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_offMeshConVerts_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConRad_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_offMeshConRad_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConFlags_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_offMeshConFlags_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConAreas_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_offMeshConAreas_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConDir_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_offMeshConDir_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConUserID_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_offMeshConUserID_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_offMeshConCount_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_offMeshConCount_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_userId_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_userId_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_tileX_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_tileX_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_tileY_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_tileY_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_tileLayer_set(long jarg1, NavMeshCreateParams jarg1_, int jarg2);

    public static native int dtNavMeshCreateParams_tileLayer_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_bmin_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_bmin_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_bmax_set(long jarg1, NavMeshCreateParams jarg1_, long jarg2);

    public static native long dtNavMeshCreateParams_bmax_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_walkableHeight_set(long jarg1, NavMeshCreateParams jarg1_, float jarg2);

    public static native float dtNavMeshCreateParams_walkableHeight_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_walkableRadius_set(long jarg1, NavMeshCreateParams jarg1_, float jarg2);

    public static native float dtNavMeshCreateParams_walkableRadius_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_walkableClimb_set(long jarg1, NavMeshCreateParams jarg1_, float jarg2);

    public static native float dtNavMeshCreateParams_walkableClimb_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_cs_set(long jarg1, NavMeshCreateParams jarg1_, float jarg2);

    public static native float dtNavMeshCreateParams_cs_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_ch_set(long jarg1, NavMeshCreateParams jarg1_, float jarg2);

    public static native float dtNavMeshCreateParams_ch_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native void dtNavMeshCreateParams_buildBvTree_set(long jarg1, NavMeshCreateParams jarg1_, boolean jarg2);

    public static native boolean dtNavMeshCreateParams_buildBvTree_get(long jarg1, NavMeshCreateParams jarg1_);

    public static native long new_dtNavMeshCreateParams();

    public static native void delete_dtNavMeshCreateParams(long jarg1);

    public static native boolean dtCreateNavMeshData(long jarg1, NavMeshCreateParams jarg1_, long jarg2, long jarg3);

    public static native boolean dtNavMeshHeaderSwapEndian(long jarg1, int jarg2);

    public static native boolean dtNavMeshDataSwapEndian(long jarg1, int jarg2);

    public static native long new_dtQueryFilter();

    public static native boolean dtQueryFilter_passFilter(long jarg1, QueryFilter jarg1_, long jarg2, long jarg3, MeshTile jarg3_, long jarg4, Poly jarg4_);

    public static native float dtQueryFilter_getCost(long jarg1, QueryFilter jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, MeshTile jarg5_, long jarg6, Poly jarg6_, long jarg7, long jarg8, MeshTile jarg8_, long jarg9, Poly jarg9_, long jarg10, long jarg11, MeshTile jarg11_, long jarg12, Poly jarg12_);

    public static native float dtQueryFilter_getAreaCost(long jarg1, QueryFilter jarg1_, int jarg2);

    public static native void dtQueryFilter_setAreaCost(long jarg1, QueryFilter jarg1_, int jarg2, float jarg3);

    public static native int dtQueryFilter_getIncludeFlags(long jarg1, QueryFilter jarg1_);

    public static native void dtQueryFilter_setIncludeFlags(long jarg1, QueryFilter jarg1_, int jarg2);

    public static native int dtQueryFilter_getExcludeFlags(long jarg1, QueryFilter jarg1_);

    public static native void dtQueryFilter_setExcludeFlags(long jarg1, QueryFilter jarg1_, int jarg2);

    public static native void delete_dtQueryFilter(long jarg1);

    public static native long new_dtNavMeshQuery();

    public static native void delete_dtNavMeshQuery(long jarg1);

    public static native long dtNavMeshQuery_init(long jarg1, NavMeshQuery jarg1_, long jarg2, NavMesh jarg2_, int jarg3);

    public static native long dtNavMeshQuery_findPath(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, QueryFilter jarg6_, long jarg7, long jarg8, int jarg9);

    public static native long dtNavMeshQuery_findStraightPath__SWIG_0(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, int jarg5, long jarg6, long jarg7, long jarg8, long jarg9, int jarg10, int jarg11);

    public static native long dtNavMeshQuery_findStraightPath__SWIG_1(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, int jarg5, long jarg6, long jarg7, long jarg8, long jarg9, int jarg10);

    public static native long dtNavMeshQuery_initSlicedFindPath(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, QueryFilter jarg6_);

    public static native long dtNavMeshQuery_updateSlicedFindPath(long jarg1, NavMeshQuery jarg1_, int jarg2, long jarg3);

    public static native long dtNavMeshQuery_finalizeSlicedFindPath(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, int jarg4);

    public static native long dtNavMeshQuery_finalizeSlicedFindPathPartial(long jarg1, NavMeshQuery jarg1_, long jarg2, int jarg3, long jarg4, long jarg5, int jarg6);

    public static native long dtNavMeshQuery_findPolysAroundCircle(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, float jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8, long jarg9, int jarg10);

    public static native long dtNavMeshQuery_findPolysAroundShape(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, int jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8, long jarg9, int jarg10);

    public static native long dtNavMeshQuery_findNearestPoly(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, QueryFilter jarg4_, long jarg5, long jarg6);

    public static native long dtNavMeshQuery_queryPolygons(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, QueryFilter jarg4_, long jarg5, long jarg6, int jarg7);

    public static native long dtNavMeshQuery_findLocalNeighbourhood(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, float jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8, int jarg9);

    public static native long dtNavMeshQuery_moveAlongSurface(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8, int jarg9);

    public static native long dtNavMeshQuery_raycast(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8, long jarg9, int jarg10);

    public static native long dtNavMeshQuery_findDistanceToWall(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, float jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8);

    public static native long dtNavMeshQuery_getPolyWallSegments(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, QueryFilter jarg3_, long jarg4, long jarg5, long jarg6, int jarg7);

    public static native long dtNavMeshQuery_findRandomPoint(long jarg1, NavMeshQuery jarg1_, long jarg2, QueryFilter jarg2_, long jarg3, long jarg4, long jarg5);

    public static native long dtNavMeshQuery_findRandomPointAroundCircle(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, float jarg4, long jarg5, QueryFilter jarg5_, long jarg6, long jarg7, long jarg8);

    public static native long dtNavMeshQuery_closestPointOnPoly(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4, long jarg5);

    public static native long dtNavMeshQuery_closestPointOnPolyBoundary(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4);

    public static native long dtNavMeshQuery_getPolyHeight(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, long jarg4);

    public static native boolean dtNavMeshQuery_isValidPolyRef(long jarg1, NavMeshQuery jarg1_, long jarg2, long jarg3, QueryFilter jarg3_);

    public static native boolean dtNavMeshQuery_isInClosedList(long jarg1, NavMeshQuery jarg1_, long jarg2);

    public static native long dtNavMeshQuery_getNodePool(long jarg1, NavMeshQuery jarg1_);

    public static native long dtNavMeshQuery_getAttachedNavMesh(long jarg1, NavMeshQuery jarg1_);

    public static native long dtAllocNavMeshQuery();

    public static native void dtFreeNavMeshQuery(long jarg1, NavMeshQuery jarg1_);

    public static native int DT_NODE_OPEN_get();

    public static native int DT_NODE_CLOSED_get();

    public static native int DT_NULL_IDX_get();

    public static native void dtNode_pos_set(long jarg1, Node jarg1_, long jarg2);

    public static native long dtNode_pos_get(long jarg1, Node jarg1_);

    public static native void dtNode_cost_set(long jarg1, Node jarg1_, float jarg2);

    public static native float dtNode_cost_get(long jarg1, Node jarg1_);

    public static native void dtNode_total_set(long jarg1, Node jarg1_, float jarg2);

    public static native float dtNode_total_get(long jarg1, Node jarg1_);

    public static native void dtNode_pidx_set(long jarg1, Node jarg1_, long jarg2);

    public static native long dtNode_pidx_get(long jarg1, Node jarg1_);

    public static native void dtNode_flags_set(long jarg1, Node jarg1_, long jarg2);

    public static native long dtNode_flags_get(long jarg1, Node jarg1_);

    public static native void dtNode_id_set(long jarg1, Node jarg1_, long jarg2);

    public static native long dtNode_id_get(long jarg1, Node jarg1_);

    public static native long new_dtNode();

    public static native void delete_dtNode(long jarg1);

    public static native long new_dtNodePool(int jarg1, int jarg2);

    public static native void delete_dtNodePool(long jarg1);

    public static native void dtNodePool_clear(long jarg1, NodePool jarg1_);

    public static native long dtNodePool_getNode(long jarg1, NodePool jarg1_, long jarg2);

    public static native long dtNodePool_findNode(long jarg1, NodePool jarg1_, long jarg2);

    public static native long dtNodePool_getNodeIdx(long jarg1, NodePool jarg1_, long jarg2, Node jarg2_);

    public static native long dtNodePool_getNodeAtIdx__SWIG_0(long jarg1, NodePool jarg1_, long jarg2);

    public static native int dtNodePool_getMemUsed(long jarg1, NodePool jarg1_);

    public static native int dtNodePool_getMaxNodes(long jarg1, NodePool jarg1_);

    public static native int dtNodePool_getHashSize(long jarg1, NodePool jarg1_);

    public static native int dtNodePool_getFirst(long jarg1, NodePool jarg1_, int jarg2);

    public static native int dtNodePool_getNext(long jarg1, NodePool jarg1_, int jarg2);

    public static native long new_dtNodeQueue(int jarg1);

    public static native void delete_dtNodeQueue(long jarg1);

    public static native void dtNodeQueue_clear(long jarg1, NodeQueue jarg1_);

    public static native long dtNodeQueue_top(long jarg1, NodeQueue jarg1_);

    public static native long dtNodeQueue_pop(long jarg1, NodeQueue jarg1_);

    public static native void dtNodeQueue_push(long jarg1, NodeQueue jarg1_, long jarg2, Node jarg2_);

    public static native void dtNodeQueue_modify(long jarg1, NodeQueue jarg1_, long jarg2, Node jarg2_);

    public static native boolean dtNodeQueue_empty(long jarg1, NodeQueue jarg1_);

    public static native int dtNodeQueue_getMemUsed(long jarg1, NodeQueue jarg1_);

    public static native int dtNodeQueue_getCapacity(long jarg1, NodeQueue jarg1_);

    public static native void dtObstacleCircle_p_set(long jarg1, dtObstacleCircle jarg1_, long jarg2);

    public static native long dtObstacleCircle_p_get(long jarg1, dtObstacleCircle jarg1_);

    public static native void dtObstacleCircle_vel_set(long jarg1, dtObstacleCircle jarg1_, long jarg2);

    public static native long dtObstacleCircle_vel_get(long jarg1, dtObstacleCircle jarg1_);

    public static native void dtObstacleCircle_dvel_set(long jarg1, dtObstacleCircle jarg1_, long jarg2);

    public static native long dtObstacleCircle_dvel_get(long jarg1, dtObstacleCircle jarg1_);

    public static native void dtObstacleCircle_rad_set(long jarg1, dtObstacleCircle jarg1_, float jarg2);

    public static native float dtObstacleCircle_rad_get(long jarg1, dtObstacleCircle jarg1_);

    public static native void dtObstacleCircle_dp_set(long jarg1, dtObstacleCircle jarg1_, long jarg2);

    public static native long dtObstacleCircle_dp_get(long jarg1, dtObstacleCircle jarg1_);

    public static native void dtObstacleCircle_np_set(long jarg1, dtObstacleCircle jarg1_, long jarg2);

    public static native long dtObstacleCircle_np_get(long jarg1, dtObstacleCircle jarg1_);

    public static native long new_dtObstacleCircle();

    public static native void delete_dtObstacleCircle(long jarg1);

    public static native void dtObstacleSegment_p_set(long jarg1, dtObstacleSegment jarg1_, long jarg2);

    public static native long dtObstacleSegment_p_get(long jarg1, dtObstacleSegment jarg1_);

    public static native void dtObstacleSegment_q_set(long jarg1, dtObstacleSegment jarg1_, long jarg2);

    public static native long dtObstacleSegment_q_get(long jarg1, dtObstacleSegment jarg1_);

    public static native void dtObstacleSegment_touch_set(long jarg1, dtObstacleSegment jarg1_, boolean jarg2);

    public static native boolean dtObstacleSegment_touch_get(long jarg1, dtObstacleSegment jarg1_);

    public static native long new_dtObstacleSegment();

    public static native void delete_dtObstacleSegment(long jarg1);

    public static native long new_dtObstacleAvoidanceDebugData();

    public static native void delete_dtObstacleAvoidanceDebugData(long jarg1);

    public static native boolean dtObstacleAvoidanceDebugData_init(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native void dtObstacleAvoidanceDebugData_reset(long jarg1, dtObstacleAvoidanceDebugData jarg1_);

    public static native void dtObstacleAvoidanceDebugData_addSample(long jarg1, dtObstacleAvoidanceDebugData jarg1_, long jarg2, float jarg3, float jarg4, float jarg5, float jarg6, float jarg7, float jarg8);

    public static native void dtObstacleAvoidanceDebugData_normalizeSamples(long jarg1, dtObstacleAvoidanceDebugData jarg1_);

    public static native int dtObstacleAvoidanceDebugData_getSampleCount(long jarg1, dtObstacleAvoidanceDebugData jarg1_);

    public static native long dtObstacleAvoidanceDebugData_getSampleVelocity(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native float dtObstacleAvoidanceDebugData_getSampleSize(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native float dtObstacleAvoidanceDebugData_getSamplePenalty(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native float dtObstacleAvoidanceDebugData_getSampleDesiredVelocityPenalty(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native float dtObstacleAvoidanceDebugData_getSampleCurrentVelocityPenalty(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native float dtObstacleAvoidanceDebugData_getSamplePreferredSidePenalty(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native float dtObstacleAvoidanceDebugData_getSampleCollisionTimePenalty(long jarg1, dtObstacleAvoidanceDebugData jarg1_, int jarg2);

    public static native long dtAllocObstacleAvoidanceDebugData();

    public static native void dtFreeObstacleAvoidanceDebugData(long jarg1, dtObstacleAvoidanceDebugData jarg1_);

    public static native int DT_MAX_PATTERN_DIVS_get();

    public static native int DT_MAX_PATTERN_RINGS_get();

    public static native void dtObstacleAvoidanceParams_velBias_set(long jarg1, dtObstacleAvoidanceParams jarg1_, float jarg2);

    public static native float dtObstacleAvoidanceParams_velBias_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_weightDesVel_set(long jarg1, dtObstacleAvoidanceParams jarg1_, float jarg2);

    public static native float dtObstacleAvoidanceParams_weightDesVel_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_weightCurVel_set(long jarg1, dtObstacleAvoidanceParams jarg1_, float jarg2);

    public static native float dtObstacleAvoidanceParams_weightCurVel_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_weightSide_set(long jarg1, dtObstacleAvoidanceParams jarg1_, float jarg2);

    public static native float dtObstacleAvoidanceParams_weightSide_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_weightToi_set(long jarg1, dtObstacleAvoidanceParams jarg1_, float jarg2);

    public static native float dtObstacleAvoidanceParams_weightToi_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_horizTime_set(long jarg1, dtObstacleAvoidanceParams jarg1_, float jarg2);

    public static native float dtObstacleAvoidanceParams_horizTime_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_gridSize_set(long jarg1, dtObstacleAvoidanceParams jarg1_, short jarg2);

    public static native short dtObstacleAvoidanceParams_gridSize_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_adaptiveDivs_set(long jarg1, dtObstacleAvoidanceParams jarg1_, short jarg2);

    public static native short dtObstacleAvoidanceParams_adaptiveDivs_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_adaptiveRings_set(long jarg1, dtObstacleAvoidanceParams jarg1_, short jarg2);

    public static native short dtObstacleAvoidanceParams_adaptiveRings_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native void dtObstacleAvoidanceParams_adaptiveDepth_set(long jarg1, dtObstacleAvoidanceParams jarg1_, short jarg2);

    public static native short dtObstacleAvoidanceParams_adaptiveDepth_get(long jarg1, dtObstacleAvoidanceParams jarg1_);

    public static native long new_dtObstacleAvoidanceParams();

    public static native void delete_dtObstacleAvoidanceParams(long jarg1);

    public static native long new_dtObstacleAvoidanceQuery();

    public static native void delete_dtObstacleAvoidanceQuery(long jarg1);

    public static native boolean dtObstacleAvoidanceQuery_init(long jarg1, dtObstacleAvoidanceQuery jarg1_, int jarg2, int jarg3);

    public static native void dtObstacleAvoidanceQuery_reset(long jarg1, dtObstacleAvoidanceQuery jarg1_);

    public static native void dtObstacleAvoidanceQuery_addCircle(long jarg1, dtObstacleAvoidanceQuery jarg1_, long jarg2, float jarg3, long jarg4, long jarg5);

    public static native void dtObstacleAvoidanceQuery_addSegment(long jarg1, dtObstacleAvoidanceQuery jarg1_, long jarg2, long jarg3);

    public static native int dtObstacleAvoidanceQuery_sampleVelocityGrid__SWIG_0(long jarg1, dtObstacleAvoidanceQuery jarg1_, long jarg2, float jarg3, float jarg4, long jarg5, long jarg6, long jarg7, long jarg8, dtObstacleAvoidanceParams jarg8_, long jarg9, dtObstacleAvoidanceDebugData jarg9_);

    public static native int dtObstacleAvoidanceQuery_sampleVelocityGrid__SWIG_1(long jarg1, dtObstacleAvoidanceQuery jarg1_, long jarg2, float jarg3, float jarg4, long jarg5, long jarg6, long jarg7, long jarg8, dtObstacleAvoidanceParams jarg8_);

    public static native int dtObstacleAvoidanceQuery_sampleVelocityAdaptive__SWIG_0(long jarg1, dtObstacleAvoidanceQuery jarg1_, long jarg2, float jarg3, float jarg4, long jarg5, long jarg6, long jarg7, long jarg8, dtObstacleAvoidanceParams jarg8_, long jarg9, dtObstacleAvoidanceDebugData jarg9_);

    public static native int dtObstacleAvoidanceQuery_sampleVelocityAdaptive__SWIG_1(long jarg1, dtObstacleAvoidanceQuery jarg1_, long jarg2, float jarg3, float jarg4, long jarg5, long jarg6, long jarg7, long jarg8, dtObstacleAvoidanceParams jarg8_);

    public static native int dtObstacleAvoidanceQuery_getObstacleCircleCount(long jarg1, dtObstacleAvoidanceQuery jarg1_);

    public static native long dtObstacleAvoidanceQuery_getObstacleCircle(long jarg1, dtObstacleAvoidanceQuery jarg1_, int jarg2);

    public static native int dtObstacleAvoidanceQuery_getObstacleSegmentCount(long jarg1, dtObstacleAvoidanceQuery jarg1_);

    public static native long dtObstacleAvoidanceQuery_getObstacleSegment(long jarg1, dtObstacleAvoidanceQuery jarg1_, int jarg2);

    public static native long dtAllocObstacleAvoidanceQuery();

    public static native void dtFreeObstacleAvoidanceQuery(long jarg1, dtObstacleAvoidanceQuery jarg1_);

    public static native long new_dtPathCorridor();

    public static native void delete_dtPathCorridor(long jarg1);

    public static native boolean dtPathCorridor_init(long jarg1, PathCorridor jarg1_, int jarg2);

    public static native void dtPathCorridor_reset(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3);

    public static native int dtPathCorridor_findCorners(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3, long jarg4, int jarg5, long jarg6, NavMeshQuery jarg6_, long jarg7, QueryFilter jarg7_);

    public static native void dtPathCorridor_optimizePathVisibility(long jarg1, PathCorridor jarg1_, long jarg2, float jarg3, long jarg4, NavMeshQuery jarg4_, long jarg5, QueryFilter jarg5_);

    public static native boolean dtPathCorridor_optimizePathTopology(long jarg1, PathCorridor jarg1_, long jarg2, NavMeshQuery jarg2_, long jarg3, QueryFilter jarg3_);

    public static native boolean dtPathCorridor_moveOverOffmeshConnection(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, NavMeshQuery jarg6_);

    public static native boolean dtPathCorridor_fixPathStart(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3);

    public static native boolean dtPathCorridor_trimInvalidPath(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3, long jarg4, NavMeshQuery jarg4_, long jarg5, QueryFilter jarg5_);

    public static native boolean dtPathCorridor_isValid(long jarg1, PathCorridor jarg1_, int jarg2, long jarg3, NavMeshQuery jarg3_, long jarg4, QueryFilter jarg4_);

    public static native boolean dtPathCorridor_movePosition(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3, NavMeshQuery jarg3_, long jarg4, QueryFilter jarg4_);

    public static native boolean dtPathCorridor_moveTargetPosition(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3, NavMeshQuery jarg3_, long jarg4, QueryFilter jarg4_);

    public static native void dtPathCorridor_setCorridor(long jarg1, PathCorridor jarg1_, long jarg2, long jarg3, int jarg4);

    public static native long dtPathCorridor_getPos(long jarg1, PathCorridor jarg1_);

    public static native long dtPathCorridor_getTarget(long jarg1, PathCorridor jarg1_);

    public static native long dtPathCorridor_getFirstPoly(long jarg1, PathCorridor jarg1_);

    public static native long dtPathCorridor_getLastPoly(long jarg1, PathCorridor jarg1_);

    public static native long dtPathCorridor_getPath(long jarg1, PathCorridor jarg1_);

    public static native int dtPathCorridor_getPathCount(long jarg1, PathCorridor jarg1_);

    public static native int dtMergeCorridorStartMoved(long jarg1, int jarg2, int jarg3, long jarg4, int jarg5);

    public static native int dtMergeCorridorEndMoved(long jarg1, int jarg2, int jarg3, long jarg4, int jarg5);

    public static native int dtMergeCorridorStartShortcut(long jarg1, int jarg2, int jarg3, long jarg4, int jarg5);

    public static native long DT_PATHQ_INVALID_get();

    public static native long new_dtPathQueue();

    public static native void delete_dtPathQueue(long jarg1);

    public static native boolean dtPathQueue_init(long jarg1, dtPathQueue jarg1_, int jarg2, int jarg3, long jarg4, NavMesh jarg4_);

    public static native void dtPathQueue_update(long jarg1, dtPathQueue jarg1_, int jarg2);

    public static native long dtPathQueue_request(long jarg1, dtPathQueue jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, QueryFilter jarg6_);

    public static native long dtPathQueue_getRequestStatus(long jarg1, dtPathQueue jarg1_, long jarg2);

    public static native long dtPathQueue_getPathResult(long jarg1, dtPathQueue jarg1_, long jarg2, long jarg3, long jarg4, int jarg5);

    public static native long dtPathQueue_getNavQuery(long jarg1, dtPathQueue jarg1_);

    public static native long new_dtProximityGrid();

    public static native void delete_dtProximityGrid(long jarg1);

    public static native boolean dtProximityGrid_init(long jarg1, dtProximityGrid jarg1_, int jarg2, float jarg3);

    public static native void dtProximityGrid_clear(long jarg1, dtProximityGrid jarg1_);

    public static native void dtProximityGrid_addItem(long jarg1, dtProximityGrid jarg1_, int jarg2, float jarg3, float jarg4, float jarg5, float jarg6);

    public static native int dtProximityGrid_queryItems(long jarg1, dtProximityGrid jarg1_, float jarg2, float jarg3, float jarg4, float jarg5, long jarg6, int jarg7);

    public static native int dtProximityGrid_getItemCountAt(long jarg1, dtProximityGrid jarg1_, int jarg2, int jarg3);

    public static native long dtProximityGrid_getBounds(long jarg1, dtProximityGrid jarg1_);

    public static native float dtProximityGrid_getCellSize(long jarg1, dtProximityGrid jarg1_);

    public static native long dtAllocProximityGrid();

    public static native void dtFreeProximityGrid(long jarg1, dtProximityGrid jarg1_);

    public static native long DT_FAILURE_get();

    public static native long DT_SUCCESS_get();

    public static native long DT_IN_PROGRESS_get();

    public static native long DT_STATUS_DETAIL_MASK_get();

    public static native long DT_WRONG_MAGIC_get();

    public static native long DT_WRONG_VERSION_get();

    public static native long DT_OUT_OF_MEMORY_get();

    public static native long DT_INVALID_PARAM_get();

    public static native long DT_BUFFER_TOO_SMALL_get();

    public static native long DT_OUT_OF_NODES_get();

    public static native long DT_PARTIAL_RESULT_get();

    public static native boolean dtStatusSucceed(long jarg1);

    public static native boolean dtStatusFailed(long jarg1);

    public static native boolean dtStatusInProgress(long jarg1);

    public static native boolean dtStatusDetail(long jarg1, long jarg2);

    public static native int DT_COMPRESSEDTILE_FREE_DATA_get();

    public static native void dtCompressedTile_salt_set(long jarg1, CompressedTile jarg1_, long jarg2);

    public static native long dtCompressedTile_salt_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_header_set(long jarg1, CompressedTile jarg1_, long jarg2, TileCacheLayerHeader jarg2_);

    public static native long dtCompressedTile_header_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_compressed_set(long jarg1, CompressedTile jarg1_, long jarg2);

    public static native long dtCompressedTile_compressed_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_compressedSize_set(long jarg1, CompressedTile jarg1_, int jarg2);

    public static native int dtCompressedTile_compressedSize_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_data_set(long jarg1, CompressedTile jarg1_, long jarg2);

    public static native long dtCompressedTile_data_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_dataSize_set(long jarg1, CompressedTile jarg1_, int jarg2);

    public static native int dtCompressedTile_dataSize_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_flags_set(long jarg1, CompressedTile jarg1_, long jarg2);

    public static native long dtCompressedTile_flags_get(long jarg1, CompressedTile jarg1_);

    public static native void dtCompressedTile_next_set(long jarg1, CompressedTile jarg1_, long jarg2, CompressedTile jarg2_);

    public static native long dtCompressedTile_next_get(long jarg1, CompressedTile jarg1_);

    public static native long new_dtCompressedTile();

    public static native void delete_dtCompressedTile(long jarg1);

    public static native int DT_MAX_TOUCHED_TILES_get();

    public static native void dtTileCacheObstacle_pos_set(long jarg1, TileCacheObstacle jarg1_, long jarg2);

    public static native long dtTileCacheObstacle_pos_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_radius_set(long jarg1, TileCacheObstacle jarg1_, float jarg2);

    public static native float dtTileCacheObstacle_radius_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_height_set(long jarg1, TileCacheObstacle jarg1_, float jarg2);

    public static native float dtTileCacheObstacle_height_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_touched_set(long jarg1, TileCacheObstacle jarg1_, long jarg2);

    public static native long dtTileCacheObstacle_touched_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_pending_set(long jarg1, TileCacheObstacle jarg1_, long jarg2);

    public static native long dtTileCacheObstacle_pending_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_salt_set(long jarg1, TileCacheObstacle jarg1_, int jarg2);

    public static native int dtTileCacheObstacle_salt_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_state_set(long jarg1, TileCacheObstacle jarg1_, short jarg2);

    public static native short dtTileCacheObstacle_state_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_ntouched_set(long jarg1, TileCacheObstacle jarg1_, short jarg2);

    public static native short dtTileCacheObstacle_ntouched_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_npending_set(long jarg1, TileCacheObstacle jarg1_, short jarg2);

    public static native short dtTileCacheObstacle_npending_get(long jarg1, TileCacheObstacle jarg1_);

    public static native void dtTileCacheObstacle_next_set(long jarg1, TileCacheObstacle jarg1_, long jarg2, TileCacheObstacle jarg2_);

    public static native long dtTileCacheObstacle_next_get(long jarg1, TileCacheObstacle jarg1_);

    public static native long new_dtTileCacheObstacle();

    public static native void delete_dtTileCacheObstacle(long jarg1);

    public static native void dtTileCacheParams_orig_set(long jarg1, TileCacheParams jarg1_, long jarg2);

    public static native long dtTileCacheParams_orig_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_cs_set(long jarg1, TileCacheParams jarg1_, float jarg2);

    public static native float dtTileCacheParams_cs_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_ch_set(long jarg1, TileCacheParams jarg1_, float jarg2);

    public static native float dtTileCacheParams_ch_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_width_set(long jarg1, TileCacheParams jarg1_, int jarg2);

    public static native int dtTileCacheParams_width_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_height_set(long jarg1, TileCacheParams jarg1_, int jarg2);

    public static native int dtTileCacheParams_height_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_walkableHeight_set(long jarg1, TileCacheParams jarg1_, float jarg2);

    public static native float dtTileCacheParams_walkableHeight_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_walkableRadius_set(long jarg1, TileCacheParams jarg1_, float jarg2);

    public static native float dtTileCacheParams_walkableRadius_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_walkableClimb_set(long jarg1, TileCacheParams jarg1_, float jarg2);

    public static native float dtTileCacheParams_walkableClimb_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_maxSimplificationError_set(long jarg1, TileCacheParams jarg1_, float jarg2);

    public static native float dtTileCacheParams_maxSimplificationError_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_maxTiles_set(long jarg1, TileCacheParams jarg1_, int jarg2);

    public static native int dtTileCacheParams_maxTiles_get(long jarg1, TileCacheParams jarg1_);

    public static native void dtTileCacheParams_maxObstacles_set(long jarg1, TileCacheParams jarg1_, int jarg2);

    public static native int dtTileCacheParams_maxObstacles_get(long jarg1, TileCacheParams jarg1_);

    public static native long new_dtTileCacheParams();

    public static native void delete_dtTileCacheParams(long jarg1);

    public static native void dtTileCacheMeshProcess_process(long jarg1, TileCacheMeshProcess jarg1_, long jarg2, NavMeshCreateParams jarg2_, long jarg3, long jarg4);

    public static native void delete_dtTileCacheMeshProcess(long jarg1);

    public static native long new_dtTileCache();

    public static native void delete_dtTileCache(long jarg1);

    public static native long dtTileCache_getAlloc(long jarg1, TileCache jarg1_);

    public static native long dtTileCache_getCompressor(long jarg1, TileCache jarg1_);

    public static native long dtTileCache_getParams(long jarg1, TileCache jarg1_);

    public static native int dtTileCache_getTileCount(long jarg1, TileCache jarg1_);

    public static native long dtTileCache_getTile(long jarg1, TileCache jarg1_, int jarg2);

    public static native int dtTileCache_getObstacleCount(long jarg1, TileCache jarg1_);

    public static native long dtTileCache_getObstacle(long jarg1, TileCache jarg1_, int jarg2);

    public static native long dtTileCache_getObstacleByRef(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtTileCache_getObstacleRef(long jarg1, TileCache jarg1_, long jarg2, TileCacheObstacle jarg2_);

    public static native long dtTileCache_init(long jarg1, TileCache jarg1_, long jarg2, TileCacheParams jarg2_, long jarg3, TileCacheAlloc jarg3_, long jarg4, TileCacheCompressor jarg4_, long jarg5, TileCacheMeshProcess jarg5_);

    public static native int dtTileCache_getTilesAt(long jarg1, TileCache jarg1_, int jarg2, int jarg3, long jarg4, int jarg5);

    public static native long dtTileCache_getTileAt(long jarg1, TileCache jarg1_, int jarg2, int jarg3, int jarg4);

    public static native long dtTileCache_getTileRef(long jarg1, TileCache jarg1_, long jarg2, CompressedTile jarg2_);

    public static native long dtTileCache_getTileByRef(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtTileCache_addTile(long jarg1, TileCache jarg1_, long jarg2, int jarg3, short jarg4, long jarg5);

    public static native long dtTileCache_removeTile(long jarg1, TileCache jarg1_, long jarg2, long jarg3, long jarg4);

    public static native long dtTileCache_addObstacle(long jarg1, TileCache jarg1_, long jarg2, float jarg3, float jarg4, long jarg5);

    public static native long dtTileCache_removeObstacle(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtTileCache_queryTiles(long jarg1, TileCache jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, int jarg6);

    public static native long dtTileCache_update(long jarg1, TileCache jarg1_, float jarg2, long jarg3, NavMesh jarg3_);

    public static native long dtTileCache_buildNavMeshTilesAt(long jarg1, TileCache jarg1_, int jarg2, int jarg3, long jarg4, NavMesh jarg4_);

    public static native long dtTileCache_buildNavMeshTile(long jarg1, TileCache jarg1_, long jarg2, long jarg3, NavMesh jarg3_);

    public static native void dtTileCache_calcTightTileBounds(long jarg1, TileCache jarg1_, long jarg2, TileCacheLayerHeader jarg2_, long jarg3, long jarg4);

    public static native void dtTileCache_getObstacleBounds(long jarg1, TileCache jarg1_, long jarg2, TileCacheObstacle jarg2_, long jarg3, long jarg4);

    public static native long dtTileCache_encodeTileId(long jarg1, TileCache jarg1_, long jarg2, long jarg3);

    public static native long dtTileCache_decodeTileIdSalt(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtTileCache_decodeTileIdTile(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtTileCache_encodeObstacleId(long jarg1, TileCache jarg1_, long jarg2, long jarg3);

    public static native long dtTileCache_decodeObstacleIdSalt(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtTileCache_decodeObstacleIdObstacle(long jarg1, TileCache jarg1_, long jarg2);

    public static native long dtAllocTileCache();

    public static native void dtFreeTileCache(long jarg1, TileCache jarg1_);

    public static native int DT_TILECACHE_MAGIC_get();

    public static native int DT_TILECACHE_VERSION_get();

    public static native short DT_TILECACHE_NULL_AREA_get();

    public static native short DT_TILECACHE_WALKABLE_AREA_get();

    public static native int DT_TILECACHE_NULL_IDX_get();

    public static native void dtTileCacheLayerHeader_magic_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_magic_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_version_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_version_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_tx_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_tx_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_ty_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_ty_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_tlayer_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_tlayer_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_bmin_set(long jarg1, TileCacheLayerHeader jarg1_, long jarg2);

    public static native long dtTileCacheLayerHeader_bmin_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_bmax_set(long jarg1, TileCacheLayerHeader jarg1_, long jarg2);

    public static native long dtTileCacheLayerHeader_bmax_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_hmin_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_hmin_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_hmax_set(long jarg1, TileCacheLayerHeader jarg1_, int jarg2);

    public static native int dtTileCacheLayerHeader_hmax_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_width_set(long jarg1, TileCacheLayerHeader jarg1_, short jarg2);

    public static native short dtTileCacheLayerHeader_width_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_height_set(long jarg1, TileCacheLayerHeader jarg1_, short jarg2);

    public static native short dtTileCacheLayerHeader_height_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_minx_set(long jarg1, TileCacheLayerHeader jarg1_, short jarg2);

    public static native short dtTileCacheLayerHeader_minx_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_maxx_set(long jarg1, TileCacheLayerHeader jarg1_, short jarg2);

    public static native short dtTileCacheLayerHeader_maxx_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_miny_set(long jarg1, TileCacheLayerHeader jarg1_, short jarg2);

    public static native short dtTileCacheLayerHeader_miny_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native void dtTileCacheLayerHeader_maxy_set(long jarg1, TileCacheLayerHeader jarg1_, short jarg2);

    public static native short dtTileCacheLayerHeader_maxy_get(long jarg1, TileCacheLayerHeader jarg1_);

    public static native long new_dtTileCacheLayerHeader();

    public static native void delete_dtTileCacheLayerHeader(long jarg1);

    public static native void dtTileCacheLayer_header_set(long jarg1, TileCacheLayer jarg1_, long jarg2, TileCacheLayerHeader jarg2_);

    public static native long dtTileCacheLayer_header_get(long jarg1, TileCacheLayer jarg1_);

    public static native void dtTileCacheLayer_regCount_set(long jarg1, TileCacheLayer jarg1_, short jarg2);

    public static native short dtTileCacheLayer_regCount_get(long jarg1, TileCacheLayer jarg1_);

    public static native void dtTileCacheLayer_heights_set(long jarg1, TileCacheLayer jarg1_, long jarg2);

    public static native long dtTileCacheLayer_heights_get(long jarg1, TileCacheLayer jarg1_);

    public static native void dtTileCacheLayer_areas_set(long jarg1, TileCacheLayer jarg1_, long jarg2);

    public static native long dtTileCacheLayer_areas_get(long jarg1, TileCacheLayer jarg1_);

    public static native void dtTileCacheLayer_cons_set(long jarg1, TileCacheLayer jarg1_, long jarg2);

    public static native long dtTileCacheLayer_cons_get(long jarg1, TileCacheLayer jarg1_);

    public static native void dtTileCacheLayer_regs_set(long jarg1, TileCacheLayer jarg1_, long jarg2);

    public static native long dtTileCacheLayer_regs_get(long jarg1, TileCacheLayer jarg1_);

    public static native long new_dtTileCacheLayer();

    public static native void delete_dtTileCacheLayer(long jarg1);

    public static native void dtTileCacheContour_nverts_set(long jarg1, TileCacheContour jarg1_, int jarg2);

    public static native int dtTileCacheContour_nverts_get(long jarg1, TileCacheContour jarg1_);

    public static native void dtTileCacheContour_verts_set(long jarg1, TileCacheContour jarg1_, long jarg2);

    public static native long dtTileCacheContour_verts_get(long jarg1, TileCacheContour jarg1_);

    public static native void dtTileCacheContour_reg_set(long jarg1, TileCacheContour jarg1_, short jarg2);

    public static native short dtTileCacheContour_reg_get(long jarg1, TileCacheContour jarg1_);

    public static native void dtTileCacheContour_area_set(long jarg1, TileCacheContour jarg1_, short jarg2);

    public static native short dtTileCacheContour_area_get(long jarg1, TileCacheContour jarg1_);

    public static native long new_dtTileCacheContour();

    public static native void delete_dtTileCacheContour(long jarg1);

    public static native void dtTileCacheContourSet_nconts_set(long jarg1, TileCacheContourSet jarg1_, int jarg2);

    public static native int dtTileCacheContourSet_nconts_get(long jarg1, TileCacheContourSet jarg1_);

    public static native void dtTileCacheContourSet_conts_set(long jarg1, TileCacheContourSet jarg1_, long jarg2, TileCacheContour jarg2_);

    public static native long dtTileCacheContourSet_conts_get(long jarg1, TileCacheContourSet jarg1_);

    public static native long new_dtTileCacheContourSet();

    public static native void delete_dtTileCacheContourSet(long jarg1);

    public static native void dtTileCachePolyMesh_nvp_set(long jarg1, TileCachePolyMesh jarg1_, int jarg2);

    public static native int dtTileCachePolyMesh_nvp_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native void dtTileCachePolyMesh_nverts_set(long jarg1, TileCachePolyMesh jarg1_, int jarg2);

    public static native int dtTileCachePolyMesh_nverts_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native void dtTileCachePolyMesh_npolys_set(long jarg1, TileCachePolyMesh jarg1_, int jarg2);

    public static native int dtTileCachePolyMesh_npolys_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native void dtTileCachePolyMesh_verts_set(long jarg1, TileCachePolyMesh jarg1_, long jarg2);

    public static native long dtTileCachePolyMesh_verts_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native void dtTileCachePolyMesh_polys_set(long jarg1, TileCachePolyMesh jarg1_, long jarg2);

    public static native long dtTileCachePolyMesh_polys_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native void dtTileCachePolyMesh_flags_set(long jarg1, TileCachePolyMesh jarg1_, long jarg2);

    public static native long dtTileCachePolyMesh_flags_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native void dtTileCachePolyMesh_areas_set(long jarg1, TileCachePolyMesh jarg1_, long jarg2);

    public static native long dtTileCachePolyMesh_areas_get(long jarg1, TileCachePolyMesh jarg1_);

    public static native long new_dtTileCachePolyMesh();

    public static native void delete_dtTileCachePolyMesh(long jarg1);

    public static native void dtTileCacheAlloc_reset(long jarg1, TileCacheAlloc jarg1_);

    public static native long dtTileCacheAlloc_alloc(long jarg1, TileCacheAlloc jarg1_, int jarg2);

    public static native void dtTileCacheAlloc_free(long jarg1, TileCacheAlloc jarg1_, long jarg2);

    public static native long new_dtTileCacheAlloc();

    public static native void delete_dtTileCacheAlloc(long jarg1);

    public static native int dtTileCacheCompressor_maxCompressedSize(long jarg1, TileCacheCompressor jarg1_, int jarg2);

    public static native long dtTileCacheCompressor_compress(long jarg1, TileCacheCompressor jarg1_, long jarg2, int jarg3, long jarg4, int jarg5, long jarg6);

    public static native long dtTileCacheCompressor_decompress(long jarg1, TileCacheCompressor jarg1_, long jarg2, int jarg3, long jarg4, int jarg5, long jarg6);

    public static native void delete_dtTileCacheCompressor(long jarg1);

    public static native long dtBuildTileCacheLayer(long jarg1, TileCacheCompressor jarg1_, long jarg2, TileCacheLayerHeader jarg2_, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7);

    public static native void dtFreeTileCacheLayer(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCacheLayer jarg2_);

    public static native long dtDecompressTileCacheLayer(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCacheCompressor jarg2_, long jarg3, int jarg4, long jarg5);

    public static native long dtAllocTileCacheContourSet(long jarg1, TileCacheAlloc jarg1_);

    public static native void dtFreeTileCacheContourSet(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCacheContourSet jarg2_);

    public static native long dtAllocTileCachePolyMesh(long jarg1, TileCacheAlloc jarg1_);

    public static native void dtFreeTileCachePolyMesh(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCachePolyMesh jarg2_);

    public static native long dtMarkCylinderArea(long jarg1, TileCacheLayer jarg1_, long jarg2, float jarg3, float jarg4, long jarg5, float jarg6, float jarg7, short jarg8);

    public static native long dtBuildTileCacheRegions(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCacheLayer jarg2_, int jarg3);

    public static native long dtBuildTileCacheContours(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCacheLayer jarg2_, int jarg3, float jarg4, long jarg5, TileCacheContourSet jarg5_);

    public static native long dtBuildTileCachePolyMesh(long jarg1, TileCacheAlloc jarg1_, long jarg2, TileCacheContourSet jarg2_, long jarg3, TileCachePolyMesh jarg3_);

    public static native boolean dtTileCacheHeaderSwapEndian(long jarg1, int jarg2);

    public static native float RC_PI_get();

    public static native int RC_LOG_PROGRESS_get();

    public static native long new_rcContext__SWIG_0(boolean jarg1);

    public static native long new_rcContext__SWIG_1();

    public static native void delete_rcContext(long jarg1);

    public static native void rcContext_enableLog(long jarg1, Context jarg1_, boolean jarg2);

    public static native void rcContext_resetLog(long jarg1, Context jarg1_);

    public static native void rcContext_log(long jarg1, Context jarg1_, int jarg2, String jarg3);

    public static native void rcContext_enableTimer(long jarg1, Context jarg1_, boolean jarg2);

    public static native void rcContext_resetTimers(long jarg1, Context jarg1_);

    public static native void rcContext_startTimer(long jarg1, Context jarg1_, int jarg2);

    public static native void rcContext_stopTimer(long jarg1, Context jarg1_, int jarg2);

    public static native int rcContext_getAccumulatedTime(long jarg1, Context jarg1_, int jarg2);

    public static native void rcConfig_width_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_width_get(long jarg1, Config jarg1_);

    public static native void rcConfig_height_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_height_get(long jarg1, Config jarg1_);

    public static native void rcConfig_tileSize_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_tileSize_get(long jarg1, Config jarg1_);

    public static native void rcConfig_borderSize_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_borderSize_get(long jarg1, Config jarg1_);

    public static native void rcConfig_cs_set(long jarg1, Config jarg1_, float jarg2);

    public static native float rcConfig_cs_get(long jarg1, Config jarg1_);

    public static native void rcConfig_ch_set(long jarg1, Config jarg1_, float jarg2);

    public static native float rcConfig_ch_get(long jarg1, Config jarg1_);

    public static native void rcConfig_bmin_set(long jarg1, Config jarg1_, long jarg2);

    public static native long rcConfig_bmin_get(long jarg1, Config jarg1_);

    public static native void rcConfig_bmax_set(long jarg1, Config jarg1_, long jarg2);

    public static native long rcConfig_bmax_get(long jarg1, Config jarg1_);

    public static native void rcConfig_walkableSlopeAngle_set(long jarg1, Config jarg1_, float jarg2);

    public static native float rcConfig_walkableSlopeAngle_get(long jarg1, Config jarg1_);

    public static native void rcConfig_walkableHeight_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_walkableHeight_get(long jarg1, Config jarg1_);

    public static native void rcConfig_walkableClimb_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_walkableClimb_get(long jarg1, Config jarg1_);

    public static native void rcConfig_walkableRadius_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_walkableRadius_get(long jarg1, Config jarg1_);

    public static native void rcConfig_maxEdgeLen_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_maxEdgeLen_get(long jarg1, Config jarg1_);

    public static native void rcConfig_maxSimplificationError_set(long jarg1, Config jarg1_, float jarg2);

    public static native float rcConfig_maxSimplificationError_get(long jarg1, Config jarg1_);

    public static native void rcConfig_minRegionArea_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_minRegionArea_get(long jarg1, Config jarg1_);

    public static native void rcConfig_mergeRegionArea_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_mergeRegionArea_get(long jarg1, Config jarg1_);

    public static native void rcConfig_maxVertsPerPoly_set(long jarg1, Config jarg1_, int jarg2);

    public static native int rcConfig_maxVertsPerPoly_get(long jarg1, Config jarg1_);

    public static native void rcConfig_detailSampleDist_set(long jarg1, Config jarg1_, float jarg2);

    public static native float rcConfig_detailSampleDist_get(long jarg1, Config jarg1_);

    public static native void rcConfig_detailSampleMaxError_set(long jarg1, Config jarg1_, float jarg2);

    public static native float rcConfig_detailSampleMaxError_get(long jarg1, Config jarg1_);

    public static native long new_rcConfig();

    public static native void delete_rcConfig(long jarg1);

    public static native int RC_SPAN_HEIGHT_BITS_get();

    public static native int RC_SPAN_MAX_HEIGHT_get();

    public static native int RC_SPANS_PER_POOL_get();

    public static native void rcSpan_smin_set(long jarg1, Span jarg1_, long jarg2);

    public static native long rcSpan_smin_get(long jarg1, Span jarg1_);

    public static native void rcSpan_smax_set(long jarg1, Span jarg1_, long jarg2);

    public static native long rcSpan_smax_get(long jarg1, Span jarg1_);

    public static native void rcSpan_area_set(long jarg1, Span jarg1_, long jarg2);

    public static native long rcSpan_area_get(long jarg1, Span jarg1_);

    public static native void rcSpan_next_set(long jarg1, Span jarg1_, long jarg2, Span jarg2_);

    public static native long rcSpan_next_get(long jarg1, Span jarg1_);

    public static native long new_rcSpan();

    public static native void delete_rcSpan(long jarg1);

    public static native long new_rcSpanPool();

    public static native void delete_rcSpanPool(long jarg1);

    public static native void rcHeightfield_width_set(long jarg1, Heightfield jarg1_, int jarg2);

    public static native int rcHeightfield_width_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_height_set(long jarg1, Heightfield jarg1_, int jarg2);

    public static native int rcHeightfield_height_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_bmin_set(long jarg1, Heightfield jarg1_, long jarg2);

    public static native long rcHeightfield_bmin_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_bmax_set(long jarg1, Heightfield jarg1_, long jarg2);

    public static native long rcHeightfield_bmax_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_cs_set(long jarg1, Heightfield jarg1_, float jarg2);

    public static native float rcHeightfield_cs_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_ch_set(long jarg1, Heightfield jarg1_, float jarg2);

    public static native float rcHeightfield_ch_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_spans_set(long jarg1, Heightfield jarg1_, long jarg2);

    public static native long rcHeightfield_spans_get(long jarg1, Heightfield jarg1_);

    public static native long rcHeightfield_pools_get(long jarg1, Heightfield jarg1_);

    public static native void rcHeightfield_freelist_set(long jarg1, Heightfield jarg1_, long jarg2, Span jarg2_);

    public static native long rcHeightfield_freelist_get(long jarg1, Heightfield jarg1_);

    public static native long new_rcHeightfield();

    public static native void delete_rcHeightfield(long jarg1);

    public static native void rcCompactCell_index_set(long jarg1, CompactCell jarg1_, long jarg2);

    public static native long rcCompactCell_index_get(long jarg1, CompactCell jarg1_);

    public static native void rcCompactCell_count_set(long jarg1, CompactCell jarg1_, long jarg2);

    public static native long rcCompactCell_count_get(long jarg1, CompactCell jarg1_);

    public static native long new_rcCompactCell();

    public static native void delete_rcCompactCell(long jarg1);

    public static native void rcCompactSpan_y_set(long jarg1, CompactSpan jarg1_, int jarg2);

    public static native int rcCompactSpan_y_get(long jarg1, CompactSpan jarg1_);

    public static native void rcCompactSpan_reg_set(long jarg1, CompactSpan jarg1_, int jarg2);

    public static native int rcCompactSpan_reg_get(long jarg1, CompactSpan jarg1_);

    public static native void rcCompactSpan_con_set(long jarg1, CompactSpan jarg1_, long jarg2);

    public static native long rcCompactSpan_con_get(long jarg1, CompactSpan jarg1_);

    public static native void rcCompactSpan_h_set(long jarg1, CompactSpan jarg1_, long jarg2);

    public static native long rcCompactSpan_h_get(long jarg1, CompactSpan jarg1_);

    public static native long new_rcCompactSpan();

    public static native void delete_rcCompactSpan(long jarg1);

    public static native void rcCompactHeightfield_width_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_width_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_height_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_height_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_spanCount_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_spanCount_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_walkableHeight_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_walkableHeight_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_walkableClimb_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_walkableClimb_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_borderSize_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_borderSize_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_maxDistance_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_maxDistance_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_maxRegions_set(long jarg1, CompactHeightfield jarg1_, int jarg2);

    public static native int rcCompactHeightfield_maxRegions_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_bmin_set(long jarg1, CompactHeightfield jarg1_, long jarg2);

    public static native long rcCompactHeightfield_bmin_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_bmax_set(long jarg1, CompactHeightfield jarg1_, long jarg2);

    public static native long rcCompactHeightfield_bmax_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_cs_set(long jarg1, CompactHeightfield jarg1_, float jarg2);

    public static native float rcCompactHeightfield_cs_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_ch_set(long jarg1, CompactHeightfield jarg1_, float jarg2);

    public static native float rcCompactHeightfield_ch_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_cells_set(long jarg1, CompactHeightfield jarg1_, long jarg2, CompactCell jarg2_);

    public static native long rcCompactHeightfield_cells_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_spans_set(long jarg1, CompactHeightfield jarg1_, long jarg2, CompactSpan jarg2_);

    public static native long rcCompactHeightfield_spans_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_dist_set(long jarg1, CompactHeightfield jarg1_, long jarg2);

    public static native long rcCompactHeightfield_dist_get(long jarg1, CompactHeightfield jarg1_);

    public static native void rcCompactHeightfield_areas_set(long jarg1, CompactHeightfield jarg1_, long jarg2);

    public static native long rcCompactHeightfield_areas_get(long jarg1, CompactHeightfield jarg1_);

    public static native long new_rcCompactHeightfield();

    public static native void delete_rcCompactHeightfield(long jarg1);

    public static native void rcHeightfieldLayer_bmin_set(long jarg1, HeightfieldLayer jarg1_, long jarg2);

    public static native long rcHeightfieldLayer_bmin_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_bmax_set(long jarg1, HeightfieldLayer jarg1_, long jarg2);

    public static native long rcHeightfieldLayer_bmax_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_cs_set(long jarg1, HeightfieldLayer jarg1_, float jarg2);

    public static native float rcHeightfieldLayer_cs_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_ch_set(long jarg1, HeightfieldLayer jarg1_, float jarg2);

    public static native float rcHeightfieldLayer_ch_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_width_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_width_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_height_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_height_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_minx_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_minx_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_maxx_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_maxx_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_miny_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_miny_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_maxy_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_maxy_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_hmin_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_hmin_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_hmax_set(long jarg1, HeightfieldLayer jarg1_, int jarg2);

    public static native int rcHeightfieldLayer_hmax_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_heights_set(long jarg1, HeightfieldLayer jarg1_, long jarg2);

    public static native long rcHeightfieldLayer_heights_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_areas_set(long jarg1, HeightfieldLayer jarg1_, long jarg2);

    public static native long rcHeightfieldLayer_areas_get(long jarg1, HeightfieldLayer jarg1_);

    public static native void rcHeightfieldLayer_cons_set(long jarg1, HeightfieldLayer jarg1_, long jarg2);

    public static native long rcHeightfieldLayer_cons_get(long jarg1, HeightfieldLayer jarg1_);

    public static native long new_rcHeightfieldLayer();

    public static native void delete_rcHeightfieldLayer(long jarg1);

    public static native void rcHeightfieldLayerSet_layers_set(long jarg1, HeightfieldLayerSet jarg1_, long jarg2, HeightfieldLayer jarg2_);

    public static native long rcHeightfieldLayerSet_layers_get(long jarg1, HeightfieldLayerSet jarg1_);

    public static native void rcHeightfieldLayerSet_nlayers_set(long jarg1, HeightfieldLayerSet jarg1_, int jarg2);

    public static native int rcHeightfieldLayerSet_nlayers_get(long jarg1, HeightfieldLayerSet jarg1_);

    public static native long new_rcHeightfieldLayerSet();

    public static native void delete_rcHeightfieldLayerSet(long jarg1);

    public static native void rcContour_verts_set(long jarg1, Contour jarg1_, long jarg2);

    public static native long rcContour_verts_get(long jarg1, Contour jarg1_);

    public static native void rcContour_nverts_set(long jarg1, Contour jarg1_, int jarg2);

    public static native int rcContour_nverts_get(long jarg1, Contour jarg1_);

    public static native void rcContour_rverts_set(long jarg1, Contour jarg1_, long jarg2);

    public static native long rcContour_rverts_get(long jarg1, Contour jarg1_);

    public static native void rcContour_nrverts_set(long jarg1, Contour jarg1_, int jarg2);

    public static native int rcContour_nrverts_get(long jarg1, Contour jarg1_);

    public static native void rcContour_reg_set(long jarg1, Contour jarg1_, int jarg2);

    public static native int rcContour_reg_get(long jarg1, Contour jarg1_);

    public static native void rcContour_area_set(long jarg1, Contour jarg1_, short jarg2);

    public static native short rcContour_area_get(long jarg1, Contour jarg1_);

    public static native long new_rcContour();

    public static native void delete_rcContour(long jarg1);

    public static native void rcContourSet_conts_set(long jarg1, ContourSet jarg1_, long jarg2, Contour jarg2_);

    public static native long rcContourSet_conts_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_nconts_set(long jarg1, ContourSet jarg1_, int jarg2);

    public static native int rcContourSet_nconts_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_bmin_set(long jarg1, ContourSet jarg1_, long jarg2);

    public static native long rcContourSet_bmin_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_bmax_set(long jarg1, ContourSet jarg1_, long jarg2);

    public static native long rcContourSet_bmax_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_cs_set(long jarg1, ContourSet jarg1_, float jarg2);

    public static native float rcContourSet_cs_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_ch_set(long jarg1, ContourSet jarg1_, float jarg2);

    public static native float rcContourSet_ch_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_width_set(long jarg1, ContourSet jarg1_, int jarg2);

    public static native int rcContourSet_width_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_height_set(long jarg1, ContourSet jarg1_, int jarg2);

    public static native int rcContourSet_height_get(long jarg1, ContourSet jarg1_);

    public static native void rcContourSet_borderSize_set(long jarg1, ContourSet jarg1_, int jarg2);

    public static native int rcContourSet_borderSize_get(long jarg1, ContourSet jarg1_);

    public static native long new_rcContourSet();

    public static native void delete_rcContourSet(long jarg1);

    public static native void rcPolyMesh_verts_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_verts_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_polys_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_polys_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_regs_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_regs_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_flags_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_flags_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_areas_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_areas_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_nverts_set(long jarg1, PolyMesh jarg1_, int jarg2);

    public static native int rcPolyMesh_nverts_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_npolys_set(long jarg1, PolyMesh jarg1_, int jarg2);

    public static native int rcPolyMesh_npolys_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_maxpolys_set(long jarg1, PolyMesh jarg1_, int jarg2);

    public static native int rcPolyMesh_maxpolys_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_nvp_set(long jarg1, PolyMesh jarg1_, int jarg2);

    public static native int rcPolyMesh_nvp_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_bmin_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_bmin_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_bmax_set(long jarg1, PolyMesh jarg1_, long jarg2);

    public static native long rcPolyMesh_bmax_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_cs_set(long jarg1, PolyMesh jarg1_, float jarg2);

    public static native float rcPolyMesh_cs_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_ch_set(long jarg1, PolyMesh jarg1_, float jarg2);

    public static native float rcPolyMesh_ch_get(long jarg1, PolyMesh jarg1_);

    public static native void rcPolyMesh_borderSize_set(long jarg1, PolyMesh jarg1_, int jarg2);

    public static native int rcPolyMesh_borderSize_get(long jarg1, PolyMesh jarg1_);

    public static native long new_rcPolyMesh();

    public static native void delete_rcPolyMesh(long jarg1);

    public static native void rcPolyMeshDetail_meshes_set(long jarg1, PolyMeshDetail jarg1_, long jarg2);

    public static native long rcPolyMeshDetail_meshes_get(long jarg1, PolyMeshDetail jarg1_);

    public static native void rcPolyMeshDetail_verts_set(long jarg1, PolyMeshDetail jarg1_, long jarg2);

    public static native long rcPolyMeshDetail_verts_get(long jarg1, PolyMeshDetail jarg1_);

    public static native void rcPolyMeshDetail_tris_set(long jarg1, PolyMeshDetail jarg1_, long jarg2);

    public static native long rcPolyMeshDetail_tris_get(long jarg1, PolyMeshDetail jarg1_);

    public static native void rcPolyMeshDetail_nmeshes_set(long jarg1, PolyMeshDetail jarg1_, int jarg2);

    public static native int rcPolyMeshDetail_nmeshes_get(long jarg1, PolyMeshDetail jarg1_);

    public static native void rcPolyMeshDetail_nverts_set(long jarg1, PolyMeshDetail jarg1_, int jarg2);

    public static native int rcPolyMeshDetail_nverts_get(long jarg1, PolyMeshDetail jarg1_);

    public static native void rcPolyMeshDetail_ntris_set(long jarg1, PolyMeshDetail jarg1_, int jarg2);

    public static native int rcPolyMeshDetail_ntris_get(long jarg1, PolyMeshDetail jarg1_);

    public static native long new_rcPolyMeshDetail();

    public static native void delete_rcPolyMeshDetail(long jarg1);

    public static native long rcAllocHeightfield();

    public static native void rcFreeHeightField(long jarg1, Heightfield jarg1_);

    public static native long rcAllocCompactHeightfield();

    public static native void rcFreeCompactHeightfield(long jarg1, CompactHeightfield jarg1_);

    public static native long rcAllocHeightfieldLayerSet();

    public static native void rcFreeHeightfieldLayerSet(long jarg1, HeightfieldLayerSet jarg1_);

    public static native long rcAllocContourSet();

    public static native void rcFreeContourSet(long jarg1, ContourSet jarg1_);

    public static native long rcAllocPolyMesh();

    public static native void rcFreePolyMesh(long jarg1, PolyMesh jarg1_);

    public static native long rcAllocPolyMeshDetail();

    public static native void rcFreePolyMeshDetail(long jarg1, PolyMeshDetail jarg1_);

    public static native int RC_BORDER_REG_get();

    public static native int RC_BORDER_VERTEX_get();

    public static native int RC_AREA_BORDER_get();

    public static native int RC_CONTOUR_TESS_WALL_EDGES_get();

    public static native int RC_CONTOUR_TESS_AREA_EDGES_get();

    public static native int RC_CONTOUR_REG_MASK_get();

    public static native int RC_MESH_NULL_IDX_get();

    public static native short RC_NULL_AREA_get();

    public static native short RC_WALKABLE_AREA_get();

    public static native int RC_NOT_CONNECTED_get();

    public static native float rcSqrt(float jarg1);

    public static native void rcVcross(long jarg1, long jarg2, long jarg3);

    public static native float rcVdot(long jarg1, long jarg2);

    public static native void rcVmad(long jarg1, long jarg2, long jarg3, float jarg4);

    public static native void rcVadd(long jarg1, long jarg2, long jarg3);

    public static native void rcVsub(long jarg1, long jarg2, long jarg3);

    public static native void rcVmin(long jarg1, long jarg2);

    public static native void rcVmax(long jarg1, long jarg2);

    public static native void rcVcopy(long jarg1, long jarg2);

    public static native float rcVdist(long jarg1, long jarg2);

    public static native float rcVdistSqr(long jarg1, long jarg2);

    public static native void rcVnormalize(long jarg1);

    public static native void rcCalcBounds(long jarg1, int jarg2, long jarg3, long jarg4);

    public static native void rcCalcGridSize(long jarg1, long jarg2, float jarg3, long jarg4, long jarg5);

    public static native boolean rcCreateHeightfield(long jarg1, Context jarg1_, long jarg2, Heightfield jarg2_, int jarg3, int jarg4, long jarg5, long jarg6, float jarg7, float jarg8);

    public static native void rcMarkWalkableTriangles(long jarg1, Context jarg1_, float jarg2, long jarg3, int jarg4, long jarg5, int jarg6, long jarg7);

    public static native void rcClearUnwalkableTriangles(long jarg1, Context jarg1_, float jarg2, long jarg3, int jarg4, long jarg5, int jarg6, long jarg7);

    public static native void rcAddSpan(long jarg1, Context jarg1_, long jarg2, Heightfield jarg2_, int jarg3, int jarg4, int jarg5, int jarg6, short jarg7, int jarg8);

    public static native void rcRasterizeTriangle__SWIG_0(long jarg1, Context jarg1_, long jarg2, long jarg3, long jarg4, short jarg5, long jarg6, Heightfield jarg6_, int jarg7);

    public static native void rcRasterizeTriangle__SWIG_1(long jarg1, Context jarg1_, long jarg2, long jarg3, long jarg4, short jarg5, long jarg6, Heightfield jarg6_);

    public static native void rcRasterizeTriangles__SWIG_0(long jarg1, Context jarg1_, long jarg2, int jarg3, long jarg4, long jarg5, int jarg6, long jarg7, Heightfield jarg7_, int jarg8);

    public static native void rcRasterizeTriangles__SWIG_1(long jarg1, Context jarg1_, long jarg2, int jarg3, long jarg4, long jarg5, int jarg6, long jarg7, Heightfield jarg7_);

    public static native void rcRasterizeTriangles__SWIG_2(long jarg1, Context jarg1_, long jarg2, int jarg3, long jarg4, long jarg5, int jarg6, long jarg7, Heightfield jarg7_, int jarg8);

    public static native void rcRasterizeTriangles__SWIG_3(long jarg1, Context jarg1_, long jarg2, int jarg3, long jarg4, long jarg5, int jarg6, long jarg7, Heightfield jarg7_);

    public static native void rcRasterizeTriangles__SWIG_4(long jarg1, Context jarg1_, long jarg2, long jarg3, int jarg4, long jarg5, Heightfield jarg5_, int jarg6);

    public static native void rcRasterizeTriangles__SWIG_5(long jarg1, Context jarg1_, long jarg2, long jarg3, int jarg4, long jarg5, Heightfield jarg5_);

    public static native void rcFilterLowHangingWalkableObstacles(long jarg1, Context jarg1_, int jarg2, long jarg3, Heightfield jarg3_);

    public static native void rcFilterLedgeSpans(long jarg1, Context jarg1_, int jarg2, int jarg3, long jarg4, Heightfield jarg4_);

    public static native void rcFilterWalkableLowHeightSpans(long jarg1, Context jarg1_, int jarg2, long jarg3, Heightfield jarg3_);

    public static native int rcGetHeightFieldSpanCount(long jarg1, Context jarg1_, long jarg2, Heightfield jarg2_);

    public static native boolean rcBuildCompactHeightfield(long jarg1, Context jarg1_, int jarg2, int jarg3, long jarg4, Heightfield jarg4_, long jarg5, CompactHeightfield jarg5_);

    public static native boolean rcErodeWalkableArea(long jarg1, Context jarg1_, int jarg2, long jarg3, CompactHeightfield jarg3_);

    public static native boolean rcMedianFilterWalkableArea(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_);

    public static native void rcMarkBoxArea(long jarg1, Context jarg1_, long jarg2, long jarg3, short jarg4, long jarg5, CompactHeightfield jarg5_);

    public static native void rcMarkConvexPolyArea(long jarg1, Context jarg1_, long jarg2, int jarg3, float jarg4, float jarg5, short jarg6, long jarg7, CompactHeightfield jarg7_);

    public static native int rcOffsetPoly(long jarg1, int jarg2, float jarg3, long jarg4, int jarg5);

    public static native void rcMarkCylinderArea(long jarg1, Context jarg1_, long jarg2, float jarg3, float jarg4, short jarg5, long jarg6, CompactHeightfield jarg6_);

    public static native boolean rcBuildDistanceField(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_);

    public static native boolean rcBuildRegions(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_, int jarg3, int jarg4, int jarg5);

    public static native boolean rcBuildRegionsMonotone(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_, int jarg3, int jarg4, int jarg5);

    public static native void rcSetCon(long jarg1, CompactSpan jarg1_, int jarg2, int jarg3);

    public static native int rcGetCon(long jarg1, CompactSpan jarg1_, int jarg2);

    public static native int rcGetDirOffsetX(int jarg1);

    public static native int rcGetDirOffsetY(int jarg1);

    public static native boolean rcBuildHeightfieldLayers(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_, int jarg3, int jarg4, long jarg5, HeightfieldLayerSet jarg5_);

    public static native boolean rcBuildContours__SWIG_0(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_, float jarg3, int jarg4, long jarg5, ContourSet jarg5_, int jarg6);

    public static native boolean rcBuildContours__SWIG_1(long jarg1, Context jarg1_, long jarg2, CompactHeightfield jarg2_, float jarg3, int jarg4, long jarg5, ContourSet jarg5_);

    public static native boolean rcBuildPolyMesh(long jarg1, Context jarg1_, long jarg2, ContourSet jarg2_, int jarg3, long jarg4, PolyMesh jarg4_);

    public static native boolean rcMergePolyMeshes(long jarg1, Context jarg1_, long jarg2, int jarg3, long jarg4, PolyMesh jarg4_);

    public static native boolean rcBuildPolyMeshDetail(long jarg1, Context jarg1_, long jarg2, PolyMesh jarg2_, long jarg3, CompactHeightfield jarg3_, float jarg4, float jarg5, long jarg6, PolyMeshDetail jarg6_);

    public static native boolean rcCopyPolyMesh(long jarg1, Context jarg1_, long jarg2, PolyMesh jarg2_, long jarg3, PolyMesh jarg3_);

    public static native boolean rcMergePolyMeshDetails(long jarg1, Context jarg1_, long jarg2, int jarg3, long jarg4, PolyMeshDetail jarg4_);

    public static native void rcAllocSetCustom(long jarg1, long jarg2);

    public static native long rcAlloc(int jarg1, int jarg2);

    public static native void rcFree(long jarg1);

    public static native long new_rcIntArray__SWIG_0();

    public static native long new_rcIntArray__SWIG_1(int jarg1);

    public static native void delete_rcIntArray(long jarg1);

    static {
        try {
            URI uri = new RecastJNI().getClass().getClassLoader().getResource(".").toURI();
            uri = uri.resolve("../../native_build/jNavigationNative.so");
            System.load(uri.getPath());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            Logger.getLogger(RecastJNI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
