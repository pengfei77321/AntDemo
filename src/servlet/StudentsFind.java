package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import util.DBConnection;

/**
 * Servlet implementation class StudentsAdd
 */
@WebServlet("/StudentsFind")
public class StudentsFind extends HttpServlet {
   //���л�ʱΪ�˱��ְ汾�ļ����ԣ����ڰ汾����ʱ�����л��Ա��ֶ����Ψһ�ԡ�
   //private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   //public StudentsFind() {
   //    super();
   //}

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    //����д��protectedΪʲô? protected����:����,ͬ��,����,
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

         DBConnection db = new DBConnection();

         String sql = "select * from student";

         ArrayList<Student> list = db.getStudentList(sql);

         request.setAttribute("list", list);
         //HttpSession session = request.getSession();
         //session.setAttribute("list", list);

         //request.getRequestDispatcher("test.jsp").forward(request, response);
         request.getRequestDispatcher("test.jsp").forward(request, response);
   }
}
