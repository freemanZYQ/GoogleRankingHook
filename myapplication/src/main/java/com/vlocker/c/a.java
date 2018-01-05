package com.vlocker.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.vlocker.b.i;
import com.vlocker.m.ae;
import com.vlocker.m.ao;
import org.json.JSONArray;

public class a {
    private static a d = null;
    private String a;
    private SharedPreferences b;
    private SharedPreferences c;

    private a(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new String("launcher.preferences.newvlockerlock");
        this.b = context.getSharedPreferences(this.a, a());
        this.c = context.getSharedPreferences("launcher.preferences.almostnexus", a());
    }

    private String S(String str) {
        Object a = ae.a(Integer.toString(str.hashCode()) + str);
        return TextUtils.isEmpty(a) ? Integer.toString(str.hashCode()) : a;
    }

    public static int a() {
        try {
            if (VERSION.SDK_INT >= 14) {
                return 4;
            }
        } catch (NumberFormatException e) {
        } catch (Exception e2) {
        }
        return 0;
    }

    public static a a(Context context) {
        if (d == null) {
            d = new a(context);
        }
        return d;
    }

    private SharedPreferences ds() {
        return this.b;
    }

    public String A() {
        return a("FEEDBACK_CONTACT_FOR_CN", "");
    }

    public void A(int i) {
        b("red_packet_2_minute", i);
    }

    public void A(String str) {
        b("locker_camera_activityname", str);
    }

    public void A(boolean z) {
        b("locker_screen_style", z);
    }

    public String B() {
        return a("location_city_code", null);
    }

    public void B(int i) {
        b("red_packet_voice_select", i);
    }

    public void B(String str) {
        b("locker_camera_title", str);
    }

    public void B(boolean z) {
        b("music_show_on_lock", z);
    }

    public String C() {
        return a("location_city_name", null);
    }

    public void C(int i) {
        b("red_packet_count", i);
    }

    public void C(boolean z) {
        b("has_manul_music_show_on_lock", z);
    }

    public boolean C(String str) {
        return be().contains(str);
    }

    public String D() {
        return a("location_addr_name", null);
    }

    public void D(int i) {
        b("red_packet_success_count", i);
    }

    public void D(String str) {
        b("red_packet_float_web_jason", str);
    }

    public void D(boolean z) {
        b("use_theme_from_local", z);
    }

    public String E() {
        return a("location_province_code", "");
    }

    public void E(int i) {
        b("qq_red_packet_success_count", i);
    }

    public void E(String str) {
        b("splash_screen_string", str);
    }

    public void E(boolean z) {
        b("use_theme_over_finish", z);
    }

    public String F() {
        return a("location_district_name", "");
    }

    public String F(String str) {
        return a("weather_temp", str);
    }

    public void F(int i) {
        b("qq_red_packet_count", i);
    }

    public void F(boolean z) {
        b("locker_music_play_enable", z);
    }

    public void G(int i) {
        b("red_packet_share_close_num", i);
    }

    public void G(String str) {
        b("weather_temp", str);
    }

    public void G(boolean z) {
        b("locker_emergency_key_enable", z);
    }

    public boolean G() {
        String a = a("location_country_code", null);
        return a == null || a.length() == 0 || a.equals("null");
    }

    public String H(String str) {
        return a("weather_text", str);
    }

    public void H(int i) {
        b("red_packet_float_web_day", i);
    }

    public void H(boolean z) {
        b("locker_shake_when_unlock_error_enable", z);
    }

    public boolean H() {
        String B = B();
        return B == null || B.length() == 0 || B.equals("null");
    }

    public void I(int i) {
        b("red_packet_float_web_hour", i);
    }

    public void I(String str) {
        b("weather_text", str);
    }

    public void I(boolean z) {
        b("locker_toolbox_closed", z);
    }

    public boolean I() {
        return a("location_use_auto", false);
    }

    public void J() {
        b("location_latitude", -1);
        b("location_longitude", -1);
        b("last_location_update_time", 0);
    }

    public void J(int i) {
        b("red_packet_last_day", i);
    }

    public void J(String str) {
        b("battery_clean_ad_data", str);
    }

    public void J(boolean z) {
        b("locker_camera_closed", z);
    }

    public long K(int i) {
        return i == 1 ? a("battry_charge_time_remaining_ac", 0) : i == 2 ? a("battry_charge_time_remaining_usb", 0) : i == 4 ? a("battry_charge_time_remaining_wifi", 0) : 0;
    }

    public Double K() {
        return Double.valueOf(Double.longBitsToDouble(a("location_latitude", -1)));
    }

    public void K(String str) {
        b("icon_post_resid", str);
    }

    public void K(boolean z) {
        b("notify_show_enabled", z);
    }

    public int L(int i) {
        return a("weather_icon_tag", i);
    }

    public Double L() {
        return Double.valueOf(Double.longBitsToDouble(a("location_longitude", -1)));
    }

    public void L(String str) {
        b("weather_alarm_text", str);
    }

