package com.konstantin_romashenko.braintraining;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private EditText editTextSave;
    private final String save_key = "save_key";
    private ActionBar actionBar;
    private TextView tvMain, tvRes;
    private int number_1;
    private int number_2;
    private int number_false;
    private int number_res;
    private int number_i;
    private int max = 20;
    private int min = 1;
    private int max1 = 10;
    private int min1 = 1;
    private long startTime = 0;
    private long currentTime = 0;
    private int true_answers = 0;
    private int max_true_answers = 100;
    private float time_result = 0;
    private boolean is_true_answer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        startTime = System.currentTimeMillis();


        pref = getSharedPreferences("test", MODE_PRIVATE);
        tvMain = findViewById(R.id.tvMain);
        tvRes = findViewById(R.id.tvRes);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Hello");
        tvRes.setText(String.valueOf(true_answers));
    }

    private void numbers()
    {
        number_1 = (int) (Math.random() * (max - min));
        number_2 = (int)(Math.random() * (max - min));
        int number_false = (int)(Math.random() * (max1 - min1));
        number_res = number_1 + number_2;
        number_i = (int)(Math.random() * (6));

        String text;
        if(number_i < 3)
        {
            text = number_1 + " + " + number_2 + " = " + number_res;
            is_true_answer = true;
        }
        else
        {
            text = number_1 + " + " + number_2 + " = " + number_false;
            is_true_answer = false;
        }
        tvMain.setText(String.valueOf(text));
    }

    public void OnClickTrue(View view)
    {
        if(is_true_answer)
        {
            true_answers++;
        }

            numbers();
            currentTime = System.currentTimeMillis();
            time_result = (float)(currentTime - startTime) / 1000;
            String time = "Time: " + time_result;
            actionBar.setTitle(time);

            tvRes.setText(String.valueOf(true_answers));
    }

    public void onClickFalse(View view)
    {
        if(!is_true_answer)
        {
            true_answers++;
        }
                numbers();

                currentTime = System.currentTimeMillis();
                time_result = (float)(currentTime - startTime) / 1000;
                String time = "Time: " + time_result;
                actionBar.setTitle(time);

        tvRes.setText(String.valueOf(true_answers));
    }
}