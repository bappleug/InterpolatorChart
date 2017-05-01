package com.lestar.interpolatortester;

/**
 * Created by my on 2017/5/1 0001.
 */

import android.graphics.PointF;
import android.view.animation.Interpolator;

/**
 * 这是一个的贝塞尔曲线插值器？
 */
public class ScanInterpolator implements Interpolator {
    private int b = 0;
    private final PointF mPointF1 = new PointF();
    private final PointF mPointF2 = new PointF();

    public ScanInterpolator(float x1, float y1, float x2, float y2) {
        this.mPointF1.x = x1;
        this.mPointF1.y = y1;
        this.mPointF2.x = x2;
        this.mPointF2.y = y2;
    }

    @Override
    public float getInterpolation(float input) {
        double d = 1.0d;
        float f2 = input;
        for (int i = b; i < 1024; i++) {
            f2 = i / 1024.0f;
            if (a(f2, 0.0d, mPointF1.x, mPointF2.x, 1.0d) >= input) {
                b = i;
                break;
            }
        }
        double a = a(f2, 0.0d, mPointF1.y, mPointF2.y, 1.0d);
        if (a > 0.999d) {
            this.b = 0;
        } else {
            d = a;
        }
        return (float) d;
    }

    private double a(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        return ((((d6 * 3.0d) * Math.pow(d, 2.0d)) * d4) + ((Math.pow(d6, 3.0d) * d2) + (((3.0d * Math.pow(d6, 2.0d)) * d) * d3))) + (Math.pow(d, 3.0d) * d5);
    }
}