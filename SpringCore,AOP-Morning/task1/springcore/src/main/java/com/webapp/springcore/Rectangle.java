package com.webapp.springcore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Rectangle 
{
	private List<String> list;
	private HashMap<Integer , Point> map;
	private HashSet<Point> set;
	private Point PointA;
	private Point PointB;
	private Point PointC;
	private Point PointD;
	private int height;
	private int width;

	public Rectangle() 
	{
		super();
	}

	public Rectangle(Point PointA, Point PointB, Point PointC, Point PointD,List<String> list , HashMap<Integer , Point> map , HashSet<Point> set) 
	{
		super();
		this.PointA = PointA;
		this.PointB = PointB;
		this.PointC = PointC;
		this.PointD = PointD;
		this.list=list;
		this.map=map;
		this.set=set;
		this.height = PointB.getH()-PointA.getH();
		this.width = PointD.getW()-PointA.getW();
	}

	public Point getPointA() 
	{
		return PointA;
	}

	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}

	public Point getPointB() {
		return PointB;
	}

	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}

	public Point getPointC() {
		return PointC;
	}

	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}

	public Point getPointD() {
		return PointD;
	}

	public void setPointD(Point PointD) {
		this.PointD = PointD;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() 
	{
		return "{"+"PointA="+"("+ PointA + ")"+"} PointB="+"(" + PointB + ")"+", PointC="+"(" + PointC + ")"+", PointD="+"(" + PointD
				+")"+ ", Height=" + height + ", Width=" + width + "}";
	}
	public void printList() 
	{
		for(int i=0;i<this.list.size();i++)
		{
			System.out.println("  "+list.get(i));
		}
	}
	public void printMap() 
	{
		for(int i=1;i<=this.map.size();i++)
		{
			System.out.println("  "+map.get(i));
		}
	}
	public void printSet() 
	{
		Iterator<Point> itr = set.iterator();
		while(itr.hasNext()){
			  System.out.println(" "+itr.next());
			}
	}

}