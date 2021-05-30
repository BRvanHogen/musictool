package com.backend.eindopdracht.musictool.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "soundfiles")
public class Soundfile {

    @Id
    @Column
    private final Long id;
    @Column
    private String byUser;
    @Column
    private String description;
    @Column
    private final Instant timestamp;

    @ManyToOne
    @JoinColumn(name="projects_id")
    private Project project;


    private static final AtomicLong idCounter = new AtomicLong();

    public Soundfile() {
        this.id = idCounter.incrementAndGet();
        this.timestamp = Instant.now();
    }

    public Soundfile(Long id, String byUser, String description, Instant timestamp) {
        this.id = id;
        this.byUser = byUser;
        this.description = description;
        this.timestamp = timestamp;
    }

    //GETTERS ONLY
    public Long getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    //BOTH GETTERS AND SETTERS
    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
