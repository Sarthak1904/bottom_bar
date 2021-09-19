package com.example.bottom_bar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    private MeowBottomNavigation bottomNavigationBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = findViewById(R.id.bnv_Main);
        bottomNavigationBar.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bottomNavigationBar.add(new MeowBottomNavigation.Model(2,R.drawable.search));
        bottomNavigationBar.add(new MeowBottomNavigation.Model(3,R.drawable.notification));
        bottomNavigationBar.add(new MeowBottomNavigation.Model(4,R.drawable.book));
        bottomNavigationBar.add(new MeowBottomNavigation.Model(5,R.drawable.person));

        bottomNavigationBar.show(1,true);
        replace(new HomeFragment());
        bottomNavigationBar.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new HomeFragment());
                        break;

                    case 2:
                        replace(new SearchFragment());
                        break;

                    case 3:
                        replace(new NotificationFragment());
                        break;

                    case 4:
                        replace(new WishlistFragment());
                        break;

                    case 5:
                        replace((new ProfileFragment()));
                        break;

                }
                return null;
            }
        });




    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}