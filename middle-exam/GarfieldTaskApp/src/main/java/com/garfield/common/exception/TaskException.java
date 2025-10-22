//2353583 徐云鹏
package com.garfield.common.exception;

/**
 * 任务相关异常类
 */
public class TaskException extends RuntimeException {

    public TaskException(String message) {
        super(message);
    }

    /**
     * 标题为空异常
     */
    public static class TitleEmptyException extends TaskException {

        public TitleEmptyException() {
            super("Task title cannot be empty.");
        }
    }

    /**
     * ID重复异常
     */
    public static class DuplicateIdException extends TaskException {

        public DuplicateIdException() {
            super("Task ID already exists.");
        }
    }

    /**
     * 记录缺失异常
     */
    public static class RecordNotFoundException extends TaskException {

        public RecordNotFoundException() {
            super("Task record not found.");
        }
    }
}
