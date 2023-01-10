package com.sophfp.sophosfp.repository;

import com.sophfp.sophosfp.entity.Account;
import com.sophfp.sophosfp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacRepository extends JpaRepository<Transaction, String> {


    Optional<Transaction> findByAccount(Account account);



}