    public void L(boolean z) {
        b("is_ever_en_show_noti", z);
    }

    public long M() {
        return a("cm_first_install_time", 0);
    }

    public void M(int i) {
        b("weather_icon_tag", i);
    }

    public void M(String str) {
        b("weather_news_target", str);
    }

    public void M(boolean z) {
        b("notify_hidden_private_enabled", z);
    }

    public int N() {
        return a("AppVerCode_current", 0);
    }

    public long N(int i) {
        return i == 1 ? a("battry_charge_level_remaining_ac", 0) : i == 2 ? a("battry_charge_level_remaining_usb", 0) : i == 4 ? a("battry_charge_level_remaining_wifi", 0) : 0;
    }

    public void N(String str) {
        b("weather_news_push_rule", str);
    }

    public void N(boolean z) {
        b("click_close_sys_lock", z);
    }

    public void O(int i) {
        b("splash_show_day", i);
    }

    public void O(String str) {
        b("select_sarry_name", str);
    }

    public void O(boolean z) {
        b("locker_message_show", z);
    }

    public boolean O() {
        return a("vlockerlauncherthemelock", true);
    }

    public void P(int i) {
        b("splash_show_count", i);
    }

    public void P(String str) {
        b("vlocker_msg_count", str);
    }

    public void P(boolean z) {
        b("locker_message_se", z);
    }

    public boolean P() {
        return a("vlockerlauncherthemevoice", true);
    }

    public void Q(int i) {
        b("battery_charge_complete_count", i);
    }

    public void Q(String str) {
        b("unlock_text_custom_content", str);
    }

    public void Q(boolean z) {
        b("locker_blur_bg_value", z);
    }

    public boolean Q() {
        return a("vlockerlocktype", 0) == 1;
    }

    public void R(int i) {
        b("battery_charge_complete_last_day", i);
    }

    public void R(String str) {
        b("unlock_text_custom_font", str);
    }

    public void R(boolean z) {
        b("locker_blur_bg_haschanged", z);
    }

    public boolean R() {
        return a("hidevlockerlocktype", false);
    }

    public void S(int i) {
        b("battery_clean_show_count", i);
    }

    public void S(boolean z) {
        b("lokcer_camera_selected_hasclick", z);
    }

    public boolean S() {
        return a("locknumenable", false);
    }

    public String T() {
        return a("vlockerpatternlockkey", "");
    }

    public void T(int i) {
        b("battery_clean_msg_show_count", i);
    }

    public void T(boolean z) {
        b("locker_msg_all_select", z);
    }

    public String U() {
        return a("vlockernumlockkey", "nothing");
    }

    public void U(int i) {
        b("battery_clean_last_day", i);
    }

    public void U(boolean z) {
        b("locker_notifi_selected_has_click", z);
    }

    public void V(int i) {
        b("repair_msg_check_day", i);
    }

    public void V(boolean z) {
        b("locker_music_lrc_show", z);
    }

    public boolean V() {
        return a("firstcamertip", false);
    }

    public void W(int i) {
        b("icon_delete_time", i);
    }

    public void W(boolean z) {
        b("locker_screen_style_first_open", z);
    }

    public boolean W() {
        return a("locker_show_weather", true);
    }

    public void X() {
        b("cover_weather_setting_dialog_showed", true);
    }

    public void X(int i) {
        b("has_set_hint_number_pwd", i);
    }

    public void X(boolean z) {
        b("locker_screen_style_first_close", z);
    }

    public void Y(int i) {
        b("battery_clean_low_power_last_day", i);
    }

    public void Y(boolean z) {
        b("locker_isfirst_onekey", z);
    }

    public boolean Y() {
        return a("cover_weather_setting_dialog_showed", false);
    }

    public void Z() {
        b("cover_locate_first_man", true);
    }

    public void Z(int i) {
        b("battery_clean_high_memory_last_day", i);
    }

    public void Z(boolean z) {
        b("one_key_setting_first", z);
    }

    public int a(String str, int i) {
        return ds().getInt(str, i);
    }

    public long a(String str, long j) {
        return ds().getLong(str, j);
    }

    public String a(String str, String str2) {
        return ds().getString(str, str2);
    }

    public void a(int i) {
        b("msg_request_ad_frequency", i);
    }

    public void a(int i, long j) {
        if (i == 1) {
            b("battry_charge_time_remaining_ac", j);
        } else if (i == 2) {
            b("battry_charge_time_remaining_usb", j);
        } else if (i == 4) {
            b("battry_charge_time_remaining_wifi", j);
        }
    }

    public void a(long j) {
        b("msg_request_ad_time", j);
    }

    public void a(Context context, Long l) {
        b("setuploadservice", l.longValue());
    }

    public void a(Double d) {
        b("location_latitude", Double.doubleToLongBits(d.doubleValue()));
    }

