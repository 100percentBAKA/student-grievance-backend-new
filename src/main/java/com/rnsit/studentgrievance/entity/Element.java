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
public class Element {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      private int orderIndex;
      private String description;

      private String fileFormat;
      private String fileName;

      private String filePath;

      @ManyToOne
      @JsonIgnore
      private Grievance grievance;
}
