package com.nasduck.dialoglib.dialog.composition.header;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nasduck.dialoglib.dialog.config.HeaderConfig;

public class DialogHeader extends FrameLayout {

    private static HeaderConfig mConfig;

    public static DialogHeader create(Context context, HeaderConfig config) {
        mConfig = config;
        return new DialogHeader(context);
    }

    public DialogHeader(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        //this.setBackgroundResource(mConfig.getBgColor());

        TextView tv = new TextView(context);
        tv.setText(mConfig.getTitle());
        tv.setTextSize(mConfig.getTitleTextSize());
        tv.setTextColor(getResources().getColor(mConfig.getTitleColor()));
        tv.setTypeface(Typeface.DEFAULT, mConfig.getTypeface());

        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.gravity = mConfig.getGravity();
        tv.setLayoutParams(lp);

        this.addView(tv);

        // set background
        /**
        float radius = mConfig.getCornerRadius();
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadii(new float[]{DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius), 0, 0, 0, 0});
        drawable.setColor(getResources().getColor(mConfig.getBgColor()));
        layoutBackground.setBackground(drawable);
         **/

        // set text location
        /**
        layoutBackground.setPadding(DensityUtils.dp2px(context, mConfig.getPaddingLeft()),
                DensityUtils.dp2px(context, mConfig.getPaddingTop()),
                DensityUtils.dp2px(context, mConfig.getPaddingRight()),
                DensityUtils.dp2px(context, mConfig.getPaddingBottom()));
         **/

    }
}
