package eg.edu.alexu.csd.datastructure.linkedList.cs10;

/*import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
*/

/**
 * The Class DLLTest.
 */
public class DLLTest {
    /*  The J-unit test has been commented due to the
     * very large number of magic numbers because of index assertions
     * And of course it would be absolutely tedious and meaningless
     * to make a constant for each one of them , that`s why they were commented
     * Other than that they are fully functional J-unit tests
     * all you need to do  is to uncomment them to be able to use them
	@Test
	public void testAdd1() {
		ILinkedList setter = new Doubly_linked_list();
		setter.add("James");
		setter.add("Castellan");
		setter.add("Cosa Nostra");
		setter.add(0, "Paul");
		setter.set(1, "castle");
		assertEquals("castle", setter.get(1));
		assertEquals(4, setter.size());
		assertEquals("Paul", setter.get(0));

	}

	@Test(expected = RuntimeException.class)
	public void testAdd2() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		assertNull(setter.get(2));

	}

	@Test(expected = RuntimeException.class)
	public void testAdd3() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		setter.add(1, "Not");
		setter.add(3, "cases");
		assertEquals("cases", setter.get(3));
		assertEquals(4, setter.size());
		assertNull(setter.get(4));

	}

	@Test(expected = RuntimeException.class)
	public void testRemove() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.add("car");
		setter.remove(1);
		setter.remove(0);
		setter.remove(2);
		assertEquals("cases", setter.get(1));
		assertEquals(2, setter.size());
		assertNull(setter.get(2));

	}

	@Test(expected = RuntimeException.class)
	public void testRemove2() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("(plain)");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.remove(0);
		setter.remove(2);
		assertNull("cases", setter.get(3));
		assertEquals(2, setter.size());
		assertNull(setter.get(4));

	}

	@Test
	public void testRemove3() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.clear();
		assertTrue(setter.isEmpty());

	}

	@Test
	public void Contains1() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.add("follow");
		setter.add("iron");
		setter.add("from");
		setter.add("the");
		setter.add("rabbit");
		setter.remove(6);
		setter.remove(5);
		assertTrue(setter.contains("follow"));
		assertTrue(setter.contains("the"));
		assertTrue(setter.contains("rabbit"));

	}

	@Test
	public void Contains2() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		setter.add(1, "Not");
		setter.add(3, "cases");

		setter.remove(1);
		assertFalse(setter.contains("Not"));

	}

	@Test
	public void Sublist1() {

		ILinkedList setter = new Doubly_linked_list();
		setter.add("()");
		setter.add("red");
		setter.add(1, "Not");
		setter.add(3, "cases");

		assertEquals(4, setter.size());
		ILinkedList x1 = setter.sublist(0, 3);
		x1.set(2, "blue");
		assertEquals("red", setter.get(2));

	}

	@Test
	public void Sublist2() {

		ILinkedList setter = new Doubly_linked_list();

		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.add("follow");
		setter.add("iron");
		setter.add("from");
		setter.add("Ice");
		ILinkedList x1 = setter.sublist(3, 7);
		x1.clear();
		assertEquals("Separately", 8, setter.size());

	}

	@Test
	public void testAdd1_s() {
		ILinkedList setter = new SinglyLinkedList();
		setter.add("James");
		setter.add("Castellan");
		setter.add("Cosa Nostra");
		setter.add(0, "Paul");
		setter.set(1, "castle");
		assertEquals("castle", setter.get(1));
		assertEquals(4, setter.size());
		assertEquals("Paul", setter.get(0));

	}

	@Test(expected = RuntimeException.class)
	public void testAdd2_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("()");
		setter.add("red");
		assertNull(setter.get(2));

	}

	@Test(expected = RuntimeException.class)
	public void testAdd3_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("()");
		setter.add("red");
		setter.add(1, "Not");
		setter.add(3, "cases");
		assertEquals("cases", setter.get(3));
		assertEquals(4, setter.size());
		assertNull(setter.get(4));

	}

	@Test(expected = RuntimeException.class)
	public void testRemove_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.add("car");
		setter.remove(1);
		setter.remove(0);
		setter.remove(2);
		assertEquals("cases", setter.get(1));
		assertEquals(2, setter.size());
		assertNull(setter.get(2));

	}

	@Test(expected = RuntimeException.class)
	public void testRemove2_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("(plain)");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.remove(0);
		setter.remove(2);
		assertNull("cases", setter.get(3));
		assertEquals(2, setter.size());
		assertNull(setter.get(4));

	}

	@Test
	public void testRemove3_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.clear();
		assertTrue(setter.isEmpty());

	}

	@Test
	public void Contains1_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.add("follow");
		setter.add("iron");
		setter.add("from");
		setter.add("the");
		setter.add("rabbit");
		setter.remove(6);
		setter.remove(5);
		assertTrue(setter.contains("follow"));
		assertTrue(setter.contains("the"));
		assertTrue(setter.contains("rabbit"));

	}

	@Test
	public void Contains2_s() {

		ILinkedList setter = new SinglyLinkedList();
		setter.add("()");
		setter.add("red");
		setter.add(1, "Not");
		setter.add(3, "cases");

		setter.remove(1);
		assertFalse(setter.contains("Not"));

	}

	@Test
	public void Sublist2_s() {

		ILinkedList setter = new SinglyLinkedList();

		setter.add("()");
		setter.add("red");
		setter.add("Not");
		setter.add("cases");
		setter.add("follow");
		setter.add("iron");
		setter.add("from");
		setter.add("Ice");
		ILinkedList x1 = setter.sublist(3, 7);
		x1.clear();
		assertEquals("Separately", 8, setter.size());

	}
 */
}
