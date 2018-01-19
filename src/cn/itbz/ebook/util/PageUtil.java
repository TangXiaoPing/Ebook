package cn.itbz.ebook.util;

import java.util.List;

public class PageUtil {

	// 查询结果的条数
	private int rowcount;
	// 每页显示的结果数
	private int pageSize;
	// 当前导航页
	private int currnav;
	// 每页显示的导航条数
	private int navnum;
	// 首页
	private int first = 1;
	// 尾页
	private int last;
	// 上一页
	private int pre;
	// 下一页
	private int next;
	// 第一个导航
	private int begin;
	// 最后一个导航
	private int end;
	// 总的导航条数
	private int navcount;

	// 数据开始的结果数
	private int startrow;

	private List pageData;

	public PageUtil() {
	}

	/**
	 * 创建构造方法，设置四个参数
	 * 
	 * @param rowcount
	 *            总结果数
	 * @param pageSize
	 *            每页结果数
	 * @param currnav
	 *            当前导航页
	 * @param navnum
	 *            每页显示多少导航
	 */
	public PageUtil(int rowcount, int pageSize, int currnav, int navnum) {
		this.rowcount = rowcount;
		this.pageSize = pageSize;
		this.currnav = currnav;
		this.navnum = navnum;
		// 求总的导航页数
		this.navcount = (int) Math.ceil(this.rowcount * 1.0 / pageSize);
		// 最后一个导航
		this.last = this.navcount;
		// 导航起始页
		/*
		 * 1 1 10 2 1 10 3 1 10 ... .. 7 2 11 8 3
		 */
		this.begin = Math.max(this.first, this.currnav - (this.navnum / 2));
		this.end = Math.max(this.navnum,
				Math.min(this.last, this.currnav + this.navnum / 2 - 1));
		this.pre = Math.max(this.first, this.currnav - 1);
		this.next = Math.min(this.last, this.currnav + 1);
		this.startrow = (this.currnav - 1) * this.pageSize;

		if ((this.end - this.begin) < (this.navnum - 1)) {
			this.begin = this.end - this.navnum + 1;
		}
	}

	public int getRowcount() {
		return rowcount;
	}

	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrnav() {
		return currnav;
	}

	public void setCurrnav(int currnav) {
		this.currnav = currnav;
	}

	public int getNavnum() {
		return navnum;
	}

	public void setNavnum(int navnum) {
		this.navnum = navnum;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getNavcount() {
		return navcount;
	}

	public void setNavcount(int navcount) {
		this.navcount = navcount;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public List getPageData() {
		return pageData;
	}

	public void setPageData(List pageData) {
		this.pageData = pageData;
	}

	@Override
	public String toString() {
		return "PageUtil [rowcount=" + rowcount + ", pageSize=" + pageSize
				+ ", currnav=" + currnav + ", navnum=" + navnum + ", first="
				+ first + ", last=" + last + ", pre=" + pre + ", next=" + next
				+ ", begin=" + begin + ", end=" + end + ", navcount="
				+ navcount + ", startrow=" + startrow + "]";
	}

	public static void main(String[] args) {
		PageUtil pageUtil = new PageUtil(760, 10, 18, 10);
		System.out.println(pageUtil);
	}

}
