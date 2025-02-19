package org.jsp.many_to_many_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudent 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Enter phone");
		long phone = sc.nextLong();
		
		Student s = new Student(0, name, email, phone);
		
		et.begin();
		em.persist(s);
		et.commit();
		System.out.println("Done");
	}
}
