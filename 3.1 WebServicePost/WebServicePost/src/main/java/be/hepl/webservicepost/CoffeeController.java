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