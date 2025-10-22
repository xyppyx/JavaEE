//2353583 徐云鹏
package com.garfield.repository.impl;

import com.garfield.common.enums.TaskStatus;
import com.garfield.common.exception.TaskException;
import com.garfield.model.Task;
import com.garfield.repository.GarfieldTaskRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于内存的任务仓库实现
 */
public class InMemoryGarfieldTaskRepository implements GarfieldTaskRepository {

    /**
     * 任务存储映射
     */
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * 保存任务
     * @param task 任务对象
     */
    @Override
    public void save(Task task) {

        tasks.put(task.getId(), task);
    }

    /**
     * 根据ID查找任务
     * @param id 任务ID
     * @return 任务对象
     * @throws TaskException 任务异常
     */
    @Override
    public Task findById(String id) throws TaskException {

        if(!tasks.containsKey(id)) {
            throw new TaskException.RecordNotFoundException();
        }

        return tasks.get(id);
    }

    /**
     * 查找所有任务
     * @return 任务列表
     */
    @Override
    public List<Task> findAll() {

        return new ArrayList<>(tasks.values());
    }

    /**
     * 根据ID删除任务
     * @param id 任务ID
     * @throws TaskException 任务异常
     */
    @Override
    public void deleteById(String id) throws TaskException {

        if(!tasks.containsKey(id)) {
            throw new TaskException.RecordNotFoundException();
        }

        tasks.remove(id);
    }

    /**
     * 根据状态查找任务
     * @param status 任务状态
     * @return 任务列表
     */
    @Override
    public List<Task> findByStatus(TaskStatus status) {

        List<Task> result = new ArrayList<>();
        for(Task task : tasks.values()) {
            if(task.getStatus() == status) {
                result.add(task);
            }
        }

        return result;
    }

    /**
     * 根据优先级查找任务
     * @param priority 任务优先级
     * @return 任务列表
     */
    @Override
    public List<Task> findByPriority(com.garfield.common.enums.TaskPriority priority) {

        List<Task> result = new ArrayList<>();
        for(Task task : tasks.values()) {
            if(task.getPriority() == priority) {
                result.add(task);
            }
        }

        return result;
    }

    /**
     * 更新任务
     * @param task 任务对象
     * @throws TaskException 任务异常
     */
    @Override
    public void update(Task task) throws TaskException {

        if(!tasks.containsKey(task.getId())) {
            throw new TaskException.RecordNotFoundException();
        }

        tasks.put(task.getId(), task);
    }
}
