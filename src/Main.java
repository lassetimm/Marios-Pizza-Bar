public class Main {
    public static void main(String[] args) {
        Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese"});
        Pizza vesuvio = new Pizza ("Vesuvio", 57, 2, new String[]{"Tomatoes", "Cheese", "Ham", "Oregano"});
        Pizza hawaii = new Pizza ("Hawaii", 60, 3, new String[]{"Tomatoes", "Cheese", "Ham", "Pineapple", "Oregano"});


        Order oneOneTwo = new Order(new Pizza[]{margarita, margarita},"Lasse","112", "7:30");

        System.out.println(oneOneTwo);

    }

}
