package com.springcore.springcore2.Service;

import com.springcore.springcore2.Model.Circle;
import com.springcore.springcore2.Model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	public Circle getCircle() 
	{
		return circle;
	}

	public void setCircle(Circle circle) 
	{
		this.circle = circle;
	}

	public Triangle getTriangle() 
	{
		return triangle;
	}

	public void setTriangle(Triangle triangle) 
	{
		this.triangle = triangle;
	}
	
	public int throwException() throws ArithmeticException{
		return 1/0;
	}
	
//	public String sayGreetings(String greet) {
//		return greet;
//	}
}
