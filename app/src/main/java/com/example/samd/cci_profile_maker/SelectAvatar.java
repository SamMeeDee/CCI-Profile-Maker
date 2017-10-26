package com.example.samd.cci_profile_maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectAvatar extends AppCompatActivity {

    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
    }

    public void buttonHandler (View view)
    {
        ImageButton input = (ImageButton)findViewById(view.getId());
        switch(input.getId())
        {
            case R.id.girl1:
                img = 1;
                break;
            case R.id.girl2:
                img = 2;
                break;
            case R.id.girl3:
                img = 3;
                break;
            case R.id.guy1:
                img = 4;
                break;
            case R.id.guy2:
                img = 5;
                break;
            case R.id.guy3:
                img = 6;
                break;
        }

        Intent intent = new Intent();
        intent.putExtra(createProfile.RESULT_KEY, img);
        setResult(RESULT_OK, intent);
        finish();
    }
}
