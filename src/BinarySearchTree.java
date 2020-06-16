
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Iterator;


public class BinarySearchTree implements BSTInterface<IItem> {

    public static BinaryNode<IItem> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean Contains(IItem item) {
        return getEntry(item) != null;
    }

    @Override
    public IItem getEntry(IItem item) {
        int id = item.itemPrice();
        BinaryNode<IItem> current = root;
        while (current != null) {
            if (current.getData().itemPrice() == id) {
                return current.getData();
            } else if (current.getData().itemPrice() > id) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    @Override
    public void add(IItem newItem) {
        int id = newItem.itemPrice();
        BinaryNode<IItem> newNode = new BinaryNode<IItem>(newItem);
        if (root == null) {
            root = newNode;
            return;
        }
        BinaryNode<IItem> current = root;
        BinaryNode<IItem> parent;
        while (true) {
            parent = current;
            if (id < current.getData().itemPrice()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    @Override
    public boolean remove(IItem item) {
        BinaryNode<IItem> parent = root;
        BinaryNode<IItem> current = root;
        int id = item.itemPrice();
        boolean isLeftChild = false;
        while (current.getData().itemPrice() != id) {
            parent = current;
            if (current.getData().itemPrice() > id) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                BinaryNode<IItem> right = parent.getRight();
                right = current.getLeft();
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();

            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if (current.getLeft() != null && current.getRight() != null) {
            BinaryNode<IItem> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {

                parent.setRight(successor);
            } else {

                parent.setRight(successor);
            }

            parent.setLeft(current.getLeft());
        }
        return true;
    }

    private BinaryNode<IItem> getSuccessor(BinaryNode<IItem> deleleNode) {
        BinaryNode<IItem> successsor = null;
        BinaryNode<IItem> successsorParent = null;
        BinaryNode<IItem> current = deleleNode.getRight();
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.getLeft();
        }

        if (successsor != deleleNode.getRight()) {
            assert successsorParent != null;
            successsorParent.setLeft(successsor.getLeft());
            successsorParent.setRight(deleleNode);
        }
        return successsor;
    }

    @Override
    public Iterator<IItem> getInorderIterator() {
        return null;
    }

    public void output() {

        output(root);
        ArrayList<IItem> allItemsDescending = reverse(allItemsAscending);
        ArrayList<IItem> coffeeItemsDescending = reverse(coffeeItemsAscending);
        ArrayList<IItem> teaItemsDescending = reverse(teaItemsAscending);
        ArrayList<IItem> frappuccinoItemsDescending = reverse(frappuccinoItemsAscending);
        ArrayList<IItem> bakeryItemsDescending = reverse(bakeryItemsAscending);
        IItem minCoffee = coffeeItemsDescending.get(coffeeItemsDescending.size()-1);
        IItem maxCoffee = coffeeItemsDescending.get(0);
        IItem minTea = teaItemsDescending.get(teaItemsDescending.size()-1);
        IItem maxTea = teaItemsDescending.get(0);
        IItem minBakery = bakeryItemsDescending.get(bakeryItemsDescending.size()-1);
        IItem maxBakery = bakeryItemsDescending.get(0);

        System.out.println("Cheapest Coffee in the menu: " +minCoffee.itemName() + " - Price: " +minCoffee.itemPrice() + "$" );
        System.out.println("Most Expensive Coffee in the menu: " +maxCoffee.itemName() + " - Price: " +maxCoffee.itemPrice() + "$" );
        System.out.println("Cheapest Tea in the menu: " +minTea.itemName() + " - Price: " +minTea.itemPrice() + "$" );
        System.out.println("Most Expensive Tea in the menu: " +maxTea.itemName() + " - Price: " +maxTea.itemPrice() + "$" );
        System.out.println("Cheapest Bakery in the menu: " +minBakery.itemName() + " - Price: " +minBakery.itemPrice() + "$" );
        System.out.println("Most Expensive Bakery in the menu: " +maxBakery.itemName() + " - Price: " +maxBakery.itemPrice() + "$" );
        System.out.println("======================================================================");
        System.out.println("All Items In Descending Order In Terms of Price");
        for (IItem item : allItemsDescending){
            System.out.println(" -" + item.itemName() + " - " + item.itemPrice() +"$");
        }
        System.out.println("======================================================================");
        System.out.println("All Items in Ascending Order In Terms of Price");
        for (IItem item : allItemsAscending){
            System.out.println(" -" + item.itemName() + " - " + item.itemPrice() +"$");
        }
        System.out.println("======================================================================");
        System.out.println("All Coffees in Descending Order in Terms of The Price.");
        for (IItem item : coffeeItemsDescending){
            System.out.println(" -" + item.itemName() + " - " + item.itemPrice() +"$");
        }
        System.out.println("======================================================================");
        System.out.println("All Coffees in Ascending Order in Terms of The Price.");
        for (IItem item : coffeeItemsAscending){
            System.out.println(" -" + item.itemName() + " - " + item.itemPrice() +"$");
        }
        System.out.println("======================================================================");
        System.out.println("All Teas in Descending Order in Terms of The Price.");
        for (IItem item : teaItemsDescending){
            System.out.println(" -" + item.itemName() + " - " + item.itemPrice() +"$");
        }
    }

    ArrayList<IItem> allItemsAscending = new ArrayList<IItem>();
    ArrayList<IItem> coffeeItemsAscending = new ArrayList<IItem>();
    ArrayList<IItem> teaItemsAscending = new ArrayList<IItem>();
    ArrayList<IItem> frappuccinoItemsAscending = new ArrayList<IItem>();
    ArrayList<IItem> bakeryItemsAscending = new ArrayList<IItem>();

    public ArrayList<IItem> reverse(ArrayList<IItem> arrayList) {
        // Arraylist for storing reversed elements
        ArrayList<IItem> revArrayList = new ArrayList<IItem>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revArrayList.add(arrayList.get(i));
        }
        // Return the reversed arraylist
        return revArrayList;
    }

    private void output(BinaryNode<IItem> root) {
        if (root != null) {
            IItem item = root.getData();
            output(root.getLeft());
            allItemsAscending.add(item);
            switch (item.itemType()) {
                case "Coffee":
                    coffeeItemsAscending.add(item);
                    break;
                case "Tea":
                    teaItemsAscending.add(item);
                    break;
                case "Frappuccino":
                    frappuccinoItemsAscending.add(item);
                    break;
                case "Bakery":
                    bakeryItemsAscending.add(item);
                    break;
            }
            output(root.getRight());
        }
    }

}
