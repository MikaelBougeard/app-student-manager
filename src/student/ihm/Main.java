package student.ihm;

import java.util.Scanner;

import student.bll.StudentManager;
import student.bo.Student;

public class Main {
	
	private static Scanner scanner;
	private static StudentManager stdMan;
	
	public static void main(String args[]) {
		stdMan = new StudentManager();
		scanner = new Scanner(System.in);

		Student newStd1 = new Student(0, "Alice", 15, "b3", 15);
		stdMan.studentList.add(newStd1);
		Student newStd2 = new Student(1, "Manu", 19, "b1", 17);
		stdMan.studentList.add(newStd2);
		Student newStd3 = new Student(2, "Peter", 17, "b2", 9);
		stdMan.studentList.add(newStd3);
		
		while(true) {
			boolean isExit = false;
			showMenu();
			String m1 = scanner.nextLine();
			switch(m1) {
			case "1":
				stdMan.addStudent();
				break;
			case "2":
				stdMan.editStudent();
				break;
			case "3":
				stdMan.deleteStudent();
				break;
			case "4":
				showSortMenu();
				String m2 = scanner.nextLine();
				switch(m2) {
				case "1":
					stdMan.sortByScore();
					break;
				case "2":
					stdMan.sortByName();
					break;
				case "3":
					stdMan.sortById();
					break;
				default:
					System.out.println(" > Invalid menu, please reselect bellow menu ");
				}
				break;
			case "5":
				stdMan.showStudent();
				break;
			case "0":
				isExit = true;
				break;
			default:
				System.out.println(" > Invalid menu, please reselect bellow menu ");
			}
			
			if (isExit == true) {
				System.out.println(" > Thank you for using my program");
				break;
			}	
		}
	}
	public static void showMenu() {
		System.out.println("--- Menu ---");
		System.out.println("1. Add student");
		System.out.println("2. Edit student by id");
		System.out.println("3. Delete student by id");
		System.out.println("4. Sort student");
		System.out.println("5. Show student");
		System.out.println("0. Exit");
		System.out.print("Please select menu: ");
	}
	public static void showSortMenu() {
		System.out.println("--- Sort Menu ---");
		System.out.println("1. Sort by score");
		System.out.println("2. Sort by name");
		System.out.println("3. Sort reset");
		System.out.print("Please select menu: ");
	}
}
