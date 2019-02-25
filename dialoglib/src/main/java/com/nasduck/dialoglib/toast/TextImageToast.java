package com.nasduck.dialoglib.toast;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nasduck.dialoglib.base.BaseToast;
import com.nasduck.dialoglib.base.ConfigName;
import com.nasduck.dialoglib.R;
import com.nasduck.dialoglib.config.ToastTextAndImageConfig;
import com.nasduck.dialoglib.config.ToastTextConfig;

public class TextImageToast extends BaseToast {

    private LinearLayout mLayoutBackground;
    private ImageView mIvImage;
    private TextView mTvContent;

    private ToastTextAndImageConfig mConfig;

    public TextImageToast(){

    }

    public static TextImageToast create(ToastTextAndImageConfig config){
        TextImageToast fragment = new TextImageToast();
        Bundle args = new Bundle();
        args.putParcelable("textAndImageToastConfig", config);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mConfig = getArguments().getParcelable("textAndImageToastConfig");
        }
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.toast_text_image;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mLayoutBackground = view.findViewById(R.id.background);
        mIvImage = view.findViewById(R.id.iv_image);
        mTvContent = view.findViewById(R.id.tv_content);

        updateUI(this.mConfig);
    }

    public void updateUI(ToastTextAndImageConfig config) {
        // Corner Radius && Background Color
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(config.getCornerRadius());
        drawable.setColor(mContext.getResources().getColor(config.getBackgroundColor()));
        mLayoutBackground.setBackground(drawable);

        // Text
        mTvContent.setText(config.getText());

        // Text Size
        mTvContent.setTextSize(config.getTextSize());

        // Text Color
        mTvContent.setTextColor(getResources().getColor(config.getTextColor()));

        // Image
        mIvImage.setImageResource(config.getImage());

        // Image Animation
        if (config.getAnim() != 0) {
            Animation animation = AnimationUtils.loadAnimation(mContext, config.getAnim());
            mIvImage.setAnimation(animation);
        }

        // Padding
        mLayoutBackground.setPadding(config.getPaddingHorizontal(), config.getPaddingVertical(),
                config.getPaddingHorizontal(), config.getPaddingVertical());
    }
}
