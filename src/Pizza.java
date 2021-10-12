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

    public String getPizzaName()
    {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName)
    {
        this.pizzaName = pizzaName;
    }

    public void setPizzaPrice(int pizzaPrice)
    {
        this.pizzaPrice = pizzaPrice;
    }

    public int getPizzaNumber()
    {
        return pizzaNumber;
    }

    public void setPizzaNumber(int pizzaNumber)
    {
        this.pizzaNumber = pizzaNumber;
    }

    public String[] getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String[] ingredients)
    {
        this.ingredients = ingredients;
    }

    @Override



    public String toString() {
        return "Pizza{" +
                "Name='" + pizzaName + '\'' +
                ", Price=" + pizzaPrice +
                ", Number=" + pizzaNumber +
                ", Ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
