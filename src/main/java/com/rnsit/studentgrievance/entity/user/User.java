package com.rnsit.studentgrievance.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
      @Id
      @Column(nullable = false)
      private String username;

      @Column(nullable = false)
      private String password;

      @Column(nullable = false)
      private String firstname;
      private String lastname;
      private boolean lightTheme;

      @Enumerated(EnumType.STRING)
      private UserAuthority userAuthority;

      @Override
      @JsonIgnore
      public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority(userAuthority.toString()));
      }

      @Override
      @JsonIgnore
      public boolean isAccountNonExpired() {
            return true;
      }

      @Override
      @JsonIgnore
      public boolean isAccountNonLocked() {
            return true;
      }

      @Override
      @JsonIgnore
      public boolean isCredentialsNonExpired() {
            return true;
      }

      @Override
      @JsonIgnore
      public boolean isEnabled() {
            return true;
      }
}
