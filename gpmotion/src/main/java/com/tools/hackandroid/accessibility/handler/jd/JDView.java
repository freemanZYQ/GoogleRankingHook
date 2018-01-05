package com.tools.hackandroid.accessibility.handler.jd;

import com.tools.hackandroid.util.DLog;

/**
 * @author zhitao
 * @since 2016-08-09 11:37
 */
public class JDView {

	public static String sVersionName = "5.2.0";

	public static void initResByAPPVersionName(String versionName) {
		sVersionName = versionName;
		DLog.i("即将使用 %s 版本的京东资源信息", sVersionName);
	}
	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 首页Activity
	 *
	 * @return
	 */
	public static String getViewId_MainActivity() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall.MainFrameActivity";
		} else {
			return "com.jingdong.app.mall.MainFrameActivity";
		}
	}

	/**
	 * 首页tab页的RadioGroup
	 *
	 * @return
	 */
	public static String getViewId_MainActivity_TAB() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/su";
		} else {
			return "com.jingdong.app.mall:id/t6";
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 用户管理页面: 用户名
	 *
	 * @return
	 */
	public static String getViewId_UserInfo_UserName() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/e9n";
		} else {
			return "com.jingdong.app.mall:id/efd";
		}
	}

	/**
	 * 用户管理页面: 点击登录注册区域
	 *
	 * @return
	 */
	public static String getViewId_UserInfo_GotoLogin() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/e9l";
		} else {
			return "com.jingdong.app.mall:id/efb";
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 登录页面: 输入用户名
	 *
	 * @return
	 */
	public static String getViewId_LoginPage_UserName() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/d8s";
		} else {
			return "com.jingdong.app.mall:id/dc2";
		}
	}

	/**
	 * 登录页面: 输入密码
	 *
	 * @return
	 */
	public static String getViewId_LoginPage_Password() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/d8z";
		} else {
			return "com.jingdong.app.mall:id/dc9";
		}
	}

	/**
	 * 登录页面: 登录按钮
	 *
	 * @return
	 */
	public static String getViewId_LoginPage_LoginBtn() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/d97";
		} else {
			return "com.jingdong.app.mall:id/dcg";
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 新增收货地址: 收货人
	 *
	 * @return
	 */
	public static String getViewId_AddressPage_Consignee() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/djn";
		} else {
			return "com.jingdong.app.mall:id/dml";
		}
	}

	/**
	 * 新增收货地址: 手机号码
	 *
	 * @return
	 */
	public static String getViewId_AddressPage_PhoneNumber() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/djp";
		} else {
			return "com.jingdong.app.mall:id/dmn";
		}
	}

	/**
	 * 新增收货地址: 详细地址
	 *
	 * @return
	 */
	public static String getViewId_AddressPage_Address() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/o7";
		} else {
			return "com.jingdong.app.mall:id/oi";
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 订单信息页面: 订单号
	 *
	 * @return
	 */
	public static String getViewId_OrderInfo_OrderId() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jd.lib.ordercenter:id/order_detail_id_number_comment";
		} else {
			return "com.jingdong.app.mall:id/eb0";
		}
	}

	/**
	 * 订单信息页面: 价格
	 *
	 * @return
	 */
	public static String getViewId_OrderInfo_Price() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jd.lib.ordercenter:id/order_money_content";
		} else {
			return "com.jingdong.app.mall:id/eb0";
		}
	}

	/**
	 * 订单信息页面: 收货人
	 *
	 * @return
	 */
	public static String getViewId_OrderInfo_Consignee() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jd.lib.ordercenter:id/order_addr_receiver_name_content";
		} else {
			return "com.jingdong.app.mall:id/eaw";
		}
	}

	/**
	 * 订单信息页面: 手机号码
	 *
	 * @return
	 */
	public static String getViewId_OrderInfo_PhoneNumber() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jd.lib.ordercenter:id/order_addr_receiver_mobile_content";
		} else {
			return "com.jingdong.app.mall:id/eax";
		}
	}

	/**
	 * 订单信息页面: 地址
	 *
	 * @return
	 */
	public static String getViewId_OrderInfo_Address() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jd.lib.ordercenter:id/order_address_content";
		} else {
			return "com.jingdong.app.mall:id/eaz";
		}
	}

	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 商品搜索页面: 搜索栏
	 *
	 * @return
	 */
	public static String getViewId_SearchShopActivity_SearchBar() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/y9";
		} else {
			return "com.jingdong.app.mall:id/xq";
		}
	}

	/**
	 * 商品搜索页面: 搜索按钮
	 *
	 * @return
	 */
	public static String getViewId_SearchShopActivity_SearchBtn() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/f3u";
		} else {
			return "com.jingdong.app.mall:id/fb9";
		}
	}

	//----------------------------------------------------------------------------------------------------------------------------

	/**
	 * 点击下单前的最后设置页面: 收货人
	 *
	 * @return
	 */
	public static String getViewId_BeforeOrder_Consignee() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/dx7";
		} else {
			return "";
		}
	}

	/**
	 * 点击下单前的最后设置页面: 电话号码
	 *
	 * @return
	 */
	public static String getViewId_BeforeOrder_PhoneNumber() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/dx8";
		} else {
			return "";
		}
	}

	/**
	 * 点击下单前的最后设置页面: 地址
	 *
	 * @return
	 */
	public static String getViewId_BeforeOrder_Address() {
		if ("5.2.0".equals(sVersionName)) {
			return "com.jingdong.app.mall:id/dxa";
		} else {
			return "";
		}
	}
}
