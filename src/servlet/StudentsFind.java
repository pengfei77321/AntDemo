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
   //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
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
    //例子写的protected为什么? protected作用:本类,同包,子类,
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
