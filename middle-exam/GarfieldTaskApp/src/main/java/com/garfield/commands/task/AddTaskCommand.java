//2353583 徐云鹏
package com.garfield.commands.task;

import com.garfield.common.enums.TaskPriority;
import com.garfield.model.DeadlineTask;
import com.garfield.model.SimpleTask;
import com.garfield.model.Task;
import com.garfield.repository.GarfieldTaskRepository;
import picocli.CommandLine;

import java.time.LocalDateTime;

@CommandLine.Command(
        name = "add",
        description = "Commands for create tasks."
)
public class AddTaskCommand implements Runnable {

    private final GarfieldTaskRepository repository;

    public AddTaskCommand(GarfieldTaskRepository repository) {
        this.repository = repository;
    }

    @CommandLine.Option(names = {"-t", "--title"},
            description = "title for the task")
    private String title;

    @CommandLine.Option(names = {"-d", "--deadline"},
            description = "deadline for the task")
    private LocalDateTime deadline;

    @CommandLine.Option(names = {"-p", "--priority"},
            description = "priority for the task")
    private String priority;

    @Override
    public void run() {

        if(title == null) {
            System.out.println("Please provide a title for the task using -tit or --title");
            return;
        }

        Task task;
        if(deadline == null) {
            // 默认创建简单任务
            task = new SimpleTask(title, priority != null ? TaskPriority.valueOf(priority) : TaskPriority.MEDIUM);
            repository.save(task);
            System.out.println("Created SimpleTask:");

        } else {
            task = new DeadlineTask(title, deadline, priority != null ? TaskPriority.valueOf(priority) : TaskPriority.MEDIUM);
            repository.save(task);
            System.out.println("Created DeadlineTask:");

        }
        System.out.println(task.describe());
    }
}
