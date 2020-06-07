package lk.ac.kln.fct.learn.reflection.shapes;

import java.awt.Color;

import lk.ac.kln.fct.learn.reflection.core.Shape;
import lk.ac.kln.fct.learn.reflection.util.Dimension;

public class Square extends Shape {
	private double h;
	private double w;
	private String name = SQUARE;
	private Color color;
	
	public Square(String name) {
		this.name = name;
	}
	
	private Square(Dimension dim) {
		this.h = dim.getHeight();
		this.w = dim.getWidth();
	}
	
	private Square(double h, double w, String name) {
		this.w = w;
		this.h = h;
		this.name = name;
	}
	

	@Override
	public double area() {
		return h * w;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public String getColor() {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		
		if(r == 0 && g == 0 && b == 0) {
			return BLACK;
		} else if(r == 255 && g == 0 && b == 0) {
			return RED;
		} else if(r == 0 && g == 255 && b == 0) {
			return GREEN;
		} else if(r == 0 && g == 0 && b == 255) {
			return BLUE;
		} else {
			return ERROR;
		}
	}
}
