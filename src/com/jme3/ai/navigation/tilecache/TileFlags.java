package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Tile flags used for various functions and fields.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public final class TileFlags {

    /**
     * The navigation mesh owns the tile memory and is responsible for freeing
     * it.
     */
    public final static TileFlags DT_TILE_FREE_DATA = new TileFlags("DT_TILE_FREE_DATA", RecastJNI.DT_TILE_FREE_DATA_get());

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static TileFlags swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + TileFlags.class + " with value " + swigValue);
    }

    private TileFlags(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private TileFlags(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private TileFlags(String swigName, TileFlags swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static TileFlags[] swigValues = {DT_TILE_FREE_DATA};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
