package cn.itbz.ebook.service;

import java.util.List;

import cn.itbz.ebook.bean.Book;
import cn.itbz.ebook.util.PageUtil;

/**
 * 图书实体的逻辑接口层
 * @author Administrator
 *
 */
public interface BookService {

	Integer getAccountBook();

	List<Book> getBookAll(PageUtil pageUtil);

	Book getBookByName(String bookName);

	List<Book> getBookType(String bookTypeName, PageUtil pageUtil);

	Integer getAccountBookByType(String bookTypeName);

}
