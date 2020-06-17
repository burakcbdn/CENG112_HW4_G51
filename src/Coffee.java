public class Coffee implements IItem {

    private String coffeeName;
    private int coffePrice;
    private String coffeSize;

    public Coffee(String coffeeName, int coffePrice, String coffeSize) {
        this.coffeeName = coffeeName;
        this.coffePrice = coffePrice;
        this.coffeSize = coffeSize;
    }

    private String coffeeSize(){
        return null;
    }


    @Override
    public String itemName() {
        return coffeeName;
    }

    @Override
    public String itemType() {
        return "Coffee";
    }

    @Override
    public int itemPrice() {
        return coffePrice;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public String getSize() {
        return coffeSize;
    }

    public String toString(){
        return null;
    }


}
