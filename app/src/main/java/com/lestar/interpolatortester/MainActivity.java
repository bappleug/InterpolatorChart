package com.lestar.interpolatortester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;

public class MainActivity extends AppCompatActivity {

    InterpolatorChart vChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vChart = (InterpolatorChart) findViewById(R.id.interpolatorChart);
        vChart.setInterpolator(new CubicBezierInterpolator(0.58f, 0.8f, 0.74f, 0.8f));
//        vChart.setInterpolator(new AnticipateOvershootInterpolator());
        vChart.showAnimChart(3000, true, false);
//        vChart.showStaticChart();
    }
}
