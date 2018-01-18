package cn.itbz.ebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itbz.ebook.bean.User;
import cn.itbz.ebook.bean.UserInfo;
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
	private Integer status=0;
	private String message;
	@Autowired
	private UserService userService;
	/**
	 * 判断用户登陆是否成功
	 * @param username：用户名
	 * @param password：用户密码
	 * @return
	 */
	@RequestMapping("login.action")
	@ResponseBody
	public MsgVo login(String username,String password,HttpServletRequest request){
		User user=userService.login(username,password);
		if(user!=null){
			//登陆成功返回状态
			status=1;
			message="登陆成功";
			
			//保存userInfo到session中
			Integer uid=user.getId();
			UserInfo userInfo=userService.getUserInfoByUid(uid);
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
		}else{
			//登陆失败返回状态
			status=0;
			message="账号或密码错误";
		}
		return initMsgVo(status, message);
	}
	/**
	 * 用户注册方法：注册之后往用户表和用户详情表添加数据
	 * @param user：用户表的实体类
	 * @return
	 */
	@RequestMapping("register.action")
	@ResponseBody
	public MsgVo register(User user){
		//添加用户和用户详细信息
		boolean flag=userService.addUserAndUserInfo(user);
		if(flag){
			status=1;
			message="注册成功";
		}else{
			status=0;
			message="注册失败";
		}
		return initMsgVo(status, message);
	}
	
	/**
	 * 修改用户的密码或者电话
	 * @param newPwd
	 * @param newPhone
	 * @param request
	 * @return
	 */
	@RequestMapping("updateUser.action")
	@ResponseBody
	public MsgVo updateUser(String newPwd,String newPhone,HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=((UserInfo)session.getAttribute("userInfo")).getUser();
		if(newPwd!=null){
			user.setPassword(newPwd);
		}
		if(newPhone!=null){
			user.setPhone(newPhone);
		}
		boolean flag=userService.updateUserById(user);
		if(flag){
			status=1;
			message="修改成功";
		}else{
			msgVo.setStatus(0);
			msgVo.setMessage("修改失败");
		}
		return initMsgVo(status, message);
	}
	
	public MsgVo getMsgVo() {
		return msgVo;
	}
	public void setMsgVo(MsgVo msgVo) {
		this.msgVo = msgVo;
	}
	
	private MsgVo initMsgVo(Integer status,String message){
		msgVo=new MsgVo(status, message);
		return msgVo;
	}
}
