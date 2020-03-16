package com.example.swiperefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout s;
    TextView t1;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         s= findViewById(R.id.swipe);
         t1=findViewById(R.id.textView);

         t1.setText("TextView = 0");
        s.setOnRefreshListener(new  SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                number=number+1;
                t1.setText("Text View = "+number);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        s.setRefreshing(false);
                    }
                },3000);
            }
        });
    }
}
