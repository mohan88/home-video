package com.hobby.homevideo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hobby.homevideo.R;
import com.hobby.homevideo.fragment.CategoryFragment;
import com.hobby.homevideo.fragment.HomeFragment;
import com.hobby.homevideo.presenter.PresenterFactory;
import com.hobby.homevideo.presenter.PresenterInitializer;
import com.hobby.homevideo.presenter.initializer.PresenterInitializerImpl;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new PresenterInitializerImpl().initializePresenters(PresenterFactory.getInstance());
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction().replace(R.id.activity_parent, new HomeFragment()).addToBackStack("home").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.category1) {
            final CategoryFragment categoryFragmentOne = CategoryFragment.newInstance("category1.json");
            getFragmentManager().beginTransaction().replace(R.id.activity_parent, categoryFragmentOne).addToBackStack("category1").commit();
            return true;
        }
        if (id == R.id.category2) {
            final CategoryFragment categoryFragmentTwo = CategoryFragment.newInstance("category2.json");
            getFragmentManager().beginTransaction().replace(R.id.activity_parent, categoryFragmentTwo).addToBackStack("category2").commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
