//使わん
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
import dao.SubjectDAO;
import model.Manager;
import model.Subject;

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
			// セッションスコープにログインユーザー情報を保存(getsession「ManagerID」で先生のID呼べる)
			session.setAttribute("ManagerID", mn.getManager_id());
			//request.setAttribute("alart"," ok");
			path = "WEB-INF/jsp/G203.jsp";
			//request.setAttribute("alart", "ok");	//←これ動かんので直して

			//ログインした先生の担当するゼミ教科の取得
			SubjectDAO subjectDao = new SubjectDAO();
			Subject subject = new Subject();
			//キー値「subject」でG203へ渡す
			request.setAttribute("subject",subjectDao.selectSubject(mn.getManager_id()));

		} else { // 不一致なら
			request.setAttribute("alart"," no");
			path = "WEB-INF/jsp/G101.jsp";	//できたらエラーページ作るとかアラート鳴らすとかしてくださ
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
