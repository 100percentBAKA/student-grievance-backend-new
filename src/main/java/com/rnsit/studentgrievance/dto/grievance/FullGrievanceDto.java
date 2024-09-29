package com.rnsit.studentgrievance.dto.grievance;

import com.rnsit.studentgrievance.entity.*;
import com.rnsit.studentgrievance.entity.grievance.GrievanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullGrievanceDto {
      private String title;
      private GrievanceStatus grievanceStatus;
      private String askedBy;
      private LocalDateTime asked;
      private LocalDateTime modified;
      private long timeTaken;
      private List<Category> categories;
      private List<Element> elements;
      private List<Comment> comments;
      private List<Answer> answers;
}