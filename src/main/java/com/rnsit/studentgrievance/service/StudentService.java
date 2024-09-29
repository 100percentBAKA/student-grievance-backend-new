package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.dto.student.StudentGrievances;
import com.rnsit.studentgrievance.entity.Student;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
      @Autowired private StudentRepository studentRepository;

      public void save(Student student) {
            studentRepository.save(student);
      }

      public List<StudentGrievances> getStudentGrievances(String usn) {
            return studentRepository.getGrievancesByUsn(usn);
      }
}
