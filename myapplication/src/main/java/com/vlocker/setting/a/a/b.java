package com.vlocker.setting.a.a;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.vlocker.m.bb;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.OneKeySettingActivity;
import com.vlocker.setting.RecentShowActivity;
import com.vlocker.setting.SettingService;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public class b {
    private String a = "";
    private String b = null;
    private String c = null;
    private boolean d = true;
    private int e = 5000;
    private long f = -1;
    private long g = -1;
    private int h = 0;
    private Integer i = null;
    private int j = 1;
    private int k = -1;
    private List l = null;
    private int m = 1;
    private List n = null;
    private List o = null;
    private List p = null;
    private int q = -1;
    private boolean r = false;
    private int s = -1;
    private boolean t = false;
    private boolean u = false;

    private final AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, List list, int i) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        Log.i(getClass().getSimpleName(), "found:" + this.h);
        if (accessibilityNodeInfo != null) {
            int i2;
            AccessibilityNodeInfo b;
            if (i > 0) {
                i2 = 0;
                while (accessibilityNodeInfo2 == null && i2 < accessibilityNodeInfo.getChildCount()) {
                    b = b(accessibilityNodeInfo.getChild(i2), list, i);
                    i2++;
                    accessibilityNodeInfo2 = b;
                }
            } else {
                i2 = accessibilityNodeInfo.getChildCount() - 1;
                while (accessibilityNodeInfo2 == null && i2 >= 0) {
                    b = b(accessibilityNodeInfo.getChild(i2), list, i);
                    i2--;
                    accessibilityNodeInfo2 = b;
                }
            }
        }
        return accessibilityNodeInfo2;
    }

    private final boolean a(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        switch (this.q) {
            case 1:
                return accessibilityNodeInfo.isChecked();
            case 2:
                return !accessibilityNodeInfo.isChecked();
            case 3:
                return !accessibilityNodeInfo.isEnabled();
            case 4:
                return true;
            case 5:
                return false;
            case 7:
                int i = 0;
                while (i < accessibilityNodeInfo.getParent().getChildCount()) {
                    if (accessibilityNodeInfo.getParent().getChild(i) != null && accessibilityNodeInfo.getParent().getChild(i).getText() != null && this.a.equals(accessibilityNodeInfo.getParent().getChild(i).getText().toString())) {
                        return true;
                    }
                    i++;
                }
                return false;
            default:
                return z;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.accessibility.AccessibilityNodeInfo b(android.view.accessibility.AccessibilityNodeInfo r4, java.util.List r5, int r6) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0056;
    L_0x0003:
        r0 = r4.getClassName();
        r0 = r5.contains(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x000d:
        r0 = java.lang.Math.abs(r6);
        r1 = 1;
        if (r0 == r1) goto L_0x0020;
    L_0x0014:
        r0 = r3.h;
        r0 = r0 + 1;
        r3.h = r0;
        r1 = java.lang.Math.abs(r6);
        if (r0 != r1) goto L_0x0051;
    L_0x0020:
        r0 = r3.getClass();
        r0 = r0.getSimpleName();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "findViewByClass:";
        r1 = r1.append(r2);
        r2 = r4.getClassName();
        r1 = r1.append(r2);
        r2 = "@";
        r1 = r1.append(r2);
        r2 = r3.b;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
    L_0x0050:
        return r4;
    L_0x0051:
        r4 = r3.a(r4, r5, r6);
        goto L_0x0050;
    L_0x0056:
        r4 = r0;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.setting.a.a.b.b(android.view.accessibility.AccessibilityNodeInfo, java.util.List, int):android.view.accessibility.AccessibilityNodeInfo");
    }

    public static final AccessibilityNodeInfo findViewByLabel(AccessibilityNodeInfo accessibilityNodeInfo, List list, List list2) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        int i = 0;
        while (accessibilityNodeInfo2 == null && i < accessibilityNodeInfo.getChildCount()) {
            AccessibilityNodeInfo accessibilityNodeInfo3;
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child != null) {
                Log.i("liu---", "-------findViewByLabel:" + child.getText() + "labels=" + list);
                if (child.getText() != null && list != null && list.contains(child.getText().toString())) {
                    Log.d(b.class.getSimpleName(), "findViewByLabel:" + child.getText() + "@");
                    Log.d(b.class.getSimpleName(), child.getClassName().toString());
                    accessibilityNodeInfo3 = child;
                } else if (child.getText() == null || list2 == null || list2.size() <= 0) {
                    accessibilityNodeInfo3 = findViewByLabel(child, list, list2);
                } else {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        if (child.getText().toString().startsWith((String) list2.get(i2))) {
                            accessibilityNodeInfo3 = child;
                            break;
                        }
                    }
                    accessibilityNodeInfo3 = accessibilityNodeInfo2;
                    if (accessibilityNodeInfo3 == null) {
                        accessibilityNodeInfo3 = findViewByLabel(child, list, list2);
                    }
                }
            } else {
                accessibilityNodeInfo3 = accessibilityNodeInfo2;
            }
            i++;
            accessibilityNodeInfo2 = accessibilityNodeInfo3;
        }
        return accessibilityNodeInfo2;
    }

    public static final String getStatusString(int i) {
        switch (i & 255) {
            case 0:
                return "unknow";
            case 1:
                return "setted";
            case 2:
                return "sucess";
            case 16:
                return "timeout";
            case 32:
                return "bottom";
            default:
                return "unknow";
        }
    }

    public static final boolean isActionBreak(int i) {
        return (i & 256) != 0;
    }

    public static final boolean isActionFinished(int i) {
        return i != 0;
    }

    public static final boolean isSuccessed(int i) {
        return (i & 15) != 0;
    }

    public static final boolean isTaskFinished(int i) {
        return (i & 256) != 0 || i == 1;
    }

    public final int UsageStats(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || bb.a(MoSecurityApplication.a())) {
            perform(accessibilityNodeInfo);
            return 2;
        } else if (!isTimeout()) {
            return 0;
        } else {
            int i = this.d ? 272 : 16;
            if (this.s != 3) {
                return i;
            }
            perform(accessibilityNodeInfo);
            return i;
        }
    }

    public final int autoStart_Vivo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (!(this.t || TextUtils.isEmpty(this.c))) {
            this.t = true;
            if (("refresh_vlocker_vivo2".equals(this.b) || ("refresh_vlocker_vivo3".equals(this.b) && VERSION.SDK_INT >= 23)) && OneKeySettingActivity.a() != null) {
                OneKeySettingActivity.a().a(10, this.c);
            }
        }
        if (accessibilityNodeInfo == null) {
            perform(accessibilityNodeInfo);
            return 2;
        } else if (a(accessibilityNodeInfo, false)) {
            perform(accessibilityNodeInfo);
            return 2;
        } else if (!isTimeout()) {
            return 0;
        } else {
            int i = this.d ? 272 : 16;
            if (this.s != 3) {
                return i;
            }
            perform(accessibilityNodeInfo);
            return i;
        }
    }

    public final int execute(String str) {
        int i = 288;
        AccessibilityNodeInfo rootInActiveWindow = SettingService.a().getRootInActiveWindow();
        if ("refresh_oppov2.1".equals(this.b) || "refresh_yunos".equals(this.b)) {
            return manual_setting(rootInActiveWindow);
        }
        if ("refresh_recent".equals(this.b)) {
            return recent_setting(rootInActiveWindow, str);
        }
        AccessibilityNodeInfo accessibilityNodeInfo;
        int i2;
        if (rootInActiveWindow == null || !(str == null || str.equals(rootInActiveWindow.getPackageName()) || "cn.nubia.processmanager".equals(rootInActiveWindow.getPackageName()) || "com.aliyun.mobile.permission".equals(rootInActiveWindow.getPackageName()) || "com.vivo.abeui".equals(rootInActiveWindow.getPackageName()))) {
            accessibilityNodeInfo = rootInActiveWindow;
            i2 = 0;
        } else {
            AccessibilityNodeInfo findViewByViewClass = findViewByViewClass(rootInActiveWindow);
            AccessibilityNodeInfo findViewByClickItemClass = findViewByClickItemClass(findViewByIndex(findViewByLabel(findViewByViewClass)));
            if ("refresh_vlocker_vivo2".equals(this.b) || "refresh_vlocker_vivo".equals(this.b) || "refresh_vlocker_vivo3".equals(this.b)) {
                return autoStart_Vivo(findViewByClickItemClass);
            }
            if ("refresh_allow_usage_access".equals(this.b)) {
                return UsageStats(findViewByClickItemClass);
            }
            if (findViewByClickItemClass != null) {
                if ("find_vlocker_nothing".equals(this.b) && MoSecurityApplication.a() != null) {
                    Rect rect = new Rect();
                    i2 = ((WindowManager) MoSecurityApplication.a().getSystemService("window")).getDefaultDisplay().getHeight();
                    findViewByClickItemClass.getBoundsInScreen(rect);
                    if (rect.bottom > i2 && scroll(findViewByViewClass)) {
                        return this.d ? 288 : 32;
                    }
                }
                if (this.q == 6) {
                    if (findViewByClickItemClass.isChecked()) {
                        this.q = 2;
                    }
                    if (isTimeout()) {
                        this.q = 0;
                        accessibilityNodeInfo = findViewByClickItemClass;
                        i2 = 0;
                    }
                } else {
                    Log.i("liu----", "checkStatus(node, false)=" + a(findViewByClickItemClass, false));
                    if (a(findViewByClickItemClass, false)) {
                        if ("click_vlocker_list_uncheck_switch_for_notify".equals(this.b) || "click_vlocker_check_close".equals(this.b) || "click_vlocker_exlist_check".equals(this.b) || "click_vlocker_exlist_checkbox".equals(this.b)) {
                            accessibilityNodeInfo = findViewByClickItemClass;
                            i2 = 2;
                        } else {
                            i2 = 1;
                            accessibilityNodeInfo = findViewByClickItemClass;
                        }
                    } else if (perform(findViewByClickItemClass)) {
                        accessibilityNodeInfo = findViewByClickItemClass;
                        i2 = 2;
                    }
                }
            } else if (scroll(findViewByViewClass)) {
                if (!this.d) {
                    i = 32;
                }
                i2 = i;
                accessibilityNodeInfo = findViewByClickItemClass;
            }
            accessibilityNodeInfo = findViewByClickItemClass;
            i2 = 0;
        }
        if (i2 == 0 && isTimeout()) {
            i2 = this.d ? 272 : 16;
            if (this.s == 3) {
                perform(accessibilityNodeInfo);
            }
            Log.d(getClass().getSimpleName(), "timeout:" + this.f + "#" + SystemClock.uptimeMillis());
        }
        if ("refresh_vlocker_vivo2".equals(this.b) || "refresh_vlocker_vivo".equals(this.b) || "refresh_vlocker_vivo3".equals(this.b)) {
            if (this.s == 3) {
                perform(accessibilityNodeInfo);
            }
            return 2;
        }
        Log.i("liu---", "status=" + i2);
        return i2;
    }

    public final AccessibilityNodeInfo findViewByClickItemClass(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || this.i != null || this.p == null) {
            return accessibilityNodeInfo;
        }
        if (accessibilityNodeInfo.getParent() != null) {
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
        }
        return a(accessibilityNodeInfo, this.p, this.j);
    }

    public AccessibilityNodeInfo findViewByIndex(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo == null || this.i == null) {
            return accessibilityNodeInfo;
        }
        if (accessibilityNodeInfo.getChildCount() == 0) {
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
        }
        int intValue = this.i.intValue();
        if (this.i.intValue() < 0) {
            intValue = accessibilityNodeInfo.getChildCount() + this.i.intValue();
        }
        if (accessibilityNodeInfo == null || intValue < 0 || intValue >= accessibilityNodeInfo.getChildCount()) {
            return null;
        }
        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(intValue);
        if (this.p == null || child == null || this.p.contains(child.getClassName())) {
            accessibilityNodeInfo2 = child;
        }
        Log.d(getClass().getSimpleName(), "findViewByIndex:" + this.i + "@" + this.b);
        return accessibilityNodeInfo2;
    }

    public final AccessibilityNodeInfo findViewByLabel(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo != null ? (this.n == null && this.o == null) ? accessibilityNodeInfo : findViewByLabel(accessibilityNodeInfo, this.n, this.o) : accessibilityNodeInfo;
    }

    public final AccessibilityNodeInfo findViewByViewClass(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || this.l == null) {
            return accessibilityNodeInfo;
        }
        this.h = 0;
        return a(accessibilityNodeInfo, this.l, this.m);
    }

    public String getActionId() {
        return this.b;
    }

    public int getTime() {
        return (int) ((SystemClock.uptimeMillis() - this.f) / 1000);
    }

    public int getTimeout() {
        return this.e;
    }

    public boolean isTimeout() {
        return this.e > 0 && this.f != -1 && SystemClock.uptimeMillis() > this.f + ((long) this.e);
    }

    public int manual_setting(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (!(MoSecurityApplication.c || this.t || TextUtils.isEmpty(this.c))) {
            this.t = true;
            if (OneKeySettingActivity.a() != null) {
                OneKeySettingActivity.a().a(9);
                OneKeySettingActivity.a().a(10, this.c);
            }
        }
        if (MoSecurityApplication.c) {
            if (this.t) {
                perform(accessibilityNodeInfo);
            }
            return 2;
        } else if (!isTimeout()) {
            return 0;
        } else {
            int i = this.d ? 272 : 16;
            if (this.s != 3) {
                return i;
            }
            perform(accessibilityNodeInfo);
            return i;
        }
    }

    @TargetApi(16)
    public final boolean perform(AccessibilityNodeInfo accessibilityNodeInfo) {
        Object rect = new Rect();
        boolean performAction;
        switch (this.s) {
            case 1:
                if (!(accessibilityNodeInfo == null || accessibilityNodeInfo.isClickable())) {
                    accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                }
                if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isClickable()) {
                    return false;
                }
                performAction = accessibilityNodeInfo.performAction(16);
                Log.i("liu---", "clickNode=" + accessibilityNodeInfo.getClassName() + ";ACTION_CLICK success=" + performAction);
                if (performAction || this.c == null || this.t) {
                    return performAction;
                }
                this.t = true;
                if (OneKeySettingActivity.a() == null) {
                    return performAction;
                }
                OneKeySettingActivity.a().a(6, this.c);
                return performAction;
            case 2:
                if (accessibilityNodeInfo == null) {
                    return false;
                }
                accessibilityNodeInfo.getBoundsInScreen(rect);
                if (OneKeySettingActivity.a() != null) {
                    OneKeySettingActivity.a().a(2, rect);
                }
                return true;
            case 3:
                if (OneKeySettingActivity.a() != null) {
                    OneKeySettingActivity.a().a(1);
                }
                return true;
            case 4:
                if (!(accessibilityNodeInfo == null || accessibilityNodeInfo.isClickable())) {
                    accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                }
                if (accessibilityNodeInfo == null) {
                    return false;
                }
                performAction = accessibilityNodeInfo.performAction(16);
                Log.i("liu---", "clickNode2=" + accessibilityNodeInfo.getClassName() + ";ACTION_CHECK success=" + performAction);
                return performAction;
            case 5:
                return true;
            case 6:
                SettingService.a().c();
                return true;
            case 7:
                if (accessibilityNodeInfo != null) {
                    accessibilityNodeInfo = accessibilityNodeInfo.getParent();
                }
                if (accessibilityNodeInfo == null) {
                    return false;
                }
                performAction = accessibilityNodeInfo.performAction(16);
                Log.i("liu---", "clickNode3=" + accessibilityNodeInfo.getClassName() + ";ACTION_CHECK success=" + performAction);
                return performAction;
            default:
                return false;
        }
    }

    public int recent_setting(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int i = 0;
        if (accessibilityNodeInfo != null && (str == null || str.equals(accessibilityNodeInfo.getPackageName()))) {
            this.u = true;
            if (!this.t) {
                this.t = true;
                if (OneKeySettingActivity.a() != null) {
                    OneKeySettingActivity.a().a(9);
                }
            }
        } else if (this.u) {
            i = 2;
            if (this.s == 3) {
                perform(accessibilityNodeInfo);
                RecentShowActivity.a();
                return i;
            }
        }
        if (i == 0 && isTimeout()) {
            i = this.d ? 272 : 16;
            if (this.s == 3) {
                perform(accessibilityNodeInfo);
                RecentShowActivity.a();
                SettingService.a().performGlobalAction(1);
            }
        }
        return i;
    }

    public void resetTime() {
        this.f = SystemClock.uptimeMillis();
        this.g = -1;
        this.t = false;
        this.u = false;
    }

    public boolean scroll(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z = false;
        if (this.r && accessibilityNodeInfo != null) {
            if (accessibilityNodeInfo.performAction(4096)) {
                this.g = SystemClock.uptimeMillis();
            } else if (this.g == -1) {
                this.g = SystemClock.uptimeMillis();
            } else {
                if (SystemClock.uptimeMillis() > this.g + 2000) {
                    z = true;
                }
                Log.d(getClass().getSimpleName(), "scroll:" + accessibilityNodeInfo.getClassName() + "@" + this.b);
            }
        }
        return z;
    }

    @com.vlocker.setting.common.a.b(a = "id")
    public void setActionId(String str) {
        this.b = str;
    }

    @com.vlocker.setting.common.a.b(a = "alert")
    public void setAlertMessage(String str) {
        this.c = str;
    }

    @com.vlocker.setting.common.a.b(a = "class_times")
    public void setClassFoundTimes(int i) {
        this.m = i;
    }

    @com.vlocker.setting.common.a.b(a = "click")
    public void setClickClassName(String str) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(str);
    }

    @com.vlocker.setting.common.a.b(a = "click_times")
    public void setClickClassTimes(int i) {
        this.j = i;
    }

    @com.vlocker.setting.common.a.b(a = "index")
    public void setItemIndex(int i) {
        this.i = Integer.valueOf(i);
    }

    @com.vlocker.setting.common.a.b(a = "label")
    public void setItemLabel(String str) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.add(str);
    }

    @com.vlocker.setting.common.a.b(a = "label_start")
    public void setItemLabel_Start(String str) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(str);
    }

    @com.vlocker.setting.common.a.b(a = "status")
    public void setItemStatus(String str) {
        if (str != null && !str.isEmpty()) {
            if ("checked".equals(str)) {
                this.q = 1;
            } else if ("unchecked".equals(str)) {
                this.q = 2;
            } else if ("disable".equals(str)) {
                this.q = 3;
            } else if ("exist".equals(str)) {
                this.q = 4;
            } else if ("notexist".equals(str)) {
                this.q = 5;
            } else if ("checkselected".equals(str)) {
                this.q = 6;
            } else {
                this.q = 7;
                this.a = str;
            }
        }
    }

    @com.vlocker.setting.common.a.b(a = "must")
    public void setMustSuccess(boolean z) {
        this.d = z;
    }

    @com.vlocker.setting.common.a.b(a = "perform")
    public void setPerformActionId(String str) {
        if ("click".equals(str)) {
            this.s = 1;
        } else if ("show".equals(str)) {
            this.s = 2;
        } else if ("refresh".equals(str)) {
            this.s = 3;
        } else if ("check".equals(str)) {
            this.s = 4;
        } else if ("nothing".equals(str)) {
            this.s = 5;
        } else if ("back".equals(str)) {
            this.s = 6;
        } else if ("click_parent".equals(str)) {
            this.s = 7;
        }
    }

    @com.vlocker.setting.common.a.b(a = "scroll")
    public void setScrollable(boolean z) {
        this.r = z;
    }

    @com.vlocker.setting.common.a.b(a = "sleep")
    public void setSleepTime(int i) {
        this.k = i;
    }

    @com.vlocker.setting.common.a.b(a = "timeout")
    public void setTimeout(int i) {
        this.e = i;
    }

    @com.vlocker.setting.common.a.b(a = "class")
    public void setViewClassName(String str) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        this.l.add(str);
    }

    public final void sleep() {
        if (this.k > 0) {
            try {
                Thread.sleep((long) this.k);
            } catch (InterruptedException e) {
            }
        }
    }
}
