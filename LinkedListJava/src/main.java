import java.util.Scanner;

/**
 * @author Matheus Henrique Schaly
 * @date Jul 26, 2017
 * @description Main method to interact with LinkedList object
 */

public class main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		LinkedList myList = new LinkedList();
		int menuOption, data, position; 
		char option;
		boolean valid;
		do {
			do {
				System.out.println("Choose:");
				System.out.println("0 - Exit");
				System.out.println("1 - Insert data");
				System.out.println("2 - Remove data");			
				System.out.println("3 - Reverse list");
				menuOption = s.nextInt();
			} while (menuOption < 0 || menuOption > 3);
			valid = false;
			switch (menuOption) {
			case 1:
				do {
					System.out.println("Enter the data:");
					data = s.nextInt();		
					do {
						valid = true;
						try {
							System.out.println("Enter the positon:");
							position = s.nextInt();
							myList.insert(data, position);
						} catch (IllegalArgumentException e) {
							valid = false;
						}
					} while (valid == false);
					System.out.println("Current list: " + myList);
					do {
						System.out.println("Add more nodes (Y/n)");
						option = s.next().charAt(0);
						option = Character.toLowerCase(option);
					} while (option != 'y' && option != 'n');
				} while (option != 'n');
				break;
			case 2:
				do {
					do {
						valid = true;
						try {
							System.out.println("Enter the positon:");
							position = s.nextInt();
							myList.remove(position);
						} catch (IllegalArgumentException e) {
							valid = false;
						}
					} while (valid == false);
					System.out.println("Current list: " + myList);
					do {
						System.out.println("Remove more nodes (Y/n)");
						option = s.next().charAt(0);
						option = Character.toLowerCase(option);
					} while (option != 'y' && option != 'n');
				} while (option != 'n');
			case 3:
				myList.reverseList();
				System.out.println("Current list: " + myList);
			}
		} while (menuOption != 0);
		s.close();
	}
}
