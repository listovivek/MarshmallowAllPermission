package com.example.user.allpermissionreqcode;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_CALENDAR;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;

public class MainActivity extends AppCompatActivity {

    public static final int RequestPermissionCode = 1;

    private static final int MY_CAMERA_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkPermission()){
            Toast.makeText(MainActivity.this,
                    "All Permissions Granted Successfully", Toast.LENGTH_LONG).show();
        }
        else {
            requestPermission();

        }
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {
                        Manifest.permission.CAMERA,
                        READ_CONTACTS,
                        READ_PHONE_STATE,
                        RECORD_AUDIO,
                        ACCESS_FINE_LOCATION,
                        READ_EXTERNAL_STORAGE,
                        WRITE_EXTERNAL_STORAGE,
                        READ_CALENDAR
                }, RequestPermissionCode);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {

                    boolean CameraPermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean ReadContactsPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean ReadPhoneStatePermission = grantResults[2] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean recordAudio = grantResults[3] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean accessLocation = grantResults[4] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean storageRead = grantResults[5] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean storageWrite = grantResults[6] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean calender = grantResults[7] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (CameraPermission && ReadContactsPermission && ReadPhoneStatePermission
                            && recordAudio && accessLocation && storageRead && calender) {

                        Toast.makeText(MainActivity.this,
                                "Permission Granted", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this,
                                "Permission Denied",Toast.LENGTH_LONG).show();

                    }
                }
                break;
        }
    }

    public boolean checkPermission() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA);

        int SecondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                READ_CONTACTS);
        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                READ_PHONE_STATE);
        int fourPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        int fifthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                ACCESS_FINE_LOCATION);
        int sixthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                READ_EXTERNAL_STORAGE);
        int seventhPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                ACCESS_FINE_LOCATION);
        int eighthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),
                READ_CALENDAR);


        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED &&
        fourPermissionResult == PackageManager.PERMISSION_GRANTED &&
        fifthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                sixthPermissionResult == PackageManager.PERMISSION_GRANTED &&
                seventhPermissionResult == PackageManager.PERMISSION_GRANTED &&
                eighthPermissionResult == PackageManager.PERMISSION_GRANTED;
    }
}
