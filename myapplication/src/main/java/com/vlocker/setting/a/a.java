package com.vlocker.setting.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.m.bb;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.OneKeySettingActivity;
import com.vlocker.setting.SettingService;
import com.vlocker.setting.a.a.b;
import com.vlocker.setting.a.a.e;
import com.vlocker.setting.a.a.h;
import com.vlocker.setting.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a extends com.vlocker.setting.common.b.a {
    public static final String SHARED_KEY_TASK_STATUS = "onekeysetting_status";
    private static a a = null;
    private Context b = null;
    private e c = null;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private boolean g = false;
    private Set h = new HashSet();
    private Set i = new HashSet();
    private Map j = new HashMap();
    private final List k = new ArrayList();
    private e l = null;
    private SharedPreferences m = null;
    private Map n = null;
    private String[] o = new String[]{"FLOAT_WIN_360"};

    private a() {
    }

    private final String a(e eVar) {
        return eVar.getTaskId() != null ? eVar.getTaskId() : (eVar.getIntentAction() == null || e.ACTION_MAIN.equals(eVar.getIntentAction())) ? eVar.getAppPackageName() : eVar.getIntentAction();
    }

    private final void a() {
        int i = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            e eVar = (e) this.k.get(i2);
            if (!eVar.finished()) {
                i += eVar.getEstimatedTimeOfCompletion();
            }
        }
        if (this.l != null) {
            this.f = this.l.getEstimatedTimeOfCompletion();
        }
        this.e = this.f + i;
    }

    private final void a(String str, boolean z) {
        if (str != null && !str.isEmpty()) {
            Editor edit = this.m.edit();
            if (b(str) && !z) {
                edit.remove(str);
            } else if (z) {
                edit.putBoolean(str, z);
            }
            edit.commit();
        }
    }

    private boolean a(String str) {
        int i = 0;
        while (i < this.o.length) {
            if (this.o[i].equals(str)) {
                return "FLOAT_WIN_VIVO".equals(str) && !b.isFloatWindowOpen(this.b);
            } else {
                i++;
            }
        }
        return true;
    }

    @TargetApi(16)
    private final void b() {
        String appPackageName = this.c.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            List list;
            if (this.n == null) {
                this.n = new HashMap();
                String[] split = "com.tencent.qqpimsecure#进入首页>#skip,com.tencent.qqpimsecure#手机卡慢 空间不足#skip,com.tencent.qqpimsecure#《腾讯手机管家许可及服务协议》#skip,ccom.tencent.qqpimsecure#All Rights Reserved#skip,om.tencent.qqpimsecure#手机卡慢 空间不足#skip,com.qihoo.cleandroid_cn#《安装许可协议》#skip".split(",");
                for (String split2 : split) {
                    String[] split3 = split2.split("#");
                    list = (List) this.n.get(split3[0]);
                    if (list == null) {
                        list = new ArrayList();
                        this.n.put(split3[0], list);
                    }
                    list.add(split3[1]);
                }
            }
            list = (List) this.n.get(appPackageName);
            if (list != null) {
                AccessibilityNodeInfo rootInActiveWindow = SettingService.a().getRootInActiveWindow();
                if (rootInActiveWindow != null && appPackageName.equals(rootInActiveWindow.getPackageName()) && b.findViewByLabel(rootInActiveWindow, list, null) != null) {
                    this.c.skipActions();
                    Log.d(getClass().getSimpleName(), "skipActions:" + list + "@" + appPackageName);
                }
            }
        }
    }

    private final boolean b(e eVar) {
        return b(a(eVar));
    }

    private final boolean b(String str) {
        if (str == null) {
            return false;
        }
        boolean z = this.m.getBoolean(str, false);
        Log.d(getClass().getSimpleName(), "getStatus:" + str + "=" + z);
        return z;
    }

    public static final a getInstance() {
        return getInstance(null);
    }

    public static final a getInstance(Context context) {
        if (a == null) {
            a = new a();
        }
        if (context != null) {
            a.b = context;
            a.m = a.b.getSharedPreferences(SHARED_KEY_TASK_STATUS, 0);
        }
        return a;
    }

    protected final boolean a(Message message) {
        boolean z = false;
        if (this.b == null) {
            return false;
        }
        this.c = null;
        this.d = -1;
        this.g = false;
        message.obj = this.k;
        com.vlocker.setting.common.a.a aVar = new com.vlocker.setting.common.a.a(this.b);
        if (this.h.isEmpty()) {
            aVar.a("conf/rom.conf", (Object) this);
        }
        if ("360UI".equals(Build.BRAND) || MoSecurityApplication.e) {
            a("FLOAT_WIN", MoSecurityApplication.c);
        } else if (hasRomReature("dido(6.0+)")) {
            a("FLOAT_WIN", !com.vlocker.c.a.a(this.b).bn());
        } else if (hasRomReature("miui_v5")) {
            a("FLOAT_WIN", b.isOpenForV5(this.b));
        } else if (VERSION.SDK_INT >= 19 || hasRomReature("miui_v6") || hasRomReature("miui_v7")) {
            a("FLOAT_WIN", b.isFloatWindowOpen(this.b));
        }
        if (VERSION.SDK_INT >= 18 || hasRomReature("miui")) {
            a(e.ACTION_NOTIFICATION_LISTENER_SETTINGS, b.CheckNotifiServiceValid(this.b));
        }
        if (bb.a()) {
            a("USAGE_ACCESS", bb.a(this.b));
        }
        aVar.a("conf/set.conf", (Object) this);
        if (!this.k.isEmpty()) {
            PackageManager packageManager = this.b.getPackageManager();
            int i = 0;
            while (i < this.k.size()) {
                e eVar = (e) this.k.get(i);
                if (!(eVar.getAppPackageName() == null || b.isPackageNameUninstalled(packageManager, eVar.getAppPackageName()))) {
                    this.i.remove(eVar.getTaskName());
                    this.k.remove(eVar);
                    setTaskStatus(eVar, false);
                    i--;
                }
                eVar.setFinished(b(eVar));
                i++;
            }
        }
        if (this.l != null) {
            this.l.resetActionStatus();
        }
        a();
        com.vlocker.c.a a = com.vlocker.c.a.a(this.b);
        if (!hasNewTask()) {
            z = true;
        }
        a.j(z);
        sendMessage(7, this.k);
        return true;
    }

    @com.vlocker.setting.common.a.b(a = "roms")
    public final void addRomFeature(h hVar) {
        if (hVar.matched()) {
            String[] romNames = hVar.getRomNames();
            for (int i = 0; i < romNames.length; i++) {
                this.h.add(romNames[i]);
                Log.i("liu---", "addRomFeature mRomTitle=" + romNames[i]);
                Log.d(getClass().getSimpleName(), romNames[i]);
            }
        }
    }

    @com.vlocker.setting.common.a.b(a = "action")
    public final void addSettingAction(b bVar) {
        this.j.put(bVar.getActionId(), bVar);
        Log.d(getClass().getSimpleName(), "id:" + bVar.getActionId());
    }

    @com.vlocker.setting.common.a.b(a = "task")
    public final void addSettingTask(e eVar) {
        PackageManager packageManager = this.b.getPackageManager();
        if (!this.i.contains(eVar.getTaskName()) && eVar.validateRom(this.h) && eVar.validateIntent(packageManager) && eVar.validateVersion(packageManager)) {
            if (!MoSecurityApplication.e || SettingService.b(this.b) || !"notify_yunos".equals(eVar.getTaskId())) {
                this.i.add(eVar.getTaskName());
                this.k.add(eVar);
                Log.i("liu---", "addSettingTask getTaskName=" + eVar.getTaskName() + ";getTaskId=" + eVar.getTaskId());
            } else {
                return;
            }
        }
        Log.d(getClass().getSimpleName(), eVar.getTaskName());
    }

    protected final boolean b(Message message) {
        boolean z;
        if (this.c != null) {
            Log.i("liu---", "----------------------mCurrentTask=" + this.c.getTaskName());
        }
        boolean z2 = this.b == null || !s.g();
        if (z2 || !(this.c == null || this.c.finished())) {
            if (!(!z2 || this.c == null || this.c.finished())) {
                this.c.resetActionStatus();
            }
            z = z2;
        } else {
            if (needCleanTask()) {//是否要关掉应用
                this.c = this.l;
            } else {
                do {
                    int i = this.d + 1;
                    this.d = i;
                    z = i >= this.k.size();
                    if (z) {
                        this.c = null;
                    } else {
                        this.c = (e) this.k.get(this.d);
                        this.c.startTime = System.currentTimeMillis();
                    }
                    if (!(this.c == null || !this.c.finished() || "close_app".equals(this.c.getTaskName()))) {
                        if (this.d == this.k.size() - 1) {
                            sendMessage(5, this.c, 3000);
                        } else {
                            sendMessage(5, this.c);
                        }
                        if ("A_tengxun".equals(j.p(this.b))) {
                            p.a(this.b, "Vlocker_Time_Of_Rescue_Locker_PPC_TF", "time", "0", "RescueName", this.c.getTaskName(), "RescueTime", (System.currentTimeMillis() - this.c.startTime) + "");
                        }
                    }
                    if (this.c == null) {
                        z2 = z;
                        break;
                    }
                } while (this.c.finished());
                z2 = z;
            }
            if (!(this.c == null || this.c.finished())) {
                this.c.resetActionStatus();
                this.c.startActivity(this.b);
                if ("package:com.android.settings".equals(this.c.getIntentData())) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        Log.d(getClass().getSimpleName(), e.toString());
                    }
                }
                if ("USAGE_ACCESS".equals(this.c.getTaskId()) || "SET_PURE_BACKGROUND_dido6.0".equals(this.c.getTaskId())) {
                    try {
                        Thread.sleep(1000);
                        z = z2;
                    } catch (Exception e2) {
                        z = z2;
                    }
                }
            }
            z = z2;
        }
        if (z) {
            com.vlocker.c.a.a(this.b).Y(false);
            if (!s.h()) {
                com.vlocker.c.a a = com.vlocker.c.a.a(this.b);
                if (a.bq()) {
                    a.aa(false);
                }
                if (OneKeySettingActivity.a() != null) {
                    OneKeySettingActivity.a().a("Vlocker_Done_Rescue_PPC_TF");
                }
            }
        } else {
            b();
            if (this.c.execute() && ((!this.c.finished() || this.d >= this.k.size() - 1 || ((e) this.k.get(this.d + 1)).isOnSetting()) && !"close_app".equals(this.c.getTaskName()))) {
                sendMessage(3, getProgress());
            }
            if (this.c.finished() && !"close_app".equals(this.c.getTaskName())) {
                if (this.d == this.k.size() - 1) {
                    sendMessage(5, this.c, 3000);
                } else {
                    sendMessage(5, this.c);
                }
                if ("A_tengxun".equals(j.p(this.b))) {
                    p.a(this.b, "Vlocker_Time_Of_Rescue_Locker_PPC_TF", "time", "0", "RescueName", this.c.getTaskName(), "RescueTime", (System.currentTimeMillis() - this.c.startTime) + "");
                }
            }
        }
        return z;
    }

    protected final boolean c(Message message) {
        return false;
    }

    public final void cleanEmptyTask() {
        Collection arrayList = new ArrayList();
        for (int i = 0; i < this.k.size(); i++) {
            if ("empty".equals(((e) this.k.get(i)).getTaskName())) {
                arrayList.add(this.k.get(i));
            }
        }
        this.k.removeAll(arrayList);
    }

    protected final boolean d(Message message) {
        this.h.clear();
        this.j.clear();
        this.k.clear();
        this.i.clear();
        this.c = null;
        return true;
    }

    public boolean finished() {
        boolean z = true;
        int i = 0;
        while (z && i < this.k.size()) {
            boolean finished = ((e) this.k.get(i)).finished();
            i++;
            z = finished;
        }
        return z;
    }

    public OneKeySettingActivity getApplicationContext() {
        return (OneKeySettingActivity) this.b;
    }

    public final Context getContext() {
        return this.b;
    }

    public e getCurrentTask() {
        return this.c;
    }

    public List getMaunalTasks(boolean z) {
        int i = 0;
        List settingTasks = getInstance().getSettingTasks();
        List arrayList = new ArrayList();
        if (settingTasks != null && settingTasks.size() == 1 && ((e) settingTasks.get(0)).isNotificationListenerSetting()) {
            return arrayList;
        }
        while (i < settingTasks.size()) {
            e eVar = (e) settingTasks.get(i);
            if (z) {
                if (!TextUtils.isEmpty(eVar.getGuideUrl()) || (eVar.getmFollowUp() != null && eVar.getmFollowUp().contains("manual"))) {
                    arrayList.add(eVar);
                } else if (!(eVar.finished() || eVar.getmFollowUp() == null || !eVar.getmFollowUp().contains("open"))) {
                    arrayList.add(eVar);
                }
            } else if (!TextUtils.isEmpty(eVar.getGuideUrl())) {
                arrayList.add(eVar);
            } else if (!(eVar.finished() || eVar.getmFollowUp() == null || !eVar.getmFollowUp().contains("open"))) {
                arrayList.add(eVar);
            }
            i++;
        }
        return arrayList;
    }

    public final Float[] getProgress() {
        Float[] fArr = new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)};
        if (this.e > 0 && this.d >= 0 && this.d < this.k.size()) {
            int i;
            e eVar;
            int nextActionTimeout;
            int i2 = 0;
            for (i = this.d; i < this.k.size(); i++) {
                eVar = (e) this.k.get(i);
                if (!eVar.finished()) {
                    i2 += eVar.getEstimatedTimeOfCompletion();
                }
            }
            eVar = (e) this.k.get(this.d);
            if (this.d + 1 == this.k.size() && "package:com.android.settings".equals(eVar.getIntentData())) {
                i = i2 + this.l.getEstimatedTimeOfCompletion();
                nextActionTimeout = this.l.getNextActionTimeout();
            } else {
                i = this.f + i2;
                nextActionTimeout = eVar.getNextActionTimeout();
            }
            fArr[0] = Float.valueOf(((float) (this.e - i)) / ((float) this.e));
            fArr[1] = Float.valueOf(((float) (nextActionTimeout + (this.e - i))) / ((float) this.e));
        } else if (finished()) {
            fArr[0] = Float.valueOf(1.0f);
            fArr[1] = Float.valueOf(1.0f);
        }
        return fArr;
    }

    public final b getSettingAction(String str) {
        return (b) this.j.get(str);
    }

    public List getSettingTasks() {
        return this.k;
    }

    public int getTaskNumByType(int i) {
        List settingTasks = getSettingTasks();
        int i2 = 0;
        for (int i3 = 0; i3 < settingTasks.size(); i3++) {
            if (((e) settingTasks.get(i3)).getGroup() == i) {
                i2++;
            }
        }
        return i2;
    }

    public final int getTotalTime() {
        if (this.e == -1) {
            a();
        }
        return this.e;
    }

    public final int getUnfinishedTaskCount() {
        int i = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (!((e) this.k.get(i2)).finished()) {
                i++;
            }
        }
        return i;
    }

    public final boolean hasNewTask() {
        int i = 0;
        boolean z = false;
        while (!z && i < this.k.size()) {
            z = !isTaskSetted((e) this.k.get(i));
            i++;
        }
        return z;
    }

    public final boolean hasRomReature(String str) {
        return this.h.contains(str);
    }

    public final boolean isEmpty() {
        Log.d(getClass().getSimpleName(), "" + this.k.size());
        return this.k.isEmpty();
    }

    public boolean isFailedTaskAllOpen() {
        List settingTasks = getSettingTasks();
        for (int i = 0; i < settingTasks.size(); i++) {
            e eVar = (e) settingTasks.get(i);
            if (!eVar.finished() && (eVar.getmFollowUp() == null || !eVar.getmFollowUp().contains("open"))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isTaskSetted(e eVar) {
        return this.m.contains(a(eVar));
    }

    public boolean needCleanTask() {
        boolean z = true;
        if (this.c == null) {
            return false;
        }
        String appPackageName = this.c.getAppPackageName();
        if (appPackageName != null && !appPackageName.isEmpty() && !appPackageName.equals("com.android.settings")) {
            this.l.setIntentData("package:" + this.c.getAppPackageName());
        } else if (!finished() || this.g) {
            z = false;
        } else {
            this.l.setIntentData("package:com.android.settings");
            this.g = true;
        }
        if (this.l == null) {
            return z;
        }
        this.l.resetActionStatus();
        return z;
    }

    public void resetFinished() {
        int i = 0;
        while (i < this.k.size()) {
            e eVar = (e) this.k.get(i);
            if (((e) this.k.get(i)).getmFollowUp() == null || !((e) this.k.get(i)).getmFollowUp().contains("open")) {
                setTaskStatus((e) this.k.get(i), false);
                p.a(this.b, "Vlocker_Restart_Rescue_Locker_PPC_TF", "rescue_name", ((e) this.k.get(i)).getTaskName());
            } else if (((e) this.k.get(i)).isNotificationListenerSetting() && !getInstance().hasRomReature("smartisan3.0+")) {
                a(e.ACTION_NOTIFICATION_LISTENER_SETTINGS, false);
                p.a(this.b, "Vlocker_Restart_Rescue_Locker_PPC_TF", "rescue_name", ((e) this.k.get(i)).getTaskName());
            }
            if (!(this.k.get(i) == null || a(((e) this.k.get(i)).getTaskId()))) {
                setTaskStatus((e) this.k.get(i), true);
            }
            eVar.setFinished(b(eVar));
            i++;
        }
    }

    public void sendMessage(int i, Object obj) {
        if (this.b instanceof OneKeySettingActivity) {
            ((OneKeySettingActivity) this.b).a(i, obj);
        }
    }

    public void sendMessage(int i, Object obj, long j) {
        if (this.b instanceof OneKeySettingActivity) {
            ((OneKeySettingActivity) this.b).a(i, obj, j);
        }
    }

    @com.vlocker.setting.common.a.b(a = "clean_task")
    public final void setCleanTask(e eVar) {
        this.l = eVar;
    }

    public final void setTaskStatus(e eVar, boolean z) {
        a(a(eVar), z);
    }
}
