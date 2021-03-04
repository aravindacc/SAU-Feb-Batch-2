package com.webapp.springcore;
public class Point 
{
	private int W;
	private int H;

	public Point() 
	{
		super();
	}

	public Point(int W, int H) 
	{
		super();
		this.W = W;
		this.H = H;
	}

	public int getW() 
	{
		return W;
	}

	public void setW(int W) 
	{
		this.W = W;
	}

	public int getH() {
		return H;
	}

	public void setY(int H) {
		this.H = H;
	}

	@Override
	public String toString() {
		return ("W=" + W + ", H=" + H);
	}	
}