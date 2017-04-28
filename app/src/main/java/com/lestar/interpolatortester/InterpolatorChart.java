package com.lestar.interpolatortester;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by Ray on 2017/4/27.
 */

public class InterpolatorChart extends View {

    private static int PADDING_DP = 8;
    private static int AXIS_COLOR = Color.BLACK;
    private static int LINE_COLOR = Color.DKGRAY;
    private static int TEXT_COLOR = Color.BLACK;
    private static int Y_AXIS_BALL_COLOR = Color.BLUE;
    private static int Y_LINE_BALL_COLOR = Color.RED;
    private static int Y_BALL_RADIUS_DP = 8;
    private static int LINE_BALL_RADIUS_DP = 4;
    private static int AXIS_WIDTH_DP = 1;
    private static int LINE_WIDTH_DP = 1;
    private static int TEXT_SIZE_SP = 14;
    private static final String Y_AXIS_TEXT = "Y-Axis";
    private static final String X_AXIS_TEXT = "Time";

    private Interpolator mInterpolator;

    private Rect mAxisRect;
    private Paint mAxisPaint;
    private Paint mLinePaint;
    private Paint mTextPaint;
    private Paint mYBallPaint;
    private Paint mLineBallPaint;
    private int mWidth;
    private int mHeight;
    private int mChartHeight;
    private int mChartWidth;
    private int mYAxisTextWidth;
    private int mTextHeight;
    private int mPadding;
    private boolean showStatic = true;
    private boolean showSampleDots = false;

    public InterpolatorChart(Context context) {
        super(context);
        init();
    }

    public InterpolatorChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InterpolatorChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setInterpolator(Interpolator interpolator){
        this.mInterpolator = interpolator;
        invalidate();
    }

    public void showStaticChart(){
        showStatic = true;
        showSampleDots = false;
        invalidate();
    }

    public void showStaticChart(boolean drawSampleDots){
        showStatic = true;
        showSampleDots = drawSampleDots;
        invalidate();
    }

    public void showAnimChart(int duration, boolean repeat){

    }

    private void init(){
        mAxisPaint = new Paint();
        mAxisPaint.setAntiAlias(true);
        mAxisPaint.setStrokeCap(Paint.Cap.ROUND);
        mAxisPaint.setColor(AXIS_COLOR);
        mAxisPaint.setStrokeWidth(DensityUtils.dip2px(getContext(), AXIS_WIDTH_DP));
        mAxisPaint.setStyle(Paint.Style.STROKE);
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(LINE_COLOR);
        mLinePaint.setStrokeWidth(DensityUtils.dip2px(getContext(), LINE_WIDTH_DP));
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(DensityUtils.dip2px(getContext(), TEXT_SIZE_SP));
        mTextPaint.setColor(TEXT_COLOR);
        mPadding = DensityUtils.dip2px(getContext(), PADDING_DP);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        mYAxisTextWidth = DensityUtils.dip2px(getContext(), Y_AXIS_TEXT.length() / 2 * TEXT_SIZE_SP + 8);
        mTextHeight = DensityUtils.dip2px(getContext(), TEXT_SIZE_SP + 8);
        mChartHeight = mHeight - mPadding * 2 - mTextHeight;
        mChartWidth = mWidth - mPadding * 2 - mYAxisTextWidth;
        mAxisRect = new Rect(
                mYAxisTextWidth + mPadding,
                mPadding,
                mWidth - mPadding,
                mHeight - mTextHeight - mPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mWidth == 0 || mHeight == 0){
            return;
        }
        drawAxis(canvas);
        drawText(canvas);
        if(showStatic){
            drawCurve();
        } else {
            drawLineAndBalls();
        }
    }

    private void drawAxis(Canvas canvas){
        canvas.drawRect(mAxisRect, mAxisPaint);
    }

    private void drawText(Canvas canvas){
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(Y_AXIS_TEXT, mPadding, mAxisRect.height() / 2 + mPadding, mTextPaint);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(X_AXIS_TEXT, (mAxisRect.right + mAxisRect.left) / 2, mHeight - mPadding, mTextPaint);
    }

    private void drawCurve() {
        if(mInterpolator == null){
            return;
        }
        for(int i = 0; i < 100; i++){
            float stepX = mChartWidth / 100;
            float value = mInterpolator.getInterpolation(i / 100.0f);
            float stepY = 
        }
    }

    private void drawLineAndBalls() {

    }
}
