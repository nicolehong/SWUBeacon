package org.androidtown.beaflexlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class ConfActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         setContentView(R.layout.activity_conf);


        Button searchBeacon = (Button) findViewById(R.id.searchBeacon);
        Button subSetting = (Button) findViewById(R.id.subSetting);
        Button subExecute = (Button) findViewById(R.id.subExecute);
        Button backBtn = (Button) findViewById(R.id.searchBackButton);
        Button AddBtn = (Button) findViewById(R.id.AddBtn);


        searchBeacon.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        Intent intent = new Intent(getBaseContext(), SearchBeaconActivity.class);
                        startActivity(intent);


                    }
                });


        subSetting.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        Intent intent = new Intent(getBaseContext(), SearchBeaconActivity.class);
                        startActivity(intent);
                    }
                });

        subExecute.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(), SearchBeaconActivity.class);
                        startActivity(intent);
                    }
                });

        backBtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {Intent intent = new Intent(getBaseContext(), SearchBeaconActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
        AddBtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getBaseContext(), SearchBeaconActivity.class);
                        startActivity(intent);

                        //Setting으로 넘어가는 창을 만들어 와야한다.

                    }
                });
    }
}