package com.sophfp.sophosfp.service;

import com.sophfp.sophosfp.entity.Client;
import com.sophfp.sophosfp.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> list(){
        return clientRepository.findAll();
    }

    public Optional<Client> getOne(Long id){
        return clientRepository.findById(id);
    }

    public boolean existsById(Long id){
        return clientRepository.existsById(id);
    }

    public void save(Client client){
        clientRepository.save(client);
    }
    public void delete(Long id){
        clientRepository.deleteById(id);
    }



}
