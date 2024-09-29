package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.entity.Element;
import com.rnsit.studentgrievance.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ElementService {
      @Autowired private ElementRepository elementRepository;

      public List<Element> getElements(UUID uuid) {
            return elementRepository.findAllByGrievanceId(uuid);
      }
}
