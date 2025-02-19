package org.jsp.many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapStudentToBatch 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		int bid=1;
		int sid=1;
		
		Batch b = em.find(Batch.class, bid);
		Student s = em.find(Student.class, sid);
		
		List<Student> students = b.getStudents();
		students.add(s);
		
		et.begin();
		em.merge(b);
		et.commit();
		System.out.println("Done");
	}
}
