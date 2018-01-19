package cn.itbz.ebook.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.itbz.ebook.bean.Book;
import cn.itbz.ebook.util.PageUtil;

public interface BookMapper {
	/**
	 * 无条件分页查询
	 * @param pageUtil:分页对象
	 * @return
	 */
	@Select("select * from t_book limit #{startrow},#{pageSize}")
	List<Book> getBookAll(PageUtil pageUtil);
	
	/**
	 * 根据图书类型进行分页查询
	 * @param bookTypeName：图书类型名字
	 * @return
	 */
	@Select("select * from t_book where bookTypeName=#{bookTypeName} limit #{pageUtil.startrow} ,#{pageUtil.pageSize}")
	List<Book> getBookType(HashMap parms);
	
	/**
	 * 查询图书类型查询图书总数
	 * @return
	 */
	@Select("select count(1) from t_book where bookTypeName=#{bookTypeName}")
	Integer getAccountBookByType(String bookTypeName);
	/**
	 * 查询图书总数
	 * @return
	 */
	@Select("select count(1) from t_book")
	Integer getAccountBook();
	/**
	 * 根据图书名查询图书
	 * @param bookName
	 * @return
	 */
	@Select("select * from t_book where bookName=#{bookName}")
	Book getBookByName(String bookName);
}
