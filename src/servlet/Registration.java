package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDAO;
import dao.SubjectDAO;
import model.Manager;
import model.Subject;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
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
		request.setCharacterEncoding("UTF-8");
		String classfication_id = request.getParameter("classfication");
		String subject_name = request.getParameter("subject_name");
		String manager_id = request.getParameter("manager_id");

		System.out.println(classfication_id);
		System.out.println(subject_name);
		System.out.println(manager_id);

		SubjectDAO subjectDao = new SubjectDAO();
		Subject mna = new Subject();

		ManagerDAO managerDao = new ManagerDAO();
		Manager mn = new Manager();

		mn = managerDao.managerPointer(manager_id);

		if (mn == null) {
			System.out.println("先生IDがない");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G204.jsp");
			rd.forward(request, response);
		} else {
			mna = subjectDao.seRegistration(classfication_id, subject_name, manager_id);
			String teacher_id = (String) session.getAttribute("ManagerID");
			String permission = (String) session.getAttribute("Permission");
			System.out.println(teacher_id);
			if (permission.equals("0")) { // 権限が「０」（担任）なら
				// キー値「subject」で担当する科目をG203へ渡す
				request.setAttribute("subject", subjectDao.selectSubject(teacher_id));
			} else if (permission.equals("1")) { // 権限が「1」（管理者）なら
				// キー値「subject」ですべてのゼミ科目をG203へ渡す
				request.setAttribute("subject", subjectDao.selectAllSubject());

				List<Subject> list1 = subjectDao.selectAllSubject();
				for (Subject list2 : list1) {
					System.out.println(list2.getSubject_id());
					System.out.println(list2.getClassification_id());
					System.out.println(list2.getSubject_name());
					System.out.println(list2.getManeger_id());
					System.out.println(list2.getClassification_name());
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G203.jsp");
					rd.forward(request, response);
				}
			}
		}
	}
}