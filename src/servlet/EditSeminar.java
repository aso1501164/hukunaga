/*
 * date:2017/06/09
 * name:福永利恵
 * comm:ゼミ科目編集用サーブレット（管理者向け）
 */

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class EditSeminar
 */
@WebServlet("/EditSeminar")
public class EditSeminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSeminar() {
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

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		// セッション情報からログインユーザの情報を取得
		HttpSession session = request.getSession();
		String ManagerID = (String) session.getAttribute("ManagerID");

		SubjectDAO subjectDao = new SubjectDAO();
		Subject subject = new Subject();

		//キー値「subject」でG203へ渡す
		request.setAttribute("subject",subjectDao.selectSubject(ManagerID));
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G203.jsp");
		rd.forward(request, response);
	}

}
