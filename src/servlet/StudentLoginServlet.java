package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

		// 確認
		System.out.println(userID);
		System.out.println(password);

		// ▼▼ログイン用処理▼▼
		StudentDAO studentDAO = new StudentDAO();
		Student st = new Student();

		// ログインユーザー情報を探す
		st = studentDAO.selectLoginStudent(userID, password);
		HttpSession session = request.getSession();

		// ログイン処理
		String path = "";
		if (st != null) { // idとpassが一致したらG102に遷移
			path = "WEB-INF/jsp/G102.jsp";
			// セッションスコープにログインユーザー情報を保存
			session.setAttribute("loginStudent", st.getStudent_id());
			//request.setAttribute("alart"," ok");
			path = "WEB-INF/jsp/G102.jsp";
			//request.setAttribute("alart", "ok");	//←これ動かんので直して
		} else { // 不一致なら
			request.setAttribute("alart"," no");
			path = "WEB-INF/jsp/G101.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
