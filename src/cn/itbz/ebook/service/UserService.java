package cn.itbz.ebook.service;


import cn.itbz.ebook.bean.User;
import cn.itbz.ebook.bean.UserInfo;

/**
 * 用户逻辑层接口
 * @author Administrator
 *
 */
public interface UserService {
	
	/**
	 * 通过用户名和密码得到用户
	 * @param username：用户名
	 * @param password：用户密码
	 * @return user
	 * 
	 */
	User login(String username, String password);
	/**
	 * 通过用户编号得到用户详细信息
	 * @param uid：用户编号
	 * @return
	 */
	UserInfo getUserInfoByUid(Integer uid);
	/**
	 * 通过用户编号得到用户
	 * @param id：用户编号
	 * @return
	 */
	User getUserById(Integer id);
	
	/**
	 * 用户注册时插入用户表数据
	 * 用户注册时添加一条空的用户详细信息
	 * @param user
	 * @return
	 */
	boolean addUserAndUserInfo(User user);
	
	/**
	 * 根据用户编号奥修改用户
	 * @param user
	 * @return
	 */
	boolean updateUserById(User user);
	
}
