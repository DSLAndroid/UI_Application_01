package com.dsl.ui_application_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int[] image={R.mipmap.anni,R.mipmap.aolafu,R.mipmap.baoshi,R.mipmap.jie,R.mipmap.ic_launcher};

    int index=0;
    double startX=0.0;
    double endX=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageSwitcher is=(ImageSwitcher)findViewById(R.id.imageSwitcher1);
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv = new ImageView(MainActivity.this);
                iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                iv.setImageResource(image[index]);
                return iv;
            }
        });
        is.setOnTouchListener(new View.OnTouchListener(){
            //触摸事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    startX=event.getX();
                    return true;//按下去
                }
                if(event.getAction()==MotionEvent.ACTION_UP)
                {
                    endX=event.getX();
                    System.out.println("start="+startX);
                    System.out.println("endX="+endX);
                    if(endX-startX>20)//向右滑
                    {
                        index=index-1>0?--index:image.length-1;
                        System.out.println("向右滑");
                        is.setInAnimation(MainActivity.this,android.R.anim.fade_in);
                        is.setOutAnimation(MainActivity.this,android.R.anim.fade_out);
                        is.setImageResource(image[index]);
                    }
                    else if(startX-endX>20)//向左滑
                    {
                        index=index+1<image.length?++index:0;
                        System.out.println("向左滑");
                        is.setInAnimation(MainActivity.this,android.R.anim.fade_in);
                        is.setOutAnimation(MainActivity.this,android.R.anim.fade_out);
                        is.setImageResource(image[index]);
                    }
                }
                return false;
            }
        });
    }
}
