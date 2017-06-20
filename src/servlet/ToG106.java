package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToG106
 */
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
		/*HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");

		DAO DAO = new DAO();
		Model model = new Model();

		Subjects subjects = DAO.getModel(userid);

		request.setAttribute("history",model);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/product-retrieve.jsp");
		rd.forward(request, response);
*/
	}

}
