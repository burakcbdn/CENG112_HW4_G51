import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            //getting all lines from file.
            Path path = Paths.get("src/CENG112_HW4_CafeMenu.txt");
            List<String> lines = Files.readAllLines(path);
            int count = 0;
            for (String line : lines) {

                if (line != null && !line.isEmpty()) {
                    //Parsing the line
                    String[] parsedInstruction = line.split(",");
                    String itemType = parsedInstruction[0];
                    String itemName = parsedInstruction[1];
                    int itemPrice = Integer.parseInt(parsedInstruction[2]);
                    String itemSize = parsedInstruction[3];



                    switch (itemType) {
                        case "Coffee":
                            Coffee coffee = new Coffee(itemName, itemPrice, itemSize);
                            binarySearchTree.add(coffee);

                            break;

                        case "Tea":
                            Tea tea = new Tea(itemName, itemPrice, itemSize);
                            binarySearchTree.add(tea);

                            break;
                        case "Frappuccino":
                            Frappuccino frappuccino = new Frappuccino(itemName, itemPrice, itemSize);
                            binarySearchTree.add(frappuccino);

                            break;
                        case "Bakery":
                            Bakery bakery = new Bakery(itemName, itemPrice, Integer.parseInt(itemSize));
                            binarySearchTree.add(bakery);

                            break;
                    }


                }
            }
            binarySearchTree.show();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ignored");
        }

    }
}
