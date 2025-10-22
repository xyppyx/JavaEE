//2353583 徐云鹏
package com.garfield.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garfield.common.enums.TaskPriority;
import com.garfield.common.enums.TaskStatus;

import java.time.LocalDateTime;

/**
 * 任务抽象类
 */
public abstract class Task {

    /**
     * 任务ID,使用32位UUID
     */
    String id;

    /**
     * 任务标题
     */
    String title;

    /**
     * 任务创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createAt;

    /**
     * 任务状态
     */
    TaskStatus status;

    /**
     * 任务优先级
     */
    TaskPriority priority;

    /**
     * 抽象方法：描述任务
     * @return 任务描述字符串
     */
    public abstract String describe();

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
}
