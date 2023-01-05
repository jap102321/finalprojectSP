package com.sophfp.sophosfp.controller;

import com.sophfp.sophosfp.dto.AccountDTO;
import com.sophfp.sophosfp.dto.Message;
import com.sophfp.sophosfp.dto.genAccNum;
import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.service.AccountService;
import com.sophfp.sophosfp.service.ClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;


    @GetMapping("accounts/{id}")
    public ResponseEntity<List<Account>> getByClient(@PathVariable("id") Long id){
        if(!accountService.existsById(id)){
            return new ResponseEntity(new Message("The account does not exists"), HttpStatus.NOT_FOUND);
        }
        List<Account> accsByClient = accountService.findByClientId(id);
        return new ResponseEntity<>(accsByClient,HttpStatus.OK);
    }


    @PostMapping("/addaccount")
    public ResponseEntity<?> create(@RequestBody AccountDTO accountDTO){
        if(StringUtils.isBlank(accountDTO.getAcc_type()))
            return new ResponseEntity<>(new Message("Need Acc Type"), HttpStatus.BAD_REQUEST);

        //Generate Acc Number
        String setAccNumber = genAccNum.genAccNum(accountDTO.getAcc_type());

        Account acc = new Account(accountDTO.getClient(),accountDTO.getAcc_type(),setAccNumber, accountDTO.getBalance(),
                accountDTO.getCreated_at(),accountDTO.getAcc_status());
        accountService.save(acc);
        return new ResponseEntity<>(new Message("Account created"), HttpStatus.CREATED);
    }
    @PutMapping("updateacc/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AccountDTO accountDTO){
        if(!accountService.existsById(id)){
            return new ResponseEntity<>(new Message("The account don't exist"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(accountDTO.getAcc_status()))
            return new ResponseEntity<>(new Message("You should add a status for the acc"), HttpStatus.BAD_REQUEST);

        Account accUpd = accountService.getOne(id).get();
        accUpd.setAcc_status(accountDTO.getAcc_status());
        accountService.save(accUpd);

        return new ResponseEntity<>(new Message("Account updated"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteacc/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!accountService.existsById(id))
            return new ResponseEntity<>(new Message("The account does not exist"), HttpStatus.NOT_FOUND);

        accountService.delete(id);
        return new ResponseEntity<>(new Message("Account eliminated"), HttpStatus.OK);
    }

}
