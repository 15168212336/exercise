package com.zg.handsome.exercise.scheduled.schedule;

import com.zg.handsome.exercise.scheduled.task.TimedOFFTask;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;

public class TimedOFFSchedule implements Runnable{
    private ScheduledFuture future;

    private static Integer count = 0;

    public TimedOFFSchedule(ScheduledFuture future) {
        this.future = future;
    }

    @Override
    public void run() {
        if (count < 10) {
            System.out.println(count.toString());
            count++;
        } else {
            TimedOFFTask timedOFFSchedule = new TimedOFFTask();
            timedOFFSchedule.endSchedule();
            System.out.println("Schedule closed");
        }
    }
}
