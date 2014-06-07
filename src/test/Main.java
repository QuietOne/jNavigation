package test;

import com.jme3.ai.recast.Config;
import com.jme3.ai.recast.Context;
import com.jme3.ai.recast.Heightfield;
import com.jme3.ai.recast.RecastBuilder;
import com.jme3.math.Vector3f;

/**
 * Testing if everything is working correctly.
 *
 * @author tihomir
 */
public class Main {

    public static void main(String[] args) {
        Vector3f[] positions = new Vector3f[3];
        positions[0] = new Vector3f(0, 0, 0);
        positions[1] = new Vector3f(25, 25, 25);
        positions[2] = new Vector3f(50, 0, 0);
        
        int[] indices = new int[3];
        indices[0] = 0;
        indices[1] = 1;
        indices[2] = 2;
        
        Config config = new Config();
        
        Vector3f minBounds = null;
        Vector3f maxBounds = null;
        
        for (Vector3f position : positions) {
            if (maxBounds==null) {
                maxBounds = new Vector3f(position.x, position.y, position.z);
            }
            if (minBounds==null) {
                minBounds = new Vector3f(position.x, position.y, position.z);
            }
            if (position.x > maxBounds.x) {
                maxBounds.x = position.x;
            }
            if (position.y > maxBounds.y) {
                maxBounds.y = position.y;
            }
            if (position.z > maxBounds.z) {
                maxBounds.z = position.z;
            }
            if (position.x > minBounds.x) {
                minBounds.x = position.x;
            }
            if (position.y > minBounds.y) {
                minBounds.y = position.y;
            }
            if (position.z > minBounds.z) {
                minBounds.z = position.z;
            }
        }
     
        config.setMaxBounds(maxBounds);
        config.setMinBounds(minBounds);
        config.setCellSize(0.3f);
        config.setCellHeight(0.2f);
        
        Context context = new Context();
        config.setWidth(RecastBuilder.calculateGridWidth(minBounds, maxBounds, config.getCellSize()));
        config.setHeight(RecastBuilder.calculateGridHeight(minBounds, maxBounds, config.getCellSize()));
        
        Heightfield heightfield = new Heightfield();
        RecastBuilder.createHeightfield(context, heightfield, config.getWidth(), config.getHeight(), config.getMinBounds(), config.getMaxBounds(), config.getCellSize(), config.getCellHeight());
        System.out.println(heightfield.getCellHeight());
        System.out.println(heightfield.getMinBounds());
    }
}
