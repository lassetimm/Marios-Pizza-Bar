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

    //Metode som returnere et array af alle pizzaer på menuen.
    public Pizza[] getListOfPizza() {
        return listOfPizza;
    }

    public Pizza getPizzaFromListOfPizza(int indexNumber){
        return listOfPizza[indexNumber];
    }

    //Metode til at printe hele menuen så den står ligesom i beskrivelsen på Marios Pizzabar.
    public void seeMenu(){
        //For hver pizza printes der en linje.
        for (int i = 0; i < listOfPizza.length; i++){
            System.out.println();
            Pizza pizza = listOfPizza[i];

            //Pizza nummer printes
            System.out.printf(i + 1 + ". ");

            //Pizza navn printes og alt afhængig af hvor langt det er printes der 2 eller 3 tabs, så ingridienserne kommer på linje.
            if(listOfPizza[i].getPizzaName().length() < 8){
                System.out.printf(pizza.getPizzaName() + "\t\t\t");
            }
            else {
                System.out.printf(pizza.getPizzaName() + "\t\t" );
            }

            //Ingridienserne printes på linje efterfulgt af et komma undtaget efter sidste ingridiens
            String ingredients = "";
            for (int x = 0; x < pizza.getIngredients().length; x++){
                if (x == pizza.getIngredients().length - 1){
                    ingredients += pizza.getIngredients()[x] + "";
                }
                else{
                    ingredients += pizza.getIngredients()[x] + ", ";
                }
            }
            System.out.printf(ingredients);

            //For at alligne prisen printer jeg et bestemt antal tabs afhængig af hvor mange ingridienser der var
            int lengthOfIngredientsString = ingredients.length();
            lengthOfIngredientsString = (75 - lengthOfIngredientsString) / 4;
            for (int y = 0; y < lengthOfIngredientsString; y++){
                System.out.printf("\t");
            }
            System.out.printf(pizza.getPizzaPrice() + ",-");
        }

    }

    public void seeExtras(){
        //Printer alle extra items under menuen

        System.out.println("\n\nExtra topping cost 10 kr.\nYou can choose form these items:");
        for (int i = 0; i < extras.length; i++) {
            if (i == extras.length - 1){
                System.out.printf("" + extras[i]);
            }
            else {
                System.out.printf(extras[i] + ", ");
            }

        }
        System.out.println("\n\n\n");

    }

    //metode som returnere menuName
    public String getMenuName() {
        return menuName;
    }

    //Giver meuen et nyt navn som man tildeler den
    public void setMenuName(String name){
        this.menuName = name;
    }

    //Metode som printer alle extra ting man kan tilkøbe
    public void getExtras() {
        for (int i = 0; i < listOfPizza.length; i++){
            System.out.println(extras[i]);
        }
    }

    //Metode som returnere extraPrice
    public int getExtraPrice() {
        return extraPrice;
    }

    //Sætter den nye extraPrice til det man indtaster
    public void setExtraPrice(int newPrice){
        this.extraPrice = newPrice;
    }


}