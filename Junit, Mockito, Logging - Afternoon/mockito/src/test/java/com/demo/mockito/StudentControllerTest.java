package com.demo.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentControllerTest {
	StudentController stud;
	@BeforeEach
	void before()
	{
		stud = new StudentController();
	}

	@Test
	void testRollNumber() {
		Student s = mock(Student.class);
		when(s.getId()).thenReturn(3195);
		int roll = stud.getStudentRollNumber(s);
		assertEquals(3195,roll);
		verify(s).getId();
	}

	@Test
	void testName() {
		Student s = mock(Student.class);
		when(s.getFirstName()).thenReturn("Kishan");
		when(s.getLastName()).thenReturn("Mishra");
		String name = stud.getFullName(s);
		assertEquals("Kishan Mishra",name);
		verify(s).getFirstName();
	}

	
	
	@AfterEach
	void after()
	{
		stud = null;
	}
}
