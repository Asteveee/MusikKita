package com.example.musikkita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnv_musik_kita;
    private FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        bnv_musik_kita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_musik:
                        bukaFragment(new MusikFragment());
                        getSupportActionBar().setTitle("Musik");
                        return true;
                    case R.id.menu_album:
                        bukaFragment(new MusikFragment());
                        getSupportActionBar().setTitle("Album");
                        return true;

                    case R.id.menu_artis:
                        bukaFragment(new MusikFragment());
                        getSupportActionBar().setTitle("Artis");
                        return true;
                }
                return false;
            }
        });
    }
        private void initView()
    {
            bnv_musik_kita = findViewById(R.id.bnv_musik_kita);
            flContainer = findViewById(R.id.fl_container);

        bukaFragment(new MusikFragment());
        getSupportActionBar().setTitle("Musik");

        bukaFragment(new MusikFragment());
        getSupportActionBar().setTitle("Album");

        bukaFragment(new MusikFragment());
        getSupportActionBar().setTitle("Artis");
    }

    private void bukaFragment(Fragment frm)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_container, frm);
        ft.commit();
    }
}