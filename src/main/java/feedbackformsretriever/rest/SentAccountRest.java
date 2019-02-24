package feedbackformsretriever.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feedbackformsretriever.persistence.domain.SentAccount;
import feedbackformsretriever.persistence.repository.MongoAccountRepo;

@CrossOrigin
@RequestMapping("${path.accounts}")
@RestController
public class SentAccountRest {
	
	@Autowired
	private MongoAccountRepo repo;

	@GetMapping("${path.getAccounts}")
	public List<SentAccount> getAccounts() {
		return repo.findAll();
	}
	
	@GetMapping("${path.getByAccountID}")
	public Optional<SentAccount> getAccountById(@PathVariable Long id) {
	    return repo.findByAccountID(id);
	}
	
	@GetMapping("${path.getByCohortID}")
	public List<SentAccount> getAccountsByCohortID(@PathVariable Long id) {
		return repo.findAllByCohortID(id);
	}
	
    @GetMapping("${path.getByEmail}")
    public Optional<SentAccount> getAccountByEmail(@PathVariable String email) {
    	return repo.findByEmail(email);
    }
    
    @PutMapping("${path.updateAccount}")
    public String updateAccountByObjId(@RequestBody SentAccount sentAccount, @PathVariable String id) {
        if(repo.existsById(id)){
        	sentAccount.set_id(id);
            repo.save(sentAccount);
    		return "{\"message\": \"account has been sucessfully updated\"}";
        }
        
		return "{\"message\": \"id does not exist\"}";
    }
    	
    

    
	
}
