package be.hepl.springavecrepository.controllers;

import be.hepl.springavecrepository.repositories.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
