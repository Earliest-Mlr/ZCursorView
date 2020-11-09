package com.zhujianyu.zcursorview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhujianyu.cursorview.CursorView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView1, textView2, textView3;
    private CursorView cvCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.tv_text1);
        textView2 = findViewById(R.id.tv_text2);
        textView3 = findViewById(R.id.tv_text3);
        cvCursor = findViewById(R.id.cv_cursor);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);

//        cvCursor.setCursorNumber(2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_text1:
                cvCursor.mobileCursor(0);
                break;
            case R.id.tv_text2:
                cvCursor.mobileCursor(1);
                break;
            case R.id.tv_text3:
                cvCursor.mobileCursor(2);
                break;
        }
    }
}
