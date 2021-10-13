import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
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

        //Menu is created with all the pizzas and all the extras that are available
        Menu menu = new Menu(new Pizza[]{vesuvio, hawaii, pepperoni, carbona, leBlissola, silvia}, "Mainmenu", extras, 8);


        Order oneOneTwo = new Order(new Pizza[]{margarita, margarita},"Lasse","112", "7:30");

        menu.seeMenu();

        boolean day = true;
        while (day){
            System.out.println();
            int choice = getChoice();
            switch (choice){
                case 1:
                    //Make order
                    System.out.println("You are in \"Make order\"");
                    break;
                case 2:
                    //Delete order
                    System.out.println("You are in \"Delete order\"");
                    break;
                case 3:
                    //Move order from "notServed" to "Served".
                    System.out.println("You are in \"Move order\"");
                    break;
                case 4:
                    //End day
                    System.out.println("You are in \"End day\"");
                    day = false;
                    break;
                    
            }

        }
    }

    private static void callOptions(){
        System.out.println("What do you want to do?");
        System.out.println("Press 1 for: Make new order.");
        System.out.println("Press 2 for: Delete order");
        System.out.println("Press 3 for: Move order from \"notServed\" to \"Served\" list");
        System.out.println("Press 4 for: End day");
    }

    private static int getChoice(){
        int choice = 0;
        while (true) {
            callOptions();
            try {
                choice = scanner.nextInt();
                if (choice > 0 && choice < 5) {
                    System.out.println("You chose: " + choice);
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException inputWrong) {
                scanner.nextLine();
                System.out.println("Please only choose a number from 1 - 4 ");
            }
        }
        return choice;
    }

}
