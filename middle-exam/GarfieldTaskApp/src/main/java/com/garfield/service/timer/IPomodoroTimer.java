//2353583 徐云鹏
package com.garfield.service.timer;

/**
 * 番茄钟计时器接口
 */
public interface IPomodoroTimer {

    /**
     * 启动番茄钟计时器
     * @param workSeconds 工作时长（秒）
     * @param breakSeconds 休息时长（秒）
     * @param cycles 循环次数
     */
    void startTimer(int workSeconds, int breakSeconds, int cycles);
}
