package cn.pdsu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * 
 */
public class ControlServlet extends HttpServlet {

	public ControlServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataSourceDAO dataSourceDAO = new DataSourceDAO();
		int countRecord = dataSourceDAO.count();
		request.setCharacterEncoding("UTF-8");
		// �õ���
		String currentPage = request.getParameter("page");
		if (currentPage == null)
			currentPage = "1";
		int cp = Integer.parseInt(currentPage);// ���
		Page<Student> p = new Page<Student>(cp, countRecord);
		// �������
		List<Student> list = dataSourceDAO.findStudent(p.getStartIndex(),
				p.getOnePageCount());
		p.setList(list);// �������
		// ����ҳ����ʾ����
		PageModel<Student> pageModel = new PageModel<Student>(p,
				"servlet/ControlServlet", PageModel.NUM_MODEL);
		request.setAttribute("pageObject", pageModel);

		
		
		 getServletContext().getRequestDispatcher("/show.jsp").forward(request,
	     	response);
		 }
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
