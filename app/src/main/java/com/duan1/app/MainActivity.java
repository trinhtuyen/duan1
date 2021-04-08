package com.duan1.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new Doc_Truyen_Fragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag = null;
            switch (item.getItemId()){
                case R.id.docTruyen:
                    selectedFrag  = new Doc_Truyen_Fragment();
                    break;
                case R.id.yeuThich:
                    selectedFrag  = new Yeu_thich_Fragment();
                    break;
                case R.id.lichSu:
                    selectedFrag  = new Lich_su_Fragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFrag).commit();
            return true ;

        }
    };
}