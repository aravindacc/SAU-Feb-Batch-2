package com.webapp.springcore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.*;

@Configuration
public class config 
{
	@Bean
	public Rectangle rectangle() 
	{
		//using List
		List<String> list = new ArrayList<String>();
		list.add("Pink");
		list.add("Red");
		list.add("Yellow");
		
		//using map
		Point A=PointA();
		Point B=PointB();
		Point C=PointC();
		Point D=PointD();
		HashMap<Integer, Point> map = new HashMap<Integer , Point>();
		map.put(1, A);
		map.put(2, B);
		map.put(3, C);
		map.put(4, D);
		
		//using Set
		Point A1=PointA();
		Point B1=PointB();
		Point C1=PointC();
		Point D1=PointD();
		HashSet<Point> set = new HashSet<Point>();
		set.add(A1);
		set.add(B1);
		set.add(C1);
		set.add(D1);

		return new Rectangle( PointA(), PointB(), PointC(), PointD(), list , map , set);
	}
	@Bean
	public Point PointA() {
		return new Point(10, 0);
	}

	@Bean
	public Point PointB() {
		return new Point(0, 10);
	}

	@Bean
	public Point PointC() {
		return new Point(25, 12);
	}

	@Bean
	public Point PointD() {
		return new Point(15, 0);
	}

}