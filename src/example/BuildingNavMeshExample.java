package example;

import com.jme3.ai.navigation.recast.CompactHeightfield;
import com.jme3.ai.navigation.recast.Config;
import com.jme3.ai.navigation.recast.Context;
import com.jme3.ai.navigation.recast.ContourSet;
import com.jme3.ai.navigation.recast.Heightfield;
import com.jme3.ai.navigation.recast.PolyMesh;
import com.jme3.ai.navigation.recast.PolyMeshDetail;
import com.jme3.ai.navigation.recast.RecastBuilder;
import com.jme3.math.Vector3f;

/**
 * Testing if everything is working correctly.
 *
 * @author Tihomir Radosavljevic
 */
public class BuildingNavMeshExample {

    public static void main(String[] args) {

        //setting some positions for vertices
        Vector3f[] positions = new Vector3f[3];
        positions[0] = new Vector3f(0, 5, 0);
        positions[1] = new Vector3f(0, 0, 5);
        positions[2] = new Vector3f(5, 0, 0);

        int[] triangles = new int[3];
        triangles[0] = 0;
        triangles[1] = 1;
        triangles[2] = 2;

        // Step 1. Initialize build config.
        Config config = new Config();

        Vector3f minBounds = RecastBuilder.calculateMinBounds(positions);
        Vector3f maxBounds = RecastBuilder.calculateMaxBounds(positions);
        config.setMaxBounds(maxBounds);
        config.setMinBounds(minBounds);

        config.setCellSize(0.3f);
        config.setCellHeight(0.2f);

        int width = RecastBuilder.calculateGridWidth(minBounds, maxBounds, config.getCellSize());
        int height = RecastBuilder.calculateGridHeight(minBounds, maxBounds, config.getCellSize());
        config.setWidth(width);
        config.setHeight(height);

        // Step 2. Rasterize input polygon soup.

        //context is needed for loging that is not yet supported in native library. It must not be null.
        Context context = new Context();
        // Allocate voxel heightfield where we rasterize our input data to.
        Heightfield heightfield = new Heightfield();

        if (!RecastBuilder.createHeightfield(context, heightfield, config)) {
            System.out.println("Could not create solid heightfield");
            return;
        }
        //important function, but I don't yet understand its usage
        //RecastBuilder.markWalkableTriangles(context, 20, positions, triangles);

        RecastBuilder.rasterizeTriangle(context, new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(0, 0, 1), (short) 1, heightfield, 3);

        // Step 3. Filter walkables surfaces.
        // Once all geoemtry is rasterized, we do initial pass of filtering to
        // remove unwanted overhangs caused by the conservative rasterization
        // as well as filter spans where the character cannot possibly stand.
        RecastBuilder.filterLowHangingWalkableObstacles(context, height, heightfield);
        RecastBuilder.filterLedgeSpans(context, height, height, heightfield);
        RecastBuilder.filterWalkableLowHeightSpans(context, height, heightfield);


        // Step 4. Partition walkable surface to simple regions.
        // Compact the heightfield so that it is faster to handle from now on.
        // This will result more cache coherent data as well as the neighbours
        // between walkable cells will be calculated.
        CompactHeightfield compactHeightfield = new CompactHeightfield();

        if (!RecastBuilder.buildCompactHeightfield(context, height, height, heightfield, compactHeightfield)) {
            System.out.println("Could not build compact data");
            return;
        }

        if (!RecastBuilder.erodeWalkableArea(context, width, compactHeightfield)) {
            System.out.println("Could not erode");
            return;
        }

        // Partition the heightfield so that we can use simple algorithm later to triangulate the walkable areas.
        // There are 3 martitioning methods, each with some pros and cons:
        // 1) Watershed partitioning
        //   - the classic Recast partitioning
        //   - creates the nicest tessellation
        //   - usually slowest
        //   - partitions the heightfield into nice regions without holes or overlaps
        //   - the are some corner cases where this method creates produces holes and overlaps
        //      - holes may appear when a small obstacles is close to large open area (triangulation can handle this)
        //      - overlaps may occur if you have narrow spiral corridors (i.e stairs), this make triangulation to fail
        //   * generally the best choice if you precompute the nacmesh, use this if you have large open areas
        // 2) Monotone partioning
        //   - fastest
        //   - partitions the heightfield into regions without holes and overlaps (guaranteed)
        //   - creates long thin polygons, which sometimes causes paths with detours
        //   * use this if you want fast navmesh generation
        String partitionType = "Sample partition watershed";

        if (partitionType.equals("Sample partition watershed")) {
            if (!RecastBuilder.buildDistanceField(context, compactHeightfield)) {
                System.out.println("Could not build distance field");
                return;
            }
            if (!RecastBuilder.buildRegions(context, compactHeightfield, height, height, height)) {
                System.out.println("Could not build watershed regions");
                return;
            }
        }

        if (partitionType.equals("Sample partition monotone")) {
            if (!RecastBuilder.buildRegionsMonotone(context, compactHeightfield, height, height, height)) {
                System.out.println("Could not build monotone regions");
                return;
            }
        }

        // Step 5. Trace and simplify region contours.
        // Create contours.
        ContourSet contourSet = new ContourSet();

        if (!RecastBuilder.buildContours(context, compactHeightfield, height, height, contourSet)) {
            System.out.println("Could not create contours");
            return;
        }

        // Step 6. Build polygons mesh from contours.
        // Build polygon navmesh from the contours.
        PolyMesh polyMesh = new PolyMesh();

        if (!RecastBuilder.buildPolyMesh(context, contourSet, width, polyMesh)) {
            System.out.println("Could not triangulate contours");
            return;
        }

        // Step 7. Create detail mesh which allows to access approximate height on each polygon.
        PolyMeshDetail polyMeshDetail = new PolyMeshDetail();

        if (!RecastBuilder.buildPolyMeshDetail(context, polyMesh, compactHeightfield, height, height, polyMeshDetail)) {
            System.out.println("Could not build detail mesh.");
            return;
        }

        // (Optional) Step 8. Create Detour data from Recast poly mesh.

        //final step of Detour

    }
}
