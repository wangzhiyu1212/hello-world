package codetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CacheTest {
	private static List<Student> students;
	 
	static {
		students = new ArrayList<Student>();
 
		Student student1 = new Student();
		student1.setName("����");
		student1.setAge(18);
		Student student2 = new Student();
		student2.setName("����");
		student2.setAge(17);
		Student student3 = new Student();
		student3.setName("����");
		student3.setAge(20);
		Student student4 = new Student();
		student4.setName("����");
		student4.setAge(18);
		Student student5 = new Student();
		student5.setName("����");
		student5.setAge(18);
 
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
	}
 
	public static List<Student> findAllStudents() {
		return students;
	}
	
	public static Student getStudentByName(String name) {
		for (Student student : students) {
			if (student.getName().equals(name)) {
				return student;
			}
		}
		return null;
	}
 
	public static void main(String[] args) {
		List<Student> students1 = CacheTest.findAllStudents();
		System.out.println(students1.size());
		for (Iterator<Student> iter = students1.iterator(); iter.hasNext();) {
			Student student = iter.next();
			if (student.getName().equals("����")) {
				iter.remove();
			}
		}
 
		List<Student> students2 = CacheTest.findAllStudents();
		System.out.println(students2.size());
	}

}


class Student {
 
	private String name;
 
	private int age;
 
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
}
