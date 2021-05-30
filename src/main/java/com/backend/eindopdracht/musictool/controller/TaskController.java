package com.backend.eindopdracht.musictool.controller;


import com.backend.eindopdracht.musictool.model.Task;
import com.backend.eindopdracht.musictool.repository.TaskRepository;
import com.backend.eindopdracht.musictool.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000/**")
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    //als dit werkt, zou het mooi zijn. Project id wordt
    //in FE uit de context gehaald en automatisch in
    //de string template van het get-request geplakt
    @GetMapping(value = "/{project_id}/all-tasks")
    public ResponseEntity<Object> getTasks() {
        return ResponseEntity.ok().body(taskService.getTasks());
    }

    @PostMapping(value = "/{project_id}/all-tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        Long newId = taskService.createTask(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newId).toUri();

            return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{project_id}/all-tasks/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
