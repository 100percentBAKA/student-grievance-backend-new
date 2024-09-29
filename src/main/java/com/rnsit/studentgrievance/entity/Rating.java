package com.rnsit.studentgrievance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      @Column(nullable = false)
      private float rating;

      @Column(nullable = false)
      private String ratedTo;

      @Column(nullable = false)
      private String ratedBy;

      @ManyToOne(fetch = FetchType.LAZY)
      private Student student;

      @ManyToOne(fetch = FetchType.LAZY)
      private Faculty faculty;

      @OneToOne(fetch = FetchType.LAZY)
      private Answer answer;
}
