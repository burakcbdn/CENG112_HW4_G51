public class Frappuccino implements IItem{
    private String frappuccinoName;
    private int frappuccinoPrice;
    private String frappuccinoSize;

    public Frappuccino(String frappuccinoName, int frappuccinoPrice, String frappuccinoSize) {
        this.frappuccinoName = frappuccinoName;
        this.frappuccinoPrice = frappuccinoPrice;
        this.frappuccinoSize = frappuccinoSize;
    }

    private String frappuccinoSize(){
        return null;
    }

    @Override
    public String itemName() {
        return frappuccinoName;
    }

    @Override
    public String itemType() {
        return "Frappuccino";
    }

    @Override
    public int itemPrice() {
        return frappuccinoPrice;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public String getSize() {
        return frappuccinoSize;
    }

    public String toString(){
        return null;
    }
}
