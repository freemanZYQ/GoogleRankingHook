package vpn;

import android.content.Context;

import net.luna.common.debug.LunaLog;

import vpn.manager.VpnManager;
import vpn.manager.VpnProfile;
import vpn.util.ProfileLoader;


public class VpnController {
    private ProfileLoader mLoader;
    private Context context;
    private VpnProfile mProfile;

    private static VpnController mInstance;

    public static VpnController getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VpnController(context);
        }
        return mInstance;
    }

    private VpnController(Context context) {
        this.context = context;
        mLoader = ProfileLoader.getInstance(context);

    }

    public void setProfile(String server, String userName, String password, String dns1, String dns2, boolean mppe) {
        mProfile = new VpnProfile();
        mProfile.server = server;
        mProfile.username = userName;
        mProfile.password = password;
        mProfile.dns1 = dns1;
        mProfile.dns2 = dns2;
        mProfile.mppe = mppe;
    }

    public void stopVpn() {
        LunaLog.d("尝试终端VPN");
        VpnManager.stopVpn();
    }

    public boolean startVpn() {

        return mProfile != null && VpnManager.startVpn(mProfile);

    }


}
