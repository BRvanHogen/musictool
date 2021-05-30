package com.backend.eindopdracht.musictool.service;

import com.backend.eindopdracht.musictool.exceptions.RecordNotFoundException;
import com.backend.eindopdracht.musictool.repository.ProjectRepository;
import com.backend.eindopdracht.musictool.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Collection<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public String createProject(Project project) {
        Project newProject = projectRepository.save(project);
        return newProject.getName();
    }

    @Override
    public void deleteProject(String name) {
        projectRepository.deleteById(name);
    }

    @Override
    public Optional<Project> getProject(String name) {
        return projectRepository.findById(name);
    }

    @Override
    public void updateProject(String name, Project newProject) {
        if (!projectRepository.existsById(name)) throw new RecordNotFoundException();
        Project project = projectRepository.findById(name).get();
        project.setName(newProject.getName());
        project.setWorkingTitle(newProject.getWorkingTitle());
        project.setId(newProject.getId());
        projectRepository.save(project);
    }
}
