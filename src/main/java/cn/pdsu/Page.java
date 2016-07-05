package cn.pdsu;

import java.util.List;

/**
 * ��˵������ҳ������װ
 * 
 */
public class Page<T> {
	/**
	 * ��ҳ����ͨ���ܼ�¼����ÿҳ��ʾ��¼����������
	 */
	private int countPage;
	/**
	 * �ܼ�¼��
	 */
	private int countRecord;
	/**
	 * ��ǰҳ��Ĭ���ǵ�һҳ
	 */
	private int currentPage = 1;
	/**
	 * ����б�
	 */
	private List<T> list = null;
	/**
	 * ÿҳ��ʾ��¼���� ��Ĭ����ÿҳ��ʾ13����¼
	 */
	private int onePageCount = 3;
	/**
	 * ��ʼ������ͨ����ǰҳ��ÿҳ��ʾ��¼����������
	 */
	private int startIndex;

	public Page() {
	}

	/**
	 * ���������Ĺ��췽�������øù��췽����Ҫ�������ý��list
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @param countRecord
	 *            ��ҳ��
	 */
	public Page(int currentPage, int countRecord) {
		this.currentPage = currentPage;
		this.countRecord = countRecord;
		calculate();
	}

	/**
	 * �ܹ�����һҳ��ʾ��������¼�Ĺ��췽��
	 * 
	 * @param currentPage
	 *            ��ǰҳ
	 * @param countRecord
	 *            �ܼ�¼��
	 * @param onePageCount
	 *            ÿҳ�����ʾ�ļ�¼����
	 */
	public Page(int currentPage, int countRecord, int onePageCount) {
		super();
		this.countRecord = countRecord;
		this.currentPage = currentPage;
		this.onePageCount = onePageCount;
		calculate();
	}

	/**
	 * ���㿪ʼ��������ҳ��
	 */
	private void calculate() {
		// ���㿪ʼ����
		this.startIndex = (currentPage - 1) * onePageCount;
		// ������ҳ��
		this.countPage = (countRecord % onePageCount == 0) ? (countRecord / onePageCount)
				: (countRecord / onePageCount + 1);
	}

	public int getCountPage() {
		return countPage;
	}

	public int getCountRecord() {
		return countRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public void setCountRecord(int countRecord) {
		this.countRecord = countRecord;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
