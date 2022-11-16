package cn.stylefeng.guns.modular.wechat;

public class Constants {

	private static String LOG_ROOT = "c://tmp";

	private static String LINUX_LOG_ROOT = "/tmp";

	public static boolean DEBUG = false;

	public static boolean MAIL_DEBUG = false;

	public static String ENTERPRISE_SZDX = "szdx";
	public static String CORP_ID_SZDX = "ww0543e43296568974";
	public static String ADDRESS_BOOK_SECRET_SZDX = "eFpQffYtsn58_zaTVCH3UCpTgS0PHlRogCL4VX0F1f0";

	public static int corpAgentId = 1000014;

	public static final String PARAMS_PAGE = "pageIndex";
	public static final String PARAMS_OFFSET = "offset";
	public static final String PARAMS_PAGESIZE = "pageSize";

	public static final String sToken = "PXXF0bg48mV5PN7J4h";
	public static final String sEncodingAESKey = "VWLjVj1uvnsUwYvNCe2LhPXdAh7ajzhHbaUwNk7LqEl";

	public static String getLogDir() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.startsWith("linux")) {
			return LINUX_LOG_ROOT;
		} else if (os.startsWith("windows")) {
			return LOG_ROOT;
		} else {
			return LINUX_LOG_ROOT;
		}
	}

	public static String getCorpId() {
		return Constants.CORP_ID_SZDX;
	}

	public static String getAddressBooKSecret() {
		return Constants.ADDRESS_BOOK_SECRET_SZDX;
	}

	public static String getToken(int agentId) {
		return sToken;
	}

	public static String getEncodingAESKey(int agentId) {
		return sEncodingAESKey;
	}

	public static String getAppSecret(int agentId) {
		switch (agentId) {
		case 1000014:
			return "1zr9ydgnAgwkB0Ean1pFSOjk3luC8uAjh16Gc4qVpc0";
		case 1000006:
			return "tgIWpa51H4sUs81oa2ClnhEH9wan9kHCwunP-zGCEAA";
		case 1000008:
			return "tZPGQYnREhdecBbOih9kY4QM02q2G9dBVeY7jazjNIs";
		case 1000024:
			return "iBLHdFz_e3lDDnbwLQ4YBLJqyhZpgiIEBhm0EC92Tbw";

		}
		return null;
	}
}
