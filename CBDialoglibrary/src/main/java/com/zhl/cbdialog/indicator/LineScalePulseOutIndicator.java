package com.zhl.cbdialog.indicator;

import android.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class LineScalePulseOutIndicator extends LineScaleIndicator {

    @Override
    public void createAnimation() {
        long[] delays=new long[]{500,250,0,250,500};
        for (int i = 0; i < 5; i++) {
            final int index=i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.3f,1);
            scaleAnim.setDuration(900);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);
            scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleYFloats[index] = (Float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            scaleAnim.start();
        }
    }

}
