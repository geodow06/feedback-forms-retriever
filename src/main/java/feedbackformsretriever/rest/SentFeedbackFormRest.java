package feedbackformsretriever.rest;



import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import feedbackformsretriever.persistence.domain.SentFeedbackForm;
import feedbackformsretriever.persistence.repository.MongoFeedbackFormRepo;

@CrossOrigin
@RequestMapping("${path.base2}")
@RestController
public class SentFeedbackFormRest {
	
	@Autowired
	private MongoFeedbackFormRepo repo;

    @GetMapping("${path.getAllFeedbackForms}")
    public Collection<SentFeedbackForm> getAllFeedbackForms() {
        return repo.findAll();
    }
    
    @GetMapping("${path.getFeedbackFormByID}")
    public Optional<SentFeedbackForm> getFeedbackFormByID(@PathVariable String feedbackID) {
    	return repo.findById(feedbackID);
    }
	

	@GetMapping("/test")
	public String test() {
		return "end points work";
	}


}
