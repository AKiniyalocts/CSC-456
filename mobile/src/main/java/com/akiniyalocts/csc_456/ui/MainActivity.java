package com.akiniyalocts.csc_456.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.akiniyalocts.commons.activities.ToolbarActivity;
import com.akiniyalocts.csc_456.R;

import butterknife.Bind;

public class MainActivity extends ToolbarActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.main_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public Toolbar getToolBar() {
        return mToolbar;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDrawer();
    }

    private void initDrawer(){

        setupHomeSupportActionBar(getString(R.string.app_name));
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.app_name, R.string.app_name
        );

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_adventure:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,ListFragment.newInstance(ListFragment.TYPE_ADVENTURES))
                        .commit();
                safeSetSupportActionBarTitle(R.string.adventures);
                break;

            case R.id.nav_chapters:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, ListFragment.newInstance(ListFragment.TYPE_CHAPTERS))
                        .commit();
                safeSetSupportActionBarTitle(R.string.chapters);
                break;

            case R.id.nav_badges:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, ListFragment.newInstance(ListFragment.TYPE_BADGES))
                        .commit();
                safeSetSupportActionBarTitle(R.string.badges);

                break;
        }
        mDrawerLayout.closeDrawers();

        return false;
    }

    private void safeSetSupportActionBarTitle(@NonNull int resId){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(resId);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
