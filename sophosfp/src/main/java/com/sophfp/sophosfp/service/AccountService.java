package com.sophfp.sophosfp.service;

import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> list(){
        return accountRepository.findAll();
    }

    public boolean existsByaccNumber(String accNumber){
        return accountRepository.existsByaccNumber(accNumber);
    }

    public Optional<Account> findByaccNumber(String accNumber){
        return accountRepository.findByaccNumber(accNumber);
    }

    public List<Account> findByClientId(Long id){
        return accountRepository.findByClientId(id);
    }

    public Optional<Account> getOne(Long id){
        return accountRepository.findById(id);
    }

    public boolean existsById(Long id){
        return accountRepository.existsById(id);
    }



    public void save(Account account){
        accountRepository.save(account);
    }
    public void delete(Long id){
        accountRepository.deleteById(id);
    }


}
