package com.jme3.ai.recast.builders;

import com.jme3.ai.recast.structures.CompactHeightfield;
import com.jme3.ai.recast.structures.Heightfield;
import com.jme3.ai.recast.structures.sub.HeightfieldLayerSet;

/**
 *
 * @author Tihomir Radosavljevic
 */
public class HeightfieldBuilder implements Builder {

    private Heightfield heightfield;

    @Override
    public void initializeStructure() {
        heightfield = new Heightfield();
        rcCreateHeightfield(heightfield, 0, 0, null, null, 0, 0);
    }

    @Override
    public void build() {
        //TODO: fix structure building sequence
    }

    public void calculateBounds(){
        rcCalcBounds(null, 0, null, null);
    }
    private native void rcCalcBounds(float[] verts, int nv, float[] bmin, float[] bmax);

    private native void rcCalcGridSize(float[] bmin, float[] bmax, float cs, int w, int h);

    private native boolean rcCreateHeightfield(Heightfield hf, int width, int height, float[] bmin, float[] bmax, float cs, float ch);

    private native void rcMarkWalkableTriangles(float walkableSlopeAngle, float[] verts, int nv, int[] tris, int nt, String areas);

    private native int rcGetHeightFieldSpanCount(Heightfield hf);

    private native void rcClearUnwalkableTriangles(float walkableSlopeAngle, float[] verts, int nv, int[] tris, int nt, String areas);

    private native void rcAddSpan(Heightfield hf, int x, int y, short smin, short smax, char area, int flagMergeThr);

    private native void rcRasterizeTriangle(float[] v0, float[] v1, float[] v2, char area, Heightfield solid, int flagMergeThr);

    private native void rcRasterizeTriangles(float[] verts, int nv, int[] tris, String areas, int nt, Heightfield solid, int flagMergeThr);

    private native void rcRasterizeTriangles(float[] verts, int nv, short[] tris, String areas, int nt, Heightfield solid, int flagMergeThr);

    private native void rcRasterizeTriangles(float[] verts, String areas, int nt, Heightfield solid, int flagMergeThr);

    private native void rcFilterLowHangingWalkableObstacles(int walkableClimb, Heightfield solid);

    private native void rcFilterLedgeSpans(int walkableHeight, int walkableClimb, Heightfield solid);

    private native void rcFilterWalkableLowHeightSpans(int walkableHeight, Heightfield solid);

    private native boolean rcBuildHeightfieldLayers(CompactHeightfield chf, int borderSize, int walkableHeight, HeightfieldLayerSet lset);

    public Heightfield getHeightfield() {
        return heightfield;
    }
}
