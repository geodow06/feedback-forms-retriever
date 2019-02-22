package feedbackformsretriever.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.bson.types.ObjectId;

import feedbackformsretriever.persistence.domain.SentAccount;
import feedbackformsretriever.persistence.domain.SentCohort;
import feedbackformsretriever.persistence.domain.SentFeedbackForm;
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
	
	
	@GetMapping("${path.getAccountById}")
	public Optional<SentAccount> findAccountByID(@PathVariable String id) {
	    return repo.findById(id);
	}
	
	@GetMapping("${path.getByCohortId}")
	public List<SentAccount> findAccountByCohortId(@PathVariable Long id) {
		return repo.findAllByCohortID(id);
	}
	
    @GetMapping("${path.getAccountByEmail}")
    public Optional<SentAccount> getAccountByEmail(@PathVariable String email) {
    	return repo.findByEmail(email);
    }
   

}
