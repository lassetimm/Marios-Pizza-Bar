import java.util.ArrayList;

public class Statistics {

    static Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese", "Oregano"});
    static Pizza vesuvio = new Pizza ("Vesuvio", 57, 2, new String[]{"Tomatoes", "Cheese", "Ham", "Oregano"});
    static Pizza hawaii = new Pizza ("Hawaii", 60, 3, new String[]{"Tomatoes", "Cheese", "Ham", "Pineapple", "Oregano"});
    static Pizza pepperoni = new Pizza ("Pepperoni", 61, 4, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Oregano"});
    static Pizza carbona = new Pizza ("Carbona", 65, 5, new String[]{"Tomatoes", "Cheese", "Bolognese", "Spaghetti", "Sausage", "Oregano"});
    static Pizza leBlissola = new Pizza ("Le Blissola", 62, 6, new String[]{"Tomatoes", "Cheese", "Ham", "Prawns", "Oregano"});
    static Pizza silvia = new Pizza ("Silvia", 65, 7, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Bell Pepper", "Onions", "Olives", "Oregano"});

    static String[] pizzaNames = {margarita.getPizzaName(), vesuvio.getPizzaName(), hawaii.getPizzaName(), pepperoni.getPizzaName(), carbona.getPizzaName(), leBlissola.getPizzaName(), silvia.getPizzaName()};

    private ArrayList<Order> listOfOrders = new ArrayList<>();
    private ArrayList<Integer> pizzas = new ArrayList<Integer>();

    private int margaritaCounter = 0;
    private int vesuvioCounter = 0;
    private int hawaiiCounter = 0;
    private int pepperoniCounter = 0;
    private int carbonaCounter = 0;
    private int leBlissolaCounter = 0;
    private int silviaCounter = 0;

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
        for (int i = mostsold; i >= 0 ; i--) {
            for (int j = 0; j < pizzas.length; j++) {
                if (i == pizzas[j]){
                    System.out.println(pizzaNames[j] + " has been sold " + i + " times");
                }
            }
        }
        calculateAllPizzasAmount(pizzas);
        calculateTotalPizzaPrice();
    }


    public void calculateAllPizzasAmount(int[] pizzas){
        String totalAmountOfPizzas = "\nTotal amount of pizzas sold";
        int sum = 0;
        for (int i = 0; i < pizzas.length; i++) {
                sum += pizzas[i];
        }
        System.out.println(totalAmountOfPizzas + " '" + sum + "'");
    }

    public void calculateTotalPizzaPrice(){
        String earningsMsg = "You have earned";
        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println(earningsMsg + " " + listOfOrders.get(i).getTotalPizzaPrice() + "Kr");
        }
    }
}
