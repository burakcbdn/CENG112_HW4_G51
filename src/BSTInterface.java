import java.util.Iterator;

public interface BSTInterface<IItem> {

    //searches for a specific item in tree.
    public boolean Contains(IItem item);

    //Retrieves a specific item in tree.
    public IItem getEntry(IItem item);

    //Adds a new item to this tree.
    public void add(IItem newItem);

    //Removes specific item from tree.
    public boolean remove(IItem item);

    //creates an iterator that traverses all items in this tree
    public Iterator<IItem> getInorderIterator();

}
