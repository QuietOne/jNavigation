package com.jme3.ai.navigation.recast;

/**
 * Recast performance timer categories.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public final class TimerLabel {

    /**
     * The user defined total time of the build.
     */
    public final static TimerLabel RC_TIMER_TOTAL = new TimerLabel("RC_TIMER_TOTAL");
    /**
     * A user defined build time.
     */
    public final static TimerLabel RC_TIMER_TEMP = new TimerLabel("RC_TIMER_TEMP");
    /**
     * The time to rasterize the triangles.
     *
     * @see
     * RecastBuilder#rasterizeTriangle(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f, com.jme3.math.Vector3f, com.jme3.math.Vector3f,
     * short, com.jme3.ai.navigation.recast.Heightfield, int)
     */
    public final static TimerLabel RC_TIMER_RASTERIZE_TRIANGLES = new TimerLabel("RC_TIMER_RASTERIZE_TRIANGLES");
    /**
     * The time to build the compact heightfield.
     *
     * @see
     * RecastBuilder#buildCompactHeightfield(com.jme3.ai.navigation.recast.Context,
     * int, int, com.jme3.ai.navigation.recast.Heightfield,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_BUILD_COMPACTHEIGHTFIELD = new TimerLabel("RC_TIMER_BUILD_COMPACTHEIGHTFIELD");
    /**
     * The total time to build the contours.
     *
     * @see RecastBuilder#buildContours(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, float, int,
     * com.jme3.ai.navigation.recast.ContourSet)
     */
    public final static TimerLabel RC_TIMER_BUILD_CONTOURS = new TimerLabel("RC_TIMER_BUILD_CONTOURS");
    /**
     * The time to trace the boundaries of the contours.
     *
     * @see RecastBuilder#buildContours(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, float, int,
     * com.jme3.ai.navigation.recast.ContourSet)
     */
    public final static TimerLabel RC_TIMER_BUILD_CONTOURS_TRACE = new TimerLabel("RC_TIMER_BUILD_CONTOURS_TRACE");
    /**
     * The time to simplify the contours.
     *
     * @see RecastBuilder#buildContours(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, float, int,
     * com.jme3.ai.navigation.recast.ContourSet)
     */
    public final static TimerLabel RC_TIMER_BUILD_CONTOURS_SIMPLIFY = new TimerLabel("RC_TIMER_BUILD_CONTOURS_SIMPLIFY");
    /**
     * The time to filter ledge spans.
     *
     * @see
     * RecastBuilder#filterLedgeSpans(com.jme3.ai.navigation.recast.Context,
     * int, int, com.jme3.ai.navigation.recast.Heightfield)
     */
    public final static TimerLabel RC_TIMER_FILTER_BORDER = new TimerLabel("RC_TIMER_FILTER_BORDER");
    /**
     * The time to filter low height spans.
     *
     * @see
     * RecastBuilder#filterWalkableLowHeightSpans(com.jme3.ai.navigation.recast.Context,
     * int, com.jme3.ai.navigation.recast.Heightfield)
     */
    public final static TimerLabel RC_TIMER_FILTER_WALKABLE = new TimerLabel("RC_TIMER_FILTER_WALKABLE");
    /**
     * The time to apply the median filter.
     *
     * @see
     * RecastBuilder#medianFilterWalkableArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_MEDIAN_AREA = new TimerLabel("RC_TIMER_MEDIAN_AREA");
    /**
     * The time to filter low obstacles.
     *
     * @see
     * RecastBuilder#filterLowHangingWalkableObstacles(com.jme3.ai.navigation.recast.Context,
     * int, com.jme3.ai.navigation.recast.Heightfield)
     */
    public final static TimerLabel RC_TIMER_FILTER_LOW_OBSTACLES = new TimerLabel("RC_TIMER_FILTER_LOW_OBSTACLES");
    /**
     * The time to build the polygon mesh.
     *
     * @see RecastBuilder#buildPolyMesh(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.ContourSet, int,
     * com.jme3.ai.navigation.recast.PolyMesh)
     */
    public final static TimerLabel RC_TIMER_BUILD_POLYMESH = new TimerLabel("RC_TIMER_BUILD_POLYMESH");
    /**
     * The time to merge polygon meshes.
     *
     * @see RecastBuilder#mergePolyMeshes(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.PolyMesh,
     * com.jme3.ai.navigation.recast.PolyMesh)
     */
    public final static TimerLabel RC_TIMER_MERGE_POLYMESH = new TimerLabel("RC_TIMER_MERGE_POLYMESH");
    /**
     * The time to erode the walkable area.
     *
     * @see
     * RecastBuilder#erodeWalkableArea(com.jme3.ai.navigation.recast.Context,
     * int, com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_ERODE_AREA = new TimerLabel("RC_TIMER_ERODE_AREA");
    /**
     * The time to mark a box area.
     *
     * @see RecastBuilder#markBoxArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f, com.jme3.math.Vector3f, short,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_MARK_BOX_AREA = new TimerLabel("RC_TIMER_MARK_BOX_AREA");
    /**
     * The time to mark a cylinder area.
     *
     * @see
     * RecastBuilder#markCylinderArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f, float, float, short,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_MARK_CYLINDER_AREA = new TimerLabel("RC_TIMER_MARK_CYLINDER_AREA");
    /**
     * The time to mark a convex polygon area.
     *
     * @see
     * RecastBuilder#markConvexPolyArea(com.jme3.ai.navigation.recast.Context,
     * com.jme3.math.Vector3f[], float, float, short,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_MARK_CONVEXPOLY_AREA = new TimerLabel("RC_TIMER_MARK_CONVEXPOLY_AREA");
    /**
     * The total time to build the distance field.
     *
     * @see
     * RecastBuilder#buildDistanceField(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_BUILD_DISTANCEFIELD = new TimerLabel("RC_TIMER_BUILD_DISTANCEFIELD");
    /**
     * The time to build the distances of the distance field.
     *
     * @see
     * RecastBuilder#buildDistanceField(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_BUILD_DISTANCEFIELD_DIST = new TimerLabel("RC_TIMER_BUILD_DISTANCEFIELD_DIST");
    /**
     * The time to blur the distance field.
     *
     * @see
     * RecastBuilder#buildDistanceField(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield)
     */
    public final static TimerLabel RC_TIMER_BUILD_DISTANCEFIELD_BLUR = new TimerLabel("RC_TIMER_BUILD_DISTANCEFIELD_BLUR");
    /**
     * The total time to build the regions.
     *
     * @see RecastBuilder#buildRegions(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     * @see
     * RecastBuilder#buildRegionsMonotone(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     */
    public final static TimerLabel RC_TIMER_BUILD_REGIONS = new TimerLabel("RC_TIMER_BUILD_REGIONS");
    /**
     * The total time to apply the watershed algorithm.
     *
     * @see RecastBuilder#buildRegions(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     */
    public final static TimerLabel RC_TIMER_BUILD_REGIONS_WATERSHED = new TimerLabel("RC_TIMER_BUILD_REGIONS_WATERSHED");
    /**
     * The time to expand regions while applying the watershed algorithm.
     *
     * @see RecastBuilder#buildRegions(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     */
    public final static TimerLabel RC_TIMER_BUILD_REGIONS_EXPAND = new TimerLabel("RC_TIMER_BUILD_REGIONS_EXPAND");
    /**
     * The time to flood regions while applying the watershed algorithm.
     *
     * @see RecastBuilder#buildRegions(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     */
    public final static TimerLabel RC_TIMER_BUILD_REGIONS_FLOOD = new TimerLabel("RC_TIMER_BUILD_REGIONS_FLOOD");
    /**
     * The time to filter out small regions.
     *
     * @see RecastBuilder#buildRegions(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     * @see
     * RecastBuilder#buildRegionsMonotone(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int, int)
     */
    public final static TimerLabel RC_TIMER_BUILD_REGIONS_FILTER = new TimerLabel("RC_TIMER_BUILD_REGIONS_FILTER");
    /**
     * The time to build heightfield layers.
     *
     * @see
     * RecastBuilder#buildHeightfieldLayers(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.CompactHeightfield, int, int,
     * com.jme3.ai.navigation.recast.HeightfieldLayerSet)
     */
    public final static TimerLabel RC_TIMER_BUILD_LAYERS = new TimerLabel("RC_TIMER_BUILD_LAYERS");
    /**
     * The time to build the polygon mesh detail.
     *
     * @see
     * RecastBuilder#buildPolyMeshDetail(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.PolyMesh,
     * com.jme3.ai.navigation.recast.CompactHeightfield, float, float,
     * com.jme3.ai.navigation.recast.PolyMeshDetail)
     */
    public final static TimerLabel RC_TIMER_BUILD_POLYMESHDETAIL = new TimerLabel("RC_TIMER_BUILD_POLYMESHDETAIL");
    /**
     * The time to merge polygon mesh details.
     *
     * @see
     * RecastBuilder#mergePolyMeshDetails(com.jme3.ai.navigation.recast.Context,
     * com.jme3.ai.navigation.recast.PolyMeshDetail,
     * com.jme3.ai.navigation.recast.PolyMeshDetail)
     */
    public final static TimerLabel RC_TIMER_MERGE_POLYMESHDETAIL = new TimerLabel("RC_TIMER_MERGE_POLYMESHDETAIL");
    /**
     * The maximum number of timers. (Used for iterating timers.)
     */
    public final static TimerLabel RC_MAX_TIMERS = new TimerLabel("RC_MAX_TIMERS");

    public final int swigValue() {
        return swigValue;
    }

    public String toString() {
        return swigName;
    }

    public static TimerLabel swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + TimerLabel.class + " with value " + swigValue);
    }

    private TimerLabel(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private TimerLabel(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private TimerLabel(String swigName, TimerLabel swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static TimerLabel[] swigValues = {RC_TIMER_TOTAL, RC_TIMER_TEMP, RC_TIMER_RASTERIZE_TRIANGLES, RC_TIMER_BUILD_COMPACTHEIGHTFIELD, RC_TIMER_BUILD_CONTOURS, RC_TIMER_BUILD_CONTOURS_TRACE, RC_TIMER_BUILD_CONTOURS_SIMPLIFY, RC_TIMER_FILTER_BORDER, RC_TIMER_FILTER_WALKABLE, RC_TIMER_MEDIAN_AREA, RC_TIMER_FILTER_LOW_OBSTACLES, RC_TIMER_BUILD_POLYMESH, RC_TIMER_MERGE_POLYMESH, RC_TIMER_ERODE_AREA, RC_TIMER_MARK_BOX_AREA, RC_TIMER_MARK_CYLINDER_AREA, RC_TIMER_MARK_CONVEXPOLY_AREA, RC_TIMER_BUILD_DISTANCEFIELD, RC_TIMER_BUILD_DISTANCEFIELD_DIST, RC_TIMER_BUILD_DISTANCEFIELD_BLUR, RC_TIMER_BUILD_REGIONS, RC_TIMER_BUILD_REGIONS_WATERSHED, RC_TIMER_BUILD_REGIONS_EXPAND, RC_TIMER_BUILD_REGIONS_FLOOD, RC_TIMER_BUILD_REGIONS_FILTER, RC_TIMER_BUILD_LAYERS, RC_TIMER_BUILD_POLYMESHDETAIL, RC_TIMER_MERGE_POLYMESHDETAIL, RC_MAX_TIMERS};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
