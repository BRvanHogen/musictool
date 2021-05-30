package com.backend.eindopdracht.musictool.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column
    private String name;
    @Column
    private String workingTitle;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Soundfile> soundfiles;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Comment> comments;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "project_user",
//    joinColumns = @JoinColumn(name = "user_username",
//    referencedColumnName = "username"),
//    inverseJoinColumns = @JoinColumn(name = "project_name",
//    referencedColumnName = "name"))
//    private List<User> users;

    private static final AtomicLong idCounter = new AtomicLong();

    public Project () {
        this.id = idCounter.incrementAndGet();
    }
        public Project (String name, String workingTitle, long id) {
            this.name = name;
            this.workingTitle = workingTitle;
            this.id = id;
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkingTitle() {
        return workingTitle;
    }

    public void setWorkingTitle(String workingTitle) {
        this.workingTitle = workingTitle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Soundfile> getSoundfiles() {
        return soundfiles;
    }

    public void setSoundfiles(Set<Soundfile> soundfiles) {
        this.soundfiles = soundfiles;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
}
