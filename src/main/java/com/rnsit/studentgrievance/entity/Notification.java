package com.rnsit.studentgrievance.entity;

import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
      private String description;

      @Column(nullable = false)
      private boolean isOtp;

      @ManyToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "user_id")
      private User user;

      @ManyToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "grievance_id")
      private Grievance grievance;
}
