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
import model.Manager;
import model.Subject;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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


        request.setCharacterEncoding("UTF-8");
        String classfication_id = request.getParameter("classfication");
        String subject_name = request.getParameter("subject_name");
        String  manager_id = request.getParameter("manager_id");

        System.out.println(classfication_id);
        System.out.println(subject_name);
        System.out.println(manager_id);

        SubjectDAO subjectDAO = new SubjectDAO();
        Subject mna = new Subject();

        mna = subjectDAO.seRegistration(classfication_id,subject_name,manager_id);

        String teacher_id = (String)session.getAttribute("ManagerID");
        System.out.println(teacher_id);
        //キー値「subject」でG203へ渡す
        Manager mn = new Manager();
        request.setAttribute("subject",subjectDAO.selectSubject(teacher_id));

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G203.jsp");
        rd.forward(request, response);

    }

}