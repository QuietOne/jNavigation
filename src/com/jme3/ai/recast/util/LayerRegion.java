package com.jme3.ai.recast.util;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.1
 */
public class LayerRegion {

    /**
     * WARNING: unsigned
     */
    public char[] layers = new char[Variables.RC_MAX_LAYERS];
    /**
     * WARNING: unsigned
     */
    public char[] neis = new char[Variables.RC_MAX_NEIS];
    /**
     * WARNING: unsigned
     */
    public short ymin;
    /**
     * WARNING: unsigned
     */
    public short ymax;
    /**
     * WARNING: unsigned
     */
    public char layerId;
    /**
     * WARNING: unsigned
     */
    public char nlayers;
    /**
     * WARNING: unsigned
     */
    public char nneis;
    /**
     * WARNING: unsigned
     */
    public char base;
}
