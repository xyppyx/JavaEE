//2353583 徐云鹏
package com.garfield.service.exporter;

import com.garfield.model.Task;

import java.util.List;

/**
 * 任务导出器接口
 */
public interface ITaskExporter {

    /**
     * 导出任务列表到指定文件
     * @param tasks 当前任务列表
     * @param filename 导出文件名
     */
    void exportTasks(List<Task> tasks, String filename);
}
