package cn.itbz.ebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itbz.ebook.bean.Book;
import cn.itbz.ebook.service.BookService;
import cn.itbz.ebook.util.PageUtil;

/**
 * 图书实体的控制层
 * 
 * @author Administrator
 * 
 */
@Controller("bookController")
public class BookController {
	@Autowired
	private BookService bookService;
	private PageUtil pageUtil;
	// 分页每页显示结果数
	private Integer pageSize = 10;
	// 分页的页码导航条数
	private Integer navnum = 10;
	// 初始为第一页
	private Integer currnav = 1;
	//挑转的网页
	private String strValue;
	//初始化分页的三个参数
	private void init(Integer newPageSize, Integer newNavnum, Integer newCurrnav) {
		if (newPageSize != null) {
			pageSize = newPageSize;
		}
		if (newNavnum != null) {
			navnum = newNavnum;
		}
		if (newCurrnav != null) {
			currnav = newCurrnav;
		}
	}

	@RequestMapping("getAllBook.action")
	public ModelAndView getAllBook(Integer newPageSize, Integer newNavnum,
			Integer newCurrnav) {
		strValue="client/productList.jsp";
		// 得到图书总数
		Integer rowcount = bookService.getAccountBook();
		init(newPageSize, newNavnum, newCurrnav);
		pageUtil=new PageUtil(rowcount, pageSize, currnav, navnum);
		List<Book> bookList=bookService.getBookAll(pageUtil);
		pageUtil.setPageData(bookList);
		ModelAndView mav=new ModelAndView(strValue);
		mav.addObject("pageUtil", pageUtil);
		return mav;
	}
	
	/**
	 * 根据图书名查询图书
	 * @param bookName
	 * @return
	 */
	@RequestMapping("getBookByName.action")
	public ModelAndView getBookByName(String bookName) {
		strValue="client/productList.jsp";
		ModelAndView mav=new ModelAndView(strValue);
		Book book=bookService.getBookByName(bookName);
		List<Book> bookList=new ArrayList<>();
		bookList.add(book);
		pageUtil=new PageUtil();
		pageUtil.setPageData(bookList);
		mav.addObject("pageUtil", pageUtil);
		return mav;
	}
	
	/**
	 * 根据图书类型进行分页查询
	 * @param newPageSize
	 * @param newNavnum
	 * @param newCurrnav
	 * @return
	 */
	@RequestMapping("getBookType.action")
	public ModelAndView getBookType(Integer newPageSize, Integer newNavnum,
			Integer newCurrnav,String bookTypeName) {
		strValue="client/productList.jsp";
		// 得到图书总数
		Integer rowcount = bookService.getAccountBookByType(bookTypeName);
		init(newPageSize, newNavnum, newCurrnav);
		pageUtil=new PageUtil(rowcount, pageSize, currnav, navnum);
		List<Book> bookList=bookService.getBookType(bookTypeName,pageUtil);
		pageUtil.setPageData(bookList);
		ModelAndView mav=new ModelAndView(strValue);
		mav.addObject("pageUtil", pageUtil);
		return mav;
	}
}
