package org.sachinjain.findr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class LostActivity extends AppCompatActivity {

    private EditText mNameText;
    private EditText mLocationText;
    private EditText mItemText;
    private EditText mRewardText;
    private EditText mDescriptionText;
    private EditText mContactText;
    private Button mPostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        mNameText = (EditText)findViewById(R.id.name);
        mLocationText = (EditText)findViewById(R.id.location);
        mItemText = (EditText)findViewById(R.id.item);
        mRewardText = (EditText)findViewById(R.id.reward);
        mDescriptionText = (EditText)findViewById(R.id.description);
        mContactText = (EditText)findViewById(R.id.contact);
        mPostButton = (Button)findViewById(R.id.post_button);
        mPostButton.setText("POST");

        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference posts = database.getReference("posts");

                String name = mNameText.getText().toString();
                String location = mLocationText.getText().toString();
                String item = mItemText.getText().toString();
                String reward = mRewardText.getText().toString().substring(1);
                String description = mDescriptionText.getText().toString();
                String contact = mContactText.getText().toString().replaceAll("[^0-9]","");

                if (TextUtils.isEmpty(name)){
                    mNameText.setError("Required");
                    return;
                }

                if (TextUtils.isEmpty(location)){
                    mLocationText.setError("Required");
                    return;
                }

                if (TextUtils.isEmpty(item)){
                    mItemText.setError("Required");
                    return;
                }

                if (TextUtils.isEmpty(reward)){
                    mRewardText.setError("Required");
                    return;
                }

                if (TextUtils.isEmpty(contact)){
                    mContactText.setError("Required");
                    return;
                }

                Post post = new Post(name, location, item, reward, description, contact);
                posts.push().setValue(post);

                mPostButton.setText("POSTED");

                final Intent intent = new Intent(v.getContext(), MainActivity.class);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 750);

            }
        });

    }
}
