package com.nitjsr.urja1920.Utilities;

import android.view.animation.BounceInterpolator;

interface BounceViewAnim {
    BounceViewAnim setScaleForPushInAnim(float scaleX, float scaleY);

    BounceViewAnim setScaleForPopOutAnim(float scaleX, float scaleY);

    BounceViewAnim setPushInAnimDuration(int timeInMillis);

    BounceViewAnim setPopOutAnimDuration(int timeInMillis);

    BounceViewAnim setInterpolatorPushIn(BounceInterpolator interpolatorPushIn);

    BounceViewAnim setInterpolatorPopOut(BounceInterpolator interpolatorPopOut);

}
