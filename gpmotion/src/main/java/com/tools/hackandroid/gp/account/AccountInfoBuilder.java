package com.tools.hackandroid.gp.account;

import android.content.Context;

import net.luna.common.debug.LunaLog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/9/14.
 */
public class AccountInfoBuilder {
    private static final String[] EMAILS = new String[]{"@gmail.com"};

    private static List<String> ffns = new ArrayList<String>();
    private static List<String> mfns = new ArrayList<String>();
    private static List<String> lns = new ArrayList<String>();
    private static List<String> pffns = new ArrayList<String>();
    private static List<String> pmfns = new ArrayList<String>();
    private static List<String> plns = new ArrayList<String>();

    private AccountInfoBuilder() {
    }

    public static RegisterAccount getRegisterAccount(Context context, boolean male) {
        if (ffns.isEmpty() || mfns.isEmpty() || lns.isEmpty()) {
            try {
                loadInfos(context);
            } catch (Exception e) {
                LunaLog.e(e);
                return null;
            }
        }

        String fn = "";
        if (!male) {
            fn = ffns.get((int) (Math.random() * ffns.size()));
        } else {
            fn = mfns.get((int) (Math.random() * mfns.size()));
        }
        String ln = lns.get((int) (Math.random() * lns.size()));

        Haikunator haikunator = new HaikunatorBuilder().setTokenHex(true).setDelimiter("").build();
        String password = haikunator.haikunate();
        String email = haikunator.haikunate() + EMAILS[(int) (Math.random() * EMAILS.length)];
        return new RegisterAccount(fn, ln, password, email, male);
    }

    public static void createGooglePlusName(Context context, RegisterAccount account) {
        if ((account.googlePlusFirstName != null) && (account.googlePlusLastName != null)) {
            return;
        }

        if (pffns.isEmpty() || pmfns.isEmpty() || plns.isEmpty()) {
            try {
                loadInfos(context);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        account.googlePlusLastName = plns.get((int) (Math.random() * plns.size()));
        if (account.male) {
            account.googlePlusFirstName = pmfns.get((int) (Math.random() * pmfns.size()));
        } else {
            account.googlePlusFirstName = pffns.get((int) (Math.random() * pffns.size()));
        }
    }

    private static void loadInfos(Context context) throws Exception {
        ffns.clear();
        mfns.clear();
        lns.clear();
        plns.clear();
        pffns.clear();
        pmfns.clear();

        InputStream is = null;
        is = context.getAssets().open("ffn");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        while ((line = br.readLine()) != null) {
            ffns.add(line);
        }
//        LunaLog.d("ffn数量:" + ffns.size());
        br.close();
        is = context.getAssets().open("mfn");
        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            mfns.add(line);
        }
//        LunaLog.d("mfn数量:" + mfns.size());
        br.close();
        is = context.getAssets().open("ln");
        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            lns.add(line);
        }
//        LunaLog.d("ln数量:" + lns.size());
        br.close();
        is = context.getAssets().open("plus_ln");
        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            plns.add(line);
        }
//        LunaLog.d("plus_ln数量:" + plns.size());
        br.close();
        is = context.getAssets().open("plus_ffn");
        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            pffns.add(line);
        }
//        LunaLog.d("plus_ffn数量:" + pffns.size());
        br.close();
        is = context.getAssets().open("plus_mfn");
        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            pmfns.add(line);
        }
//        LunaLog.d("plus_mfn数量:" + pmfns.size());
        br.close();

        is.close();

    }


}
