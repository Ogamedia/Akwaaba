package io.github.ogamedia.akwaaba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by ogamedia on 5/3/15.
 */
public class Caller {
    private String mPhoneNumber = "000";

    public Caller(Context context, String phoneNumber){
        mPhoneNumber = phoneNumber;

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+mPhoneNumber));
        context.startActivity(callIntent);
    }
}
