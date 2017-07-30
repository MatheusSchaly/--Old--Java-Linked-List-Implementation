import java.util.Scanner;

/**
 * @author Matheus Henrique Schaly
 * @date Jul 26, 2017
 * @description Main method to interact with LinkedList object
 */

public class main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int menuOption; 
		LinkedList myList = new LinkedList();
		
		do {
			do {
				System.out.println("Choose:");
				System.out.println("0 - Exit");
				System.out.println("1 - Insert data");
				System.out.println("2 - Remove data");			
				System.out.println("3 - Reverse list");
				System.out.println("4 - Print list");
				menuOption = s.nextInt();
			} while (menuOption < 0 || menuOption > 4);
			
			switch (menuOption) {
			case 1:
				int data, position;
				char option;
				boolean valid;
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
					do {
						System.out.println("Add more nodes (Y/n)");
						option = s.next().charAt(0);
						option = Character.toLowerCase(option);
					} while (option != 'y' && option != 'n');
				} while (option != 'n');
			}
//			case 2:
//				int position;
//				char option;
//				boolean valid
		} while (menuOption != 0);
		s.close();
	}
}
