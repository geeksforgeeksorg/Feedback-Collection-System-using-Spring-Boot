package com.app;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "feedbackdata")
public class FeedBack {

	@Id
	private String id;

	private String fullName;
	private String email;
	private String category;
	private String message;
	private LocalDateTime date;
}
