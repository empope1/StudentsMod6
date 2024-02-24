

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Feb 21, 2024
 */

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Teacher teacher;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Student> listOfStudents;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setShopper(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getListOfStudents() {
		return listOfStudents;
	}
	public void setListOfStudents(List<Student> listOfStudents) {
		this.listOfStudents = listOfStudents;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", teacher=" + teacher
				+ ", listofItems=" + listOfStudents + "]";
	}
	public ListDetails(String listName, LocalDate tripDate, Teacher teacher, List<Student> listOfStudents) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.teacher = teacher;
		this.listOfStudents = listOfStudents;
	}
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ListDetails(int id, String listName, LocalDate tripDate, Teacher teacher) {
		
	}

}
