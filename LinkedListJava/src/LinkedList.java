/**
 * @author Matheus Henrique Schaly
 * @date Jul 23, 2017
 * @description Creates a LinkedList object.
 */

public class LinkedList { 

	private Node head;
	private int listSize;
	
	public LinkedList() { 
		head = null;
		listSize = 0;
	}
	
	public Node getHead() { 
		return head;
	}
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	public int getListSize() { 
		return listSize;
	}
	
	/**
	 * Increases list by 1.
	 */
	
	public void increaseListSize() {
		listSize++;
	}
	
	/**
	 * Decreases list by 1.
	 */
	
	public void decreaseListSize() {
		listSize--;
	}
	
	/**
	 * Inserts a node to the list.
	 * @param data The data to be contained inside the new node
	 * @param position The position (not index) which the new node will be created
	 * 
	 * @return a boolean representing if a node has been added
	 */
	
	public boolean insert(int data, int position) {
		if (position < 1 || position > getListSize() + 1) {
			throw new IndexOutOfBoundsException("insert: invalid parameter, position must be between 1 and listSize.");
		}
		increaseListSize();
		Node temp1 = new Node(data);
		if (position == 1) {
			temp1.setNext(getHead());
			setHead(temp1);
			return true;
		}
		Node temp2 = getHead();
		for (int i = 2; i < position; i++) {
			temp2 = temp2.getNext();
		}
		temp1.setNext(temp2.getNext());
		temp2.setNext(temp1);
		return true;
	}
	
	/**
	 * Removes a node from the list.
	 * @param position The position (not index) of the node to be excluded
	 * 
	 * @returns a boolean representing if a node has been removed
	 */
	
	public boolean remove(int position) {
		if (position < 1 || position > getListSize()) {
			throw new IndexOutOfBoundsException("remove: invalid parameter, position must be between 1 and listSize.");
		}
		decreaseListSize();
		Node prev = null, temp = getHead();
		if (position == 1) {
			setHead(temp.getNext());
			return true;
		}
		for (int i = 1; i < position; i++) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(temp.getNext());
		return true;
	}
	
	/**
	 * Retrieves a node from the list (does not remove it).
	 * @param position The position (not index) of the node to be retrieved
	 * 
	 * @return the selected node
	 */
	
	public Node retrieveNode(int position) {
		if (position < 1 || position > getListSize()) {
			throw new IndexOutOfBoundsException("retrieveNode: invalid parameter, position must be between 1 and listSize.");
		}
		Node temp = getHead();
		for (int i = 1; i < position; i++) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	/**
	 * Reverses the order of the list, i.e.:
	 * the element at position "listSize" will become the
	 * element at position 1, and vice-versa. Head will also change,
	 * it will point to the new first element (as it should).
	 * 
	 * @return a LinkedList used specially for the "test" class
	 */
	
	public LinkedList reverseList() {
		Node prev = null, current = getHead(), next;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		setHead(prev);
		return this;
	}
	
	/**
	 * Prints the data contained inside each node of the list, and also its size (number of nodes).
	 * 
	 * @return the data contained inside each node of the list, and also its size (number of nodes), in form of a string
	 */
	
	public String toString() {
		Node temp = getHead();
		StringBuilder myList = new StringBuilder();
		while (temp != null) {
			myList.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return myList + "\nSize: " + listSize + "\n";
	}
	
	/**
	 * Checks if 2 LinkedLists are equal.
	 * @param myList The list to be checked
	 * 
	 * @return a boolean representing if myList is equal another
	 */
	
	public boolean equals(LinkedList myList) {
		if (myList == this) {
			return true;
		}
		if (!(myList.getListSize() == getListSize())) {
			return false;
		}
		for (int i = 1; i != getListSize(); i++) {
			if (myList.retrieveNode(i).getData() != retrieveNode(i).getData()) {
				return false;
			}
		}
		return true;
	}
	
}
