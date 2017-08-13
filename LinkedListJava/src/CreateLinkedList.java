import java.util.Scanner;

/**
 * @author Matheus Henrique Schaly
 * @date Aug 13, 2017
 * @description Creates a LinkedList object.
 */

public class CreateLinkedList {
	
	private LinkedList list = new LinkedList();
	
	public LinkedList getList() {
		return list;
	}
	
	public int choiceMenu() {
		Scanner s = new Scanner(System.in);
		int menuOption;
		do {
			System.out.println("Choose:");
			System.out.println("0 - Exit");
			System.out.println("1 - Insert data");
			System.out.println("2 - Remove data");			
			System.out.println("3 - Reverse list");
			menuOption = s.nextInt();
		} while (menuOption < 0 || menuOption > 3);
		s.close();
		return menuOption;
	}
	
	public void insertData() {
		Scanner s = new Scanner(System.in);
		int data, position;
		char option;
		boolean valid = false;
		do {
			System.out.println("Enter the data:");
			data = s.nextInt();		
			do {
				valid = true;
				try {
					System.out.println("Enter the positon:");
					position = s.nextInt();
					getList().insert(data, position);
				} catch (IndexOutOfBoundsException e) {
					valid = false;
				}
			} while (valid == false);
			System.out.println("Current list: " + getList());
			do {
				System.out.println("Add more nodes (Y/n)");
				option = s.next().charAt(0);
				option = Character.toLowerCase(option);
			} while (option != 'y' && option != 'n');
		} while (option != 'n');
		s.close();
	}
	
	public void removeData() {
		Scanner s = new Scanner(System.in);
		int position;
		char option;
		boolean valid = false;
		do {
			do {
				valid = true;
				try {
					System.out.println("Enter the positon:");
					position = s.nextInt();
					getList().remove(position);
				} catch (IndexOutOfBoundsException e) {
					valid = false;
				}
			} while (valid == false);
			System.out.println("Current list: " + getList());
			do {
				System.out.println("Remove more nodes (Y/n)");
				option = s.next().charAt(0);
				option = Character.toLowerCase(option);
			} while (option != 'y' && option != 'n');
		} while (option != 'n');
		s.close();
	}
	
	public void invert() {
		getList().reverseList();
		System.out.println("Current list: " + getList());
	}
	
	public void run() {
		Scanner s = new Scanner(System.in);
		int menuOption;
		do {
			menuOption = choiceMenu();
			switch (menuOption) {
			case 1:
				insertData();
				break;
			case 2:
				removeData();
				break;
			case 3:
				invert();
				break;
			}
		} while (menuOption != 0);
		s.close();
	}
	
}

