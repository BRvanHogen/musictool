package com.backend.eindopdracht.musictool.controller;

import com.backend.eindopdracht.musictool.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.eindopdracht.musictool.service.ProjectService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000/**")
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getProjects() {
        return ResponseEntity.ok().body(projectService.getProjects());
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Object> getProject(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(projectService.getProject(name));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createProject(@RequestBody Project project) {
        String newName = projectService.createProject(project);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
                .buildAndExpand(newName).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{name}")
    public ResponseEntity<Object> updateProject(@PathVariable("name") String name, @RequestBody Project project) {
        projectService.updateProject(name, project);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping (value = "/{name}")
    public ResponseEntity<Object> deleteProject(@PathVariable("name") String name) {
        projectService.deleteProject(name);
        return ResponseEntity.noContent().build();
    }
}

