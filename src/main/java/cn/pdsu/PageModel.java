package cn.pdsu;

import java.util.List;


/**
 * 
 */
public class PageModel<T> {
	/**
	 * �ı����ͣ����磺����һҳ ��һҳ ��һҳ ���һҳ��
	 */
	public static final int TEXT_MODEL = 1;

	/**
	 * �������ͣ����磺NumModel ����һҳ 2 3 4 ���һҳ��
	 */
	public static final int NUM_MODEL = 2;
	/**
	 * ҳ����ʾģ��
	 */
	private int model = 1;
	/**
	 * ҳ������URL������Ҫ���ҳ�����
	 */
	private String url;
	/**
	 * ҳ����Ϣ�ķ�װ
	 */
	private Page page = null;
	/**
	 * ģ�����͵�ҳ��
	 */
	private StringBuffer strHtml = null;

	/**
	 * �������͵�ҳ��ģ���м�������ʾ���������磺��һҳ 1 2 3 4 5 ���һҳ��numCount = 5; Ĭ����ʾ 5������
	 */
	private int numCount = 5;

	/**
	 * ҳ���ģʽĬ�ϵ��������͵���ʽ
	 * 
	 * @param page
	 *            ҳ����Ϣ
	 * @param url
	 *            ҳ���url��ַ
	 */
	public PageModel(Page page, String url) {
		super();
		this.url = url;
		this.page = page;
	}

	/**
	 * ҳ���ģ��
	 * 
	 * @param page
	 *            ҳ����Ϣ
	 * @param url
	 *            ҳ���url��ַ
	 * @param model
	 *            ҳ�����ʾ��ʽ
	 */
	public PageModel(Page page, String url, int model) {
		super();
		this.model = model;
		this.url = url;
		this.page = page;
	}

	/**
	 * ҳ���ģ��
	 * 
	 * @param page
	 *            ҳ����Ϣ
	 * @param url
	 *            ҳ���url��ַ
	 * @param model
	 *            ҳ�����ʾ��ʽ
	 * @param numCount
	 *            �������͵�ҳ�룬����ʾ�ĸ���
	 */
	public PageModel(Page page, String url, int model, int numCount) {
		super();
		this.model = model;
		this.url = url;
		this.page = page;
		this.numCount = numCount;
	}

	/**
	 * ����ҳ���ģ��
	 * 
	 * @return
	 */
	public String getPageModel() {
		// ��װҳ��ģ��
		createURL();
		return createModel();
	}

	/**
	 * ����URL
	 */
	private void createURL() {
		url = url.contains("?") ? url + "&page=" : url + "?page=";
	}

	/**
	 * ��װҳ��ģ��
	 */
	private String createModel() {
		strHtml = new StringBuffer();
		switch (model) {
		case TEXT_MODEL:// �ı�ģ��
			buildTextModel();
			break;
		case NUM_MODEL:// ����ģ��
			buildNumModel();
			break;
		default:// �ı�ģ��
			buildTextModel();
			break;
		}
		return strHtml.toString();
	}

	/**
	 * ����������͵�ҳ��ģ��
	 */
	private void buildNumModel() {
		int currentPage = page.getCurrentPage();
		int countPage = page.getCountPage();
		strHtml.append(
				"<table width='100%'  border='0' cellspacing='0' cellpadding='0'>")
				.append("<tr><td height='24' align='center'>");
		// �����ʽ����һҳ 1 2 3 4 5 ���һҳ
		PageIndex pageIndex = PageIndex.getPageIndex(numCount, currentPage,
				countPage);
		// ���ǵ�һҳʱ����ʾ��ҳ
		if (currentPage > 1) {
			strHtml.append("<a href='").append(url)
					.append("1'>��ҳ</a>&nbsp;&nbsp;");
		}
		if (currentPage <= countPage) {
			for (int i = pageIndex.getStartIndex(); i <= pageIndex
					.getEndIndex(); i++) {
				// ��ǰҳ�Ӵ�
				if (currentPage == i) {
					strHtml.append("<b>").append(i).append("</b>&nbsp;&nbsp;");
				} else {
					strHtml.append("<a href='").append(url).append(i)
							.append("'>").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			// �������һҳ��ʾĩҳ
			if (currentPage < countPage) {
				strHtml.append("<a href='").append(url).append(countPage)
						.append("'>ĩҳ</a>");
			}
		}
		strHtml.append("</td></tr></table>");
	}

	/**
	 * ����ı����͵�ҳ��
	 */
	private void buildTextModel() {
		int currentPage = page.getCurrentPage();
		int countPage = page.getCountPage();
		strHtml.append(
				"<table width='100%'  border='0' cellspacing='0' cellpadding='0'>")
				.append("<tr> <td height='24' align='center'>��ǰҳ����[")
				.append(currentPage).append("/").append(countPage)
				.append("]&nbsp;&nbsp;");
		if (currentPage > 1) {
			strHtml.append("<a href='").append(url).append("1'>��ҳ</a>")
					.append("&nbsp;&nbsp;<a href='").append(url)
					.append(currentPage - 1).append("'>��һҳ</a>");
		}
		if (currentPage < countPage) {
			strHtml.append("&nbsp;&nbsp;<a href='").append(url)
					.append(currentPage + 1)
					.append("'>��һҳ</a>&nbsp;&nbsp;<a href='").append(url)
					.append(countPage).append("'>ĩҳ</a>");
		}
		strHtml.append("</td></tr></table>");
	}

	public List<T> getList() {
		return page.getList();
	}
}
