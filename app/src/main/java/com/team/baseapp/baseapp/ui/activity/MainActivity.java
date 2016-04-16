package com.team.baseapp.baseapp.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.team.baseapp.baseapp.R;
import com.team.baseapp.baseapp.ui.adapter.BottomBarAdapter;
import com.team.baseapp.baseapp.ui.base.BaseActivity;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mBottomBar;

    private BottomBarAdapter mBottomBarAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewWithId();
        initViewPager();
        initBottomBar();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }

    private void findViewWithId() {
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        mBottomBar = (TabLayout) findViewById(R.id.bottom_bar);
    }

    /**
     * init viewpager
     */
    private void initViewPager() {

    }

    /**
     * 初始化底部bar
     */
    private void initBottomBar() {
        initBottomBarAdapter();
        mBottomBar.setupWithViewPager(mViewPager);
        initTabsCustomView();
    }

    private void initBottomBarAdapter() {
        mBottomBarAdapter = new BottomBarAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mBottomBarAdapter);
    }

    //自定义bottom bar tab view
    private void initTabsCustomView() {
        for (int i = 0; i < mBottomBar.getTabCount(); i++) {
            TabLayout.Tab tab = mBottomBar.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(mBottomBarAdapter.getCustomTabView(i));
            }
        }
        //默认显示首页
        mViewPager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
