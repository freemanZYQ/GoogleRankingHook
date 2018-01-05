package net.luna.common.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import net.luna.commom.R;
import net.luna.common.view.button.ButtonFlat;

public class CustomerDialog extends android.app.Dialog {

    Context context;
    View view;
    View backView;
    private View customerView;
    private RelativeLayout contentView;
    private boolean mCanCancel = true;

    LinearLayout bottomLayout;
    ButtonFlat buttonAccept;
    ButtonFlat buttonCancel;

    String buttonCancelText;

    View.OnClickListener onAcceptButtonClickListener;
    View.OnClickListener onCancelButtonClickListener;


    public CustomerDialog(Context context, View customerView) {
        super(context, android.R.style.Theme_Translucent);
        this.context = context;// init Context
        this.customerView = customerView;
    }

    public void addCancelButton(String buttonCancelText) {
        this.buttonCancelText = buttonCancelText;
    }

    public void addCancelButton(String buttonCancelText, View.OnClickListener onCancelButtonClickListener) {
        this.buttonCancelText = buttonCancelText;
        this.onCancelButtonClickListener = onCancelButtonClickListener;
    }

    public void setAcceptButtonVisible(boolean bool) {
        if (bottomLayout != null) {
            if (bool) {
                this.bottomLayout.setVisibility(View.VISIBLE);
            } else {
                this.bottomLayout.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public void setCancelable(boolean flag) {
        mCanCancel = flag;
        super.setCancelable(flag);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerdialog);

        view = (RelativeLayout) findViewById(R.id.contentDialog);
        bottomLayout = (LinearLayout) findViewById(R.id.bottom_layout);
        backView = (RelativeLayout) findViewById(R.id.dialog_rootView);
        backView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getX() < view.getLeft()
                        || event.getX() > view.getRight()
                        || event.getY() > view.getBottom()
                        || event.getY() < view.getTop()) {
                    if (mCanCancel)
                        dismiss();
                }
                return false;
            }
        });
        this.contentView = (RelativeLayout) findViewById(R.id.customer_view);
        if (customerView != null) {
            contentView.addView(customerView, new FrameLayout.LayoutParams(-2, -2));
        }

        this.buttonAccept = (ButtonFlat) findViewById(R.id.button_accept);
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onAcceptButtonClickListener != null)
                    onAcceptButtonClickListener.onClick(v);
            }
        });

        if (buttonCancelText != null) {
            this.buttonCancel = (ButtonFlat) findViewById(R.id.button_cancel);
            this.buttonCancel.setVisibility(View.VISIBLE);
            this.buttonCancel.setText(buttonCancelText);
            buttonCancel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dismiss();
                    if (onCancelButtonClickListener != null)
                        onCancelButtonClickListener.onClick(v);
                }
            });
        }
    }

    @Override
    public void show() {
        // TODO 自动生成的方法存根
        super.show();
        // set dialog enter animations
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.dialog_main_show_amination));
        backView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.dialog_root_show_amin));

        if (buttonAccept.getVisibility() == View.GONE) {
            contentView.setPadding(0, 0, 0, 0);
        }
    }

    // GETERS & SETTERS
    public ButtonFlat getButtonAccept() {
        return buttonAccept;
    }

    public void setButtonAccept(ButtonFlat buttonAccept) {
        this.buttonAccept = buttonAccept;
    }

    public ButtonFlat getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(ButtonFlat buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public void setOnAcceptButtonClickListener(
            View.OnClickListener onAcceptButtonClickListener) {
        this.onAcceptButtonClickListener = onAcceptButtonClickListener;
        if (buttonAccept != null)
            buttonAccept.setOnClickListener(onAcceptButtonClickListener);
    }

    public void setOnCancelButtonClickListener(
            View.OnClickListener onCancelButtonClickListener) {
        this.onCancelButtonClickListener = onCancelButtonClickListener;
        if (buttonCancel != null)
            buttonCancel.setOnClickListener(onCancelButtonClickListener);
    }

    @Override
    public void dismiss() {
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.dialog_main_hide_amination);
        anim.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        CustomerDialog.super.dismiss();
                    }
                });

            }
        });
        Animation backAnim = AnimationUtils.loadAnimation(context, R.anim.dialog_root_hide_amin);

        view.startAnimation(anim);
        backView.startAnimation(backAnim);
    }

}
