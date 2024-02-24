import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Feb 22, 2024
 */
public class TeacherHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StudentRoster");

	public void insertTeacher(Teacher s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Teacher> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<Teacher> allTeachers = em.createQuery("SELECT d FROM Teacher d").getResultList();
		return allTeachers;
	}
	
	public Teacher searchForTeachersById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Teacher found = em.find(Teacher.class, tempId);
		em.close();
		return found;
	}

	public void deleteList(Teacher listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Teacher> typedQuery = em.createQuery("SELECT teacher from Teacher teacher where teacher.id= :selectedId", Teacher.class);
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		Teacher result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateList(Teacher toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
