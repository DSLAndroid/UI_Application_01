package com.dsl.ui_application_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity2 extends AppCompatActivity {

    double startX=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewfilper);
        final ViewFlipper vf=(ViewFlipper)findViewById(R.id.viewFlipper1);
        vf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    startX=event.getX();
                    return true;
                }
                else if(event.getAction()==MotionEvent.ACTION_UP)
                {
                    if(event.getX()>startX)//右滑
                    {
                        System.out.println("右滑");
                        vf.showPrevious();
                    }else if(event.getX()<startX)//左滑
                    {
                        vf.showNext();
                    }
                }
                return false;
            }
        });
    }
}
