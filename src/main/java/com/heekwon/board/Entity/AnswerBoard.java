package com.heekwon.board.Entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(sequenceName =  "aboard00_seq", name = "aboard00_seq_generator", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 1000)
	private String content;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createTime;
	
	@ManyToOne
	private QuestionBoard questionBoard;
	
}
