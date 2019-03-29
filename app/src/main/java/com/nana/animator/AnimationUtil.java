package com.nana.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * ProjectName: WYHalove
 * PackageName: com.halove.wydoctor.messageflow.util
 * Description: 视频问诊-信息流布局动画
 * <p>
 * CreateTime: 2018/12/17 16:30
 * Modifier: yangnana
 * ModifyTime: 2018/12/17 16:30
 * Comment:
 *
 * @author yangnana
 */
public class AnimationUtil {

    public static void translate(final View view,
                                 float fromYValue,
                                 final float toYValue) {

        if(fromYValue==toYValue){
            return;
        }
        Animation slide = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, toYValue-fromYValue);

        slide.setDuration(1000);
        slide.setFillAfter(true);
        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /*不加clearAnimation，会出现闪屏，且clearAnimation必须在layout之前执行，否则无效*/
                view.clearAnimation();
                /*重置view的实际显示位置，否则移动之后获取的位置坐标还是未移动之前的*/
                int left = view.getLeft();
                int width = view.getWidth();
                int height = view.getHeight();
                // int top=view.getTop();
                view.layout(left, (int)toYValue, left+width, (int)toYValue+height);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(slide);
    }

    public static void objectTranslate(final View view,
                                       float fromYValue,
                                       final float toYValue) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", fromYValue, toYValue);
        animator.setDuration(200);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.clearAnimation();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }
}
