public class Bakery implements IItem{
    private String bakeryName;
    private int bakeryPrice;
    private int calories;

    public Bakery(String bakeryName, int bakeryPrice, int calories) {
        this.bakeryName = bakeryName;
        this.bakeryPrice = bakeryPrice;
        this.calories = calories;
    }

    @Override
    public String itemName() {
        return bakeryName;
    }

    @Override
    public String itemType() {
        return "Bakery";
    }

    @Override
    public int itemPrice() {
        return bakeryPrice;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String getSize() {
        return null;
    }

    public String toString(){
        return null;
    }
}
