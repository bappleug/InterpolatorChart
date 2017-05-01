package com.lestar.interpolatortester;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/**
 * Created by my on 2017/5/1 0001.
 */

public class CubicBezierInterpolator implements Interpolator {
    private int mLastI = 0;
    private static final float STEP_SIZE = 1.0f / 4096;
    private final PointF point1 = new PointF();
    private final PointF point2 = new PointF();

    public CubicBezierInterpolator(float x1, float y1, float x2, float y2) {
        point1.x = x1;
        point1.y = y1;
        point2.x = x2;
        point2.y = y2;
    }

    @Override
    public float getInterpolation(float input) {
        float t = input;
        //如果重新开始要重置缓存的i。
        if (input == 0) {
            mLastI = 0;
        }
        // 近似求解t
        double tempX;
        for (int i = mLastI; i < 4096; i++) {
            t = i * STEP_SIZE;
            tempX = cubicEquation(t, point1.x, point2.x);
            if (tempX >= input) {
                mLastI = i;
                break;
            }
        }
        double value = cubicEquation(t, point1.y, point2.y);

        //如果结束要重置缓存的i。
        if (input == 1) {
            mLastI = 0;
        }
        return (float) value;
    }

    public static double cubicEquation(double t, double p1, double p2) {
        double u = 1 - t;
        double tt = t * t;
        double uu = u * u;
        double ttt = tt * t;
        return 3 * uu * t * p1 + 3 * u * tt * p2 + ttt;
    }

}