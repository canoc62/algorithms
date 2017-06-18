/**
 * Created by canoc on 6/17/17.
 */
public class MyLinkedList implements MyList {
    private ListItem head = null;

    public MyLinkedList(ListItem firstItem) {
        this.head = firstItem;
    }

    @Override
    public ListItem getHead() {
        return this.head;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.head == null) {
            this.head = item;
            return true;
        } else {
            ListItem curr = this.head;

            while (curr != null) {
                if (curr.compareTo(item) > 0) {
                    ListItem oldPrevious = curr.previous();

                    if (oldPrevious != null) {
                        oldPrevious.setNext(item);
                        item.setPrevious(oldPrevious);
                        item.setNext(curr);
                        curr.setPrevious(item);
                    } else {
                        item.setNext(curr);
                        curr.setPrevious(item);
                        this.head = item;
                    }
                    return true;
                } else if (curr.compareTo(item) < 0) {
                    if (curr.next() != null) {
                        curr = curr.next();
                    } else {
                        curr.setNext(item);
                        item.setPrevious(curr);
                        return true;
                    }
                } else {
                    System.out.println(item.getValue() + " is already in list!");
                    return false;
                }
            }
            return false;
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem curr = this.head;

        while (curr != null) {
            if (curr.compareTo(item) == 0) {
                if (curr == this.head) {
                    this.head = curr.next();
                    //this.head.setPrevious(null);
                } else {
                    curr.previous().setNext(curr.next());
                    if (curr.next() != null) {
                        curr.next().setPrevious(curr.previous());
                    }
                }
                return true;
            } else if (curr.compareTo(item) < 0) {
                curr = curr.next();
            } else {
                return false;
            }
        }
        System.out.println("Requested item to be removed is not present in list");
        return false;
    }

    @Override
    public void traverse(ListItem head) {

        ListItem curr = head;
        if (curr == null) {
            System.out.println("List is empty, nothing to traverse!");
            return;
        }
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.next();
        }
    }
}
