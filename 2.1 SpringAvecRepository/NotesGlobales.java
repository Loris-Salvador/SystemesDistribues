/* DEMARRAGE PROJET : spring intializer et ajouter dependances web, thymeleaf, data jpa, h2 db*/
 

//architecture : 4 packages : bootstrap, model, controllers, repositories

//model Account : 

package be.hepl.springavecrepository.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Account {

    @Id
    private long accountId;
    private String bankName;
    private double prix;


    public Account(int i, String test1, double v) {
        accountId = i;
        bankName = test1;
        prix = v;
    }

    public Account() {

    }

    public long getaccountId() {
        return accountId;
    }

    public String getBankName() {
        return bankName;
    }

    public double getaccountAmount() {
        return prix;
    }
}


/*

@Entity : facilite persitance des donnees : mapping db relationnelle
@Id : cle primaire

*/

//REPOSITORY


package be.hepl.springavecrepository.repositories;

import be.hepl.springavecrepository.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}

//Cette interface (Crud) générique est fournie par Spring Data JPA. Elle offre des méthodes CRUD (Create, Read, Update, Delete) de base pour travailler avec des entités


//Controller

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
        return "accounts/list"; // bien mettre le html dans le repertoire template/accounts/
    }
}


//model.addAttribute("accounts", accountRepository.findAll()) : Cette ligne ajoute un attribut lie
//appelé "accounts" au modèle (Model). Cet attribut est associé à la liste des comptes récupérée à partir de accountRepository.findAll().

//InitDb

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



//HTML

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <table>
    <tr>
        <th>ID</th>
        <th>Bank</th>
        <th>Account</th>
    </tr>
      </tr>
      <tr th:each="account : ${accounts}">
          <td th:text="${account.getaccountId()}"></td>
          <td th:text="${account.getBankName()}"></td>
          <td th:text="${account.getaccountAmount()}"></td>
      </tr>
  </table>

</body>
</html>



//Properties

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.defer-datasource-initialization=true

//tester avec localhost:8080/accounts puis localhost:8080/h2-console (pour la bd)

//base de donnee est embarque avec et du coup les save se font la, et pas besoin de faire de classe qui implemente le l'interface repository Spring Data JPA fournit une implémentation de cette interface à l'exécution
