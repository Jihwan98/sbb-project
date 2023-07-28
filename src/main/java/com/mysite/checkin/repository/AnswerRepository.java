package com.mysite.checkin.repository;

import com.mysite.checkin.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
