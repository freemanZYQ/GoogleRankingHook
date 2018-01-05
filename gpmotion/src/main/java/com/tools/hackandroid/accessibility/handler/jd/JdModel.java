package com.tools.hackandroid.accessibility.handler.jd;

import com.tools.hackandroid.util.DLog;

import java.io.Serializable;

/**
 * @author zhitao
 * @since 2016-08-05 09:36
 */
public class JdModel implements Serializable {

	/**
	 * 本订单数据来源于当天的哪一分JD订单文件
	 */
	public String matchSrcJDFile;

	/**
	 * 订单结果保存文件
	 */
	public String matchResultJDFile;

	/**
	 * 商品名字
	 */
	public String productName;

	/**
	 * 收货人名字
	 */
	public String consignee;

	/**
	 * 收货电话
	 */
	public String phoneNumber;

	/**
	 * 收货地址
	 */
	public String address;

	/**
	 * 物流单号
	 */
	public String orderId;

	/**
	 * 购买价格
	 */
	public String price;

	/**
	 * 购买链接
	 */
	public String orderUrl;

	/**
	 * 购买账号
	 */
	public String accountName;

	/**
	 * 密码
	 */
	public String accountPwd;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("JdModel {\n");
		sb.append("  订单来源文件=\"").append(matchSrcJDFile).append('\"').append("\n");
		sb.append("  订单保存文件=\"").append(matchResultJDFile).append('\"').append("\n");
		sb.append("  商品名字=\"").append(productName).append('\"').append("\n");
		sb.append("  收货人名字=\"").append(consignee).append('\"').append("\n");
		sb.append("  收货电话=\"").append(phoneNumber).append('\"').append("\n");
		sb.append("  收货地址=\"").append(address).append('\"').append("\n");
		sb.append("  物流单号=\"").append(orderId).append('\"').append("\n");
		sb.append("  购买价格=\"").append(price).append('\"').append("\n");
		sb.append("  购买链接=\"").append(orderUrl).append('\"').append("\n");
		sb.append("  购买账号=\"").append(accountName).append('\"').append("\n");
		sb.append("  账号密码=\"").append(accountPwd).append('\"').append("\n");
		sb.append('}');
		return sb.toString();
	}

	public void initFromString(String fileName, String string) {
		String[] dataArray = string.split(",");
		for (int i = 0; i < dataArray.length; i++) {
			DLog.i("%d : %s", i, dataArray[i]);
		}

		matchSrcJDFile = fileName;
		matchResultJDFile = fileName == null ? null : fileName.replace("src", "result");
		productName = dataArray[0];
		consignee = dataArray[1];
		phoneNumber = dataArray[2];
		address = dataArray[3];
		orderId = dataArray[4];
		price = dataArray[5];
		orderUrl = dataArray[6];
		accountName = dataArray[7];
		accountPwd = dataArray[8];
	}

	/**
	 * 转换为CSV每行的数据
	 *
	 * @return
	 */
	public String toCSVLineString() {
		StringBuilder sb = new StringBuilder();
		if (productName != null) {
			sb.append(productName);
		}
		sb.append(",");
		if (consignee != null) {
			sb.append(consignee);
		}
		sb.append(",");
		if (phoneNumber != null) {
			sb.append(phoneNumber);
		}
		sb.append(",");
		if (address != null) {
			sb.append(address);
		}
		sb.append(",");
		if (orderId != null) {
			sb.append(orderId);
		}
		sb.append(",");
		if (price != null) {
			sb.append(price);
		}
		sb.append(",");
		if (orderUrl != null) {
			sb.append(orderUrl);
		}
		sb.append(",");
		if (accountName != null) {
			sb.append(accountName);
		}
		sb.append(",");
		if (accountPwd != null) {
			sb.append(accountPwd);
		}
		return sb.toString();
	}

}
