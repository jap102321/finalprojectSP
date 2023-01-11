package com.sophfp.sophosfp.repository;

import com.sophfp.sophosfp.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);

    Optional<Account> findByaccNumber(String accNumber);
    boolean existsByaccNumber(String accNumber);

    List<Account> findByClientId(Long id);

    boolean existsById(Long id);

}
