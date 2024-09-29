package com.rnsit.studentgrievance.controller;

import com.rnsit.studentgrievance.dto.grievance.FullGrievanceDto;
import com.rnsit.studentgrievance.dto.grievance.PartialGrievance;
import com.rnsit.studentgrievance.dto.student.StudentGrievances;
import com.rnsit.studentgrievance.entity.grievance.Grievance;
import com.rnsit.studentgrievance.entity.grievance.GrievanceStatus;
import com.rnsit.studentgrievance.service.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grievance")
public class GrievanceController {
      @Autowired private GrievanceService grievanceService;

      @PostMapping
      public ResponseEntity<String> addGrievance(@RequestBody Grievance grievance) {
            grievance.setGrievanceStatus(GrievanceStatus.RAISED);
            return new ResponseEntity<>(grievanceService.save(grievance), HttpStatus.OK);
      }

      @GetMapping("/{grievance_id}")
      public ResponseEntity<FullGrievanceDto> getGrievance(@PathVariable String grievance_id) {
            return new ResponseEntity<>(grievanceService.getGrievance(grievance_id), HttpStatus.OK);
      }

      @GetMapping("/get")
      public ResponseEntity<Map<String, Object>> getGrievances(@RequestParam int pageNo) {
            return new ResponseEntity<>(grievanceService.getGrievances(pageNo), HttpStatus.OK);
      }
}