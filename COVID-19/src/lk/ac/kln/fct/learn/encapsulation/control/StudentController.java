package lk.ac.kln.fct.learn.encapsulation.control;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import lk.ac.kln.fct.learn.encapsulation.core.Student;

public class StudentController implements Serializable {
	public final HashMap<String, Student> students = new HashMap<>();
	
	public void addNewStudent(Student s) {
		students.put(s.getId(), s);
	}

	public StudentController clone() {
		  ObjectOutputStream oos = null;
	      ObjectInputStream ois = null;
	      try
	      {
	         ByteArrayOutputStream bos = new ByteArrayOutputStream();
	         oos = new ObjectOutputStream(bos);
	         oos.writeObject(this);
	         oos.flush();
	         ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
	         ois = new ObjectInputStream(bin);
	         bin.close();
	         bos.close();
	         oos.close();
			 ois.close();
	         return (StudentController) ois.readObject();
	      }
	      catch(Exception e)
	      {
	        System.out.println(e.toString());
	      }
		return null;
	}
}
