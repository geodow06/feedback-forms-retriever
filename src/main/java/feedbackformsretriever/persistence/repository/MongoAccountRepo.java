package feedbackformsretriever.persistence.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import feedbackformsretriever.persistence.domain.SentAccount;

@Repository
public interface MongoAccountRepo  extends MongoRepository<SentAccount, String>{
	
    public Optional <SentAccount> findByCohortID(Long id);

    public Optional <SentAccount> findByAccountID(Long id);
    
    public Optional <SentAccount> findByFirstName(String firstName);
    
    public Optional <SentAccount> findByLastName (String lastName);
    
    public  Optional <SentAccount> findByEmail(String email);


    
    
    
    
    
//	
//	private Long accountID;
//	private Long cohortID;
//	private boolean admin;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String password;
//	private boolean flagged;

}
