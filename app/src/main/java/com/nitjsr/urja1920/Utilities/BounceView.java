package com.nitjsr.urja1920.Utilities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;

import java.lang.ref.WeakReference;

public class BounceView implements BounceViewAnim {

    public static final float PUSH_IN_SCALE_X = 0.9f;
    public static final float PUSH_IN_SCALE_Y = 0.9f;
    public static final float POP_OUT_SCALE_X = 1.1f;
    public static final float POP_OUT_SCALE_Y = 1.1f;
    public static final int PUSH_IN_ANIM_DURATION = 100;
    public static final int POP_OUT_ANIM_DURATION = 100;
    public static final BounceInterpolator DEFAULT_INTERPOLATOR = new BounceInterpolator();

    private WeakReference<View> view;
    private boolean isTouchInsideView = true;
    private float pushInScaleX = PUSH_IN_SCALE_X;
    private float pushInScaleY = PUSH_IN_SCALE_Y;
    private float popOutScaleX = POP_OUT_SCALE_X;
    private float popOutScaleY = POP_OUT_SCALE_Y;
    private int pushInAnimDuration = PUSH_IN_ANIM_DURATION;
    private int popOutAnimDuration = POP_OUT_ANIM_DURATION;
    private BounceInterpolator pushInInterpolator = DEFAULT_INTERPOLATOR;
    private BounceInterpolator popOutInterpolator = DEFAULT_INTERPOLATOR;

    private BounceView(View view) {
        this.view = new WeakReference<View>(view);
    }

    public static BounceView addAnimTo(View view) {
        BounceView bounceAnim = new BounceView(view);
        bounceAnim.setAnimToView();
        return bounceAnim;
    }

    @Override
    public BounceViewAnim setScaleForPushInAnim(float scaleX, float scaleY) {
        this.pushInScaleX = scaleX;
        this.pushInScaleY = scaleY;
        return this;
    }

    @Override
    public BounceViewAnim setScaleForPopOutAnim(float scaleX, float scaleY) {
        this.popOutScaleX = scaleX;
        this.popOutScaleY = scaleY;
        return this;
    }

    @Override
    public BounceViewAnim setPushInAnimDuration(int timeInMillis) {
        this.pushInAnimDuration = timeInMillis;
        return this;
    }

    @Override
    public BounceViewAnim setPopOutAnimDuration(int timeInMillis) {
        this.popOutAnimDuration = timeInMillis;
        return this;
    }

    @Override
    public BounceViewAnim setInterpolatorPushIn(BounceInterpolator interpolatorPushIn) {
        this.pushInInterpolator = interpolatorPushIn;
        return this;
    }

    @Override
    public BounceViewAnim setInterpolatorPopOut(BounceInterpolator interpolatorPopOut) {
        this.popOutInterpolator = interpolatorPopOut;
        return this;
    }

    private void setAnimToView() {
        if (view != null) {
            view.get().setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(final View v, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == MotionEvent.ACTION_DOWN) {
                        isTouchInsideView = true;
                        startAnimScale(v, pushInScaleX, pushInScaleY, pushInAnimDuration, pushInInterpolator, 0);
                        startAnimScale(v, popOutScaleX, popOutScaleY, popOutAnimDuration, popOutInterpolator, pushInAnimDuration);
                        startAnimScale(v, 1f, 1f, popOutAnimDuration, popOutInterpolator, popOutAnimDuration + pushInAnimDuration);
                    }
                    return false;
                }
            });
        }
    }

    private void startAnimScale(View view, float scaleX, float scaleY,
                                int animDuration,
                                BounceInterpolator interpolator,
                                int startDelay) {
        ObjectAnimator animX = ObjectAnimator.ofFloat(view, "scaleX", scaleX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(view, "scaleY", scaleY);
        AnimatorSet animatorSet = new AnimatorSet();
        animX.setDuration(animDuration);
        animX.setInterpolator(interpolator);
        animY.setDuration(animDuration);
        animY.setInterpolator(interpolator);

        animatorSet.playTogether(animX, animY);
        animatorSet.setStartDelay(startDelay);
        animatorSet.start();
    }


}