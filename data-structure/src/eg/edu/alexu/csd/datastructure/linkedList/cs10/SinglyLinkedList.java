package eg.edu.alexu.csd.datastructure.linkedList.cs10;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * The Class SinglyLinkedList.
 */
public class SinglyLinkedList implements ILinkedList {

    /**
     * The Class ListNode.
     */
    private class ListNode {

        /** Object element ListNode next. */
        private Object element;

        /** The next. */
        private ListNode next;

        /**
         * Instantiates a new list node.
         *
         * @param el the el
         * @param nextElement the next element
         */
        public ListNode(final Object el, final ListNode nextElement) {
            element = el;
            next = nextElement;
        }

        /**
         * Gets the element.
         *
         * @return element
         */
        public Object getElement() {
            return element;
        }

        /**
         * Gets the next.
         *
         * @return next
         */
        public ListNode getNext() {
            return next;
        }

        /**
         * Sets the value.
         *
         * @param value the new value
         */
        public void setValue(final Object value) {
            element = value;
        }

        /**
         * Sets the next.
         *
         * @param value the new next
         */
        public void setNext(final ListNode value) {
            next = value;
        }

    } /* The end of the node class */

    /** Object element ListNode next. */
    private ListNode head;

    /** The size. */
    private int size = 0;

    /**
     * Constructor.
     */
    public SinglyLinkedList() {
        head = null;
    }

    /**
     * Adds the.
     *
     * @param index the index
     * @param element the element
     */
    @Override
    public void add(final int index, final Object element) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }

        if (element == null) {
            throw new RuntimeException("Null");
        }

        if (size == 0 && index == 0) {
            add(element);
            return;
        }

        if (index == 0) { /* InCaseThatSizeNotEqualsZero */
            ListNode insert = new ListNode(element, head);
            head = insert;
            size++;
            return;
        } else {
            int i = 1;

            ListNode counter = head;

            for (i = 0; i < size; i++) {
                if (i == index - 1) {
                    ListNode z = new ListNode(element, counter.getNext());
                    counter.setNext(z);
                }

                counter = counter.getNext();

            }

        } /* End of Else */

        size++;

    } /* End of Add method */

    /**
     * Adds the.
     *
     * @param element the element
     */
    @Override
    public void add(final Object element) {
        if (element == null) {
            throw new RuntimeException("Null");
        }
        ListNode counter = head;

        if (counter == null) {
            head = new ListNode(element, null);
            size++;
            return;
        }
        int i = 2;
        for (i = 1; i < size; i++) {
            counter = counter.getNext();
        }

        ListNode t = new ListNode(element, null);

        counter.setNext(t);

        size++;

    }

    /**
     * Gets the.
     *
     * @param index the index
     * @return the object
     */
    @Override
    public Object get(final int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException();
        }

        int i = 2;

        ListNode counter = head;

        if (index == 0) {
            return counter.getElement();
        }

        for (i = 1; i <= index; i++) {
            counter = counter.getNext();
        }

        return counter.getElement();
    }

    /**
     * Sets the.
     *
     * @param index the index
     * @param element the element
     */
    @Override
    public void set(final int index, final Object element) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }
        if (element == null) {
            throw new RuntimeException("Null");
        }

        int i = 1;
        ListNode counter = head;

        if (index == 0) {
            counter.setValue(element);
            return;
        }

        for (i = 1; i <= index; i++) {
            counter = counter.getNext();
        }

        counter.setValue(element);

    }

    /**
     * clears list.
     */
    @Override
    public void clear() {
        head = null;

        size = 0;
    }

    /**
     * Checks if is empty.
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    /**
     * Removes the.
     *
     * @param index the index
     */
    @Override
    public void remove(final int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }

        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        ListNode counter = head;

        int i = 2;

        for (i = 1; i < index; i++) { /* BE ATTENTION - Until Index-1 */
            counter = counter.getNext();
        }

        ListNode removed = counter.getNext();

        counter.setNext(removed.getNext());

        size--;

    } /* End of remove method */

    /**
     * Size.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sublist.
     *
     * @param fromIndex the from index
     * @param toIndex the to index
     * @return ILinkedList
     */
    @Override
    public ILinkedList sublist(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || fromIndex > size - 1
                || toIndex < 0 || toIndex > size - 1) {
            throw new RuntimeException("Out of Boundary");
        }
        if (fromIndex >= toIndex) {
            throw new RuntimeException("Wrong Arguments");
        }

        SinglyLinkedList subList = new SinglyLinkedList();

        subList.size = toIndex - fromIndex + 1;
        int i = 2;

        if (fromIndex == 0) {
            subList.head = head; /* Caught the list */

            ListNode counter = subList.head;

            for (i = 1; i <= toIndex; i++) {
                counter = counter.getNext();
            }

            return subList;
        } /* End of If */

        ListNode elseCounter = head;

        for (i = 1; i <= fromIndex; i++) { /*
             * To catch the head node of the
             * sublist
             */
            elseCounter = elseCounter.getNext();
        }

        subList.head = elseCounter;

        for (i = fromIndex + 1; i <= toIndex; i++) {
            elseCounter = elseCounter.getNext();
        }

        return subList;

    } /* End of Sublist Method */

    /**
     * Contains.
     *
     * @param o the o
     * @return boolean
     */
    @Override
    public boolean contains(final Object o) {
        int i = 0;

        ListNode counter = head;

        if (o == null) {
            throw new RuntimeException();
        }

        if (size == 0) {
            throw new RuntimeException();
        }

        for (i = 1; i <= size; i++) {
        /* To catch the head node of the sublist */
            if (o.equals(counter.element)) {
                return true;
            }
            counter = counter.getNext();

        } /* End of for loop */

        return false;
    } /* End of contain method */

} /* End of Class */
