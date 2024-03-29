package com.example.bazaruno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class More_Option extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more__option);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // work for recycel view to set and send data
        recyclerView=(RecyclerView) findViewById(R.id.recycleview);
        Set_Data();

        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        bottomNavigationView.getMenu().getItem(1).setCheckable(false);
        bottomNavigationView.getMenu().getItem(2).setCheckable(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(More_Option.this, "I was click", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id=menuItem.getItemId();
        if (id == R.id.search)
        {
            Intent intent=new Intent(getApplicationContext(),Search_Activity.class);
            startActivity(intent);
        }
        else if (id == R.id.compare)
        {
            Intent intent=new Intent(getApplicationContext(),Compare_Activity.class);
            startActivity(intent);
        }
        else if(id == R.id.favorites)
        {
            Intent intent=new Intent(getApplicationContext(),Favorites.class);
            startActivity(intent);
        }
        else if (id == R.id.more)
        {
            Intent intent=new Intent(getApplicationContext(),More_Option.class);
            startActivity(intent);
        }

        return false;
    }


    // this set data for recycleview
    void Set_Data()
    {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> image=new ArrayList<>();

        name.add("My Shop");
        name.add("Notifications");
        name.add("My Product Reivews");
        name.add("Payment");
        name.add("Account Settings");

        image.add(R.drawable.m_shop_icon);
        image.add(R.drawable.m_notification_icon);
        image.add(R.drawable.m_review_icon);
        image.add(R.drawable.m_payment_icon);
        image.add(R.drawable.m_account_icon);

        recyclerView.setHasFixedSize(true);
        More_Recycleview adapter=new More_Recycleview(this,name,image);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


    }
}
