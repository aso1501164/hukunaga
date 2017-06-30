package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/ToG105")
public class ToG105 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToG105() {
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

    	 HttpSession session = request.getSession();
    	 String student_id = (String)session.getAttribute("loginStudentID");

         request.setCharacterEncoding("UTF-8");
         String subject_id_1 = request.getParameter("subject_1");
         String subject_id_2 = request.getParameter("subject_2");

//         ApplicationDAO applicatioinDAO = new ApplicationDAO();
//         applicatioinDAO.InsertApplication(student_id,subject_id_1,subject_id_2);

         //G105に表示するためにリクエストスコープに格納

         RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G105.jsp");
         rd.forward(request, response);

    }

}