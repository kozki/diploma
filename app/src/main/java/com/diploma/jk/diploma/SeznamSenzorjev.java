package com.diploma.jk.diploma;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SeznamSenzorjev extends AppCompatActivity {
    SensorManager sm;
    List<Sensor> ss;
    TextView sslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seznam_senzorjev);

        sslist = (TextView)findViewById(R.id.sensorList);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        ss = sm.getSensorList(Sensor.TYPE_ALL);

        for (Sensor s: ss) {
            sslist.append("\n\n"+s.getName());
        }
    }
}
