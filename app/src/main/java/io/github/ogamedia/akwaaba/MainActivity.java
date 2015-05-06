package io.github.ogamedia.akwaaba;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends ActionBarActivity implements MaterialTabListener {
    private String[] mIntents;
    DrawerFragment mdrawerFragment;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    public ActionBarDrawerToggle mDrawerToggle;
    private CharSequence DrawerTitle;
    private CharSequence Title;

    private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDrawerItems();
        initializeToggleItems(); /* related to toggle actions */


    }

    private void initializeToggleItems() {
        Title = DrawerTitle = getTitle();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(Title);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(DrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void initializeDrawerItems() {
        mIntents = getResources().getStringArray(R.array.activities_array);
        mdrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_drawer, mIntents));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {

    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }


    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            goToAction(position);
        }
    }

    private void goToAction(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                 fragment = new CultureFragment();
                break;
            case 1:
                fragment = new PeopleFragment();
                break;
            case 2:
                fragment = new LanguageFragment();
                break;
            case 3:
                fragment = new PlacesFragment();
                break;
            case 4:
                fragment = new DirectoryFragment();
                break;
            case 5:
                fragment = new AboutFragment();
                break;
        }
        if (fragment != null) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.slide_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);

            setTitle(mIntents[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            Log.e("Main Activity", "Error in creating fragment");
        }
    }

//    toggling actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void setTitle(CharSequence title) {
        Title = title;
        getSupportActionBar().setTitle(Title);
    }
}
