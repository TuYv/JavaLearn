package com.max.design.behavioral.state;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rick
 * @date 2022-01-21 14:43
 */
public class ActivityService {
    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<String, Enum<Status>>();

    public static void init(String activityId, Enum<Status> status) {
        ActivityInfo info = new ActivityInfo();
        info.setActivityId(activityId);
        info.setActivityName("早起打卡学习领奖活动");
        info.setStatus(status);
        info.setBeginTime(new Date());
        info.setEndTime(new Date());

        statusMap.put(activityId, status);
    }

    public static ActivityInfo queryActivityInfo(String activityId) {

        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }

    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) {return;}
        statusMap.put(activityId, afterStatus);
    }
}
