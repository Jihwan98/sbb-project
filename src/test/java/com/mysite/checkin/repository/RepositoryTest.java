package com.mysite.checkin;

import com.mysite.checkin.domain.Question;
import com.mysite.checkin.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    // 단위 테스트 이후 삭제하는게 구현이 안되어있으니(Transaction) 한 번만 실행 해야함
//	@Test
//	void 질문_생성_저장() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); // 첫번째 질문 저장
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2); // 두번째 질문 저장
//
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//	}

    @Test
    void getSubject() {
        List<Question> all = this.questionRepository.findAll();
        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void findById() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }
    @Test
    void findBySubject() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q.getId());
    }

    @Test
    void findBySubjectAndContent() {
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?",
                "sbb에 대해서 알고 싶습니다."
        );
        assertEquals(1, q.getId());
    }
}
