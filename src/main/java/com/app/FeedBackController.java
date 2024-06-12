package com.app;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FeedBackController {
	
	@Autowired
	private FeedBackService feedBackService;
	
	@Autowired
	private FeedBackRepo feedBackRepo;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("feedback", new FeedBack());
		return "index";
	}
	
	@PostMapping("/")
	public String saveData(Model model, @ModelAttribute FeedBack feedBack) {
		feedBack.setDate(LocalDateTime.now());
		if (feedBackService.saveData(feedBack)) {
			model.addAttribute("success","Feedback Received Successfully");
		}
		else {
			model.addAttribute("error","Something Went Wrong");
		}
		return "index";
	}
	
	@GetMapping("/feedbacks")
    public String getDashboard(Model model) {
        model.addAttribute("feedbackList", feedBackService.getAllData());
        model.addAttribute("totalFeedbacks", feedBackRepo.count());
        model.addAttribute("totalProductFeedbacks", feedBackRepo.countByCategory("Product feedback"));
        model.addAttribute("totalCustomerFeedbacks", feedBackRepo.countByCategory("Customer feedback"));
        model.addAttribute("totalReviewFeedbacks", feedBackRepo.countByCategory("Review feedback"));
        model.addAttribute("totalOtherFeedbacks", feedBackRepo.countByCategory("others"));
        return "dashboard";
    }
	
}
