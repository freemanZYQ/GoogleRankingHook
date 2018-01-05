package com.tools.hackandroid.accessibility.handler.jd;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.tools.hackandroid.accessibility.handler.AbsHandler;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.FileUtil;
import com.tools.hackandroid.util.PackageUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 京东辅助功能
 * <p/>
 * <ul>
 * <li>自动登陆</li>
 * <li>自动清空购物车</li>
 * <li>自动进入购物页面</li>
 * <li>自动下单</li>
 * <li>自动创建新的收货地址</li>
 * </ul>
 *
 * @author zhitao
 * @since 2016-08-04 10:43
 */

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class JdHandler extends AbsHandler {

	private boolean hasLoginIn = false;

	private boolean hasCleanShoppingCar = false;

	private JdModel mJdModel;

	private void reset() {
		hasLoginIn = false;
		hasCleanShoppingCar = false;
	}

	@Override
	public void onServiceConnected() {
	}

	@Override
	public void onInterrupt() {
	}

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		mJdModel = JdModelUtil.readObjectFromCache(getAccessibilityService().getApplicationContext());
		if (mJdModel == null) {
			return;
		}

		switch (event.getEventType()) {

		case AccessibilityEvent.TYPE_VIEW_SCROLLED:

			switch (event.getClassName().toString()) {
			// 第一次进入订单界面时,会有进度条,然后有listview加载
			// 加载完毕之后读取订单内容,然后写入到文件中
			case "android.widget.ListView":
				reWriteOrderInfo2CSV();

				break;
			// 购物车具体页面
			//			case "android.widget.ExpandableListView":
			//				cleanAllShopInShoppongCar();
			//				break;
			}
			break;
		case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
			switch (event.getClassName().toString()) {

			// 点击登陆/注册
			case "android.support.v7.widget.RecyclerView":
				gotoLoginPage(event);
				break;
			//			 购物车具体页面
			//			case "android.widget.ExpandableListView":
			//				cleanAllShopInShoppongCar();
			//				break;
			}
			break;
		case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
			switch (event.getClassName().toString()) {

			// 搜索商品的activity页面
			case "com.jingdong.app.mall.searchRefactor.view.Activity.SearchActivity":
				// 自动搜索商品
				autoSearchShop();
				break;
			// 搜索结果的商品列表页
			case "com.jingdong.app.mall.searchRefactor.view.Activity.ProductListActivity":
				break;
			//			// 清空购物车时弹出来的对话框
			//			case "com.jingdong.common.ui.JDDialog":
			//				// 确定删除所有购物
			//				confirmDeleteAllShop(event);
			//				break;

			// 首页(下方存在导航栏),点击进入用户页面
			case "com.jingdong.app.mall.MainFrameActivity":
				//				gotoUserInfoTab();
				break;
			// 购物车下单后,进入的确认订单页面:
			// 5.1.1
			case "com.jingdong.app.mall.settlement.NewFillOrderActivity":
				//5.2.0
			case "com.jingdong.app.mall.settlement.view.activity.NewFillOrderActivity":
				//checkConsigneeMsgBeforeOrders();
				break;

			// 订单界面获取订单号
			case "com.jingdong.app.mall.personel.myOrderDetail.view.activity.OrderDetailActivity":
				// 5.2.0 之后的订单界面
			case "com.jd.lib.ordercenter.myOrderDetail.view.activity.OrderDetailActivity":
				reWriteOrderInfo2CSV();
				break;
			// 登陆界面自动填写
			case "com.jingdong.app.mall.login.LoginActivity":
				autoInputLoginMsg();
				break;
			// 下订单后界面的新增收货地址页面自动填写
			// 5.2.0 之前用这个activity
			case "com.jingdong.app.mall.settlement.EditOrderAddressActivityNew":
				// 5.2.0 之后用这个activity
			case "com.jingdong.app.mall.settlement.view.activity.EditOrderAddressActivityNew":
				// 用户设置界面的新增收货地址页面自动填写
			case "com.jingdong.app.mall.easybuy.EditNewEasyBuyAddressActivity":
				addNewAddress();
				break;
			}
			break;
		}

	}

	/**
	 * 在点击下单之前确定一下收货人信息
	 */
	private void checkConsigneeMsgBeforeOrders() {
		String consignee = getText(JDView.getViewId_BeforeOrder_Consignee());
		String phoneNumber = getText(JDView.getViewId_BeforeOrder_PhoneNumber());
		String address = getText(JDView.getViewId_BeforeOrder_Address());

		if (TextUtils.isEmpty(consignee) || TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(address)) {
			toast("收货信息不全,部分参数为空");
			return;
		}
		if (!consignee.equals(mJdModel.consignee)) {
			toast("收货人不对!\n目标收货人为:%s", mJdModel.consignee);
			return;
		}

		if (!TextUtils.isEmpty(address)) {
			boolean isAddressRight = true;
			String addressArray[] = address.split("\\s+");
			for (String addr : addressArray) {
				if (mJdModel.address == null || !mJdModel.address.contains(addr)) {
					isAddressRight = false;
					break;
				}
			}
			if (!isAddressRight) {
				toast("地址不对!\n订单地址：%s\n原始地址:%s", address, mJdModel.address);
				return;
			}
		} else {
			toast("地址不对!\n订单地址：%s\n原始地址:%s", address, mJdModel.address);
			return;
		}

		// 新版做了改动，代码不适用了
		//		String formatAddress = mJdModel.address;
		//		if (mJdModel.address != null) {
		//			String[] temp = mJdModel.address.split("\\s+");
		//			StringBuilder sb = new StringBuilder();
		//			for (String str : temp) {
		//				sb.append(str);
		//			}
		//			formatAddress = sb.toString();
		//		}
		//		if (!address.trim().endsWith(formatAddress)) {
		//			toast("地址不对!\n地址后面部分应该为: %s", formatAddress);
		//			return;
		//		}

		String[] phoneNumberArray = phoneNumber.split("\\*+");
		if (phoneNumberArray.length == 1) {
			if (!phoneNumber.trim().equals(mJdModel.phoneNumber.trim())) {
				toast("电话不对!\n目标电话应该为: %s", phoneNumber);
				return;
			}
		} else if (phoneNumberArray.length == 2) {
			if (!mJdModel.phoneNumber.trim().startsWith(phoneNumberArray[0].trim()) ||
			    !mJdModel.phoneNumber.trim().endsWith(phoneNumberArray[1].trim())) {
				toast("电话不对!\n目标电话应该为: %s", phoneNumber);
				return;
			}
		}
		toast("收货信息正确，可以下单了");
	}

	/**
	 * 自动搜索商品
	 */
	private void autoSearchShop() {
		String orderNumber = mJdModel.orderUrl;
		Pattern pattern = Pattern.compile("(\\d)+");
		Matcher matcher = pattern.matcher(orderNumber);
		// 只找第一个数字
		if (matcher.find()) {
			orderNumber = matcher.group();
		}

		DLog.i("即将搜索的商品: %s", orderNumber);
		if (!pattern.matcher(orderNumber).matches()) {
			return;
		}

		performInputText(JDView.getViewId_SearchShopActivity_SearchBar(), orderNumber);

		toast("已经自动填写商品ID");
		// 不进行点击,不然的话是会没法搜索自己的内容
		//		performClickByResId(JDView.getViewId_SearchShopActivity_SearchBtn());
	}

	private void cleanAllShopInShoppongCar() {
		if ("com.jingdong.app.mall.MainFrameActivity"
				.equals(PackageUtil.getTopActivityNameBelowAndroidL(getAccessibilityService().getApplicationContext()))) {

			// 检查购物车是否为空
			List<AccessibilityNodeInfo> finishNodeList = getNodeByResIdFromRootInActiveWindow("com.jingdong.app.mall:id/f6l");
			if (finishNodeList == null || finishNodeList.isEmpty()) {

				// 购物车本身为空
				DLog.i("没有node,当前购物车已经为空");

			} else if ("编辑".equals(finishNodeList.get(0).getText().toString())) {

				// 购物车本身有商品,所以存在编辑按钮
				DLog.i("当前购物车不为空,进入编辑页面");
				finishNodeList.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);

			} else if ("完成".equals(finishNodeList.get(0).getText().toString())) {

				// 购物车编辑页面

				// 全选区域
				List<AccessibilityNodeInfo> quanXuanNodeList =
						getNodeByResIdFromRootInActiveWindow("com.jingdong.app.mall:id/boq");
				// 全选文字
				List<AccessibilityNodeInfo> quanXuanTextNodeList =
						getNodeByResIdFromRootInActiveWindow("com.jingdong.app.mall:id/bos");
				// 删除
				List<AccessibilityNodeInfo> deleteNodeList =
						getNodeByResIdFromRootInActiveWindow("com.jingdong.app" + ".mall:id/f7u");
				//						DLog.i("%s %s %s", finishNodeList.get(0).getText().toString(),
				//								quanXuanNodeList.get(0).getText().toString(), deleteNodeList.get(0)
				// .getText().toString());
				//						if (quanXuanTextNodeList.get(0).getText().toString().equals("全选") &&
				//						    deleteNodeList.get(0).toString().equals("删除")) {
				DLog.i("准备清空购物车");
				quanXuanNodeList.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
				deleteNodeList.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
				finishNodeList.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
				DLog.i("已经自动清空清空购物车");
				//						}
			}

		}
	}

	/**
	 * 确定删除所有购物
	 *
	 * @param event
	 */
	private void confirmDeleteAllShop(AccessibilityEvent event) {
		List<AccessibilityNodeInfo> msgNodeList = getNodeByResIdFromEventSource(event, "com.jingdong.app.mall:id/ag");
		List<AccessibilityNodeInfo> positionBtnNodeList = getNodeByResIdFromEventSource(event, "com.jingdong.app.mall:id/aj");
		List<AccessibilityNodeInfo> nagativeBtnNodeList = getNodeByResIdFromEventSource(event, "com.jingdong.app.mall:id/ak");
		if (msgNodeList == null || msgNodeList.isEmpty() ||
		    positionBtnNodeList == null || positionBtnNodeList.isEmpty() ||
		    nagativeBtnNodeList == null || nagativeBtnNodeList.isEmpty()) {
			return;
		}
		//"确认要删除这1种商品吗？"
		String msgText = msgNodeList.get(0).getText().toString();
		String posBtnText = positionBtnNodeList.get(0).getText().toString();
		String nagBtnText = nagativeBtnNodeList.get(0).getText().toString();

		boolean isMsgText = Pattern.compile("确认要删除这\\d种商品吗？").matcher(msgText).matches();
		if (isMsgText && "确定".equals(posBtnText) && "取消".equals(nagBtnText) &&
		    "com.jingdong.app.mall.MainFrameActivity"
				    .equals(PackageUtil.getTopActivityNameBelowAndroidL(getAccessibilityService().getApplicationContext()))) {
			positionBtnNodeList.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
		}
	}

	/**
	 * 添加新的收货地址
	 */
	private void addNewAddress() {

		String consignee = getText(JDView.getViewId_AddressPage_Consignee());
		String phoneNumber = getText(JDView.getViewId_AddressPage_PhoneNumber());
		String address = getText(JDView.getViewId_AddressPage_Address());

		// 如果都为空就标识为新建地址
		// 否则就是编辑原有的之类
		if (TextUtils.isEmpty(consignee) && TextUtils.isEmpty(phoneNumber) &&
		    (TextUtils.isEmpty(address) || address.contains("街道、楼牌号等"))) {

			// 输入收货人
			performInputText(JDView.getViewId_AddressPage_Consignee(), mJdModel.consignee);
			// 输入手机号码
			performInputText(JDView.getViewId_AddressPage_PhoneNumber(), mJdModel.phoneNumber);
			// 输入详细地址
			performInputText(JDView.getViewId_AddressPage_Address(), mJdModel.address);

			toast("已经自动填写地址信息");
		}

		//				// 获取所在地区，如果为空的话就打开对话自动输入
		//				String area = getText("com.jingdong.app.mall:id/of");
		//				if (TextUtils.isEmpty(area)) {
		//					// 点击地区选择
		//					performClickByResId("com.jingdong.app.mall:id/of");
		//					// 标记还没有完成地区选择
		//					hasCompleteAreaSelect = false;
		//				} else {
		//					// 标记已经完成地区选择
		//					hasCompleteAreaSelect = true;
	}

	/**
	 * 自动填写登录信息和登录
	 */
	private void autoInputLoginMsg() {
		// 输入用户名
		performInputText(JDView.getViewId_LoginPage_UserName(), mJdModel.accountName);
		// 输入密码
		performInputText(JDView.getViewId_LoginPage_Password(), mJdModel.accountPwd);
		// 点击登陆
		performClickByResId(JDView.getViewId_LoginPage_LoginBtn());
	}

	/**
	 * 进入登录页面登陆
	 *
	 * @param event
	 */
	private void gotoLoginPage(AccessibilityEvent event) {
		if (JDView.getViewId_MainActivity()
				.equals(PackageUtil.getTopActivityNameBelowAndroidL(getAccessibilityService().getApplicationContext()))) {
			// 登陆成功之后还是这个界面,因此还是会点击这个按钮,不过这个时候,这个按钮已经是跳转到用户管理的聊,所以不该点击进来
			String userName = getText(JDView.getViewId_UserInfo_UserName());
			DLog.i("当前用户名:%s", userName);
			// 进入登录
			if ("登录/注册".equals(userName)) {
				performClickByResId(event, JDView.getViewId_UserInfo_GotoLogin());
				toast("开始自动登录");
			} else {
				//				//到这里就标识登录成功,进入购物车清空所有数据
				//				gotoTab(3);
			}
		}
	}

	/**
	 * 进入首页指定index的tab
	 *
	 * @param index
	 */
	private void gotoTab(int index) {
		List<AccessibilityNodeInfo> list = getNodeByResIdFromRootInActiveWindow(JDView.getViewId_MainActivity_TAB());
		if (list == null || list.isEmpty()) {
			return;
		}
		AccessibilityNodeInfo radioGroupNode = list.get(0);
		AccessibilityNodeInfo accountNode = radioGroupNode.getChild(index);
		radioGroupNode.recycle();
		accountNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
	}

	/**
	 * 点击首页下方的tab页进入用户管理页面
	 */
	private void gotoUserInfoTab() {
		gotoTab(4);
	}

	/**
	 * 将订单结果重新吸入到CSV中
	 */
	private void reWriteOrderInfo2CSV() {
		String orderId = getText(JDView.getViewId_OrderInfo_OrderId());
		String price = getText(JDView.getViewId_OrderInfo_Price());

		String consignee = getText(JDView.getViewId_OrderInfo_Consignee());
		String phoneNumber = getText(JDView.getViewId_OrderInfo_PhoneNumber());
		String address = getText(JDView.getViewId_OrderInfo_Address());

		String headerNumber = phoneNumber;
		String footerNumber = phoneNumber;
		if (!TextUtils.isEmpty(phoneNumber)) {
			String[] phoneNumberArray = phoneNumber.split("\\*+");
			if (phoneNumberArray.length == 2) {
				headerNumber = phoneNumberArray[0];
				footerNumber = phoneNumberArray[1];
			}
		}
		DLog.i("订单信息\n收货人:%s\n电话:%s\n电话前缀:%s\n电话后缀:%s\n收货地址:%s\n对应的订单号:%s\n价钱:%s", consignee, phoneNumber, headerNumber,
				footerNumber, address, orderId, price);

		if (TextUtils.isEmpty(orderId) || TextUtils.isEmpty(price) || TextUtils.isEmpty(consignee) ||
		    TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(address)) {
			return;
		}

		//		// 利用收货人相关信息来定位
		//		boolean isAddressRight = true;
		//		if (!TextUtils.isEmpty(address)) {
		//			String addressArray[] = address.split("\\s+");
		//			for (String addr : addressArray) {
		//				if (mJdModel.address == null || !mJdModel.address.contains(addr)) {
		//					isAddressRight = false;
		//					break;
		//				}
		//			}
		//		} else {
		//			isAddressRight = false;
		//		}

		if (consignee.equals(mJdModel.consignee) &&
				//		    isAddressRight &&
            (mJdModel.phoneNumber == null ||
             (mJdModel.phoneNumber.trim().startsWith(headerNumber) && mJdModel.phoneNumber.trim().endsWith(footerNumber)))) {
			//		if (true) {
			DLog.w("为目标订单");
			mJdModel.orderId = orderId;
			mJdModel.price = price;
			JdModelUtil.writeObject2Cache(getAccessibilityService().getApplicationContext(), mJdModel);
			DLog.i("写入订单号后的数据: %s", JdModelUtil.readObjectFromCache(getAccessibilityService().getApplicationContext()));

			// 保存到结果的csv中
			File resultFile = JdModelUtil.getCurrentJdResultCSVFile(mJdModel.matchResultJDFile);
			if (!resultFile.exists()) {
				resultFile = FileUtil.getVaildFile(resultFile);

				ArrayList<String> temp = new ArrayList<>();
				temp.add(FileUtil.getStringFromFileWithSpecLineNumber(JdModelUtil.getCurrentJdSrcCSVFile(mJdModel
						.matchSrcJDFile),
						1));
				DLog.i("第一行:%s", temp.get(0));
				FileUtil.writeList2File(resultFile, temp);
			}
			if (resultFile == null) {
				toast("失败, 结果存储文件为null");
				return;
			}

			// 从结果csv读取所有的行
			ArrayList<String> lastList = FileUtil.getAllLineStringFromFile(resultFile);

			boolean isNeed2WirteCSV = true;
			// 如果结果csv中已经有该订单的内容,就不用在写回去了
			for (String line : lastList) {
				if (line.contains(mJdModel.orderId)) {
					isNeed2WirteCSV = false;
					DLog.i("结果csv中已经存在了该订单的内容,不在填写");
					break;
				}
			}

			if (isNeed2WirteCSV) {
				lastList.add(mJdModel.toCSVLineString());
				boolean isSuccess = FileUtil.writeList2File(resultFile, lastList);
				toast("%s 目标订单已经写入到 %s", isSuccess ? "成功," : "失败!", resultFile.getAbsolutePath());
			} else {
				toast("目标订单已经写入到 %s", resultFile.getAbsolutePath());
			}
		} else {
			DLog.i("不为目标订单");
			toast("不为目标订单,不处理");
		}
	}

}
