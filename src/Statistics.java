import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    private ArrayList<Order> listOfOrders = new ArrayList<>();
    private ArrayList<Integer> pizzas = new ArrayList<Integer>();

    private int margarino = 0;
    private int vesuvio = 0;
    private int hawaii = 0;
    private int pepperoni = 0;
    private int carbona = 0;
    private int leBlissola = 0;
    private int silvia = 0;

    public void addToListOfOrders(Order Order) {
        this.listOfOrders.add(Order);
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }


    public void numberOfPizzas(){

        for (int i = 0; i < listOfOrders.size(); i++) {
            for (int j = 0; j < listOfOrders.get(i).getListOfPizzas().size(); j++) {
                Pizza pizza = listOfOrders.get(i).getListOfPizzas().get(j);
                switch (pizza.getPizzaNumber()) {
                    case 1 -> margarino++;
                    case 2 -> vesuvio++;
                    case 3 -> hawaii++;
                    case 4 -> pepperoni++;
                    case 5 -> carbona++;
                    case 6 -> leBlissola++;
                    case 7 -> silvia++;
                }
            }
        }
        pizzas.add(margarino);
        pizzas.add(vesuvio);
        pizzas.add(hawaii);
        pizzas.add(pepperoni);
        pizzas.add(carbona);
        pizzas.add(leBlissola);
        pizzas.add(silvia);
        Collections.sort(pizzas);
        for(int counter: pizzas){
            System.out.println(counter);
        }
    }

/*
    public void nameForPizzaNumber(){
        for (int i = 0; i < ; i++) {

        }
    }
 */


    public void soutTotalPizzaPricePerOrder(){
        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println(listOfOrders.get(i).getTotalPizzaPrice());
        }
    }
}
