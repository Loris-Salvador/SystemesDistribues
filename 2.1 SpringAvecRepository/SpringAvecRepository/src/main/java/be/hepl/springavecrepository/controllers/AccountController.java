package be.hepl.springavecrepository.controllers;

import be.hepl.springavecrepository.model.Account;
import be.hepl.springavecrepository.repositories.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/accounts")
    public String getAccounts(Model model)
    {
        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts/list";
    }
}
