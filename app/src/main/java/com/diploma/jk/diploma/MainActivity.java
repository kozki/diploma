package com.diploma.jk.diploma;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    Sensor accelerometer;
    Sensor orientation;
    SensorManager sm;
    TextView acceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SeznamSenzorjev.class);
                startActivity(intent);
            }
        });


        //ACCELEROMETER TEST
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        orientation = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, orientation, SensorManager.SENSOR_DELAY_NORMAL);

        acceleration = (TextView)findViewById(R.id.acceleration);
        orientation = (TextView)findViewById(R.id.sensorList);

    }


    //DODANA METODA PRI TESTIRANJU ACCELEROMETRA
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        acceleration.setText("X: "+sensorEvent.values[0]+
                            "\nY: "+sensorEvent.values[1]+
                            "\nZ: "+sensorEvent.values[2]);
    }


    //DODANA METODA PRI TESTIRANJU ACCELEROMETRA
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
