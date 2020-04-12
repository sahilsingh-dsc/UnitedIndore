package com.tetravalstartups.unitedindore.merchant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tetravalstartups.unitedindore.R;
import com.tetravalstartups.unitedindore.common.notification.NotificationActivity;
import com.tetravalstartups.unitedindore.merchant.admin.AdminFragment;
import com.tetravalstartups.unitedindore.merchant.customer.CustomerFragment;
import com.tetravalstartups.unitedindore.merchant.dashboard.DashboardFragment;
import com.tetravalstartups.unitedindore.merchant.ledger.LedgerFragment;
import com.tetravalstartups.unitedindore.merchant.post.PostFragment;

public class BusinessMainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private BottomNavigationView navFooter;
    private TextView tvMenuTitle;
    private ImageView ivNotification, ivChangeLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_main);
        init();
    }

    private void init() {
        navFooter = findViewById(R.id.navFooter);
        navFooter.setOnNavigationItemSelectedListener(this);

        tvMenuTitle = findViewById(R.id.tvMenuTitle);
        navFooter.setSelectedItemId(R.id.f_m_dashboard);
        tvMenuTitle.setText("Dashboard");

        ivNotification = findViewById(R.id.ivNotification);
        ivNotification.setOnClickListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.f_m_dashboard:
                fragment = new DashboardFragment();
                tvMenuTitle.setText("Dashboard");
                break;

            case R.id.f_m_customer:
                fragment = new CustomerFragment();
                tvMenuTitle.setText("Customer");
                break;

            case R.id.f_m_post:
                fragment = new PostFragment();
                tvMenuTitle.setText("Post");
                break;

            case R.id.f_m_ledger:
                fragment = new LedgerFragment();
                tvMenuTitle.setText("Ledger");
                break;

            case R.id.f_m_admin:
                fragment = new AdminFragment();
                tvMenuTitle.setText("Admin");
                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContent, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v == ivNotification){
            startActivity(new Intent(BusinessMainActivity.this, NotificationActivity.class));
        }
    }
}