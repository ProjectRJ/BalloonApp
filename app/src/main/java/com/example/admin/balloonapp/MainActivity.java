package com.example.admin.balloonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;


public class MainActivity extends Activity {


    private boolean cameraFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        findFrontFacingCamera();
    }

    private int findFrontFacingCamera() {
        int CameraId = -1;//Set an integer variable called CameraId to -1
        int Number_Of_Cameras = Camera.getNumberOfCameras();
        //Set Number_Of_Cameras to the integer returned from the function .getNumberOfCameras()
        for (int i = 0; i < Number_Of_Cameras; i++) {
            //Set variable called i to 0, for i is less than Number_Of_Cameras, increment 1 to i
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                CameraId = i;
                cameraFront = true;
                break;
            }
        }
        return CameraId;
    }

    //An variable called number_Of_Cameras is set as an integer and it equals to the number returned from the function .getNumberOfCameras()
    //Search for the back facing camera
    private int findBackCamera() {
        int CameraId = -1;
        int Number_Of_Cameras = Camera.getNumberOfCameras();
        //get the number of cameras
        //for every camera check
        for (int i = 0; i < Number_Of_Cameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                CameraId = i;
                cameraFront = false;
                break;
                // CameraInfo couldnt be resolved and so therefore CTRL @Space@ was used to change the identifier


            }
        }
        return CameraId;
    }
}