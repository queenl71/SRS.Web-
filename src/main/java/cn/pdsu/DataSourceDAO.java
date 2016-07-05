package cn.pdsu;

import java.util.LinkedList;
import java.util.List;
import cn.pdsu.Student;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cn.pdsu.Student;
/**
 * ��˵�������ݵķ�װ
 * 
 */
public class DataSourceDAO {
	private  List<Student> list = new LinkedList<Student>();//
	private  Connection con;
	
	
	 
		//for (int i = 0; i < 20; i++) {
			//list.add(new Student(i, "����" + i, "��", "ѧ��" + i));
	//}
	
    
	/**
	 * ģ�����ݿ��з�ҳ��ѯ
	 * 
	 * @param startIndex
	 *            Ҫ��ѯ�Ŀ�ʼ����
	 * @param count
	 *            ��ѯ���ܼ�¼��
	 * @return ��ѯ����ѧ����¼
	 */
	public List<Student> findStudent(int startIndex, int count) {
		Student student=new Student();
		list = student.getAllStudents();
		int num = count + startIndex;
		if (num > list.size())
			num = list.size();
		return list.subList(startIndex, num);
	}

	/**
	 * ģ�����ݿ��в�ѯ�ܼ�¼��
	 * 
	 * @return �ܵļ�¼��
	 */
	public int count() {
		Student student=new Student();
		list=student.getAllStudents();
		return list.size();
	}
	
	
	
}
