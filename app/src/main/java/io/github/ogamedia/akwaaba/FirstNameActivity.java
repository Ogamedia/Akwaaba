package io.github.ogamedia.akwaaba;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ogamedia on 4/29/15.
 */
public class FirstNameActivity extends Activity {
    TextView textView;
    TextView fade;
    EditText firstNameInput;
    String firstName ="";

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String KEY_NAME_FIRSTNAME = "";
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_name);
        anim();

    }

    private void anim() {
        textView = (TextView) findViewById(R.id.textView);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_medium);
        textView.startAnimation(anim);
    }

    public void FirstName(View view) {
        mSharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        firstNameInput = (EditText) findViewById(R.id.editName);
        firstName = firstNameInput.getText().toString().trim();

        editor.putString(KEY_NAME_FIRSTNAME, firstName);
        editor.commit();

        Intent twiNameIntent = new Intent(FirstNameActivity.this,TwiNameActivity.class);
        startActivity(twiNameIntent);
        finish();
    }
}
