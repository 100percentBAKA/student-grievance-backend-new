package com.rnsit.studentgrievance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractPersistableEntity<String> {
      @Id
      private String category;
      private String description;

      @Override
      @JsonIgnore
      public String getId() {
            return category;
      }
}