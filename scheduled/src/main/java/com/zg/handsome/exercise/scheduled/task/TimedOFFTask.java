package com.zg.handsome.exercise.scheduled.task;

import com.zg.handsome.exercise.scheduled.schedule.MySchedule;
import com.zg.handsome.exercise.scheduled.schedule.TimedOFFSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
@EnableScheduling
@RequestMapping("TimedOff/")
public class TimedOFFTask implements TaskBase{

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture future;

    @GetMapping("startTask")
    @Override
    public String startSchedule(@RequestParam("timing") String timing) {
        future = threadPoolTaskScheduler.schedule(new TimedOFFSchedule(future), new CronTrigger(timing));
        System.out.println("Task start");
        return "Task start";
    }

    @GetMapping("endTask")
    @Override
    public String endSchedule() {
        if (future != null) {
            future.cancel(true);
        }
        System.out.println("Task end");
        return "Task end";
    }

    @GetMapping("changeTask")
    @Override
    public String changeSchedule(@RequestParam("timing") String timing) {
        endSchedule();
        startSchedule(timing);
        System.out.println("Task Changed");
        return "Task Changed ";
    }

}
