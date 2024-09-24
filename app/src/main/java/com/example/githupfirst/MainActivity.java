package com.example.githupfirst;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;
    private TextView textView, textView2, textView3, textView4;
    boolean b = false;
    int counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0;
    Thread counter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.buttone2);
        textView = findViewById(R.id.textview);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);
        textView4 = findViewById(R.id.textview4);
    }

    public void startCount(View view) {
        counter = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    counter5++;
                    runOnUiThread(() -> textView4.setText(counter5 + ""));
                    Thread.sleep(1000);

                    if (counter5 == 9) {
                        counter4++;
                        runOnUiThread(() -> {
                            textView3.setText(counter4 + "");
                            counter5 = 0;
                        });
                    }

                    if (counter4 == 6) {
                        counter3++;
                        runOnUiThread(() -> {
                            counter4 = 0;
                            textView2.setText(counter3 + "");
                            textView3.setText(counter4 + "");
                        });
                    }

                    if (counter3 == 10) {
                        counter2++;
                        runOnUiThread(() -> {
                            counter3 = 0;
                            textView.setText(counter2 + "");
                            textView2.setText(counter3 + "");
                        });
                    }
                }
            } catch (InterruptedException e) {
                // Handle interruption
            }
        });
        counter.start();
    }

    public void stopcount(View view) {
        if (counter != null) {
            counter.interrupt();
        }
    }

    public void reset2(View view) {
        counter5 = 0;
        counter4 = 0;
        counter3 = 0;
        counter2 = 0;
        runOnUiThread(() -> {
            textView.setText("0");
            textView2.setText("0");
            textView3.setText("0");
            textView4.setText("0");
        });
        if (counter != null) {
            counter.interrupt();
        }
    }
}
