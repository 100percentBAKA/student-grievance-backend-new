package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.dto.student.StudentGrievances;
import com.rnsit.studentgrievance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
      @Query("SELECT new com.rnsit.studentgrievance.dto.student.StudentGrievances(g.id, g.title, g.grievanceStatus, g.askedBy, g.asked, g.modified, g.timeTaken) FROM Grievance g WHERE g.student.usn = :usn")
      List<StudentGrievances> getGrievancesByUsn(String usn);
}