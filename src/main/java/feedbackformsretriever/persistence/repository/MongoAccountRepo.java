package feedbackformsretriever.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import feedbackformsretriever.persistence.domain.SentAccount;
import feedbackformsretriever.persistence.domain.SentFeedbackForm;

@Repository
public interface MongoAccountRepo  extends MongoRepository<SentAccount, String>{
	
    public SentAccount findByEmail(String email);


}
