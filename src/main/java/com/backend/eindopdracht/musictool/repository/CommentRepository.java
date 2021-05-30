package com.backend.eindopdracht.musictool.repository;

import com.backend.eindopdracht.musictool.model.Comment;
import com.backend.eindopdracht.musictool.model.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentRepository extends JpaRepository <Comment, Long> {

    Project findById(String name);
    Collection<Comment> findByProject(Project project, Sort sort);
    Collection<Comment> findAllById(Long projects_id);

}
