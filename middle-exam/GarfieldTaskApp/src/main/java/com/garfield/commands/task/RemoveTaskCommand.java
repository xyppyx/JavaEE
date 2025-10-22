//2353583 徐云鹏
package com.garfield.commands.task;

import com.garfield.repository.GarfieldTaskRepository;
import picocli.CommandLine;

@CommandLine.Command(
        name = "remove",
        description = "Commands for remove tasks."
)
public class RemoveTaskCommand implements Runnable {

    private final GarfieldTaskRepository repository;

    public RemoveTaskCommand(GarfieldTaskRepository repository) {
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
                repository.deleteById(id);
                System.out.println("Removed task with ID: " + id);
            } catch (Exception e) {
                System.out.println("Error updating task: " + e.getMessage());
            }
        }
    }
}
