package io.github.ogamedia.akwaaba;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



/**
 * Created by ogamedia on 4/28/15.
 */
public class TwiNameActivity extends Activity{

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String KEY_NAME_GENDER = "genderKey";
    public static final String KEY_NAME_FIRSTNAME = "";
    SharedPreferences mSharedPreferences;

    TextView textView;
    TextView textView2;
    TextView textView3;
    RadioGroup rg;
    Button btn;

    String gender = "hello";
    String firstName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twi_name);

        textView = (TextView) findViewById(R.id.textView6);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        btn = (Button) findViewById(R.id.button);

        mSharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        firstName = mSharedPreferences.getString("Hey, " + KEY_NAME_FIRSTNAME + ",", " ");
        textView.setText(firstName);
        anim();

    }

    private void anim() {

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_init);
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_medium);
        Animation anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_long);

        textView.startAnimation(anim);
        textView2.startAnimation(anim1);
        textView3.startAnimation(anim2);
        rg.startAnimation(anim3);
        btn.startAnimation(anim3);
    }


    public void onRadioButtonClicked(View view) {
        mSharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioMale:
                    gender ="male";
                    editor.putString(KEY_NAME_GENDER, gender);
                    editor.commit();
            break;

            case R.id.radioFemale:
                    gender ="female";
                    editor.putString(KEY_NAME_GENDER, gender);
                    editor.commit();
            break;
        }
    }

        public void showDatePickerDialog(View v) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getFragmentManager(), "datePicker");
        }
}
