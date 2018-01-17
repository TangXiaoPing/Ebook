package cn.itbz.ebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itbz.ebook.bean.User;
import cn.itbz.ebook.service.UserService;
import cn.itbz.ebook.util.MsgVo;
/**
 * 用户管理类：
 * 1、用户登陆
 * 2、用户注册
 * 3、用户修改
 * @author Administrator
 *
 */
@Controller("userController")
public class UserController {
	//返回json数据到前端
	private MsgVo msgVo;
	private UserService userService;
	
	/**
	 * 判断用户登陆是否成功
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login.action")
	@ResponseBody
	public MsgVo login(String username,String password){
		return msgVo;
	}
	
	@RequestMapping("register.action")
	@ResponseBody
	public MsgVo register(User user){
		return msgVo;
	}
	
	@RequestMapping("updateUser.action")
	@ResponseBody
	public MsgVo updateUser(User user){
		return msgVo;
	}
}
