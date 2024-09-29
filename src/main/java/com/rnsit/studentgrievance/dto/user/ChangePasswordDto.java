package com.rnsit.studentgrievance.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDto {
      @Email private String username;
      @NotEmpty private String oldPassword;
      @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).{8,16}$")
      private String newPassword;
}
