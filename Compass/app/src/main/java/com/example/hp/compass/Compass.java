package com.example.hp.compass;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.hardware.SensorManager.SENSOR_DELAY_UI;

public class Compass extends AppCompatActivity implements SensorEventListener{

    ImageView img_compass;
    TextView txt_compass; //azymut -  kąt zawarty między północną częścią południka odniesienia a danym kierunkiem poziomym
    int mAzimuth;
    private SensorManager mSensorManager;
    private Sensor mRotationV, mAccelerometer, mMagnetometer; //akcelerometr, czujniki wektora obrotowego,
    float[] rMat = new float[9];
    float[] orientation = new float[9];
    private float[] mLastAccelerometer = new float[3];
    private float[] mLastMagnetometer = new float[3];
    private boolean haveSensor = false, haveSensor2 = false;
    private boolean mLastAccelerometerSet = false;
    private boolean mLastMagnetometerSet = false;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        img_compass = (ImageView) findViewById(R.id.img_compass);
        txt_compass = (TextView) findViewById(R.id.txt_azimuth);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPositionActivity();
            }
        });
        start();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {        //sensor reports new value
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            SensorManager.getRotationMatrixFromVector(rMat, event.values);  //convert rotation vector to rotation matrix
            mAzimuth = (int) ((Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360);
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values,0,mLastAccelerometer,0,event.values.length);  //copy event values to the mLastAccelerometer
            mLastAccelerometerSet = true;
        }
        else
            if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
                System.arraycopy(event.values,0,mLastMagnetometer,0,event.values.length);
                mLastMagnetometerSet = true;
            }
        if(mLastMagnetometerSet && mLastAccelerometerSet){
            SensorManager.getRotationMatrix(rMat,null,mLastAccelerometer,mLastMagnetometer);    //
            SensorManager.getOrientation(rMat,orientation);     //Computes the device's orientation based on the rotation matrix.
            mAzimuth = (int) ((Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360);
        }
        mAzimuth = Math.round(mAzimuth);
        img_compass.setRotation(-mAzimuth);

        String where = "NO";

        if (mAzimuth >= 350 || mAzimuth <= 10)
            where = "N";
        if (mAzimuth < 350 && mAzimuth > 280)
            where = "NW";
        if (mAzimuth <= 280 && mAzimuth > 260)
            where = "W";
        if (mAzimuth <= 260 && mAzimuth > 190)
            where = "SW";
        if (mAzimuth <= 190 && mAzimuth > 170)
            where = "S";
        if (mAzimuth <= 170 && mAzimuth > 100)
            where = "SE";
        if (mAzimuth <= 100 && mAzimuth > 80)
            where = "E";
        if (mAzimuth <= 80 && mAzimuth > 10)
            where = "NE";


        txt_compass.setText(mAzimuth + "° " + where);

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {    //sensor reports with different accuracy

    }

    public void start() {
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null){
            if(mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null ||
                    mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)==null){
                noSensorAlert();
            }
            else{
                mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

                haveSensor = mSensorManager.registerListener(this,mAccelerometer,SensorManager.SENSOR_DELAY_UI);
                haveSensor2 = mSensorManager.registerListener(this,mMagnetometer,SensorManager.SENSOR_DELAY_UI);
            }
        }
        else{
            mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            haveSensor = mSensorManager.registerListener(this,mRotationV,SensorManager.SENSOR_DELAY_UI);
        }

    }
    public void noSensorAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Your device does not support the compass")
                .setCancelable(false) // we have to push close button
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
    }

    public void stop(){
        if(haveSensor && haveSensor2) {
            mSensorManager.unregisterListener(this,mAccelerometer);
            mSensorManager.unregisterListener(this,mMagnetometer);
        }
        else
            if(haveSensor){
                mSensorManager.unregisterListener(this,mRotationV);
            }
    }

    @Override
    protected void onPause(){
        super.onPause();
        stop();
    }

    @Override
    protected void onResume(){
        super.onResume();
        start();
    }

    public void openPositionActivity(){
        Intent position = new Intent(Compass.this, activity_position.class);
        startActivity(position);
    }
}
