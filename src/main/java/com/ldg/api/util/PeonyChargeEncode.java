package com.ldg.api.util;

public class PeonyChargeEncode {
	private static String encode(String phone, String dateStr, String AppKey, String APPId) {
		StringBuilder sbd = new StringBuilder(AppKey);
		sbd.append(APPId).append(phone).append(dateStr);
		String md5Str = MD5Util.string2MD5(sbd.toString());
		return md5Str;
	}

	public static String getUrl(int type, String phone) {
		String AppKey = PropertiesUtil.getPeonyPropertiesVal("AppKey");
		String APPId = PropertiesUtil.getPeonyPropertiesVal("APPId");
		String nowDateStr = DateUtil.getNowStr_yyyyMMddHHmmss();
		StringBuilder rtUrl = new StringBuilder();
		switch (type) {
		case 1:
			// 电费
			rtUrl.append(PropertiesUtil.getPeonyPropertiesVal("dianurl"));
			break;
		case 2:
			// 水费
			rtUrl.append(PropertiesUtil.getPeonyPropertiesVal("shuiurl"));
			break;
		case 3:
			// 燃气
			rtUrl.append(PropertiesUtil.getPeonyPropertiesVal("ranqiurl"));
			break;
		case 4:
			// 暖气
			rtUrl.append(PropertiesUtil.getPeonyPropertiesVal("nuanqiurl"));
			break;
		default:
			break;
		}
		rtUrl.append("?md5=").append(encode(phone, nowDateStr, AppKey, APPId)).append("&id=").append(APPId)
				.append("&phone=").append(phone).append("&time=").append(nowDateStr);
		return rtUrl.toString();
	}

	public static void main(String[] args) {
		// System.out.println(PeonyChargeEncode.encode("13808923285"));
	}
}
