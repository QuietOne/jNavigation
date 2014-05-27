package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.CompactHeightfield.CompactSpan;
import com.jme3.ai.recast.structures.CompactHeightfield.HeightfieldLayerSet;
import com.jme3.ai.recast.structures.Heightfield;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class CompactHeightfieldBuilder extends Builder {

    private CompactHeightfield compactHeightfield;

    @Override
    public void initializeStructure() {
        compactHeightfield = new CompactHeightfield();
    }

    public CompactHeightfield getCompactHeightfield() {
        return compactHeightfield;
    }

    public boolean buildCompactHeightfield(int walkableHeight, int walkableClimb, Heightfield heightfield){
        return rcBuildCompactHeightfield(walkableHeight, walkableClimb, heightfield);
    }
    
    private native boolean rcBuildCompactHeightfield(int walkableHeight, int walkableClimb, Heightfield hf);
    
    public boolean erodeWalkableArea(int radius){
        return rcErodeWalkableArea(radius);
    }

    private native boolean rcErodeWalkableArea(int radius);

    public boolean medianFilterWalkableArea(){
        return rcMedianFilterWalkableArea();
    }
    
    private native boolean rcMedianFilterWalkableArea();
    
    public void markBoxArea(Vector3f minBound, Vector3f maxBound, char area){
        rcMarkBoxArea(convertToFloatArray(minBound), convertToFloatArray(maxBound), area);
    }

    private native void rcMarkBoxArea(float[] bmin, float[] bmax, char area);
    
    public void markConvexPolyArea(Vector3f[] vertices, float minHeight, float maxHeight, char area){
        rcMarkConvexPolyArea(convertToFloatArray(vertices), minHeight, maxHeight, area);
    }

    private native void rcMarkConvexPolyArea(float[] verts, float hmin, float hmax, char area);

    public int offsetPoly(Vector3f[] vertices, float offset, Vector3f[] outVertices){
        return rcOffsetPoly(convertToFloatArray(vertices), offset, convertToFloatArray(outVertices));
    }
    
    private native int rcOffsetPoly(float[] verts, float offset, float[] outVerts);

    public void markCylinderArea(Vector3f position, float radius, float height, char area){
        rcMarkCylinderArea(convertToFloatArray(position), radius, height, area);
    }
    
    private native void rcMarkCylinderArea(float[] pos, float r, float h, char area);

    public boolean buildDistanceField(){
        return rcBuildDistanceField();
    }
    
    private native boolean rcBuildDistanceField();
    
    public boolean buildRegions(int borderSize, int minRegionArea, int mergeRegionArea){
        return rcBuildRegions(borderSize, minRegionArea, mergeRegionArea);
    }

    private native boolean rcBuildRegions(int borderSize, int minRegionArea, int mergeRegionArea);

    public boolean buildRegionsMonotone(int borderSize, int minRegionArea, int mergeRegionArea){
        return rcBuildRegionsMonotone(borderSize, minRegionArea, mergeRegionArea);
    }
    
    private native boolean rcBuildRegionsMonotone(int borderSize, int minRegionArea, int mergeRegionArea);

    public void setConnection(CompactSpan compactSpan, int direction, int index){
        rcSetCon(compactSpan, index, index);
    }
    
    private native void rcSetCon(CompactSpan s, int dir, int i);

    public int getConnection(CompactSpan compactSpan, int direction){
        return rcGetCon(compactSpan, direction);
    }
    
    private native int rcGetCon(CompactSpan s, int dir);
    
    public int getDirectionOffsetX(int direction){
        return rcGetDirOffsetX(direction);
    }

    private native int rcGetDirOffsetX(int dir);

    public int getDirectionOffsetY(int direction){
        return rcGetDirOffsetY(direction);
    }
    
    private native int rcGetDirOffsetY(int dir);

    public boolean buildHeightfieldLayers(int borderSize, int walkableHeight, HeightfieldLayerSet heightfieldLayerSet){
        return rcBuildHeightfieldLayers(borderSize, walkableHeight, heightfieldLayerSet);
    }
    
    private native boolean rcBuildHeightfieldLayers(int borderSize, int walkableHeight, HeightfieldLayerSet lset);
}
