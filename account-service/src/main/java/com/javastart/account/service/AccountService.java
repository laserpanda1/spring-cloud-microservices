package com.javastart.account.service;

import com.javastart.account.entity.Account;
import com.javastart.account.exception.AccountNotFoundException;
import com.javastart.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).
                orElseThrow(() -> new AccountNotFoundException("Unable to find account with id : " + id));
    }

    public Long createAccount(String name, String email, String phone, List<Long> bills) {
        Account account = new Account(name, phone, OffsetDateTime.now(), phone, bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account updateAccount(Long accountId, String name, String email, String phone , List<Long> bills) {
        Account account = new Account();
        account.setAccountId(accountId);
        account.setName(name);
        account.setPhone(phone);
        account.setEmail(email);
        account.setBills(bills);
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long id) {
        Account deletedAccount = getAccountById(id);
        accountRepository.deleteById(id);
        return deletedAccount;
    }

}
