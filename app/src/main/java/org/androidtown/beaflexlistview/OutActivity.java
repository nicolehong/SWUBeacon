package org.androidtown.beaflexlistview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OutActivity extends Activity {


    View dialogView;
    TextView btn1;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_in);
        Intent intent = new Intent(getIntent());

        btn1 = (TextView) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogView = (View) View.inflate(OutActivity.this,
                        R.layout.dial_btn1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(OutActivity.this);
                dlg.setView(dialogView);

                dlg.show();

            }

        });

        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Button Search = (Button) findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OutActivity.this, SearchBeaconActivity.class);
                startActivity(intent);
            }
        });

       Button Setting = (Button) findViewById(R.id.Setting);
        Setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OutActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });


    }
}












