package com.max.design.behavioral.state.impl;

import com.max.design.behavioral.state.ActivityService;
import com.max.design.behavioral.state.Result;
import com.max.design.behavioral.state.State;
import com.max.design.behavioral.state.Status;

/**
 * 活动状态；活动开启
 */
public class OpenState extends State {

    @Override public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可提审");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭完成");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动不可重复开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "活动变更活动中完成");
    }

}