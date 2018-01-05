package com.vlocker.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;

public class V2BannerPage extends RelativeLayout {
    public V2BannerPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBtnText(int i) {
        Button button = (Button) findViewById(R.id.banner_local_click_btn);
        if (button != null) {
            button.setText(i);
        }
    }

    public void setBtnText(String str) {
        Button button = (Button) findViewById(R.id.banner_local_click_btn);
        if (button != null) {
            button.setText(str);
        }
    }

    public void setCenterImg(int i) {
        ImageView imageView = (ImageView) findViewById(R.id.banner_local_center_img);
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setDescription(int i) {
        TextView textView = (TextView) findViewById(R.id.banner_local_des_tip);
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setDescription(String str) {
        TextView textView = (TextView) findViewById(R.id.banner_local_des_tip);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
