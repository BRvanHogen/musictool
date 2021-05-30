package com.backend.eindopdracht.musictool.service;

import com.backend.eindopdracht.musictool.model.Project;

import java.util.Collection;
import java.util.Optional;

public interface ProjectService {

    public abstract Collection<Project> getProjects();

    public abstract String createProject(Project project);

    public abstract void deleteProject(String name);

    public abstract Optional<Project> getProject(String name);

    public abstract void updateProject(String name, Project project);
}
