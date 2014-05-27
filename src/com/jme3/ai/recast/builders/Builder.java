package com.jme3.ai.recast.builders;

import com.jme3.math.Vector3f;

/**
 * Interface for structure builder.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public abstract class Builder {

    /**
     * Allocation of structure and initializing it.
     */
    public abstract void initializeStructure();

    /**
     * Method for converting Vector3f to adequate array requested by native functions.
     * @param array
     * @return 
     */
    protected float[] convertToFloatArray(Vector3f[] array) {
        float[] newArray = new float[array.length * 3];
        for (int i = 0; i < array.length; i++) {
            newArray[i * 3] = array[i].getX();
            newArray[i * 3 + 1] = array[i].getY();
            newArray[i * 3 + 2] = array[i].getZ();
        }
        return newArray;
    }

    /**
     * Method for converting Vector3f to adequate array requested by native functions.
     * @param vector
     * @return 
     */
    protected float[] convertToFloatArray(Vector3f vector) {
        float[] array = new float[3];
        array[0] = vector.getX();
        array[1] = vector.getY();
        array[2] = vector.getZ();
        return array;
    }
}
