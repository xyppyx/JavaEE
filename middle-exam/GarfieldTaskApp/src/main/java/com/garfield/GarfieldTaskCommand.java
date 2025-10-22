//2353583 徐云鹏
package com.garfield;

import com.garfield.repository.GarfieldTaskRepository;
import com.garfield.repository.impl.InMemoryGarfieldTaskRepository;
import com.garfield.service.exporter.ITaskExporter;
import com.garfield.service.exporter.impl.TaskExporter;
import com.garfield.service.timer.IPomodoroTimer;
import com.garfield.service.timer.impl.PomodoroTimer;
import picocli.CommandLine.Command;

// This is the main command. Students will add subcommands to it.
@Command(
    name = "GarfieldTask",
    version = "GarfieldTask 1.0",
    mixinStandardHelpOptions = true, // Adds --help and --version options
    description = "A command-line tool to help Garfield manage his tasks."
)
public class GarfieldTaskCommand {
    // This class acts as a container for all other commands.
    // Students will need to pass the repository and other services
    // into the constructors of their real command classes.
    private final GarfieldTaskRepository repository = new InMemoryGarfieldTaskRepository();
    private final IPomodoroTimer timer = new PomodoroTimer();
    private final ITaskExporter exporter = new TaskExporter();

    public IPomodoroTimer getTimer() {
        return timer;
    }

    public ITaskExporter getExporter() {
        return exporter;
    }

    public GarfieldTaskRepository getRepository() {
        return repository;
    }
}
