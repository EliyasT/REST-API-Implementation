package demo.stisys2;

public class Student {
	private int id;
	private String name;
	private String department;
	private int semester;

	public Student(){

	}

	public Student(int id, String name, String department, int semester) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.semester = semester;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", name='" + name +
				", department=" + department +
				", semester=" + semester +
				'}';
	}
}
