package com.backend.eindopdracht.musictool.service.task;

import com.backend.eindopdracht.musictool.model.Task;

import java.util.Collection;

public interface TaskService {
    public abstract Long createTask(Task task);
    public abstract Collection<Task> getTasks();
    public abstract void deleteTask(Long id);
}
