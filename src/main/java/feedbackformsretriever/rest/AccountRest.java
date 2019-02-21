package feedbackformsretriever.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feedbackformsretriever.persistence.domain.Account;
import feedbackformsretriever.service.AccountService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AccountRest {
	
	@Autowired
    private AccountService service;
	
	
	 @GetMapping("${path.getAccounts}")
	    public List<Account> getAccounts() {
	        return service.getAccounts();
	    }

	    @GetMapping("${path.getAccountById}")
	    public Account getAccount(@PathVariable Long id) {
	        return service.getAccount(id);
	    }

	
	

}
