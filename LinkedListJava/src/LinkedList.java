/**
 * @author Matheus Henrique Schaly
 * @date Jul 23, 2017
 * @description Creates the LinkedList object, exhaustively commented
 */

public class LinkedList { 
	
	public boolean equals(LinkedList myList) {
		if (myList == this) {
			return true;
		}
		if (!(myList.getListSize() == this.getListSize())) {
			return false;
		}
		for (int i = 1; i != this.getListSize(); i++) {
			if (myList.retrieveNode(i).getData() != this.retrieveNode(i).getData()) {
				return false;
			}
		}
		return true;
	}

	Node head; // Creates the global pointer head of type Node, private by default
	int listSize; // Creates the global pointer listSize of type int, private by default
	
	/*
	 * Constructor, which sets the pointers head and listSize
	 */
	
	public LinkedList() { 
		head = null;
		listSize = 0;
	}
	
	/*
	 * Returns the private global pointer head
	 */
	
	public Node getHead() { 
		return head;
	}
	
	/*
	 * Returns the private global pointer listSize
	 */
	
	public int getListSize() { 
		return listSize;
	}
	
	/*
	 * Inserts a node to the list, parameters:
	 * data: the data to be contained inside the new node
	 * position: the position (not index) which the new node will be created
	 * 
	 * returns: a boolean used specially for the "test" class to confirm if "insert" is working properly
	 */
	
	public boolean insert(int data, int position) {
		if (position < 1 || position > listSize + 2) { // Test method for IllegalArgumentExpection, complementary to the "test" class
			throw new IllegalArgumentException("insert: invalid parameter, position must be between 1 and listSize.");
		}
		listSize++; // Increases the global variable "listSize" by 1
		Node temp1 = new Node(data); // Creates a new Node, "temp1", and sets its data to the be the data parameter
		if (position == 1) { // If position is equal to 1
			temp1.setNext(head); // "temp1's" "next" pointer will point to what the "head" is pointing to
			head = temp1; // "head" will point to what "temp1" is pointing to
			return true; // Affirms that a new node has been inserted, used specially for the "test" class
		}
		Node temp2 = head; // Creates a pointer to "head" of type Node
		for (int i = 2; i < position; i++) { // This loop will only have effect when position is bigger than 2
			temp2 = temp2.getNext(); // "temp2" will point to what its previously pointed Node's "next" pointer is pointing to
		}
		temp1.setNext(temp2.getNext()); // "temp1's" "next" pointer will point to what "temp2's" "next" pointer is pointing to
		temp2.setNext(temp1); // "temp2's" "next" pointer will point to "temp1"
		return true; // Affirms that a new node has been inserted, used specially for the "test" class
	}
	
	/*
	 * Removes a node from the list, parameter:
	 * position: the position (not index) of the node to be excluded
	 * 
	 * returns: a boolean used specially for the "test" class to confirm if "remove" is working properly
	 */
	
	public boolean remove(int position) {
		if (position < 1 || position > listSize + 2) { // Test method for IllegalArgumentExpection, complementary to the "test" class
			throw new IllegalArgumentException("remove: invalid parameter, position must be between 1 and listSize.");
		}
		listSize--; // Decreases the global variable "listSize" by 1
		Node prev = null, temp = head; // Creates two pointers. "Prev" will point to null, "temp" will point to "head"
		if (position == 1) { // If position is equal to 1
			head = temp.getNext(); // "head" will point to the object that "temp's" pointed object is pointing to through the pointer "next"
			return true; // Affirms that a node has been removed, used specially for the "test" class
		}
		for (int i = 1; i < position; i++) { // This loop will only have effect when position is bigger than 1
			prev = temp; // "prev" will point to what "temp1" is pointing to
			temp = temp.getNext(); // "temp" will point to the object that "temp's" pointed object is pointing to through the pointer "next"
		}
		prev.setNext(temp.getNext()); // prev's "next" pointer will point to what temp's "next" pointer is pointing to
		return true; // Affirms that a node has been removed, used specially for the "test" class
	}
	
	public Node retrieveNode(int position) {
		Node temp = head;
		for (int i = 1; i < position; i++) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	/*
	 * Reverses the order of the list, i.e.:
	 * the element at position "listSize" will become the
	 * element at position 1, and vice-versa. Head will also change,
	 * it will point to the new first element (as it should)
	 */
	
	public LinkedList reverseList() {
		Node prev = null, current = head, next; // Creates three pointers. "prev" will point to null, "current" will point to "head"
		while (current != null) { // While the pointer "current" is not pointing to null
			next = current.getNext(); // "next" will point to the object that "current's" pointed object is pointing to through the pointer "next"
			current.setNext(prev); // "current's" "next" pointer will point to "prev"
			prev = current; // "prev" will point to what "current" is pointing to
			current = next; // "current" will point to what "next" is pointing to
		}
		head = prev; // "head" will point to what "current" is pointing to
		return this; // Returns "checkList", so that the "test" class can verify its "reverseList's" functionality
	}
	
	/*
	 * Prints the data contained inside each node of the list, and also its size (number of nodes).
	 * It overwrites the toString() method embedded in Java, so it must return a string
	 * 
	 * returns: the data contained inside each node of the list, and also its size (number of nodes), in form of a string
	 */
	
	public String toString() {
		Node temp = head;
		StringBuilder myList = new StringBuilder();
		while (temp != null) {
			myList.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return myList + "\nSize: " + listSize + "\n";
	}
	
}
