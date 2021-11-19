package com.raoshashwat.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class DrawView extends View
{
    int count = 0;
    int dDeg = 1;
    int deg = 130;
    float dDeg2 = 0;
    float deg2 = 0;
    int numStars = 90;
    int[][] stars = new int[numStars][2];

    public DrawView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        Random rand = new Random();
        int randX;
        int randY;
        for (int i = 0; i < numStars; i ++)
        {
            randX = rand.nextInt(1400);
            randY = rand.nextInt(1600);
            stars[i][0] = randX;
            stars[i][1] = randY;
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        int x;
        int delX;
        int y;
        int delY;
        int mainX;
        int mainY;

        super.onDraw(canvas);   //Setup
        Paint p = new Paint();
        p.setAntiAlias(true);
        mainX = 0;
        mainY = 0;
        Random rand = new Random();

        count %= 10;
        canvas.drawColor(Color.BLACK);  //Background
        p.setColor(Color.WHITE);
        for (int[] coord: stars)    //Stars
        {
            canvas.drawCircle(coord[0], coord[1], 5f, p);
        }

        p.setColor(Color.GRAY); //Moon
        canvas.drawCircle(545, 4000, 2800f, p);

        x = 200;
        delX = 20;
        y = 1000;
        delY = 250;
        canvas.save();
        canvas.rotate(-7, x + delX/y, y);
        p.setColor(Color.DKGRAY);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Flagpole
        int x2 = 50;
        int delX2 = 150;
        int y2 = 1000;
        int delY2 = 100;
        p.setColor(Color.WHITE);
        canvas.drawRect(x2, y2, x2 + delX2, y + delY2, p);  //Flag
        canvas.restore();

        //Astronaut
        p.setColor(Color.WHITE);
        x = 545 + mainX;
        y = 900 + mainY;
        float rad = 110;
        canvas.drawCircle(x, y, rad, p);   //Helmet
        p.setColor(0xFFFFCBA4);
        rad = 78;
        canvas.drawCircle(x, y, rad, p);
        p.setColor(0xFFA0A0A0);
        rad = 90;
        canvas.drawCircle(x, y, rad, p);

        x = 400 + mainX;
        delX = 100;
        y = 1040 + mainY;
        delY = 350;
        canvas.save();
        canvas.rotate(deg, x + delX/2, y);
        x2 = 410 + mainX;
        delX2 = 80;
        y2 = 1370 + mainY;
        delY2 = 70;
        p.setColor(Color.DKGRAY);
        canvas.drawRect(x2, y2, x2 + delX2, y2 + delY2, p);   //Left Hand
        p.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Arm
        y = y + 300;
        delY = delY/18;
        p.setColor(Color.RED);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Bands
        canvas.drawRect(x, y - 30, x + delX, y - 30 + delY, p);
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
        y = y + 300;
        delY = delY/18;
        p.setColor(Color.RED);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Bands
        canvas.drawRect(x, y - 30, x + delX, y - 30 + delY, p);
        canvas.restore();

        x = 435 + mainX;
        delX = 220;
        y = 990 + mainY;
        delY = 300;
        p.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Body

        x = 470 + mainX;
        delX = 155;
        y = 1070 + mainY;
        delY = 80;
        int round = 10;
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        p.setColor(Color.DKGRAY);
        canvas.drawRoundRect(x, y, x + delX, y + delY, round, round, p);
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setStrokeWidth(0);

        p.setColor(Color.RED);
        x = 500 + mainX;
        y = 1100 + mainY;
        rad = 20;
        canvas.drawCircle(x, y, rad, p);    //Red Button

        p.setColor(Color.BLUE);
        x = 540 + mainX;
        y = 1095 + mainY;
        rad = 10;
        canvas.drawCircle(x, y, rad, p);    //Blue Button 1

        x = 570 + mainX;
        y = 1095 + mainY;
        rad = 10;
        canvas.drawCircle(x, y, rad, p);    //Blue Button 2

        x = 600 + mainX;
        y = 1095 + mainY;
        rad = 10;
        canvas.drawCircle(x, y, rad, p);    //Blue Button 3

        p.setColor(Color.DKGRAY);
        x = 530 + mainX;
        delX = 80;
        y = 1110 + mainY;
        delY = 20;
        round = 10;
        canvas.drawRoundRect(x, y, x + delX, y + delY, round, round, p);

        x = 280 + mainX;
        delX = 180;
        y = 1680 + mainY;
        delY = 85;
        round = 30;
        p.setColor(Color.DKGRAY);
        canvas.drawRoundRect(x, y, x + delX, y + delY, round, round, p);  //Left Foot

        x = 630 + mainX;
        delX = 180;
        y = 1680 + mainY;
        delY = 85;
        p.setColor(Color.DKGRAY);
        canvas.drawRoundRect(x, y, x + delX, y + delY, round, round, p);  //Right Foot

        x = 585 + mainX;
        delX = 120;
        y = 1350 + mainY;
        delY = 350;
        canvas.save();
        canvas.rotate(-15,x + delX/2,y + delY/2);
        p.setColor(Color.WHITE);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Right Leg
        y = y + 300;
        delY = delY/18;
        p.setColor(Color.RED);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Bands
        canvas.drawRect(x, y - 30, x + delX, y - 30 + delY, p);
        canvas.restore();

        x = 390 + mainX;
        delX = 120;
        y = 1350 + mainY;
        delY = 350;
        canvas.save();
        p.setColor(Color.WHITE);
        canvas.rotate(15,x + delX/2,y + delY/2);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Left Leg
        y = y + 300;
        delY = delY/18;
        p.setColor(Color.RED);
        canvas.drawRect(x, y, x + delX, y + delY, p);   //Bands
        canvas.drawRect(x, y - 30, x + delX, y - 30 + delY, p);
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

        x = 420;
        delX = 250;
        y = 290;
        delY = 120;
        canvas.save();
        canvas.rotate(deg2, 545, 4000);
        p.setColor(Color.RED);
        canvas.drawRect(x, y, x + delX, y + delY, p);
        p.setColor(0xFF940000);
        Path path2 = new Path();
        path2.moveTo(x + delX, y);
        path2.lineTo(x + delX + 50, y + delY/2);
        path2.lineTo(x + delX, y + delY);
        path2.moveTo(x, y);
        path2.lineTo(x - 50, y - 50);
        path2.lineTo(x - 50 + 45, y - 50);
        path2.lineTo(x + 100, y);
        path2.moveTo(x, y + delY);
        path2.lineTo(x - 50, y + delY + 50);
        path2.lineTo(x - 50 + 45, y + delY + 50);
        path2.lineTo(x + 100, y + delY);
        path2.close();
        canvas.drawPath(path2, p);
        p.setColor(Color.LTGRAY);
        Path path3 = new Path();
        path3.moveTo(x, y + 15);
        path3.lineTo(x - 15, y + 10 - 5);
        path3.lineTo(x - 15, y + delY - 10 + 5);
        path3.lineTo(x, y + delY - 15);
        path3.close();
        canvas.drawPath(path3, p);  //Rocket
        x2 = x + delX/2;
        y2 = y + delY/2;
        rad = 50f;
        p.setColor(Color.WHITE);
        canvas.drawCircle(x2, y2, rad, p);
        rad = 40f;
        p.setColor(0xff91deff);
        canvas.drawCircle(x2, y2, rad, p);


        x = x - 15;
        y = y + 38;
        p.setColor(Color.YELLOW);
        Path path5 = new Path();
        path5.moveTo(x, y);
        path5.lineTo(x - 35, y);
        path5.lineTo(x - 70, y + 23);
        path5.lineTo(x - 35, y + 45);
        path5.lineTo(x, y + 45);
        path5.close();
        canvas.drawPath(path5, p);  //Inner Flame
        y = y - 16;
        p.setColor(0xbee37d24);
        Path path4 = new Path();
        path4.moveTo(x, y);
        path4.lineTo(x - 70/2, y - 5);
        path4.lineTo(x - 70, y - 5);
        path4.lineTo(x - 100, y + 35);
        path4.lineTo(x - 70, y + 80);
        path4.lineTo(x - 70/2, y + 80);
        path4.lineTo(x, y + 75);
        path4.close();
        canvas.drawPath(path4, p);  //Outer Flame
        canvas.restore();

        deg2 += dDeg2;
        deg2 %= 360;
        if ((deg2 >= 335 && deg2 <= 360) || (deg2 >= 0 && deg2 <= 25))
        {
            dDeg2 = 0.2f;
        }
        else
        {
            dDeg2 = 6.5f;
        }

        deg += dDeg;
        if (deg >= 145)
        {
            dDeg = -dDeg;
        }
        else if (deg <= 120)
        {
            dDeg = -dDeg;
        }
        count ++;
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
