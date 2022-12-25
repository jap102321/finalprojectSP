package com.sophfp.sophosfp.controller;


import com.sophfp.sophosfp.dto.Message;
import com.sophfp.sophosfp.dto.TransacDTO;
import com.sophfp.sophosfp.dto.getTransac;
import com.sophfp.sophosfp.entity.Transaction;
import com.sophfp.sophosfp.service.TransactionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TransacController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("/transaction")
    public ResponseEntity<?> transac(@RequestBody TransacDTO transacDTO){
        if(StringUtils.isBlank(transacDTO.getTransac_type()))
            return new ResponseEntity<>(new Message("The transaction type is mandatory"), HttpStatus.BAD_REQUEST);
        if(transacDTO.getAccount().equals("")){
            return new ResponseEntity<>(new Message("You should add an account"), HttpStatus.BAD_REQUEST);
        }

       Transaction transaction = new Transaction(transacDTO.getAccount(),transacDTO.getTransac_type(),transacDTO.getRec_acc(),transacDTO.getAmount(),transacDTO.getTransac_date());
       transactionService.save(transaction);


       return new ResponseEntity<>(new Message("Transaction succesful"), HttpStatus.OK);
    }
}
