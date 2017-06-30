package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationDAO;
import dao.StudentDAO;
import model.Application;
import model.Student;

/**
 * Servlet implementation class LoginStudent
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// リクエストパラメータの取得
//		ApplicationDAO applicationDAO = new ApplicationDAO();
//
//		String studentId = request.getParameter("application");
//
//		ArrayList<Application> applications = applicationDAO.getApplicationsByStudentId(studentId);
//
//		request.setAttribute("applications", applications);
//
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G102.jsp");
//		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String student_id = request.getParameter("student_id");
		String password = request.getParameter("password");
		String path = "";

		// 確認
		System.out.println(student_id);
		System.out.println(password);

		// ▼▼ログイン用処理▼▼
		StudentDAO studentDAO = new StudentDAO();
		Student st = new Student();

		// ログインユーザー情報を探す
		st = studentDAO.selectLoginStudent(student_id, password);
		HttpSession session = request.getSession();

		// ログイン処理

		if (st != null) { // idとpassが一致したらG102に遷移
			session.setAttribute("loginStudentID", st.getStudent_id());
			// セッションスコープにログインユーザー情報を保存(getsession「loginStudentID」でいつでも生徒のID呼べるよ)
			ApplicationDAO applicationDAO = new ApplicationDAO();
			ArrayList<Application> confList = applicationDAO.selectConfList(student_id);
			request.setAttribute("ConfList", confList);



			path = "WEB-INF/jsp/G102.jsp";

		} else { // 不一致なら
			System.out.println("ログイン失敗");
			request.setAttribute("errorMessage", "会員IDまたはパスワードが違います。");
			path = "WEB-INF/jsp/G101.jsp";	//できたらエラーページ作るとかアラート鳴らすとかしてください
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
