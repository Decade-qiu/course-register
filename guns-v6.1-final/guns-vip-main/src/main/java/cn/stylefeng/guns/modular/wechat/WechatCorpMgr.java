package cn.stylefeng.guns.modular.wechat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WechatCorpMgr {

	private final static Logger logger = LoggerFactory.getLogger(WechatCorpMgr.class);

	private Map<String, AccessTokenBean> tokenMap = new HashMap<String, AccessTokenBean>();

	private static WechatCorpMgr instance;

	public static final String CORP_ID = Constants.getCorpId();

	private WechatCorpMgr() {
	}

	public static WechatCorpMgr getInstance() {
		if (instance == null) {
			instance = new WechatCorpMgr();
		}
		return instance;
	}

	public String getUserIdByCode(String code, int agent) {
		String accessToken = getAccessToken(agent);

		String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=" + accessToken + "&code=" + code;

		HttpGet request = new HttpGet(url);
		String userId = null;

		try {
			HttpResponse response = HttpClients.createDefault().execute(request);

			if (response.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(response.getEntity());
				logger.info(result);

				JSONObject jsonObj = new JSONObject(result);

				if (jsonObj.has("UserId")) {
					userId = jsonObj.getString("UserId");
					logger.info("##userId=" + userId);
				}
			}

		} catch (Exception e) {
			logger.error(e.toString());
		}
		return userId;
	}

	public String getAccessToken(int agent) {

		String key = "" + agent;

		AccessTokenBean atb = tokenMap.get(key);

		if (atb == null || atb.isOverDue()) {
			logger.info("Create NEW Access Token!");
			atb = new AccessTokenBean(agent);
			tokenMap.put(key, atb);
		} else {
			logger.info("Use Exist Access Token!");
			return atb.accessToken;
		}

		String corpSecrect = Constants.getAppSecret(agent);
		

		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORP_ID + "&corpsecret=" + corpSecrect;

		HttpGet request = new HttpGet(url);
		String accessToken = null;
		try {

			HttpResponse response = HttpClients.createDefault().execute(request);

			if (response.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(response.getEntity());
				logger.info(result);

				JSONObject jsonObj = new JSONObject(result);
				accessToken = jsonObj.getString("access_token");
				logger.info("accessToken=" + accessToken);
				atb.accessToken = accessToken;
				atb.tokenTime = Calendar.getInstance().getTime();
			}

		} catch (Exception e) {
			logger.error(e.toString());
		}
		return accessToken;
	}

	public void clearAccessToken(int agent) {
		String key = "" + agent;
		tokenMap.remove(key);
	}

}
