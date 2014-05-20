package com.jme3.ai.recast;

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
 * @version 0.1
 */
public class Config {

    /**
     * The maximum bounds of the field's AABB. [(x, y, z)] [Units: wu].
     */
    public float[] bmax = new float[3];
    /**
     * The minimum bounds of the field's AABB. [(x, y, z)] [Units: wu].
     */
    public float[] bmin = new float[3];
    /**
     * he size of the non-navigable border around the heightfield. [Limit: >=0]
     * [Units: vx].
     *
     * This value represents the the closest the walkable area of the
     * heightfield should come to the xz-plane AABB of the field. It does not
     * have any impact on the borders around internal obstructions.
     */
    public int borderSize;

    /**
     * The y-axis cell size to use for fields. [Limit: > 0] [Units: wu].
     *
     * cs and ch define voxel/grid/cell size. So their values have significant
     * side effects on all parameters defined in voxel units.
     *
     * The minimum value for this parameter depends on the platform's floating
     * point accuracy, with the practical minimum usually around 0.05.
     */
    public float ch;
    /**
     * The xz-plane cell size to use for fields. [Limit: > 0] [Units: wu].
     *
     * cs and ch define voxel/grid/cell size. So their values have significant
     * side effects on all parameters defined in voxel units.
     *
     * The minimum value for this parameter depends on the platform's floating
     * point accuracy, with the practical minimum usually around 0.05.
     */
    public float cs;
    /**
     * Sets the sampling distance to use when generating the detail mesh.
     *
     * (For height detail only.) [Limits: 0 or >= 0.9] [Units: wu]
     */
    public float detailSampleDist;
    /**
     * The maximum distance the detail mesh surface should deviate from
     * heightfield data.
     *
     * (For height detail only.) [Limit: >=0] [Units: wu]
     */
    public float detailSampleMaxError;
    /**
     * The height of the field along the z-axis. [Limit: >= 0] [Units: vx].
     */
    public int height;
    /**
     * The maximum allowed length for contour edges along the border of the
     * mesh. [Limit: >=0] [Units: vx].
     *
     * Extra vertices will be inserted as needed to keep contour edges below
     * this length. A value of zero effectively disables this feature.
     */
    public int maxEdgeLen;

    /**
     * The maximum distance a simplfied contour's border edges should deviate
     * the original raw contour.
     *
     * [Limit: >=0] [Units: vx]
     *
     * The effect of this parameter only applies to the xz-plane.
     */
    public float maxSimplificationError;
    /**
     * The maximum number of vertices allowed for polygons generated during the
     * contour to polygon conversion process.
     *
     * [Limit: >= 3]
     *
     * If the mesh data is to be used to construct a Detour navigation mesh,
     * then the upper limit is limited to <= DT_VERTS_PER_POLYGON.
     */
    public int maxVertsPerPoly;
    /**
     * Any regions with a span count smaller than this value will, if possible,
     * be merged with larger regions.
     *
     * [Limit: >=0] [Units: vx]
     */
    public int mergeRegionArea;

    /**
     * The minimum number of cells allowed to form isolated island areas.
     * [Limit: >=0] [Units: vx].
     *
     * Any regions that are smaller than this area will be marked as unwalkable.
     * This is useful in removing useless regions that can sometimes form on
     * geometry such as table tops, box tops, etc.
     */
    public int minRegionArea;

    /**
     * The width/height size of tile's on the xz-plane. [Limit: >= 0] [Units:
     * vx].
     *
     * This field is only used when building multi-tile meshes.
     */
    public int tileSize;
    /**
     * Maximum ledge height that is considered to still be traversable. [Limit:
     * >=0] [Units: vx].
     *
     * Allows the mesh to flow over low lying obstructions such as curbs and
     * up/down stairways. The value is usually set to how far up/down an agent
     * can step.
     */
    public int walkableClimb;
    /**
     * Minimum floor to 'ceiling' height that will still allow the floor area to
     * be considered walkable.
     *
     * [Limit: >= 3] [Units: vx]
     *
     * Permits detection of overhangs in the source geometry that make the
     * geometry below un-walkable. The value is usually set to the maximum agent
     * height.
     */
    public int walkableHeight;
    /**
     * The distance to erode/shrink the walkable area of the heightfield away
     * from obstructions.
     *
     * [Limit: >=0] [Units: vx]
     *
     * In general, this is the closest any part of the final mesh should get to
     * an obstruction in the source geometry. It is usually set to the maximum
     * agent radius.
     *
     * While a value of zero is legal, it is not recommended and can result in
     * odd edge case issues.
     */
    public int walkableRadius;
    /**
     * The maximum slope that is considered walkable. [Limits: 0 <= value < 90]
     * [Units: Degrees].
     *
     * The practical upper limit for this parameter is usually around 85
     * degrees.
     */
    public float walkableSlopeAngle;
    /**
     * The width of the field along the x-axis. [Limit: >= 0] [Units: vx].
     */
    public int width;
}
