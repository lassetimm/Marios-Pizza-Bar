import java.util.ArrayList;
import java.util.Arrays;
public class Pizza {
    private String pizzaName;
    private int pizzaPrice;
    private int pizzaNumber;
    private String[] ingredients;
    static final String[] extras = {"Cheese", "Oregano", "Ham", "Pineapple", "Pepperoni", "Bolognese", "Spaghetti", "Sausage", "Prawns", "Bell Pepper", "Onions", "Olives"};

    private ArrayList<String> choosenExtras = new ArrayList<>();



    public Pizza(String pizzaName, int pizzaPrice, int pizzaNumber, String[] ingredients) {
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaNumber = pizzaNumber;
        this.ingredients = ingredients;
    }



    public String[] getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String[] ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getPizzaName()
    {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName)
    {
        this.pizzaName = pizzaName;
    }

    public int getPizzaPrice()
    {
        return pizzaPrice;
    }

    public void setPizzaPrice(int pizzaPrice)
    {
        this.pizzaPrice = pizzaPrice;
    }
    public void addToPizzaPrice(int pizzaPrice)
    {
        this.pizzaPrice += pizzaPrice;
    }

    public int getPizzaNumber()
    {
        return pizzaNumber;
    }

    public void setPizzaNumber(int pizzaNumber)
    {
        this.pizzaNumber = pizzaNumber;
    }


    static void viewExtras(){

        for (int i = 1; i <= extras.length; i++) {
            System.out.println(i + ". " + extras[i - 1]);
        }
    }

    public ArrayList<String> getChoosenExtras() {
        return choosenExtras;
    }

    public void addToChoosenExtras(String extra) {
        this.choosenExtras.add(extra);
    }

    @Override
    public String toString() {
        String toReturn = "Pizza {" +
                "Name = '" + pizzaName + '\'' +
                ", Price = " + pizzaPrice + ",-" +
                ", Number = " + pizzaNumber +
                ", Ingredients = " + Arrays.toString(ingredients) +
                ", Exstras = " + getChoosenExtras() +
                '}';
        if (choosenExtras.size() == 0){
            toReturn = "Pizza {" +
                    "Name = '" + pizzaName + '\'' +
                    ", Price = " + pizzaPrice + ",-" +
                    ", Number = " + pizzaNumber +
                    ", Ingredients = " + Arrays.toString(ingredients) +
                    '}';
        }

        return toReturn;
    }
}
