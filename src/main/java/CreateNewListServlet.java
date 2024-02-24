

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentHelper lih = new StudentHelper();
		String listName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String teacherName = request.getParameter("teacherName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedStudents = request.getParameterValues("allStudentsToAdd");
		List<Student> selectedStudentsInList = new ArrayList<Student>();
		
		if(selectedStudents != null && selectedStudents.length > 0){
			for(int i = 0; i<selectedStudents.length; i++) {
				Student c = lih.searchForStudentsById(Integer.parseInt(selectedStudents[i]));
				selectedStudentsInList.add(c);
			}
		}
		
		Teacher teacher = new Teacher(teacherName);
		
		Teacher sld = new Teacher(listName, ld, teacher);
		
		sld.setListofStudents(selectedStudentsInList);
		
		TeacherHelper slh = new TeacherHelper();
		slh.insertTeacher(sld);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
