//2353583 徐云鹏
package com.garfield.commands.task;

import com.garfield.common.enums.TaskPriority;
import com.garfield.common.enums.TaskStatus;
import com.garfield.model.Task;
import com.garfield.repository.GarfieldTaskRepository;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(
        name = "list",
        description = "Commands for read tasks."
)
public class ListTaskCommand implements Runnable {

    private final GarfieldTaskRepository repository;

    public ListTaskCommand(GarfieldTaskRepository repository) {
        this.repository = repository;
    }

    @CommandLine.Option(names = {"-sta", "--status"},
            description = "status for the task")
    private String status;

    @CommandLine.Option(names = {"-p", "--priority"},
            description = "priority for the task")
    private String priority;

    @Override
    public void run() {

        if(priority == null && status == null) {
            List<Task> tasks = repository.findAll();
            for(Task task : tasks) {
                String description = task.describe();
                System.out.println(description);
            }

        }else if(priority != null) {
            List<Task> tasks = repository.findByPriority(TaskPriority.valueOf(priority));
            for(Task task : tasks) {
                String description = task.describe();
                System.out.println(description);
            }

        }else if(status != null) {
            List<Task> tasks = repository.findByStatus(TaskStatus.valueOf(status));
            for(Task task : tasks) {
                String description = task.describe();
                System.out.println(description);
            }

        }
    }
}