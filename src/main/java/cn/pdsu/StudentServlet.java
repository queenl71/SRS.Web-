package cn.pdsu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

 public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

  doPost(request,response);
 }


 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {request.setCharacterEncoding("gb2312");       
	  String sid = request.getParameter("sid");
	int i=0;
	  try { i=Integer.parseInt(sid);
	  }
	  catch(NumberFormatException e)
	  {//i=0;
	  }
	  String sname = request.getParameter("sname");
	  
	  String sage = request.getParameter("sage");
	  String action =  request.getParameter("action");
	  
	  // ����ҵ�񷽷�
	  Student student=new Student();
	  if(action.equals("list")){ // ��ʾ�б�
	 List list = student.getAllStudents();
	   request.setAttribute("pageObject",list);
	 }
	  if(action.equals("add")){ //���
	   Student info = new Student();
	   info.setId(i);
	   info.setSname(sname);
	   info.setSage(sage);
	   student.add(info);
	   
	  }else if(action.equals("edit")){ // �޸�
	   Student info = new Student();
	   info.setSid(i);
	   info.setSname(sname);
	   info.setSage(sage);
	   student.edit(info);
	 }else if(action.equals("findedit")){ // �޸�֮ǰ�Ĳ�ѯ
	 Student info = student.findStudentById(sid);
	   request.setAttribute("student",info);
	  }else if(action.equals("delete")){ // ɾ��ѧ��
	   student.delete(sid);
	  }else if(action.equals("findadd")){
	   
	  }
	  
	  String forward;
	  if(action.equals("findedit")){
	   request.setAttribute("type","edit"); // �ڽ����������ж�����ӽ��滹���޸Ľ���
	   forward = "edituser.jsp";
	  }else if(action.equals("findadd")){
	   request.setAttribute("type","add"); // �ڽ����������ж�����ӽ��滹���޸Ľ���
	   forward = "edituser.jsp";
	  }else if(action.equals("list")){
	   forward = "index.jsp";
	  }	   
	  else{
		  forward="index.jsp";
	  } 
	  
	  RequestDispatcher rd = request.getRequestDispatcher(forward);
	  rd.forward(request,response);     }

}