package org.androidtown.beaflexlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;


public class SearchBeaconActivity extends Activity implements View.OnClickListener  {

    private final String TAG = MainActivity.class.getSimpleName();

    private Button textScanBeacon;

    boolean isBackGroundServiceBound = false;
    private Messenger messengerToService = null;
    private Messenger messengerFromService = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon);

        initUI();
        initClass();
        initService();

    }

    protected void onDestroy() {
        doUnbindService();
        super.onDestroy();
    }

    private void initUI() {
        textScanBeacon = (Button) findViewById(R.id.scanBeacon);

        textScanBeacon.setOnClickListener(this);
    }

    private void initClass() {
        messengerFromService = new Messenger(new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                handleMessageMainActivity(msg);
                return false;
            }
        }));
    }

    private void initService() {
        doBindService();
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            messengerToService = new Messenger(service);
            if (messengerToService != null) {
                try {
                    Message msg = Message.obtain(null, BackgroundService.BACKGROUND_SERVICE_MSG_START_INIT);
                    msg.replyTo = messengerFromService;
                    messengerToService.send(msg);
                } catch (RemoteException e) {
                }
            }

        }

        public void onServiceDisconnected(ComponentName className) {
            messengerToService = null;
        }
    };

    private void doBindService() {
        bindService(new Intent(this, BackgroundService.class), mConnection, Context.BIND_AUTO_CREATE);
        isBackGroundServiceBound = true;
    }

    private void doUnbindService() {
        if (isBackGroundServiceBound) {
            if (messengerToService != null) {
                try {
                    Message msg = Message.obtain(null, BackgroundService.BACKGROUND_SERVICE_MSG_UNBIND);
                    msg.replyTo = messengerFromService;
                    messengerToService.send(msg);
                } catch (RemoteException e) {
                }
            }
            unbindService(mConnection);
            isBackGroundServiceBound = false;
        }
    }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.scanBeacon:
                startBackgroundScan();
                break;

                /*case R.id.btnStop:
                    stopBackgroundScan();
                    break;*/
        }

    }

    private void handleMessageMainActivity(Message msg) {
        switch (msg.what) {
            case BackgroundService.BACKGROUND_SERVICE_MSG_RESULT:

                String macAddress = "";
                String uuid = "";
                int major = 0;
                int minor = 0;
                int rssi = 0;

                Bundle b = msg.getData();
                if (b != null) {
                    macAddress = b.getString(BackgroundService.MSG_MAC_ADDRESS);
                    uuid = b.getString(BackgroundService.MSG_UUID);
                    major = b.getInt(BackgroundService.MSG_MAJOR);
                    minor = b.getInt(BackgroundService.MSG_MINOR);
                    rssi = b.getInt(BackgroundService.MSG_RSSI);

                }

                String logdata = String.format("[Result] mac: %s, uuid: %s, major: %d, minor: %d, rssi: %d", macAddress, uuid, major, minor, rssi);
                Log.d("TAG", logdata);

                break;
        }
    }

    private void startBackgroundScan() {
        Log.d(TAG, "startBackgroundScan()");
        if (isBackGroundServiceBound) {
            if (messengerToService != null) {
                try {
                    Message msg = Message.obtain(null, BackgroundService.BACKGROUND_SERVICE_MSG_START_SCAN);
                    msg.replyTo = messengerFromService;
                    messengerToService.send(msg);
                } catch (RemoteException e) {
                }
            }
        }
    }

    private void stopBackgroundScan() {
        Log.d(TAG, "stopBackgroundScan()");
        if (isBackGroundServiceBound) {
            if (messengerToService != null) {
                try {
                    Message msg = Message.obtain(null, BackgroundService.BACKGROUND_SERVICE_MSG_START_STOP);
                    msg.replyTo = messengerFromService;
                    messengerToService.send(msg);
                } catch (RemoteException e) {
                }
            }
        }
    }



}


