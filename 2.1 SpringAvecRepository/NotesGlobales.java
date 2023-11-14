/* DEMARRAGE PROJET : spring intializer et ajouter dependances web, thymeleaf, data jpa, h2 db*/
 

//architecture : 4 packages : bootstrap, model, controllers, repositories

//model Account : 

package be.hepl.springavecrepository.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private long accountId;
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

//Cette interface générique est fournie par Spring Data JPA. Elle offre des méthodes CRUD (Create, Read, Update, Delete) de base pour travailler avec des entités


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
        System.out.println("wesh");
        this.accountRepository = accountRepository;
    }

    @RequestMapping("/accounts")
    public String getAccounts(Model model)
    {
        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts/list"; // bien mettre le html dans le repertoire template/accounts/
    }
}


//model.addAttribute("accounts", accountRepository.findAll()) : Cette ligne ajoute un attribut
//appelé "accounts" au modèle (Model). Cet attribut est associé à la liste des comptes récupérée à partir de accountRepository.findAll().

//InitDb

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

        System.out.println("INIT DB");
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

//pour tester rajouter des propriete a la classe account et lui faire des getters qui ont les meme nom que les attribue dans les th:text


//Properties

spring.h2.console.enabled=true

//tester avec localhost:8080/accounts puis localhost:8080/h2-console (pour la bd)
