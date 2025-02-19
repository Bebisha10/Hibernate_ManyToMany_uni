package org.jsp.many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test1 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		int bid = 3;
		Batch b = em.find(Batch.class, bid);
		System.out.println(b.getName());
		
		List<Student> students = b.getStudents();
		for(Student s:students)
		{
			System.out.println(s.getName());
		} 
	}
}
