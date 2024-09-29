package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long> {
      @Query("SELECT c FROM Comment c WHERE c.grievance.id = :grievanceId")
      List<Comment> findAllByGrievanceId(UUID grievanceId);
}
