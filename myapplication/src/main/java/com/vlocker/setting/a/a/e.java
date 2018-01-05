package com.vlocker.setting.a.a;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.vlocker.b.p;
import com.vlocker.locker.BuildConfig;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.RecentShowActivity;
import com.vlocker.setting.SettingService;
import com.vlocker.setting.a.a;
import com.vlocker.setting.common.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@TargetApi(16)
public final class e {
    public static final String ACTION_APPLICATION_DETAILS_SETTINGS = "detail";
    public static final String ACTION_APPLICATION_DETAILS_VLOCKER = "vlocker_detail";
    public static final String ACTION_APPLICATION_RECENT = "recent";
    public static final String ACTION_MAIN = "main";
    public static final String ACTION_NOTIFICATION_LISTENER_SETTINGS = "notify";
    public static final String ACTION_USAGE_ACCESS_SETTINGS = "usage_access";
    private String a = null;
    private String b = null;
    private List c = new ArrayList();
    private List d = new ArrayList();
    private String e = null;
    private int f = 0;
    private int g = -1;
    private String h = null;
    private List i = new ArrayList();
    public boolean isTextAnim = false;
    private String j = null;
    private Bundle k = null;
    private String l = null;
    private Iterator m = null;
    private g n = null;
    private boolean o = false;
    private String p = null;
    private String q = null;
    private int r = 0;
    private int s = 0;
    public long startTime = 0;
    private String t = null;

