package com.example.hozoor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class in_class extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem tabItem;
    TabItem tabitem2;
    ViewPager viewPager;
    page_adapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       toolbar =(Toolbar)findViewById(R.id.toolbar);
       tabLayout=findViewById(R.id.tablayout);
        tabItem = findViewById(R.id.tab_1);
        tabitem2 = findViewById(R.id.tab_2);
        viewPager = findViewById(R.id.view_pager);
        pageAdapter=new page_adapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}
