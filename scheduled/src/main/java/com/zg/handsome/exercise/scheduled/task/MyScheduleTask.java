package com.zg.handsome.exercise.scheduled.task;


import com.zg.handsome.exercise.scheduled.schedule.MySchedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@EnableScheduling
@RestController
@RequestMapping("MySchedule")
public class MyScheduleTask implements TaskBase{

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture future;

    /**
     * 启动定时器  "0/5 * * * * *" 5次/s
     */
    @GetMapping("startTask/")
    @Override
    public String startSchedule(@RequestParam("timing") String timing) {
        future = threadPoolTaskScheduler.schedule(new MySchedule("test"), new CronTrigger(timing));
        System.out.println("Task start");
        return "Task start";
    }

    /**
     * 结束定时器
     * @return
     */
    @GetMapping("endTask")
    @Override
    public String endSchedule() {
        if (future != null) {
            future.cancel(true);
        }
        System.out.println("Task end");
        return "Task end";
    }

    /**
     * 改变定时器时间
     * @param timing
     * @return
     */
    @GetMapping("changeTask")
    @Override
    public String changeSchedule(@RequestParam("timing") String timing) {
        endSchedule();
        startSchedule(timing);
        System.out.println("Task Changed");
        return "Task Changed ";
    }

}
