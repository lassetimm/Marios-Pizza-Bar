import java.util.ArrayList;

public class Order { // =========> MADE BY CHRISTIAN <=========

//================================ATRIBUTES===================================================

    private String customerName;
    private String customerPhoneNumber;
    private String timeOfPickUp;
    private int totalPizzaPrice;
    private boolean hasBeenPickedUp = false;
    private ArrayList<Pizza> listOfPizzas = new ArrayList<>();

//================================CONSTRUCTOR===================================================

    public Order(ArrayList<Pizza> listOfPizzas, String customerName, String customerPhoneNumber, String timeOfPickUp) {
        this.listOfPizzas = listOfPizzas;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.timeOfPickUp = timeOfPickUp;

        for (Pizza pizza: listOfPizzas) {
            totalPizzaPrice += pizza.getPizzaPrice();
        }
    }


//================================CLASS METHODS===================================================

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }


    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }


    public void setTimeOfPickUp(String timeOfPickUp) {
        this.timeOfPickUp = timeOfPickUp;
    }

    public String getTimeOfPickUp() {
        return timeOfPickUp;
    }


    public int getTotalPizzaPrice() {
        return totalPizzaPrice;
    }

    public void addTotalPizzaPrice(int totalPizzaPrice) {
        this.totalPizzaPrice += totalPizzaPrice;
    }


    public void setHasBeenPickedUp(boolean hasBeenPickedUp) {
        this.hasBeenPickedUp = hasBeenPickedUp;
    }

    public boolean getHasBeenPickedUp() {
        return hasBeenPickedUp;
    }


    public ArrayList<Pizza> getListOfPizzas() {
        return listOfPizzas;
    }

    public String returnStringListOfPizzas() {
        String listOfPizzasToReturn = "";
        for (int i = 0; i < listOfPizzas.size(); i++) {
            listOfPizzasToReturn += ((i + 1) + ". " + listOfPizzas.get(i) + "\n");
        }
        return listOfPizzasToReturn;
    }


    public void printOrder(){
        System.out.println();
        System.out.println("1. Ordered pizzas:      " + getListOfPizzas());
        System.out.println("2. Customer name:       " + customerName);
        System.out.println("3. Customer phoneNo.:   " + customerPhoneNumber);
        System.out.println("4. Time of pickup       " + timeOfPickUp);
        System.out.println();

    }

    public void addPizzaToOrder(Pizza pizzaToAdd){
        listOfPizzas.add(pizzaToAdd);
    }


    @Override
    public String toString() {

        String pizzas = "";

        for (Pizza pizza : listOfPizzas) {

            pizzas +=  pizza.toString() + "\n" + "                 -   ";
        }

        return  "OrderNo.: " + customerPhoneNumber +
                "\nPizzas           -   " + pizzas +
                "\nTotal Price      -   " + totalPizzaPrice + ",-" +
                "\nCustomer Name    -   " + customerName +
                "\nTime Of Pickup   -   " + timeOfPickUp +
                "\nPicked Up?       -   " + hasBeenPickedUp;
    }


}
