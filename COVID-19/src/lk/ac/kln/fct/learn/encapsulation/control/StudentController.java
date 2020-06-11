package lk.ac.kln.fct.learn.encapsulation.control;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import lk.ac.kln.fct.learn.encapsulation.core.Student;
import lk.ac.kln.fct.learn.encapsulation.core.Subject;

public class StudentController implements Cloneable {
	private static HashMap<Integer, Student> students = new HashMap<>();
	
	public void addStudent(Integer studentID, String name, String degree, HashMap<String,Subject> subjects, Double gpa) {
		Student student = new Student(studentID, name, degree,subjects,gpa);
		students.put(studentID, student);
	}
	
	public HashMap<Integer, Student> getStudents() {
		HashMap<Integer, Student> copyStudents = new HashMap<>();
		Iterator<Entry<Integer, Student>> it = students.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, Student> entry =  it.next();
			copyStudents.put(entry.getKey(), entry.getValue().clone());
		}
		return copyStudents;
	}
}
