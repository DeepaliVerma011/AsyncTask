package com.deepaliverma.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsyncTaskActivity extends AppCompatActivity {

    private static final String TAG ="TAG" ;
    TextView textView;
    Button  button;
    Button  random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button2);
        random=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountTask ctask= new CountTask();
                //cTask.doInBackground
                ctask.execute(5);
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Random r=new Random();
               textView.setText(String.valueOf(r.nextInt(100)));
            }
        });
    }


    class CountTask extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n=integers[0];
            //waitNsec(n);
            for(int i=0;i<n;i++){
                wait1sec();
         publishProgress();
            }
            Log.d(TAG,"doINBACKGROUND");
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0]);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }
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