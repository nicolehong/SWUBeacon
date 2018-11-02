package org.androidtown.beaflexlistview;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    View dialogView;
    Button mainSetting;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //splash
        startActivity(new Intent(this, SplashActivity.class));

        mainSetting = (Button) findViewById(R.id.mainSetting);
        mainSetting.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
        dialogView = (View) View.inflate(MainActivity.this,
                R.layout.inout_ex, null);

        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setView(dialogView);

        dlg.show();
    }});
        //mainActivity에서 In->Out textview 버튼
        TextView InToOut = (TextView) findViewById(R.id.InToOut);
        InToOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InActivity.class);
                startActivity(intent);

            }
        });

        //mainActivity에서 Out->In textview 버튼
        TextView OutToIn = (TextView) findViewById(R.id.OutToIn);
        OutToIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OutActivity.class);
                startActivity(intent);

            }
        });
    }

}