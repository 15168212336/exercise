package com.zg.handsome.exercise.scheduled.schedule;

public class MySchedule implements Runnable{
    private String param;

    public MySchedule(String param) {
        this.param = param;
    }

    @Override
    public void run() {
        System.out.println(param +":"+System.currentTimeMillis());
    }
}
