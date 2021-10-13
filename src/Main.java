import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    static ArrayList<Pizza> PizzasToOrder = new ArrayList<>();

    static Statistics stats = new Statistics();
    static Pizza margarita = new Pizza ("Margarita", 57, 1, new String[]{"Tomatoes", "Cheese"});
    static Pizza pepperroni = new Pizza ("Pepperroni", 65, 2, new String[]{"Tomatoes", "Cheese, Pepperroni"});
    static Pizza hawaii = new Pizza ("Hawaii", 60, 3, new String[]{"Tomatoes", "Cheese, Ham, Pinapple"});

    static Scanner scan = new Scanner(System.in);
    static Menu primaryMenu = new Menu(new Pizza[]{margarita, pepperroni, hawaii}, "MainMenu", Pizza.getIngredients(),10);



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


    public static void main(String[] args) {


        Pizza margarita = new Pizza ("Margarita", 57, 1, new String[]{"Tomatoes", "Cheese"});

        Order oneOneTwo = new Order(new Pizza[]{margarita, margarita},"Lasse","112", "7:30");

        System.out.println(oneOneTwo);

    }

}
