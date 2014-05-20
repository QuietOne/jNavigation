package com.jme3.ai.recast.util;

/**
 * Represents a simple, non-overlapping contour in field space.
 *
 * A contour only exists within the context of a ContourSet object.

 While the height of the contour's border may vary, the contour will always
 form a simple polygon when projected onto the xz-plane.

 Example of converting vertices into world space:

 // Where cset is the ContourSet object to which the contour belongs. float
 worldX = cset.bmin[0] + vertX * cset.cs; float worldY = cset.bmin[1] + vertY
 * cset.ch; float worldZ = cset.bmin[2] + vertZ * cset.cs; See Also
 ContourSet
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class Contour {

    /**
     * WARNING: unsigned char The area id of the contour.
     */
    char area;

    /**
     * The number of vertices in the raw contour.
     */
    public int nrverts;

    /**
     * The number of vertices in the simplified contour.
     */
    public int nverts;

    /**
     * WARNING: unsigned short The region id of the contour.
     */
    public int reg;

    /**
     * Raw contour vertex and connection data. [Size: 4 * nrverts]. See verts
     * for information on element layout.
     */
    public int rverts;

    /**
     * Simplified contour vertex and connection data. [Size: 4 * nverts].
     *
     * The simplified contour is a version of the raw contour with all
     * 'unnecessary' vertices removed. Whether a vertex is considered
     * unnecessary depends on the contour build process.
     *
     * The data format is as follows: (x, y, z, r) * nverts
     *
     * A contour edge is formed by the current and next vertex. The r-value
     * represents region and connection information for the edge. For example:
     * int r = verts[i*4+3]; int regionId = r & RC_CONTOUR_REG_MASK; if (r &
     * RC_BORDER_VERTEX) { // The edge represents a solid border. } if (r &
     * RC_AREA_BORDER) { // The edge represents a transition between different
     * areas. }
     */
    public int[] verts = new int[4];

}
