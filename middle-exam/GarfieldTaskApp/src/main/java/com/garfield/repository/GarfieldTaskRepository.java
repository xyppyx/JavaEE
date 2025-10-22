//2353583 徐云鹏
package com.garfield.repository;

import com.garfield.common.enums.TaskPriority;
import com.garfield.common.enums.TaskStatus;
import com.garfield.common.exception.TaskException;
import com.garfield.model.Task;

import java.util.List;

/**
 * 任务仓库通用接口
 */
public interface GarfieldTaskRepository {

    /**
     * 保存任务
     * @param task 任务对象
     */
    void save(Task task);

    /**
     * 根据ID查找任务
     * @param id 任务ID
     * @return 任务对象
     * @throws TaskException 任务异常
     */
    Task findById(String id) throws TaskException;

    /**
     * 查找所有任务
     * @return 任务列表
     */
    List<Task> findAll();

    /**
     * 根据ID删除任务
     * @param id 任务ID
     * @throws TaskException 任务异常
     */
    void deleteById(String id) throws TaskException;

    /**
     * 根据状态查找任务
     * @param status 任务状态
     * @return 任务列表
     */
    List<Task> findByStatus(TaskStatus status);

    /**
     * 根据优先级查找任务
     * @param priority 任务优先级
     * @return 任务列表
     */
    List<Task> findByPriority(TaskPriority priority);

    /**
     * 更新任务
     * @param task 任务对象
     * @throws TaskException 任务异常
     */
    void update(Task task) throws TaskException;
}
