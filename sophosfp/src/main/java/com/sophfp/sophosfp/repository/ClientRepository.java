package com.sophfp.sophosfp.repository;

import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findById(Long id);

    boolean existsByDocument(Long document);
    boolean existsById(Long id);





}
