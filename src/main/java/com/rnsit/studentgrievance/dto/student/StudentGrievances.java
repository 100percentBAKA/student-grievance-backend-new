package com.rnsit.studentgrievance.dto.student;

import com.rnsit.studentgrievance.entity.grievance.GrievanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGrievances {
      private UUID id;
      private String title;
      private GrievanceStatus grievanceStatus;
      private String askedBy;
      private LocalDateTime asked;
      private LocalDateTime modified;
      private long timeTaken;
}