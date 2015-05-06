package io.github.ogamedia.akwaaba;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;


import java.util.Calendar;
import java.util.Date;

/**
 * Created by ogamedia on 4/28/15.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    String dayOfWeek;
    String nameReturner = "";
    String FILE_NAME = "hello_file.txt";

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String KEY_NAME_GENDER = "genderKey";

    SharedPreferences mSharedPreferences;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_MONTH);



        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Calendar c = Calendar.getInstance();
//        set new date
            c.set(year, month, day);
//        get the day of any particular
            int datea = c.get(Calendar.DAY_OF_WEEK);

            logger(datea);

            String DayName = dayName(datea);

            Intent welcomeIntent = new Intent(getActivity(), WelcomeActivity.class);
            welcomeIntent.putExtra("name", DayName);
            welcomeIntent.putExtra("date", datea);
            startActivity(welcomeIntent);
    }

    private String logger(int datea) {
        String dow = String.valueOf(datea);
        Log.v("fragment?", dow);
        return dow;
    }

    private String dayName(int datea) {
        boolean checked = true;

        mSharedPreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String gender = mSharedPreferences.getString(KEY_NAME_GENDER, "");
        Log.d("GENDER", gender);

        if (gender.equals("male")){
            String m = maleNames(datea);
            nameReturner = m;
        } else {
            if (gender.equals("female")) {
                String f = femaleNames(datea);
                nameReturner = f;
            }
        }

        return nameReturner;
    }

    private String maleNames(int weekDay) {
        switch (weekDay) {
            case 1:
                dayOfWeek = "Kwasi";
                break;

            case 2:
                dayOfWeek = "Kojo";
                break;

            case 3:
                dayOfWeek = "Kobby";
                break;

            case 4:
                dayOfWeek = "Kwaku";
                break;

            case 5:
                dayOfWeek = "Yaw";
                break;

            case 6:
                dayOfWeek = "Kofi";
                break;

            case 7:
                dayOfWeek = "Kwame";
                break;

            case 0:
                dayOfWeek = "Kwasi";
                break;
            default:
                dayOfWeek = "barima";
                break;
        }
        return dayOfWeek;
    }

    private String femaleNames(int weekDay) {
        switch (weekDay) {
            case 1:
                dayOfWeek = "Akosua";
                break;

            case 2:
                dayOfWeek = "Adjoa";
                break;

            case 3:
                dayOfWeek = "Abena";
                break;

            case 4:
                dayOfWeek = "Akua";
                break;

            case 5:
                dayOfWeek = "Yaa";
                break;

            case 6:
                dayOfWeek = "Afia";
                break;

            case 7:
                dayOfWeek = "Ama";
                break;

            case 0:
                dayOfWeek = "Akosua";
                break;

            default:
                dayOfWeek = "obaa";
        }
        return dayOfWeek;
    }
}
