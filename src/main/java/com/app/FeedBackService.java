package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {
	@Autowired
	private FeedBackRepo feedBackRepo;

	public boolean saveData(FeedBack feedBack) {
		feedBackRepo.save(feedBack);
		return true;
	}
	
	public List<FeedBack> getAllData() {
		List<FeedBack> feedbackList = feedBackRepo.findAll();
		return feedbackList;
	}
}
