//DEMARRAGE PROJET / SPRING INITIALIZER DEPENDANCE : WEB


//un peu comme le 1.3 sauf qu'ici on va faire un post

package be.hepl.webservicepost;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private ArrayList<CoffeeOrder> orders = new ArrayList<>();

    @PostMapping("/order")
    public String order(@RequestBody CoffeeOrder coffeeOrder)
    {
        orders.add(coffeeOrder);
        return "Commande Effectuee";
    }

    @GetMapping("/orders")
    public ArrayList<CoffeeOrder> getOrders()
    {
        return orders;
    }


    public static class CoffeeOrder
    {
        private String coffeeType;
        private String customerName;
        private int quantity;

        public String getCoffeeType() {
            return coffeeType;
        }

        public void setCoffeeType(String coffeeName) {
            this.coffeeType = coffeeName;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}

//classe static veut dire qu'elle est pas accessible en dehors du controller mais en soit ca ne change pas grand chose

//sinon comme d'habitude RestController donc instancier directement par spring +  possibilite de renvoyer des donnees

//Classe qui envoie la requete

package be.hepl.webservicepost;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

        String apiUrl = "http://localhost:8090/coffee/order";
        String requestBody = "{\"customerName\":\"Gaston\",\"coffeeType\":\"Espresso\",\"quantity\":2}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Code HTTP de réponse : " + response.statusCode());
            System.out.println("Réponse (Body) du serveur : " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//attention mettre le port dans le properties (si pas 8080)

server.port=8090