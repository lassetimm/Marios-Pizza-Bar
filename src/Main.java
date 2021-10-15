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

		ArrayList<Pizza> pizzasToOrder = new ArrayList<>();
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


		ArrayList<Pizza> pizzasToAdd = makeNewPizzas();
		for (int i = 0; i < pizzasToAdd.size(); i++) {

			pizzasToOrder.add(pizzasToAdd.get(i));
		}

		String scannerDone = scan.next();
		newOrder = new Order(pizzasToOrder, customerName, customerPhoneNum, timeOfPickup);
		currentOrders.add(newOrder);
		System.out.println(newOrder.toString());
		System.out.println();

		scan.reset();

	}
    // =========> MADE BY CHRISTIAN <=========
	static ArrayList<Pizza> makeNewPizzas(){
		ArrayList<Pizza> pizzasToOrder = new ArrayList<>();

		System.out.println("    - What pizza to add to order:\n" +
				"Press q when your done");
		primaryMenu.seeMenu();
		System.out.println("\n\n\n");

		while (scan.hasNextInt()){

			int pizzaNumber = validateUserIntInput(1, primaryMenu.getListOfPizza().length);
			Pizza pizzaToAdd = primaryMenu.getPizzaFromListOfPizza(pizzaNumber - 1);
			chooseExstra(pizzaToAdd);
			pizzasToOrder.add(pizzaToAdd);
			System.out.println(pizzaToAdd);
		}
		return pizzasToOrder;
	}

	// =========> MADE BY CHRISTIAN <=========
	static void chooseExstra(Pizza pizza){
		System.out.println("========================================");
		System.out.println("Add extra ingredients?");
		System.out.println("1. Yes\n2. No\n");
		int choice = validateUserIntInput(1, 2);
		if (choice == 1){
			Pizza.viewExtras();
			System.out.println("\nChoose extra ingedient\nPress \'q\' to stop");
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
		System.out.println("There are " + currentOrders.size() +  pluralOrder + "\n");
		for (int i = 1; i <= currentOrders.size(); i++) {
			System.out.println(i + ". " + currentOrders.get(i - 1) + "\n");
		}
        System.out.println("========================================\n");
	}

	static void printCurrentOrders(){
		for (int i = 1; i <= currentOrders.size(); i++) {
			System.out.println(i + ". " + currentOrders.get(i - 1) + "\n");
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
                "\nPress 4 for: Move order from \"currentOrder\" to \"Stats\" list." +
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

    public static void changeOrder(){
        System.out.println("========================================");
        System.out.println("|       C H A N G E   O R D E R        |");
        System.out.println("========================================");
        System.out.println();
        printCurrentOrders();
        System.out.println("Choose an order to change");
        int orderChoice = validateUserIntInput(1, currentOrders.size());
        Order chosenOrder = currentOrders.get(orderChoice - 1);
        chosenOrder.printOrder();
        System.out.println("What do you want to change");
        int choice = validateUserIntInput(1, 4);
        switch (choice){

            case 1:// Pizzas

                System.out.println("1. Choose a pizza to change:");
                System.out.println("2. Add new pizza to order?");
                int actionChoice = validateUserIntInput(1, 2);
                if (actionChoice == 2){
                    ArrayList<Pizza> pizzasToAdd = makeNewPizzas();
                    for (int i = 0; i < pizzasToAdd.size(); i++) {

                        chosenOrder.addPizzaToOrder(pizzasToAdd.get(i));
                    }
                }
                else{
                    System.out.println(chosenOrder.returnStringListOfPizzas());
                    System.out.println("1. Choose pizza:");
                    int pizzaChoice = validateUserIntInput(1, chosenOrder.getListOfPizzas().size());
                    Pizza chosenPizza = chosenOrder.getListOfPizzas().get(pizzaChoice - 1);
                    System.out.println("1. Remove pizza?");
                    System.out.println("2. Change exstras?");
                    int actionChoice1 = validateUserIntInput(1, 2);
                    if (actionChoice1 == 1){
                        chosenOrder.getListOfPizzas().remove(chosenPizza);
                    }
                    else if (actionChoice1 == 2){
                        chosenPizza.getChoosenExtras().clear();
                        chooseExstra(chosenPizza);
                    }
                }
                break;
            case 2:// customer name
                System.out.println("Current name " + chosenOrder.getCustomerName());
                System.out.println("Change to ->\n");
                String newCustomerName = scan.next() + scan.nextLine();
                chosenOrder.setCustomerName(newCustomerName);
                break;
            case 3:// customer phoneNo.
                System.out.println("Current phoneNo. " + chosenOrder.getCustomerPhoneNumber());
                System.out.println("Change to ->\n");
                String newCustomerPhoneNo = scan.next() + scan.nextLine();
                chosenOrder.setCustomerPhoneNumber(newCustomerPhoneNo);
                break;
            case 4:// time of pickup
                System.out.println("Current time of pickup " + chosenOrder.getTimeOfPickUp());
                System.out.println("Change to ->\n");
                String newPickupTime = scan.next() + scan.nextLine();
                chosenOrder.setTimeOfPickUp(newPickupTime);
                break;
        }
        if (chosenOrder.getListOfPizzas().size() == 0){
            currentOrders.remove(chosenOrder);
        }

    }
    // =========> MADE BY JOHANNES <=========
    static void doChoice(int choice){
        switch (choice){
            case 1:
                takeNewOrder();
                break;
            case 2:
                changeOrder();
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
