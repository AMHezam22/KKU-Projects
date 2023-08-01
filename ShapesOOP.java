package OOP1MiniProjects;

//Super class
abstract class Shape {
	protected String color = "red";
	protected boolean filled = true;
	public Shape() {
	}
	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	@Override
	public String toString() {
		return "Shape(" + "color='" + color + '\'' + ", filled=" + filled + ')';
	}
}
//subclass 1
class Circle extends Shape {
	protected double radius = 1.0;
	public Circle() {
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	public Circle(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
	@Override
	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}
	@Override
	public String toString() {
		return "Circle(" + "Shape(" + "color='" + color + '\'' + ", filled=" + filled + ')' + ", radius=" + radius + ')';
	}
}
//subclass 2
class Rectangle extends Shape {
	protected double width = 1;
	protected double length = 1;
	public Rectangle() {
	}
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	public Rectangle(String color, boolean filled, double width, double length) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	@Override
	public double getArea() {
		return width * length;
	}
	@Override
	public double getPerimeter() {
		return width * 2 + length * 2;
	}
	@Override
	public String toString() {
		return "Rectangle{" + "Shape{" + "color='" + color + '\'' + ", filled=" + filled + '}' + ", width=" + width + ", length=" + length + '}';
	}
	public double getSide() {
		return width;
	}
}
//subclass 1 of rectangle
class Square extends Rectangle {
	public Square() {
	}
	public Square(double side) {
		super(side, side);
	}
	public Square(String color, boolean filled, double side) {
		super(color, filled, side, side);
	}
	public double getSide() {
		return width;
	}
	public void setSide(double side) {
		width = length = side;
	}
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
	}
	@Override
	public void setLength(double length) {
		super.setLength(length);
	}
	@Override
	public String toString() {
		return "Square{" + "Rectangle{" + "Shape{" + "color='" + color + '\'' + ", filled=" + filled + '}' + ", width=" + width + ", length=" + length + "}}";
	}
}

public class ShapesOOP {
	public static void main(String[] args) {
		Circle s1 = new Circle("red", false, 5.5); // Upcast
		System.out.println(s1);
		System.out.println(s1.getArea());
		System.out.println(s1.getPerimeter());
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		System.out.println(s1.getRadius());
		System.out.println(s1);
		System.out.println(s1.getArea());
		System.out.println(s1.getPerimeter());
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		System.out.println(s1.getRadius());
		Rectangle s3 = new Rectangle("red", false, 1.0, 2.0);
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		System.out.println(s3.getLength());
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getColor());
		System.out.println(s3.getLength());
		Square s4 = new Square(6.6);
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		System.out.println(s4.getSide());
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		System.out.println(((Rectangle) s4).getSide());
		System.out.println(s4.getLength());
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		System.out.println(s4.getSide());
		System.out.println(s4.getLength());
	}
}
