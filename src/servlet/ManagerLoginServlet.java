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

		// ▼▼ログイン用処理▼▼
		ManagerDAO managerDAO = new ManagerDAO();
		Manager mn = new Manager();

		// ログインユーザー情報を探す
		mn = managerDAO.selectLoginManager(userID, password);
		HttpSession session = request.getSession();

		// ログイン処理
		String path = "";
		if (mn != null) { // idとpassが一致したらG102に遷移
			// セッションスコープにログインユーザー情報を保存(getsession「ManagerID」で先生のIDと権限が呼べる)
			session.setAttribute("ManagerID", mn.getManager_id());
			session.setAttribute("Permission", mn.getPermission());
			session.setAttribute("class_name", mn.getClass_name());
			System.out.println("権限："+mn.getPermission());
			path = "WEB-INF/jsp/G203.jsp";

			SubjectDAO subjectDao = new SubjectDAO();
			Subject subject = new Subject();

			if(mn.getPermission().equals("0")){	//権限が「０」（担任）なら
				//キー値「subject」で担当する科目をG203へ渡す
				request.setAttribute("subject",subjectDao.selectSubject(mn.getManager_id()));
			}else if(mn.getPermission().equals("1")){	//権限が「1」（管理者）なら
				//キー値「subject」ですべてのゼミ科目をG203へ渡す
				request.setAttribute("subject",subjectDao.selectAllSubject());

				List<Subject> list1 = subjectDao.selectAllSubject();
				for(Subject list2 : list1){
					System.out.println(list2.getSubject_id());
					System.out.println(list2.getClassification_id());
					System.out.println(list2.getSubject_name());
					System.out.println(list2.getManeger_id());
					System.out.println(list2.getClassification_name());
				}
			}

		} else { // 不一致なら
			request.setAttribute("alert"," no");
			path = "WEB-INF/jsp/G201.jsp";	//できたらエラーページ作るとかアラート鳴らすとかしてください
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
