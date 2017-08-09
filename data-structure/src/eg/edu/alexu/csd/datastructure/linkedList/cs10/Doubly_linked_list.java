package eg.edu.alexu.csd.datastructure.linkedList.cs10;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * The Class Doubly_linked_list.
 */
public class Doubly_linked_list implements ILinkedList {

    // private ArrayList<DLL_Node> added_nodes = new ArrayList<>();

    /**
     * The Class DLLNode.
     */
    private class DLLNode {

        /** The value. */
        private Object value;

        /** The prev. */
        private DLLNode prev;

        /** The next. */
        private DLLNode next;

        /**
         * Instantiates a new DLL node.
         *
         * @param value1 the value1
         */
        public DLLNode(final Object value1) {

            value = value1;
            next = null;
            prev = null;
        }

        /**
         * Gets the value.
         *
         * @return the value
         */
        public Object getValue() {
            return value;

        }

        /**
         * Gets the prev.
         *
         * @return the prev
         */
        public DLLNode getPrev() {
            return prev;
        }

        /**
         * Gets the next.
         *
         * @return the next
         */
        public DLLNode getNext() {
            return next;
        }

        /**
         * Sets the value.
         *
         * @param value1 the new value
         */
        public void setValue(final Object value1) {
            value = value1;

        }

        /**
         * Sets the next.
         *
         * @param next1 the new next
         */
        public void setNext(final DLLNode next1) {
            next = next1;

        }

        /**
         * Sets the prev.
         *
         * @param prev1 the new prev
         */
        public void setPrev(final DLLNode prev1) {
            prev = prev1;

        }

    }

    /** The head. */
    private DLLNode head;

    /** The count. */
    private int count = 0;

    /**
     * Instantiates a new doubly_linked_list.
     */
    public Doubly_linked_list() {
        head = null;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.
     */
    @Override
    public void add(final int index, final Object element) {
        if (index > count || index < 0) {

            throw new RuntimeException("Access Out of bound");

        } else if (index == 0) {
            if (count == 0) {
                DLLNode x1 = new DLLNode(element);
                head = x1;
            } else {
                DLLNode x1 = new DLLNode(element);
                head.setPrev(x1);
                x1.setNext(head);

                head = x1;
            }

            count++;
        } else {
            DLLNode slider = head;
            int i;
            for (i = 1; i < index; i++) {
                slider = slider.getNext();
            }
            DLLNode x1 = new DLLNode(element);
            x1.setPrev(slider);
            if (slider.getNext() != null) {
                x1.setNext(slider.getNext());
                slider.getNext().setPrev(x1);
                slider.setNext(x1);
            } else {
                slider.setNext(x1);

            }
            count++;
        }

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure
     */
    @Override
    public void add(final Object element) {
        if (count == 0) {
            DLLNode x1 = new DLLNode(element);
            head = x1;
            count++;

        } else {

            DLLNode slider = head;
            while (slider.getNext() != null) {
                slider = slider.getNext();

            }

            DLLNode x1 = new DLLNode(element);
            x1.setPrev(slider);
            slider.setNext(x1);
            count++;

        }

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList#get(int)
     */
    @Override
    public Object get(final int index) {
        int i;
        DLLNode slider = head;
        if (index > count - 1 || index < 0) {

            throw new RuntimeException("Access Out OF Bound");

        }

        for (i = 0; i < index; i++) {
            slider = slider.getNext();
        }

        // TODO Auto-generated method stub
        return slider.getValue();
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure
     */
    @Override
    public void set(final int index, final Object element) {

        if (index > count - 1 || index < 0) {

            throw new RuntimeException("Access Out OF Bound");

        }
        int i;
        DLLNode slider = head;
        for (i = 0; i < index; i++) {
            slider = slider.getNext();
        }

        slider.setValue(element);

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList#clear()
     */
    @Override
    public void clear() {
        if (count < 2) {
            head = null;
            count = 0;
        }

        int i;
        DLLNode slider = head;
        for (i = 1; i <= count; i++) {
            if (i > 1) {
                slider.getPrev().setNext(null);
                slider.setPrev(null);
            }

            slider = slider.getNext();
        }
        slider = null;
        head = null;

        count = 0;

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        boolean a;
        if (count == 0 && head == null) {
            a = true;
        } else {
            a = false;
        }

        // TODO Auto-generated method stub
        return a;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList#remove(int)
     */
    @Override
    public void remove(final int index) {
        if (index > count - 1 || index < 0) {

            throw new RuntimeException("Trying to remove a non-existent Node");

        }
        if (count < 2) {
            head = null;
            count = 0;
        } else {
            int i;

            DLLNode slider = head;
            for (i = 0; i < index; i++) {
                slider = slider.getNext();

            }
            if (slider.getNext() == null) {
                slider.getPrev().setNext(null);
                slider.setPrev(null);
                count--;
            } else {

                DLLNode x1 = slider.getNext();
                if (slider.getPrev() != null) {
                    x1.setPrev(slider.getPrev());
                    slider.getPrev().setNext(x1);
                } else {
                    x1.setPrev(null);
                    slider.setNext(null);
                    head = x1;
                }

                slider.setNext(null);
                slider.setPrev(null);
                count--;
            }
        }

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList#size()
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return count;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure
     */
    @Override
    public ILinkedList sublist(final int fromIndex, final int toIndex) {
        ILinkedList chard = new Doubly_linked_list();

        if (toIndex > count - 1 || toIndex < 0
          || fromIndex < 0 || fromIndex > toIndex) {

            throw new RuntimeException("Out of range");

        } else {

            int i;
            DLLNode slider = head;
            for (i = 0; i < fromIndex; i++) {
                slider = slider.getNext();

            }

            while (i <= toIndex) {
                Object x1 = new Object();
                x1 = slider.getValue();
                chard.add(x1);
                slider = slider.getNext();
                i++;
            }

        }

        // TODO Auto-generated method stub
        return chard;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.linkedList
     */
    @Override
    public boolean contains(final Object o) {
        boolean k = false;

        DLLNode slider = head;
        while (slider != null) {
            if (slider.getValue().equals(o)) {

                k = true;
                break;

            }
            slider = slider.getNext();

        }
        // TODO Auto-generated method stub
        return k;
    }

}
