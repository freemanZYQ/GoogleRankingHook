package com.tools.hackandroid.output;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

import java.math.BigDecimal;

/**
 * @author zhitao
 * @since 2016-07-04 09:52
 */
public class ScreenInfo {

	/**
	 * (竖屏状态下)屏幕宽度像素
	 */
	private static int sWidthPixels;

	/**
	 * (竖屏状态下)屏幕高度像素
	 */
	private static int sHeightPixels;

	/**
	 * 屏幕像素密度(e.g 1.0)
	 */
	private static float sDensity;

	/**
	 * 屏幕像素密度比(e.g 160)
	 */
	private static int sDensityDpi;

	/**
	 * 屏幕尺寸(四舍五入后保留两位小数)
	 */
	private static double sScreenInches;

	/**
	 * 屏幕ppi
	 */
	private static int sPPI;

	/**
	 * x轴上，每英寸存在的像素个数
	 */
	private static float sXDPI;

	/**
	 * y轴上，每英寸存在的像素个数
	 */
	private static float sYDPI;

	/**
	 * 获取当前屏幕方向
	 *
	 * @param context
	 *
	 * @return <ul>
	 * <li>{@link Surface#ROTATION_0 }: 正常的竖屏</li>
	 * <li>{@link Surface#ROTATION_90 }: 正常的横屏</li>
	 * <li>{@link Surface#ROTATION_180 }: 翻转的竖屏)</li>
	 * <li>{@link Surface#ROTATION_270 }: 反转的横屏</li>
	 * </ul>
	 */
	public static int getOrientation(Context context) {
		return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
	}

	/**
	 * 初始化屏幕宽高，因为基本不会变，而且app中可能会多次调用，所以用静态变量保存
	 *
	 * @param context
	 */
	private static void init(Context context) {

		// 如果已经初始化过的话，那么这两个值就不会为0，不用重新在创建内部对象初始化
		if (sWidthPixels != 0 && sHeightPixels != 0) {
			return;
		}
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);

		// =========================================================================
		// 密度相关

		sDensity = displayMetrics.density;
		sDensityDpi = displayMetrics.densityDpi;

		// =========================================================================
		// 屏幕分辨率相关

		// since SDK_INT = 1;
		sWidthPixels = displayMetrics.widthPixels;
		sHeightPixels = displayMetrics.heightPixels;

		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
			try {
				sWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
				sHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
			} catch (Exception ignored) {
				// 可能准确，但是it's all we can got
				sWidthPixels = display.getWidth();
				sHeightPixels = display.getHeight();
			}
		}

		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 17) {
			try {
				Point realSize = new Point();
				display.getRealSize(realSize);
				sWidthPixels = realSize.x;
				sHeightPixels = realSize.y;
			} catch (Exception ignored) {
			}
		}

		// 经过上面方法，基本得出调用本方法的时候，当前屏幕方向下的宽高分辨率
		// 如果当前的屏幕方向已经是竖屏的话，那么就没问题了
		// 如果当前的屏幕方向是横屏的话，就需要转换一下
		switch (display.getRotation()) {
		case Surface.ROTATION_90:
		case Surface.ROTATION_270:
			int temp = sWidthPixels;
			sWidthPixels = sHeightPixels;
			sHeightPixels = temp;
			break;
		}

		// =========================================================================
		// x/y 轴上每英寸的像素个数

		sXDPI = displayMetrics.xdpi;
		sYDPI = displayMetrics.ydpi;

		// =========================================================================
		// 屏幕尺寸

		// 尺寸，利用x/y轴上，多少个px代表一英寸来算出宽高的英寸，在开方得出对角线即为屏幕尺寸
		double x = Math.pow(sWidthPixels / sXDPI, 2);
		double y = Math.pow(sHeightPixels / sYDPI, 2);
		double srcScreenInches = Math.sqrt(x + y);

		// 四舍五入后的屏幕尺寸
		BigDecimal bd = new BigDecimal(srcScreenInches);
		sScreenInches = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		// =========================================================================
		// ppi
		sPPI = (int) Math.floor(Math.sqrt(Math.pow(sWidthPixels, 2) + Math.pow(sHeightPixels, 2)) / sScreenInches);

	}

	/**
	 * 获取(竖屏状态下)屏幕宽度像素
	 *
	 * @return
	 */
	public static int getWidthPx(Context context) {
		init(context);
		return sWidthPixels;
	}

	/**
	 * 获取(竖屏状态下)屏幕高度像素
	 *
	 * @return
	 */
	public static int getHeightPx(Context context) {
		init(context);
		return sHeightPixels;
	}

	/**
	 * 屏幕密度（densityDpi:每英寸点）
	 * APP根据densityDpi的大小决定调用哪个文件夹下的图片，关系如下：
	 * drawable-ldpi 底密度，通常是指120
	 * drawable-mdpi 中等密度，通常是指160
	 * drawable-xhdpi 超高密度，通常是指320
	 *
	 * @return
	 */
	public static int getDensityDpi(Context context) {
		init(context);
		return sDensityDpi;
	}

	/**
	 * 屏幕密度级别(density =  densityDpi /160)
	 *
	 * @return
	 */
	public static float getDensity(Context context) {
		init(context);
		return sDensity;
	}

	/**
	 * 获取屏幕尺寸（单位：英寸inches）
	 *
	 * @param context
	 *
	 * @return
	 */
	public static double getSize(Context context) {
		init(context);
		return sScreenInches;
	}

	/**
	 * 获取屏幕ppi
	 *
	 * @param context
	 *
	 * @return
	 */
	public static int getPPI(Context context) {
		init(context);
		return sPPI;
	}

	/**
	 * x轴上，每英寸的像素个数
	 *
	 * @param context
	 *
	 * @return
	 */
	public static float getXDPI(Context context) {
		init(context);
		return sXDPI;
	}

	/**
	 * y轴上，每英寸的像素个数
	 *
	 * @param context
	 *
	 * @return
	 */
	public static float getYDPI(Context context) {
		init(context);
		return sYDPI;
	}

	/**
	 * 获取当前屏幕可视区域宽高
	 *
	 * @return 长度为2的int数组，int[0] = width,int[1] = height
	 */
	public static int[] getCurrentVisibleScreenInfo(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		dm = context.getApplicationContext().getResources().getDisplayMetrics();
		return new int[] { dm.widthPixels, dm.heightPixels };
	}
}
