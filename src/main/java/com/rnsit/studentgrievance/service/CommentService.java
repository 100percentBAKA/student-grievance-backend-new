package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.entity.Comment;
import com.rnsit.studentgrievance.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
      @Autowired private CommentRepository commentRepository;

      @Transactional
      public void addComment(Comment comment) {
            commentRepository.save(comment);
      }

      public List<Comment> getComments(UUID uuid) {
            return commentRepository.findAllByGrievanceId(uuid);
      }
}
