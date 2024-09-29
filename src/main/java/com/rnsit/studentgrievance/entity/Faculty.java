package com.rnsit.studentgrievance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rnsit.studentgrievance.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "email")
      @JsonIgnoreProperties("lightTheme")
      private User user;
}