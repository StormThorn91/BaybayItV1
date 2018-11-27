package com.milagrado.cs.baybayit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Caitlin on 10/31/2018.
 */

public class MyCanvas{

    Paint paint;
    Path path;

//    public MyCanvas(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        paint = new Paint();
//        path = new Path();
//
//        paint.setAntiAlias(true);
//        paint.setColor(Color.BLACK);
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(15f);
//    }

    public static void renderModel (Canvas canvas, DrawModel model, Paint paint, int startLineIndex){
        paint.setAntiAlias(true);

        int lineSize = model.getLineSize();
        //given that size
        for (int i = startLineIndex; i < lineSize; ++i){
            DrawModel.Line line = model.getLine(i);
            paint.setColor(Color.BLACK);
            int elemSize = line.getElemSize();
            if (elemSize < 1){
                continue;
            }
            DrawModel.LineElem elem = line.getElem(0);
            float lastX = elem.x;
            float lastY = elem.y;

            for (int j = 0; j < elemSize; ++j) {
                //get the next coordinate
                elem = line.getElem(j);
                float x = elem.x;
                float y = elem.y;
                //and draw the line between those two paints
                canvas.drawLine(lastX, lastY, x, y, paint);
                //store the coordinate as last and repeat
                //until the line is drawn
                lastX = x;
                lastY = y;
            }
        }
    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawPath(path, paint);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        float xPos = event.getX();
//        float yPos = event.getY();
//
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                path.moveTo(xPos, yPos);
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                path.lineTo(xPos, yPos);
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//            default:
//                return false;
//        }
//        invalidate();
//        return true;
//    }


}
