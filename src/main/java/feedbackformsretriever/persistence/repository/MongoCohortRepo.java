package feedbackformsretriever.persistence.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import feedbackformsretriever.persistence.domain.SentCohort;

public interface MongoCohortRepo extends MongoRepository<SentCohort, ObjectId> {
	
    public Optional <SentCohort> findByCohortId(Long id);
    
}
	