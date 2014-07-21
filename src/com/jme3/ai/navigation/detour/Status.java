package com.jme3.ai.navigation.detour;

import com.jme3.ai.navigation.utils.RecastJNI;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
public class Status {

    private long status;

    public Status(long status) {
        this.status = status;
    }

    public boolean isSucceed() {
        return RecastJNI.dtStatusSucceed(status);
    }

    public boolean isFailed() {
        return RecastJNI.dtStatusFailed(status);
    }

    public boolean isInProgress() {
        return RecastJNI.dtStatusInProgress(status);
    }

    public boolean isDetail(long detail) {
        return RecastJNI.dtStatusDetail(status, detail);
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
