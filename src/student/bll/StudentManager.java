package student.bll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import student.bo.Student;

public class StudentManager {
	public static Scanner scanner = new Scanner(System.in);
	public List<Student> studentList;
	private int maxId;
	
	/**
	 * Constructor
	 */
	public StudentManager() {
		this.studentList = new ArrayList<>();
		this.maxId = this.maxId();
	}
	/**
	 * Add new student to list
	 */
	public void addStudent() {	
		System.out.println("--- Add new student ---");
		int id = ++this.maxId;
		String name = this.inputName();
		int age = this.inputAge();
		String classroom = this.inputClassroom();
		float score = this.inputScore();
		
		Student newStd = new Student(id, name, age, classroom, score);
		this.studentList.add(newStd);
	}
	/**
	 * Edit student by ID
	 */
	public void editStudent() {
		System.out.println("--- Edit student ---");
		System.out.print("Input the ID: ");
		try {
			int id = Integer.parseInt((scanner.nextLine()));
			if (id > 0 && id < 10000) {
				
				for(int i=0; i<this.studentList.size(); i++) {
					if(this.studentList.get(i).getId() == id) {
					
						this.studentList.get(i).setName(this.inputName());
						this.studentList.get(i).setAge(this.inputAge());
						this.studentList.get(i).setClassroom(this.inputClassroom());
						this.studentList.get(i).setScore(this.inputScore());
					}
				}
			}
			else
				throw new Exception();
			
		}catch(Exception e) {
			System.out.println(" > Invalid id!");
		}
	}
	/**
	 * Delete student by id
	 */
	public void deleteStudent() {
		System.out.println("--- Delete student ---");
		System.out.print("Input the ID: ");
		try {
			int id = Integer.parseInt((scanner.nextLine()));
			if (id > 0 && id < 10000) {
				for(int i=0; i<this.studentList.size(); i++) {
					if(this.studentList.get(i).getId() == id) {
						this.studentList.remove(i);
						i--;
					}
				}
			}
			else
				throw new Exception();
			
		}catch(Exception e) {
			System.out.println(" > Invalid id!");
		}
	}
	
	/**
	 * Sort student list by Score [increasing]
	 */
	public class SortStudentByScore implements Comparator<Student>{
		
		public int compare(Student st1, Student st2) {
			return st1.getScore() > st2.getScore() ? 1 : -1;
		}
	}
	public void sortByScore() {
		this.studentList.sort(new SortStudentByScore());
	}
	
	/**
	 * Sort student list by name [increasing]
	 */
	public class SortStudentByName implements Comparator<Student>{
		
		public int compare(Student st1, Student st2) {
			return st1.getName().compareTo(st2.getName());
		}
	}
	public void sortByName() {
		this.studentList.sort(new SortStudentByName());
	}
	/**
	 * Sort student list by Id [increasing]
	 */
	public class SortStudentById implements Comparator<Student>{
		
		public int compare(Student st1, Student st2) {
			return st1.getId() > st2.getId() ? 1 : -1;
		}
	}
	public void sortById() {
		this.studentList.sort(new SortStudentById());
	}
	/**
	 * Find the max ID of student list
	 * @return
	 */
	public int maxId() {
		int maxId = 0;
		if(this.studentList.isEmpty() == false) {
			for(Student std : this.studentList) {
				if (std.getId() > maxId)
					maxId = std.getId();
			}
		}
		return maxId;
	}
	
	 // Input 
	
	public String inputName() {
		System.out.print("Student Name: ");
		return scanner.nextLine();
	}
	
	public int inputAge() {
		System.out.print("Student Age: ");
		while(true) {
			try {
				int age = Integer.parseInt((scanner.nextLine()));
				if (age > 10 && age < 100) {
					return age;
				}
				throw new Exception();
			}catch(Exception e) {
				System.out.println(" > Invalid age, please try again!");
			}
		}
	}
	public String inputClassroom() {
		System.out.print("Student Classroom: ");
		return scanner.nextLine();
	}
	public float inputScore() {
		System.out.print("Student Score: ");
		while(true) {
			try {
				float score = Float.parseFloat((scanner.nextLine()));
				if (score >= 0 && score <= 20) {
					return score;
				}
				throw new Exception();
			}catch(Exception e) {
				System.out.println(" > Invalid Score, please try again!");
			}
		}
	}
	/**
	 * Show all students
	 */
	public void showStudent() {
		if(this.studentList == null || this.studentList.isEmpty() == true) {
			System.out.println(" > Empty Student List!");
			return;
		}
		System.out.println("--- Student List ---");
		System.out.format("%5s | ", "ID");
		System.out.format("%20s | ", "Name");
		System.out.format("%5s | ", "Age");
		System.out.format("%25s | ", "Classroom");
		System.out.format("%10s | ", "Score");
		System.out.println();
		for(int i=1; i<81; i++)
			System.out.print("-");
		System.out.println();
		for (Student student : this.studentList) {
			System.out.format("%5d | ", student.getId());
			System.out.format("%20s | ", student.getName());
			System.out.format("%5d | ", student.getAge());
			System.out.format("%25s | ", student.getClassroom());
			System.out.format("%10.1f | ", student.getScore());
			System.out.println();
			for(int i=1; i<81; i++)
				System.out.print("-");
			System.out.println();
		}
	}
}
