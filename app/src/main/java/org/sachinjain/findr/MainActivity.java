package org.sachinjain.findr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mLostButton;
    private Button mFoundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLostButton = (Button)findViewById(R.id.lost_button);
        mFoundButton = (Button)findViewById(R.id.found_button);

        mLostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LostActivity.class);
                startActivity(intent);
            }
        });

        mFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FoundActivity.class);
                startActivity(intent);
            }
        });

    }
}
