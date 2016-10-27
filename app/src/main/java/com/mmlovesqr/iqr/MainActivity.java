package com.mmlovesqr.iqr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mmlovesqr.loveqr.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String WHEN_WE_MET = "2016-09-11 01:00:00";

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView tv = (TextView) findViewById(R.id.counter);
//        tv.setText(formatDays());
//
//    }

    private TimerView timerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerView = (TimerView) findViewById(R.id.timer);

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date since = format.parse(WHEN_WE_MET);
            String nowDate = format.format(new Date());
            Date now = format.parse(nowDate);
            timerView.setMax(daysBetween(since, now));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        timerView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        timerView.stop();
    }

    private String formatDays() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date since = format.parse(WHEN_WE_MET);
            String nowDate = format.format(new Date());
            Date now = format.parse(nowDate);

            return String.valueOf(daysBetween(since, now) + 1);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "爱你一万年";
    }

    private static int daysBetween(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }
}
