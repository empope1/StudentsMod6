import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Feb 22, 2024
 */
public class StudentHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StudentRoster");

	public void insertStudent(Student s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Student> showAllStudents(){
		EntityManager em = emfactory.createEntityManager();
		List<Student> allStudents = em.createQuery("SELECT s from Student s").getResultList();
		return allStudents;
		
	}

	public void deleteStudent(Student ToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("SELECT li from Student li where li.name= :selectedName and li.major= :selectedMajor", Student.class);
		typedQuery.setParameter("selectedName", ToDelete.getName());
		typedQuery.setParameter("selectedMajor", ToDelete.getMajor());
		
		typedQuery.setMaxResults(1);
		
		Student result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Student searchForStudentsById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Student found = em.find(Student.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateStudent(Student toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(em);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Student> searchForStudentByMajor(String studentMajor) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select li from Student li where li.major = :selectedMajor", Student.class);
		
		typedQuery.setParameter("selectedMajor", studentMajor);
		
		List<Student> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;
	}

	public List<Student> searchForStudentByName(String studentName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select li from Student li where li.name = :selectedName", Student.class);
		
		typedQuery.setParameter("selectedName", studentName);
		
		List<Student> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
