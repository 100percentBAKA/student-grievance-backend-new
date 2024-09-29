package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
      @Autowired private AnswerRepository answerRepository;
}
