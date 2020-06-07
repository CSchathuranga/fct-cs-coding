package lk.ac.kln.fct.learn.reflection.main;

import java.awt.Color;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


import lk.ac.kln.fct.learn.reflection.core.Shape;
import lk.ac.kln.fct.learn.reflection.shapes.Rectangle;
import lk.ac.kln.fct.learn.reflection.shapes.Square;
import lk.ac.kln.fct.learn.reflection.util.Dimension;

public class Main {
	private final static String COLOR = "Color";
	private final static String GET = "get";
	private final static String SET = "set";
	
	public static void main(String[] args) {
		Dimension dim1 = new Dimension(5,10);
		Dimension dim2 = new Dimension(15,15);
		
		Shape shape1 = createShape(Rectangle.class, dim1);
		Shape shape2 = createShape(Square.class, dim2);
		
		Color red = new Color(255,0,0);
		Color green = new Color(0, 255, 0);
		System.out.println(shape1.getName()+" : "+shape1.area() +" : "+ setColorAndGetColorName(shape1,COLOR,red));
		System.out.println(shape2.getName()+" : "+shape2.area()+" : "+ setColorAndGetColorName(shape2,COLOR,green));
	}
/**
 * 
 * @param clazz Unknown class that extends Shape 
 * @param dimension height and width of the object
 * @return Instance of lk.ac.kln.fct.learn.reflection.core.Shape
 */
	public static Shape createShape(Class<? extends Shape> clazz, Dimension dimension) {
		try {
			Constructor<?> constructor=clazz.getDeclaredConstructor(Dimension.class);
			constructor.setAccessible(true);
			return (Shape)constructor.newInstance(dimension);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid class or invalid Type", e);
		}
	}
	/**
	 * 
	 * @param shape Object of lk.ac.kln.fct.learn.reflection.shapes
	 * @param name name="color";
	 * @param value java.awt.Color color
	 * @return color of the object
	 */
	public static String setColorAndGetColorName(Shape shape, String name, Color value) {
		String getterName = GET + name;
		String setterName = SET + name;
		String fieldName = name.toLowerCase();
		Class<?> clazz = shape.getClass();
		try {
			Method setterMethod=clazz.getDeclaredMethod(setterName,clazz.getDeclaredField(fieldName).getType());
			setterMethod.invoke(shape, value);
			return (String) clazz.getMethod(getterName).invoke(shape);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid class or invalid Type", e);
		}
	}
}
