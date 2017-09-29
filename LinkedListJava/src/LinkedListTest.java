/**
 * @author Matheus Henrique Schaly
 * @date Jul 24, 2017
 * @description Tests a LinkedList object.
 */

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {
	
	/**
	 * Tests insert corner cases using assertEquals and also
	 * checks for index out of bounds exception.
	 */
	
	public void testInsert() {
		LinkedList myList = new LinkedList();
		assertEquals("Check insert, inserting first element in list.", true, myList.insert(5, 1));
		assertEquals("Check insert, inserting second element in list.", true, myList.insert(10, 2));
		assertEquals("Check insert, inserting element between two elements.", true, myList.insert(15, 1));
		assertEquals("Check insert, inserting element with the same data as the previous element.", true, myList.insert(15, 3));
		try {
			myList.insert(5, 0);
			fail("Check insert, illegal argument exception, position has to be bigger than 0.");
		} catch (IndexOutOfBoundsException e) {
			
		}
		try {
			myList.insert(20, myList.getListSize() + 1);
			fail("Check insert, illegal argument exception, position has to be smaller than listSize plus 2.");
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/**
	 * Tests remove corner cases assertEquals and also
	 * checks for index out of bounds exception.
	 */
	
	public void testRemove() {
		LinkedList myList = new LinkedList();
		myList.insert(5, 1);
		myList.insert(10, 2);
		myList.insert(15, 1);
		myList.insert(15, 3);
		assertEquals("Check remove, removing first element in list.", true, myList.remove(1));
		assertEquals("Check remove, removing last element in list.", true, myList.remove(myList.getListSize()));
		try {
			myList.remove(0);
			fail("Check remove, illegal argument exception, position has to be bigger than 1.");
		} catch (IndexOutOfBoundsException e) {
			
		}
		try {
			myList.remove(myList.getListSize() + 1);
			fail("Check remove, illegal argument exception, position has to be smaller than listSize plus 1.");
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/**
	 * Tests retrieveNode corner cases using assertEquals and also
	 * checks for index out of bounds exception.
	 */
	
	public void testRetrieveNode() {
		LinkedList myList = new LinkedList();
		myList.insert(1, 1);
		myList.insert(2, 2);
		myList.insert(3, 3);
		assertEquals("Check retrieveNode, checking first element data in list.", 1, myList.retrieveNode(1).getData());
		assertEquals("Check retrieveNode, checking second element data in list.", 2, myList.retrieveNode(2).getData());
		assertEquals("Check retrieveNode, checking last element data in list.", 3, myList.retrieveNode(3).getData());
		try {
			myList.retrieveNode(0);
			fail("Check retrieveNode, illegal argument exception, position has to be bigger than 1.");
		} catch (IndexOutOfBoundsException e) {
			
		}
		try {
			myList.retrieveNode(myList.getListSize() + 1);
			fail("Check retrieveNode, illegal argument exception, position has to be smaller than listSize plus 1.");
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/**
	 * Tests reverseList corner cases using assertEquals.
	 */
	
	public void testReverseList() {
		LinkedList myList = new LinkedList();
	    myList.insert(1, 1);
	    LinkedList singleElementList = new LinkedList();
	    singleElementList.insert(1, 1);
	    assertEquals("Check reverseList, could not reverse a list with 1 element.", true, myList.reverseList().equals(singleElementList));  
	    LinkedList expectedList = new LinkedList();
	    myList.insert(2, 2);
	    myList.insert(3, 3);
	    expectedList.insert(3, 1);
	    expectedList.insert(2, 2);
	    expectedList.insert(1, 3);
	    assertEquals("Check reverseList, could not reverse a list with 3 elements.", true, myList.reverseList().equals(expectedList));  
	}
	
	/**
	 * Tests testEquals corner cases using assertEquals.
	 */
	
	public void testEquals() {
		LinkedList myList = new LinkedList();
	    myList.insert(1, 1);
		assertEquals("Check reverseList, could not compare to the same list.", true, myList.reverseList().equals(myList));
		LinkedList myList2 = new LinkedList();
		myList2.insert(1, 1);
		myList2.insert(2, 2);
		assertEquals("Check reverseList, could not compare different size lists.", false, myList.reverseList().equals(myList2));
	}
	
	/**
	 * Tests toString corner cases using assertEquals.
	 */
	
	public void testToString() {
		LinkedList myList = new LinkedList();
		myList.insert(5, 1);
		myList.insert(10, 2);
		myList.insert(15, 1);
		myList.insert(15, 3);
		assertEquals("Check toString, could not print a list with 4 elements.", "15 5 15 10 \nSize: 4\n", myList.toString());
		myList.remove(1);
		myList.remove(1);
		myList.remove(1);
		assertEquals("Check toString, could not print a list with 1 element.", "10 \nSize: 1\n", myList.toString());
		myList.remove(1);
		assertEquals("Check toString, could not print a empty list.", "\nSize: 0\n", myList.toString());
	}
	
}
