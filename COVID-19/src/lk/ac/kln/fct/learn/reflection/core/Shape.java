package lk.ac.kln.fct.learn.reflection.core;


public abstract class Shape {
	protected static final String RECTANGLE = "RECTANGLE";
	protected static final String SQUARE = "SQUARE";
	protected static final String BLACK = "BLACK";
	protected static final String RED = "RED";
	protected static final String GREEN = "GREEN";
	protected static final String BLUE = "BLUE";
	protected static final String ERROR = "ERROR";
	
	public abstract double area();	
	public abstract String getName();

}
