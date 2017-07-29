/**
 * @author Matheus Henrique Schaly
 * @date Jul 23, 2017
 * @description Creates the Node object
 */

public class Node {
	
	int data;
	Node next;
	
	// Four different types of constructors, as Java does not allow default parameters

	public Node() {
		data = 0;
		next = null;
	}
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	public Node(Node next) {
		this.next = next;
		data = 0;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}
