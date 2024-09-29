package com.rnsit.studentgrievance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.entity.user.UserAuthority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
      private String comment;
      private String commentedBy;
      private UserAuthority userAuthority;

      @CreationTimestamp
      private LocalDateTime createTimeStamp;

      @UpdateTimestamp
      private LocalDateTime updateTimeStamp;

      @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
      @JsonIgnore
      private Grievance grievance;
}
