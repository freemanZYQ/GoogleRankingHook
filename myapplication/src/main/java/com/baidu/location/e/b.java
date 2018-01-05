package com.baidu.location.e;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;

public class b implements SensorEventListener {
    private static b d;
    private static float e;
    float[] a;
    float[] b = new float[9];
    SensorManager c;
    private boolean f;

    public static b a() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public synchronized void b() {
        if (this.c == null) {
            this.c = (SensorManager) f.getServiceContext().getSystemService("sensor");
        }
        this.c.registerListener(this, this.c.getDefaultSensor(11), 3);
    }

    public synchronized void c() {
        if (this.c != null) {
            this.c.unregisterListener(this);
            this.c = null;
        }
    }

    public boolean d() {
        return this.f;
    }

    public float e() {
        return e;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 11:
                this.a = (float[]) sensorEvent.values.clone();
                break;
        }
        if (this.a != null) {
            float[] fArr = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr, this.a);
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            e = (float) Math.toDegrees((double) fArr2[0]);
            e = (float) Math.floor(e >= 0.0f ? (double) e : (double) (e + 360.0f));
        }
    }
}
