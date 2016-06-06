package com.ps.youku;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView iv_home;
	private ImageView iv_menu;
	private RelativeLayout level1, level2, level3;

	private boolean isShowlevel2 = true;
	private boolean isShowlevel3 = true;

	private boolean isShowMenu = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initListener();
	}

	private void initView() {

		iv_home = (ImageView) findViewById(R.id.iv_home);
		iv_menu = (ImageView) findViewById(R.id.iv_menu);
		level1 = (RelativeLayout) findViewById(R.id.level1);
		level2 = (RelativeLayout) findViewById(R.id.level2);
		level3 = (RelativeLayout) findViewById(R.id.level3);

	}

	private void initListener() {

		iv_home.setOnClickListener(this);
		iv_menu.setOnClickListener(this);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_MENU) {

			if (isShowMenu) {
				// 需要关闭所有菜单
				int startOffse = 0;
				if (isShowlevel3) {
					AnimUtil.closeMenu(level3, startOffse);
					isShowlevel3 = false;
					startOffse += 200;
				}
				if (isShowlevel2) {
					AnimUtil.closeMenu(level2, startOffse);
					isShowlevel2 = false;
					startOffse += 200;
				}
				AnimUtil.closeMenu(level1, startOffse);

			} else {
				// 需要显示所有菜单
				AnimUtil.showMenu(level1, 0);
				AnimUtil.showMenu(level2, 200);
				isShowlevel2 = true;
				AnimUtil.showMenu(level3, 400);
				isShowlevel3 = true;
			}
			isShowMenu = !isShowMenu;
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.iv_home:
			if (AnimUtil.animaCount != 0) {
				// 说明有动画在执行
				return;
			}
			if (isShowlevel2) {
				// 隐藏菜单
				int startOffset = 0;
				if (isShowlevel3) {

					AnimUtil.closeMenu(level3, startOffset);
					isShowlevel3 = false;
					startOffset += 200;
				}
				AnimUtil.closeMenu(level2, startOffset);
			} else {
				// 显示2级菜单
				AnimUtil.showMenu(level2, 0);
			}
			isShowlevel2 = !isShowlevel2;
			break;

		case R.id.iv_menu:
			if (AnimUtil.animaCount != 0) {
				return;
			}
			if (isShowlevel3) {
				// 隐藏3级菜单
				AnimUtil.closeMenu(level3, 0);
			} else {
				// 显示3级菜单
				AnimUtil.showMenu(level3, 0);
			}
			isShowlevel3 = !isShowlevel3;
			break;
		default:
			break;
		}
	}
}
