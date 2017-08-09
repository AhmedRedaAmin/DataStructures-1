package eg.edu.alexu.csd.datastructure.queue.cs10;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 * The Class QueueArray.
 */
public class QueueArray implements IQueue, IArrayBased {

    /** The r. */
    private int r;

    /** The f. */
    private int f;

    /** The c array. */
    private Object[] cArray;

    /** The total size. */
    private int totalSize;

    /**
     * Instantiates a new queue array.
     *
     * @param sizer the sizer
     */
    QueueArray(final int sizer) {
        cArray = new Object[sizer + 1];
        f = 0;
        r = 0;
        totalSize = sizer + 1;
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public int getSize() {
        return (totalSize - f + r) % totalSize;
    }

        /* (non-Javadoc)
         * @see eg.edu.alexu.csd.datastructure
         */
        @Override
    public void enqueue(final Object item) {
        if (this.getSize() == totalSize - 1 || r + 1 == f) {
            throw new RuntimeException("Array full");
        }
        if (r == totalSize - 1) {
            cArray[r] = item;
            r = 0;

        } else {

            cArray[r] = item;
            r++;

        }

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#dequeue()
     */
    @Override
    public Object dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("This List is Empty");
        }
        Object z = cArray[f];
        if (f + 1 == totalSize) {
            cArray[f] = null;
            f = 0;
        } else {
            cArray[f] = null;
            f++;
        }

        // TODO Auto-generated method stub
        return z;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return f == r;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.queue.IQueue#size()
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return (totalSize - f + r) % totalSize;
    }

}
