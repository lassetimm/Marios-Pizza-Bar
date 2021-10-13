import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    private Pizza[] listOfPizzas;
    private int totalPizzaPrice;
    private String customerName;
    private String customerPhoneNumber;
    private String timeOfPickUp;
    private boolean hasBeenPickedUp = false;

    public Order(Pizza[] listOfPizzas, String customerName, String customerPhoneNumber, String timeOfPickUp) {
        this.listOfPizzas = listOfPizzas;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.timeOfPickUp = timeOfPickUp;

        for (Pizza pizza: listOfPizzas) {
            totalPizzaPrice += pizza.getPizzaPrice();
        }
    }

    public int getTotalPizzaPrice() {
        return totalPizzaPrice;
    }

    public Pizza[] getListOfPizzas() {
        return listOfPizzas;
    }


    @Override
    public String toString() {
        return "Order{" +
                "listOfPizzas=" + Arrays.toString(listOfPizzas) +
                ", totalPizzaPrice=" + totalPizzaPrice +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", timeOfPickUp='" + timeOfPickUp + '\'' +
                ", hasBeenPickedUp=" + hasBeenPickedUp +
                '}';
    }
}
