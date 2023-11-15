import controller.ConstructorInjected;
import controller.PropertyInjected;
import service.GreetingService;
import service.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        GreetingService service = new ServiceImpl();

        ConstructorInjected constructorInjected = new ConstructorInjected(service);

        PropertyInjected propertyInjected = new PropertyInjected();

        propertyInjected.service = service;
    }
}