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

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clientlist")
    public ResponseEntity<List<Client>> list(){
        List<Client> list = clientService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/clientdetail/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") long id){
        if(!clientService.existsById(id)){
            return new ResponseEntity(new Message("It does not exist"),HttpStatus.NOT_FOUND);
        }

        Client client = clientService.getOne(id).get();
        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }

    @PostMapping("/registerclient")
    public ResponseEntity<?> create(@RequestBody ClientDTO clientDTO){
        if (StringUtils.isBlank(clientDTO.getName()))
            return new ResponseEntity<>(new Message("The name is mandatory"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(clientDTO.getEmail()))
            return new ResponseEntity<>(new Message("The email is mandatory"), HttpStatus.BAD_REQUEST);
        if(clientService.existsByDocument(clientDTO.getDocument()))
            return new ResponseEntity<>(new Message("The document is already registered"), HttpStatus.BAD_REQUEST);

        Client client = new Client(clientDTO.getIdType(),clientDTO.getName(), clientDTO.getLastname(), clientDTO.getDocument(),clientDTO.getEmail(),clientDTO.getBirthDate(),clientDTO.getUpdateUser(),clientDTO.getCreationDate());

        int years = Period.between(clientDTO.getBirthDate(), clientDTO.getCreationDate()).getYears();
        if(years < 18)
            return new ResponseEntity<>(new Message("The client must be 18 or older to create an account"), HttpStatus.BAD_REQUEST);

        clientService.save(client);

            return new ResponseEntity<>(new Message("Client added to the DBase"), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO){
        if(!clientService.existsById(id))
            return new ResponseEntity(new Message("It does not exists"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(clientDTO.getUpdateUser()))
            return new ResponseEntity<>(new Message("The update user is mandatory"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(clientDTO.getEmail()))
            return new ResponseEntity<>(new Message("The email is mandatory"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(clientDTO.getUpdateUser()))
            return new ResponseEntity<>(new Message("The update user is mandatory"), HttpStatus.BAD_REQUEST);

        Client clientUpd = clientService.getOne(id).get();
        clientUpd.setUpdateDate(clientDTO.getUpdateDate());
        clientUpd.setUpdateUser(clientDTO.getUpdateUser());
        clientUpd.setEmail(clientDTO.getEmail());
        clientService.save(clientUpd);

        return new ResponseEntity<>(new Message("Client updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!clientService.existsById(id))
            return new ResponseEntity<>(new Message("It does not exist"), HttpStatus.NOT_FOUND);
        clientService.delete(id);
        return new ResponseEntity<>(new Message("User eliminated"), HttpStatus.OK);
    }





}
