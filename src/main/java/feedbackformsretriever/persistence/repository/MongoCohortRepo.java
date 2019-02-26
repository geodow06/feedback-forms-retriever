package feedbackformsretriever.persistence.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import feedbackformsretriever.persistence.domain.SentCohort;

public interface MongoCohortRepo extends MongoRepository<SentCohort, Long> {
	
     SentCohort findByCohortID(Long id);
     
     Long deleteByCohortName(String cohortName);
     
     Long deleteByCohortID(Long cohortID);

    
}
	
