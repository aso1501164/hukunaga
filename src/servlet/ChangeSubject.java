package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationDAO;
import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class Registration
 */

@WebServlet("/ChangeSubject")

public class ChangeSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();
		String student_id = (String) session.getAttribute("loginStudentID");
		request.setCharacterEncoding("UTF-8");
		String subject_name_1 = request.getParameter("subject_1");
		String subject_name_2 = request.getParameter("subject_2");
		SubjectDAO subjectDAO = new SubjectDAO();
		Subject subject1 = subjectDAO.getSubjectid(subject_name_1);
		Subject subject2 = subjectDAO.getSubjectid2(subject_name_2);
		String subject3 = subject1.getSubject_id();
		String subject4 = subject2.getSubject_id();
		request.setAttribute("subject1", subject1);
		request.setAttribute("subject2", subject2);
		Locale locale = new Locale("ja","JP","JP");
		SimpleDateFormat sdf = new SimpleDateFormat("GGGGyyyy年",locale);
		String year = sdf.format(new Date());

		ApplicationDAO applicatioinDAO = new ApplicationDAO();
		applicatioinDAO.UpdateApplication( subject3, subject4,subject_name_1,subject_name_2,year,student_id);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
		rd.forward(request, response);

	}

}