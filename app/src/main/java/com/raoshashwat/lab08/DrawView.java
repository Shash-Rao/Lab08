package com.raoshashwat.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
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

        canvas.drawColor(Color.BLACK);  //Background

        p.setColor(Color.GRAY); //Moon
        canvas.drawCircle(545, 2700, 1500f, p);

        p.setColor(Color.WHITE);    //Astronaut
        canvas.drawCircle(545, 900, 110f, p);
        p.setColor(0xFFFFCBA4);
        canvas.drawCircle(545, 900, 78f, p);
        p.setColor(0x90C9C9C9);
        canvas.drawCircle(545, 900, 90f, p);
        p.setColor(Color.WHITE);
        int x = 440;
        int delX = 200;
        int y = 1000;
        int delY = 200;
        canvas.drawRect(x, y, x + delX, y + delY, p);

        invalidate();
    }
}
