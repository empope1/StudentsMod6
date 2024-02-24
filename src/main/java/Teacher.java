import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author emilylester empope1
 * CIS 175 Spring 2024
 * Feb 22, 2024
 */

@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue
	private int id;
	private String teacherName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private Teacher teacher;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Student> listofStudents;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String teacherName) {
		super();
		this.id = id;
		this.teacherName = teacherName;
	}

	public Teacher(String teacherName) {
		super();
		this.teacherName = teacherName;
	}

	public Teacher(int id, String teacherName, LocalDate tripDate, Teacher teacher, List<Student> listofStudents) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.tripDate = tripDate;
		this.teacher = teacher;
		this.listofStudents = listofStudents;
	}

	public Teacher(String teacherName, LocalDate tripDate, List<Student> listofStudents) {
		super();
		this.teacherName = teacherName;
		this.tripDate = tripDate;
		this.listofStudents = listofStudents;
	}

	public Teacher(String teacherName, LocalDate tripDate, Teacher teacher) {
		super();
		this.teacherName = teacherName;
		this.tripDate = tripDate;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getListofStudents() {
		return listofStudents;
	}

	public void setListofStudents(List<Student> listofStudents) {
		this.listofStudents = listofStudents;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherName=" + teacherName + "]";
	}
	
	
	

}
