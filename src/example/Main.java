package example;

import com.jme3.ai.navigation.recast.Config;
import com.jme3.ai.navigation.recast.Context;
import com.jme3.ai.navigation.recast.Heightfield;
import com.jme3.ai.navigation.recast.RecastBuilder;
import com.jme3.ai.navigation.recast.Span;
import com.jme3.math.Vector3f;

/**
 * Testing if everything is working correctly.
 *
 * @author Tihomir Radosavljevic
 */
public class Main {

    public static void main(String[] args) {
        Vector3f[] positions = new Vector3f[3];
        positions[0] = new Vector3f(0, 5, 0);
        positions[1] = new Vector3f(0, 0, 5);
        positions[2] = new Vector3f(5, 0, 0);

        int[] indices = new int[3];
        indices[0] = 0;
        indices[1] = 1;
        indices[2] = 2;

        Config config = new Config();

        Vector3f minBounds = RecastBuilder.calculateMinBounds(positions);
        Vector3f maxBounds = RecastBuilder.calculateMaxBounds(positions);


        config.setMaxBounds(maxBounds);
        config.setMinBounds(minBounds);
        config.setCellSize(0.3f);
        config.setCellHeight(0.2f);

        Context context = new Context();
        config.setWidth(RecastBuilder.calculateGridWidth(minBounds, maxBounds, config.getCellSize()));
        config.setHeight(RecastBuilder.calculateGridHeight(minBounds, maxBounds, config.getCellSize()));

        Heightfield heightfield = new Heightfield();
        RecastBuilder.createHeightfield(context, heightfield, config.getWidth(), config.getHeight(), config.getMinBounds(), config.getMaxBounds(), config.getCellSize(), config.getCellHeight());

        RecastBuilder.rasterizeTriangle(context, new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), new Vector3f(0, 0, 1), (short) 1, heightfield, 3);

        Span span = heightfield.getSpans();

        System.out.println("Height: " + config.getHeight());
        System.out.println("Width: " + config.getWidth());

        while (span != null) {
            System.out.println(span);
            span = span.getNext();
        }
    }
}
