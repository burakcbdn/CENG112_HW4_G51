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

    public void show(){

        display(root);
    }

    public void display(BinaryNode<IItem> root){
        if(root!=null){
            display(root.getLeft());
            System.out.print(" " + root.getData().itemPrice());
            display(root.getRight());
        }
    }

}
