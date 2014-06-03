package com.jme3.ai.detour.util;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class Status {

    /**
     * The maximum number of user defined area ids.
     */
    public static final int MAX_AREAS = 64;
    /**
     * The maximum number of vertices per navigation polygon.
     */
    public static final int VERTICES_PER_POLYGON = 6;
    /**
     * A value that indicates the entity does not link to anything.
     */
    public static final int NULL_LINK = 0xffffffff;
    
    public static final long FAILURE = 1 << 31;
    public static final long SUCCESS = 1 << 30;
    public static final long IN_PROGRESS = 1 << 29;
    public static final long STATUS_DETAIL_MASK = 0x0ffffff;
    public static final long WRONG_MAGIC = 1;
    public static final long WRONG_VERSION = 1 << 1;
    public static final long OUT_OF_MEMORY = 1 << 2;
    public static final long INVALID_PARAM = 1 << 3;
    public static final long BUFFER_TOO_SMALL = 1 << 4;
    public static final long OUT_OF_NODES = 1 << 5;
    public static final long PARTIAL_RESULT = 1 << 6;
    /**
     * Reference to the object.
     */
    private Object reference;
    
    public boolean isSucceed(){
        return dtStatusSucceed();
    }
    
    private native boolean dtStatusSucceed();
    
    public boolean isFailed(){
        return dtStatusFailed();
    }
    
    private native boolean dtStatusFailed();
    
    public boolean isInProgress(){
        return dtStatusInProgress();
    }
    
    private native boolean dtStatusInProgress();
    
    public boolean isDetail(){
        return dtStatusDetail();
    }
    
    //TODO: see about param unsigned int detail
    private native boolean dtStatusDetail();
}
