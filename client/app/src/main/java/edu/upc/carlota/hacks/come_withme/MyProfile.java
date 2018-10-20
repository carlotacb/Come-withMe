package edu.upc.carlota.hacks.come_withme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {

    private ImageView profilePic;
    private TextView bio, username;
    private Button btnEditProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        //profilePic = (ImageView) findViewById(R.id.profilePic);
        //bio = (TextView) findViewById(R.id.bio);

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyProfile.this, EditProfile.class));
            }
        });
    }
}
