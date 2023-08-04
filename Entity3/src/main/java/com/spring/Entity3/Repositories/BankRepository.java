package com.spring.Entity3.Repositories;

import com.spring.Entity3.Models.Bank;
import com.spring.Entity3.Models.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<BankEntity,String> {

    @Query(value = "select concat(?1, ?2, ifnull(lpad(max(substr(acc_no, 3, 3))+1, 3, '0'), '001')) as acc_no from Bank where substr(acc_no,1,1)=?1 and substr(acc_no, 2,1)=?2", nativeQuery = true)
    String newAccountNo(String type, String country);

    @Query(value = "select * from Bank where substr(acc_no,1,1)=?1 and substr(acc_no,2,1)=?2", nativeQuery = true)
    List<BankEntity> find(String type, String country);

    @Query(value = "select * from Bank where substr(acc_no,1,1)=?1", nativeQuery = true)
    List<BankEntity> findType(String type);

}
