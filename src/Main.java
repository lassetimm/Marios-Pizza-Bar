public class Main {
    public static void main(String[] args) {
        Pizza margarita = new Pizza ("Margarita", 57, 1,new String[]{"Tomatoes", "Cheese", "Oregano"});
        Pizza vesuvio = new Pizza ("Vesuvio", 57, 2, new String[]{"Tomatoes", "Cheese", "Ham", "Oregano"});
        Pizza hawaii = new Pizza ("Hawaii", 60, 3, new String[]{"Tomatoes", "Cheese", "Ham", "Pineapple", "Oregano"});
        Pizza pepperoni = new Pizza ("Pepperoni", 61, 4, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Oregano"});
        Pizza carbona = new Pizza ("Carbona", 65, 5, new String[]{"Tomatoes", "Cheese", "Bolognese", "Spaghetti", "Sausage", "Oregano"});
        Pizza leBlissola = new Pizza ("Le Blissola", 62, 6, new String[]{"Tomatoes", "Cheese", "Ham", "Prawns", "Oregano"});
        Pizza silvia = new Pizza ("Silvia", 65, 7, new String[]{"Tomatoes", "Cheese", "Pepperoni", "Bell Pepper", "Onions", "Olives", "Oregano"});


        Order oneOneTwo = new Order(new Pizza[]{margarita, margarita},"Lasse","112", "7:30");

        String[] extras = {"Cheese", "Oregano", "Ham", "Pineapple", "Pepperoni", "Bolognese", "Spaghetti", "Sausage", "Prawns", "Bell Pepper", "Onions", "Olives"};
        Menu menu = new Menu(new Pizza[]{vesuvio, hawaii, pepperoni, carbona, leBlissola, silvia}, "Mainmenu", extras, 8);
        menu.seeMenu();

    }

}
