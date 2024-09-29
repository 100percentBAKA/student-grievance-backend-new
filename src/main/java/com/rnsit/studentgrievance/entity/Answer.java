package com.rnsit.studentgrievance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      @CreationTimestamp
      private LocalDateTime answered;

      @UpdateTimestamp
      private LocalDateTime modified;

      @Column(nullable = false)
      private String answeredBy;

      @Column(nullable = false)
      private String grievanceTitle;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "faculty_id")
      @JsonIgnore
      private Faculty faculty;

      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "answer_id", referencedColumnName = "id")
      @OrderBy("orderIndex")
      private List<Element> elements;

      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "answer_id", referencedColumnName = "id")
      private List<Comment> comments;

      @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
      private Rating rating;
}