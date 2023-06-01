package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringExampleApplication.class, args);

		StudentService studservice=context.getBean(StudentService.class);

		List<Students> students=studservice.getAllStudents();
		//Students stud=studservice.getStudent(6);

		for(Students s: students)
		{
			System.out.println(s);
		}
//
//		System.out.println("find by roll");
//		System.out.println(stud);

	}

}
