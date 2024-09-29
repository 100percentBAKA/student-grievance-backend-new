package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.entity.Faculty;
import com.rnsit.studentgrievance.repository.FacultyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
      @Autowired private FacultyRepository facultyRepository;

      @Transactional
      public void save(Faculty faculty) {
            facultyRepository.save(faculty);
      }

      public Faculty getFaculty(long id) {
            return facultyRepository.findById(id).orElse(null);
      }
}
