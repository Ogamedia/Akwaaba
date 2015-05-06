package io.github.ogamedia.akwaaba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ogamedia on 4/29/15.
 */
public class ValueProp extends Activity{
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_prop);
//        anim();
    }

    private void anim() {
        textView = (TextView) findViewById(R.id.textView);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        textView.startAnimation(anim);
    }
    public void NextButton(View view) {
        Intent firstNameIntent = new Intent(ValueProp.this, FirstNameActivity.class);
        startActivity(firstNameIntent);
        finish();
    }
}
