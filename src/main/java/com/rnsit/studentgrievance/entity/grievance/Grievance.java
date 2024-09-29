package com.rnsit.studentgrievance.entity.grievance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rnsit.studentgrievance.entity.*;
import com.rnsit.studentgrievance.entity.Comment;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grievance {
      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      @Column(columnDefinition = "CHAR(36)")
      @JdbcTypeCode(SqlTypes.VARCHAR)
      @JsonIgnore
      private UUID id;

      @Column(nullable = false)
      private String title;

      @Enumerated(EnumType.STRING)
      private GrievanceStatus grievanceStatus;

      @Column(nullable = false)
      private String askedBy;

      @CreationTimestamp
      private LocalDateTime asked;

      @UpdateTimestamp
      private LocalDateTime modified;

      @Formula("CASE WHEN status = 'RESOLVED' THEN TIMESTAMPDIFF(SECOND, asked, modified) ELSE NULL END")
      @Column
      private long timeTaken;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "student_usn")
      private Student student;

      @ManyToMany
      @JoinTable(
              name = "grievance_category",
              joinColumns = @JoinColumn(name = "grievance_id", referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "category_name", referencedColumnName = "category"))
      private List<Category> categories;

      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "grievance_id", referencedColumnName = "id")
      @OrderBy("orderIndex")
      private List<Element> elements;

      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "grievance_id", referencedColumnName = "id")
      private List<Comment> comments;
}