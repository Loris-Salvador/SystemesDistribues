/* DEMARRAGE PROJET : spring intializer et ajouter dependances web, thymeleaf, data jpa, h2 db*/

//repo, model, initDb, controller

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


spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.defer-datasource-initialization=true