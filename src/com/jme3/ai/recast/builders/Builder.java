package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.BoundedField;

/**
 *
 * @author Tihomir Radosavljevic
 */
public interface Builder {
    
    public void initializeStructure();
    
    public BoundedField build();
}
