package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Student;


public class DBConnection {

   /**
    * ����������
    */
   private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

   /**
    * ���ݿ������ַ���   jdbc:mysql://localhost:3306/test
    */
   private static final String URL = "jdbc:mysql://localhost:3306/test";

   /**
    * ���ݿ��û���
    */
   private static final String USERNAME = "root";

   /**
    * ���ݿ�����
    */
   private static final String PASSWORD = "root";

   /**
    * ���ݿ�������
    */
   private static Connection conn;

   /**
    * ���ݿ������
    */
   private static Statement stmt;



   // ��������
   static {
      try {
         Class.forName(DRIVER_CLASS);
      }
      catch(Exception e) {
         System.out.println("������������");
         System.out.println(e.getMessage());
      }
   }

   // ȡ������
   private static Connection getConnection(){

      try {
         conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      }
      catch(Exception e) {
         System.out.println("ȡ�����Ӵ���");
         System.out.println(e.getMessage());
      }
      
      return conn;
   }

   /**
    * ִ�� ����ɾ���� ����
    * @param sql
    */
   /*
   public void ExecuteDel(String sql){

      try {
         stmt = getConnection().createStatement();
      }
      catch(Exception e) {
         System.out.println("statementȡ�ô���");
         System.out.println(e.getMessage());
      }

      try {
         int rows = stmt.executeUpdate(sql);
         if(rows >= 1){
            System.out.println("�ɹ�ɾ��.....");
         }
         else {
            System.out.println("ɾ��ʧ��.....");
         }
      }
      catch(Exception e) {

      }
   }
   */

   /**
    * ��ȡ���ݿ��е����ݣ���ѯ������
    * @param sql
    * @return
    */
   public ArrayList<Student> getStudentList(String sql){

      ArrayList<Student> list = new ArrayList<Student>();

      // ȡ�����ݿ��������
      try {
         stmt = getConnection().createStatement();
      }
      catch(Exception e) {
         System.out.println("statementȡ�ô���");
         System.out.println(e.getMessage());
         return null;
      }

      try {
         // ��ѯ���ݿ����,���ؼ�¼��(�����)
         ResultSet rs = stmt.executeQuery(sql);

         // ѭ����¼�����鿴ÿһ��ÿһ�еļ�¼
         while(rs.next()) {
            // ��1�� sno
            int sno = rs.getInt(1);

            // ��2�� sname
            String sname = rs.getString(2);

            // ��3�� sage
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
