package com.rnsit.studentgrievance.dto.user;

import com.rnsit.studentgrievance.entity.user.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
      private String firstname;
      private String lastname;
      private Boolean lightTheme;
      private UserAuthority userAuthority;
}
