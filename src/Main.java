public class Main {
    public static void main(String[] args) {
        Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese"});


        Order oneOneTwo = new Order(new Pizza[]{margarita, margarita},"Lasse","112", "7:30");

        System.out.println(oneOneTwo);

    }

}
