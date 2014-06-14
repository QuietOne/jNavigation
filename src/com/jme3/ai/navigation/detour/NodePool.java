package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

public class NodePool {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NodePool(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NodePool obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    @Override
    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                RecastJNI.delete_dtNodePool(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public NodePool(int maxNodes, int hashSize) {
        this(RecastJNI.new_dtNodePool(maxNodes, hashSize), true);
    }

    public void clear() {
        RecastJNI.dtNodePool_clear(swigCPtr, this);
    }

    public Node getNode(long id) {
        long cPtr = RecastJNI.dtNodePool_getNode(swigCPtr, this, id);
        return (cPtr == 0) ? null : new Node(cPtr, false);
    }

    public Node findNode(long id) {
        long cPtr = RecastJNI.dtNodePool_findNode(swigCPtr, this, id);
        return (cPtr == 0) ? null : new Node(cPtr, false);
    }

    public long getNodeIdx(Node node) {
        return RecastJNI.dtNodePool_getNodeIdx(swigCPtr, this, Node.getCPtr(node), node);
    }

    public Node getNodeAtIdx(long idx) {
        long cPtr = RecastJNI.dtNodePool_getNodeAtIdx__SWIG_0(swigCPtr, this, idx);
        return (cPtr == 0) ? null : new Node(cPtr, false);
    }

    public int getMemUsed() {
        return RecastJNI.dtNodePool_getMemUsed(swigCPtr, this);
    }

    public int getMaxNodes() {
        return RecastJNI.dtNodePool_getMaxNodes(swigCPtr, this);
    }

    public int getHashSize() {
        return RecastJNI.dtNodePool_getHashSize(swigCPtr, this);
    }

    public int getFirst(int bucket) {
        return RecastJNI.dtNodePool_getFirst(swigCPtr, this, bucket);
    }

    public int getNext(int i) {
        return RecastJNI.dtNodePool_getNext(swigCPtr, this, i);
    }
}
