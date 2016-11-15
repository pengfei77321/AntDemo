package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Student;


public class DBConnection {

   /**
    * 驱动类名称
    */
   private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

   /**
    * 数据库连接字符串   jdbc:mysql://localhost:3306/test
    */
   private static final String URL = "jdbc:mysql://localhost:3306/test";

   /**
    * 数据库用户名
    */
   private static final String USERNAME = "root";

   /**
    * 数据库密码
    */
   private static final String PASSWORD = "root";

   /**
    * 数据库连接类
    */
   private static Connection conn;

   /**
    * 数据库操作类
    */
   private static Statement stmt;



   // 加载驱动
   static {
      try {
         Class.forName(DRIVER_CLASS);
      }
      catch(Exception e) {
         System.out.println("加载驱动错误");
         System.out.println(e.getMessage());
      }
   }

   // 取得连接
   private static Connection getConnection(){

      try {
         conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      }
      catch(Exception e) {
         System.out.println("取得连接错误");
         System.out.println(e.getMessage());
      }
      
      return conn;
   }

   /**
    * 执行 增、删、改 操作
    * @param sql
    */
   /*
   public void ExecuteDel(String sql){

      try {
         stmt = getConnection().createStatement();
      }
      catch(Exception e) {
         System.out.println("statement取得错误");
         System.out.println(e.getMessage());
      }

      try {
         int rows = stmt.executeUpdate(sql);
         if(rows >= 1){
            System.out.println("成功删除.....");
         }
         else {
            System.out.println("删除失败.....");
         }
      }
      catch(Exception e) {

      }
   }
   */

   /**
    * 读取数据库中的数据（查询操作）
    * @param sql
    * @return
    */
   public ArrayList<Student> getStudentList(String sql){

      ArrayList<Student> list = new ArrayList<Student>();

      // 取得数据库操作对象
      try {
         stmt = getConnection().createStatement();
      }
      catch(Exception e) {
         System.out.println("statement取得错误");
         System.out.println(e.getMessage());
         return null;
      }

      try {
         // 查询数据库对象,返回记录集(结果集)
         ResultSet rs = stmt.executeQuery(sql);

         // 循环记录集，查看每一行每一列的记录
         while(rs.next()) {
            // 第1列 sno
            int sno = rs.getInt(1);

            // 第2列 sname
            String sname = rs.getString(2);

            // 第3列 sage
            int sage = rs.getInt(3);

            Student stu = new Student();
            stu.setId(sno);
            stu.setName(sname);
            stu.setAge(sage);

            list.add(stu);
         }
      }
      catch(Exception e) {
         System.out.println(e.getMessage());
      }

      return list;
   }
}
