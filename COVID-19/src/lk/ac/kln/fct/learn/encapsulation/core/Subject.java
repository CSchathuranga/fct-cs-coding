package lk.ac.kln.fct.learn.encapsulation.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Subject implements Serializable  {
	private String subjectID;
	private String subjectName;
	private ArrayList<Degree> allowedDegrees;
	
	public Subject(String subjectID, String subjectName, ArrayList<Degree> allowedDegrees) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.allowedDegrees = allowedDegrees;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
 
	public ArrayList<Degree> getAllowedDegrees() {
		return allowedDegrees;
	}
 
	public void setAllowedDegrees(ArrayList<Degree> allowedDegrees) {
		this.allowedDegrees = allowedDegrees;
	}
	
	@Override
	public Subject clone(){
	        Subject subject = null;
	        try {
	            subject = (Subject) super.clone();
	            ArrayList<Degree> copyAllowDegree = new ArrayList<Degree>();
	    		Iterator<Degree> it = allowedDegrees.iterator();
	    		
	    		while(it.hasNext()) {
	    			Degree temp = it.next();
	    			copyAllowDegree.add(new Degree(temp.getName(), temp.getId()));
	    		}   	            
	            subject.allowedDegrees = copyAllowDegree;
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	        }        
	        return subject;
	    }
}
