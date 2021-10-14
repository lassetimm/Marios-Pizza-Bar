import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {
    private Menu menu;
    private String[] pizzaNames;

    static Scanner scan = new Scanner(System.in);

    private ArrayList<Order> listOfOrders = new ArrayList<>();
    private ArrayList<Integer> pizzas = new ArrayList<Integer>();

    private int margaritaCounter = 0;
    private int vesuvioCounter = 0;
    private int hawaiiCounter = 0;
    private int pepperoniCounter = 0;
    private int carbonaCounter = 0;
    private int leBlissolaCounter = 0;
    private int silviaCounter = 0;

    public Statistics(Menu menu) {
        this.menu = menu;
        this.pizzaNames = new String[menu.getListOfPizza().length];

        for (int i = 0; i < pizzaNames.length; i++){
            pizzaNames[i] = menu.getListOfPizza()[i].getPizzaName();
        }



    }

    public void addToListOfOrders(Order Order) {
        this.listOfOrders.add(Order);
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }


    public void countAndSortPizzasFromOrders(){

        for (int i = 0; i < listOfOrders.size(); i++) {
            for (int j = 0; j < listOfOrders.get(i).getListOfPizzas().size(); j++) {
                Pizza pizza = listOfOrders.get(i).getListOfPizzas().get(j);
                switch (pizza.getPizzaNumber()) {
                    case 1 -> margaritaCounter++;
                    case 2 -> vesuvioCounter++;
                    case 3 -> hawaiiCounter++;
                    case 4 -> pepperoniCounter++;
                    case 5 -> carbonaCounter++;
                    case 6 -> leBlissolaCounter++;
                    case 7 -> silviaCounter++;
                }
            }
        }
        int[] pizzas = {margaritaCounter, vesuvioCounter, hawaiiCounter, pepperoniCounter, carbonaCounter, leBlissolaCounter, silviaCounter};
        int mostsold = 0;
        for (int i = 0; i < pizzas.length; i++){
            if (pizzas[i] > mostsold){
                mostsold = pizzas[i];
            }
        }
        System.out.println("\nYour most bought pizzas:");
        for (int i = mostsold; i >= 0 ; i--) {
            for (int j = 0; j < pizzas.length; j++) {
                if (pizzaNames[j].length() <= 8) {
                    if (i == pizzas[j]) {
                        System.out.println(pizzaNames[j] + "\t\t\t\t" + "bought " + i + " times");
                    }
                } else {
                    if (i == pizzas[j]) {
                        System.out.println(pizzaNames[j] + "\t\t\t" + "bought " + i + " times");
                    }
                }
            }
        }

        calculateTotalPizzaAmount(pizzas);
        calculateTotalPizzaPrice();
        //exitStatistics();
        margaritaCounter = 0;
        vesuvioCounter = 0;
        hawaiiCounter = 0;
        pepperoniCounter = 0;
        carbonaCounter = 0;
        leBlissolaCounter = 0;
        silviaCounter = 0;
    }

    public void calculateTotalPizzaAmount(int[] pizzas){
        String totalAmountOfPizzas = "\nTotal amount of pizzas sold:";
        int sum = 0;
        for (int i = 0; i < pizzas.length; i++) {
                sum += pizzas[i];
        }
        System.out.println(totalAmountOfPizzas + " '" + sum + "'");
    }

    public int calculateTotalPizzaPrice(){
        int totalTurnover = 0;
        String turnoverMsg = "Your turnover today is: ";
        String turnoverMsgWithTax = "Your earnings after taxes: ";
        for (int i = 0; i < listOfOrders.size(); i++) {
            totalTurnover += listOfOrders.get(i).getTotalPizzaPrice();
        }
        System.out.println(turnoverMsg + " " + totalTurnover + ",-");
         int turnoverWithTax = (totalTurnover / 4) * 3;
        System.out.println(turnoverMsgWithTax + turnoverWithTax + ",-");
        return turnoverWithTax;
    }

    public int calculateTotalPizzaPrice2(){
        int totalTurnover = 0;
        for (int i = 0; i < listOfOrders.size(); i++) {
            totalTurnover += listOfOrders.get(i).getTotalPizzaPrice();
        }
        int turnoverWithTax = (totalTurnover / 4) * 3;
        return turnoverWithTax;
    }


    public void payEmployees(int turnoverWithTax) {
        int employeeWorkingSalary = 8 * 120;
        if (turnoverWithTax >= employeeWorkingSalary) {
            String payEmployeesText = "You earned enough to pay your employees today\nDo you want to pay Alfonso? 'y' 'n'";
            System.out.println(payEmployeesText);
            String answer = scan.nextLine();
            String moneyAfterTaxAndEmployeePayText = "Your earnings after tax and employee pay: ";
            if (answer.equals("y")) {
                turnoverWithTax = turnoverWithTax - employeeWorkingSalary;
                System.out.println(moneyAfterTaxAndEmployeePayText + turnoverWithTax + ",-");
            }
        }
        else {
            String youDidntMakeEnoughToPayEmplyees = "You didnt make enough to pay your employees today";
            System.out.println(youDidntMakeEnoughToPayEmplyees);
        }
    }

    public void exitStatistics(){
        String lineBreak = "\n";
        String exitStatsText = "Press 'q' to exit stats";
        System.out.println(lineBreak + exitStatsText);
        String exitStats = scan.nextLine();
    }
}
