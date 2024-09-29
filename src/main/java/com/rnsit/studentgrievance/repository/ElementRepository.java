package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ElementRepository extends JpaRepository<Element, Long> {
      @Query("SELECT e FROM Element e WHERE e.grievance.id = :grievanceId")
      List<Element> findAllByGrievanceId(UUID grievanceId);
}
