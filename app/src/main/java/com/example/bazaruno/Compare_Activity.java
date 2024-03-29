package com.example.bazaruno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Compare_Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        viewPager=(ViewPager) findViewById(R.id.view_pager);
        // function work for recyclerview in activity
        Set_Data();
        ImageView back=(ImageView) findViewById(R.id.backarrow);
        ImageView forward=(ImageView) findViewById(R.id.forword);

       back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (viewPager.getCurrentItem() != 0)
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (viewPager.getCurrentItem() < viewPager.getAdapter().getCount())
             {
                 viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
             }
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Compare_Activity.this, "I was click", Toast.LENGTH_SHORT).show();
            }
        });


        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        bottomNavigationView.getMenu().getItem(2).setCheckable(false);
        bottomNavigationView.getMenu().getItem(3).setCheckable(false);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
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



    // setting data to the recycle view item

    void Set_Data()
    {
        ArrayList<Compare_Data_Container> list=new ArrayList<>();

        Compare_Data_Container compare=new Compare_Data_Container();
        compare.setName("Best quality shirts");
        compare.setImage("https://images-na.ssl-images-amazon.com/images/I/810cdIUimcL._UL1500_.jpg");
        compare.setRating("4.9");
        compare.setPrice("100");
        compare.setType("Clothes");
        compare.setColor("Pink");
        compare.setShop_rating("4.2");
        compare.setSize("Medium");

        Compare_Data_Container compare2=new Compare_Data_Container();
        compare2.setName("Sumsang A-10");
        compare2.setImage("https://images-na.ssl-images-amazon.com/images/I/71qJXXHQWXL._SY550_.jpg");
        compare2.setRating("4.3");
        compare2.setPrice("330");
        compare2.setType("Mobile");
        compare2.setColor("Blue");
        compare2.setShop_rating("3.3");
        compare2.setSize("Larg");

        Compare_Data_Container compare3=new Compare_Data_Container();
        compare3.setName("Top Sport Shirts");
        compare3.setImage("https://mbksports.net/wp-content/uploads/2017/04/pastedImage2.png");
        compare3.setRating("4.1");
        compare3.setPrice("123");
        compare3.setType("T-shirts");
        compare3.setColor("Red");
        compare3.setShop_rating("5.0");
        compare3.setSize("Small");

        list.add(compare);
        list.add(compare2);
        list.add(compare3);

        Compare_RecycleView adapter=new Compare_RecycleView(this,list);
         viewPager.setAdapter(adapter);


    }


}
