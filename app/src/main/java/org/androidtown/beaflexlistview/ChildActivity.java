package org.androidtown.beaflexlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends Activity {

    public static final int REQUEST_CODE_SETT = 1002;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Button searchBackButton = (Button) findViewById(R.id.searchBackButton);
       // Button subSetting = (Button) findViewById(R.id.subSetting);


       /* subSetting.setOnClickListener(new View.OnClickListener() {
            public void onClick (View V) {
                Intent intent = new Intent(getBaseContext(), SettingActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SETT);
            }
        });
*/

        //onSettingButtonClicked
       /*searchBackButton.setOnClickListener(new View.OnClickListener() {
            publi void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", "mike");
                // 응답을 전달하고 이 액티비티를 종료합니다.
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });*/

    }
}