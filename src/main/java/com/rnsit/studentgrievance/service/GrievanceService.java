package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.dto.grievance.FullGrievanceDto;
import com.rnsit.studentgrievance.dto.grievance.PartialGrievance;
import com.rnsit.studentgrievance.dto.student.StudentGrievances;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.repository.GrievanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GrievanceService {
      @Autowired private GrievanceRepository grievanceRepository;

      @Autowired private ElementService elementService;
      @Autowired private CommentService commentService;

      @Transactional
      public String save(Grievance grievance) {
            return grievanceRepository.save(grievance).getId().toString();
      }

      public FullGrievanceDto getGrievance(String grievance_id) {
            UUID uuid = UUID.fromString(grievance_id);
            Grievance grievance = grievanceRepository.findById(uuid).orElse(null);

            assert grievance != null;
            return new FullGrievanceDto(
                    grievance.getTitle(),
                    grievance.getGrievanceStatus(),
                    grievance.getAskedBy(),
                    grievance.getAsked(),
                    grievance.getModified(),
                    grievance.getTimeTaken(),
                    grievance.getCategories(),
                    elementService.getElements(uuid),
                    commentService.getComments(uuid),
                    null
            );
      }

      public Map<String, Object> getGrievances(int pageNo) {
            Pageable pageable = PageRequest.of(pageNo - 1, 5);

            Map<String, Object> grievances = new HashMap<>();
            Page<PartialGrievance> grievancePage = grievanceRepository.findGrievances(pageable);

            grievances.put("TotalPages", grievancePage.getTotalPages());
            grievances.put("Content", grievancePage.getContent());

            return grievances;
      }

      public Map<String, Object> getGrievancesByStudent(String usn, int pageNo) {
            Pageable pageable = PageRequest.of(pageNo - 1, 5);

            Map<String, Object> studentGrievances = new HashMap<>();
            Page<PartialGrievance> studentGrievancePage = grievanceRepository.findGrievancesByStudent(usn, pageable);

            studentGrievances.put("TotalPages", studentGrievancePage.getTotalPages());
            studentGrievances.put("Content", studentGrievancePage.getContent());

            return studentGrievances;
      }
}
