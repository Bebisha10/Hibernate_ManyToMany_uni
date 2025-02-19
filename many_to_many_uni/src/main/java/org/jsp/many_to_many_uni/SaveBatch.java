package org.jsp.many_to_many_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatch 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter code");
		String code = sc.next();
		System.out.println("Enter name");
		String name = sc.next();
		
		Batch b = new Batch(0, code, name, null);
		
		et.begin();
		em.persist(b);
		et.commit();
		System.out.println("Done");
	}
}
