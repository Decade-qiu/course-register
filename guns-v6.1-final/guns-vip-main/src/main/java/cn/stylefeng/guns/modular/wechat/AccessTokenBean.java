package cn.stylefeng.guns.modular.wechat;

import java.util.Calendar;
import java.util.Date;

public class AccessTokenBean {

	public String key;
	public String accessToken;
	public Date tokenTime;
	public int agent;

	public AccessTokenBean() {

	}

	public AccessTokenBean(int agent) {
		this.key = "" + agent;
		this.agent = agent;
		this.tokenTime = new Date();
	}

	public boolean isOverDue() {
		long now = Calendar.getInstance().getTimeInMillis();

		return ((now - tokenTime.getTime()) / 60000) > 30;
	}
}
