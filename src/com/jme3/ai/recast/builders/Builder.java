package com.jme3.ai.recast.builders;

/**
 * Interface for structure builder.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public interface Builder {

    /**
     * Allocation of structure and initializing it.
     */
    public void initializeStructure();

    /**
     * Automatic build of structure.
     */
    public void build();
}
