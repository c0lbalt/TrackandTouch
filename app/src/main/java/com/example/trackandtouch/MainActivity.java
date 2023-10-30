package com.example.trackandtouch;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = (ConstraintLayout)  findViewById(R.id.main_layout);

        Thread touchThread = new Thread(new Runnable() {

            @Override
            public void run() {
                myLayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        Log.i("TouchEvents", "Touch is Detected");

                        int eventType = motionEvent.getActionMasked();

                        switch (eventType)
                        {
                            case MotionEvent.ACTION_DOWN:
                                Log.i("touchEvents", "Action Down ");
                                break;

                            case MotionEvent.ACTION_POINTER_DOWN:
                                Log.i("touchEvents", "Action Pointer Down " + motionEvent.getPointerCount());
                                break;

                            case MotionEvent.ACTION_UP:
                                Log.i("touchEvents", "Action Up ");
                                break;

                            case MotionEvent.ACTION_POINTER_UP:
                                Log.i("touchEvents", "Action Pointer Up " + motionEvent.getPointerCount());
                                break;

                            case MotionEvent.ACTION_MOVE:
                                Log.i("touchEvents", "Action Move ");
                                break;

                            case MotionEvent.ACTION_BUTTON_PRESS:
                                Log.i("touchButton", "Button Pressed");
                                break;
                        }

                        return true;
            }
        });



            }
        });

        touchThread.start();

        // Find the button by its ID
        Button myButton = findViewById(R.id.myButton);

        // Set an OnClickListener for the button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                showToast("You pressed Toast!");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}