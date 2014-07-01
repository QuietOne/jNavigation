package com.jme3.ai.navigation.tilecache;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 * Flags for addTile.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public final class CompressedTileFlags {

    /**
     * Navmesh owns the tile memory and should free it.
     */
    public final static CompressedTileFlags DT_COMPRESSEDTILE_FREE_DATA = new CompressedTileFlags("DT_COMPRESSEDTILE_FREE_DATA", RecastJNI.DT_COMPRESSEDTILE_FREE_DATA_get());

    public final int swigValue() {
        return swigValue;
    }

    @Override
    public String toString() {
        return swigName;
    }

    public static CompressedTileFlags swigToEnum(int swigValue) {
        if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue) {
            return swigValues[swigValue];
        }
        for (int i = 0; i < swigValues.length; i++) {
            if (swigValues[i].swigValue == swigValue) {
                return swigValues[i];
            }
        }
        throw new IllegalArgumentException("No enum " + CompressedTileFlags.class + " with value " + swigValue);
    }

    private CompressedTileFlags(String swigName) {
        this.swigName = swigName;
        this.swigValue = swigNext++;
    }

    private CompressedTileFlags(String swigName, int swigValue) {
        this.swigName = swigName;
        this.swigValue = swigValue;
        swigNext = swigValue + 1;
    }

    private CompressedTileFlags(String swigName, CompressedTileFlags swigEnum) {
        this.swigName = swigName;
        this.swigValue = swigEnum.swigValue;
        swigNext = this.swigValue + 1;
    }
    private static CompressedTileFlags[] swigValues = {DT_COMPRESSEDTILE_FREE_DATA};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
}
