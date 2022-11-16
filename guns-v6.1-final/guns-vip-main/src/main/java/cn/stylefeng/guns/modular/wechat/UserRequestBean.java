package cn.stylefeng.guns.modular.wechat;

import java.util.Calendar; 
import java.util.Date;

public class UserRequestBean {

	public Date tokenTime;

	public String userKey;

	public String userId;
	public String userName;
	public int gender;// 性别 1=男，2=女， 0=未知

	public String email;
	public String mobile;

	public String avatar;

	public Object from;

	public Object enterprise;
  
	

	public UserRequestBean() {
		this.tokenTime = new Date();
	}

	public boolean isOverDue() {
		long now = Calendar.getInstance().getTimeInMillis();

		return ((now - tokenTime.getTime()) / 60000) > 30;
	}
}
