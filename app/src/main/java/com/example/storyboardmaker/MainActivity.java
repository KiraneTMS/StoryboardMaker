package com.example.storyboardmaker;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.storyboardmaker.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    ImageButton editProfiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, binding.drawer, toolbar, R.string.open, R.string.close);
        binding.drawer.addDrawerListener(toggle);
        toggle.syncState();
        editProfiles = findViewById(R.id.editProfile);
//        editProfiles.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment = null;
//                fragment = new ProfilesFragment();
//                loadFragment(fragment);
//            }
//        });
        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();
                Fragment fragment = null;
                switch (id){
                    case R.id.search:
                        fragment = new SearchFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.stories:
                        fragment = new StoriesFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.scenes:
                        fragment = new ScenesFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.characters:
                        fragment = new CharactersFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.setting:
                        fragment = new SettingFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.support:
                        fragment = new SupportFragment();
                        loadFragment(fragment);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment).commit();
        binding.drawer.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}