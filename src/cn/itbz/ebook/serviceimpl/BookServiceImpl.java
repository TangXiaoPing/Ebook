package cn.itbz.ebook.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itbz.ebook.bean.Book;
import cn.itbz.ebook.service.BookService;
import cn.itbz.ebook.util.PageUtil;
@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 查询图书总数
	 */
	@Override
	public Integer getAccountBook() {
		Integer account=0;
		try {
			account=sqlSession.selectOne("cn.itbz.ebook.dao.BookMapper.getAccountBook");
			return account;
		} catch (Exception e) {
			e.printStackTrace();
			return account;
		}
	
	}
	/**
	 * 无条件进行分页查询
	 */
	@Override
	public List<Book> getBookAll(PageUtil pageUtil) {
		List<Book> bookList=null;
		try {
			bookList=sqlSession.selectList("cn.itbz.ebook.dao.BookMapper.getBookAll",pageUtil);
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			return bookList;
		}
	}
	/**
	 * 根据图书名字查询图书
	 */
	@Override
	public Book getBookByName(String bookName) {
		Book book=null;
		try {
			book=sqlSession.selectOne("cn.itbz.ebook.dao.BookMapper.getBookByName",bookName);
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			return book;
		}
	}
	/**
	 * 根据图书类型进行分页查询
	 */
	@Override
	public List<Book> getBookType(String bookTypeName, PageUtil pageUtil) {
		List<Book> bookList=null;
		HashMap parms=new HashMap();
		parms.put("bookTypeName", bookTypeName);
		parms.put("pageUtil", pageUtil);
		try {
			bookList=sqlSession.selectList("cn.itbz.ebook.dao.BookMapper.getBookType",parms);
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			return bookList;
		}
	}
	
	/**
	 * 查询某一类型的图书总数
	 */
	@Override
	public Integer getAccountBookByType(String bookTypeName) {
		Integer account=0;
		try {
			account=sqlSession.selectOne("cn.itbz.ebook.dao.BookMapper.getAccountBookByType",bookTypeName);
			return account;
		} catch (Exception e) {
			e.printStackTrace();
			return account;
		}
	}
	
}
