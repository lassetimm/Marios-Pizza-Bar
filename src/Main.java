import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // =========> MADE BY ALL <=========
    static Scanner scan = new Scanner(System.in);


    static ArrayList<Order> currentOrders = new ArrayList<>();


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
    static Statistics stats = new Statistics(primaryMenu);

    //=============================================================METHODS=======================================================

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
        System.out.println(newOrder.toString());

        scan.reset();

    }
    // =========> MADE BY CHRISTIAN <=========
    static void chooseExstra(Pizza pizza){
        System.out.println("========================================");
        System.out.println("Add extra ingredients?");
        System.out.println("1. Yes\n2. No\n");
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

    // =========> MADE BY JOHANNES <=========
    private static void callOptions(){
        System.out.println("What do you want to do?" +
                "\nPress 1 for: Make new order." +
                "\nPress 2 for: Change existing order." +
                "\nPress 3 for: Delete order." +
                "\nPress 4 for: Pickup order." +
                "\nPress 5 for: Show menu" +
                "\nPress 6 for: Show current orders" +
                "\nPress 7 for: Show today's current stats." +
                "\nPress 8 for: End day.");
    }

    // =========> MADE BY JOHANNES <=========
    public static boolean getChoice(){
        callOptions();
        int choice = validateUserIntInput(1, 8);
        doChoice(choice);
        if (choice == 8 && currentOrders.size() == 0){
            stats.countAndSortPizzasFromOrders();
            stats.payEmployees(stats.calculateTotalPizzaPrice2());
            return false;
        }
        else{
            return true;
        }
    }

    // =========> MADE BY ELLA <=========
    public static void removeOrder(){
            System.out.println("========================================");
            System.out.println("|      D E L E T E   O R D E R         |");
            System.out.println("========================================");
            viewCurrentOrders();
            System.out.println("========================================");
            System.out.println("What order has been cancelled?");
            int getOrder = validateUserIntInput(0, currentOrders.size());
            currentOrders.remove(getOrder - 1);
            System.out.println("Order " + getOrder + " has now been deleted.");
    }

    public static void changeOrder(String orderToChange){
        for (int i = 0; i <currentOrders.size(); i++) {
            if (currentOrders.get(i).getCustomerPhoneNumber().equals(orderToChange)) {
            }
        }
    }

    // =========> MADE BY JOHANNES <=========
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
                if (currentOrders.size() > 0) {
                    removeOrder();
                }
                else{
                    System.out.println("You don't have any orders in your system.");
                }
                break;
            case 4:
                completeOrder();
                break;
            case 5:
                primaryMenu.seeMenu();
                break;
            case 6:
                viewCurrentOrders();
                break;
            case 7:
                stats.countAndSortPizzasFromOrders();
                stats.exitStatistics();
                break;
            case 8:
                String endDay = currentOrders.size() == 0 ? "After a long day of work, you can finally go home" : "You cannot end the day when orders still need to be made. Make the rest and then go home.";
                System.out.println(endDay);
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
