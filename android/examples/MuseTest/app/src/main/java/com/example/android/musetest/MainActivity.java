package com.example.android.musetest;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.choosemuse.libmuse.Muse;
import com.choosemuse.libmuse.MuseConnectionListener;
import com.choosemuse.libmuse.MuseConnectionPacket;
import com.choosemuse.libmuse.MuseManagerAndroid;

import java.lang.ref.WeakReference;
import java.util.Timer;
import com.choosemuse.libmuse.MuseDataPacketType;
import java.lang.Runnable;
import android.widget.TextView;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer myTimer;
    private MuseManagerAndroid manager;
    TextView BPDisplay;
    private Muse muse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BPDisplay = (TextView)findViewById(R.id.text_view);

        manager = MuseManagerAndroid.getInstance();
        manager.setContext(this);

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                refreshBP();
            }

        }, 0, 100);

        WeakReference<MainActivity> weakActivity =
                new WeakReference<>(this);

        ConnectionListener connectionListener = new ConnectionListener(weakActivity);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            // We don't have the ACCESS_COARSE_LOCATION permission so create the dialogs asking
            // the user to grant us the permission.

            DialogInterface.OnClickListener buttonListener =
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which){
                            dialog.dismiss();
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                    0);
                        }
                    };

            // This is the context dialog which explains to the user the reason we are requesting
            // this permission.  When the user presses the positive (I Understand) button, the
            // standard Android permission dialog will be displayed (as defined in the button
            // listener above).
            AlertDialog introDialog = new AlertDialog.Builder(this)
                    .setTitle(R.string.permission_dialog_title)
                    .setMessage(R.string.permission_dialog_description)
                    .setPositiveButton(R.string.permission_dialog_understand, buttonListener)
                    .create();
            introDialog.show();
        }

    }

    public void refreshBP() {
        float debug = 6.3352f;
        String string;
        string = "Alpha: " + String.valueOf(MuseDataPacketType.ALPHA_ABSOLUTE);
        string = string + "\n" + "Beta: " + String.valueOf(MuseDataPacketType.BETA_ABSOLUTE);
        string = string + "\n" + "Theta: " + String.valueOf(MuseDataPacketType.THETA_ABSOLUTE);
        string = string + "\n" + "Delta: " + String.valueOf(MuseDataPacketType.DELTA_ABSOLUTE);
        string = string + "\n" + "Gamma: " + String.valueOf(MuseDataPacketType.GAMMA_ABSOLUTE);
        string = string + "\n" + "Debug: " + String.valueOf(debug);
        final String BP = string;


            runOnUiThread(new Runnable() {
                              public void run() {
                                  BPDisplay.setText(BP);
                              }
                          });
        };

    class ConnectionListener extends MuseConnectionListener {
        final WeakReference<MainActivity> activityRef;

        ConnectionListener(final WeakReference<MainActivity> activityRef) {
            this.activityRef = activityRef;
        }

        @Override
        public void receiveMuseConnectionPacket(final MuseConnectionPacket p, final Muse muse) {
            activityRef.get().receiveMuseConnectionPacket(p, muse);
        }
    }

}
