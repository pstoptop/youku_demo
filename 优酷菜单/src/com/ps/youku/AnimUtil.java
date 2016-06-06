package com.ps.youku;

import android.sax.StartElementListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimUtil {

	public static int animaCount = 0; // 记录当前执行的动画数量

	public static void closeMenu(RelativeLayout rl, int startOffse) {
		for (int i = 0; i < rl.getChildCount(); i++) {
			rl.getChildAt(i).setEnabled(false);

		}
		RotateAnimation animation = new RotateAnimation(0, -180,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 1);

		animation.setDuration(500);
		animation.setFillAfter(true);
		animation.setStartOffset(startOffse);

		animation.setAnimationListener(new MyAnimationListener());

		rl.startAnimation(animation);

	}

	public static void showMenu(RelativeLayout rl, int startOffse) {
		for (int i = 0; i < rl.getChildCount(); i++) {
			rl.getChildAt(i).setEnabled(true);
		}
		RotateAnimation animation = new RotateAnimation(-180, 0,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 1);

		animation.setDuration(500);
		animation.setFillAfter(true);
		animation.setStartOffset(startOffse);
		
		animation.setAnimationListener(new MyAnimationListener());

		rl.startAnimation(animation);
	}

	static class MyAnimationListener implements AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			animaCount++;
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			animaCount--;
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub

		}

	}
}
