package com.rnsit.studentgrievance.controller;

import com.rnsit.studentgrievance.entity.Faculty;
import com.rnsit.studentgrievance.entity.user.User;
import com.rnsit.studentgrievance.entity.user.UserAuthority;
import com.rnsit.studentgrievance.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
      @Autowired private FacultyService facultyService;
      @Autowired private PasswordEncoder passwordEncoder;

      @PostMapping
      public ResponseEntity<String> createFaculty(@RequestBody Faculty faculty) {
            User user = faculty.getUser();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setUserAuthority(UserAuthority.FACULTY);
            user.setLightTheme(true);
            faculty.setUser(user);

            facultyService.save(faculty);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/{id}")
      public ResponseEntity<Faculty> getFaculty(@PathVariable long id) {
            return new ResponseEntity<>(facultyService.getFaculty(id), HttpStatus.OK);
      }
}
