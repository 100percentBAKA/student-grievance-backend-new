package com.rnsit.studentgrievance.controller;

import com.rnsit.studentgrievance.entity.Comment;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {
      @Autowired private CommentService commentService;

      @PostMapping("/add-comment/{uuid}")
      public ResponseEntity<String> addComment(@RequestBody Comment comment, @PathVariable UUID uuid) {
            Grievance grievance = new Grievance();
            grievance.setId(uuid);
            comment.setGrievance(grievance);

            commentService.addComment(comment);
            return new ResponseEntity<>("Added", HttpStatus.OK);
      }
}
