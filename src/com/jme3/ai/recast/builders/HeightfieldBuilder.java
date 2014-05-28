package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.Heightfield;
import com.jme3.math.Vector3f;

/**
 * HeightfieldBuilder is class for correct manipulation on Heightfield
 * structure. Always use initializeStructure() and createHeightField() first.
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class HeightfieldBuilder extends Builder {

    private Heightfield heightfield;

    @Override
    public void initializeStructure() {
        heightfield = new Heightfield();
    }

    /**
     * Creates Heightfield with entered constraints. Structure must be
     * initialized first by function initalizeStructure(). If not there will be
     * NullPointerException.
     *
     * @param width
     * @param height
     * @param minBounds
     * @param maxBounds
     * @param cellSize
     * @param cellHeight
     * @return
     */
    public boolean createHeightfield(int width, int height, Vector3f minBounds, Vector3f maxBounds, float cellSize, float cellHeight) {
        return rcCreateHeightfield(width, height, convertToFloatArray(minBounds), convertToFloatArray(maxBounds), cellSize, cellHeight);
    }

    private native boolean rcCreateHeightfield(int width, int height, float[] minBounds, float[] maxBounds, float cellSize, float cellHeight);

    /**
     * 
     * @param vertices 
     */
    public void calculateBounds(Vector3f[] vertices) {
        rcCalcBounds(convertToFloatArray(vertices));
    }

    private native void rcCalcBounds(float[] verts);

    /**
     * 
     */
    public void calculateGridSize() {
        rcCalcGridSize();
    }

    private native void rcCalcGridSize();

    /**
     * 
     * @param walkableSlopeAngle
     * @param vertices
     * @param indexes
     * @param areas 
     */
    public void markWalkableTriangles(float walkableSlopeAngle, Vector3f[] vertices, int[] indexes, char[] areas) {
        rcMarkWalkableTriangles(walkableSlopeAngle, convertToFloatArray(vertices), indexes, areas);
    }

    private native void rcMarkWalkableTriangles(float walkableSlopeAngle, float[] verts, int[] tris, char[] areas);

    /**
     * 
     * @return 
     */
    public int getSpanCount() {
        return rcGetHeightFieldSpanCount();
    }

    private native int rcGetHeightFieldSpanCount();

    /**
     * 
     * @param walkableSlopeAngle
     * @param vertices
     * @param indexes
     * @param areas 
     */
    public void clearUnwalkableTriangles(float walkableSlopeAngle, Vector3f[] vertices, int[] indexes, char[] areas) {
        rcClearUnwalkableTriangles(walkableSlopeAngle, convertToFloatArray(vertices), indexes, areas);
    }

    private native void rcClearUnwalkableTriangles(float walkableSlopeAngle, float[] verts, int[] tris, char[] areas);

    /**
     * 
     * @param x
     * @param y
     * @param minHeight
     * @param maxHeight
     * @param area
     * @param flagMerge 
     */
    public void addSpan(int x, int y, short minHeight, short maxHeight, char area, int flagMerge) {
        rcAddSpan(x, y, minHeight, maxHeight, area, flagMerge);
    }

    private native void rcAddSpan(int x, int y, short smin, short smax, char area, int flagMergeThr);

    /**
     * 
     * @param v0
     * @param v1
     * @param v2
     * @param area
     * @param flagMerge 
     */
    public void rasterizeTriangle(Vector3f v0, Vector3f v1, Vector3f v2, char area, int flagMerge) {
        rcRasterizeTriangle(convertToFloatArray(v0), convertToFloatArray(v1), convertToFloatArray(v2), area, flagMerge);
    }

    private native void rcRasterizeTriangle(float[] v0, float[] v1, float[] v2, char area, int flagMergeThr);

    public void rasterizeTriangles(Vector3f[] vertices, int[] indexes, char[] areas, int flagMerge) {
        rcRasterizeTriangles(convertToFloatArray(vertices), indexes, areas, flagMerge);
    }

    private native void rcRasterizeTriangles(float[] verts, int[] tris, char[] areas, int flagMergeThr);

    /**
     * 
     * @param vertices
     * @param indexes
     * @param areas
     * @param flagMerge 
     */
    public void rasterizeTriangles(Vector3f[] vertices, short[] indexes, char[] areas, int flagMerge) {
        rcRasterizeTriangles(convertToFloatArray(vertices), indexes, areas, flagMerge);
    }

    private native void rcRasterizeTriangles(float[] verts, short[] tris, char[] areas, int flagMergeThr);

    /**
     * 
     * @param vertices
     * @param areas
     * @param flagMerge 
     */
    public void rasterizeTriangles(Vector3f[] vertices, char[] areas, int flagMerge) {
        rcRasterizeTriangles(convertToFloatArray(vertices), areas, flagMerge);
    }

    private native void rcRasterizeTriangles(float[] verts, char[] areas, int flagMergeThr);

    /**
     * 
     * @param WalkableClimb 
     */
    public void filterLowHangingWalkableObstacles(int WalkableClimb) {
        rcFilterLowHangingWalkableObstacles(WalkableClimb);
    }

    private native void rcFilterLowHangingWalkableObstacles(int walkableClimb);

    /**
     * 
     * @param walkableHeight
     * @param walkableClimb 
     */
    public void filterLedgeSpans(int walkableHeight, int walkableClimb) {
        rcFilterLedgeSpans(walkableHeight, walkableClimb);
    }

    private native void rcFilterLedgeSpans(int walkableHeight, int walkableClimb);

    /**
     * 
     * @param walkableHeight 
     */
    public void filterWalkableLowHeightSpans(int walkableHeight) {
        rcFilterWalkableLowHeightSpans(walkableHeight);
    }

    private native void rcFilterWalkableLowHeightSpans(int walkableHeight);

    /**
     * 
     * @return 
     */
    public Heightfield getHeightfield() {
        return heightfield;
    }
}
