public class Menu {
    private Pizza[] listOfPizza;
    private String menuName;
    private String[] extras;
    private int extraPrice;

    public Menu(Pizza[] listOfPizza, String menuName, String[] extras, int extraPrice) {
        this.listOfPizza = listOfPizza;
        this.menuName = menuName;
        this.extras = extras;
        this.extraPrice = extraPrice;
    }
}
