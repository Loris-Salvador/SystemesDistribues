package be.hepl.springavecrepository.bootstrap;

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

    }
}
