package com.example.samd.cci_profile_maker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);

        Profile profile = (Profile)getIntent().getExtras().getSerializable(createProfile.PROFILE_KEY);
        TextView profileNameDyn = (TextView) findViewById(R.id.profileNameDyn);
        TextView profileEmailDyn = (TextView) findViewById(R.id.profileEmailDyn);
        TextView profileDepartDyn = (TextView) findViewById(R.id.profileDepartDyn);
        TextView profileMood = (TextView)findViewById(R.id.profileMood);
        ImageView moodImageDyn = (ImageView)findViewById(R.id.moodImgDyn);
        ImageView avatarImgDyn = (ImageView)findViewById(R.id.avatarImgDyn);

        profileNameDyn.setText(profile.getName());
        profileEmailDyn.setText(profile.getEmail());
        profileDepartDyn.setText(profile.getDepartment());

        Log.d("demo", "mood "+profile.getMood());
        Log.d("demo", "mood "+profile.getAvatar());

        switch (profile.getMood()) {
            case 0:
                moodImageDyn.setImageResource(R.drawable.angry);
                profileMood.setText(R.string.profileAngry);
                break;
            case 1:
                moodImageDyn.setImageResource(R.drawable.sad);
                profileMood.setText(R.string.profileSad);
                break;
            case 2:
                moodImageDyn.setImageResource(R.drawable.happy);
                profileMood.setText(R.string.profileHappy);
                break;
            case 3:
                moodImageDyn.setImageResource(R.drawable.awesome);
                profileMood.setText(R.string.profileAwesome);
                break;
        }



    }
}

