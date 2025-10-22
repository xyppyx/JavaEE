//2353583 徐云鹏
package com.garfield.commands.exporter;

import com.garfield.model.Task;
import com.garfield.repository.GarfieldTaskRepository;
import com.garfield.service.exporter.ITaskExporter;
import picocli.CommandLine;

import java.util.List;

/**
 * 任务导出命令
 */
@CommandLine.Command(
        name = "export",
        description = "Commands for export tasks to json file."
)
public class ExportCommand implements Runnable {

    private final GarfieldTaskRepository repository;
    private final ITaskExporter exporter;

    public ExportCommand(GarfieldTaskRepository repository, ITaskExporter exporter) {
        this.repository = repository;
        this.exporter = exporter;
    }

    @CommandLine.Option(names = {"-f", "--file"},
            description = "file path for the exported json file")
    private String file;

    @Override
    public void run() {
        if(file == null) {
            System.out.println("Please provide a file path for the exported json file using -f or --file");
            return;
        }

        try {
            List<Task> tasks = repository.findAll();
            exporter.exportTasks(tasks, file);
            System.out.println("Exported tasks to " + file);
        } catch (Exception e) {
            System.out.println("Error exporting tasks: " + e.getMessage());
        }
    }

}
