package be.hepl.springavecrepository.bootstrap;

import be.hepl.springavecrepository.model.Account;
import be.hepl.springavecrepository.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDb implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        Account a = new Account(1,"test1", 29.99);
        Account b = new Account(2,"test 2", 39.99);

        accountRepository.save(a);
        accountRepository.save(b);
    }
}
