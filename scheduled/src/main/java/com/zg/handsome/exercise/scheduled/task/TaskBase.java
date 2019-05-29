package com.zg.handsome.exercise.scheduled.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public interface TaskBase {
    String startSchedule(String timing);

    String endSchedule();

    String changeSchedule(String timing);
}
