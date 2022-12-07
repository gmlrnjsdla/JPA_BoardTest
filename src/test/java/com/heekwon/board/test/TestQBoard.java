package com.heekwon.board.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.heekwon.board.Entity.AnswerBoard;
import com.heekwon.board.Entity.QuestionBoard;
import com.heekwon.board.repository.ABoardRepository;
import com.heekwon.board.repository.QBoardRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TestQBoard {

	@Autowired
	QBoardRepository qBoardRepository;
	
	@Autowired
	ABoardRepository aBoardRepository;
	
	@Test
	@DisplayName("저장 테스트")
	public void createQuestion() {
		QuestionBoard qBoard = new QuestionBoard();
		
		qBoard.setSubject("안녕");
		qBoard.setContent("안녕");
		
		qBoardRepository.save(qBoard);
	}
	
//	@Test
//	@DisplayName("조회 테스트")
//	public void searchQuestion() {
//		
//		List<QuestionBoard> qAll = qBoardRepository.findAll();
//		
//		assertEquals(7, qAll.size()); //실제 모든글의 개수와 기대한 값인 2개가 일치하는지 여부 확인
//		
//		QuestionBoard q1 =  qAll.get(1);
//		assertEquals("질문 또 드립니다!", q1.getSubject()); 
//		
////		for(QuestionBoard q1 : qAll) {
////			System.out.println(q1);
////		}
//		
//	}
	
//	@Test
//	@DisplayName("조회 테스트2")
//	public void searchQuestion2() {
//		
//		Optional<QuestionBoard> qBoard = qBoardRepository.findById(2);
//		
//		if(qBoard.isPresent()) {
//			QuestionBoard q1 =  qBoard.get();
//			assertEquals("질문 또 드립니다!", q1.getSubject());
//		}
//	}
	
	@Test
	@DisplayName("조회 테스트3")
	public void searchQuestion3() {
		
		List<QuestionBoard> qBoards = qBoardRepository.findBySubject("질문1");
		
		QuestionBoard qboard = qBoards.get(0);
		
		assertEquals(6, qboard.getId());
		
		
	}
	
	@Test
	@DisplayName("조회 테스트4")
	public void searchQuestion4() {
		
		List<QuestionBoard> qBoards = qBoardRepository.findBySubjectAndContent("안녕","안녕");
		
		QuestionBoard qboard = qBoards.get(0);
		
		assertEquals(7, qboard.getId());
		
		
	}
	
	@Test
	@DisplayName("조회 테스트5")
	public void searchQuestion5() {
		
		List<QuestionBoard> qBoards = qBoardRepository.findBySubjectLike("%질문%");
		assertEquals(4, qBoards.size());
		
	}
	
	@Test
	@DisplayName("수정 테스트")
	public void modifyQuestion() {
		
		Optional<QuestionBoard> qBoard = qBoardRepository.findById(2);
		QuestionBoard q1 = qBoard.get();
		q1.setSubject("저는 2번글입니다");
		assertEquals("저는 2번글입니다", q1.getSubject());
		
		qBoardRepository.save(q1);
		
	}
	
	@Test
	@DisplayName("삭제 테스트")
	public void deleteQuestion() {
		
		Optional<QuestionBoard> qBoard = qBoardRepository.findById(3);
		QuestionBoard q1 = qBoard.get();
		
		qBoardRepository.delete(q1);
		
		List<QuestionBoard> qAll = qBoardRepository.findAll();
		assertEquals(6, qAll.size());
		
	}
	
	
}
