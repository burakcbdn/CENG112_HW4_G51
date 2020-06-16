public class Tea implements IItem{

    private String teaName;
    private int teaPrice;
    private String teaSize;

    public Tea(String teaName, int teaPrice, String teaSize) {
        this.teaName = teaName;
        this.teaPrice = teaPrice;
        this.teaSize = teaSize;
    }

    private String teaSize(){
        return null;
    }


    @Override
    public String itemName() {
        return teaName;
    }

    @Override
    public String itemType() {
        return "Tea";
    }

    @Override
    public int itemPrice() {
        return teaPrice;
    }

    public String toString(){
        return null;
    }
}
