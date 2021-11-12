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
    int dDeg = 1;
    int deg = 130;
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
        int mainX = 0;
        int mainY = 0;

        canvas.drawColor(Color.BLACK);  //Background

        p.setColor(Color.GRAY); //Moon
        canvas.drawCircle(545, 2700, 1500f, p);

        //Astronaut
        p.setColor(Color.WHITE);
        int x = 545 + mainX;
        int y = 900 + mainY;
        canvas.drawCircle(x, y, 110f, p);   //Helmet
        p.setColor(0xFFFFCBA4);
        canvas.drawCircle(x, y, 78f, p);
        p.setColor(0x90C9C9C9);
        canvas.drawCircle(x, y, 90f, p);
        p.setColor(Color.WHITE);
        x = 435 + mainX;
        int delX = 220;
        y = 990 + mainY;
        int delY = 300;
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Body

        x = 400 + mainX;
        delX = 100;
        y = 1040 + mainY;
        delY = 350;
        canvas.save();
        canvas.rotate(deg, x + delX/2, y);
        int x2 = 410 + mainX;
        int delX2 = 80;
        int y2 = 1370 + mainY;
        int delY2 = 70;
        p.setColor(Color.DKGRAY);
        canvas.drawRect(x2, y2, x2 + delX2, y2 + delY2, p);   //Left Hand
        p.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Arm
        canvas.restore();

        x = 760 + mainX;
        delX = 80;
        y = 1300 + mainY;
        delY = 70;
        canvas.save();
        canvas.rotate(-30, x + delX/2, y + delY/2);
        p.setColor(Color.DKGRAY);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Right Hand
        canvas.restore();

        x = 660 + mainX;
        delX = 100;
        y = 1000 + mainY;
        delY = 350;
        canvas.save();
        canvas.rotate(-30, x + delX/2, y + delY/2);
        p.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Right Arm
        canvas.restore();

        x = 280 + mainX;
        delX = 180;
        y = 1680 + mainY;
        delY = 85;
        p.setColor(Color.DKGRAY);
        canvas.drawRoundRect(x, y, x + delX, y + delY, 30, 30, p);  //Left Foot

        x = 630 + mainX;
        delX = 180;
        y = 1680 + mainY;
        delY = 85;
        p.setColor(Color.DKGRAY);
        canvas.drawRoundRect(x, y, x + delX, y + delY, 30, 30, p);  //Right Foot

        x = 585 + mainX;
        delX = 120;
        y = 1350 + mainY;
        delY = 350;
        canvas.save();
        canvas.rotate(-15,x + delX/2,y + delY/2);
        p.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Right Leg
        canvas.restore();

        x = 390 + mainX;
        delX = 120;
        y = 1350 + mainY;
        delY = 350;
        canvas.save();
        canvas.rotate(15,x + delX/2,y + delY/2);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Leg
        canvas.restore();

        x = 433 + mainX;
        y = 1338 + mainY;
        p.setColor(Color.DKGRAY);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(x, y - 50);
        path.lineTo(x, y + 3);
        path.lineTo(x + 114, y + 41);
        path.lineTo(x + 225,y + 3);
        path.lineTo(x + 225,y - 50);
        path.close();
        canvas.drawPath(path, p);

        deg += dDeg;
        if (deg >= 145)
        {
            dDeg = -dDeg;
        }
        else if (deg <= 120)
        {
            dDeg = -dDeg;
        }
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
