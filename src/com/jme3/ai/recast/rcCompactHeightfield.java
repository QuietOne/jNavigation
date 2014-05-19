package com.jme3.ai.recast;

import com.jme3.ai.recast.util.rcCompactSpan;
import com.jme3.ai.recast.util.rcCompactCell;
import com.jme3.ai.recast.util.rcCompactCell;
import java.util.List;

/**
 * A compact, static heightfield representing unobstructed space.
 *
 * For this type of heightfield, the spans represent the open (unobstructed)
 * space above the solid surfaces of a voxel field. It is usually created from a
 * rcHeightfield object. Data is stored in a compact, efficient manner, but the
 * structure is not condusive to adding and removing spans.
 *
 * The standard process for buidling a compact heightfield is to allocate it
 * using rcAllocCompactHeightfield, build it using rcBuildCompactHeightfield,
 * then run it through the various helper functions to generate neighbor and
 * region data.
 *
 * Connected neighbor spans form non-overlapping surfaces. When neighbor
 * information is generated, spans will include data that can be used to locate
 * axis-neighbors. Axis-neighbors are connected spans that are offset from the
 * current cell column as follows:
 *
 * Direction 0 = (-1, 0) Direction 1 = (0, 1) Direction 2 = (1, 0) Direction 3 =
 * (0, -1) Example of iterating and inspecting spans, including connected
 * neighbors:
 *
 * // Where chf is an instance of a rcCompactHeightfield. const float cs =
 * chf.cs; const float ch = chf.ch; for (int y = 0; y < chf.height; ++y) { for
 * (int x = 0; x < chf.width; ++x) { // Deriving the minimum corner of the grid
 * location. const float fx = chf.bmin[0] + x*cs; const float fz = chf.bmin[2] +
 * y*cs; // Get the cell for the grid location then iterate // up the column.
 * const rcCompactCell& c = chf.cells[x+y*chf.width]; for (unsigned i = c.index,
 * ni = c.index+c.count; i < ni; ++i) { const rcCompactSpan& s = chf.spans[i];
 * Deriving the minimum (floor) of the span. const float fy = chf.bmin[1] +
 * (s.y+1)*ch; // Testing the area assignment of the span. if (chf.areas[i] ==
 * RC_WALKABLE_AREA) { // The span is in the default 'walkable area'. } else if
 * (chf.areas[i] == RC_NULL_AREA) { // The surface is not considered walkable.
 * // E.g. It was filtered out during the build processes. } else { // Do
 * something. (Only applicable for custom build // build processes.) } //
 * Iterating the connected axis-neighbor spans. for (int dir = 0; dir < 4;
 * ++dir) { if (rcGetCon(s, dir) != RC_NOT_CONNECTED) { // There is a neighbor
 * in this direction. const int nx = x + rcGetDirOffsetX(dir); const int ny = y
 * + rcGetDirOffsetY(dir); const int ni = (int)chf.cells[nx+ny*w].index +
 * rcGetCon(s, 0); const rcCompactSpan& ns = chf.spans[ni]; // Do something with
 * the neighbor span. } } } } } See Also rcAllocCompactHeightfield,
 * rcFreeCompactHeightfield, rcBuildCompactHeightfield
 *
 * @author TihomirRadosavljevic
 * @version 0.1
 */
public class rcCompactHeightfield {

    /**
     * WARNING: unsigned char* Array containing area id data. [Size: spanCount].
     */
    public String areas;

    /**
     * The maximum bounds in world space. [(x, y, z)].
     */
    public float[] bmax = new float[3];

    /**
     * The minimum bounds in world space. [(x, y, z)].
     */
    public float[] bmin = new float[3];

    /**
     * The AABB border size used during the build of the field. (See:
     * rcConfig::borderSize)
     */
    public int borderSize;

    /**
     * Array of cells. [Size: width*height].
     */
    public rcCompactCell cells;

    /**
     * The height of each cell. (The minimum increment along the y-axis.)
     */
    public float ch;

    /**
     * The size of each cell. (On the xz-plane.)
     */
    public float cs;

    /**
     * WARNING: unsigned short* Array containing border distance data. [Size:
     * spanCount].
     */
    public List<Integer> dist;

    /**
     * The height of the heightfield. (Along the z-axis in cell units.)
     */
    public int height;

    /**
     * WARNING: unsigned short The maximum distance value of any span within the
     * field.
     */
    public int maxDistance;

    /**
     * WARNING: unsigned short The maximum region id of any span within the
     * field.
     */
    public int maxRegions;

    /**
     * The number of spans in the heightfield.
     */
    public int spanCount;

    /**
     * Array of spans. [Size: spanCount].
     */
    public rcCompactSpan spans;

    /**
     * The walkable climb used during the build of the field. (See:
     * rcConfig::walkableClimb)
     */
    public int walkableClimb;

    /**
     * The walkable height used during the build of the field. (See:
     * rcConfig::walkableHeight)
     */
    public int walkableHeight;

    /**
     * The width of the heightfield. (Along the x-axis in cell units.)
     */
    public int width;

}
