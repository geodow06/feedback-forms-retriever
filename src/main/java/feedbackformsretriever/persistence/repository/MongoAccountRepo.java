package feedbackformsretriever.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import feedbackformsretriever.persistence.domain.SentAccount;

@Repository
public interface MongoAccountRepo  extends MongoRepository<SentAccount, String>{
	
     List<SentAccount> findAllByCohortID(Long id);

     Optional <SentAccount> findByAccountID(Long id);
    
     Optional <SentAccount> findByEmail(String email);
    
     Long deleteByEmail(String email);
    
}
