package eg.edu.alexu.csd.datastructure.queue.cs10;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * The Class QueueLinkedList.
 */
public class QueueLinkedList implements IQueue, ILinkedBased {

    /**
     * The Class SinglyLinkedList.
     */
    private class SinglyLinkedList  {

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

        /** The tail. */
        private ListNode tail;

        /** The size. */
        private int size = 0;

        /**
         * Constructor.
         */
        public SinglyLinkedList() {
            head = null;
            tail = null;
        }
        /**
         * Adds the.
         *
         * @param element the element
         */
        public void add(final Object element) {
            if (element == null) {
                throw new RuntimeException("Null");
            }

            if (head == null) {
                head = new ListNode(element, null);
                tail = head;
            } else {
               ListNode f = new ListNode(element, null);
               tail.setNext(f);
               tail = tail.getNext();
            }

            size++;

        }

        /**
         * Gets the.
         *
         * @param index the index
         * @return the object
         */
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
         * Checks if is empty.
         *
         * @return boolean
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

                head = head.getNext();
                size--;
        } /* End of remove method */

        /**
         * Size.
         *
         * @return size
         */
        public int size() {
            return size;
        }
       } /* End of Class */
     /** The queue. */
     SinglyLinkedList queue = new SinglyLinkedList();

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#enqueue
     */
    @Override
    public void enqueue(final Object item) {
        queue.add(item);
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#dequeue()
     */
    @Override
    public Object dequeue() {
        Object getter;
        getter = queue.get(0);
        queue.remove(0);
        return getter;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#size()
     */
    @Override
    public int size() {
        return queue.size();
    }
}
