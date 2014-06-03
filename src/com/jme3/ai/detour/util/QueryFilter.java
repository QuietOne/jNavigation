package com.jme3.ai.detour.util;

import com.jme3.ai.detour.structures.MeshTile;
import com.jme3.ai.detour.structures.Poly;
import com.jme3.ai.detour.structures.Poly.PolyRef;

/**
 * Defines polygon filtering and traversal costs for navigation mesh query
 * operations.
 *
 * The Default Implementation
 *
 * At construction: All area costs default to 1.0. All flags are included and
 * none are excluded.
 *
 * If a polygon has both an include and an exclude flag, it will be excluded.
 *
 * The way filtering works, a navigation mesh polygon must have at least one
 * flag set to ever be considered by a query. So a polygon with no flags will
 * never be considered.
 *
 * Setting the include flags to 0 will result in all polygons being excluded.
 *
 * @author Tihomir Radosavljevic
 */
public class QueryFilter {

    private Object reference;

    public QueryFilter() {
        reference = allocQueryFilter();
    }

    private native Object allocQueryFilter();

    public boolean passFilter(PolyRef polyRef, MeshTile meshTile, Poly poly) {
        return passFilterDT(polyRef, meshTile, poly);
    }

    private native boolean passFilterDT(PolyRef polyRef, MeshTile meshTile, Poly poly);

    public float getAreaCost(int i){
        return getAreaCostDT(i);
    }
    
    private native float getAreaCostDT(int i);

    public void setAreaCost(int i, float cost){
        setAreaCostDT(i, cost);
    }
    
    private native void setAreaCostDT(int i, float cost);

    public short getIncludeFlags(){
        return getIncludeFlagsDT();
    }
    
    private native short getIncludeFlagsDT();
    
    public void setIncludeFlags(short flags){
        setIncludeFlagsDT(flags);
    }
    
    private native void setIncludeFlagsDT(short flags);
    
    public short getExcludeFlags(){
        return getExcludeFlagsDT();
    }
    
    private native short getExcludeFlagsDT();
    
    public void setExcludeFlags(short flags){
        setExcludeFlagsDT(flags);
    }
    
    private native void setExcludeFlagsDT(short flags);
            
    //getCost
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        freeQueryFilter(this);
    }

    private native void freeQueryFilter(QueryFilter filter);
}
