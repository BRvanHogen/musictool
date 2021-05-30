package com.backend.eindopdracht.musictool.controller;


import com.backend.eindopdracht.musictool.model.Comment;
import com.backend.eindopdracht.musictool.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backend.eindopdracht.musictool.repository.CommentRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000/**")
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(value = "")
    public ResponseEntity<Object> getComments() {
        return ResponseEntity.ok().body(commentService.getComments());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getComment(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(commentService.getComment(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {
        Long newId = commentService.createComment(comment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}

