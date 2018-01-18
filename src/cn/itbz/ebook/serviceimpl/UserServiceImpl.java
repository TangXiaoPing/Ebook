package cn.itbz.ebook.serviceimpl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.itbz.ebook.bean.User;
import cn.itbz.ebook.bean.UserInfo;
import cn.itbz.ebook.service.UserService;
/**
 * 用户逻辑层的实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	/**
	 * 通过用户名和密码得到用户
	 * @param username：用户名
	 * @param password：用户密码
	 * @return user
	 * 
	 */
	@Override
	public User login(String username, String password) {
		try {
			User user = sqlSession.selectOne("cn.itbz.ebook.dao.UserMapper.login", new User(username, password));
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 通过用户编号得到用户详细信息
	 * @param uid：用户编号
	 * @return
	 */
	@Override
	public UserInfo getUserInfoByUid(Integer uid) {
		try {
			UserInfo userInfo = sqlSession.selectOne("cn.itbz.ebook.dao.UserMapper.getUserInfoByUid", uid);
			return userInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 通过用户编号得到用户
	 * @param id：用户编号
	 * @return
	 */
	@Override
	public User getUserById(Integer id) {
		try {
			User user = sqlSession.selectOne("cn.itbz.ebook.dao.UserMapper.getUserById", id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 用户注册时插入用户表数据
	 * 用户注册时添加一条空的用户详细信息
	 * @param user
	 * @return
	 */
	@Override
	@Transactional(rollbackFor=Exception.class,readOnly=false)
	public boolean addUserAndUserInfo(User user) {
		try {
			sqlSession.insert("cn.itbz.ebook.dao.UserMapper.addUser", user);
			Integer uid=user.getId();
			sqlSession.insert("cn.itbz.ebook.dao.UserMapper.addUserInfo", uid);
			return true;
		} catch (Exception e) {
			//出现异常，手动回滚所有数据(user和userInfo都回滚)
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}
	
	/**
	 * 根据用户编号奥修改用户
	 * @param user
	 * @return
	 */
	@Override
	@Transactional(rollbackFor=Exception.class,readOnly=false)
	public boolean updateUserById(User user) {
		try {
			sqlSession.update("cn.itbz.ebook.dao.UserMapper.updateUserById", user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}
	
}
