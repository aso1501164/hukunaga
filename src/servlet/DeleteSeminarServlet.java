/*
 * date:2017/06/16
 * name:福永利恵
 * comm:ゼミ科目削除用サーブレット（管理者向け）
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

import dao.SeminarDAO;

/**
 * Servlet implementation class DeleteSeminarServlet
 */
@WebServlet("/DeleteSeminarServlet")
public class DeleteSeminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSeminarServlet() {
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
		String seminar_id = request.getParameter("delete");

		// ログインユーザー情報の取得
		// HttpServletRequestからHttpSessionを取得
		HttpSession session = request.getSession();
		String loginTeacherID = (String) session.getAttribute("loginTeacherID");

		// ゼミ科目を削除する
		SeminarDAO seminarDao = new SeminarDAO();
		seminarDao.deleteSeminar(seminar_id);

		System.out.println("delete:" + seminar_id);

		//キー値「subject」でG203へ渡す
		request.setAttribute("subject",seminarDao.selectSubject(loginTeacherID));


		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G203.jsp");
		rd.forward(request, response);

	}

}
