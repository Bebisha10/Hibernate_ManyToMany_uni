package org.jsp.many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrintBatchNameByStudentId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		int sid = 1;
		Student s = em.find(Student.class, sid);
		
		Query q = em.createQuery("select b from Batch b");
		
		List<Batch> b1 = q.getResultList();
		for(Batch b:b1) {
			List<Student> students = b.getStudents();
			if(students.contains(s)) {
				System.out.println(b.getName());
			}
		}
		
		
	}
}