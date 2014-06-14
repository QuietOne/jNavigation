package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 0.5
 */
public class NodeQueue {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    public NodeQueue(int n) {
        this(RecastJNI.new_dtNodeQueue(n), true);
    }

    public NodeQueue(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    public static long getCPtr(NodeQueue obj) {
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
                RecastJNI.delete_dtNodeQueue(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public void clear() {
        RecastJNI.dtNodeQueue_clear(swigCPtr, this);
    }

    public Node top() {
        long cPtr = RecastJNI.dtNodeQueue_top(swigCPtr, this);
        return (cPtr == 0) ? null : new Node(cPtr, false);
    }

    public Node pop() {
        long cPtr = RecastJNI.dtNodeQueue_pop(swigCPtr, this);
        return (cPtr == 0) ? null : new Node(cPtr, false);
    }

    public void push(Node node) {
        RecastJNI.dtNodeQueue_push(swigCPtr, this, Node.getCPtr(node), node);
    }

    public void modify(Node node) {
        RecastJNI.dtNodeQueue_modify(swigCPtr, this, Node.getCPtr(node), node);
    }

    public boolean empty() {
        return RecastJNI.dtNodeQueue_empty(swigCPtr, this);
    }

    public int getMemoryUsed() {
        return RecastJNI.dtNodeQueue_getMemUsed(swigCPtr, this);
    }

    public int getCapacity() {
        return RecastJNI.dtNodeQueue_getCapacity(swigCPtr, this);
    }
}
