//2353583 徐云鹏
package com.garfield.commands.timer;

import com.garfield.service.timer.IPomodoroTimer;
import picocli.CommandLine;

@CommandLine.Command(
        name = "timer",
        description = "Commands for timer."
)
public class TimeCommand implements Runnable {

    private final IPomodoroTimer timer;

    public TimeCommand(IPomodoroTimer timer) {
        this.timer = timer;
    }

    @CommandLine.Option(names = {"-w", "--work"},
            description = "work time in seconds")
    private Integer workTime;

    @CommandLine.Option(names = {"-b", "--break"},
            description = "break time in seconds")
    private Integer breakTime;

    @CommandLine.Option(names = {"-c", "--cycles"},
            description = "cycles")
    private Integer cycles;

    @Override
    public void run() {

        if(workTime == null || breakTime == null || cycles == null) {
            System.out.println("Please provide work time, break time and cycles using -w/--work, -b/--break and -c/--cycles");
            return;
        }

        timer.startTimer(workTime, breakTime, cycles);
    }

}