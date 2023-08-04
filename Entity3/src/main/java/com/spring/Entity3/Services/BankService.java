package com.spring.Entity3.Services;

import com.spring.Entity3.Models.Bank;
import com.spring.Entity3.Models.BankEntity;
import com.spring.Entity3.Repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    BankRepository repo;

    public String newAccountNo(Bank b){
        BankEntity newAccount = new BankEntity();

        String type = b.getType();
        String country = b.getCountry();

        String num = repo.newAccountNo(type.substring(0,1), country.substring(0,1));

        newAccount.setAccNo(num);
        newAccount.setName(b.getName());

        repo.save(newAccount);
        return num;

    }

    public List<BankEntity> findAcc(String type, String country){
        return repo.find(type.substring(0,1),country.substring(0,1));
    }

    public List<BankEntity> findAccType(String type){
        return repo.findType(type.substring(0,1));
    }

}
