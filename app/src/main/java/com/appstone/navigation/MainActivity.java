package com.appstone.navigation;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private FragmentTransaction fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tl_main);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        TextView toolbarTitle = findViewById(R.id.toolbar_title);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        toolbarTitle.setText("Navigation");
        toolbarTitle.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null));

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerToggle.syncState();


//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_home:
//                        Toast.makeText(MainActivity.this, "home is clicked", Toast.LENGTH_LONG).show();
//                        break;
//                }
//                return false;
//            }
//        });

        navigationView.setNavigationItemSelectedListener(this);


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.action_menu) {
//            drawerLayout.openDrawer(GravityCompat.END);
//        }
//        return true;
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        fm = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.action_home:

                startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                break;

            case R.id.action_search:
//                Intent intent =new Intent(FromActivity, DestinationActivity);
//                startActivity();

                Bundle args = new Bundle();
                args.putString("TITLE", "Search Fragment");


                SearchFragment searchFragment = new SearchFragment();
                searchFragment.setArguments(args);

                fm.replace(R.id.fragment_holder, searchFragment).commit();
                break;

            case R.id.action_logout:

                Bundle args1 = new Bundle();
                args1.putString("TITLE", "Logout Fragment");


                LogoutFragment logoutFragment = new LogoutFragment();
                logoutFragment.setArguments(args1);
                fm.replace(R.id.fragment_holder, logoutFragment).commit();
                break;
        }
        return false;
    }
}