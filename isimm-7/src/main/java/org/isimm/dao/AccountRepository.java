package org.isimm.dao;

import org.isimm.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
   // public Page<Account> findByUsername(String mc,Pageable pageable);
    Page<AccountProjection> findAllProjectedBy(Pageable pageable);
    Page<AccountProjection> findByUsername(@Param("username") String username, Pageable pageable);
    
}