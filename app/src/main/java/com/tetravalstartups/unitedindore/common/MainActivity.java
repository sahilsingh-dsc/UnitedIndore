package com.tetravalstartups.unitedindore.common;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tetravalstartups.unitedindore.R;
import com.tetravalstartups.unitedindore.common.notification.NotificationActivity;
import com.tetravalstartups.unitedindore.explore.ExploreFragment;
import com.tetravalstartups.unitedindore.home.HomeFragment;
import com.tetravalstartups.unitedindore.profile.ProfileFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private BottomNavigationView navFooter;
    private TextView tvMenuTitle;
    private ImageView ivNotification, ivChangeLang;
    private SharedPreferences preferences;
    private ListView listLang;
    private ArrayAdapter langArrayAdapter;
    private String[] LANG = {"English", "हिन्दी"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        navFooter = findViewById(R.id.navFooter);
        navFooter.setOnNavigationItemSelectedListener(this);

        tvMenuTitle = findViewById(R.id.tvMenuTitle);
        navFooter.setSelectedItemId(R.id.footer_menu_home);
        tvMenuTitle.setText("Home");

        ivNotification = findViewById(R.id.ivNotification);
        ivNotification.setOnClickListener(this);

        ivChangeLang = findViewById(R.id.ivChangeLang);
        ivChangeLang.setOnClickListener(this);

        preferences = getSharedPreferences("lang", 0);

        langArrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, LANG);
        String lang = preferences.getString("lang", "Select Language");
        if (lang.equals("Select Language")){
            openLangDialog();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.footer_menu_home:
                fragment = new HomeFragment();
                tvMenuTitle.setText("Home");
                break;

            case R.id.footer_menu_explore:
                fragment = new ExploreFragment();
                tvMenuTitle.setText("Explore");
                break;

            case R.id.footer_menu_profile:
                fragment = new ProfileFragment();
                tvMenuTitle.setText("Account");
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
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        }
        if (v == ivChangeLang){
            openLangDialog();
        }
    }

    private void openLangDialog() {
        LayoutInflater factory = LayoutInflater.from(MainActivity.this);
        final View langDialogView = factory.inflate(R.layout.lang_changer_dialog, null);
        final AlertDialog langDialog = new AlertDialog.Builder(MainActivity.this).create();
        langDialog.setView(langDialogView);
        listLang = langDialogView.findViewById(R.id.listLang);
        listLang.setAdapter(langArrayAdapter);
        listLang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected_lang = parent.getItemAtPosition(position).toString();
                SharedPreferences.Editor LangEditor = preferences.edit();
                LangEditor.putString("lang", selected_lang);
                LangEditor.apply();
                updatePrefDealLang();
                langDialog.dismiss();
            }
        });
        langDialog.show();
    }

    public void updatePrefDealLang() {
        String lang = preferences.getString("lang", "Select Language");
        if (lang.equals("English")){
            Toast.makeText(this, ""+lang, Toast.LENGTH_SHORT).show();
            Locale locale = new Locale("en", "US");
            Locale.setDefault(locale);
            Configuration configuration = getResources().getConfiguration();
            configuration.setLocale(locale);
            createConfigurationContext(configuration);
        }
        if (lang.equals("हिन्दी")){
            Toast.makeText(this, ""+lang, Toast.LENGTH_SHORT).show();
            Locale locale = new Locale("hi", "IN");
            Locale.setDefault(locale);
            Configuration configuration = getResources().getConfiguration();
            configuration.setLocale(locale);
            createConfigurationContext(configuration);
        }
    }



}
