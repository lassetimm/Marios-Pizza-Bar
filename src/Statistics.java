public class Statistics {
    private Order[] listOfOrders;


    public void addToListOfOrders(Order Order) {
        this.listOfOrders.add(Order);
    }

    public Order[] getListOfOrders() {
        return listOfOrders;
    }

    ArrayList<Integer> pizzas = new ArrayList<Integer>();

    public void numberOfPizzas(){
        int margarino = 0;
        int vesuvio = 0;
        int hawaii = 0;
        int pepperoni = 0;
        int carbona = 0;
        int leBlissola = 0;
        int silvia = 0;
        for (int i = 0; i < listOfOrders.length; i++) {
            for (int j = 0; j < listOfOrders[i].getListOfPizzas().length; j++) {
                Pizza pizza = listOfOrders[i].getListOfPizzas()[j];
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
        for (int i = 0; i < listOfOrders.length; i++) {
            System.out.println(listOfOrders[i].getTotalPizzaPrice());
        }
    }
}
