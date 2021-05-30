package com.backend.eindopdracht.musictool.service.comment;

import com.backend.eindopdracht.musictool.model.Comment;
import com.backend.eindopdracht.musictool.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

   @Autowired
   private CommentRepository commentRepository;

    @Override
    public Collection<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getComment(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Collection<Comment> getCommentsByProject(Long projects_id) {
        return commentRepository.findAllById(projects_id);
    }

    @Override
    public Long createComment(Comment comment) {
        Comment newComment = commentRepository.save(comment);
        return newComment.getId();
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
