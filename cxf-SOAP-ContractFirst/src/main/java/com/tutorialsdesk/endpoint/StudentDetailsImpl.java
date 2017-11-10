package com.tutorialsdesk.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.tutorialsdesk.services.studentdetails.StudentDetailsPortType;
import com.tutorialsdesk.types.studentdetails.RollNumber;
import com.tutorialsdesk.types.studentdetails.Student;

public class StudentDetailsImpl implements StudentDetailsPortType{

	List<Student> studentList = new ArrayList<>();
	
	StudentDetailsImpl(){
		Student s1 = new Student();
		s1.setRollNumber("1");
		s1.setFirstName("Prakash");
		s1.setLastName("Sharma");
		s1.setDob("04/02/1986");
		studentList.add(new Student());
	}
	
	@Override
	public Student getStudent(RollNumber rollNumber) {
			Student s1 = new Student();
			s1.setRollNumber(rollNumber.getRollNumber());
			s1.setFirstName("Prakash");
			s1.setLastName("Sharma");
			s1.setDob("04/02/1986");
		return s1;
	}

}
