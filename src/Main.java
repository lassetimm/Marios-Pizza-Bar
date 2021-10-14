import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Pizza> PizzasToOrder = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    static ArrayList<Order> currentOrders = new ArrayList<>();


    //All pizzas
    static Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese", "Oregano"});
    static Pizza vesuvio = new Pizza ("Vesuvio", 57, 2, new String[]{"Tomatoes", "Cheese", "Ham", "Oregano"});
    static Pizza hawaii = new Pizza ("Hawaii", 60, 3, new String[]{"Tomatoes", "Cheese", "Ham", "Pineapple", "Oregano"});
    static Pizza pepperoni = new Pizza ("Pepperoni", 61, 4, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Oregano"});
    static Pizza carbona = new Pizza ("Carbona", 65, 5, new String[]{"Tomatoes", "Cheese", "Bolognese", "Spaghetti", "Sausage", "Oregano"});
    static Pizza leBlissola = new Pizza ("Le Blissola", 62, 6, new String[]{"Tomatoes", "Cheese", "Ham", "Prawns", "Oregano"});
    static Pizza silvia = new Pizza ("Silvia", 65, 7, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Bell Pepper", "Onions", "Olives", "Oregano"});


    //Menu
    static Menu primaryMenu = new Menu(new Pizza[]{margarita, vesuvio, hawaii, pepperoni, carbona, leBlissola, silvia}, "MainMenu", Pizza.extras,10);

    //Statistic
    static Statistics stats = new Statistics();

    // =========> MADE BY CHRISTIAN <=========
    static void takeNewOrder(){

        ArrayList<Pizza> PizzasToOrder = new ArrayList<>();
        Order newOrder;

        System.out.println("========================================");
        System.out.println("|     T A K E   N E W   O R D E R      |");
        System.out.println("========================================");
        System.out.println("Insert the following infomation");
        System.out.println("    - Customer name:");
        String customerName = scan.next() + scan.nextLine();
        System.out.println("    - Customer Phone Number:");
        String customerPhoneNum = scan.next() + scan.nextLine();
        System.out.println("    - Time of pickup:");
        String timeOfPickup = scan.next() + scan.nextLine();
        System.out.println("    - What pizzas:\n" +
                "Press q when your done");
        primaryMenu.seeMenu();

        while (scan.hasNextInt()){

            int pizzaNumber = validateUserIntInput(1, primaryMenu.getListOfPizza().length);
            Pizza pizzaToOrder = primaryMenu.getPizzaFromListOfPizza(pizzaNumber - 1);
            PizzasToOrder.add(pizzaToOrder);
            chooseExstra(pizzaToOrder);
            System.out.println(pizzaToOrder);
        }

        String scannerDone = scan.next();
        newOrder = new Order(PizzasToOrder, customerName, customerPhoneNum, timeOfPickup);
        currentOrders.add(newOrder);
        stats.addToListOfOrders(newOrder);
        System.out.println(newOrder.toString());

        scan.reset();

    }
    // =========> MADE BY CHRISTIAN <=========
    static void chooseExstra(Pizza pizza){
        System.out.println("========================================");
        System.out.println("Add extra ingredients?");
        System.out.println("1. yes\n2. no\n");
        int choice = validateUserIntInput(1, 2);
        if (choice == 1){
            Pizza.viewExtras();
            System.out.println("Choose extra ingedient\nPress \'q\' to stop");
            while (scan.hasNextInt()) {
                int extraIndexNum = validateUserIntInput(1, Pizza.extras.length);
                String extraIngredient = Pizza.extras[extraIndexNum - 1];
                pizza.addToChoosenExtras(extraIngredient);
                pizza.addToPizzaPrice(primaryMenu.getExtraPrice());
            }
            String scannerDone = scan.next();
            scan.reset();
        }
    }
    // =========> MADE BY CHRISTIAN <=========
    static void viewCurrentOrders(){
        String pluralOrder = " orders";
        if (currentOrders.size() == 1){
            pluralOrder = " order";
        }

        System.out.println("========================================");
        System.out.println("|     C U R R E N T   O R D E R S      |");
        System.out.println("========================================");
        System.out.println("There are " + currentOrders.size() +  pluralOrder);
        for (int i = 1; i <= currentOrders.size(); i++) {
            System.out.println(i + ". " + currentOrders.get(i - 1));
        }
    }

    // =========> MADE BY CHRISTIAN <=========
    static void completeOrder(){

        System.out.println("========================================");
        System.out.println("|     C O M P L E T E   O R D E R      |");
        System.out.println("========================================");

        viewCurrentOrders();

        System.out.println("========================================");
        System.out.println("What order have been picked up");
        int getOrder = validateUserIntInput(1, currentOrders.size());

        currentOrders.get(getOrder - 1).setHasBeenPickedUp(true);

        for (int i = 0; i < currentOrders.size(); i++) {

            if (currentOrders.get(i).getHasBeenPickedUp()){
                stats.addToListOfOrders(currentOrders.get(i));
                currentOrders.remove(i);
                break;
            }
        }
    }

    // =========> MADE BY CHRISTIAN <=========
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
                    System.out.println("The number has to be between " + (minValue) + " and " + (maxValue));
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
        System.out.println("Press 2 for: Change existing order.");
        System.out.println("Press 3 for: Delete order.");
        System.out.println("Press 4 for: Move order from \"notServed\" to \"Served\" list.");
        System.out.println("Press 5 for: Show menu");
        System.out.println("Press 6 for: Show today's current stats.");
        System.out.println("Press 7 for: End day.");
    }

    public static boolean getChoice(){
        callOptions();
        int choice = validateUserIntInput(1, 7);
        doChoice(choice);
        if (choice == 7){
            return false;
        }
        else{
            return true;
        }
    }




    public static void removeOrder(String orderToDelete){
        for (int i = 0; i <currentOrders.size(); i++) {
            if (currentOrders.get(i).getCustomerPhoneNumber().equals(orderToDelete)) {
                currentOrders.remove(i);
            }
        }
    }

    public static void changeOrder(String orderToChange){
        for (int i = 0; i <currentOrders.size(); i++) {
            if (currentOrders.get(i).getCustomerPhoneNumber().equals(orderToChange)) {
            }
        }
    }

    static void doChoice(int choice){
        switch (choice){
            case 1:
                takeNewOrder();
                break;
            case 2:
                //Change existing order
                System.out.println("You are in: 2");
                break;
            case 3:
                //Delete order
                //String phoneNumberToDelete = getPhoneNumber();
                //removeOrder(phoneNumberToDelete);
                break;
            case 4:
                //Move order from "notServed" to "served"
                System.out.println("You are in: 4");
                break;
            case 5:
                //See menu
                primaryMenu.seeMenu();
                break;
            case 6:
                //Show today's current stats
                System.out.println("You are in: 6");
                break;
            case 7:
                //End day
                System.out.println("You are in: 7");
                break;
        }
    }



    public static void main(String[] args) {
        boolean choice = true;
        while (choice){
            choice = getChoice();
        }

    }
}
