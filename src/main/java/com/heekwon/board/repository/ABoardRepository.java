package com.heekwon.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heekwon.board.Entity.AnswerBoard;

public interface ABoardRepository extends JpaRepository<AnswerBoard, Integer>{

	
	
}