    private final int a(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 8192);
            return packageInfo != null ? packageInfo.versionCode : -1;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", str, null));
        intent.setFlags(276824064);
        return intent;
    }

    private final g a() {
        if (this.m == null) {
            this.m = this.i.iterator();
        }
        if (this.m.hasNext()) {
            this.n = (g) this.m.next();
            if (this.n.getAction() != null) {
                this.n.getAction().resetTime();
            }
        } else {
            this.o = true;
            this.n = null;
            a.getInstance().setTaskStatus(this, true);
        }
        return this.n;
    }

    private void a(b bVar) {
        if (this.n.d = false) {
            bVar.sleep();
            this.n.d = true;
        }
    }

    public final boolean execute() {
        boolean isActionFinished;
        b currentAction = getCurrentAction();
        a instance = a.getInstance();
        if (currentAction != null) {
            Log.i("liu---", "action=" + currentAction.getActionId());
            a(currentAction);
            int execute = currentAction.execute(this.e);
            isActionFinished = b.isActionFinished(execute);
            if (isActionFinished) {
                setActionFinished();
                this.o = b.isTaskFinished(execute);
                if (this.o) {
                    boolean isSuccessed = b.isSuccessed(execute);
                    instance.setTaskStatus(this, true);
                    while (this.m.hasNext()) {
                        this.m.next();
                    }
                    Log.d(getClass().getSimpleName(), "finish:" + this.e + isSuccessed);
                }
                p.a(instance.getContext(), "Vlocker_Success_Name_Rescue_Locker_PPC_TF", "rescue_name", getTaskName(), "ActionName", currentAction.getActionId(), "Do", b.getStatusString(execute));
                if (b.isActionBreak(execute)) {
                    String str = currentAction.getActionId() + SettingService.a(SettingService.a().getRootInActiveWindow());
                    if (str.length() > 255) {
                        str.substring(0, 255);
                    }
                }
            }
        } else {
            isActionFinished = false;
        }
        Log.i("liu---", "execute actionFinished=" + isActionFinished);
        return isActionFinished;
    }

    public boolean finished() {
        return this.o;
    }

    public String getActivityClassName() {
        return this.h;
    }

    public String getAppPackageName() {
        return this.e;
    }

    public final b getCurrentAction() {
        if (!finished() && (this.n == null || this.n.c)) {
            a();
        }
        if (this.n == null) {
            return null;
        }
        b action = this.n.getAction();
        Log.d(getClass().getSimpleName(), this.n.b);
        return action;
    }

    public String getDes() {
        return this.t;
    }

    public int getEstimatedTimeOfCompletion() {
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            g gVar = (g) this.i.get(i2);
            if (!gVar.c) {
                b action = gVar.getAction();
                if (action != null) {
                    i += action.getTimeout();
                }
            }
        }
        return i;
    }

    public int getGroup() {
        return this.s;
    }

    public String getGuideUrl() {
        return this.p;
    }

    public final Intent getIntent() {
        Intent intent;
        if (this.j == null) {
            intent = new Intent();
        } else if (ACTION_MAIN.equals(this.j)) {
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
        } else if (ACTION_NOTIFICATION_LISTENER_SETTINGS.equals(this.j)) {
            intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        } else if (ACTION_APPLICATION_DETAILS_SETTINGS.equals(this.j)) {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        } else if (ACTION_USAGE_ACCESS_SETTINGS.equals(this.j)) {
            intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        } else if (ACTION_APPLICATION_DETAILS_VLOCKER.equals(this.j)) {
            return a(BuildConfig.APPLICATION_ID);
        } else {
            if (ACTION_APPLICATION_RECENT.equals(this.j)) {
                intent = new Intent(MoSecurityApplication.a(), RecentShowActivity.class);
                intent.putExtra(IXAdRequestInfo.ACT, this.q);
                intent.putExtra("packageName", this.e);
                intent.putExtra("activity", this.h);
                intent.putExtra("recent_type", this.r);
                intent.addFlags(268435456);
                return intent;
            }
            intent = new Intent(this.j);
        }
        if (this.k != null) {
            intent.putExtras(this.k);
        }
        if (this.l != null) {
            intent.setData(Uri.parse(this.l));
        }
        if (this.e != null) {
            intent.setComponent(new ComponentName(this.e, this.h));
        }
        intent.addFlags(268468224);
        return intent;
    }

    public String getIntentAction() {
        return this.j;
    }

    public String getIntentData() {
        return this.l;
    }

    public int getNextActionTimeout() {
        int i = 0;
        while (i < this.i.size()) {
            g gVar = (g) this.i.get(i);
            if (gVar.c) {
                i++;
            } else {
                b action = gVar.getAction();
                return action != null ? action.getTimeout() : 0;
            }
        }
        return 0;
    }

    public String getTaskId() {
        return this.a;
    }

    public String getTaskName() {
        return this.b;
    }

    public List getmFollowUp() {
        return this.d;
    }

    public boolean isNotificationListenerSetting() {
        return ACTION_NOTIFICATION_LISTENER_SETTINGS.equals(this.j);
    }

    public boolean isOnSetting() {
        return this.m != null;
    }

    public void resetActionStatus() {
        for (int i = 0; i < this.i.size(); i++) {
            ((g) this.i.get(i)).init();
        }
        this.o = false;
        this.m = null;
        this.n = null;
    }

    @b(a = "recent_type")
    public void setAct(int i) {
        this.r = i;
    }

    @b(a = "act")
    public void setAct(String str) {
        this.q = str;
    }

    public void setActionFinished() {
        this.n.c = true;
    }

    @b(a = "activity")
    public void setActivityClassName(String str) {
        this.h = str;
    }

    @b(a = "pkg_name")
    public void setAppPackageName(String str) {
        this.e = str;
    }

    @b(a = "action")
    public void setCheckAction(String str) {
        this.i.add(new g(this, str));
    }

    @b(a = "des")
    public void setDes(String str) {
        this.t = str;
    }

    public void setFinished(boolean z) {
        this.o = z;
        if (!this.o) {
            resetActionStatus();
        }
    }

    @b(a = "follow_up")
    public void setFollowUp(String str) {
        this.d.add(str);
    }

    @b(a = "group")
    public void setGroup(int i) {
        this.s = i;
    }

    @b(a = "guide_url")
    public void setGuide_url(String str) {
        this.p = str;
    }

    @b(a = "intent")
    public void setIntentAction(String str) {
        this.j = str;
    }

    @b(a = "data")
    public void setIntentData(String str) {
        this.l = str;
    }

    @b(a = "extra")
    public void setIntentExtra(String str) {
        if (this.k == null) {
            this.k = new Bundle();
        }
        String[] split = str.split("=");
        String str2 = split[0];
        String str3 = split[1];
        if (str3.startsWith("$uid@")) {
            String substring = str3.substring("$uid@".length());
            try {
                this.k.putInt(str2, a.getInstance().getContext().getPackageManager().getPackageInfo(substring, 0).applicationInfo.uid);
            } catch (NameNotFoundException e) {
                Log.e(getClass().getSimpleName(), e.toString());
            }
            Log.d(getClass().getSimpleName(), substring);
        } else if (TextUtils.isDigitsOnly(str3)) {
            this.k.putInt(str2, Integer.valueOf(str3).intValue());
        } else {
            this.k.putString(str2, str3);
        }
    }

    @b(a = "max_version")
    public void setMaxVersion(int i) {
        this.g = i;
    }

    @b(a = "min_version")
    public void setMinVersion(int i) {
        this.f = i;
    }

    @b(a = "rom")
    public void setRomFeature(String str) {
        this.c.add(str);
    }

    @b(a = "id")
    public void setTaskId(String str) {
        this.a = str;
    }

    @b(a = "task_name")
    public void setTaskName(String str) {
        this.b = str;
    }

    public void skipActions() {
        if (this.m == null) {
            this.m = this.i.iterator();
        }
        while (this.m.hasNext()) {
            this.n = (g) this.m.next();
            this.n.c = true;
        }
    }

    public boolean startActivity(Context context) {
        boolean z = false;
        if (!finished()) {
            try {
                context.startActivity(getIntent());
                z = true;
            } catch (Exception e) {
                Log.i("liu---", e.toString());
                Log.e(getClass().getSimpleName(), e.toString());
            }
        }
        Log.d(getClass().getSimpleName(), "start:" + this.e + ":" + this.h);
        return z;
    }

    public boolean validateIntent(PackageManager packageManager) {
        return com.vlocker.setting.a.b.validateIntent(packageManager, getIntent());
    }

    public final boolean validateRom(Set set) {
        boolean z = this.c.size() == 0;
        int i = 0;
        boolean z2 = false;
        while (!z && i < this.c.size()) {
            Object obj = (String) this.c.get(i);
            z2 = obj.startsWith("-");
            if (z2) {
                obj = obj.substring(1);
            }
            i++;
            z = set.contains(obj);
        }
        return z2 ? !z : z;
    }

    public final boolean validateVersion(PackageManager packageManager) {
        if (this.e == null) {
            return true;
        }
        if (this.f <= 0 && this.g <= 0) {
            return true;
        }
        int a = a(packageManager, this.e);
        return a >= this.f && (this.g == -1 || a < this.g);
    }
}
