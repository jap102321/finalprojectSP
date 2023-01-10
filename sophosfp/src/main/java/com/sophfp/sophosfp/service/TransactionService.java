package com.sophfp.sophosfp.service;

import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.entity.Transaction;
import com.sophfp.sophosfp.repository.TransacRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransacRepository transacRepository;
    public List<Transaction> getOne(Long id){
        return transacRepository.findByAccountAccid(id);
    }


    public void save(Transaction transaction){
        transacRepository.save(transaction);
    }

}
