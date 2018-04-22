package com.dm.environmentapp;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;

public class Progress extends AppCompatActivity {
    private static GraphView graph;
    private static LineGraphSeries<DataPoint> series;
    private static int todaysDate;
    private static boolean setUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        Log.d("test", "todays Date is: "+ todaysDate);
        todaysDate =Calendar.DAY_OF_WEEK;
        Log.d("test", "before set up");
        if (!setUp){
            Log.d("test", "set up");
            graph = (GraphView) findViewById(R.id.graph);
            series = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
                    new DataPoint(0, 0)
            });
            series.setDrawDataPoints(true);
//            graph.getViewport().setXAxisBoundsManual(true);
//            graph.getViewport().setMinX(0);
//            graph.getViewport().setMaxX(8);
            graph.getViewport().setScalable(true);
            graph.getViewport().setScrollable(true);

            setUp= true;
        }
        graph.removeAllSeries();
        graph.addSeries(series);
        Bundle extras = getIntent().getExtras();

        if (extras != null){
            //graph.removeAllSeries();
//            series.appendData(new DataPoint(1 * Math.random(),2), false, 1000);
//            series.appendData(new DataPoint(1 ,4), false, 1000);
            series.appendData(new DataPoint((Calendar.DAY_OF_WEEK %todaysDate)+ Calendar.HOUR * .01+ Calendar.MINUTE *.0001
                    +Calendar.SECOND * .000001, Double.parseDouble(extras.getString("key"))), false, 1000);
            //graph.addSeries(series);
            extras.clear();
        } //^^

    }






}
