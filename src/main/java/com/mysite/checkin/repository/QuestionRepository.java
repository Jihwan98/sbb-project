package com.mysite.checkin.repository;

import com.mysite.checkin.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject, String content);
}
