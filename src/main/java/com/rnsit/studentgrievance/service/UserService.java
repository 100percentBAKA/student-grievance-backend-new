package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.dto.authentication.AuthenticationDetails;
import com.rnsit.studentgrievance.dto.user.ChangePasswordDto;
import com.rnsit.studentgrievance.dto.user.UserDetailsDto;
import com.rnsit.studentgrievance.entity.user.User;
import com.rnsit.studentgrievance.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
      @Autowired UserRepository userRepository;

      public User getUser(String username) {
            return userRepository.findById(username).orElse(null);
      }

      public UserDetailsDto getUserDetails(String username) {
            return userRepository.getUserDetails(username);
      }

      @Transactional
      @Modifying
      public User updatePassword(ChangePasswordDto changePasswordDto) {
            User user = getUser(changePasswordDto.getUsername());

            if(user != null) {
                  if(user.getPassword().equals(changePasswordDto.getOldPassword())) {
                        user.setPassword(changePasswordDto.getNewPassword());
                        return userRepository.save(user);
                  }
            }
            return null;
      }

      @Transactional
      @Modifying
      public User updateUser(String username, UserDetailsDto userDetailsDto) {
            User user = getUser(username);

            if(user != null) {
                  if(userDetailsDto.getFirstname() != null) user.setFirstname(userDetailsDto.getFirstname());
                  if(userDetailsDto.getLastname() != null) user.setLastname(userDetailsDto.getLastname());
                  if(userDetailsDto.getLightTheme() != null) user.setLightTheme(userDetailsDto.getLightTheme());
                  return userRepository.save(user);
            }
            return null;
      }

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            AuthenticationDetails authenticationDetails = userRepository.getAuthenticationDetails(username);

            return new org.springframework.security.core.userdetails.User(
                    username,
                    authenticationDetails.getPassword(),
                    Collections.singleton(new SimpleGrantedAuthority(authenticationDetails.getUserAuthority().toString()))
            );
      }
}