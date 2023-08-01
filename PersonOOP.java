package OOP1MiniProjects;
import java.util.*;
// This is an OOP project that make a class: 
// - Person
// - Student inherits Person
// - Teacher inherits Person

/**
 * A class representing a Person.
 *
 * This class provides methods for getting and setting the person's name and address,
 * as well as a method for getting a string representation of the person.
 * <br>
 * Example usage:
 *
 * Person p = new Person("Alice", "123 Main Street");
 * p.setAddress("456 Oak Street");
 * String name = p.getName();
 * String address = p.getAddress();
 * String description = p.toString();
 *
 * Parameters:
 *   name (String): The name of the person.
 *   address (String): The address of the person.
 *
 * Returns:
 *   None.
 *
 * Throws:
 *   None.
 */
class Person {
	private final String name;
	private String address;
	Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return name + " address(" + address + ')';
	}
}

/**
 * A class representing a Student, which is a type of Person.
 *
 * This class provides methods for adding and printing course grades,
 * as well as calculating the average grade for all courses.
 *
 * Example usage:
 *
 * Student s = new Student("Bob", "789 Elm Street", 3);
 * s.addCourseGrade("Math", 90);
 * s.addCourseGrade("Science", 80);
 * s.addCourseGrade("English", 85);
 * s.printGrades();
 * double averageGrade = s.getAverageGrade();
 *
 * Parameters:
 *   name (String): The name of the student.
 *   address (String): The address of the student.
 *   numCourses (int): The number of courses the student is taking.
 *
 * Returns:
 *   None.
 *
 * Throws:
 *   None.
 *
 * Additional information:
 *   This class extends the Person class and inherits its methods and properties.
 */
class Student extends Person {
	private final ArrayList<String> courses = new ArrayList<>();
	private final ArrayList<Integer> grades = new ArrayList<>();
	Student(String name, String address,int numCourses) {
		super(name, address);
	}
	
	public void addCourseGrade(String course,int grade){
		courses.add(course);
		grades.add(grade);
	}
	public void printGrads(){
		for (String course : courses) {
			System.out.println(course);
		}
	}
	public double getAverageGrade(){
		int total = 0;
		for (Integer grade : grades) {
			total += grade;
		}
		return total / grades.size();
	}
	public String toString(){
		return "Student: "+ getName() + " (" + getAddress()+ ")";
	}
}
/**
 * A class representing a Teacher, which is a type of Person.
 *
 * This class provides methods for adding and removing courses that the teacher is teaching.
 *
 * Example usage:
 *
 * Teacher t = new Teacher("Charlie", "345 Maple Street");
 * t.addCourse("Math");
 * t.addCourse("Science");
 * t.removeCourse("Math");
 *
 * Parameters:
 *   name (String): The name of the teacher.
 *   address (String): The address of the teacher.
 *
 * Returns:
 *   None.
 *
 * Throws:
 *   None.
 *
 * Additional information:
 *   This class extends the Person class and inherits its methods and properties.
 */
class Teacher extends Person{
	private final int numCourses = 0;
	private final ArrayList<String> courses = new ArrayList<>();
	
	Teacher(String name, String address) {
		super(name, address);
	}
	public boolean addCourse(String course){
		for (String cour : courses) {
			if(cour.equals(course)){
				return false;
			}
		}
		courses.add(course);
		return true;
	}
	public boolean removeCourse(String course){
		for (int i = 0; i < courses.size(); i++) {
			if(courses.get(i).equals(course)){
				courses.remove(i);
				return true;
			}
		}
		return false;
	}
	public String toString(){
		return "Teacher: "+ getName() + " (" + getAddress()+ ")";
	}
}

public class PersonOOP {
	public static void main(String[] args) {
	
	}
}
