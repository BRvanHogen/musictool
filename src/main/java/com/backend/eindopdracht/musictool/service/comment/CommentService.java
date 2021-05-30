package com.backend.eindopdracht.musictool.service.comment;

import com.backend.eindopdracht.musictool.model.Comment;

import java.util.Collection;
import java.util.Optional;

public interface CommentService {

    public abstract Collection<Comment> getComments();
    public abstract Optional<Comment> getComment(Long id);
    public abstract Collection<Comment> getCommentsByProject(Long projects_id);
    public abstract Long createComment(Comment comment);
    public abstract void deleteComment(Long id);
}
