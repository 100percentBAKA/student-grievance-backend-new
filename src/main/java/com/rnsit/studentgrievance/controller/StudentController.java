package com.rnsit.studentgrievance.controller;

import com.rnsit.studentgrievance.dto.student.StudentGrievances;
import com.rnsit.studentgrievance.entity.Student;
import com.rnsit.studentgrievance.entity.user.User;
import com.rnsit.studentgrievance.entity.user.UserAuthority;
import com.rnsit.studentgrievance.repository.StudentRepository;
import com.rnsit.studentgrievance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
      @Autowired private StudentService studentService;
      @Autowired private StudentRepository studentRepository;
      @Autowired private PasswordEncoder passwordEncoder;

      @PostMapping
      public ResponseEntity<String> createStudent(@RequestBody Student student) {
            User user = student.getUser();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setLightTheme(true);
            user.setUserAuthority(UserAuthority.STUDENT);
            student.setUser(user);

            studentService.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/{usn}/grievances")
      public List<StudentGrievances> getGrievancesByUsn(@PathVariable String usn) {
            return studentService.getStudentGrievances(usn);
      }
}