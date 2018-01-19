package cn.itbz.ebook.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.itbz.ebook.bean.User;
import cn.itbz.ebook.bean.UserInfo;
/**
 * user的dao层，控制user表
 * @author Administrator
 *
 */
public interface UserMapper {
	
	/**
	 * 通过用户名和密码得到用户
	 * @param user：用户表实体类
	 * @return
	 */
	@Select("select * from t_user where username=#{username} and password=#{password}")
	User login(User user);
	/**
	 * 通过用户编号得到用户
	 * @param id：用户编号
	 * @return
	 */
	@Select("select * from t_user where id=#{id}")
	User getUserById(Integer id);
	
	/**
	 * 通过用户编号得到用户详细信息
	 * @param uid：用户编号
	 * @return
	 */
	@Select("select * from t_userInfo where uid=#{uid}")
	@Results({
			@Result(id = true, property = "id", column = "id"),
			@Result(property = "user", column = "uid", javaType = User.class, 
			one = @One(select = "cn.itbz.ebook.dao.UserMapper.getUserById")) })
	UserInfo getUserInfoByUid(Integer uid);
	
	/**
	 * 用户注册时插入用户表数据
	 * @param user
	 * @return
	 */
	@Insert("insert into t_user(username,password,phone) values(#{username},#{password},#{phone})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	boolean addUser(User user);
	
	/**
	 * 用户注册时添加一条空的用户详细信息
	 * @param uid
	 * @return
	 */
	@Insert("insert into t_userInfo(uid) values(#{uid})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	boolean addUserInfo(Integer uid);
	
	/**
	 * 根据用户编号奥修改用户
	 * @param user
	 * @return
	 */
	@Update("update t_user set password=#{password},phone=#{phone} where id=#{id}")
	boolean updateUserById(User user);
}
