package com.sophfp.sophosfp.controller;


import com.sophfp.sophosfp.dto.*;
import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.entity.Client;
import com.sophfp.sophosfp.entity.Transaction;
import com.sophfp.sophosfp.repository.AccountRepository;
import com.sophfp.sophosfp.service.AccountService;
import com.sophfp.sophosfp.service.TransactionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "http://localhost:4200")

public class TransacController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;


    @GetMapping("/transaclist/{id}")
    public ResponseEntity<List<Transaction>> getOne(@PathVariable("id") Long id ){

        List<Transaction> translist = transactionService.getOne(id);

        return new ResponseEntity<>(translist, HttpStatus.OK);
    }

    @PostMapping("/inacc")
    public ResponseEntity<?> transac(@RequestBody TransacDTO transacDTO){
        Long acc_id = transacDTO.getAccount().getAccid();

        if(StringUtils.isBlank(transacDTO.getTransac_type()))
            return new ResponseEntity<>(new Message("The transaction type is mandatory"), HttpStatus.BAD_REQUEST);
        if(transacDTO.getAccount().equals("")){
            return new ResponseEntity<>(new Message("You should add an account"), HttpStatus.BAD_REQUEST);
        }

        Account accountUpd = accountService.getOne(acc_id).get();
        Transaction transaction = new Transaction(transacDTO.getAccount(),transacDTO.getTransac_type(),
                transacDTO.getAmount(),transacDTO.getTransac_date());

        double currentBalance= accountUpd.getBalance();
        double amountTransac = transacDTO.getAmount();


        if(transacDTO.getTransac_type().equalsIgnoreCase("deposit")){
            double addedValue = currentBalance + amountTransac ;
            accountUpd.setBalance(addedValue);
        }


        if (transacDTO.getTransac_type().equalsIgnoreCase("withdraw")) {

            double addedValue = currentBalance - amountTransac ;
            accountUpd.setBalance(addedValue);
            if(accountUpd.getAcc_type().equalsIgnoreCase("corriente")
                    && accountUpd.getBalance()  <= -3000000){
                return new ResponseEntity<>(new Message("You don't have enough balance"), HttpStatus.BAD_REQUEST);
            } else if (accountUpd.getAcc_type().equalsIgnoreCase("ahorros") &&
                    accountUpd.getBalance()  <= 0) {
                return new ResponseEntity<>(new Message("You don't have enough balance"), HttpStatus.BAD_REQUEST);
            }

        }


        accountService.save(accountUpd);
        transactionService.save(transaction);

       return new ResponseEntity<>(new Message("Transaction successful"), HttpStatus.OK);
    }




}
