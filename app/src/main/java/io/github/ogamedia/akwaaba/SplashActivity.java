package io.github.ogamedia.akwaaba;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by ogamedia on 4/28/15.
 */
public class SplashActivity extends Activity {
    SharedPreferences mSharedPreferences;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String KEY_NAME_TWINAME = " ";
    String twiName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mSharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                twiName = mSharedPreferences.getString(KEY_NAME_TWINAME,"");

                if (twiName.length() < 2) {
                    Intent onBoard = new Intent(SplashActivity.this,ValueProp.class);
                    startActivity(onBoard);
                }else {
                    Intent mainActivity = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                }
            }
        }, 3000);



    }
}
