//2353583 徐云鹏
package com.garfield.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garfield.common.enums.TaskPriority;
import com.garfield.common.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 截止任务类，继承自抽象任务类
 */
public class DeadlineTask extends Task {

    /**
     * 任务截止时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

    public DeadlineTask(String title, LocalDateTime deadline, TaskPriority priority) {

        this.id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        this.title = title;
        this.createAt = LocalDateTime.now();
        this.status = TaskStatus.OPEN;
        this.priority = priority;
        this.deadline = deadline;
    }

    /**
     * 描述任务
     * @return 任务描述字符串
     */
    @Override
    public String describe() {

        return String.format("Task ID: %s, Title: %s, Created At: %s, Status: %s, Priority: %s, Deadline: %s",
                id, title, createAt.toString(), status.name(), priority.name(), deadline.toString());
    }

    /**
     * 检查任务是否已过期
     * @return 如果当前时间在截止时间之后则返回true，否则返回false
     */
    public boolean isOverdue() {

        return LocalDateTime.now().isAfter(deadline);
    }

    /**
     * 获取任务剩余时间
     * @return 剩余时间的字符串表示
     */
    public String getTimeRemaining() {

        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(deadline)) {
            return "Overdue";
        }

        long days = java.time.Duration.between(now, deadline).toDays();
        long hours = java.time.Duration.between(now, deadline).toHours() % 24;
        long minutes = java.time.Duration.between(now, deadline).toMinutes() % 60;
        return String.format("%d days, %d hours, %d minutes remaining", days, hours, minutes);
    }

    //getter and setter
    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}