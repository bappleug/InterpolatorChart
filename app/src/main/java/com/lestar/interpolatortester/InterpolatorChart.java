package com.lestar.interpolatortester;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by Ray on 2017/4/27.
 */

public class InterpolatorChart extends View {

    private static int MARGIN_DP = 8;
    private static int AXIS_COLOR = Color.BLUE;
    private static int AXIS_LINE_WIDTH_DP = 2;
    private static int LINE_COLOR = Color.RED;
    private static int LINE_WIDTH_DP = 2;

    private Interpolator mInterpolator;

    private Paint mAxisPaint;
    private Paint mLinePaint;
    private int mWidth;
    private int mHeight;

    public InterpolatorChart(Context context) {
        super(context);
    }

    public InterpolatorChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InterpolatorChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setInterpolator(Interpolator interpolator){
        this.mInterpolator = interpolator;
        invalidate();
    }

    private void init(){
        mAxisPaint = new Paint();
        mAxisPaint.setAntiAlias(true);
        mAxisPaint.setStrokeCap(Paint.Cap.ROUND);
        mAxisPaint.setColor(AXIS_COLOR);
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(LINE_COLOR);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
