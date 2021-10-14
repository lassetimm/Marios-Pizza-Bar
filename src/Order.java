import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    private ArrayList<Pizza> listOfPizzas = new ArrayList<>();
    private int totalPizzaPrice;
    private String customerName;
    private String customerPhoneNumber;
    private String timeOfPickUp;
    private boolean hasBeenPickedUp = false;

    public Order(ArrayList<Pizza> listOfPizzas, String customerName, String customerPhoneNumber, String timeOfPickUp) {
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

    public ArrayList<Pizza> getListOfPizzas() {
        return listOfPizzas;
    }

    public boolean getHasBeenPickedUp() {
        return hasBeenPickedUp;
    }

    public void setHasBeenPickedUp(boolean hasBeenPickedUp) {
        this.hasBeenPickedUp = hasBeenPickedUp;
    }

    @Override
    public String toString() {

        String pizzas = "";

        for (Pizza pizza : listOfPizzas) {

            pizzas +=  pizza.toString() + "\n" + "                 -   ";
        }

        return  "OrderNo.: " + customerPhoneNumber +
                "\nPizzas           -   " + pizzas +
                "\nTotal Price      -   " + totalPizzaPrice +
                "\nCustomer Name    -   " + customerName +
                "\nTime Of Pickup   -   " + timeOfPickUp +
                "\nPicked Up?       -   " + hasBeenPickedUp;
    }

    public String getCustomerPhoneNumber()
    {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber)
    {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
