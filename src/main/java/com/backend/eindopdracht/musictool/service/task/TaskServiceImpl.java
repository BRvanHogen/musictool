package com.backend.eindopdracht.musictool.service.task;


import com.backend.eindopdracht.musictool.model.Task;
import com.backend.eindopdracht.musictool.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Long createTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @Override
    public Collection<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
