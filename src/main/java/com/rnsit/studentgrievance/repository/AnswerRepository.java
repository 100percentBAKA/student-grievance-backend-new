package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
/*
      @Query("SELECT a FROM Answer a WHERE a.grievance.id = :grievanceId")
      List<Answer> findAllByGrievanceId(UUID grievanceId);
 */
}