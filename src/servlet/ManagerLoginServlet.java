package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDAO;
import model.Manager;

/**
 * Servlet implementation class ManagerLoginServlet
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() {
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
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

		// 確認
		System.out.println(userID);
		System.out.println(password);

		// ▼▼ログイン用処理▼▼
		ManagerDAO managerDAO = new ManagerDAO();
		Manager mn = new Manager();

		// ログインユーザー情報を探す
		mn = managerDAO.selectLoginManager(userID, password);
		HttpSession session = request.getSession();

		// ログイン処理
		String path = "";
		if (mn != null) { // idとpassが一致したらG102に遷移
			// セッションスコープにログインユーザー情報を保存
			session.setAttribute("loginTeacher", mn.getTeacher_id());
			//request.setAttribute("alart"," ok");
			path = "WEB-INF/jsp/G202.jsp";
			//request.setAttribute("alart", "ok");	//←これ動かんので直して
		} else { // 不一致なら
			request.setAttribute("alart"," no");
			path = "WEB-INF/jsp/G201.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
