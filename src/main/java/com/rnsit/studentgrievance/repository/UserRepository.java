package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.dto.authentication.AuthenticationDetails;
import com.rnsit.studentgrievance.dto.user.UserDetailsDto;
import com.rnsit.studentgrievance.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String > {
      @Query("SELECT new com.rnsit.studentgrievance.dto.user.UserDetailsDto(u.firstname, u.lastname, u.lightTheme, u.userAuthority) FROM User u WHERE u.username = :username")
      UserDetailsDto getUserDetails(String username);

      @Query("SELECT new com.rnsit.studentgrievance.dto.authentication.AuthenticationDetails(u.password, u.userAuthority) FROM User u WHERE u.username = :username")
      AuthenticationDetails getAuthenticationDetails(String username);
}