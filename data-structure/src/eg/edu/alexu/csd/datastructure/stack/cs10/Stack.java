package eg.edu.alexu.csd.datastructure.stack.cs10;

import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * The Class Stack.
 */
public class Stack implements IStack {

    /**
     * The Class SinglyLinkedList.
     */
    private class SinglyLinkedList {

        /**
         * The Class ListNode.
         */
        private class ListNode {

            /** The element. */
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
             * @return void
             */
            public Object getElement() {
                return element;
            }

            /**
             * Gets the next.
             *
             * @return void
             */
            public ListNode getNext() {
                return next;
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
        /** The head. */
        private ListNode head;
        /** The size. */
        private int size = 0;
        /**
         * Instantiates a new singly linked list.
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

            if (index == 0) { /* In case that size not equals zero */
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

            ListNode t = new ListNode(element, head);
            head = t;
            size++;

        }

        /**
         * Gets the.
         *
         * @param index the index
         * @return Object
         */
        public Object get(final int index) {
            if (index < 0 || index > size - 1) {
                throw new RuntimeException("Invalid input");
            }

            int i = 0;

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
         * Checks if is empty.
         *
         * @return void
         */
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

            int i = 0;

            for (i = 1; i < index; i++) { /* BE ATTENTION - Until Index-1 */
                counter = counter.getNext();
            }

            ListNode removed = counter.getNext();

            counter.setNext(removed.getNext());
            removed.setNext(null);

            size--;

        } /* End of remove method */

        /**
         * Size.
         *
         * @return the int
         */
        public int size() {
            return size;
        }

    } /* End of Class */

    /** The stacker. */
    SinglyLinkedList stacker = new SinglyLinkedList();

    /**
     * Adds the.
     *
     * @param index            , element
     * @param element the element
     */
    @Override
    public void add(int index, final Object element) {
        index = stacker.size() - index;
        stacker.add(index, element);

        // TODO Auto-generated method stub

    }

    /**
     * Pop.
     *
     * @return object
     */
    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        Object k;
        k = stacker.get(0);
        stacker.remove(0);
        return k;
    }

    /**
     * Peek.
     *
     * @return Object
     */
    @Override
    public Object peek() {
        Object k;
        k = stacker.get(0);
        // TODO Auto-generated method stub
        return k;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.stack.IStack#push(java.lang.Object)
     */
    @Override
    public void push(final Object element) {
        // TODO Auto-generated method stub

        stacker.add(element);
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.stack.IStack#isEmpty()
     */
    @Override
    public boolean isEmpty() {

        // TODO Auto-generated method stub
        return stacker.isEmpty();
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.stack.IStack#size()
     */
    @Override
    public int size() {

        // TODO Auto-generated method stub
        return stacker.size();
    }

}
