package cn.pdsu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.pdsu.Student;




/**
 * 
 */
public class Student {
	private int id;
	private String name;
	private String age;
	private String resume;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public Student(int id, String name, String age, String resume) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.resume = resume;
	}
	
	
	public List getAllStudents(){
		  List list = new ArrayList();
		  String sql = "select * from student";
		  
		  try{
		   rs = executeQuery(sql);
		   
		   while(rs.next()) {
			   
		    Student temp = new Student();
		    temp.setSid(rs.getInt(1));
		    temp.setSname(rs.getString(2));
		    temp.setSage(rs.getString(3));
		    list.add(temp);}
			 
		  }catch(Exception e){
		   System.out.println(e.toString());
		  }finally{
		   close();
		  }
		  return list;
		 }
	
	/*
	  * 添加
	  */

	 public void add(Student stu){
	  String sql = "insert into student values('"+stu.getSid()+"','"+stu.getSname()+"',"+stu.getSage()+")";
	  try{
	   executeUpdate(sql);
	  }catch(Exception e){
	   System.out.println(e.toString());
	  }finally{
	   close();
	  }
	 }
	 
	 /*
	  * 删除
	  */
	 public void delete(String sid){
	  String sql = "delete from student where sid='"+sid+"'";
	  try{
	   executeUpdate(sql);
	  }catch(Exception e){
	   System.out.println(e.toString());
	  }finally{
	   close();
	  }
	 }
	 
	 /*
	  */
	 public Student findStudentById(String sid){
	  String sql = "select * from student where sid='"+sid+"'";
	  try{
	   rs = executeQuery(sql);
	   if(rs.next()){
		   String id = rs.getString(1);
			int i=0;
			  try { i=Integer.parseInt(id);
			  }
			  catch(NumberFormatException e)
			  {//i=0;
			  }
	    Student temp = new Student();
	    temp.setSid(i);
	    temp.setSname(rs.getString(2));
	    temp.setSage(rs.getString(3));
	    return temp;
	   }
	  }catch(Exception e){
	   System.out.println(e.toString());
	  }finally{
	   close();
	  }
	  return null;
	 }
	 
	 
	 /*
	  * �޸�ѧ��
	  */
	 public void edit(Student stu){
	  String sql = "update student set sname='"+stu.getSname()+"',sage="+stu.getSage()+" where sid='"+stu.getSid()+"'";
	  try{
	   int n = executeUpdate(sql);
	   System.out.println("--------------"+n);
	  }catch(Exception e){
	   System.out.println(e.toString());
	  }finally{
	   close();
	  }
	 }
	 
	 /*
	  * ִ�и��µȲ���
	  */
	 public int executeUpdate(String sql)throws SQLException,ClassNotFoundException{
	  return getStatement().executeUpdate(sql);
	 }
	
	

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return age;
	}

	public void setSex(String sex) {
		this.age = age;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	
	
	
	 public int getSid() {
		  return id;
		 }

		 public void setSid(int id) {
		  this.id = id;
		 }

		 public String getSname() {
		  return name;
		 }

		 public void setSname(String name) {
		  this.name = name;
		 }

		 public String getSage() {
		  return age;
		 }

		 public void setSage(String age) {
		  this.age = age;
		 }
		 
	/*
	  * ִ���н�������صĲ�ѯ
	  */
	 public ResultSet executeQuery(String sql) throws SQLException,ClassNotFoundException{
	  return getStatement().executeQuery(sql);
	 }

	 /*
	  * ��ȡ������
	  */
	 public Statement getStatement() throws SQLException,ClassNotFoundException{
	  if(stmt==null){
	   stmt = getConnection().createStatement();
	  }
	  return stmt;
	 }
	 
	 /*数据库
	  */
	 public Connection getConnection() throws SQLException,ClassNotFoundException{
	  if(con==null){
	   Class.forName("com.mysql.jdbc.Driver");
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
	  }
	  return con;
	 }
	 
	
	 
	 
	 public void close(){
		  if(rs!=null)
		   try{rs.close();}catch(Exception e){}
		  if(stmt!=null)
		   try{stmt.close();}catch(Exception e){}
		  if(con!=null)
		   try{con.close();}catch(Exception e){}
		 }
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", resume=" + resume + "]";
	}

}
