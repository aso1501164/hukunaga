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
import dao.SubjectDAO;
import model.Application;
import model.Subject;

/**
 * Servlet implementation class ToG103
 */
@WebServlet("/ToG103")
public class ToG103 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	//登録情報持ってくるDAO
	HttpSession session = request.getSession();
	String student_id = (String)session.getAttribute("loginStudentID");

	ApplicationDAO applicationDAO = new ApplicationDAO();
	ArrayList<Application> confList = applicationDAO.selectConfList(student_id);
	request.setAttribute("ConfList", confList);

	//全セミナーを持ってくる奴～www
	SubjectDAO subjectDAO = new SubjectDAO();
	ArrayList<Subject> allSelect = subjectDAO.allSelectList();
	request.setAttribute("AllSelectList", allSelect);



	if(confList.size() == 0){
		// 登録情報がなかった場合はリクエストスコープへメッセージを格納する。
		request.setAttribute("message", "現在登録情報はありません。");
	}

	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G103.jsp");
	rd.forward(request, response);

}
}