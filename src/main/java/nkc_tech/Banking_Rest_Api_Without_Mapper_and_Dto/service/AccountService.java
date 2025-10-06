package nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.service;

import nkc_tech.Banking_Rest_Api_Without_Mapper_and_Dto.entity.Account;

import java.util.List;

public interface AccountService {


    Account createAccount(Account account);

    Account getAccountById(Long id);

    Account deposit(Long id, double amount);

    Account withdraw(Long id, double amount);

    List<Account> getAllAccounts();

    void deleteAccount(Long id);
}
