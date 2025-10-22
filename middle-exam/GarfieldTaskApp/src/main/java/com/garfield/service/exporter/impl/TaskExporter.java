//2353583 徐云鹏
package com.garfield.service.exporter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garfield.model.Task;
import com.garfield.service.exporter.ITaskExporter;

import java.io.File;
import java.util.List;

/**
 * 任务导出器实现类
 */
public class TaskExporter implements ITaskExporter {

    /**
     * 导出任务列表到指定文件
     * @param tasks 当前任务列表
     * @param filename 导出文件名
     */
    @Override
    public void exportTasks(List<Task> tasks, String filename) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

        try {
            mapper.writeValue(new File(filename), tasks);
        } catch (Exception e) {
            throw new RuntimeException("Failed to export tasks to " + filename, e);
        }
    }
}
