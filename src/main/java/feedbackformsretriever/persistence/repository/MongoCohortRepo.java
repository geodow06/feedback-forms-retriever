package feedbackformsretriever.persistence.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import feedbackformsretriever.persistence.domain.SentAccount;
import feedbackformsretriever.persistence.domain.SentCohort;

public interface MongoCohortRepo extends MongoRepository<SentCohort, String> {
	
     Optional <SentCohort> findByCohortID(Long id);
     
     Long deleteByCohortName(String cohortName);

    
}
	
