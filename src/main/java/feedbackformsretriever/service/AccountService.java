package feedbackformsretriever.service;

import java.util.List;

import feedbackformsretriever.persistence.domain.Account;


public interface AccountService {
	
    List<Account> getAccounts();

    Account getAccount(Long id);

    Account addAccount(Account account);

    Account deleteAccount(Long id);

    Account updateAccount(Account account, Long id);
	

}
