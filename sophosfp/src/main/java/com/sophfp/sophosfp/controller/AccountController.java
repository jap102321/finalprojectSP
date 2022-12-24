package com.sophfp.sophosfp.controller;

import com.sophfp.sophosfp.dto.AccountDTO;
import com.sophfp.sophosfp.dto.ClientReq;
import com.sophfp.sophosfp.dto.Message;
import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.entity.Client;
import com.sophfp.sophosfp.repository.AccountRepository;
import com.sophfp.sophosfp.repository.ClientRepository;
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
    @GetMapping("/accountlist")
    public ResponseEntity<List<Account>> list(){
        List<Account> list = accountService.list();
        return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
    }

    @PostMapping("/addaccount")
    public ResponseEntity<?> create(@RequestBody AccountDTO accountDTO){
        if(StringUtils.isBlank(accountDTO.getAcc_type()))
            return new ResponseEntity<>(new Message("Need Acc Type"), HttpStatus.BAD_REQUEST);



       Account account = new Account(accountDTO.getClient(),accountDTO.getAcc_type(), accountDTO.getAcc_number() , accountDTO.getBalance(),accountDTO.getCreated_at(), accountDTO.isAcc_status());
       accountService.save(account);


        //accountService.save(account);
        return new ResponseEntity<>(new Message("Account created"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteacc/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!accountService.existsById(id))
            return new ResponseEntity<>(new Message("The account does not exist"), HttpStatus.NOT_FOUND);
        accountService.delete(id);
        return new ResponseEntity<>(new Message("Account eliminated"), HttpStatus.OK);
    }

}
