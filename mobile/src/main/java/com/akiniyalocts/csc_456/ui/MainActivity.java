package com.akiniyalocts.csc_456.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.akiniyalocts.commons.activities.ToolbarActivity;
import com.akiniyalocts.csc_456.R;
import com.akiniyalocts.csc_456.model.pojos.Badge;
import com.akiniyalocts.csc_456.ui.adapters.BaseAdapter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

public class MainActivity extends ToolbarActivity implements NavigationView.OnNavigationItemSelectedListener, BaseAdapter.OnItemClickListener<Badge>{

    private final static String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.main_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    @Bind(R.id.drawer_header_image)
    ImageView mHeaderImage;

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
        Picasso.with(this)
                .load(R.drawable.drawer_header_bg)
                .fit()
                .centerCrop()
                .into(mHeaderImage);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.nav_overview:
                getSupportFragmentManager().beginTransaction()
                        .disallowAddToBackStack()
                        .replace(R.id.fragment_container, OverviewFragment.newInstance())
                        .commit();
                safeSetSupportActionBarTitle(R.string.overview);
                break;

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

            case R.id.nav_github:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.project_github_url)));
                startActivity(intent);
                break;
        }
        mDrawerLayout.closeDrawers();

        return false;
    }

    @Override
    public void onItemClick(Badge item, View parentView) {
        Intent intent = new Intent(this, BadgeDetailActivity.class);
        intent.putExtra(BadgeDetailActivity.BADGE_KEY, item.getId());

        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,

                // Now we provide a list of Pair items which contain the view we can transitioning
                // from, and the name of the view it is transitioning to, in the launched activity
                new Pair<View, String>(parentView.findViewById(R.id.badge_glyph),
                        BadgeDetailActivity.BADGE_GLYPH_VIEW_KEY),
                new Pair<View, String>(parentView.findViewById(R.id.badge_title),
                        BadgeDetailActivity.BADGE_TITLE_VIEW_KEY));

        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());

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
