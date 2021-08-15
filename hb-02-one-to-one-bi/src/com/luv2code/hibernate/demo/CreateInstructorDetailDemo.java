package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Instructor;
import com.luv2code.com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//Use session to save and retrieve objects
			
			//Create a Objects
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube/ashique.com","Watching football");
			Instructor tempInstructor = new Instructor("Ashique","Mohaimin","amornab@gmail.com");
			
			//Associate objects
			tempInstructorDetail.setInstructor(tempInstructor);
			
			//Start transaction
			session.beginTransaction();
			
			//Save student
			session.save(tempInstructorDetail);
							
			//Commit transaction
			session.getTransaction().commit();
			
			
		}
		finally
		{
			factory.close();
		}

	}

}