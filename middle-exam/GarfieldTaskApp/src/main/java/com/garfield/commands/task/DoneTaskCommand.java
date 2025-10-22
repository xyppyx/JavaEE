//2353583 徐云鹏
package com.garfield.commands.task;

import com.garfield.common.enums.TaskStatus;
import com.garfield.model.Task;
import com.garfield.repository.GarfieldTaskRepository;
import picocli.CommandLine;

@CommandLine.Command(
        name = "done",
        description = "Commands for done tasks."
)
public class DoneTaskCommand implements Runnable {

    private final GarfieldTaskRepository repository;

    public DoneTaskCommand(GarfieldTaskRepository repository) {
        this.repository = repository;
    }

    @CommandLine.Option(names = {"--id"},
            description = "id for the task")
    private String id;

    @Override
    public void run() {

        if(id == null){
            System.out.println("Please provide the task ID to update using --id");
            return;
        } else {
            try {
                Task task = repository.findById(id);
                task.setStatus(TaskStatus.DONE);
                repository.update(task);
                System.out.println("Done task:");
                System.out.println(task.describe());
            } catch (Exception e) {
                System.out.println("Error updating task: " + e.getMessage());
            }
        }
    }
}
