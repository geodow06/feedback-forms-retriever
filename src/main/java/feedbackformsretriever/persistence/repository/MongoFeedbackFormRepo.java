package feedbackformsretriever.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import feedbackformsretriever.persistence.domain.SentFeedbackForm;

public interface MongoFeedbackFormRepo extends MongoRepository<SentFeedbackForm, String> {

}
