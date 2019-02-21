package feedbackformsretriever.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feedbackformsretriever.persistence.domain.SentAccount;
import feedbackformsretriever.persistence.repository.MongoAccountRepo;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class SentAccountRest {
	
	@Autowired
	private MongoAccountRepo repo;

	@GetMapping("${path.getAccounts}")
	public List<SentAccount> getAccounts() {
		return repo.findAll();
	}

	@GetMapping("/test")
	public String test() {
		return "end points work";
	}

}
