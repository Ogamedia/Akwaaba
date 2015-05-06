package io.github.ogamedia.akwaaba;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by ogamedia on 4/28/15.
 */
public class WelcomeActivity extends Activity {
    TextView nameTextView, nameTextView2;
    SharedPreferences mSharedPreferences;
    private MyView touchView;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String KEY_NAME_TWINAME = " ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        nameTextView = (TextView) findViewById(R.id.textView4);
        nameTextView2 = (TextView) findViewById(R.id.textView13);
        Button btn;

        mSharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();


        Intent intent = getIntent();
        String localName = intent.getStringExtra("name");

        nameTextView.setText(localName);
        anim();
        nameTextView2.setText("how about we get started " + localName);



        editor.putString(KEY_NAME_TWINAME, localName);
        editor.commit();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivity = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        }, 10000);



    }

    private void anim() {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        nameTextView.startAnimation(anim);
    }

    public void getStartedButton(View view) {
        Intent mainActivity = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
