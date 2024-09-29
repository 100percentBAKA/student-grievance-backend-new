package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.dto.grievance.PartialGrievance;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GrievanceRepository extends JpaRepository<Grievance, UUID> {
      @Query("SELECT new com.rnsit.studentgrievance.dto.grievance.PartialGrievance(g.id, g.title, g.grievanceStatus, g.askedBy, g.asked, g.modified, g.timeTaken) FROM Grievance g")
      Page<PartialGrievance> findGrievances(Pageable pageable);

      @Query("SELECT new com.rnsit.studentgrievance.dto.grievance.PartialGrievance(g.id, g.title, g.grievanceStatus, g.askedBy, g.asked, g.modified, g.timeTaken) FROM Grievance g where g.student.usn = :usn")
      Page<PartialGrievance> findGrievancesByStudent(String usn, Pageable pageable);
}