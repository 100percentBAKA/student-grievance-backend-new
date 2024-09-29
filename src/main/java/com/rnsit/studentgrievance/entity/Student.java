package com.rnsit.studentgrievance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractPersistableEntity<String> {
      @Id
      private String usn;

      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "email")
      private User user;

      @OneToMany(cascade = CascadeType.ALL)
      @JsonIgnoreProperties({"student", "elements", "comments"})
      private List<Grievance> grievances;

      @Override
      public String getId() {
            return usn;
      }
}