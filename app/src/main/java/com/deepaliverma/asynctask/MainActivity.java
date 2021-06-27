package com.deepaliverma.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    LinearLayout linearLayout;
    Button button;
    ListView listView;
    String[] items=new String[]{
            "Alpha",
            "Beta",
            "Gamma",
            "Delta",
            "Curo",
            "Phi",
            "Strata",
            "Humo"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.clLayout);
        button=findViewById(R.id.button);
        listView=findViewById(R.id.lv);

        ArrayAdapter<String> itemAdapter=new ArrayAdapter<>(
            this,
                    android.R.layout.simple_list_item_1,
            android.R.id.text1,
            items
        );

       listView.setAdapter(itemAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*waitNsec(10);
                linearLayout.setBackgroundColor(Color.RED);
                Log.d(TAG,"onClick:"+System.currentTimeMillis());*/
                Handler h= new Handler(); //using Async Task here
                Runnable r= new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"Run: we have waited 5 minutes");
                        linearLayout.setBackgroundColor(Color.RED);
                    }
                };
                h.postDelayed(r,5000);
            }
        });

    }

    void wait1sec(){
        long startTime=System.currentTimeMillis();
        while(System.currentTimeMillis()<startTime+1000);
    }

    void waitNsec(int n){
        for(int i=0;i<n;i++){
            wait1sec();
        }
    }
}