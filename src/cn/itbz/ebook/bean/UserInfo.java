package cn.itbz.ebook.bean;
/**
 * 用户详细信息表的实体类
 * @author Administrator
 *
 */
public class UserInfo {
	private Integer id;
	private String realName;
	private String email;
	private Integer sex;
	private Integer age;
	private User user;
	
	public UserInfo() {
		
	}
	
	public UserInfo(Integer id, String realName, String email, Integer sex,
			Integer age, User user) {
		super();
		this.id = id;
		this.realName = realName;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.user = user;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", realName=" + realName + ", email="
				+ email + ", sex=" + sex + ", age=" + age + ", user=" + user
				+ "]";
	}
	
}
