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
        return null;
    }

    @Override
    public int itemPrice() {
        return coffePrice;
    }

    public String toString(){
        return null;
    }


}
