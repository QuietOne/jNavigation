package com.jme3.ai.recast.util;

/**
 * This class is not separate class in Recast Navigation, but for now, this is
 * class with all constants found in recast module
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class Variables {

    /**
     * Area border flag.
     *
     * If a region ID has this bit set, then the associated element lies on the
     * border of an area. (Used during the region and contour build process.)
     *
     * See Also rcCompactSpan::reg, rcContour::verts, rcContour::rverts
     */
    public final static int RC_AREA_BORDER = 0x20000;

    /**
     * WARNING: unsigned short
     *
     * Heighfield border flag. If a heightfield region ID has this bit set, then
     * the region is a border region and its spans are considered unwalkable.
     * (Used during the region and contour build process.)
     *
     * See Also rcCompactSpan::reg
     */
    public final static int RC_BORDER_REG = 0x8000;

    /**
     * Border vertex flag.
     *
     * If a region ID has this bit set, then the associated element lies on a
     * tile border. If a contour vertex's region ID has this bit set, the vertex
     * will later be removed in order to match the segments and vertices at tile
     * boundaries. (Used during the build process.)
     *
     * See Also rcCompactSpan::reg, rcContour::verts, rcContour::rverts
     */
    public final static int RC_BORDER_VERTEX = 0x10000;

    /**
     * Applied to the region id field of contour vertices in order to extract
     * the region id.
     *
     * The region id field of a vertex may have several flags applied to it. So
     * the fields value can't be used directly.
     *
     * See Also rcContour::verts, rcContour::rverts
     */
    public final static int RC_CONTOUR_REG_MASK = 0xffff;

    /**
     * WARNING: unsigned short
     *
     * An value which indicates an invalid index within a mesh.
     *
     * Note This does not necessarily indicate an error. See Also
     * rcPolyMesh::polys
     */
    public final static int RC_MESH_NULL_IDX = 0xffff;
    /**
     * The value returned by rcGetCon if the specified direction is not
     * connected to another span.
     *
     * (Has no neighbor.)
     */
    public final static int RC_NOT_CONNECTED = 0x3f;

    /**
     * WARNING: unsigned char
     *
     * Represents the null area.
     *
     * When a data element is given this value it is considered to no longer be
     * assigned to a usable area. (E.g. It is unwalkable.)
     */
    public final static char RC_NULL_AREA = 0;

    /**
     * The value of PI used by Recast.
     */
    public final static float RC_PI = 3.14159265f;
    /**
     * Defines the number of bits allocated to rcSpan::smin and rcSpan::smax.
     */
    public final static int RC_SPAN_HEIGHT_BITS = 13;
    /**
     * Defines the maximum value for rcSpan::smin and rcSpan::smax.
     */
    public static final int RC_SPAN_MAX_HEIGHT = (1 << RC_SPAN_HEIGHT_BITS) - 1;
    /**
     * The number of spans allocated per span spool.
     *
     * See Also rcSpanPool
     */
    public final static int RC_SPANS_PER_POOL = 2048;

    /**
     * WARNING: unsigned char
     *
     * The default area id used to indicate a walkable polygon.
     *
     * This is also the maximum allowed area id, and the only non-null area id
     * recognized by some steps in the build process.
     */
    public final static char RC_WALKABLE_AREA = 63;

}
