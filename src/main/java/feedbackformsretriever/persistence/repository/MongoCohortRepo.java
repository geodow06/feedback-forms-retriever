package feedbackformsretriever.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import feedbackformsretriever.persistence.domain.SentCohort;

public interface MongoCohortRepo extends MongoRepository<SentCohort, String> {

}
	