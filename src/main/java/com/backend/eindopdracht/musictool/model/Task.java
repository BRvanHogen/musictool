package com.backend.eindopdracht.musictool.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column
    private final Long id;
    @Column
    private String content;
    @Column
    private String byUser;
    @Column
    private final Instant timestamp;
    @Column
    private String parentProject;



    @ManyToOne
    @JoinColumn(name="projects_id")
    private Project project;

    private static final AtomicLong idCounter = new AtomicLong();

    public Task() {
        this.id = idCounter.incrementAndGet();
        this.timestamp = Instant.now();
    }




    public Task(Long id, Instant timestamp, String content, String byUser, String parentProject, Project project) {
        this.id = id;
        this.timestamp = timestamp;
        this.content = content;
        this.byUser = byUser;
        this.parentProject = parentProject;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public String getParentProject() {
        return parentProject;
    }

    public void setParentProject(String parentProject) {
        this.parentProject = parentProject;
    }

//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
}
