package com.rnsit.studentgrievance.controller;

import com.rnsit.studentgrievance.dto.user.ChangePasswordDto;
import com.rnsit.studentgrievance.dto.user.UserDetailsDto;
import com.rnsit.studentgrievance.entity.user.User;
import com.rnsit.studentgrievance.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
      @Autowired UserService userService;

      @GetMapping("/login/{username}")
      public ResponseEntity<UserDetailsDto> login(@PathVariable String username) {
            UserDetailsDto userDetails = userService.getUserDetails(username);
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
      }

      @PatchMapping("/change-password")
      public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordDto changePasswordDto) {
            try {
                  User user = userService.updatePassword(changePasswordDto);
                  return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                  return new ResponseEntity<>("Some error", HttpStatus.UNAUTHORIZED);
            }
      }

      @PatchMapping("/update-user/{username}")
      public ResponseEntity<String> updateDetails(@PathVariable String username, @Valid @RequestBody UserDetailsDto userDetailsDto) {
            try {
                  User user = userService.updateUser(username, userDetailsDto);
                  return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                  return new ResponseEntity<>("Some error", HttpStatus.UNAUTHORIZED);
            }
      }
}
