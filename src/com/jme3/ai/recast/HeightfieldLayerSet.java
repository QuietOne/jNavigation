package com.jme3.ai.recast;

import com.jme3.ai.recast.util.HeightfieldLayer;

/**
 * Represents a set of heightfield layers.
 *
 * See Also rcAllocHeightfieldLayerSet, rcFreeHeightfieldLayerSet
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class HeightfieldLayerSet {

    /**
     * The layers in the set. [Size: nlayers].
     */
    public HeightfieldLayer layers;

    /**
     * The number of layers in the set.
     */
    public int nlayers;

}
