package student.bo;

public class Student {
	private int id;
	private String name;
	private int age;
	private String classroom;
	private float score;
	
	/**
	 * Constructor for Student
	 * @param id
	 * @param name
	 * @param age
	 * @param classroom
	 * @param score
	 */
	
	public Student(int id, String name, int age, String classroom, float score) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.classroom = classroom;
		this.score = score;
		
				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
}
