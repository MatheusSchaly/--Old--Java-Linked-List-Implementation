/**
 * @author Matheus Henrique Schaly
 * @date Jul 23, 2017
 * @description Creates the LinkedList object, exhaustively commented
 */

public class LinkedList { 

	Node head;
	int listSize;
	
	public LinkedList() { 
		head = null;
		listSize = 0;
	}
	
	
	public Node getHead() { 
		return head;
	}
	
	
	public int getListSize() { 
		return listSize;
	}
	
	/*
	 * Inserts a node to the list
	 * data: the data to be contained inside the new node
	 * position: the position (not index) which the new node will be created
	 * 
	 * returns: a boolean representing if a node has been added
	 */
	
	public boolean insert(int data, int position) {
		if (position < 1 || position > listSize + 2) {
			throw new IllegalArgumentException("insert: invalid parameter, position must be between 1 and listSize.");
		}
		listSize++;
		Node temp1 = new Node(data);
		if (position == 1) {
			temp1.setNext(head);
			head = temp1;
			return true;
		}
		Node temp2 = head;
		for (int i = 2; i < position; i++) {
			temp2 = temp2.getNext();
		}
		temp1.setNext(temp2.getNext());
		temp2.setNext(temp1);
		return true;
	}
	
	/*
	 * Removes a node from the list
	 * position: the position (not index) of the node to be excluded
	 * 
	 * returns: a boolean representing if a node has been removed
	 */
	
	public boolean remove(int position) {
		if (position < 1 || position > listSize + 2) {
			throw new IllegalArgumentException("remove: invalid parameter, position must be between 1 and listSize.");
		}
		listSize--;
		Node prev = null, temp = head;
		if (position == 1) {
			head = temp.getNext();
			return true;
		}
		for (int i = 1; i < position; i++) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(temp.getNext());
		return true;
	}
	
	/*
	 * Retrieve a node from the list (does not remove it)
	 * position: the position (not index) of the node to be retrieved
	 * 
	 * return: the selected node
	 */
	
	public Node retrieveNode(int position) {
		if (position < 1 || position > listSize + 2) {
			throw new IllegalArgumentException("retrieveNode: invalid parameter, position must be between 1 and listSize.");
		}
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
	 * 
	 * returns: a LinkedList used specially for the "test" class
	 */
	
	public LinkedList reverseList() {
		Node prev = null, current = head, next;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return this;
	}
	
	/*
	 * Prints the data contained inside each node of the list, and also its size (number of nodes).
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
	
	/*
	 * Check if 2 LinkedLists are equal
	 * myList: the list to be checked
	 * 
	 * returns: a boolean representing if myList is equal another
	 */
	
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
	
}
