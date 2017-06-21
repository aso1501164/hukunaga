/*
 * date:2017/06/20
 * name:福永利恵
 * comm:ゼミ受講学生一覧検索（管理者向け）
 */

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplicationDAO;
import dao.SubjectDAO;
import model.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String subject_id = request.getParameter("subject_id");
		System.out.println("subject_id:"+subject_id);

		ApplicationDAO applicationDao = new ApplicationDAO();
		SubjectDAO subjectDao = new SubjectDAO();

		Student student = new Student();

		//キー値「student」で学生情報を渡す
		request.setAttribute("student",applicationDao.selectStudentList(subject_id));

		//▼▼▼▼確認用▼▼▼▼
		List<Student> list1 = applicationDao.selectStudentList(subject_id)	;
		for(Student list2 : list1){
			System.out.println(list2.getStudent_name());
			System.out.println(list2.getClass_name());
		}
		//▼▼▼▼▼▼▼▼▼▼

		//キー値「subject_name」で科目名を渡す
		request.setAttribute("subject_name",subjectDao.selectSubject_name(subject_id));

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G202.jsp");
		rd.forward(request, response);
	}

}
