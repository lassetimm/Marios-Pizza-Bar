import java.util.ArrayList;
import java.util.Arrays;
public class Pizza {
    private String pizzaName;
    private int pizzaPrice;
    private int pizzaNumber;
    private String[] ingredients;



    public Pizza(String pizzaName, int pizzaPrice, int pizzaNumber, String[] ingredients) {
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaNumber = pizzaNumber;
        this.ingredients = ingredients;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", pizzaPrice=" + pizzaPrice +
                ", pizzaNumber=" + pizzaNumber +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
