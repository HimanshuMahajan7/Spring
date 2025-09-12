package com.example;

import com.example.entity.Account;
import com.example.entity.AccountPK;
import com.example.repository.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Application3 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application3.class);
        AccountRepository accountRepository = context.getBean(AccountRepository.class);

        AccountPK accountPK = new AccountPK();
        accountPK.setAccId(1);
        accountPK.setAccNum(1000L);
        accountPK.setAccType("Current");

        Account account = new Account();
        account.setAccountPK(accountPK);
        account.setHolderName("Himanshu");
        account.setBranch("Indore");
        accountRepository.save(account);
        System.out.println("Account Record Inserted !!!");

        System.out.println("\n **************** Account Record *****************");
        Optional<Account> accountDetails = accountRepository.findById(accountPK);
        System.out.println(accountDetails.get());

        System.out.println("\n");
    }
}
