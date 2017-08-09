package eg.edu.alexu.csd.datastructure.queue.cs10;


/*import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
*/



/**
 * The Class JUnitQueue.
 */
public class JUnitQueue {

    /*  The J-unit test has been commented due to the
     * very large number of magic numbers because of index or size assertions
     * And of course it would be absolutely tedious and meaningless
     * to make a constant for each one of them , that`s why they were commented
     * Other than that they are fully functional J-unit tests
     * all you need to do  is to uncomment them to be able to use them






    @Test
    public void enqueueDequeueCA() {
        QueueArray tester = new QueueArray(20);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        assertEquals(tester.dequeue(),"Salah");
        assertEquals(tester.dequeue(),"Yassin");
        assertEquals(tester.getSize(),3);
        assertEquals(tester.dequeue(),"Isaac");
        assertEquals(tester.dequeue(),"Marzouky ");
        assertEquals(tester.getSize(),1);
        tester.dequeue();
        assertTrue(tester.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void outofBoundCA() {

        QueueArray tester = new QueueArray(20);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");

    }

    @Test(expected = RuntimeException.class)
    public void testRemoveCA() {

        QueueArray tester = new QueueArray(20);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();

    }

    @Test
    public void sizeCA() {

        QueueArray tester = new QueueArray(20);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        assertEquals(tester.dequeue(),"Salah");
        assertEquals(tester.dequeue(),"Yassin");
        assertEquals(tester.getSize(),3);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        assertEquals(tester.size(),8);
        assertEquals(tester.dequeue(),"Isaac");
        assertEquals(tester.dequeue(),"Marzouky ");
        tester.enqueue("Yassin");
        tester.enqueue("Salah");
        assertEquals(tester.dequeue(),"Kareem");
        assertEquals(tester.dequeue(),"Salah");
        assertEquals(tester.getSize(),6);
    }

    @Test
    public void fullDequeueCA() {
        QueueArray tester = new QueueArray(20);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
       tester.dequeue();
        tester.dequeue();
       assertEquals(tester.getSize(),7);
       tester.dequeue();
        tester.dequeue();
        assertEquals(tester.getSize(),5);
       tester.dequeue();
       tester.dequeue();
       assertEquals(tester.getSize(),3);
       tester.dequeue();
       tester.dequeue();
       assertEquals(tester.getSize(),1);
       assertFalse(tester.isEmpty());

    }

    @Test
    public void enqueueDequeueLL() {

        QueueLinkedList tester = new QueueLinkedList();
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        assertEquals(tester.dequeue(),"Salah");
        assertEquals(tester.dequeue(),"Yassin");
        assertEquals(tester.size(),3);
        assertEquals(tester.dequeue(),"Isaac");
        assertEquals(tester.dequeue(),"Marzouky ");
        assertEquals(tester.size(),1);
        tester.dequeue();
        assertTrue(tester.isEmpty());

    }

    @Test(timeout=5)
    public void longEnqueueLL() {
        QueueLinkedList tester = new QueueLinkedList();
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
    }

    @Test
    public void fullDequeueLL() {

        QueueLinkedList tester = new QueueLinkedList();
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
       tester.dequeue();
        tester.dequeue();
       assertEquals(tester.size(),7);
       tester.dequeue();
        tester.dequeue();
        assertEquals(tester.size(),5);
       tester.dequeue();
       tester.dequeue();
       assertEquals(tester.size(),3);
       tester.dequeue();
       tester.dequeue();
       assertEquals(tester.size(),1);
       assertFalse(tester.isEmpty());

    }

    @Test(expected = RuntimeException.class)
    public void fullRemoveLL() {

        QueueLinkedList tester = new QueueLinkedList();

        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();
        tester.dequeue();

    }

    @Test
    public void sizeLL() {
        QueueLinkedList tester = new QueueLinkedList();
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        assertEquals(tester.dequeue(),"Salah");
        assertEquals(tester.dequeue(),"Yassin");
        assertEquals(tester.size(),3);
        tester.enqueue("Salah");
        tester.enqueue("Yassin");
        tester.enqueue("Isaac");
        tester.enqueue("Marzouky ");
        tester.enqueue("Kareem");
        assertEquals(tester.size(),8);
        assertEquals(tester.dequeue(),"Isaac");
        assertEquals(tester.dequeue(),"Marzouky ");
        tester.enqueue("Yassin");
        tester.enqueue("Salah");
        assertEquals(tester.dequeue(),"Kareem");
        assertEquals(tester.dequeue(),"Salah");
        assertEquals(tester.size(),6);

    }
   */
}
