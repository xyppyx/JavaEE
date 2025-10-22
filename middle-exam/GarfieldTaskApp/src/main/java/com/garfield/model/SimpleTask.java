//2353583 徐云鹏
package com.garfield.model;

import com.garfield.common.enums.TaskPriority;
import com.garfield.common.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 简单任务类，继承自抽象任务类
 */
public class SimpleTask extends Task {

    public SimpleTask(String title, TaskPriority priority) {
        this.id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.title = title;
        this.createAt = LocalDateTime.now();
        this.status = TaskStatus.OPEN;
        this.priority = priority;
    }

    /**
     * 描述任务
     * @return 任务描述字符串
     */
    @Override
    public String describe() {
        return String.format("Task ID: %s, Title: %s, Created At: %s, Status: %s, Priority: %s",
                id, title, createAt.toString(), status.name(), priority.name());
    }
}
