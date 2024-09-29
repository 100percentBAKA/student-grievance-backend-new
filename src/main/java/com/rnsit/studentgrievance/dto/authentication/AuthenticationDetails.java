package com.rnsit.studentgrievance.dto.authentication;

import com.rnsit.studentgrievance.entity.user.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDetails {
      private String password;
      private UserAuthority userAuthority;
}
