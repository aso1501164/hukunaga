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

import dao.HistoryDAO;
import model.History;

/**
 * Servlet implementation class ToG106
 */
@WebServlet("/ToG106")
public class ToG106 extends HttpServlet {
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
		HttpSession session = request.getSession();
		String student_id = "0001" ;//(String)session.getAttribute("student_id");

		HistoryDAO historyDAO = new HistoryDAO();
		ArrayList<History> history = historyDAO.getHistory(student_id);

		request.setAttribute("History",history);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G106.jsp");
		rd.forward(request, response);

	}

}
