package lk.ac.kln.fct.learn.reflection.shapes;

abstract class Shape {
	private String name;

	public String getName() {
		return name;
	}
	
	public abstract double area(double l1, double l2);
}