    public void a(String str) {
        b("latest_push_msg", str);
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray.length() >= 3) {
            b("theme_mobile_1", jSONArray.optString(0));
            b("theme_mobile_2", jSONArray.optString(1));
            b("theme_mobile_3", jSONArray.optString(2));
        }
    }

    public void a(boolean z) {
        b("is_first_in_setting", z);
    }

    public boolean a(String str, boolean z) {
        return ds().getBoolean(str, z);
    }

    public String aA() {
        return a("imei", "");
    }

    public void aA(boolean z) {
        b("click_tools_and_camera", z);
    }

    public void aB(boolean z) {
        b("click_message", z);
    }

    public boolean aB() {
        return a("notify_show_enabled", true);
    }

    public void aC(boolean z) {
        b("fingprint_enable", z);
        if (z) {
            aQ(true);
        }
    }

    public boolean aC() {
        return a("is_ever_en_show_noti", false);
    }

    public void aD(boolean z) {
        b("fingprint_support", z);
    }

    public boolean aD() {
        return a("notify_hidden_private_enabled", false);
    }

    public void aE() {
        b("msg_light_app_pkg_name", "");
    }

    public void aE(boolean z) {
        b("first_show_theme_detail", z);
    }

    public String aF() {
        return a("msg_light_app_pkg_name", "").trim();
    }

    public void aF(boolean z) {
        b("first_click_theme_btn", z);
    }

    public String aG() {
        return a("msg_app_pkg_name", "").trim();
    }

    public void aG(boolean z) {
        b("need_hint_number_pwd", z);
    }

    public void aH(boolean z) {
        b("custome_pwd_unlock_success", z);
    }

    public boolean aH() {
        return a("is_import_msgpkg", false);
    }

    public void aI() {
        b("is_import_msgpkg", true);
    }

    public void aI(boolean z) {
        b("is_pull_to_search", z);
    }

    public String aJ() {
        return a("phone_cm_name", "");
    }

    public void aJ(boolean z) {
        b("first_request_weather", z);
    }

    public void aK(boolean z) {
        b("ip_location", z);
    }

    public boolean aK() {
        return a("show_guide", false);
    }

    public void aL() {
        b("show_guide", true);
    }

    public void aL(boolean z) {
        b("update_show_force_dialog", z);
    }

    public int aM() {
        return a("locker_question_id", -1);
    }

    public void aM(boolean z) {
        b("update_show_force2_dialog", z);
    }

    public int aN() {
        return a("locker_question_month", -1);
    }

    public void aN(boolean z) {
        b("update_first_on_setting", z);
    }

    public int aO() {
        return a("locker_question_day", -1);
    }

    public void aO(boolean z) {
        b("weather_news_switch", z);
    }

    public String aP() {
        return a("locker_question_answer", "");
    }

    public void aP(boolean z) {
        b("is_guide_fingerprint", z);
    }

    public String aQ() {
        return a("locker_question_myquestion", "");
    }

    public void aQ(boolean z) {
        b("is_vivo_enroll", z);
    }

    public void aR(boolean z) {
        b("is_first_open_fingerprint_swticher", z);
    }

    public boolean aR() {
        return a("click_close_sys_lock", false);
    }

    public void aS(boolean z) {
        b("is_boot_start", z);
    }

    public boolean aS() {
        return a("locker_message_show", false);
    }

    public int aT() {
        return a("locker_system_screenofftime", 0);
    }

    public void aT(boolean z) {
        b("vlocker_has_remove_cover", z);
    }

    public int aU() {
        return a("locker_message_time_1_hour", 23);
    }

    public void aU(boolean z) {
        b("unlock_text_is_custom", z);
    }

    public int aV() {
        return a("locker_message_time_1_minute", 0);
    }

    public void aV(boolean z) {
        b("unlock_text_has_set_color", z);
    }

    public int aW() {
        return a("locker_message_time_2_hour", 7);
    }

    public void aW(boolean z) {
        b("unlock_text_edit_has_open", z);
    }

    public int aX() {
        return a("locker_message_time_2_minute", 0);
    }

    public boolean aY() {
        return a("locker_message_se", false);
    }

    public boolean aZ() {
        return a("locker_blur_bg_value", true);
    }

    public void aa(int i) {
        b("theme_isPrompt_identify", i);
    }

    public void aa(boolean z) {
        b("one_key_setting_first_finish", z);
    }

    public boolean aa() {
        return a("cover_locate_first_man", false);
    }

    public void ab(int i) {
        b("screen_on_times", i);
    }

    public void ab(boolean z) {
        b("red_packet_isopen", z);
    }

    public boolean ab() {
        return a("weather_dot_icon_guide_flag", false);
    }

    public void ac(int i) {
        b("is_show_pull_search_text", i);
    }

    public void ac(boolean z) {
        b("red_packet_voice_prompt", z);
    }

    public boolean ac() {
        return a("weather_first_update_ing", false);
    }

    public String ad() {
        return a("cover_wall_papaer_path", null);
    }

    public void ad(int i) {
        b("vlocker_screen_on_count", i);
    }

    public void ad(boolean z) {
        b("red_packet_vibrate_prompt", z);
    }

    public int ae() {
        return a("cover_wall_papaer_type2", 0);
    }

    public void ae(int i) {
        b("vlocker_screen_on_lastday", i);
    }

    public void ae(boolean z) {
        b("red_packet_hasclick", z);
    }

    public int af() {
        return a("cover_wall_papaer_type3", 0);
    }

    public void af(int i) {
        b("vlocker_msg_max_count", i);
    }

    public void af(boolean z) {
        b("red_packet_switch_click_status", z);
    }

    public void ag(int i) {
        b("post_msg_count_data_time", i);
    }

    public void ag(boolean z) {
        b("red_packet_msg_has_send", z);
    }

    public boolean ag() {
        return a("cover_wallpaper_update_path", false);
    }

    public void ah(int i) {
        b("delete_weather_icon_count", i);
    }

    public void ah(boolean z) {
        b("red_packet_chang_off_time", z);
    }

    public boolean ah() {
        return a("cover_wallpaper_theme_type_lock", false);
    }

    public int ai() {
        return a("lockhideStatusbar", 0);
    }

    public void ai(int i) {
        b("delete_weather_icon_date", i);
    }

    public void ai(boolean z) {
        b("system_off_time_has_chang", z);
    }

    public int aj() {
        return a("lockdragStatusbar", 0);
    }

    public void aj(int i) {
        b("unlock_text_custom_color", i);
    }

    public void aj(boolean z) {
        b("red_packet_dialog_has_show", z);
    }

    public void ak(int i) {
        b("unlock_text_edit_hint_count", i);
    }

    public void ak(boolean z) {
        b("red_packet_float_notice_switch", z);
    }

    public boolean ak() {
        return a("batteryPercentageStatusbar", false);
    }

    public void al(boolean z) {
        b("red_packet_float_invite_switch", z);
    }

    public boolean al() {
        return a("locker_setting_has_runned", false);
    }

    public void am(boolean z) {
        b("red_packet_has_share_this_day", z);
    }

    public boolean am() {
        return a("locker_tool_box_has_clicked", false);
    }

    public int an() {
        return a("locker_time_key_enable", 0);
    }

    public void an(boolean z) {
        b("onekey_first_set", z);
    }

    public void ao(boolean z) {
        b("red_packet_setting_out_switch", z);
    }

    public boolean ao() {
        return a("locker_screen_style", false);
    }

    public void ap(boolean z) {
        b("red_packet_float_setting_in_switch", z);
    }

    public boolean ap() {
        return a("music_show_on_lock", true);
    }

    public void aq(boolean z) {
        b("locker_notification_permission_msg_tip", z);
    }

    public boolean aq() {
        return a("has_manul_music_show_on_lock", false);
    }

    public void ar(boolean z) {
        b("locker_notification_permission_msg_switch", z);
    }

    public boolean ar() {
        return a("locker_music_play_enable", false);
    }

    public void as(boolean z) {
        b("share_theme_text_status", z);
    }

    public boolean as() {
        return a("use_theme_from_local", false);
    }

    public boolean at() {
        return a("locker_emergency_key_enable", false);
    }

    public boolean at(boolean z) {
        return a("weather_synch", z);
    }

    public void au(boolean z) {
        b("weather_synch", z);
    }

    public boolean au() {
        return a("locker_shake_when_unlock_error_enable", true);
    }

    public void av(boolean z) {
        b("battery_charge_switch", z);
    }

    public boolean av() {
        return a("locker_toolbox_closed", true);
    }

    public void aw(boolean z) {
        b("battery_charge_cloud_switch", z);
    }

    public boolean aw() {
        return a("locker_camera_closed", true);
    }

    public long ax() {
        return a("firstintolauncher", 0);
    }

    public void ax(boolean z) {
        b("locker_show_cover", z);
    }

    public int ay() {
        return a("moble_screen_width", 320);
    }

    public void ay(boolean z) {
        b("click_setting", z);
    }

    public int az() {
        return a("moble_display_width", 0);
    }

    public void az(boolean z) {
        b("show_pwd_hint", z);
    }

    public Long b(Context context) {
        return Long.valueOf(a("setuploadservice", 0));
    }

    public void b(int i) {
        b("lockthemecolor", i);
    }

    public void b(int i, long j) {
        if (i == 1) {
            b("battry_charge_level_remaining_ac", j);
        } else if (i == 2) {
            b("battry_charge_level_remaining_usb", j);
        } else if (i == 4) {
            b("battry_charge_level_remaining_wifi", j);
        }
    }

    public void b(long j) {
        b("screen_on_no_push_msg_time", j);
    }

    public void b(Double d) {
        b("location_longitude", Double.doubleToLongBits(d.doubleValue()));
    }

    public void b(String str) {
        b("latest_push_msg_pkg_name", str);
    }

    public void b(String str, int i) {
        Editor edit = ds().edit();
        edit.putInt(str, i);
        ao.a(edit);
    }

    public void b(String str, long j) {
        Editor edit = ds().edit();
        edit.putLong(str, j);
        ao.a(edit);
    }

    public void b(String str, String str2) {
        Editor edit = ds().edit();
        edit.putString(str, str2);
        ao.a(edit);
    }

    public void b(String str, boolean z) {
        Editor edit = ds().edit();
        edit.putBoolean(str, z);
        ao.a(edit);
    }

    public void b(boolean z) {
        b("is_first_in_password", z);
    }

    public boolean b() {
        return a("is_first_in_setting", false);
    }

    public boolean bA() {
        return a("red_packet_switch_click_status", false);
    }

    public int bB() {
        return a("red_packet_count", 0);
    }

    public int bC() {
        return a("red_packet_success_count", 0);
    }

    public int bD() {
        return a("qq_red_packet_success_count", 0);
    }

    public int bE() {
        return a("qq_red_packet_count", 0);
    }

    public long bF() {
        return a("red_packet_last_send_time", 0);
    }

    public boolean bG() {
        return a("red_packet_msg_has_send", false);
    }

    public boolean bH() {
        return a("system_off_time_has_chang", false);
    }

    public boolean bI() {
        return a("red_packet_dialog_has_show", false);
    }

    public int bJ() {
        return a("red_packet_share_close_num", 0);
    }

    public boolean bK() {
        return a("red_packet_float_notice_switch", false);
    }

    public boolean bL() {
        return a("red_packet_float_invite_switch", false);
    }

    public String bM() {
        return a("red_packet_float_web_jason", null);
    }

    public int bN() {
        return a("red_packet_float_web_day", -1);
    }

    public int bO() {
        return a("red_packet_last_day", 0);
    }

    public boolean bP() {
        return a("red_packet_has_share_this_day", false);
    }

    public boolean bQ() {
        return a("onekey_first_set", true);
    }

    public boolean bR() {
        return a("red_packet_setting_out_switch", false);
    }

    public boolean bS() {
        return a("red_packet_float_setting_in_switch", false);
    }

    public boolean bT() {
        return a("locker_notification_permission_msg_tip", false);
    }

    public boolean bU() {
        return a("locker_notification_permission_msg_switch", false);
    }

    public boolean bV() {
        return a("share_theme_text_status", false);
    }

    public boolean bW() {
        return Q() || S();
    }

    public boolean bX() {
        return a("battery_charge_switch", true);
    }

    public boolean bY() {
        return a("battery_charge_cloud_switch", true);
    }

    public long bZ() {
        return a("battery_charge_oneday_time", 0);
    }

    public boolean ba() {
        return a("locker_blur_bg_haschanged", false);
    }

    public String bb() {
        return a("locker_camera_packagename", "");
    }

    public String bc() {
        return a("locker_camera_activityname", "");
    }

    public String bd() {
        return a("locker_camera_title", "");
    }

    public String be() {
        return a("locker_toolbox_app_info", "");
    }

    public void bf() {
        b("locker_toolbox_app_info", "");
    }

    public boolean bg() {
        return a("lokcer_camera_selected_hasclick", false);
    }

    public boolean bh() {
        return a("locker_msg_all_select", false);
    }

    public boolean bi() {
        return a("locker_notifi_selected_has_click", false);
    }

    public boolean bj() {
        return a("locker_music_lrc_always_light", false);
    }

    public int bk() {
        return a("locker_to_today", -1);
    }

    public boolean bl() {
        return a("locker_music_lrc_hasclick", false);
    }

    public boolean bm() {
        return a("locker_screen_style_first_open", false);
    }

    public boolean bn() {
        return a("locker_isfirst_onekey", true);
    }

    public boolean bo() {
        return a("locker_screen_style_first_close", false);
    }

    public boolean bp() {
        return a("one_key_setting_first", true);
    }

    public boolean bq() {
        return a("one_key_setting_first_finish", true);
    }

    public int br() {
        return a("red_packet_time_1_hour", 0);
    }

    public int bs() {
        return a("red_packet_time_1_minute", 0);
    }

    public int bt() {
        return a("red_packet_time_2_hour", 7);
    }

    public int bu() {
        return a("red_packet_2_minute", 0);
    }

    public boolean bv() {
        return a("red_packet_isopen", false);
    }

    public boolean bw() {
        return a("red_packet_voice_prompt", true);
    }

    public boolean bx() {
        return a("red_packet_vibrate_prompt", true);
    }

    public int by() {
        return a("red_packet_voice_select", 0);
    }

    public boolean bz() {
        return a("red_packet_hasclick", false);
    }

    public void c(int i) {
        b("lockthemecoloralpa", i);
    }

    public void c(long j) {
        b("CrashFeedbackInterval", j);
    }

    public void c(String str) {
        b("drawable_level", str);
    }

    public void c(String str, boolean z) {
        String trim = str.trim();
        String aG = aG();
        boolean contains = aG.contains(trim);
        if (z) {
            if (!contains) {
                b("msg_app_pkg_name", (aG + "|" + trim).trim());
            }
        } else if (contains) {
            b("msg_app_pkg_name", aG.replace("|" + trim, "").trim());
        }
    }

    public void c(boolean z) {
        b("lockerthemeplugbg", z);
    }

    public boolean c() {
        return a("is_first_in_password", true);
    }

    public int cA() {
        return a("has_set_hint_number_pwd", -1);
    }

    public int cB() {
        return a("battery_clean_low_power_last_day", 0);
    }

    public int cC() {
        return a("battery_clean_high_memory_last_day", 0);
    }

    public long cD() {
        return a("post_active_data_time", 0);
    }

    public int cE() {
        return a("theme_isPrompt_identify", -1);
    }

    public boolean cF() {
        return a("custome_pwd_unlock_success", false);
    }

    public boolean cG() {
        return a("is_pull_to_search", false);
    }

    public int cH() {
        return a("screen_on_times", -1);
    }

    public int cI() {
        return a("is_show_pull_search_text", 0);
    }

    public boolean cJ() {
        return a("is_pull_search_enabled", false);
    }

    public boolean cK() {
        return a("ip_location", false);
    }

    public boolean cL() {
        return a("first_request_weather", true);
    }

    public long cM() {
        return a("first_requst_weather_time", 0);
    }

    public String cN() {
        return a("weather_alarm_text", "");
    }

    public int cO() {
        return a("vlocker_screen_on_count", 0);
    }

    public int cP() {
        return a("vlocker_screen_on_lastday", 0);
    }

    public String cQ() {
        return a("weather_news_target", "");
    }

    public String cR() {
        return a("weather_news_push_rule", "10:0:1");
    }

    public String cS() {
        return a("select_sarry_name", null);
    }

    public boolean cT() {
        return a("update_show_force_dialog", false);
    }

    public boolean cU() {
        return a("update_show_force2_dialog", false);
    }

    public long cV() {
        return a("update_show_force_dialog_last_time", 0);
    }

    public boolean cW() {
        return a("update_first_on_setting", true);
    }

    public boolean cX() {
        return a("weather_news_switch", true);
    }

    public long cY() {
        return a("request_net_service_time", 0);
    }

    public boolean cZ() {
        return a("is_guide_fingerprint", false);
    }

    public long ca() {
        return a("battery_charge_last_show_time", 0);
    }

    public boolean cb() {
        return a("locker_show_cover", false);
    }

    public boolean cc() {
        return a("click_setting", false);
    }

    public boolean cd() {
        return a("show_pwd_hint", true);
    }

    public boolean ce() {
        return a("click_tools_and_camera", false);
    }

    public boolean cf() {
        return a("click_message", false);
    }

    public boolean cg() {
        return a("fingprint_enable", false);
    }

    public boolean ch() {
        return a("fingprint_support", false);
    }

    public boolean ci() {
        return a("first_show_theme_detail", true);
    }

    public boolean cj() {
        return a("first_click_theme_btn", true);
    }

    public void ck() {
        b("clicked_launcher_entry", true);
    }

    public boolean cl() {
        return a("clicked_launcher_entry", false);
    }

    public int cm() {
        return a("splash_show_day", 0);
    }

    public int cn() {
        return a("splash_show_count", 0);
    }

    public String co() {
        return a("battery_clean_ad_data", "");
    }

    public int cp() {
        return a("battery_charge_complete_count", 0);
    }

    public int cq() {
        return a("battery_charge_complete_last_day", 0);
    }

    public int cr() {
        return a("battery_clean_show_count", 0);
    }

    public int cs() {
        return a("battery_clean_msg_show_count", 0);
    }

    public int ct() {
        return a("battery_clean_last_day", 0);
    }

    public long cu() {
        return a("repair_msg_tip", 0);
    }

    public int cv() {
        return a("repair_msg_check_day", -1);
    }

    public long cw() {
        return a("icon_close_time", 0);
    }

    public int cx() {
        return a("icon_delete_time", 0);
    }

    public String cy() {
        return a("icon_post_resid", "");
    }

    public boolean cz() {
        return a("need_hint_number_pwd", false);
    }

    public int d() {
        return a("msg_request_ad_frequency", 0);
    }

    public long d(long j) {
        return a("last_location_update_time", j);
    }

    public void d(int i) {
        b("vlocker_color", i);
    }

    public void d(String str) {
        b("current_theme_path", str);
    }

    public void d(String str, boolean z) {
        String trim = str.trim();
        String aF = aF();
        boolean contains = aF.contains(trim);
        if (z) {
            if (!contains) {
                b("msg_light_app_pkg_name", (aF + "|" + trim).trim());
            }
        } else if (contains) {
            b("msg_light_app_pkg_name", aF.replace("|" + trim, "").trim());
        }
    }

    public void d(boolean z) {
        b("is_apply_widget_theme", z);
    }

    public boolean da() {
        return a("is_vivo_enroll", false);
    }

    public long db() {
        return a("last_finger_verify_time", 0);
    }

    public boolean dc() {
        return a("is_first_open_fingerprint_swticher", true);
    }

    public boolean dd() {
        return a("is_boot_start", false);
    }

    public boolean de() {
        return a("vlocker_has_remove_cover", false);
    }

    public String df() {
        return a("vlocker_msg_count", "");
    }

    public int dg() {
        return a("vlocker_msg_max_count", 0);
    }

    public int dh() {
        return a("post_msg_count_data_time", 0);
    }

    public void di() {
        String a = a("theme_mobile_1", "");
        if (a.length() > 1) {
            i.a(a, 0);
        }
        a = a("theme_mobile_2", "");
        if (a.length() > 1) {
            i.a(a, 1);
        }
        a = a("theme_mobile_3", "");
        if (a.length() > 1) {
            i.a(a, 2);
        }
    }

    public int dj() {
        return a("delete_weather_icon_count", 0);
    }

    public int dk() {
        return a("delete_weather_icon_date", 0);
    }

    public boolean dl() {
        return a("unlock_text_is_custom", false);
    }

    public String dm() {
        return a("unlock_text_custom_content", "");
    }

    public int dn() {
        return a("unlock_text_custom_color", -1);
    }

    public boolean do() {
        return a("unlock_text_has_set_color", false);
    }

    public String dp() {
        return a("unlock_text_custom_font", "");
    }

    public int dq() {
        return a("unlock_text_edit_hint_count", 0);
    }

    public boolean dr() {
        return a("unlock_text_edit_has_open", false);
    }

    public long e() {
        return a("msg_request_ad_time", 0);
    }

    public void e(int i) {
        b("widget_versoncode", i);
    }

    public void e(long j) {
        b("last_location_update_time", j);
    }

    public void e(String str) {
        b("theme_package", str);
    }

    public void e(String str, boolean z) {
        String trim = str.trim();
        String be = be();
        boolean contains = be.contains(trim);
        if (z) {
            if (!contains) {
                b("locker_toolbox_app_info", (be + "|" + trim).trim());
            }
        } else if (contains) {
            b("locker_toolbox_app_info", be.replace("|" + trim, "").trim());
        }
    }

    public void e(boolean z) {
        b("is_restart_vlocker", z);
    }

    public long f(long j) {
        return a("last_weather_update_time", j);
    }

    public String f() {
        return a("latest_push_msg", "");
    }

    public void f(int i) {
        b("AppVerCode_current", i);
    }

    public void f(String str) {
        b("locker_theme_color_keys", str);
    }

    public void f(boolean z) {
        b("is_restart_from_launcher", z);
    }

    public String g() {
        return a("latest_push_msg_pkg_name", "");
    }

    public void g(int i) {
        b("AppVerCode_previous", i);
    }

    public void g(long j) {
        b("last_weather_update_time", j);
    }

    public void g(String str) {
        b("FEEDBACK_CONTACT_FOR_CN", str);
    }

    public void g(boolean z) {
        b("is_restart_from_theme", z);
    }

    public long h() {
        return a("screen_on_no_push_msg_time", 0);
    }

    public void h(int i) {
        b("cover_wall_papaer_type2", i);
    }

    public void h(long j) {
        b("cm_first_install_time", j);
    }

    public void h(String str) {
        b("location_city_code", str);
    }

    public void h(boolean z) {
        b("locker_theme_color_selectall", z);
    }

    public void i(int i) {
        b("cover_wall_papaer_type3", i);
    }

    public void i(long j) {
        b("cm_first_download_time", j);
    }

    public void i(String str) {
        b("location_city_name", str);
    }

    public void i(boolean z) {
        b("is_password_from_setting", z);
    }

    public boolean i() {
        return a("lockerthemeplugbg", true);
    }

    public int j() {
        return a("lockthemecolor", -1);
    }

    public void j(int i) {
        b("lockhideStatusbar", i);
    }

    public void j(long j) {
        long a = a("recent_crash_time_one", 0);
        long a2 = a("recent_crash_time_two", 0);
        long a3 = a("recent_crash_time_three", 0);
        if (a <= a2 && a <= a3) {
            b("recent_crash_time_one", j);
        } else if (a2 > a || a2 > a3) {
            b("recent_crash_time_three", j);
        } else {
            b("recent_crash_time_two", j);
        }
    }

    public void j(String str) {
        b("location_addr_name", str);
    }

    public void j(boolean z) {
        b("one_key_setting_finished", z);
    }

    public int k() {
        return a("lockthemecoloralpa", 255);
    }

    public void k(int i) {
        b("lockdragStatusbar", i);
    }

    public void k(long j) {
        b("red_packet_last_send_time", j);
    }

    public void k(String str) {
        b("location_province_code", str);
    }

    public void k(boolean z) {
        b("location_use_auto", z);
    }

    public int l() {
        return a("vlocker_color", 0);
    }

    public void l(int i) {
        b("locker_time_key_enable", i);
    }

    public void l(long j) {
        b("battery_charge_oneday_time", j);
    }

    public void l(String str) {
        b("location_district_name", str);
    }

    public void l(boolean z) {
        b("location_auto_failed", z);
    }

    public String m() {
        return a("drawable_level", null);
    }

    public void m(int i) {
        b("moble_screen_width", i);
    }

    public void m(long j) {
        b("battery_charge_last_show_time", j);
    }

    public void m(String str) {
        b("location_country_code", str);
    }

    public void m(boolean z) {
        b("vlockerlauncherthemelock", z);
    }

    public String n() {
        return a("current_theme_path", null);
    }

    public void n(int i) {
        b("moble_display_width", i);
    }

    public void n(long j) {
        b("repair_msg_tip", j);
    }

    public void n(boolean z) {
        b("vlockerlauncherthemevoice", z);
    }

    public boolean n(String str) {
        return a("mrfp_" + S(str), true);
    }

    public String o() {
        return a("theme_package", null);
    }

    public void o(int i) {
        b("locker_question_id", i);
    }

    public void o(long j) {
        b("icon_close_time", j);
    }

    public void o(String str) {
        b("mrfp_" + S(str), false);
    }

    public void o(boolean z) {
        if (z) {
            b("vlockerlocktype", 1);
        } else {
            b("vlockerlocktype", 0);
        }
    }

    public void p(int i) {
        b("locker_question_month", i);
    }

    public void p(long j) {
        b("post_active_data_time", j);
    }

    public void p(String str) {
        b("vlockernumlockkey", str);
    }

    public void p(boolean z) {
        b("hidevlockerlocktype", z);
    }

    public boolean p() {
        return a("is_apply_widget_theme", false);
    }

    public void q(int i) {
        b("locker_question_day", i);
    }

    public void q(long j) {
        b("first_requst_weather_time", j);
    }

    public void q(String str) {
        b("cover_wall_papaer_path", str);
    }

    public void q(boolean z) {
        b("locknumenable", z);
    }

    public boolean q() {
        return a("is_restart_vlocker", false);
    }

    public void r(int i) {
        b("locker_system_screenofftime", i);
    }

    public void r(long j) {
        b("update_show_force_dialog_last_time", j);
    }

    public void r(String str) {
        b("imei", str);
    }

    public void r(boolean z) {
        b("firstcamertip", z);
    }

    public boolean r() {
        return a("is_restart_from_launcher", false);
    }

    public void s(int i) {
        b("locker_message_time_1_hour", i);
    }

    public void s(long j) {
        b("request_net_service_time", j);
    }

    public void s(boolean z) {
        b("locker_show_weather", z);
    }

    public boolean s() {
        return a("is_restart_from_theme", false);
    }

    public boolean s(String str) {
        return aF().contains(str);
    }

    public String t() {
        return a("locker_theme_color_keys", "111111111");
    }

    public void t(int i) {
        b("locker_message_time_1_minute", i);
    }

    public void t(long j) {
        b("last_finger_verify_time", j);
    }

    public void t(boolean z) {
        b("weather_dot_icon_guide_flag", z);
    }

    public boolean t(String str) {
        return aG().contains(str);
    }

    public void u(int i) {
        b("locker_message_time_2_hour", i);
    }

    public void u(String str) {
        b("phone_cm_name", str);
    }

    public void u(boolean z) {
        b("weather_first_update_ing", z);
    }

    public boolean u() {
        return a("locker_theme_color_selectall", true);
    }

    public void v(int i) {
        b("locker_message_time_2_minute", i);
    }

    public void v(String str) {
        b("sms_cm_name", str);
    }

    public void v(boolean z) {
        b("cover_wallpaper_update_path", z);
    }

    public boolean v() {
        return aM() != -1;
    }

    public void w(int i) {
        b("locker_to_today", i);
    }

    public void w(String str) {
        b("locker_question_answer", str);
    }

    public void w(boolean z) {
        b("cover_wallpaper_theme_type_lock", z);
    }

    public boolean w() {
        return a("is_password_from_setting", false);
    }

    public void x(int i) {
        b("red_packet_time_1_hour", i);
    }

    public void x(String str) {
        b("locker_question_myquestion", str);
    }

    public void x(boolean z) {
        b("batteryPercentageStatusbar", z);
    }

    public boolean x() {
        boolean a = a("isFirstInstall", true);
        if (a) {
            b("isFirstInstall", false);
        }
        return a;
    }

    public void y(int i) {
        b("red_packet_time_1_minute", i);
    }

    public void y(String str) {
        b("locker_weather_dianshang", str);
    }

    public void y(boolean z) {
        b("locker_setting_has_runned", z);
    }

    public boolean y() {
        return a("one_key_setting_finished", false);
    }

    public long z() {
        return a("CrashFeedbackInterval", 0);
    }

    public void z(int i) {
        b("red_packet_time_2_hour", i);
    }

    public void z(String str) {
        b("locker_camera_packagename", str);
    }

    public void z(boolean z) {
        b("locker_tool_box_has_clicked", z);
    }
}
