package lk.ac.kln.fct.learn.encapsulation.main;

import java.util.ArrayList;
import java.util.HashMap;

import lk.ac.kln.fct.learn.encapsulation.control.StudentController;
import lk.ac.kln.fct.learn.encapsulation.core.Degree;
import lk.ac.kln.fct.learn.encapsulation.core.Student;
import lk.ac.kln.fct.learn.encapsulation.core.Subject;

public class Main {
	private final static String COMP102 = "COMP102";
	private final static String COMP103 = "COMP103";
	private final static String CS = "CS";
	private final static String ICT = "ICT";
	private final static String ASE = "ASE";
	private static StudentController controller = new StudentController();
	
	public static void main(String[] args) {

		ArrayList<Degree> degreesJava = new ArrayList<>();
		degreesJava.add(new Degree(CS,1)); 
		degreesJava.add(new Degree(ICT,2));
		degreesJava.add(new Degree(ASE,3));
		Subject java = new Subject(COMP102,"Program Design Using Java",degreesJava);  

		ArrayList<Degree> degreesOS = new ArrayList<>();  
		degreesOS.add(new Degree(CS,1));  
		degreesOS.add(new Degree(ICT,2));
		degreesOS.add(new Degree(ASE,3));
		Subject os = new Subject(COMP103,"Principles of OS",degreesOS);  
		
		HashMap<String,Subject> subjectsAdam = new HashMap<>();
		subjectsAdam.put(COMP102,java);
		subjectsAdam.put(COMP103,os);
		
		HashMap<String,Subject> subjectsFinn = new HashMap<>();
		subjectsFinn.put(COMP102,java);
		subjectsFinn.put(COMP103,os);
	
		controller.addStudent(100, "Adam", CS, subjectsAdam, 3.9);
		controller.addStudent(101, "Finn", ASE, subjectsFinn, 3.8);
		
		illegalStudentAccess();
		checkOriginalValues();
	}
	
	/**
	 * This method performs an illegal access to students objects and change different fields.
	 * Your aim is to prevent this attack. You can't change this method.
	 */
	public static void illegalStudentAccess() {
		HashMap<Integer, Student> students = controller.getStudents();
		students.get(100).setDegree(ASE);
		students.get(100).getSubjects().get(COMP102).setSubjectName("Dummy Java");
		students.get(101).getSubjects().get(COMP103).getAllowedDegrees().get(1).setName("ET");
		students.get(101).getSubjects().remove(COMP102);
	}
	
	public static void checkOriginalValues() {
		HashMap<Integer, Student> students = controller.getStudents();
		if(students.get(100).getDegree().equals(CS)) {
			System.out.println("Test Pass: TRUE");
		} else {
			System.out.println("Test Pass: FALSE");
		}
		
		if(students.get(100).getSubjects().get(COMP102).getSubjectName().equals("Program Design Using Java")) {
			System.out.println("Test Pass: TRUE");
		} else {
			System.out.println("Test Pass: FALSE");
		}
		
		if(students.get(101).getSubjects().get(COMP103).getAllowedDegrees().get(1).getName().equals(ICT)) {
			System.out.println("Test Pass: TRUE");
		} else {
			System.out.println("Test Pass: FALSE");
		}
		
		if(students.get(101).getSubjects().size() == 2) {
			System.out.println("Test Pass: TRUE");
		} else {
			System.out.println("Test Pass: FALSE");
		}
	}
}
