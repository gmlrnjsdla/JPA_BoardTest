package com.heekwon.board.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
public class TestABoard {

	@Autowired
	QBoardRepository qBoardRepository;
	
	@Autowired
	ABoardRepository aBoardRepository;
	
	@Test
	@DisplayName("답변 저장 테스트")
	public void AnswerCreateTest() {
		
		Optional<QuestionBoard> oQboard = qBoardRepository.findById(8);
		assertTrue(oQboard.isPresent()); // 8번 질문글이 존재하는지 테스트
		
		QuestionBoard qBoard = oQboard.get();
		
		AnswerBoard aBoard = new AnswerBoard();
		aBoard.setContent("8번글 답변입니다.");
		aBoard.setQuestionBoard(qBoard);
		
		aBoardRepository.save(aBoard);
		
	}
	
	@Test
	@DisplayName("답변 조회 테스트")
	public void AnswerSearchTest() {
		
		Optional<AnswerBoard> oAboard = aBoardRepository.findById(11);
		assertTrue(oAboard.isPresent());
		
		AnswerBoard aBoard = oAboard.get();
		
		assertEquals(8, aBoard.getQuestionBoard().getId());
		//질문글의 아이디를 가져와서 확인
		
	}
	
	@Transactional
	@Test
	@DisplayName("답변/질문 조회 테스트")
	public void AnswerQuestionSearchTest() {
		
		Optional<QuestionBoard> oQboard = qBoardRepository.findById(8);
		assertTrue(oQboard.isPresent()); // 8번 질문글이 존재하는지 테스트
		QuestionBoard qBoard = oQboard.get();
		
		List<AnswerBoard> aBoards = qBoard.getAnswerList(); //답변글 리스트 가져오기
		assertEquals(6, aBoards.size());
		// 질문 8번에 달린 답글 개수가 총 5개인지 확인
		
		
	}
	
}
