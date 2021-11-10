package com.raoshashwat.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View
{
    public DrawView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);   //Setup
        Paint p = new Paint();
        p.setAntiAlias(true);

        canvas.drawColor(Color.BLACK);  //Background

        p.setColor(Color.GRAY); //Moon
        canvas.drawCircle(545, 2700, 1500f, p);

        p.setColor(Color.WHITE);    //Astronaut
        canvas.drawCircle(545, 900, 110f, p);   //Helmet
        p.setColor(0xFFFFCBA4);
        canvas.drawCircle(545, 900, 78f, p);
        p.setColor(0x90C9C9C9);
        canvas.drawCircle(545, 900, 90f, p);
        p.setColor(Color.WHITE);
        int x = 435;
        int delX = 220;
        int y = 990;
        int delY = 300;
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Body

//        canvas.save();
//        canvas.rotate(30);
//        x = 850;
//        delX = 100;
//        y = 650;
//        delY = 300;
//        canvas.drawRect(x, y, x + delX, y + delY, p);   //Right Arm
//        canvas.restore();
//
//
//        canvas.rotate(-30);
//        x = -10;
//        delX = 100;
//        y = 1200;
//        delY = 300;
//        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Arm
//        canvas.rotate(30);

        x = 605;
        delX = 120;
        y = 1350;
        delY = 350;
        canvas.save();
        canvas.rotate(-20,x + delX/2,y + delY/2);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Leg
        canvas.restore();

        x = 370;
        delX = 120;
        y = 1350;
        delY = 350;
        canvas.save();
        canvas.rotate(20,x + delX/2,y + delY/2);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Leg
        canvas.restore();

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo((float) (x * Math.cos(Math.toRadians(-20))), y);
        path.lineTo((float) ((x + delX) * Math.cos(Math.toRadians(-20))), y);
        //path.lineTo(1100, 1050);
        path.lineTo(0,0);
        path.close();
        canvas.drawPath(path, p);


        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
            System.out.println("point "+event.getX() +";" +event.getY());

        return true;
    }
}
