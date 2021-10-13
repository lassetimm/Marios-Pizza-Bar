import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Pizza> PizzasToOrder = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    private static java.lang.Object scan;

    //All pizzas
    Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese", "Oregano"});
    Pizza vesuvio = new Pizza ("Vesuvio", 57, 2, new String[]{"Tomatoes", "Cheese", "Ham", "Oregano"});
    Pizza hawaii = new Pizza ("Hawaii", 60, 3, new String[]{"Tomatoes", "Cheese", "Ham", "Pineapple", "Oregano"});
    Pizza pepperoni = new Pizza ("Pepperoni", 61, 4, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Oregano"});
    Pizza carbona = new Pizza ("Carbona", 65, 5, new String[]{"Tomatoes", "Cheese", "Bolognese", "Spaghetti", "Sausage", "Oregano"});
    Pizza leBlissola = new Pizza ("Le Blissola", 62, 6, new String[]{"Tomatoes", "Cheese", "Ham", "Prawns", "Oregano"});
    Pizza silvia = new Pizza ("Silvia", 65, 7, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Bell Pepper", "Onions", "Olives", "Oregano"});

    //All Ingredients available
    String[] extras = {"Cheese", "Oregano", "Ham", "Pineapple", "Pepperoni", "Bolognese", "Spaghetti", "Sausage", "Prawns", "Bell Pepper", "Onions", "Olives"};



    static void takeNewOrder(){

        Order newOrder;

        System.out.println("Insert the following infomation");
        System.out.println("    - Customer name:");
        String customerName = scan.nextLine();
        System.out.println("    - Customer Phone Number:");
        String customerPhoneNum = scan.nextLine();
        System.out.println("    - time of pickup:");
        String timeOfPickup = scan.nextLine();
        System.out.println("    - What pizzas:\n" +
                "Press q when your done");

        while (scan.hasNextInt()){

            System.out.println(primaryMenu.toString());
            int pizzaNumber = validateUserIntInput(1, primaryMenu.getListOfPizzas().length);
            PizzasToOrder.add(primaryMenu.getPizzaFromListOfPizzas(pizzaNumber));
            System.out.println(primaryMenu.getPizzaFromListOfPizzas(pizzaNumber));
        }

        newOrder = new Order(PizzasToOrder, customerName, customerPhoneNum, timeOfPickup);
        stats.addToListOfOrders(new Order(PizzasToOrder, customerName, customerPhoneNum, timeOfPickup));
        System.out.println(newOrder.toString());

    }

    static int validateUserIntInput(int minValue, int maxValue){
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = scan.nextInt();
                if (returnNum >= minValue && returnNum <= maxValue){
                    run = false;
                }
                else {
                    System.out.println("The number has to be between " + (minValue - 1) + " and " + (maxValue + 1));
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                scan.next();
            }
        }
        return returnNum;
    }

    private static void callOptions(){
        System.out.println("What do you want to do?");
        System.out.println("Press 1 for: Make new order.");
        System.out.println("Press 2 for: Delete order");
        System.out.println("Press 3 for: Move order from \"notServed\" to \"Served\" list");
        System.out.println("Press 4 for: End day");
    }



    public static void main(String[] args) {
        Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese"});


        Order oneOneTwo = new Order(new Pizza[]{margarita, margarita},"Lasse","112", "7:30");

        System.out.println(oneOneTwo);

    }

}
