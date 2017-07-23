package com.jimmy.doublebutton;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DoubleButton mDB;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     mContext=this;
//        TextView tv=new TextView(this);
//        tv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//

       mDB=(DoubleButton) findViewById(R.id.db_btn);
       mDB.setOnDoubleClickListener(new DoubleButton.OnDoubleListener() {
           @Override
           public void doubleClick(View v) {
               Toast.makeText(mContext,"您双击了",Toast.LENGTH_SHORT).show();
           }
       });

    }
}
