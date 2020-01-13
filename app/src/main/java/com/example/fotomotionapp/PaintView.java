package com.example.fotomotionapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;


public class PaintView extends View {

    private final static int DEF_COLOR = Color.BLACK;
    private static final float DEF_STROKE_SIZE = 8f;

    private Path path = new Path();
    private Paint brush = new Paint();

    private int brushColor = DEF_COLOR;
    private float strokeSize = DEF_STROKE_SIZE;

    public PaintView(Context context) {
        super(context);

        brush.setAntiAlias(true);
        brush.setColor(brushColor);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(strokeSize);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }

        postInvalidate();
        return false;
    }

    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, brush);
    }
}
