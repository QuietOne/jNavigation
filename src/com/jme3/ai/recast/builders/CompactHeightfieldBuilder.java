package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.sub.CompactSpan;
import com.jme3.ai.recast.structures.Heightfield;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class CompactHeightfieldBuilder implements Builder{

    private CompactHeightfield compactHeightfield;
    
    @Override
    public void initializeStructure() {
        compactHeightfield = new CompactHeightfield();
    }

    @Override
    public void build() {
        //TODO: fix structure building sequence
    }

    public CompactHeightfield getCompactHeightfield() {
        return compactHeightfield;
    }
    

    
    private native boolean rcBuildCompactHeightfield(int walkableHeight, int walkableClimb, Heightfield hf, CompactHeightfield chf);
    
    private native boolean rcErodeWalkableArea(int radius, CompactHeightfield chf);

    private native boolean rcMedianFilterWalkableArea(CompactHeightfield chf);

    private native void rcMarkBoxArea(float[] bmin, float[] bmax, char areaId, CompactHeightfield chf);

    private native void rcMarkConvexPolyArea(float[] verts, int nverts, float hmin, float hmax, char areaId, CompactHeightfield chf);

    private native int rcOffsetPoly(float[] verts, int nverts, float offset, float[] outVerts, int maxOutVerts);

    private native void rcMarkCylinderArea(float[] pos, float r, float h, char areaId, CompactHeightfield chf);

    private native boolean rcBuildDistanceField(CompactHeightfield chf);

    private native boolean rcBuildRegions(CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea);

    private native boolean rcBuildRegionsMonotone(CompactHeightfield chf, int borderSize, int minRegionArea, int mergeRegionArea);

    private native void rcSetCon(CompactSpan s, int dir, int i);

    private native int rcGetCon(CompactSpan s, int dir);

    private native int rcGetDirOffsetX(int dir);

    private native int rcGetDirOffsetY(int dir);
}
