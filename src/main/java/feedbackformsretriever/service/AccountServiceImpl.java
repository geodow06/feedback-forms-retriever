package feedbackformsretriever.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feedbackformsretriever.persistence.domain.Account;
import feedbackformsretriever.persistence.repository.MongoAccountRepo;
import feedbackformsretriever.util.exceptions.AccountNotFoundException;

@Service
public class AccountServiceImpl {
	
	@Autowired
	private MongoAccountRepo repo;

	public List<Account> getAccounts() {
		return repo.findAll();
	}
	
	public Account getAccount(Long id) {
		Optional<Account> account = repo.findById(id);
		return account.orElseThrow(() -> new AccountNotFoundException(id));
	}

	private boolean accountExists(Long id) {
		Optional<Account> accountOptional = repo.findById(id);
		return accountOptional.isPresent();
	}

}
