package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.Heightfield;
import com.jme3.math.Vector3f;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class HeightfieldBuilder extends Builder {

    private Heightfield heightfield;

    @Override
    public void initializeStructure() {
        heightfield = new Heightfield();
    }

    /**
     * Structure must be initialized first by function initalizeStructure(). If
     * not there will be NullPointerException
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

    public void calculateBounds(Vector3f[] vertices) {
        rcCalcBounds(convertToFloatArray(vertices));
    }

    private native void rcCalcBounds(float[] verts);

    public void calculateGridSize() {
        rcCalcGridSize();
    }

    private native void rcCalcGridSize();

    public void markWalkableTriangles(float walkableSlopeAngle, Vector3f[] vertices, int[] indexes, char[] areas) {
        rcMarkWalkableTriangles(walkableSlopeAngle, convertToFloatArray(vertices), indexes, areas);
    }

    private native void rcMarkWalkableTriangles(float walkableSlopeAngle, float[] verts, int[] tris, char[] areas);

    public int getSpanCount() {
        return -1;
    }

    private native int rcGetHeightFieldSpanCount(Heightfield hf);

    public void clearUnwalkableTriangles(float walkableSlopeAngle, Vector3f[] vertices, int[] indexes, char[] areas) {
        rcClearUnwalkableTriangles(walkableSlopeAngle, convertToFloatArray(vertices), indexes, areas);
    }

    private native void rcClearUnwalkableTriangles(float walkableSlopeAngle, float[] verts, int[] tris, char[] areas);

    public void addSpan(int x, int y, short minHeight, short maxHeight, char area, int flagMerge) {
        rcAddSpan(x, y, minHeight, maxHeight, area, flagMerge);
    }

    private native void rcAddSpan(int x, int y, short smin, short smax, char area, int flagMergeThr);

    public void rasterizeTriangle(Vector3f v0, Vector3f v1, Vector3f v2, char area, int flagMerge) {
        rcRasterizeTriangle(convertToFloatArray(v0), convertToFloatArray(v1), convertToFloatArray(v2), area, flagMerge);
    }

    private native void rcRasterizeTriangle(float[] v0, float[] v1, float[] v2, char area, int flagMergeThr);

    public void rasterizeTriangles(Vector3f[] vertices, int[] indexes, char[] areas, int flagMerge) {
        rcRasterizeTriangles(convertToFloatArray(vertices), indexes, areas, flagMerge);
    }

    private native void rcRasterizeTriangles(float[] verts, int[] tris, char[] areas, int flagMergeThr);

    public void rasterizeTriangles(Vector3f[] vertices, short[] indexes, char[] areas, int flagMerge) {
        rcRasterizeTriangles(convertToFloatArray(vertices), indexes, areas, flagMerge);
    }

    private native void rcRasterizeTriangles(float[] verts, short[] tris, char[] areas, int flagMergeThr);

    public void rasterizeTriangles(Vector3f[] vertices, char[] areas, int flagMerge) {
        rcRasterizeTriangles(convertToFloatArray(vertices), areas, flagMerge);
    }

    private native void rcRasterizeTriangles(float[] verts, char[] areas, int flagMergeThr);

    public void filterLowHangingWalkableObstacles(int WalkableClimb) {
        rcFilterLowHangingWalkableObstacles(WalkableClimb);
    }

    private native void rcFilterLowHangingWalkableObstacles(int walkableClimb);

    public void filterLedgeSpans(int walkableHeight, int walkableClimb) {
        rcFilterLedgeSpans(walkableHeight, walkableClimb);
    }

    private native void rcFilterLedgeSpans(int walkableHeight, int walkableClimb);

    public void filterWalkableLowHeightSpans(int walkableHeight) {
        rcFilterWalkableLowHeightSpans(walkableHeight);
    }

    private native void rcFilterWalkableLowHeightSpans(int walkableHeight);

    public Heightfield getHeightfield() {
        return heightfield;
    }
}
