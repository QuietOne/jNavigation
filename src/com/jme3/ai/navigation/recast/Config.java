package com.jme3.ai.navigation.recast;

import com.jme3.ai.navigation.detour.DetourBuilder;
import com.jme3.ai.navigation.utils.Converter;
import com.jme3.ai.navigation.utils.SWIGTYPE_p_float;
import com.jme3.ai.navigation.utils.RecastJNI;
import com.jme3.math.Vector3f;

/**
 * Specifies a configuration to use when performing Recast builds.
 *
 * The is a convenience structure that represents an aggregation of parameters
 * used at different stages in the Recast build process. Some values are derived
 * during the build process. Not all parameters are used for all build
 * processes.
 *
 * Units are usually in voxels (vx) or world units (wu). The units for voxels,
 * grid size, and cell size are all based on the values of cs and ch.
 *
 * In this documentation, the term 'field' refers to heightfield and contour
 * data structures that define spacial information using an integer grid.
 *
 * The upper and lower limits for the various parameters often depend on the
 * platform's floating point accuraccy as well as interdependencies between the
 * values of multiple parameters. See the individual parameter documentation for
 * details.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Config {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Config() {
        this(RecastJNI.new_rcConfig(), true);
    }

    public Config(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(Config obj) {
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
                RecastJNI.delete_rcConfig(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    /**
     *
     * @param value The width of the field along the x-axis. [Limit: >= 0]
     * [Units: vx].
     */
    public void setWidth(int value) {
        RecastJNI.rcConfig_width_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The width of the field along the x-axis. [Limit: >= 0] [Units:
     * vx].
     */
    public int getWidth() {
        return RecastJNI.rcConfig_width_get(swigCPtr, this);
    }

    /**
     *
     * @param value The height of the field along the z-axis. [Limit: >= 0]
     * [Units: vx].
     */
    public void setHeight(int value) {
        RecastJNI.rcConfig_height_set(swigCPtr, this, value);
    }

    /**
     *
     * @return The height of the field along the z-axis. [Limit: >= 0] [Units:
     * vx].
     */
    public int getHeight() {
        return RecastJNI.rcConfig_height_get(swigCPtr, this);
    }

    /**
     * This field is only used when building multi-tile meshes.
     *
     * @param value The width/height size of tile's on the xz-plane. [Limit: >=
     * 0] [Units: vx].
     */
    public void setTileSize(int value) {
        RecastJNI.rcConfig_tileSize_set(swigCPtr, this, value);
    }

    /**
     * This field is only used when building multi-tile meshes.
     *
     * @return The width/height size of tile's on the xz-plane. [Limit: >= 0]
     * [Units: vx].
     */
    public int getTileSize() {
        return RecastJNI.rcConfig_tileSize_get(swigCPtr, this);
    }

    /**
     * This value represents the the closest the walkable area of the
     * heightfield should come to the xz-plane AABB of the field. It does not
     * have any impact on the borders around internal obstructions.
     *
     * @param value The size of the non-navigable border around the heightfield.
     * [Limit: >=0] [Units: vx].
     */
    public void setBorderSize(int value) {
        RecastJNI.rcConfig_borderSize_set(swigCPtr, this, value);
    }

    /**
     * This value represents the the closest the walkable area of the
     * heightfield should come to the xz-plane AABB of the field. It does not
     * have any impact on the borders around internal obstructions.
     *
     * @return The size of the non-navigable border around the heightfield.
     * [Limit: >=0] [Units: vx].
     */
    public int getBorderSize() {
        return RecastJNI.rcConfig_borderSize_get(swigCPtr, this);
    }

    /**
     * The minimum value for this parameter depends on the platform's floating
     * point accuracy, with the practical minimum usually around 0.05.
     *
     * @param value The xz-plane cell size to use for fields. [Limit: > 0]
     * [Units: wu].
     */
    public void setCellSize(float value) {
        RecastJNI.rcConfig_cs_set(swigCPtr, this, value);
    }

    /**
     * The minimum value for this parameter depends on the platform's floating
     * point accuracy, with the practical minimum usually around 0.05.
     *
     * @return The xz-plane cell size to use for fields. [Limit: > 0] [Units:
     * wu].
     */
    public float getCellSize() {
        return RecastJNI.rcConfig_cs_get(swigCPtr, this);
    }

    /**
     * The minimum value for this parameter depends on the platform's floating
     * point accuracy, with the practical minimum usually around 0.05.
     *
     * @param value The y-axis cell size to use for fields. [Limit: > 0] [Units:
     * wu].
     */
    public void setCellHeight(float value) {
        RecastJNI.rcConfig_ch_set(swigCPtr, this, value);
    }

    /**
     * The minimum value for this parameter depends on the platform's floating
     * point accuracy, with the practical minimum usually around 0.05.
     *
     * @return The y-axis cell size to use for fields. [Limit: > 0] [Units: wu].
     */
    public float getCellHeight() {
        return RecastJNI.rcConfig_ch_get(swigCPtr, this);
    }

    /**
     *
     * @param minBounds The minimum bounds of the field's AABB.
     */
    public void setMinBounds(Vector3f minBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(minBounds);
        RecastJNI.rcConfig_bmin_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The minimum bounds of the field's AABB.
     */
    public Vector3f getMinBounds() {
        long cPtr = RecastJNI.rcConfig_bmin_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     *
     * @param maxBounds The maximum bounds of the field's AABB.
     */
    public void setMaxBounds(Vector3f maxBounds) {
        SWIGTYPE_p_float value = Converter.convertToSWIGTYPE_p_float(maxBounds);
        RecastJNI.rcConfig_bmax_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
    }

    /**
     *
     * @return The maximum bounds of the field's AABB.
     */
    public Vector3f getMaxBounds() {
        long cPtr = RecastJNI.rcConfig_bmax_get(swigCPtr, this);
        if (cPtr == 0) {
            return null;
        }
        return Converter.convertToVector3f(cPtr);
    }

    /**
     * The practical upper limit for this parameter is usually around 85
     * degrees.
     *
     * @param value The maximum slope that is considered walkable. [Limits: 90 >
     * value >=0] [Units: Degrees].
     */
    public void setWalkableSlopeAngle(float value) {
        RecastJNI.rcConfig_walkableSlopeAngle_set(swigCPtr, this, value);
    }

    /**
     * The practical upper limit for this parameter is usually around 85
     * degrees.
     *
     * @return The maximum slope that is considered walkable. [Limits: 90 >
     * value >=0] [Units: Degrees].
     */
    public float getWalkableSlopeAngle() {
        return RecastJNI.rcConfig_walkableSlopeAngle_get(swigCPtr, this);
    }

    /**
     * Permits detection of overhangs in the source geometry that make the
     * geometry below un-walkable. The value is usually set to the maximum agent
     * height.
     *
     * @param value Minimum floor to 'ceiling' height that will still allow the
     * floor area to be considered walkable. [Limit: >= 3] [Units: vx]
     */
    public void setWalkableHeight(int value) {
        RecastJNI.rcConfig_walkableHeight_set(swigCPtr, this, value);
    }

    /**
     * Permits detection of overhangs in the source geometry that make the
     * geometry below un-walkable. The value is usually set to the maximum agent
     * height.
     *
     * @return Minimum floor to 'ceiling' height that will still allow the floor
     * area to be considered walkable. [Limit: >= 3] [Units: vx]
     */
    public int getWalkableHeight() {
        return RecastJNI.rcConfig_walkableHeight_get(swigCPtr, this);
    }

    /**
     * Allows the mesh to flow over low lying obstructions such as curbs and
     * up/down stairways. The value is usually set to how far up/down an agent
     * can step.
     *
     * @param value Maximum ledge height that is considered to still be
     * traversable. [Limit: >=0] [Units: vx].
     */
    public void setWalkableClimb(int value) {
        RecastJNI.rcConfig_walkableClimb_set(swigCPtr, this, value);
    }

    /**
     * Allows the mesh to flow over low lying obstructions such as curbs and
     * up/down stairways. The value is usually set to how far up/down an agent
     * can step.
     *
     * @return Maximum ledge height that is considered to still be traversable.
     * [Limit: >=0] [Units: vx].
     */
    public int getWalkableClimb() {
        return RecastJNI.rcConfig_walkableClimb_get(swigCPtr, this);
    }

    /**
     * In general, this is the closest any part of the final mesh should get to
     * an obstruction in the source geometry. It is usually set to the maximum
     * agent radius.
     *
     * While a value of zero is legal, it is not recommended and can result in
     * odd edge case issues.
     *
     * @param value The distance to erode/shrink the walkable area of the
     * heightfield away from obstructions. [Limit: >=0] [Units: vx]
     */
    public void setWalkableRadius(int value) {
        RecastJNI.rcConfig_walkableRadius_set(swigCPtr, this, value);
    }

    /**
     * In general, this is the closest any part of the final mesh should get to
     * an obstruction in the source geometry. It is usually set to the maximum
     * agent radius.
     *
     * While a value of zero is legal, it is not recommended and can result in
     * odd edge case issues.
     *
     * @return The distance to erode/shrink the walkable area of the heightfield
     * away from obstructions. [Limit: >=0] [Units: vx]
     */
    public int getWalkableRadius() {
        return RecastJNI.rcConfig_walkableRadius_get(swigCPtr, this);
    }

    /**
     * Extra vertices will be inserted as needed to keep contour edges below
     * this length. A value of zero effectively disables this feature.
     *
     * @param value The maximum allowed length for contour edges along the
     * border of the mesh. [Limit: >=0] [Units: vx].
     */
    public void setMaxEdgeLength(int value) {
        RecastJNI.rcConfig_maxEdgeLen_set(swigCPtr, this, value);
    }

    /**
     * Extra vertices will be inserted as needed to keep contour edges below
     * this length. A value of zero effectively disables this feature.
     *
     * @return The maximum allowed length for contour edges along the border of
     * the mesh. [Limit: >=0] [Units: vx].
     */
    public int getMaxEdgeLength() {
        return RecastJNI.rcConfig_maxEdgeLen_get(swigCPtr, this);
    }

    /**
     * The effect of this parameter only applies to the xz-plane.
     *
     * @param value The maximum distance a simplfied contour's border edges
     * should deviate the original raw contour.
     *
     * [Limit: >=0] [Units: vx]
     *
     */
    public void setMaxSimplificationError(float value) {
        RecastJNI.rcConfig_maxSimplificationError_set(swigCPtr, this, value);
    }

    /**
     * The effect of this parameter only applies to the xz-plane.
     *
     * @return The maximum distance a simplfied contour's border edges should
     * deviate the original raw contour.
     *
     * [Limit: >=0] [Units: vx]
     */
    public float getMaxSimplificationError() {
        return RecastJNI.rcConfig_maxSimplificationError_get(swigCPtr, this);
    }

    /**
     * Any regions that are smaller than this area will be marked as unwalkable.
     * This is useful in removing useless regions that can sometimes form on
     * geometry such as table tops, box tops, etc.
     *
     * @param value The minimum number of cells allowed to form isolated island
     * areas. [Limit: >=0] [Units: vx].
     */
    public void setMinRegionArea(int value) {
        RecastJNI.rcConfig_minRegionArea_set(swigCPtr, this, value);
    }

    /**
     * Any regions that are smaller than this area will be marked as unwalkable.
     * This is useful in removing useless regions that can sometimes form on
     * geometry such as table tops, box tops, etc.
     *
     * @return The minimum number of cells allowed to form isolated island
     * areas. [Limit: >=0] [Units: vx].
     */
    public int getMinRegionArea() {
        return RecastJNI.rcConfig_minRegionArea_get(swigCPtr, this);
    }

    /**
     *
     * @param value Any regions with a span count smaller than this value will,
     * if possible, be merged with larger regions. [Limit: >=0] [Units: vx]
     */
    public void setMergeRegionArea(int value) {
        RecastJNI.rcConfig_mergeRegionArea_set(swigCPtr, this, value);
    }

    /**
     *
     * @return Any regions with a span count smaller than this value will, if
     * possible, be merged with larger regions. [Limit: >=0] [Units: vx]
     */
    public int getMergeRegionArea() {
        return RecastJNI.rcConfig_mergeRegionArea_get(swigCPtr, this);
    }

    /**
     * If the mesh data is to be used to construct a DetourBuilder navigation mesh,
     * then the upper limit is limited to smaller than DT_VERTS_PER_POLYGON.
     *
     * @param value The maximum number of vertices allowed for polygons
     * generated during the contour to polygon conversion process. [Limit: >= 3]
     * @see DetourBuilder#DT_VERTS_PER_POLYGON()
     */
    public void setMaxVerticesPerPoly(int value) {
        RecastJNI.rcConfig_maxVertsPerPoly_set(swigCPtr, this, value);
    }

    /**
     * If the mesh data is to be used to construct a DetourBuilder navigation mesh,
     * then the upper limit is limited to smaller than DT_VERTS_PER_POLYGON.
     *
     * @return The maximum number of vertices allowed for polygons generated
     * during the contour to polygon conversion process. [Limit: >= 3]
     * @see DetourBuilder#DT_VERTS_PER_POLYGON()
     */
    public int getMaxVerticesPerPoly() {
        return RecastJNI.rcConfig_maxVertsPerPoly_get(swigCPtr, this);
    }

    /**
     * Sets the sampling distance to use when generating the detail mesh. (For
     * height detail only.) [Limits: 0 or >= 0.9] [Units: wu]
     *
     * @param value
     */
    public void setDetailSampleDistance(float value) {
        RecastJNI.rcConfig_detailSampleDist_set(swigCPtr, this, value);
    }

    /**
     * Sets the sampling distance to use when generating the detail mesh. (For
     * height detail only.) [Limits: 0 or >= 0.9] [Units: wu]
     *
     * @return
     */
    public float getDetailSampleDistance() {
        return RecastJNI.rcConfig_detailSampleDist_get(swigCPtr, this);
    }

    /**
     * The maximum distance the detail mesh surface should deviate from
     * heightfield data.
     *
     * (For height detail only.) [Limit: >=0] [Units: wu]
     *
     * @param value
     */
    public void setDetailSampleMaxError(float value) {
        RecastJNI.rcConfig_detailSampleMaxError_set(swigCPtr, this, value);
    }

    /**
     * The maximum distance the detail mesh surface should deviate from
     * heightfield data.
     *
     * (For height detail only.) [Limit: >=0] [Units: wu]
     *
     * @return
     */
    public float getDetailSampleMaxError() {
        return RecastJNI.rcConfig_detailSampleMaxError_get(swigCPtr, this);
    }
}
