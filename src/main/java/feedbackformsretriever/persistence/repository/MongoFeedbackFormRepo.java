package feedbackformsretriever.persistence.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import feedbackformsretriever.persistence.domain.SentFeedbackForm;

public interface MongoFeedbackFormRepo extends MongoRepository<SentFeedbackForm, String> {

	Optional<SentFeedbackForm> findByfeedbackID(Long feedbackID);
	
	
}
