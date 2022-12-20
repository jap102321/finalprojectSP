package com.sophfp.sophosfp.controller;

import com.sophfp.sophosfp.dto.ClientDTO;
import com.sophfp.sophosfp.dto.Message;
import com.sophfp.sophosfp.entity.Client;
import com.sophfp.sophosfp.service.ClientService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clientlist")
    public ResponseEntity<List<Client>> list(){
        List<Client> list = clientService.list();
        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
    }

    @GetMapping("/clientdetail/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") long id){
        if(!clientService.existsById(id)){
            return new ResponseEntity(new Message("It does not exist"),HttpStatus.NOT_FOUND);
        }

        Client client = clientService.getOne(id).get();
        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }

    @PostMapping("/registerClient")
    public ResponseEntity<?> create(@RequestBody ClientDTO clientDTO){

    }
}
