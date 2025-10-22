//2353583 徐云鹏
package com.garfield.service.timer.impl;

import com.garfield.service.timer.IPomodoroTimer;

/**
 * 番茄钟计时器实现类
 */
public class PomodoroTimer implements IPomodoroTimer {

    /**
     * 启动番茄钟计时器
     * @param workSeconds 工作时长（秒）
     * @param breakSeconds 休息时长（秒）
     * @param cycles 循环次数
     */
    @Override
    public void startTimer(int workSeconds, int breakSeconds, int cycles) {

        Thread timerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= cycles; i++) {
                    System.out.println("Cycle " + i + ": Work for " + workSeconds + " seconds.");
                    Thread.sleep(workSeconds * 1000L);
                    System.out.println("Cycle " + i + ": Break for " + breakSeconds + " seconds.");
                    if (i < cycles) {
                        Thread.sleep(breakSeconds * 1000L);
                    }
                }
                System.out.println("Pomodoro session completed!");
            } catch (InterruptedException e) {
                System.out.println("Pomodoro timer interrupted.");
            }
        });
        timerThread.start();
    }
}
