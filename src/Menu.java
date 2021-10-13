public class Menu {
    private Pizza[] listOfPizzas;
    private String menuName;
    private String[] extras;
    private int extraPrice;

    public Menu(Pizza[] listOfPizzas, String menuName, String[] extras, int extraPrice) {
        this.listOfPizzas = listOfPizzas;
        this.menuName = menuName;
        this.extras = extras;
        this.extraPrice = extraPrice;
    }


    public Pizza[] getListOfPizzas() {
        return listOfPizzas;
    }

    public Pizza getPizzaFromListOfPizzas(int indexNumber) {
        return listOfPizzas[indexNumber];
    }
}
