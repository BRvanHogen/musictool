package com.backend.eindopdracht.musictool.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private final Long id;
    @Column
    private String textareaInput;
    @Column
    private String byUser;
    @Column
    private final Instant timestamp;

    @ManyToOne
    @JoinColumn(name="projects_id")
    private Project project;

    private static final AtomicLong idCounter = new AtomicLong();

    public Comment() {
        this.id = idCounter.incrementAndGet();
        this.timestamp = Instant.now();
    }

    public Comment(Long id, Instant timestamp, String textareaInput, String byUser, Project project) {
        this.textareaInput = textareaInput;
        this.byUser = byUser;
        this.timestamp = timestamp;
        this.id = id;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public String getTextareaInput() {
        return textareaInput;
    }

    public void setTextareaInput(String textareaInput) {
        this.textareaInput = textareaInput;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}


