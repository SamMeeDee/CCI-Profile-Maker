package com.example.samd.cci_profile_maker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class createProfile extends AppCompatActivity {

    final static int REQ_CODE=9999;
    final static String RESULT_KEY="result";
    final static String PROFILE_KEY = "PROFILE";
    int mood;
    int avatarImg;
    String name;
    String email;
    String department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        final ImageView moodImg = (ImageView)findViewById(R.id.moodImg);
        final TextView moodDyn = (TextView)findViewById(R.id.moodDyn);
        SeekBar moodInput = (SeekBar)findViewById(R.id.moodSeekBar);

        moodInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                mood = progress;
                switch (mood)
                {
                    case 0:
                        moodImg.setImageResource(R.drawable.angry);
                        moodDyn.setText(R.string.Angry);
                        break;
                    case 1:
                        moodImg.setImageResource(R.drawable.sad);
                        moodDyn.setText(R.string.sad);
                        break;
                    case 2:
                        moodImg.setImageResource(R.drawable.happy);
                        moodDyn.setText(R.string.happy);
                        break;
                    case 3:
                        moodImg.setImageResource(R.drawable.awesome);
                        moodDyn.setText(R.string.awesome);
                        break;
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void submitHandler (View view)
    {
        EditText nameInput = (EditText)findViewById(R.id.nameInput);
        EditText emailInput = (EditText)findViewById(R.id.emailInput);
        RadioGroup depInput = (RadioGroup)findViewById(R.id.radioGroup);

        name = nameInput.getText().toString();
        email = emailInput.getText().toString();

        if(depInput.getCheckedRadioButtonId()==R.id.sis){department="SIS";}
        else if(depInput.getCheckedRadioButtonId()==R.id.cs){department="CS";}
        else if(depInput.getCheckedRadioButtonId()==R.id.bio){department="BIO";}

        Intent intent = new Intent(getBaseContext(), DisplayProfile.class);
        Profile profile = new Profile(name, email, department, mood, avatarImg);

        intent.putExtra(PROFILE_KEY, profile);

        startActivity(intent);
    }

    public void avatarSelectHandler (View view)
    {
        ImageButton avatarButton = (ImageButton)findViewById(R.id.selectAvatar);
        Intent intent = new Intent(getBaseContext(), SelectAvatar.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE)
        {
            if (resultCode == RESULT_OK && data.getExtras().containsKey(RESULT_KEY))
            {
                ImageButton avatarButton = (ImageButton)findViewById(R.id.selectAvatar);
                switch (data.getExtras().getInt(RESULT_KEY))
                {
                    case 1:
                        avatarButton.setImageResource(R.drawable.avatar_f_1);
                        break;
                    case 2:
                        avatarButton.setImageResource(R.drawable.avatar_f_2);
                        break;
                    case 3:
                        avatarButton.setImageResource(R.drawable.avatar_f_3);
                        break;
                    case 4:
                        avatarButton.setImageResource(R.drawable.avatar_m_1);
                        break;
                    case 5:
                        avatarButton.setImageResource(R.drawable.avatar_m_2);
                        break;
                    case 6:
                        avatarButton.setImageResource(R.drawable.avatar_m_3);
                        break;
                }
            }
        }
    }

}

