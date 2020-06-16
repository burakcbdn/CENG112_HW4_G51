public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T dataP) {
        this(dataP, null, null);
    }

    public BinaryNode(T dataP, BinaryNode<T> newLeft, BinaryNode<T> newRight) {
        data = dataP;
        left = newLeft;
        right = newRight;
    }

    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setLeft(BinaryNode<T> newLeft) {
        left = newLeft;
    }

    public void setRight(BinaryNode<T> newRight){
        right = newRight;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public int getHeight() {
        return getHeight(this);
    }

    public int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        }
        return height;
    }

    public int getNumberOfNodes() {
        int leftNum = 0;
        int rightNum = 0;
        if (left != null) {
            leftNum = left.getNumberOfNodes();
        }
        if (right != null) {
            rightNum = right.getNumberOfNodes();
        }
        return 1 + leftNum + rightNum;
    }

}
