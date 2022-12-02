package com.heekwon.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heekwon.board.Entity.QuestionBoard;

public interface QBoardRepository extends JpaRepository<QuestionBoard, Integer>{

	public List<QuestionBoard> findBySubject(String subject);

	public List<QuestionBoard> findBySubjectAndContent(String subject, String content);

	public List<QuestionBoard> findBySubjectLike(String subject);

	
	
}
