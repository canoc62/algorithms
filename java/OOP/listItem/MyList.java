/**
 * Created by canoc on 6/17/17.
 */
public interface MyList {
    ListItem getHead();
    boolean addItem(ListItem Item);
    boolean removeItem(ListItem Item);
    void traverse(ListItem head);
}