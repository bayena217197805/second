package com.example.githupfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
    private TextView textView;
    boolean b=false;
    int counter2;
    Thread counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.buttone2);
        textView=findViewById(R.id.textview);



    }
    public void startCount(View view) {
        counter=new Thread(()->{
            try {


                while (true) {
                    counter2++;
                    textView.setText(counter2 + "");
                    Thread.sleep(1000);


                }


            }catch(Exception e){
            }
        });
        counter.start();
    }
    public void stopcount(View view){
        counter.interrupt();
    }

}