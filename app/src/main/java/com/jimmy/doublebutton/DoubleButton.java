package com.jimmy.doublebutton;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


/**
 * Created by zhangtianjie on 2017/7/21.
 */



public class DoubleButton extends AppCompatButton {

    Context mContext;
    OnDoubleListener mDoubleListener;

    public DoubleButton(Context context) {
        super(context);
        this.mContext=context;
    }

    public DoubleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
    }

    public DoubleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
    }
    long downTime;
    long upTime;

    long firstTime;
    long secondTime;

    public interface OnDoubleListener{

        int DURING_CLICK_TIME=500;
        int CLICK_TIME=500;

        void doubleClick(View v);
    }

    public void setOnDoubleClickListener(OnDoubleListener mDoubleListener){
        this.mDoubleListener=mDoubleListener;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        long currentTime=System.currentTimeMillis();
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            downTime=currentTime;
            Log.d("MotionEvent","dowm:"+downTime+"");
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
            upTime=currentTime;
            Log.d("MotionEvent","up:"+upTime+"");
            if(upTime-downTime<OnDoubleListener.DURING_CLICK_TIME){
                singelClick(currentTime);
            }



        }

        return super.onTouchEvent(event);
    }

    private void singelClick(long currentTime) {
       if(currentTime-firstTime<OnDoubleListener.CLICK_TIME){

           if(mDoubleListener!=null){
               mDoubleListener.doubleClick(DoubleButton.this);
           }

         Log.d("Motion","双击");
       }else{
           firstTime=currentTime;
       }
    }
}
