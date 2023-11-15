/*DEMARRAGE PROJET : SPRING INITIALIZER DEPENDANCES THYMELEAF + WEB */

//Architecture service et config(instancie model en dehors du package) et controller et model dedans

//HTML

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Cool Message</title>
</head>
<body>
<p th:text="'Message  : ' + ${message}" />
</body>
</html>
