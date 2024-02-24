import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Feb 24, 2024
 */
public class SemesterHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StudentRoster");

	public void insertSemester(Teacher s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Teacher> showAllTeachers(){
		EntityManager em = emfactory.createEntityManager();
		List<Teacher> allTeachers = em.createQuery("SELECT s from Teacher s").getResultList();
		return allTeachers;
	}
	
	public Teacher findTeacher(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Teacher> typedQuery = em.createQuery("select sh from Teacher sh where sh.teacherName = :selectedName",Teacher.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Teacher foundTeacher;
		try {
			foundTeacher = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundTeacher = new Teacher(nameToLookUp);
		}
		em.close();

		return foundTeacher;
	}

}
