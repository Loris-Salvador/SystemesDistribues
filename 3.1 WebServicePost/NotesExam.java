//DEMARRAGE PROJET / SPRING INITIALIZER DEPENDANCE : WEB

//Post d'une commande de caffee + get d'une ArrayList

//Json pour faire la request

{\"customerName\":\"Gaston\",\"coffeeType\":\"Espresso\",\"quantity\":2} 


HttpClient httpClient = HttpClient.newHttpClient();

String apiUrl = "http://localhost:8090/coffee/order";
String requestBody = "{\"customerName\":\"Gaston\",\"coffeeType\":\"Espresso\",\"quantity\":2}";

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(apiUrl))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
        .build();

HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(response.body());